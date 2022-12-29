package com.example.autosuggest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.antlr.v4.runtime.atn.*;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Given an ATN state and the lexer ATN, suggests auto-completion texts.
 */
class LexerTokensSuggester {
    private final LexerWrapper lexerWrapper;
    private final CasePreference casePreference;

    private final Set<String> suggestions = new TreeSet<>();
    //private final List<Integer> visitedLexerStates = new ArrayList<>();
    private final String origUntokenizedText;

    public LexerTokensSuggester(LexerWrapper lexerWrapper, String input) {
        this(input, lexerWrapper, CasePreference.BOTH);
    }

    public LexerTokensSuggester(String origUntokenizedText, LexerWrapper lexerWrapper, CasePreference casePreference) {
        this.origUntokenizedText = origUntokenizedText;
        this.lexerWrapper = lexerWrapper;
        this.casePreference = casePreference;
    }

    // region suggest viaers

    public Collection<String> suggestViaLexerState(Collection<Integer> nextParserTransitionLabels) {
        return suggestViaLexerState(nextParserTransitionLabels, 0);
    }

    // "hello i return every suggestion available for these transition labels referencing lexer rules"
    // rule nesting level helps with return a result. We return result only if we've reached RuleStopState, but
    // we shouldn't return it if the RuleStopState is inner rule's stop state. So if the level is 0, that means
    // we're in the rule that we asked suggestions for, not in its inner rules
    private Collection<String> suggestViaLexerState(
            Collection<Integer> nextParserTransitionLabels,
            int ruleNestingLevel
    ) {
        System.out.println("There are " + nextParserTransitionLabels.size() + " suggestable transition labels in total");
        for (int nextParserTransitionLabel : nextParserTransitionLabels) {
            int nextTokenRuleNumber = nextParserTransitionLabel - 1; // Count from 0 not from 1
            ATNState lexerState = this.lexerWrapper.findStateByRuleNumber(nextTokenRuleNumber);
            System.out.println("  Checking if " + lexerState.stateNumber + " lexer rule (state) is suggestable");
            suggestViaLexerState(
                    lexerState,
                    new UntokenizedTextState("", origUntokenizedText),
                    ruleNestingLevel
            );
        }
        return suggestions;
    }

    // "hello i try to find suggestions according to the given lexer state"
    private UntokenizedTextState suggestViaLexerState(
            ATNState lexerState,
            UntokenizedTextState untokenizedTextState,
            int ruleNestingLevel
    ) {
        // that should not affect the algorithm because we no longer use RuleStopState to reference other rules
        /*if (visitedLexerStates.contains(lexerState.stateNumber)) {
            System.out.println("  Already checked " + lexerState.stateNumber + " lexer state. Skipping");
            return untokenizedTextState; // avoid infinite loop and stack overflow
        }*/
        if (lexerState instanceof RuleStopState) {
            if (ruleNestingLevel > 0) {
                // no we're not gonna check transitions who just point to rules who use this rule
                return untokenizedTextState;
            }
            // alright seems this is it. Time to generate results
            int indexFrom = Math.min(untokenizedTextState.getCurrentTokenText().length(), origUntokenizedText.length());
            String justTheCompletionPart = untokenizedTextState.getCurrentTokenText().substring(indexFrom);
            suggestions.add(justTheCompletionPart);
            System.out.println("  Added \"" + justTheCompletionPart + "\" to the suggestions list because " +
                    "RuleStopState's reached");
            return untokenizedTextState;
        }
        //visitedLexerStates.add(lexerState.stateNumber);
        Transition[] transitions = lexerState.getTransitions();
        System.out.println("  There are " + transitions.length + " transitions available for " + lexerState.stateNumber +
                " lexer state");
        for (Transition trans : transitions) {
            untokenizedTextState = suggestViaLexerTransition(trans, untokenizedTextState, ruleNestingLevel);
        }
        //visitedLexerStates.remove(visitedLexerStates.size() - 1);
        return untokenizedTextState;
    }

    private String toString(ATNState lexerState) {
        String ruleName = this.lexerWrapper.getRuleNames()[lexerState.ruleIndex];
        return ruleName + " " + lexerState.getClass().getSimpleName() + " " + lexerState;
    }

    // "hello i try to find suggestions according to the given lexer transition"
    private UntokenizedTextState suggestViaLexerTransition(
            Transition transition,
            UntokenizedTextState untokenizedTextState,
            int ruleNestingLevel
    ) {
        if (transition instanceof ActionTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof AtomTransition atomTransition) {
            untokenizedTextState = handleAtomTransition(atomTransition, untokenizedTextState, ruleNestingLevel);
        } else if (transition instanceof EpsilonTransition epsilonTransition) {
            System.out.println("    Transition's Epsilon, skipping to its target state");
            untokenizedTextState = suggestViaLexerState(transition.target, untokenizedTextState, ruleNestingLevel);
        } else if (transition instanceof NotSetTransition notSetTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof PrecedencePredicateTransition predicateTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof PredicateTransition predicateTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof RangeTransition rangeTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof RuleTransition ruleTransition) {
            System.out.println("    Transition's Rule, checking the referenced rule instead");
            untokenizedTextState = handleRuleTransition(ruleTransition, untokenizedTextState, ruleNestingLevel);
        } else if (transition instanceof SetTransition setTransition) {
            untokenizedTextState = handleSetTransition(setTransition, untokenizedTextState, ruleNestingLevel);
        } else if (transition instanceof WildcardTransition) {
            throw new NotImplementedException();
        }
        return untokenizedTextState;
    }

