package com.example.suggester;

import java.util.*;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.apache.commons.lang3.NotImplementedException;

public class AutoSuggester {
    private final ParserWrapper parserWrapper;

    private final LexerWrapper lexerWrapper;

    @Getter
    @Setter
    private CasePreference casePreference = CasePreference.LAST_MET;

    public static int START_RULE_PARSER_STATE_INDEX = 0;

    private final TransitionAnalyser transitionAnalyser = new TransitionAnalyser();

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
                TransitionAnalyseResult transitionAnalyseResult = transitionAnalyser.analyseTransition(
                        transition,
                        currParserState.getAtnState(),
                        tokens,
                        currParserState.getTokenIndex()
                );
                if (transitionAnalyseResult.isTokenMatchingPattern()) {
                    if (transitionAnalyseResult.isSupposedToConsumeToken()) {
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
        // at which char in a user input we'll be checking if a new suggested char is already in the user input
        int atInputPos = 0;
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        statesLoop:
        while (!lexerStatesToCheck.isEmpty()) {
            ATNState lexerState = lexerStatesToCheck.poll();
            if (lexerState instanceof RuleStopState) {
                if (suggestableRulesStopStates.contains(lexerState)) {
                    if (!sbCurrSuggestion.isEmpty()) {
                        fullSuggestions.add(sbCurrSuggestion.toString());
                    }
                    sbCurrSuggestion.setLength(0);
                    atInputPos = 0;
                }
                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            for (int i = lexerState.getNumberOfTransitions() - 1; i >= 0; i--) {
                Transition transition = lexerState.transition(i);
                TransitionAnalyseResult transitionAnalyseResult = transitionAnalyser.analyseTransition(
                        transition,
                        lexerState
                );
                lexerStatesToCheck.addFirst(transitionAnalyseResult.getTargetState());
                if (transitionAnalyseResult.getOtherRuleReference() != null) {
                    lexerStatesToCheck.addFirst(transitionAnalyseResult.getOtherRuleReference());
                } else if (transitionAnalyseResult.getParserToLexerRuleNumbersOrLexerCharInts() != null) {
                    IntervalSet charIntervalSet = transitionAnalyseResult.getParserToLexerRuleNumbersOrLexerCharInts();
                    Character newCharForSuggestion = getCharForSuggestion(charIntervalSet);
                    InputAndSuggestionCompareResult inputAndSuggestionCompareResult = compareInputAndSuggestion(
                            tokenizationResult.untokenizedText,
                            atInputPos,
                            newCharForSuggestion
                    );
                    switch (inputAndSuggestionCompareResult) {
                        case INAPPROPRIATE_SUGGESTION -> {
                            sbCurrSuggestion.setLength(0);
                            atInputPos = 0;
                            continue statesLoop;
                        }
                        case APPROPRIATE_SUGGESTION -> {
                            sbCurrSuggestion.append(newCharForSuggestion);
                        }
                        case SUGGESTION_ALREADY_IN_INPUT -> {
                            atInputPos++;
                        }
                        default -> throw new NotImplementedException("Unknown input and suggestion compare result");
                    }
                }
            }
        }

        return fullSuggestions;
    }

    private InputAndSuggestionCompareResult compareInputAndSuggestion(
            String userInput,
            int atInputPos,
            Character suggestedChar
    ) {
        if (userInput == null || userInput.length() <= atInputPos) {
            return InputAndSuggestionCompareResult.APPROPRIATE_SUGGESTION;
        }
        if (Character.toLowerCase(userInput.charAt(atInputPos)) == Character.toLowerCase(suggestedChar)) {
            return InputAndSuggestionCompareResult.SUGGESTION_ALREADY_IN_INPUT;
        }
        return InputAndSuggestionCompareResult.INAPPROPRIATE_SUGGESTION;
    }

    private Character getCharForSuggestion(IntervalSet availableCharsIntervals) {
        if (availableCharsIntervals.size() <= 0) {
            return null;
        }
        Character result = null;
        switch (casePreference) {
            case FIRST_MET -> {
                result = Character.toChars(
                        availableCharsIntervals.getIntervals().get(0).a
                )[0];
            }
            case LAST_MET -> {
                result = Character.toChars(
                        availableCharsIntervals.getIntervals().get(availableCharsIntervals.size() - 1).b
                )[0];
            }
            case LOWER -> {
                for (Interval interval : availableCharsIntervals.getIntervals()) {
                    for (int val = interval.a; val <= interval.b; val++) {
                        if (Character.isLowerCase(val)) {
                            result = Character.toChars(val)[0];
                        }
                    }
                }
            }
            case UPPER -> {
                for (Interval interval : availableCharsIntervals.getIntervals()) {
                    for (int val = interval.a; val <= interval.b; val++) {
                        if (Character.isUpperCase(val)) {
                            result = Character.toChars(val)[0];
                        }
                    }
                }
            }
        }
        return result;
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
                TransitionAnalyseResult transitionAnalyseResult = transitionAnalyser.analyseTransition(
                        transition,
                        currParserState
                );
                if (transitionAnalyseResult.isSupposedToConsumeToken()) {
                    // ladies and gentlemen we got em
                    closestTokenConsumingTransitions.add(transition);
                } else if (transitionAnalyseResult.getOtherRuleReference() != null) {
                    // it references other rule states, we might get a proper state there!
                    parserStatesToCheck.addFirst(transitionAnalyseResult.getOtherRuleReference());
                } else {
                    // bruh, keep exploring the ATN branch then
                    parserStatesToCheck.addFirst(transition.target);
                }
            }
        }

        return closestTokenConsumingTransitions;
    }
}
