package com.lizurt.suggester;

import com.lizurt.suggester.factories.LexerFactory;
import lombok.Getter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.RuleStartState;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LexerWrapper {
    private final LexerFactory lexerFactory;

    @Getter
    private Lexer cachedLexer;

    private Map<Integer, RuleStartState> rulesByTheirTypesMap = new HashMap<>();

    static class TokenizationResult {
        public List<? extends Token> tokens;
        public String untokenizedText = "";
    }

    public LexerWrapper(LexerFactory lexerFactory) {
        super();
        this.lexerFactory = lexerFactory;
        cachedLexer = createLexer("");
        cacheRulesByTheirTypes();
    }

    public TokenizationResult tokenizeNonDefaultChannel(String input) {
        TokenizationResult result = tokenize(input);
        result.tokens = result.tokens.stream().filter(t -> t.getChannel() == 0).collect(Collectors.toList());
        return result;
    }

    public RuleStartState getRuleByItsType(int type) {
        return rulesByTheirTypesMap.get(type);
    }

    private void cacheRulesByTheirTypes() {
        Map<String, Integer> tokenTypeMap = getCachedLexer().getTokenTypeMap();
        Map<String, Integer> ruleIndexMap = getCachedLexer().getRuleIndexMap();
        for (Map.Entry<String, Integer> entry : tokenTypeMap.entrySet()) {
            if (entry.getValue() < 0) {
                // EOF has -1 type. This rule doesn't have its own index or rule
                continue;
            }
            if (!entry.getKey().isEmpty() && !Character.isUpperCase(entry.getKey().charAt(0))) {
                // ANTLR has both rule names and their values if the value is a plain string (TEST: 'test';).
                // but the ruleIndexMap isn't about values-to-indexes, so we're skipping this value
                continue;
            }
            RuleStartState ruleStartState =
                    getCachedLexer().getATN().ruleToStartState[ruleIndexMap.get(entry.getKey())];
            rulesByTheirTypesMap.put(entry.getValue(), ruleStartState);
        }
    }
    
    private TokenizationResult tokenize(String input) {
        Lexer lexer = this.createLexer(input);
        lexer.removeErrorListeners();
        final TokenizationResult result = new TokenizationResult();
        ANTLRErrorListener newErrorListener = new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                    int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException {
                result.untokenizedText = input.substring(charPositionInLine); // intended side effect
            }
        };
        lexer.addErrorListener(newErrorListener);
        result.tokens = lexer.getAllTokens();
        return result;
    }

    private Lexer createLexer(CharStream input) {
        return this.lexerFactory.createLexer(input);
    }

    private Lexer createLexer(String lexerInput) {
        return this.createLexer(toCharStream(lexerInput));
    }

    private static CharStream toCharStream(String text) {
        CharStream inputStream;
        try {
            inputStream = CharStreams.fromReader(new StringReader(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputStream;
    }
}
