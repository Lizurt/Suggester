// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoGrammar.g4 by ANTLR 4.10.1

    package com.example.arangui.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArangoGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR_STATEMENTS=1, RETURN_STATEMENT=2, TABLE_NAME=3, KEYS_AND_VALS=4, KEY_AND_VAL=5, 
		ANY_VAL=6, NUM_VAL=7, STR_VAL=8, ANY_WORD=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FOR_STATEMENTS", "RETURN_STATEMENT", "TABLE_NAME", "KEYS_AND_VALS", 
			"KEY_AND_VAL", "ANY_VAL", "NUM_VAL", "STR_VAL", "IN", "FOR", "INSERT", 
			"INTO", "DOT", "MINUS", "COLON", "COMMA", "L_CUR_BR", "R_CUR_BR", "QUOTE", 
			"ANY_WORD", "WS", "AL_NUM", "CHAR", "NUMS", "NUM", "ANY_TEXT"
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
			null, "FOR_STATEMENTS", "RETURN_STATEMENT", "TABLE_NAME", "KEYS_AND_VALS", 
			"KEY_AND_VAL", "ANY_VAL", "NUM_VAL", "STR_VAL", "ANY_WORD", "WS"
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


	public ArangoGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ArangoGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\n\u009a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0003\u0001:\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003D\b\u0003\n\u0003\f\u0003G\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005O\b\u0005\u0001"+
		"\u0006\u0003\u0006R\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006X\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013\u0080"+
		"\b\u0013\u000b\u0013\f\u0013\u0081\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u008a\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0004\u0017\u008f\b\u0017\u000b\u0017\f\u0017"+
		"\u0090\u0001\u0018\u0001\u0018\u0001\u0019\u0005\u0019\u0096\b\u0019\n"+
		"\u0019\f\u0019\u0099\t\u0019\u0001\u0097\u0000\u001a\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\u0000\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d"+
		"\u0000\u001f\u0000!\u0000#\u0000%\u0000\'\t)\n+\u0000-\u0000/\u00001\u0000"+
		"3\u0000\u0001\u0000\u0003\u0003\u0000\t\n\r\r  \u0002\u0000AZaz\u0001"+
		"\u000009\u0092\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0001"+
		"5\u0001\u0000\u0000\u0000\u00037\u0001\u0000\u0000\u0000\u0005=\u0001"+
		"\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\tH\u0001\u0000\u0000"+
		"\u0000\u000bN\u0001\u0000\u0000\u0000\rQ\u0001\u0000\u0000\u0000\u000f"+
		"Y\u0001\u0000\u0000\u0000\u0011]\u0001\u0000\u0000\u0000\u0013`\u0001"+
		"\u0000\u0000\u0000\u0015d\u0001\u0000\u0000\u0000\u0017k\u0001\u0000\u0000"+
		"\u0000\u0019p\u0001\u0000\u0000\u0000\u001br\u0001\u0000\u0000\u0000\u001d"+
		"t\u0001\u0000\u0000\u0000\u001fv\u0001\u0000\u0000\u0000!x\u0001\u0000"+
		"\u0000\u0000#z\u0001\u0000\u0000\u0000%|\u0001\u0000\u0000\u0000\'\u007f"+
		"\u0001\u0000\u0000\u0000)\u0083\u0001\u0000\u0000\u0000+\u0089\u0001\u0000"+
		"\u0000\u0000-\u008b\u0001\u0000\u0000\u0000/\u008e\u0001\u0000\u0000\u0000"+
		"1\u0092\u0001\u0000\u0000\u00003\u0097\u0001\u0000\u0000\u000056\u0003"+
		"\u0003\u0001\u00006\u0002\u0001\u0000\u0000\u000079\u0003\'\u0013\u0000"+
		"8:\u0003\u0019\f\u000098\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;<\u0003\'\u0013\u0000<\u0004\u0001\u0000\u0000"+
		"\u0000=>\u0003\'\u0013\u0000>\u0006\u0001\u0000\u0000\u0000?E\u0003\'"+
		"\u0013\u0000@A\u0003\u001f\u000f\u0000AB\u0003\'\u0013\u0000BD\u0001\u0000"+
		"\u0000\u0000C@\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\b\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000HI\u0003\'\u0013\u0000IJ\u0003\u001d\u000e\u0000"+
		"JK\u0003\u000b\u0005\u0000K\n\u0001\u0000\u0000\u0000LO\u0003\u000f\u0007"+
		"\u0000MO\u0003\r\u0006\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000"+
		"\u0000O\f\u0001\u0000\u0000\u0000PR\u0003\u001b\r\u0000QP\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SW\u0003"+
		"/\u0017\u0000TU\u0003\u0019\f\u0000UV\u0003/\u0017\u0000VX\u0001\u0000"+
		"\u0000\u0000WT\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X\u000e"+
		"\u0001\u0000\u0000\u0000YZ\u0003%\u0012\u0000Z[\u00033\u0019\u0000[\\"+
		"\u0003%\u0012\u0000\\\u0010\u0001\u0000\u0000\u0000]^\u0005I\u0000\u0000"+
		"^_\u0005N\u0000\u0000_\u0012\u0001\u0000\u0000\u0000`a\u0005F\u0000\u0000"+
		"ab\u0005O\u0000\u0000bc\u0005R\u0000\u0000c\u0014\u0001\u0000\u0000\u0000"+
		"de\u0005I\u0000\u0000ef\u0005N\u0000\u0000fg\u0005S\u0000\u0000gh\u0005"+
		"E\u0000\u0000hi\u0005R\u0000\u0000ij\u0005T\u0000\u0000j\u0016\u0001\u0000"+
		"\u0000\u0000kl\u0005I\u0000\u0000lm\u0005N\u0000\u0000mn\u0005T\u0000"+
		"\u0000no\u0005O\u0000\u0000o\u0018\u0001\u0000\u0000\u0000pq\u0005.\u0000"+
		"\u0000q\u001a\u0001\u0000\u0000\u0000rs\u0005-\u0000\u0000s\u001c\u0001"+
		"\u0000\u0000\u0000tu\u0005:\u0000\u0000u\u001e\u0001\u0000\u0000\u0000"+
		"vw\u0005,\u0000\u0000w \u0001\u0000\u0000\u0000xy\u0005{\u0000\u0000y"+
		"\"\u0001\u0000\u0000\u0000z{\u0005}\u0000\u0000{$\u0001\u0000\u0000\u0000"+
		"|}\u0005\"\u0000\u0000}&\u0001\u0000\u0000\u0000~\u0080\u0003+\u0015\u0000"+
		"\u007f~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"(\u0001\u0000\u0000\u0000\u0083\u0084\u0007\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0006\u0014\u0000\u0000\u0086*\u0001"+
		"\u0000\u0000\u0000\u0087\u008a\u0003-\u0016\u0000\u0088\u008a\u00031\u0018"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a,\u0001\u0000\u0000\u0000\u008b\u008c\u0007\u0001\u0000\u0000"+
		"\u008c.\u0001\u0000\u0000\u0000\u008d\u008f\u00031\u0018\u0000\u008e\u008d"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u00910\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0007\u0002\u0000\u0000\u00932\u0001\u0000"+
		"\u0000\u0000\u0094\u0096\t\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000"+
		"\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u00984\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\n\u00009ENQW\u0081\u0089\u0090\u0097"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}