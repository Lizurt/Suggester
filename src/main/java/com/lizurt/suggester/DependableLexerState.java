package com.lizurt.suggester;

import com.lizurt.util.PermissiveSimpleLinkedList;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.atn.ATNState;

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
public class DependableLexerState {
    // the state itself
    private ATNState atnState;

    // its previous state
    private DependableLexerState prevState;

    // if this state's branch fails completely, the dependent state's branch fails too
    private PermissiveSimpleLinkedList.Node<DependableLexerState> dependentLexerStateNode;

    // how many states depends on this state
    private int dependingStatesAmount;

    // how many chars we already suggested at this state
    private int suggestedCharsAmount;

    // at which input char we're getting a suggestion for
    private int suggestingAtInputPos;

    // how many transitions of this state remains unchecked
    private int uncheckedTransitionsAmt;

    public DependableLexerState(
            ATNState atnState,
            DependableLexerState prevState,
            int suggestedCharsAmount,
            int suggestingAtInputPos
    ) {
        this.atnState = atnState;
        this.prevState = prevState;
        this.suggestedCharsAmount = suggestedCharsAmount;
        this.suggestingAtInputPos = suggestingAtInputPos;
    }

    public void dependOn(PermissiveSimpleLinkedList.Node<DependableLexerState> dependentLexerStateNode) {
        this.dependentLexerStateNode = dependentLexerStateNode;
        PermissiveSimpleLinkedList.Node<DependableLexerState> tempNode = dependentLexerStateNode;
        while (tempNode != null) {
            tempNode.getValue().dependingStatesAmount++;
            tempNode = tempNode.getValue().dependentLexerStateNode;
        }
    }

    public void failBranch() {
        PermissiveSimpleLinkedList.Node<DependableLexerState> tempNode = this.getDependentLexerStateNode();
        while (tempNode != null) {
            tempNode.getValue().dependingStatesAmount--;
            tempNode = tempNode.getValue().getDependentLexerStateNode();
        }
    }

    @Override
    public String toString() {
        return atnState.toString();
    }
}
