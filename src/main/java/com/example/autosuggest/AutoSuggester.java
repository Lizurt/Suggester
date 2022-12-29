package com.example.autosuggest;

import java.util.*;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.commons.lang3.NotImplementedException;

public class AutoSuggester {
    private final ParserWrapper parserWrapper;
    private final LexerWrapper lexerWrapper;
    private final String input;
    private final Set<String> collectedSuggestions = new HashSet<>();

    private List<? extends Token> inputTokens;
    private String textToAutocomplete = "";
    private CasePreference casePreference = CasePreference.BOTH;

    // "last time i met this <ATNState> when was processing the argument at <Integer> index"
    // private Map<ATNState, Integer> parserStateToTokenListIndexWhereLastVisited = new HashMap<>();

    public static int START_RULE_PARSER_STATE_INDEX = 0;

    // region init stuff

    public AutoSuggester(LexerAndParserFactory lexerAndParserFactory, String input) {
        this.lexerWrapper = new LexerWrapper(lexerAndParserFactory);
        this.parserWrapper = new ParserWrapper(lexerAndParserFactory, lexerWrapper.getVocabulary());
        this.input = input;
        tokenizeInput();
    }

    public void setCasePreference(CasePreference casePreference) {
        this.casePreference = casePreference;
    }

    private void tokenizeInput() {
        LexerWrapper.TokenizationResult tokenizationResult = lexerWrapper.tokenizeNonDefaultChannel(this.input);
        this.inputTokens = tokenizationResult.tokens;
        this.textToAutocomplete = tokenizationResult.untokenizedText;
    }

    // endregion

    // "hello i generate (and return) suggestions into my own class depending on input which is also in my class"
    public Collection<String> suggestCompletions() {
        ATNState initialState = this.parserWrapper.getAtnState(START_RULE_PARSER_STATE_INDEX);
        parseAndCollectTokenSuggestions(initialState, 0);
        return collectedSuggestions;
    }

    // "hello i generate suggestions into my own class when reach the untokenized text. But until i reach the text,
    // i try to find the last <parserState> (recursively) to generate suggestions for, depending on the generated
    // tokens"
    private void parseAndCollectTokenSuggestions(ATNState parserState, int tokenListIndex) {
        // todo: check if this can be removed cuz i don't see why we should use this
/*
        if (isParserStateVisitedOnThisTokenIndex(parserState, tokenListIndex)) {
            return;
        }
        Integer previousTokenListIndexForThisState = setParserStateLastVisitedOnThisTokenIndex(parserState, tokenListIndex);
*/
        if (tokenListIndex >= inputTokens.size()) {
            System.out.println("Out of tokens, starting generating suggestions");
            suggestAutocompletionsForParserState(parserState);
            return;
        }
        System.out.println("Total transitions for lexer state " + parserState.stateNumber + " is " + parserState.getNumberOfTransitions());
        for (Transition trans : parserState.getTransitions()) {
            handleTransition(trans, tokenListIndex, parserState);
        }
  //      setParserStateLastVisitedOnThisTokenIndex(parserState, previousTokenListIndexForThisState);
    }
/*
    private boolean isParserStateVisitedOnThisTokenIndex(ATNState parserState, Integer currentTokenListIndex) {
        Integer lastVisitedThisStateAtTokenListIndex = parserStateToTokenListIndexWhereLastVisited.get(parserState);
        return currentTokenListIndex.equals(lastVisitedThisStateAtTokenListIndex);
    }

    private Integer setParserStateLastVisitedOnThisTokenIndex(ATNState parserState, Integer tokenListIndex) {
        if (tokenListIndex == null) {
            if (false) {
                // todo: yes it is possible somehow. i'll check how later
                throw new RuntimeException("uhm erm...");
            }
            return parserStateToTokenListIndexWhereLastVisited.remove(parserState);
        } else {
            return parserStateToTokenListIndexWhereLastVisited.put(parserState, tokenListIndex);
        }
    }
*/

    // region transition handlers

