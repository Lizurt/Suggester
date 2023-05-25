package com.lizurt.suggester;

import java.util.*;

import com.lizurt.suggester.factories.LexerAndParserFactory;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.apache.commons.lang3.NotImplementedException;

public class Suggester {
    private final Set<ATNState> bannedRules = new HashSet<>();

    private final ParserWrapper parserWrapper;

    private final LexerWrapper lexerWrapper;

    @Getter
    @Setter
    private CasePreference casePreference = CasePreference.LOWER;

    private final TransitionAnalyser transitionAnalyser = new TransitionAnalyser();

    private final ATNStateAnalyser atnStateAnalyser = new ATNStateAnalyser();

    // region init stuff

    public Suggester(LexerAndParserFactory lexerAndParserFactory) {
        this(new LexerWrapper(lexerAndParserFactory), new ParserWrapper(lexerAndParserFactory));
    }

    public Suggester(LexerAndParserFactory lexerAndParserFactory, Set<String> rawBannedStates) {
        this(
                new LexerWrapper(lexerAndParserFactory),
                new ParserWrapper(lexerAndParserFactory),
                rawBannedStates
        );
    }

    public Suggester(LexerWrapper lexerWrapper, ParserWrapper parserWrapper, Set<String> rawBannedStates) {
        Map<String, Integer> tokenTypeMap = lexerWrapper.getCachedLexer().getTokenTypeMap();
        for (String rawBannedState : rawBannedStates) {
            Integer tokenType = tokenTypeMap.get(rawBannedState);
            if (tokenType == null) {
                throw new IllegalArgumentException("The lexer rule \"" + rawBannedState + "\" doesn't exist for " +
                        "\"" + lexerWrapper.getCachedLexer() + "\".");
            }
            this.bannedRules.add(lexerWrapper.getRuleByItsType(tokenType));
        }
        this.lexerWrapper = lexerWrapper;
        this.parserWrapper = parserWrapper;
    }

    public Suggester(LexerWrapper lexerWrapper, ParserWrapper parserWrapper) {
        this(lexerWrapper, parserWrapper, new HashSet<>());
    }

    // endregion

    // "hello i generate (and return) suggestions into my own class depending on input which is also in my class"
    public List<String> generateAndGetSuggestions(String input) {
        List<? extends Token> tokens = lexerWrapper.tokenize(input);
        List<ATNState> initialParserStates = parserWrapper.getInitialAtnStates();
        List<String> suggestions = new ArrayList<>();
        for (ATNState initialState : initialParserStates) {
            DependableATNState greediestParserState = getGreediestParserState(
                    initialState,
                    tokens
            );
            suggestions.addAll(generateAndGetSuggestions(greediestParserState, tokens, input));
        }
        return suggestions;
    }

