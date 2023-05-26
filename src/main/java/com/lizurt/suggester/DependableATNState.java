package com.lizurt.suggester;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.RuleStartState;

import java.util.HashSet;
import java.util.Set;

// For example we have A state who refers B state via RuleTransition who then leads to C state.
// If B state fails completely (all their forks/branches fail completely), we should also cut the A -> C branch,
// which means we "fail" C state.
// Let's say B state have 2 forks. If first fork fails that doesn't mean all B state fails - we still have the
// second fork. In this case we had 2 dependingStatesAmount on A. When each branch fails, we reduce
// dependingStatesAmount for every dependentLexerState and their dependentLexerState etc etc.
// When dependingStatesAmount reaches 0, we cut A -> C branch like we said earlier. That means we remove this state
// from the checking list, who is actually a linked list. In order to remove the state, we have to use Node.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DependableATNState {
    // the rule that contains the atn state
    private RuleStartState atnRuleState;

    // the state itself
    private ATNState atnState;

    // its previous state
    private DependableATNState prevState;

    // the transition who referenced current rule branch. If, in the current branch, we reach a RuleStopState, we
    // add a transition's following state to the to-check list
    private TransitionAnalyseResult callerTransition;

    private StringBuilder sbSuggestion;

    // how many chars we already suggested at this state
    private int suggestedCharsAmount = -1;

    // at which input char we're getting a suggestion for
    private int suggestingAtInputPos = -1;

    // how many tokens we consumed at this state
    private int consumedTokensAmt = -1;

    // which transitions' following states are banned to be checked. Used in star and plus blocks where we don't want
    // to loop infinitely
    private Set<ATNState> bannedStates;

    private boolean lastTokenConsumedViaBannedRule;

    @Override
    public String toString() {
        return atnState.toString();
    }
}