    private void handleTransition(Transition transition, int tokenListIndex, ATNState parserState) {
        if (transition instanceof ActionTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof AtomTransition) {
            System.out.println("  Transition " + parserState.stateNumber + " -> " + transition.target.stateNumber + " is Atom");
            handleAtomTransition((AtomTransition) transition, tokenListIndex);
        } else if (transition instanceof EpsilonTransition) {
            System.out.println("  Transition " + parserState.stateNumber + " -> " + transition.target.stateNumber + " is Epsilon");
            handleEpsilonTransition(transition, tokenListIndex);
        } else if (transition instanceof NotSetTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof PrecedencePredicateTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof PredicateTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof RangeTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof RuleTransition) {
            throw new NotImplementedException();
        } else if (transition instanceof SetTransition) {
            System.out.println("  Transition " + parserState.stateNumber + " -> " + transition.target.stateNumber + " is Set");
            handleSetTransition((SetTransition) transition, tokenListIndex);
        } else if (transition instanceof WildcardTransition) {
            throw new NotImplementedException();
        }
    }

    private void handleEpsilonTransition(Transition trans, int tokenListIndex) {
        System.out.println("    Skipping epsilon transition");
        // Epsilon transitions don't consume a token, so don't move the index
        parseAndCollectTokenSuggestions(trans.target, tokenListIndex);
    }

    private void handleAtomTransition(AtomTransition trans, int tokenListIndex) {
        System.out.println("    Atom transition referencing " + trans.label + " lexer rule");
        Token nextToken = inputTokens.get(tokenListIndex);
        int nextTokenType = inputTokens.get(tokenListIndex).getType();
        boolean nextTokenMatchesTransition = (trans.label == nextTokenType);
        if (nextTokenMatchesTransition) {
            System.out.println("      Next token matches transition");
            parseAndCollectTokenSuggestions(trans.target, tokenListIndex + 1);
        } else {
            System.out.println("      Next token doesn't match transition");
        }
    }

    private void handleSetTransition(SetTransition trans, int tokenListIndex) {
        System.out.println("    Set transition referencing " + Arrays.toString(trans.set.toArray()) + " lexer rules");
        Token nextToken = inputTokens.get(tokenListIndex);
        int nextTokenType = nextToken.getType();
        for (int transitionTokenType : trans.label().toList()) {
            boolean nextTokenMatchesTransition = (transitionTokenType == nextTokenType);
            if (nextTokenMatchesTransition) {
                parseAndCollectTokenSuggestions(trans.target, tokenListIndex + 1);
            } else {
            }
        }
    }

    // endregion

    // "hello i can generate and add suggestions based on the given parser state (i.e. what words can be after
    // the last tokenized one)"
    private void suggestAutocompletionsForParserState(ATNState parserState) {
        Set<Integer> transitionLabels = new HashSet<>();
        fillParserTransitionLabels(parserState, transitionLabels, new HashSet<>());
        System.out.println("Parser state " + parserState.stateNumber + " referencing these rules: "
                + Arrays.toString(transitionLabels.toArray()));
        LexerTokensSuggester lexerTokensSuggester = new LexerTokensSuggester(this.textToAutocomplete, lexerWrapper, this.casePreference);
        Collection<String> suggestions = lexerTokensSuggester.suggestViaLexerState(transitionLabels);
        parseSuggestionsAndAddValidOnes(parserState, suggestions);
    }

    private void fillParserTransitionLabels(ATNState parserState, Collection<Integer> result, Set<TransitionWrapper> visitedTransitions) {
        for (Transition trans : parserState.getTransitions()) {
            TransitionWrapper transWrapper = new TransitionWrapper(parserState, trans);
            if (visitedTransitions.contains(transWrapper)) {
                continue;
            }
            if (trans.isEpsilon()) {
                try {
                    visitedTransitions.add(transWrapper);
                    fillParserTransitionLabels(trans.target, result, visitedTransitions);
                } finally {
                    visitedTransitions.remove(transWrapper);
                }
            } else if (trans instanceof AtomTransition) {
                int label = ((AtomTransition) trans).label;
                if (label >= 1) { // EOF would be -1
                    result.add(label);
                }
            } else if (trans instanceof SetTransition) {
                for (Interval interval : ((SetTransition) trans).label().getIntervals()) {
                    for (int i = interval.a; i <= interval.b; ++i) {
                        result.add(i);
                    }
                }
            }
        }
    }

