package com.example.suggester;

import lombok.Data;
import org.antlr.v4.runtime.atn.ATNState;

// "at this atnState we already consumed tokenIndex tokens"
@Data
public class ParserStateWithTokenIndex {
    private final ATNState atnState;

    private final int tokenIndex;
}
