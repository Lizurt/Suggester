package com.lizurt.suggester;

import com.lizurt.suggester.factories.ParserFactory;
import lombok.Getter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.RuleStartState;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParserWrapper {
    private final Parser cachedParser;

    // states with no links to them
    private List<RuleStartState> initialAtnStates = new ArrayList<>();

    public ParserWrapper(ParserFactory parserFactory) {
        this.cachedParser = parserFactory.createParser(null);
        this.initialAtnStates = tryGetInitialAtnStates();
    }

    public ParserWrapper(ParserFactory parserFactory, List<RuleStartState> initialAtnStates) {
        this.cachedParser = parserFactory.createParser(null);
        this.initialAtnStates = initialAtnStates;
    }

    public ParserWrapper(ParserFactory parserFactory, String... initialAtnStatesNames) {
        this.cachedParser = parserFactory.createParser(null);
        for (String stateName : initialAtnStatesNames) {
            if (!cachedParser.getRuleIndexMap().containsKey(stateName)) {
                throw new IllegalArgumentException("Parser doesn't conain such state: \"" + stateName + "\"");
            }
            int stateIndex = cachedParser.getRuleIndexMap().get(stateName);
            initialAtnStates.add(cachedParser.getATN().ruleToStartState[stateIndex]);
        }
    }

    public List<RuleStartState> tryGetInitialAtnStates() {
        List<RuleStartState> result = new ArrayList<>();
        for (RuleStartState ruleStartState : cachedParser.getATN().ruleToStartState) {
            // stop states have transitions to states who were referenced via a transition who referenced this
            // start state. These transitions also known as rule transitions. So if there are no rule transitions,
            // no one references this state, so we assume this state as an initial one
            if (ruleStartState.stopState.getNumberOfTransitions() > 0) {
                continue;
            }
            result.add(ruleStartState);
        }
        return result;
    }
}
