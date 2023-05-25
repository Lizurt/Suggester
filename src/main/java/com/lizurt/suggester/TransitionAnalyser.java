package com.lizurt.suggester;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class TransitionAnalyser {
    public TransitionAnalyseResult analyseTransition(Transition transition) {
        return analyseTransition(transition, null);
    }

    public TransitionAnalyseResult analyseTransition(Transition transition, DependableATNState sourceState) {
        return analyseTransition(transition, sourceState, null, -1);
    }

    public TransitionAnalyseResult analyseTransition(
            Transition transition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (transition instanceof ActionTransition actionTransition) {
            return analyseActionTransition(actionTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof AtomTransition atomTransition) {
            return analyseAtomTransition(atomTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof EpsilonTransition epsilonTransition) {
            return analyseEpsilonTransition(epsilonTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof NotSetTransition notSetTransition) {
            return analyseNotSetTransition(notSetTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof PrecedencePredicateTransition precedencePredicateTransition) {
            return analysePrecedencePredicateTransition(precedencePredicateTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof PredicateTransition predicateTransition) {
            return analysePredicateTransition(predicateTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof RangeTransition rangeTransition) {
            return analyseRangeTransition(rangeTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof RuleTransition ruleTransition) {
            return analyseRuleTransition(ruleTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof SetTransition setTransition) {
            return analyseSetTransition(setTransition, sourceState, tokens, tokenListIndex);
        } else if (transition instanceof WildcardTransition wildcardTransition) {
            return analyseWildcardTransition(wildcardTransition, sourceState, tokens, tokenListIndex);
        }
        throw new NotImplementedException();
    }

    private boolean areTokenParamsIncorrect(List<? extends Token> tokens, int tokenListIndex) {
        return tokens == null || tokenListIndex < 0 || tokens.size() <= tokenListIndex;
    }

    private TransitionAnalyseResult analyseActionTransition(
            ActionTransition actionTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                actionTransition.label(),
                null,
                actionTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analyseAtomTransition(
            AtomTransition atomTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionAnalyseResult(
                    false,
                    true,
                    atomTransition.label(),
                    null,
                    atomTransition.target,
                    sourceState
            );
        }

        boolean doesTokenFitParser = atomTransition.label == tokens.get(tokenListIndex).getType();
        return new TransitionAnalyseResult(
                doesTokenFitParser,
                true,
                atomTransition.label(),
                null,
                atomTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analyseEpsilonTransition(
            EpsilonTransition epsilonTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionAnalyseResult(
                    false,
                    false,
                    epsilonTransition.label(),
                    null,
                    epsilonTransition.target,
                    sourceState
            );
        }

        return new TransitionAnalyseResult(
                true,
                false,
                epsilonTransition.label(),
                null,
                epsilonTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analyseNotSetTransition(
            NotSetTransition notSetTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                notSetTransition.label(),
                null,
                notSetTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analysePrecedencePredicateTransition(
            PrecedencePredicateTransition precedencePredicateTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                precedencePredicateTransition.label(),
                null,
                precedencePredicateTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analysePredicateTransition(
            PredicateTransition predicateTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                predicateTransition.label(),
                null,
                predicateTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analyseRangeTransition(
            RangeTransition rangeTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                rangeTransition.label(),
                null,
                rangeTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analyseRuleTransition(
            RuleTransition ruleTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                null,
                (RuleStartState) ruleTransition.target,
                ruleTransition.followState,
                sourceState
        );
    }
    private TransitionAnalyseResult analyseSetTransition(
            SetTransition setTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionAnalyseResult(
                    false,
                    true,
                    setTransition.label(),
                    null,
                    setTransition.target,
                    sourceState
            );
        }

        for (Interval interval : setTransition.set.getIntervals()) {
            for (int val = interval.a; val <= interval.b; val++) {
                if (tokens.get(tokenListIndex).getType() == val) {
                    return new TransitionAnalyseResult(
                            true,
                            true,
                            setTransition.label(),
                            null,
                            setTransition.target,
                            sourceState
                    );
                }
            }
        }
        return new TransitionAnalyseResult(
                false,
                true,
                setTransition.label(),
                null,
                setTransition.target,
                sourceState
        );
    }
    private TransitionAnalyseResult analyseWildcardTransition(
            WildcardTransition wildcardTransition,
            DependableATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                wildcardTransition.label(),
                null,
                wildcardTransition.target,
                sourceState
        );
    }
}
