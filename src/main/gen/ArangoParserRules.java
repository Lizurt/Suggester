// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoParserRules.g4 by ANTLR 4.10.1

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
public class ArangoParserRules extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INSERT=1, IN=2, FOR=3, INTO=4, RETURN=5, DOT=6, MINUS=7, COLON=8, COMMA=9, 
		L_CUR_BR=10, R_CUR_BR=11, QUOTE=12, NUM_VAL=13, STR_VAL=14, NUMS=15, WS=16, 
		AL_NUM=17;
	public static final int
		RULE_query = 0, RULE_insertSt = 1, RULE_forSt = 2, RULE_into = 3, RULE_forStatements = 4, 
		RULE_keysAndVals = 5, RULE_keyAndVal = 6, RULE_value = 7, RULE_identifier = 8, 
		RULE_returnSt = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "insertSt", "forSt", "into", "forStatements", "keysAndVals", 
			"keyAndVal", "value", "identifier", "returnSt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'.'", "'-'", "':'", "','", "'{'", 
			"'}'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INSERT", "IN", "FOR", "INTO", "RETURN", "DOT", "MINUS", "COLON", 
			"COMMA", "L_CUR_BR", "R_CUR_BR", "QUOTE", "NUM_VAL", "STR_VAL", "NUMS", 
			"WS", "AL_NUM"
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
	public String getGrammarFileName() { return "ArangoParserRules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArangoParserRules(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public InsertStContext insertSt() {
			return getRuleContext(InsertStContext.class,0);
		}
		public ForStContext forSt() {
			return getRuleContext(ForStContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			setState(22);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				insertSt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				forSt();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InsertStContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(ArangoParserRules.INSERT, 0); }
		public TerminalNode L_CUR_BR() { return getToken(ArangoParserRules.L_CUR_BR, 0); }
		public KeysAndValsContext keysAndVals() {
			return getRuleContext(KeysAndValsContext.class,0);
		}
		public TerminalNode R_CUR_BR() { return getToken(ArangoParserRules.R_CUR_BR, 0); }
		public IntoContext into() {
			return getRuleContext(IntoContext.class,0);
		}
		public InsertStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterInsertSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitInsertSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitInsertSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStContext insertSt() throws RecognitionException {
		InsertStContext _localctx = new InsertStContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_insertSt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(INSERT);
			setState(25);
			match(L_CUR_BR);
			setState(26);
			keysAndVals();
			setState(27);
			match(R_CUR_BR);
			setState(28);
			into();
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

	public static class ForStContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ArangoParserRules.FOR, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode IN() { return getToken(ArangoParserRules.IN, 0); }
		public ForStatementsContext forStatements() {
			return getRuleContext(ForStatementsContext.class,0);
		}
		public ForStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterForSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitForSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitForSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStContext forSt() throws RecognitionException {
		ForStContext _localctx = new ForStContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forSt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(FOR);
			setState(31);
			identifier();
			setState(32);
			match(IN);
			setState(33);
			identifier();
			setState(34);
			forStatements();
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

	public static class IntoContext extends ParserRuleContext {
		public TerminalNode INTO() { return getToken(ArangoParserRules.INTO, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IntoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_into; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterInto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitInto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitInto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntoContext into() throws RecognitionException {
		IntoContext _localctx = new IntoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_into);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(INTO);
			setState(37);
			identifier();
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

	public static class ForStatementsContext extends ParserRuleContext {
		public ReturnStContext returnSt() {
			return getRuleContext(ReturnStContext.class,0);
		}
		public ForStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterForStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitForStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitForStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementsContext forStatements() throws RecognitionException {
		ForStatementsContext _localctx = new ForStatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forStatements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			returnSt();
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

	public static class KeysAndValsContext extends ParserRuleContext {
		public List<KeyAndValContext> keyAndVal() {
			return getRuleContexts(KeyAndValContext.class);
		}
		public KeyAndValContext keyAndVal(int i) {
			return getRuleContext(KeyAndValContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ArangoParserRules.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ArangoParserRules.COMMA, i);
		}
		public KeysAndValsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keysAndVals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterKeysAndVals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitKeysAndVals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitKeysAndVals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeysAndValsContext keysAndVals() throws RecognitionException {
		KeysAndValsContext _localctx = new KeysAndValsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_keysAndVals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			keyAndVal();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(42);
				match(COMMA);
				setState(43);
				keyAndVal();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class KeyAndValContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ArangoParserRules.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public KeyAndValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyAndVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterKeyAndVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitKeyAndVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitKeyAndVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyAndValContext keyAndVal() throws RecognitionException {
		KeyAndValContext _localctx = new KeyAndValContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_keyAndVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			identifier();
			setState(50);
			match(COLON);
			setState(51);
			value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STR_VAL() { return getToken(ArangoParserRules.STR_VAL, 0); }
		public TerminalNode NUM_VAL() { return getToken(ArangoParserRules.NUM_VAL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==NUM_VAL || _la==STR_VAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> AL_NUM() { return getTokens(ArangoParserRules.AL_NUM); }
		public TerminalNode AL_NUM(int i) {
			return getToken(ArangoParserRules.AL_NUM, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(55);
					match(AL_NUM);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(58); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ReturnStContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ArangoParserRules.RETURN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode DOT() { return getToken(ArangoParserRules.DOT, 0); }
		public ReturnStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterReturnSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitReturnSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitReturnSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStContext returnSt() throws RecognitionException {
		ReturnStContext _localctx = new ReturnStContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnSt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(RETURN);
			setState(61);
			identifier();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(62);
				match(DOT);
				}
			}

			setState(65);
			identifier();
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
		"\u0004\u0001\u0011D\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0003\u0000\u0017\b"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005-\b\u0005\n\u0005\f\u00050\t"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0004\b9\b\b\u000b\b\f\b:\u0001\t\u0001\t\u0001\t\u0003"+
		"\t@\b\t\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0000\u0001\u0001\u0000\r\u000e=\u0000\u0016"+
		"\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000\u0004\u001e"+
		"\u0001\u0000\u0000\u0000\u0006$\u0001\u0000\u0000\u0000\b\'\u0001\u0000"+
		"\u0000\u0000\n)\u0001\u0000\u0000\u0000\f1\u0001\u0000\u0000\u0000\u000e"+
		"5\u0001\u0000\u0000\u0000\u00108\u0001\u0000\u0000\u0000\u0012<\u0001"+
		"\u0000\u0000\u0000\u0014\u0017\u0003\u0002\u0001\u0000\u0015\u0017\u0003"+
		"\u0004\u0002\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0015\u0001"+
		"\u0000\u0000\u0000\u0017\u0001\u0001\u0000\u0000\u0000\u0018\u0019\u0005"+
		"\u0001\u0000\u0000\u0019\u001a\u0005\n\u0000\u0000\u001a\u001b\u0003\n"+
		"\u0005\u0000\u001b\u001c\u0005\u000b\u0000\u0000\u001c\u001d\u0003\u0006"+
		"\u0003\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0003"+
		"\u0000\u0000\u001f \u0003\u0010\b\u0000 !\u0005\u0002\u0000\u0000!\"\u0003"+
		"\u0010\b\u0000\"#\u0003\b\u0004\u0000#\u0005\u0001\u0000\u0000\u0000$"+
		"%\u0005\u0004\u0000\u0000%&\u0003\u0010\b\u0000&\u0007\u0001\u0000\u0000"+
		"\u0000\'(\u0003\u0012\t\u0000(\t\u0001\u0000\u0000\u0000).\u0003\f\u0006"+
		"\u0000*+\u0005\t\u0000\u0000+-\u0003\f\u0006\u0000,*\u0001\u0000\u0000"+
		"\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/\u000b\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"12\u0003\u0010\b\u000023\u0005\b\u0000\u000034\u0003\u000e\u0007\u0000"+
		"4\r\u0001\u0000\u0000\u000056\u0007\u0000\u0000\u00006\u000f\u0001\u0000"+
		"\u0000\u000079\u0005\u0011\u0000\u000087\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";\u0011\u0001\u0000\u0000\u0000<=\u0005\u0005\u0000\u0000=?\u0003\u0010"+
		"\b\u0000>@\u0005\u0006\u0000\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0003\u0010\b\u0000B\u0013\u0001"+
		"\u0000\u0000\u0000\u0004\u0016.:?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}