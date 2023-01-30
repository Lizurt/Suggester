package com.example.suggester;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class TransitionAnalyser {
    public TransitionAnalyseResult analyseTransition(Transition transition) {
        return analyseTransition(transition, null);
    }

    public TransitionAnalyseResult analyseTransition(Transition transition, ATNState sourceState) {
        return analyseTransition(transition, sourceState, null, -1);
    }

    public TransitionAnalyseResult analyseTransition(
            Transition transition,
            ATNState sourceState,
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
            return analysePredicateTransition(predicateTransition , sourceState, tokens, tokenListIndex);
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
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionAnalyseResult analyseAtomTransition(
            AtomTransition atomTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionAnalyseResult(
                    false,
                    true,
                    atomTransition.label(),
                    null,
                    atomTransition.target
            );
        }

        boolean doesTokenFitParser = atomTransition.label == tokens.get(tokenListIndex).getType();
        return new TransitionAnalyseResult(
                doesTokenFitParser,
                true,
                atomTransition.label(),
                null,
                atomTransition.target
        );
    }
    private TransitionAnalyseResult analyseEpsilonTransition(
            EpsilonTransition epsilonTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionAnalyseResult(
                    false,
                    false,
                    epsilonTransition.label(),
                    null,
                    epsilonTransition.target
            );
        }

        return new TransitionAnalyseResult(
                true,
                false,
                epsilonTransition.label(),
                null,
                epsilonTransition.target
        );
    }
    private TransitionAnalyseResult analyseNotSetTransition(
            NotSetTransition notSetTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionAnalyseResult analysePrecedencePredicateTransition(
            PrecedencePredicateTransition precedencePredicateTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionAnalyseResult analysePredicateTransition(
            PredicateTransition predicateTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionAnalyseResult analyseRangeTransition(
            RangeTransition rangeTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
    private TransitionAnalyseResult analyseRuleTransition(
            RuleTransition ruleTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        return new TransitionAnalyseResult(
                true,
                false,
                null,
                ruleTransition.target,
                ruleTransition.followState
        );
    }
    private TransitionAnalyseResult analyseSetTransition(
            SetTransition setTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        if (areTokenParamsIncorrect(tokens, tokenListIndex)) {
            return new TransitionAnalyseResult(
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
                    return new TransitionAnalyseResult(
                            true,
                            true,
                            setTransition.label(),
                            null,
                            setTransition.target
                    );
                }
            }
        }
        return new TransitionAnalyseResult(
                false,
                true,
                setTransition.label(),
                null,
                setTransition.target
        );
    }
    private TransitionAnalyseResult analyseWildcardTransition(
            WildcardTransition wildcardTransition,
            ATNState sourceState,
            List<? extends Token> tokens,
            int tokenListIndex
    ) {
        throw new NotImplementedException();
    }
}
