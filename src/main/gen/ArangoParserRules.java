// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoParserRules.g4 by ANTLR 4.10.1

    package com.example.arangui.antlr;

    import java.util.*;
    import org.antlr.v4.tool.Rule;
    import com.example.arangui.arango.grammar.AranagoGrammarRulesSingleton;

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
		AGGREGATE=1, ALL=2, AND=3, ANY=4, ASC=5, COLLECT=6, DESC=7, DISTINCT=8, 
		FALSE=9, FOR=10, GRAPH=11, IN=12, INBOUND=13, INSERT=14, INTO=15, K_PATHS=16, 
		K_SHORTEST_PATHS=17, LET=18, LIMIT=19, NONE=20, NOT=21, NULL=22, OR=23, 
		OUTBOUND=24, REMOVE=25, REPLACE=26, RETURN=27, SHORTEST_PATH=28, SORT=29, 
		TRUE=30, UPDATE=31, UPSERT=32, WITH=33, WINDOW=34, CHAR_BACKTICK=35, CHAR_TILDA=36, 
		CHAR_EXCL_MARK=37, CHAR_AT_SIGN=38, CHAR_NUMBER_SIGN=39, CHAR_DOLLAR=40, 
		CHAR_PERCENT=41, CHAR_CIRCUMFLEX=42, CHAR_AMPERSAND=43, CHAR_ASTERISK=44, 
		CHAR_L_ROUND_BR=45, CHAR_R_ROUND_BR=46, CHAR_MINUS=47, CHAR_UNDERSCORE=48, 
		CHAR_EQUALS=49, CHAR_PLUS=50, CHAR_L_BR=51, CHAR_L_CUR_BR=52, CHAR_R_BR=53, 
		CHAR_R_CUR_BR=54, CHAR_SEMICON=55, CHAR_COLON=56, CHAR_APOSTROPHE=57, 
		CHAR_QUOTE=58, CHAR_BACKSLASH=59, CHAR_VERT_LINE=60, CHAR_COMMA=61, CHAR_L_TRIANG_BR=62, 
		CHAR_DOT=63, CHAR_R_TRIANG_BR=64, CHAR_SLASH=65, CHAR_QUESTION_MARK=66, 
		VAL_DOUBLE=67, VAL_STRING=68, VAL_IDENTIFIER=69, IGNORED_COMMENT=70, IGNORED_MULTILINE_COMMENT=71, 
		IGNORED_NL=72, IGNORED_TAB=73, IGNORED_SPACE=74, IGNORED_WS=75, VAL_FLOAT=76;
	public static final int
		RULE_query = 0, RULE_insert = 1, RULE_forLoop = 2, RULE_into = 3, RULE_forStatements = 4, 
		RULE_keysAndVals = 5, RULE_keyAndVal = 6, RULE_value = 7, RULE_identifier = 8, 
		RULE_returnSt = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "insert", "forLoop", "into", "forStatements", "keysAndVals", 
			"keyAndVal", "value", "identifier", "returnSt"
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
			null, "AGGREGATE", "ALL", "AND", "ANY", "ASC", "COLLECT", "DESC", "DISTINCT", 
			"FALSE", "FOR", "GRAPH", "IN", "INBOUND", "INSERT", "INTO", "K_PATHS", 
			"K_SHORTEST_PATHS", "LET", "LIMIT", "NONE", "NOT", "NULL", "OR", "OUTBOUND", 
			"REMOVE", "REPLACE", "RETURN", "SHORTEST_PATH", "SORT", "TRUE", "UPDATE", 
			"UPSERT", "WITH", "WINDOW", "CHAR_BACKTICK", "CHAR_TILDA", "CHAR_EXCL_MARK", 
			"CHAR_AT_SIGN", "CHAR_NUMBER_SIGN", "CHAR_DOLLAR", "CHAR_PERCENT", "CHAR_CIRCUMFLEX", 
			"CHAR_AMPERSAND", "CHAR_ASTERISK", "CHAR_L_ROUND_BR", "CHAR_R_ROUND_BR", 
			"CHAR_MINUS", "CHAR_UNDERSCORE", "CHAR_EQUALS", "CHAR_PLUS", "CHAR_L_BR", 
			"CHAR_L_CUR_BR", "CHAR_R_BR", "CHAR_R_CUR_BR", "CHAR_SEMICON", "CHAR_COLON", 
			"CHAR_APOSTROPHE", "CHAR_QUOTE", "CHAR_BACKSLASH", "CHAR_VERT_LINE", 
			"CHAR_COMMA", "CHAR_L_TRIANG_BR", "CHAR_DOT", "CHAR_R_TRIANG_BR", "CHAR_SLASH", 
			"CHAR_QUESTION_MARK", "VAL_DOUBLE", "VAL_STRING", "VAL_IDENTIFIER", "IGNORED_COMMENT", 
			"IGNORED_MULTILINE_COMMENT", "IGNORED_NL", "IGNORED_TAB", "IGNORED_SPACE", 
			"IGNORED_WS", "VAL_FLOAT"
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


	    public final static int CONTEXT_POSTFIX_LENGTH = 7;

	    private final static List<Class<?>> allContextClasses = Arrays.asList(ArangoParserRules.class.getDeclaredClasses());

	    private final static Map<Class<? extends ParseTree>, Rule> rulesByContextClasses = new HashMap<>();

	    public ArangoParserRules(TokenStream input, boolean shouldInitRulesByContextClassesMap) {
	        this(input);
	        if (shouldInitRulesByContextClassesMap) {
	            initRulesByContextClassesMap();
	        }
	    }

	    private void initRulesByContextClassesMap() {
	        for (Class<?> contextClass : allContextClasses) {
	            String rawContextClassName = contextClass.getSimpleName();
	            // camelCasing the name
	            String contextClassName = String.valueOf(Character.toLowerCase(rawContextClassName.charAt(0)));
	            // the first symbol was camelCased already, so we start from a 2nd char.
	            // We also need to remove the "Context" postfix
	            contextClassName += rawContextClassName.substring(1, rawContextClassName.length() - CONTEXT_POSTFIX_LENGTH);
	            if (!AranagoGrammarRulesSingleton.getInstance().getParserRulesByNames().containsKey(contextClassName)) {
	                throw new RuntimeException("Cannot find a parser rule by such context class name: \""
	                    + contextClassName + "\"."
	                );
	            }
	            Rule parserRule = AranagoGrammarRulesSingleton.getInstance().getParserRulesByNames().get(contextClassName);
	            rulesByContextClasses.put((Class<? extends ParseTree>) contextClass, parserRule);
	        }
	    }

	    public static Rule getRuleByContextClass(Class<? extends ParseTree> contextClass) {
	        return rulesByContextClasses.containsKey(contextClass) ? rulesByContextClasses.get(contextClass) : null;
	    }

	public ArangoParserRules(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
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
				insert();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				forLoop();
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

	public static class InsertContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(ArangoParserRules.INSERT, 0); }
		public TerminalNode CHAR_L_CUR_BR() { return getToken(ArangoParserRules.CHAR_L_CUR_BR, 0); }
		public KeysAndValsContext keysAndVals() {
			return getRuleContext(KeysAndValsContext.class,0);
		}
		public TerminalNode CHAR_R_CUR_BR() { return getToken(ArangoParserRules.CHAR_R_CUR_BR, 0); }
		public IntoContext into() {
			return getRuleContext(IntoContext.class,0);
		}
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(INSERT);
			setState(25);
			match(CHAR_L_CUR_BR);
			setState(26);
			keysAndVals();
			setState(27);
			match(CHAR_R_CUR_BR);
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

	public static class ForLoopContext extends ParserRuleContext {
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
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArangoParserRulesListener ) ((ArangoParserRulesListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArangoParserRulesVisitor ) return ((ArangoParserRulesVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forLoop);
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
		public List<TerminalNode> CHAR_COMMA() { return getTokens(ArangoParserRules.CHAR_COMMA); }
		public TerminalNode CHAR_COMMA(int i) {
			return getToken(ArangoParserRules.CHAR_COMMA, i);
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
			while (_la==CHAR_COMMA) {
				{
				{
				setState(42);
				match(CHAR_COMMA);
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
		public TerminalNode CHAR_COLON() { return getToken(ArangoParserRules.CHAR_COLON, 0); }
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
			match(CHAR_COLON);
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
		public TerminalNode VAL_STRING() { return getToken(ArangoParserRules.VAL_STRING, 0); }
		public TerminalNode VAL_FLOAT() { return getToken(ArangoParserRules.VAL_FLOAT, 0); }
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
			if ( !(_la==VAL_STRING || _la==VAL_FLOAT) ) {
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
		public TerminalNode VAL_IDENTIFIER() { return getToken(ArangoParserRules.VAL_IDENTIFIER, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(VAL_IDENTIFIER);
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
		public TerminalNode CHAR_DOT() { return getToken(ArangoParserRules.CHAR_DOT, 0); }
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
			setState(57);
			match(RETURN);
			setState(58);
			identifier();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHAR_DOT) {
				{
				setState(59);
				match(CHAR_DOT);
				setState(60);
				identifier();
				}
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

	public static final String _serializedATN =
		"\u0004\u0001L@\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0003\u0000\u0017\b\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005-\b\u0005\n\u0005\f\u00050\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t>\b\t\u0001\t\u0000"+
		"\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0001\u0002"+
		"\u0000DDLL8\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000"+
		"\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000\u0006$\u0001\u0000\u0000"+
		"\u0000\b\'\u0001\u0000\u0000\u0000\n)\u0001\u0000\u0000\u0000\f1\u0001"+
		"\u0000\u0000\u0000\u000e5\u0001\u0000\u0000\u0000\u00107\u0001\u0000\u0000"+
		"\u0000\u00129\u0001\u0000\u0000\u0000\u0014\u0017\u0003\u0002\u0001\u0000"+
		"\u0015\u0017\u0003\u0004\u0002\u0000\u0016\u0014\u0001\u0000\u0000\u0000"+
		"\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0001\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0005\u000e\u0000\u0000\u0019\u001a\u00054\u0000\u0000\u001a"+
		"\u001b\u0003\n\u0005\u0000\u001b\u001c\u00056\u0000\u0000\u001c\u001d"+
		"\u0003\u0006\u0003\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0005\n\u0000\u0000\u001f \u0003\u0010\b\u0000 !\u0005\f\u0000\u0000"+
		"!\"\u0003\u0010\b\u0000\"#\u0003\b\u0004\u0000#\u0005\u0001\u0000\u0000"+
		"\u0000$%\u0005\u000f\u0000\u0000%&\u0003\u0010\b\u0000&\u0007\u0001\u0000"+
		"\u0000\u0000\'(\u0003\u0012\t\u0000(\t\u0001\u0000\u0000\u0000).\u0003"+
		"\f\u0006\u0000*+\u0005=\u0000\u0000+-\u0003\f\u0006\u0000,*\u0001\u0000"+
		"\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001"+
		"\u0000\u0000\u0000/\u000b\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u000012\u0003\u0010\b\u000023\u00058\u0000\u000034\u0003\u000e\u0007"+
		"\u00004\r\u0001\u0000\u0000\u000056\u0007\u0000\u0000\u00006\u000f\u0001"+
		"\u0000\u0000\u000078\u0005E\u0000\u00008\u0011\u0001\u0000\u0000\u0000"+
		"9:\u0005\u001b\u0000\u0000:=\u0003\u0010\b\u0000;<\u0005?\u0000\u0000"+
		"<>\u0003\u0010\b\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">\u0013\u0001\u0000\u0000\u0000\u0003\u0016.=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}