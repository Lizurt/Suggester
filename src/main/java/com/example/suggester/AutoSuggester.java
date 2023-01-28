package com.example.suggester;

import java.util.*;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;

public class AutoSuggester {
    private final ParserWrapper parserWrapper;

    private final LexerWrapper lexerWrapper;

    private CasePreference casePreference = CasePreference.BOTH;

    public static int START_RULE_PARSER_STATE_INDEX = 0;

    private TransitionHandler transitionHandler = new TransitionHandler();

    // region init stuff

    public AutoSuggester(LexerAndParserFactory lexerAndParserFactory) {
        this.lexerWrapper = new LexerWrapper(lexerAndParserFactory);
        this.parserWrapper = new ParserWrapper(lexerAndParserFactory);
    }

    private LexerWrapper.TokenizationResult tokenizeInput(String input) {
        return lexerWrapper.tokenizeNonDefaultChannel(input);
    }

    // endregion

    // "hello i generate (and return) suggestions into my own class depending on input which is also in my class"
    public List<String> generateAndGetSuggestions(String input) {
        LexerWrapper.TokenizationResult tokenizationResult = tokenizeInput(input);
        ATNState initialParserState = parserWrapper.getCachedParser().getATN().states.get(START_RULE_PARSER_STATE_INDEX);
        ParserStateWithTokenIndex greedestParserState = getGreediestParserState(
                initialParserState,
                tokenizationResult.tokens
        );
        return generateAndGetSuggestions(greedestParserState, tokenizationResult);
    }

