// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoGrammar.g4 by ANTLR 4.10.1

    package com.example.arangui.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArangoGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INSERT=1, L_CUR_BR=2, KEYS_AND_VALS=3, R_CUR_BR=4, INTO=5, TABLE_NAME=6, 
		FOR=7, ANY_WORD=8, IN=9, FOR_STATEMENTS=10;
	public static final int
		RULE_query = 0, RULE_statement = 1, RULE_insert = 2, RULE_forLoop = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "statement", "insert", "forLoop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INSERT", "L_CUR_BR", "KEYS_AND_VALS", "R_CUR_BR", "INTO", "TABLE_NAME", 
			"FOR", "ANY_WORD", "IN", "FOR_STATEMENTS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ArangoGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArangoGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoGrammarVisitor ) return ((ArangoGrammarVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoGrammarVisitor ) return ((ArangoGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			insert();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(ArangoGrammarParser.INSERT, 0); }
		public TerminalNode L_CUR_BR() { return getToken(ArangoGrammarParser.L_CUR_BR, 0); }
		public TerminalNode KEYS_AND_VALS() { return getToken(ArangoGrammarParser.KEYS_AND_VALS, 0); }
		public TerminalNode R_CUR_BR() { return getToken(ArangoGrammarParser.R_CUR_BR, 0); }
		public TerminalNode INTO() { return getToken(ArangoGrammarParser.INTO, 0); }
		public TerminalNode TABLE_NAME() { return getToken(ArangoGrammarParser.TABLE_NAME, 0); }
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).enterInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).exitInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoGrammarVisitor ) return ((ArangoGrammarVisitor<? extends T>)visitor).visitInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(INSERT);
			setState(13);
			match(L_CUR_BR);
			setState(14);
			match(KEYS_AND_VALS);
			setState(15);
			match(R_CUR_BR);
			setState(16);
			match(INTO);
			setState(17);
			match(TABLE_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ArangoGrammarParser.FOR, 0); }
		public List<TerminalNode> ANY_WORD() { return getTokens(ArangoGrammarParser.ANY_WORD); }
		public TerminalNode ANY_WORD(int i) {
			return getToken(ArangoGrammarParser.ANY_WORD, i);
		}
		public TerminalNode IN() { return getToken(ArangoGrammarParser.IN, 0); }
		public TerminalNode FOR_STATEMENTS() { return getToken(ArangoGrammarParser.FOR_STATEMENTS, 0); }
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoGrammarListener ) ((ArangoGrammarListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoGrammarVisitor ) return ((ArangoGrammarVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(FOR);
			setState(20);
			match(ANY_WORD);
			setState(21);
			match(IN);
			setState(22);
			match(ANY_WORD);
			setState(23);
			match(FOR_STATEMENTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\n\u001a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0000\u0000\u0004\u0000\u0002"+
		"\u0004\u0006\u0000\u0000\u0015\u0000\b\u0001\u0000\u0000\u0000\u0002\n"+
		"\u0001\u0000\u0000\u0000\u0004\f\u0001\u0000\u0000\u0000\u0006\u0013\u0001"+
		"\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000\t\u0001\u0001\u0000\u0000"+
		"\u0000\n\u000b\u0003\u0004\u0002\u0000\u000b\u0003\u0001\u0000\u0000\u0000"+
		"\f\r\u0005\u0001\u0000\u0000\r\u000e\u0005\u0002\u0000\u0000\u000e\u000f"+
		"\u0005\u0003\u0000\u0000\u000f\u0010\u0005\u0004\u0000\u0000\u0010\u0011"+
		"\u0005\u0005\u0000\u0000\u0011\u0012\u0005\u0006\u0000\u0000\u0012\u0005"+
		"\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u0007\u0000\u0000\u0014\u0015"+
		"\u0005\b\u0000\u0000\u0015\u0016\u0005\t\u0000\u0000\u0016\u0017\u0005"+
		"\b\u0000\u0000\u0017\u0018\u0005\n\u0000\u0000\u0018\u0007\u0001\u0000"+
		"\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}