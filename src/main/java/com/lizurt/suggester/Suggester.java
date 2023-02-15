package com.lizurt.suggester;

import java.util.*;

import com.lizurt.suggester.factories.LexerAndParserFactory;
import com.lizurt.util.PermissiveSimpleLinkedList;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.apache.commons.lang3.NotImplementedException;

public class Suggester {
    private final ParserWrapper parserWrapper;

    private final LexerWrapper lexerWrapper;

    @Getter
    @Setter
    private CasePreference casePreference = CasePreference.LOWER;

    private final TransitionAnalyser transitionAnalyser = new TransitionAnalyser();

    // region init stuff

    public Suggester(LexerAndParserFactory lexerAndParserFactory) {
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
        List<ATNState> initialParserStates = parserWrapper.getInitialAtnStates();
        List<String> suggestions = new ArrayList<>();
        for (ATNState initialState : initialParserStates) {
            ParserStateWithTokenIndex greediestParserState = getGreediestParserState(
                    initialState,
                    tokenizationResult.tokens
            );
            suggestions.addAll(generateAndGetSuggestions(greediestParserState, tokenizationResult));
        }
        return suggestions;
    }

    private ParserStateWithTokenIndex getGreediestParserState(
            ATNState startParserState,
            List<? extends Token> tokens
    ) {
        // the state where we consumed maximum amount of available tokens.
        // If the state consumed all the tokens (tokens.len == index) we can generate suggestions
        ParserStateWithTokenIndex greediestParserState = new ParserStateWithTokenIndex(
                startParserState,
                null,
                0
        );
        // no we're not gonna system.arraycopy each time we want to pop an element, so linkedlist instead of stack
        LinkedList<ParserStateWithTokenIndex> parserStatesToCheck = new LinkedList<>();
        parserStatesToCheck.addFirst(greediestParserState);
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
                    ParserStateWithTokenIndex followingState = new ParserStateWithTokenIndex(
                            transitionAnalyseResult.getTargetState(),
                            currParserState.getDependentState(),
                            currParserState.getTokenIndex()
                    );
                    if (transitionAnalyseResult.isSupposedToConsumeToken()) {
                        followingState.consumeToken();
                    }
                    // the one that transitions points to, not the one that it can reference via rule transition
                    parserStatesToCheck.addFirst(followingState);
                    if (transitionAnalyseResult.getOtherRuleReference() != null) {
                        // thus we check referenced rules first
                        parserStatesToCheck.addFirst(new ParserStateWithTokenIndex(
                                transitionAnalyseResult.getOtherRuleReference(),
                                followingState,
                                followingState.getTokenIndex()
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
        String textToComplete = tokenizationResult.untokenizedText;
        List<? extends Token> tokens = tokenizationResult.tokens;
        if (greediestState.getTokenIndex() < tokens.size()) {
            // oops seems the tokens don't fit in the parser rules.
            // Let's give it a second chance and assume that all tokens after greediest state token index are just
            // our untokenized text.
            StringBuilder sbNewTextToComplete = new StringBuilder();
            for (int i = greediestState.getTokenIndex(); i < tokens.size(); i++) {
                sbNewTextToComplete.append(tokens.get(i).getText());
            }
            // don't forget the untokenized text if lexer found some
            sbNewTextToComplete.append(textToComplete);
            textToComplete = sbNewTextToComplete.toString();
            tokens = tokens.subList(0, greediestState.getTokenIndex());
        }

        StringBuilder sbCurrSuggestion = new StringBuilder();
        // at which char in a user input we'll be checking if a new suggested char is already in the user input
        int atInputPos = 0;
        List<String> suggestions = new ArrayList<>();
        // no we're not gonna system.arraycopy each time we want to pop an element, so linkedlist instead of stack
        PermissiveSimpleLinkedList<DependableLexerState> lexerStatesToCheck = new PermissiveSimpleLinkedList<>();
        // we'll add a suggestion when will have reached one of these states, so we won't add incomplete suggestions,
        // e.g. "h" for "hello", we'll wait for full "hello" instead
        Set<ATNState> suggestableRulesStopStates = new HashSet<>();
        List<Transition> closestTokenConsumingTransitions = getClosestTokenConsumingTransitions(
                greediestState.getAtnState()
        );
        for (Transition transition : closestTokenConsumingTransitions) {
            for (Interval interval : transition.label().getIntervals()) {
                for (int val = interval.a; val <= interval.b; val++) {
                    RuleStartState lexerRuleToCheck = lexerWrapper.getRuleByItsType(val);
                    lexerStatesToCheck.addFirst(new DependableLexerState(
                            lexerRuleToCheck,
                            null,
                            sbCurrSuggestion.length(),
                            atInputPos
                    ));
                    suggestableRulesStopStates.add(lexerRuleToCheck.stopState);
                }
            }
        }
        // cheap way to avoid deep recursion here is to use stacks. They're not similar to recursion
        // but at least quite close to it
        statesLoop:
        while (lexerStatesToCheck.getFirst() != null) {
            PermissiveSimpleLinkedList.Node<DependableLexerState> currLexerStateNode = lexerStatesToCheck.removeFirst();
            DependableLexerState currDependableLexerState = currLexerStateNode.getValue();
            ATNState currLexerState = currLexerStateNode.getValue().getAtnState();
            if (currLexerState instanceof RuleStopState) {
                if (currDependableLexerState.getDependentLexerStateNode() != null) {
                    // we've reached the end of the inner rule completely, which means we could add suggestion chars
                    // somewhere. So the dependent rule shouldn't erase the inner rule's result but save it.
                    currDependableLexerState.getDependentLexerStateNode().getValue().setSuggestedCharsAmount(
                            currDependableLexerState.getSuggestedCharsAmount()
                    );
                    currDependableLexerState.getDependentLexerStateNode().getValue().setSuggestingAtInputPos(
                            currDependableLexerState.getSuggestingAtInputPos()
                    );
                }
                if (suggestableRulesStopStates.contains(currLexerState)) {
                    // we got a suggestion! Let's add it to the list and keep searching a new one.
                    // We won't add empty ones
                    if (!sbCurrSuggestion.isEmpty()) {
                        suggestions.add(sbCurrSuggestion.toString());
                    }
                }
                // no infinite loops allowed. RuleStopStates references rules that reference this rule
                continue;
            }
            // rule start states have null prev state
            if (currDependableLexerState.getPrevState() != null) {
                // we're here because of one of previous node's transition, so we can say we checked this transition
                currDependableLexerState.getPrevState().setUncheckedTransitionsAmt(
                        currDependableLexerState.getPrevState().getUncheckedTransitionsAmt() - 1
                );
            }
            currDependableLexerState.setUncheckedTransitionsAmt(currLexerState.getNumberOfTransitions());
            for (int i = currLexerState.getNumberOfTransitions() - 1; i >= 0; i--) {
                // don't affect other transition's target states if one of the transitions gave a suggestion
                sbCurrSuggestion.setLength(currDependableLexerState.getSuggestedCharsAmount());
                atInputPos = currDependableLexerState.getSuggestingAtInputPos();
                Transition transition = currLexerState.transition(i);
                TransitionAnalyseResult transitionAnalyseResult = transitionAnalyser.analyseTransition(
                        transition,
                        currLexerState
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
                                    // come on that's not the last suggestion there's still a chance!
                                    continue;
                                }
                                // nope all suggestions are a dead way. Let's roll back to some previous branch (rule).
                                // For avoiding duplicate code, we assume this state as a dependent state
                                PermissiveSimpleLinkedList.Node<DependableLexerState> dependentLexerStateNode =
                                        currLexerStateNode;
                                while (dependentLexerStateNode != null) {
                                    // poor states die without a chance to live :(
                                    lexerStatesToCheck.remove(currDependableLexerState.getDependentLexerStateNode());
                                    // we should also check if we need to remove the dependent state's dependent state,
                                    // so we also check if this branch (rule) still has some unchecked transitions
                                    DependableLexerState livingPrevState = dependentLexerStateNode.getValue().getPrevState();
                                    while (livingPrevState != null && livingPrevState.getUncheckedTransitionsAmt() == 0) {
                                        livingPrevState = livingPrevState.getPrevState();
                                    }
                                    if (livingPrevState != null) {
                                        // ok enough of breaking dependent states' lifes, their previous state still
                                        // has some unchecked transitions
                                        break;
                                    }
                                    // no living states in the previous ones of this one. This branch (rule) is
                                    // has completely failed, and we should fail the dependent state
                                    dependentLexerStateNode =
                                            dependentLexerStateNode.getValue().getDependentLexerStateNode();
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
                DependableLexerState followingState = new DependableLexerState(
                        transitionAnalyseResult.getTargetState(),
                        currDependableLexerState,
                        sbCurrSuggestion.length(),
                        atInputPos
                );
                followingState.dependOn(currDependableLexerState.getDependentLexerStateNode());
                PermissiveSimpleLinkedList.Node<DependableLexerState> followingStateNode =
                        lexerStatesToCheck.addFirst(followingState);
                if (transitionAnalyseResult.getOtherRuleReference() != null) {
                    DependableLexerState dependableLexerState = new DependableLexerState(
                            transitionAnalyseResult.getOtherRuleReference(),
                            null,
                            sbCurrSuggestion.length(),
                            atInputPos
                    );
                    dependableLexerState.dependOn(followingStateNode);
                    lexerStatesToCheck.addFirst(dependableLexerState);
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
        List<Character> result = new ArrayList<>();
        switch (casePreference) {
            case NONE -> {
                for (Interval interval : availableCharsIntervals.getIntervals()) {
                    for (int val = interval.a; val <= interval.b; val++) {
                        char[] chars = Character.toChars(val);
                        for (char character : chars) {
                            result.add(character);
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
                                continue;
                            }
                            result.add(character);
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
                                continue;
                            }
                            result.add(character);
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