    private ParserStateWithTokenIndex getGreediestParserState(final ATNState startParserState, final List<? extends Token> tokens) {
        // the state where we consumed maximum amount of available tokens.
        // If the state consumed all the tokens (tokens.len == index) we can generate suggestions
        ParserStateWithTokenIndex greediestParserState = new ParserStateWithTokenIndex(startParserState, 0);
        // no we're not gonna system.arraycopy each time we want to pop an element, so linkedlist instead of stack
        LinkedList<ParserStateWithTokenIndex> parserStatesToCheck = new LinkedList<>();
        parserStatesToCheck.addFirst(new ParserStateWithTokenIndex(startParserState, 0));
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        while (!parserStatesToCheck.isEmpty()) {
            ParserStateWithTokenIndex currParserState = parserStatesToCheck.poll();
            if (currParserState.getAtnState() instanceof RuleStopState) {
                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            if (currParserState.getTokenIndex() > greediestParserState.getTokenIndex()) {
                greediestParserState = currParserState;
            }
            for (int i = currParserState.getAtnState().getNumberOfTransitions() - 1; i >= 0; i--) {
                Transition transition = currParserState.getAtnState().transition(i);
                TransitionHandlerResult transitionHandlerResult = transitionHandler.handleTransition(
                        transition,
                        currParserState.getAtnState(),
                        tokens,
                        currParserState.getTokenIndex()
                );
                if (transitionHandlerResult.isTokenMatchingPattern()) {
                    if (transitionHandlerResult.isSupposedToConsumeToken()) {
                        parserStatesToCheck.addFirst(new ParserStateWithTokenIndex(
                                transition.target,
                                currParserState.getTokenIndex() + 1
                        ));
                    } else {
                        parserStatesToCheck.addFirst(new ParserStateWithTokenIndex(
                                transition.target,
                                currParserState.getTokenIndex()
                        ));
                    }
                }
            }
        }
        return greediestParserState;
    }

    // at this parser greediestState we try to generate suggestions based on tokenizationResult
    private List<String> generateAndGetSuggestions(
            ParserStateWithTokenIndex greediestState,
            LexerWrapper.TokenizationResult tokenizationResult
    ) {
        if (greediestState.getTokenIndex() < tokenizationResult.tokens.size()) {
            // oops seems the tokens don't fit in the parser rules
            return Collections.emptyList();
        }

        List<Transition> closestTokenConsumingTransitions = getClosestTokenConsumingTransitions(
                greediestState.getAtnState()
        );

        List<String> fullSuggestions = new ArrayList<>();
        // no we're not gonna system.arraycopy each time we want to pop an element, so linkedlist instead of stack
        LinkedList<ATNState> lexerStatesToCheck = new LinkedList<>();
        // we'll add a suggestion when will have reached one of these states, so we won't add incomplete suggestions,
        // e.g. "h" for "hello", we'll wait for full "hello" instead
        Set<ATNState> suggestableRulesStopStates = new HashSet<>();
        for (Transition transition : closestTokenConsumingTransitions) {
            for (Interval interval : transition.label().getIntervals()) {
                for (int val = interval.a; val <= interval.b; val++) {
                    RuleStartState lexerRuleToCheck = lexerWrapper.getRuleByItsType(val);
                    lexerStatesToCheck.addFirst(lexerRuleToCheck);
                    suggestableRulesStopStates.add(lexerRuleToCheck.stopState);
                }
            }
        }
        StringBuilder sbCurrSuggestion = new StringBuilder();
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        while (!lexerStatesToCheck.isEmpty()) {
            ATNState lexerState = lexerStatesToCheck.poll();
            if (lexerState instanceof RuleStopState) {
                if (suggestableRulesStopStates.contains(lexerState)) {
                    fullSuggestions.add(sbCurrSuggestion.toString());
                    sbCurrSuggestion.setLength(0);
                }
                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            for (int i = lexerState.getNumberOfTransitions() - 1; i >= 0; i--) {
                Transition transition = lexerState.transition(i);
                TransitionHandlerResult transitionHandlerResult = transitionHandler.handleTransition(
                        transition,
                        lexerState
                );
                lexerStatesToCheck.addFirst(transitionHandlerResult.getTargetState());
                if (transitionHandlerResult.getOtherRuleReference() != null) {
                    lexerStatesToCheck.addFirst(transitionHandlerResult.getOtherRuleReference());
                } else if (transitionHandlerResult.getParserToLexerRuleNumbersOrLexerCharInts() != null) {
                    // todo: case preferences; don't ignore user inputted text when generating suggestion
                    IntervalSet charIntervalSet = transitionHandlerResult.getParserToLexerRuleNumbersOrLexerCharInts();
                    char newCharForSuggestion = Character.toChars(charIntervalSet.getIntervals().get(0).a)[0];
                    sbCurrSuggestion.append(newCharForSuggestion);
                }
            }
        }

        return fullSuggestions;
    }

    private List<Transition> getClosestTokenConsumingTransitions(ATNState startParserState) {
        List<Transition> closestTokenConsumingTransitions = new ArrayList<>();
        // no we're not gonna system.arraycopy each time we want to pop an element, so linkedlist instead of stack
        LinkedList<ATNState> parserStatesToCheck = new LinkedList<>();
        parserStatesToCheck.addFirst(startParserState);
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        while (!parserStatesToCheck.isEmpty()) {
            ATNState currParserState = parserStatesToCheck.poll();
            if (currParserState instanceof RuleStopState) {
                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            for (int i = currParserState.getNumberOfTransitions() - 1; i >= 0; i--) {
                Transition transition = currParserState.transition(i);
                TransitionHandlerResult transitionHandlerResult = transitionHandler.handleTransition(
                        transition,
                        currParserState
                );
                if (transitionHandlerResult.isSupposedToConsumeToken()) {
                    // ladies and gentlemen we got em
                    closestTokenConsumingTransitions.add(transition);
                } else if (transitionHandlerResult.getOtherRuleReference() != null) {
                    // it references other rule states, we might get a proper state there!
                    parserStatesToCheck.addFirst(transitionHandlerResult.getOtherRuleReference());
                } else {
                    // bruh, keep exploring the ATN branch then
                    parserStatesToCheck.addFirst(transition.target);
                }
            }
        }

        return closestTokenConsumingTransitions;
    }
}
