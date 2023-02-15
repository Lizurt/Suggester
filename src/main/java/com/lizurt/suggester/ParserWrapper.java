package com.lizurt.suggester;

import com.lizurt.suggester.factories.ParserFactory;
import lombok.Getter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.RuleStartState;

import java.util.ArrayList;
import java.util.List;

@Getter
class ParserWrapper {
    private final Parser cachedParser;

    // states with no links to them
    private final List<ATNState> initialAtnStates = new ArrayList<>();

    public ParserWrapper(ParserFactory parserFactory) {
        this.cachedParser = parserFactory.createParser(null);

        for (RuleStartState ruleStartState : cachedParser.getATN().ruleToStartState) {
            // stop states have transitions to states who were referenced via a transition who referenced this
            // start state. These transitions also known as rule transitions. So if there are no rule transitions,
            // no one references this start state so this start state is an initial state
            if (ruleStartState.stopState.getNumberOfTransitions() > 0) {
                continue;
            }
            initialAtnStates.add(ruleStartState);
        }
    }
}
