package com.lizurt.suggester;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.atn.ATNState;

// "at this atnState we already consumed tokenIndex tokens"
@Getter
@Setter
@AllArgsConstructor
public class ParserStateWithTokenIndex {
    private final ATNState atnState;

    // the state whose tokenIndex depends on this state.
    // For example, state A refers B via RuleTransition and has C as their following state. So if B consumes tokens,
    // C should also monitor this case (increase tokenIndex)
    private final ParserStateWithTokenIndex dependentState;

    // how many tokens we already consumed at this state
    private int tokenIndex;

    public void consumeToken() {
        tokenIndex++;
        ParserStateWithTokenIndex dependentState = this.dependentState;
        while (dependentState != null) {
            dependentState.tokenIndex++;
            dependentState = dependentState.getDependentState();
        }
    }
}
