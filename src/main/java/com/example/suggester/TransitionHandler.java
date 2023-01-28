package com.example.suggester;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class TransitionHandler {
    public TransitionHandlerResult handleTransition(Transition transition) {
        return handleTransition(transition, null);
    }

    public TransitionHandlerResult handleTransition(Transition transition, ATNState sourceState) {
        return handleTransition(transition, sourceState, null, -1);
    }

    public TransitionHandlerResult handleTransition(
            Transition transition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (transition instanceof ActionTransition actionTransition) {
            return handleActionTransition(actionTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof AtomTransition atomTransition) {
            System.out.println("  Transition " + sourceState.stateNumber + " -> "
                    + transition.target.stateNumber + " is Atom");
            return handleAtomTransition(atomTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof EpsilonTransition epsilonTransition) {
            System.out.println("  Transition " + sourceState.stateNumber + " -> "
                    + transition.target.stateNumber + " is Epsilon");
            return handleEpsilonTransition(epsilonTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof NotSetTransition notSetTransition) {
            return handleNotSetTransition(notSetTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof PrecedencePredicateTransition precedencePredicateTransition) {
            return handlePrecedencePredicateTransition(precedencePredicateTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof PredicateTransition predicateTransition) {
            return handlePredicateTransition(predicateTransition , sourceState, tokens, tokenListIndex);
        } else if (transition instanceof RangeTransition rangeTransition) {
            return handleRangeTransition(rangeTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof RuleTransition ruleTransition) {
            return handleRuleTransition(ruleTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof SetTransition setTransition) {
            System.out.println("  Transition " + sourceState.stateNumber + " -> "
                    + transition.target.stateNumber + " is Set");
            return handleSetTransition(setTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof WildcardTransition wildcardTransition) {
            return handleWildcardTransition(wildcardTransition, sourceState, tokens, tokenListIndex);
        }
        throw new NotImplementedException();
    }

    private boolean areTokenParamsIncorrect(List<? extends Token> tokens, int tokenListIndex) {
        return tokens == null || tokenListIndex < 0 || tokens.size() <= tokenListIndex;
    }

    private TransitionHandlerResult handleActionTransition(
            ActionTransition actionTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionHandlerResult handleAtomTransition(
            AtomTransition atomTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionHandlerResult(
                    false,
                    true,
                    atomTransition.label(),
                    null,
                    atomTransition.target
            );
        }

        boolean doesTokenFitParser = atomTransition.label == tokens.get(tokenListIndex).getType();
        return new TransitionHandlerResult(
                doesTokenFitParser,
                true,
                atomTransition.label(),
                null,
                atomTransition.target
        );
    }
    private TransitionHandlerResult handleEpsilonTransition(
            EpsilonTransition epsilonTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionHandlerResult(
                    false,
                    false,
                    epsilonTransition.label(),
                    null,
                    epsilonTransition.target
            );
        }

        return new TransitionHandlerResult(
                true,
                false,
                epsilonTransition.label(),
                null,
                epsilonTransition.target
        );
    }
    private TransitionHandlerResult handleNotSetTransition(
            NotSetTransition notSetTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionHandlerResult handlePrecedencePredicateTransition(
            PrecedencePredicateTransition precedencePredicateTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionHandlerResult handlePredicateTransition(
            PredicateTransition predicateTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionHandlerResult handleRangeTransition(
            RangeTransition rangeTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionHandlerResult handleRuleTransition(
            RuleTransition ruleTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionHandlerResult(
                true,
                false,
                null,
                ruleTransition.target,
                ruleTransition.followState
        );
    }
    private TransitionHandlerResult handleSetTransition(
            SetTransition setTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionHandlerResult(
                    false,
                    true,
                    setTransition.label(),
                    null,
                    setTransition.target
            );
        }

        for (Interval interval : setTransition.set.getIntervals()) {
            for (int val = interval.a; val <= interval.b; val++) {
                if (tokens.get(tokenListIndex).getType() == val) {
                    return new TransitionHandlerResult(
                            true,
                            true,
                            setTransition.label(),
                            null,
                            setTransition.target
                    );
                }
            }
        }
        return new TransitionHandlerResult(
                false,
                true,
                setTransition.label(),
                null,
                setTransition.target
        );
    }
    private TransitionHandlerResult handleWildcardTransition(
            WildcardTransition wildcardTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
}
