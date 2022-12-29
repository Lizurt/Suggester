package com.example.autosuggest;

import java.io.IOException;
import java.io.StringReader;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class LexerWrapper {
    private final LexerFactory lexerFactory;
    private Lexer cachedLexer;

    static class TokenizationResult {
        public List<? extends Token> tokens;
        public String untokenizedText = "";
    }

    public LexerWrapper(LexerFactory lexerFactory) {
        super();
        this.lexerFactory = lexerFactory;
    }

    public TokenizationResult tokenizeNonDefaultChannel(String input) {
        TokenizationResult result = this.tokenize(input);
        result.tokens = result.tokens.stream().filter(t -> t.getChannel() == 0).collect(Collectors.toList());
        return result;
    }

    public String[] getRuleNames() {
        return getCachedLexer().getRuleNames();
    }

    public ATNState findStateByRuleNumber(int ruleNumber) {
        return getCachedLexer().getATN().ruleToStartState[ruleNumber];
    }

    public Vocabulary getVocabulary() {
        return getCachedLexer().getVocabulary();
    }
    
    private Lexer getCachedLexer() {
        if (cachedLexer == null) {
            cachedLexer = createLexer("");
        }
        return cachedLexer;
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
        ANTLRErrorListener antlrErrorListener = new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                System.out.println("!!!!!!!!!!!!!!!!!! syntax");
            }

            @Override
            public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
                System.out.println("!!!!!!!!!!!!!!!!! ambiguiy");
            }

            @Override
            public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
                System.out.println("!!!!!!!!!!!!!!!!!! context");
            }

            @Override
            public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
                System.out.println("!!!!!!!!!!!!!!!!!! sensetivity");
            }
        };
        lexer.addErrorListener(newErrorListener);
        //lexer.addErrorListener(antlrErrorListener);
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
            throw new IllegalStateException("Unexpected while reading input string", e);
        }
        return inputStream;
    }

}
