package com.example.suggester;

import lombok.Getter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNState;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ParserWrapper {
    @Getter
    private final Parser cachedParser;

    public ParserWrapper(ParserFactory parserFactory) {
        this.cachedParser = parserFactory.createParser(null);
    }
}
