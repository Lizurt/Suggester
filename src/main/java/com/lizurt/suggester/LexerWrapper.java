package com.lizurt.suggester;

import com.lizurt.suggester.factories.LexerFactory;
import lombok.Getter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.RuleStartState;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.tool.ANTLRToolListener;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexerWrapper {
    private final LexerFactory lexerFactory;

    @Getter
    private Lexer cachedLexer;

    private Map<Integer, RuleStartState> rulesByTheirTypesMap = new HashMap<>();

    public LexerWrapper(LexerFactory lexerFactory) {
        super();
        this.lexerFactory = lexerFactory;
        cachedLexer = createLexer("");
        cacheRulesByTheirTypes();
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
    
    public List<? extends Token> tokenize(String input) {
        Lexer lexer = this.createLexer(input);
        lexer.removeErrorListeners();
        return lexer.getAllTokens();
    }

    // it's being used to generate textToAutocomplete. We can't say for sure what chars we need to skip. Some languages
    // skip whitespaces, some do not. Or maybe they skip other chars? No time to analyse the whole ATN,
    // just add everything that our lexer didn't skip.
    public String getAllNonSkippedChars(String input) {
        Lexer lexer = this.createLexer(input);
        lexer.removeErrorListeners();
        StringBuilder sbResult = new StringBuilder();
        ANTLRErrorListener newErrorListener = new BaseErrorListener() {
            @Override
            public void syntaxError(
                    Recognizer<?, ?> recognizer,
                    Object offendingSymbol,
                    int line,
                    int charPositionInLine,
                    String msg,
                    RecognitionException e
            ) throws ParseCancellationException {
                sbResult.append(input.charAt(charPositionInLine));
            }
        };
        lexer.addErrorListener(newErrorListener);
        Token token;
        while ((token = lexer.nextToken()) != null) {
            if (token.getType() == Token.EOF) {
                break;
            }
            sbResult.append(token.getText());
        }
        return sbResult.toString();
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
