package com.lizurt.suggester;

import com.lizurt.suggester.factories.ParserFactory;
import lombok.Getter;
import org.antlr.v4.runtime.Parser;

class ParserWrapper {
    @Getter
    private final Parser cachedParser;

    public ParserWrapper(ParserFactory parserFactory) {
        this.cachedParser = parserFactory.createParser(null);
    }
}
