package com.example.suggester;

import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.misc.IntervalSet;

@Data
public class TransitionHandlerResult {
    private final boolean isTokenMatchingPattern;

    private final boolean isSupposedToConsumeToken;

    // ANTLR named this field "label" (very helpful field name for real), they use this field to reference
    // lexer rules in parser rules and at the same time in lexer rules this "label" can be just a
    // character (int representation)
    private final IntervalSet parserToLexerRuleNumbersOrLexerCharInts;

    private final ATNState otherRuleReference;

    @NonNull
    private final ATNState targetState;
}