    private UntokenizedTextState suggestViaTargetState(
            ATNState targetState,
            UntokenizedTextState untokenizedTextState,
            String newTokenChar,
            int ruleNestingLevel
    ) {
        UntokenizedTextState newUntokenizedTextState;
        if (untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText().length() > 0) {
            newUntokenizedTextState = new UntokenizedTextState(
                    untokenizedTextState.getCurrentTokenText() + newTokenChar,
                    untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText().substring(1)
            );
        } else {
            newUntokenizedTextState = new UntokenizedTextState(
                    untokenizedTextState.getCurrentTokenText() + newTokenChar,
                    untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText()
            );
        }
        return suggestViaLexerState(targetState, newUntokenizedTextState, ruleNestingLevel);
    }

    // endregion

    // region transition handlers

    private UntokenizedTextState handleRuleTransition(
            RuleTransition ruleTransition,
            UntokenizedTextState untokenizedTextState,
            int ruleNestingLevel
    ) {
        UntokenizedTextState newUntokenizedTextState = suggestViaLexerState(
                ruleTransition.target,
                untokenizedTextState,
                ruleNestingLevel + 1
        );
        return suggestViaLexerState(ruleTransition.followState, newUntokenizedTextState, ruleNestingLevel);
    }

    private UntokenizedTextState handleAtomTransition(
            AtomTransition atomTransition,
            UntokenizedTextState untokenizedTextState,
            int ruleNestingLevel
    ) {
        UntokenizedTextState newUntokenizedTextState = untokenizedTextState;
        String newTokenPart = transitionLabelToString(atomTransition.label);
        System.out.println("    Transition's Atom who suggests \"" + newTokenPart + "\" as a new token part");
        if (
                untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText().isEmpty()
                        || untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText().startsWith(newTokenPart)
        ) {
            System.out.println("      \"" + newTokenPart + "\" satisfies the remaining text: " +
                    untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText());
            newUntokenizedTextState = suggestViaTargetState(
                    atomTransition.target,
                    untokenizedTextState,
                    newTokenPart,
                    ruleNestingLevel
            );
        } else {
            System.out.println("      \"" + newTokenPart + "\" DOES NOT satisfy the remaining text: " +
                    untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText());
        }
        return newUntokenizedTextState;
    }

    private UntokenizedTextState handleSetTransition(
            SetTransition setTransition,
            UntokenizedTextState untokenizedTextState,
            int ruleNestingLevel
    ) {
        UntokenizedTextState newUntokenizedTextState = untokenizedTextState;
        List<Integer> labels = setTransition.label().toList();
        System.out.println("    Transition's Set who suggests " + labels.size() + " chars in total");
        for (Integer label : labels) {
            String newTokenPart = transitionLabelToString(label);
            boolean doesCharCaseSatisfyCasePreference = doesCharCaseSatisfyCasePreference(label, labels);
            if (doesCharCaseSatisfyCasePreference
                    &&
                    (
                            untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText().isEmpty()
                                    || untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText().startsWith(newTokenPart)
                    )
            ) {
                System.out.println("      \"" + newTokenPart + "\" satisfies the remaining text: \"" +
                        untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText() + "\" and char case's correct");
                return suggestViaTargetState(
                        setTransition.target,
                        untokenizedTextState,
                        newTokenPart,
                        ruleNestingLevel
                );
            } else {
                System.out.println("      \"" + newTokenPart + "\" DOES NOT satisfy the remaining text: \"" +
                        untokenizedTextState.getCurrentUnsuggestedTextFromUntokenizedText() + "\" or char case's wrong");
            }
        }
        return newUntokenizedTextState;
    }

    // endregion

    private String transitionLabelToString(int transitionLabel) {
        return new String(Character.toChars(transitionLabel));
    }

    private boolean doesCharCaseSatisfyCasePreference(int transChar, List<Integer> allTransChars) {
        if (this.casePreference == null) {
            // sure thing if there are no case preferences
            return true;
        }
        switch (this.casePreference) {
            case BOTH:
                // sure thing if case preferences don't care about char cases
                return true;
            case LOWER:
                return Character.isLowerCase(transChar) && allTransChars.contains(Character.toUpperCase(transChar));
            case UPPER:
                return Character.isUpperCase(transChar) && allTransChars.contains(Character.toLowerCase(transChar));
            default:
                return true;
        }
    }

}