    // "hello i suggest <suggestions> for the <parserState> as autocompletions for the untokenized text and then add them
    //  to the suggestions list in the AutoSuggester class"
    private void parseSuggestionsAndAddValidOnes(ATNState parserState, Collection<String> suggestions) {
        for (String suggestion : suggestions) {
            Token addedToken = getAddedToken(suggestion);
            if (isParseableWithAddedToken(parserState, addedToken, new HashSet<TransitionWrapper>())) {
                collectedSuggestions.add(suggestion);
            }
        }
    }

    // "hello i add the suggestion to the input text, generate tokens once again and return the last one, if it's a new one"
    private Token getAddedToken(String suggestedCompletion) {
        String completedText = this.input + suggestedCompletion;
        List<? extends Token> completedTextTokens = this.lexerWrapper.tokenizeNonDefaultChannel(completedText).tokens;
        if (completedTextTokens.size() <= inputTokens.size()) {
            return null; // Completion didn't yield whole token, could be just a token fragment
        }
        Token newToken = completedTextTokens.get(completedTextTokens.size() - 1);
        return newToken;
    }

    // "hello i check if the <newToken> is appropriate for the transitions of the <parserState> (i. e. can it be the next token)"
    private boolean isParseableWithAddedToken(ATNState parserState, Token newToken, Set<TransitionWrapper> visitedTransitions) {
        if (newToken == null) {
            // nope, null tokens will definitely not fit the parser state and its transitions
            return false;
        }
        for (Transition parserTransition : parserState.getTransitions()) {
            if (parserTransition.isEpsilon()) {
                TransitionWrapper transWrapper = new TransitionWrapper(parserState, parserTransition);
                if (visitedTransitions.contains(transWrapper)) {
                    // nah, we already checked this transition somewhere, skipping
                    continue;
                }
                visitedTransitions.add(transWrapper);
                // epsilon transition doesn't contain any useful info but a next parser state, so we skip all epsilon
                // transitions and let next transitions (after this one's target state) decide what we will return
                System.out.println("      Skipping epsilon transition");
                if (isParseableWithAddedToken(parserTransition.target, newToken, visitedTransitions)) {
                    return true;
                }
                visitedTransitions.remove(transWrapper);
            } else if (parserTransition instanceof AtomTransition) {
                AtomTransition parserAtomTransition = (AtomTransition) parserTransition;
                int transitionTokenType = parserAtomTransition.label;
                System.out.println("      Checking atom transition");
                if (transitionTokenType == newToken.getType()) {
                    System.out.println("        Atom transition(" + parserAtomTransition + ") fits the new token(" + newToken + ")");
                    // yep, that token can be the next one according to the <parserState> and its transitions
                    return true;
                }
                System.out.println("        Atom transition(" + parserAtomTransition + ") DOES NOT fit the new token(" + newToken + ")");
            } else if (parserTransition instanceof SetTransition) {
                SetTransition parserSetTransition = (SetTransition) parserTransition;
                // set transition's just a short way to save multiple atom transitions, so we just check all its values
                System.out.println("      Checking set transition");
                for (int transitionTokenType : parserSetTransition.label().toList()) {
                    if (transitionTokenType == newToken.getType()) {
                        System.out.println("        Set transition(" + parserSetTransition + ") fits the new token(" + newToken + ")");
                        // yep, that token can be the next one according to the <parserState> and its transitions
                        return true;
                    }
                }
                System.out.println("        Set transition(" + parserSetTransition + ") DOES NOT fit the new token(" + newToken + ")");
            } else {
                throw new IllegalStateException("Unexpected: " + parserWrapper.toString(parserTransition));
            }
        }
        // we've checked all the transitions and couldn't find any that fits the <newToken>, so return false
        return false;
    }


}