    private DependableATNState getGreediestParserState(
            ATNState startParserState,
            List<? extends Token> tokens
    ) {
        // the state where we consumed maximum amount of available tokens.
        // If the state consumed all the tokens (tokens.len == index) we can generate suggestions
        DependableATNState greediestParserState = new DependableATNState(
                startParserState,
                null,
                null,
                null,
                0,
                0,
                0,
                null
        );
        Stack<DependableATNState> parserStatesToCheck = new Stack<>();
        parserStatesToCheck.push(greediestParserState);
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        statesLoop:
        while (!parserStatesToCheck.isEmpty()) {
            DependableATNState currDependableATNState = parserStatesToCheck.pop();
            ATNState currParserState = currDependableATNState.getAtnState();
            if (currDependableATNState.getConsumedTokensAmt() == tokens.size()) {
                return currDependableATNState;
            }
            if (currDependableATNState.getConsumedTokensAmt() > greediestParserState.getConsumedTokensAmt()) {
                greediestParserState = currDependableATNState;
            }
            if (currParserState instanceof RuleStopState) {
                if (currDependableATNState.getCallerTransition() != null) {
                    // someone referenced this rule (probably via RuleTransition), we need to add its following state
                    // to the to-check list
                    parserStatesToCheck.push(new DependableATNState(
                            currDependableATNState.getCallerTransition().getFollowingState(),
                            currDependableATNState,
                            currDependableATNState.getCallerTransition().getSourceState().getCallerTransition(),
                            currDependableATNState.getSbSuggestion(),
                            currDependableATNState.getSuggestedCharsAmount(),
                            currDependableATNState.getSuggestingAtInputPos(),
                            currDependableATNState.getConsumedTokensAmt(),
                            null
                    ));
                }
                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            for (int i = currParserState.getNumberOfTransitions() - 1; i >= 0; i--) {
                int consumedTokensAmt = currDependableATNState.getConsumedTokensAmt();
                Transition transition = currParserState.transition(i);
                TransitionAnalyseResult transitionAnalyseResult = transitionAnalyser.analyseTransition(
                        transition,
                        currDependableATNState,
                        tokens,
                        consumedTokensAmt
                );
                if (!transitionAnalyseResult.isTokenMatchingPattern()) {
                    continue;
                }
                if (transitionAnalyseResult.isSupposedToConsumeToken()) {
                    consumedTokensAmt++;
                }
                if (transitionAnalyseResult.getOtherRuleReference() != null) {
                    DependableATNState referencedState = new DependableATNState(
                            transitionAnalyseResult.getOtherRuleReference(),
                            currDependableATNState,
                            transitionAnalyseResult,
                            null,
                            -1,
                            -1,
                            consumedTokensAmt,
                            null
                    );
                    parserStatesToCheck.push(referencedState);
                } else {
                    DependableATNState followingState = new DependableATNState(
                            transitionAnalyseResult.getFollowingState(),
                            currDependableATNState,
                            currDependableATNState.getCallerTransition(),
                            null,
                            -1,
                            -1,
                            consumedTokensAmt,
                            null
                    );
                    parserStatesToCheck.push(followingState);
                }
            }
        }
        return greediestParserState;
    }

    // at this parser greediestState we try to generate suggestions based on tokens
    private List<String> generateAndGetSuggestions(
            DependableATNState greediestState,
            List<? extends Token> tokens,
            String originalText
    ) {
        // it's raw because it can contain chars that should be skipped according to user's language rules
        String rawTextToComplete = originalText;
        if (greediestState.getConsumedTokensAmt() > 0) {
            rawTextToComplete = originalText.substring(
                    tokens.get(greediestState.getConsumedTokensAmt() - 1).getStopIndex() + 1
            );
        }
        String textToComplete = lexerWrapper.getAllNonSkippedChars(rawTextToComplete);
        List<String> suggestions = new ArrayList<>();
        Stack<DependableATNState> lexerStatesToCheck = new Stack<>();
        // we'll add a suggestion when will have reached one of these states, so we won't add incomplete suggestions,
        // e.g. "h" for "hello", we'll wait for full "hello" instead
        Set<ATNState> suggestableRulesStopStates = new HashSet<>();
        Set<Transition> closestTokenConsumingTransitions = getClosestTokenConsumingTransitions(
                greediestState
        );
        for (Transition transition : closestTokenConsumingTransitions) {
            for (Interval interval : transition.label().getIntervals()) {
                for (int val = interval.a; val <= interval.b; val++) {
                    if (val < 0) {
                        // EOF transitions have -1 as their label
                        continue;
                    }
                    RuleStartState lexerRuleToCheck = lexerWrapper.getRuleByItsType(val);
                    lexerStatesToCheck.push(new DependableATNState(
                            lexerRuleToCheck,
                            null,
                            null,
                            new StringBuilder(),
                            0,
                            0,
                            -1,
                            new HashSet<>()
                    ));
                    suggestableRulesStopStates.add(lexerRuleToCheck.stopState);
                }
            }
        }
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        statesLoop:
        while (!lexerStatesToCheck.isEmpty()) {
            DependableATNState currDependableATNState = lexerStatesToCheck.pop();
            ATNState currLexerState = currDependableATNState.getAtnState();
            StringBuilder sbCurrSuggestion = currDependableATNState.getSbSuggestion();
            if (bannedRules.contains(currLexerState)) {
                // no suggestions for unwanted rules (the ones that user define)
                continue;
            }
            if (currLexerState instanceof RuleStopState) {
                if (suggestableRulesStopStates.contains(currLexerState)) {
                    // we got a suggestion! Let's add it to the list and keep searching a new one.
                    // We won't add empty ones
                    if (!sbCurrSuggestion.isEmpty()) {
                        suggestions.add(sbCurrSuggestion.toString());
                    }
                }
                if (currDependableATNState.getCallerTransition() != null) {
                    // someone referenced this rule (probably via RuleTransition), we need to add its following state
                    // to the to-check list
                    lexerStatesToCheck.push(new DependableATNState(
                            currDependableATNState.getCallerTransition().getFollowingState(),
                            currDependableATNState,
                            currDependableATNState.getCallerTransition().getSourceState().getCallerTransition(),
                            currDependableATNState.getSbSuggestion(),
                            currDependableATNState.getSuggestedCharsAmount(),
                            currDependableATNState.getSuggestingAtInputPos(),
                            -1,
                            currDependableATNState.getBannedStates()
                    ));
                }
                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            if (currDependableATNState.getBannedStates().contains(currDependableATNState.getAtnState())) {
                // avoid infinite loops
                continue;
            }
            if (atnStateAnalyser.shouldStateBeBanned(currLexerState)) {
                currDependableATNState.getBannedStates().add(currLexerState);
            }
            boolean shouldCopySomeData = currLexerState.getNumberOfTransitions() > 1;
            for (int i = currLexerState.getNumberOfTransitions() - 1; i >= 0; i--) {
                // don't affect other transition's target states if one of the transitions gave a suggestion
                sbCurrSuggestion.setLength(currDependableATNState.getSuggestedCharsAmount());
                int atInputPos = currDependableATNState.getSuggestingAtInputPos();
                Transition transition = currLexerState.transition(i);
                TransitionAnalyseResult transitionAnalyseResult = transitionAnalyser.analyseTransition(
                        transition,
                        currDependableATNState
                );
                if (transitionAnalyseResult.getParserToLexerRuleNumbersOrLexerCharInts() != null) {
                    IntervalSet charIntervalSet = transitionAnalyseResult.getParserToLexerRuleNumbersOrLexerCharInts();
                    List<Character> newCharsForSuggestion = getCharsForSuggestion(charIntervalSet);
                    if (newCharsForSuggestion == null || newCharsForSuggestion.isEmpty()) {
                        throw new RuntimeException("No suggested chars for some reason");
                    }
                    charsLoop:
                    for (int j = 0; j < newCharsForSuggestion.size(); j++) {
                        InputAndSuggestionCompareResult inputAndSuggestionCompareResult = compareInputAndSuggestion(
                                textToComplete,
                                atInputPos,
                                newCharsForSuggestion.get(j)
                        );
                        switch (inputAndSuggestionCompareResult) {
                            case INAPPROPRIATE_SUGGESTION -> {
                                if (j != newCharsForSuggestion.size() - 1) {
                                    // ok but maybe other chars will fit the input?
                                    continue;
                                }
                                // nope we ain't wasting time on suggestions that don't fit the user input
                                continue statesLoop;
                            }
                            case APPROPRIATE_SUGGESTION -> {
                                sbCurrSuggestion.append(newCharsForSuggestion.get(j));
                                // nope we already found what we were looking for. Breaking
                                break charsLoop;
                            }
                            case SUGGESTION_ALREADY_IN_INPUT -> {
                                atInputPos++;
                                // nope we already found what we were looking for. Breaking
                                break charsLoop;
                            }
                            default -> throw new NotImplementedException("Unknown input and suggestion compare result");
                        }
                    }
                }
                StringBuilder sbSuggestion;
                Set<ATNState> bannedStates;
                if (shouldCopySomeData) {
                    sbSuggestion = new StringBuilder(currDependableATNState.getSbSuggestion());
                    bannedStates = new HashSet<>(currDependableATNState.getBannedStates());
                } else {
                    sbSuggestion = currDependableATNState.getSbSuggestion();
                    bannedStates = currDependableATNState.getBannedStates();
                }
                if (transitionAnalyseResult.getOtherRuleReference() != null) {
                    DependableATNState referencedState = new DependableATNState(
                            transitionAnalyseResult.getOtherRuleReference(),
                            currDependableATNState,
                            transitionAnalyseResult,
                            sbSuggestion,
                            sbCurrSuggestion.length(),
                            atInputPos,
                            -1,
                            bannedStates
                    );
                    lexerStatesToCheck.push(referencedState);
                } else {
                    DependableATNState followingState = new DependableATNState(
                            transitionAnalyseResult.getFollowingState(),
                            currDependableATNState,
                            currDependableATNState.getCallerTransition(),
                            sbSuggestion,
                            sbCurrSuggestion.length(),
                            atInputPos,
                            -1,
                            bannedStates
                    );
                    lexerStatesToCheck.push(followingState);
                }
            }
        }

        return suggestions;
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

    private List<Character> getCharsForSuggestion(IntervalSet availableCharsIntervals) {
        if (availableCharsIntervals.size() <= 0) {
            return null;
        }
        LinkedList<Character> result = new LinkedList<>();
        switch (casePreference) {
            case NONE -> {
                for (Interval interval : availableCharsIntervals.getIntervals()) {
                    for (int val = interval.a; val <= interval.b; val++) {
                        char[] chars = Character.toChars(val);
                        for (char character : chars) {
                            result.addFirst(character);
                        }
                    }
                }
            }
            case LOWER -> {
                for (Interval interval : availableCharsIntervals.getIntervals()) {
                    for (int val = interval.a; val <= interval.b; val++) {
                        char[] chars = Character.toChars(val);
                        for (char character : chars) {
                            if (Character.isUpperCase(character)) {
                                result.addLast(character);
                                continue;
                            }
                            result.addFirst(character);
                        }
                    }
                }
            }
            case UPPER -> {
                for (Interval interval : availableCharsIntervals.getIntervals()) {
                    for (int val = interval.a; val <= interval.b; val++) {
                        char[] chars = Character.toChars(val);
                        for (char character : chars) {
                            if (Character.isLowerCase(character)) {
                                result.addLast(character);
                                continue;
                            }
                            result.addFirst(character);
                        }
                    }
                }
            }
        }
        return result;
    }

    private Set<Transition> getClosestTokenConsumingTransitions(DependableATNState startParserState) {
        Set<Transition> closestTokenConsumingTransitions = new HashSet<>();
        // no we're not gonna system.arraycopy each time we want to pop an element, so linkedlist instead of stack
        LinkedList<DependableATNState> parserStatesToCheck = new LinkedList<>();
        parserStatesToCheck.addFirst(new DependableATNState(
                startParserState.getAtnState(),
                startParserState.getPrevState(),
                startParserState.getCallerTransition(),
                null,
                -1,
                -1,
                -1,
                null
        ));
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        while (!parserStatesToCheck.isEmpty()) {
            DependableATNState currDependableParserState = parserStatesToCheck.poll();
            ATNState currParserState = currDependableParserState.getAtnState();
            if (currParserState instanceof RuleStopState) {
                if (currDependableParserState.getCallerTransition() != null) {
                    parserStatesToCheck.addFirst(new DependableATNState(
                            currDependableParserState.getCallerTransition().getFollowingState(),
                            currDependableParserState,
                            currDependableParserState.getCallerTransition().getSourceState().getCallerTransition(),
                            null,
                            -1,
                            -1,
                            -1,
                            null
                    ));
                }

                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            for (int i = currParserState.getNumberOfTransitions() - 1; i >= 0; i--) {
                Transition transition = currParserState.transition(i);
                TransitionAnalyseResult transitionAnalyseResult = transitionAnalyser.analyseTransition(
                        transition,
                        currDependableParserState
                );
                if (transitionAnalyseResult.isSupposedToConsumeToken()) {
                    // ladies and gentlemen we got em
                    closestTokenConsumingTransitions.add(transition);
                } else if (transitionAnalyseResult.getOtherRuleReference() != null) {
                    // it references other rule states, we might get a proper state there!
                    parserStatesToCheck.addFirst(new DependableATNState(
                            transitionAnalyseResult.getOtherRuleReference(),
                            currDependableParserState,
                            transitionAnalyseResult,
                            null,
                            -1,
                            -1,
                            -1,
                            null
                    ));
                } else {
                    // bruh, keep exploring the ATN branch then
                    parserStatesToCheck.addFirst(new DependableATNState(
                            transitionAnalyseResult.getFollowingState(),
                            currDependableParserState,
                            currDependableParserState.getCallerTransition(),
                            null,
                            -1,
                            -1,
                            -1,
                            null
                    ));
                }
            }
        }

        return closestTokenConsumingTransitions;
    }
}
