// Generated from java-escape by ANTLR 4.11.1

    package the.grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TheLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HELLO=1, WORLD=2, WS=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"HELLO", "WORLD", "WS", "A", "B", "C", "D", "E", "F", "G", "H", "I", 
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
			"X", "Y", "Z"
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
			null, "HELLO", "WORLD", "WS"
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


	public TheLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TheLexer.g4"; }

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
		"\u0004\u0000\u0003\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0000\t\u0000\u000b\u0000\r\u0000\u000f\u0000\u0011"+
		"\u0000\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d"+
		"\u0000\u001f\u0000!\u0000#\u0000%\u0000\'\u0000)\u0000+\u0000-\u0000/"+
		"\u00001\u00003\u00005\u00007\u00009\u0000\u0001\u0000\u001b\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000AAaa\u0002\u0000BBbb\u0002\u0000CCcc\u0002\u0000"+
		"DDdd\u0002\u0000EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002\u0000HHhh\u0002"+
		"\u0000IIii\u0002\u0000JJjj\u0002\u0000KKkk\u0002\u0000LLll\u0002\u0000"+
		"MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000QQqq\u0002"+
		"\u0000RRrr\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000"+
		"VVvv\u0002\u0000WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002\u0000ZZzzd"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000\u0000\u0003"+
		"A\u0001\u0000\u0000\u0000\u0005G\u0001\u0000\u0000\u0000\u0007K\u0001"+
		"\u0000\u0000\u0000\tM\u0001\u0000\u0000\u0000\u000bO\u0001\u0000\u0000"+
		"\u0000\rQ\u0001\u0000\u0000\u0000\u000fS\u0001\u0000\u0000\u0000\u0011"+
		"U\u0001\u0000\u0000\u0000\u0013W\u0001\u0000\u0000\u0000\u0015Y\u0001"+
		"\u0000\u0000\u0000\u0017[\u0001\u0000\u0000\u0000\u0019]\u0001\u0000\u0000"+
		"\u0000\u001b_\u0001\u0000\u0000\u0000\u001da\u0001\u0000\u0000\u0000\u001f"+
		"c\u0001\u0000\u0000\u0000!e\u0001\u0000\u0000\u0000#g\u0001\u0000\u0000"+
		"\u0000%i\u0001\u0000\u0000\u0000\'k\u0001\u0000\u0000\u0000)m\u0001\u0000"+
		"\u0000\u0000+o\u0001\u0000\u0000\u0000-q\u0001\u0000\u0000\u0000/s\u0001"+
		"\u0000\u0000\u00001u\u0001\u0000\u0000\u00003w\u0001\u0000\u0000\u0000"+
		"5y\u0001\u0000\u0000\u00007{\u0001\u0000\u0000\u00009}\u0001\u0000\u0000"+
		"\u0000;<\u0003\u0015\n\u0000<=\u0003\u000f\u0007\u0000=>\u0003\u001d\u000e"+
		"\u0000>?\u0003\u001d\u000e\u0000?@\u0003#\u0011\u0000@\u0002\u0001\u0000"+
		"\u0000\u0000AB\u00033\u0019\u0000BC\u0003#\u0011\u0000CD\u0003)\u0014"+
		"\u0000DE\u0003\u001d\u000e\u0000EF\u0003\r\u0006\u0000F\u0004\u0001\u0000"+
		"\u0000\u0000GH\u0007\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0006"+
		"\u0002\u0000\u0000J\u0006\u0001\u0000\u0000\u0000KL\u0007\u0001\u0000"+
		"\u0000L\b\u0001\u0000\u0000\u0000MN\u0007\u0002\u0000\u0000N\n\u0001\u0000"+
		"\u0000\u0000OP\u0007\u0003\u0000\u0000P\f\u0001\u0000\u0000\u0000QR\u0007"+
		"\u0004\u0000\u0000R\u000e\u0001\u0000\u0000\u0000ST\u0007\u0005\u0000"+
		"\u0000T\u0010\u0001\u0000\u0000\u0000UV\u0007\u0006\u0000\u0000V\u0012"+
		"\u0001\u0000\u0000\u0000WX\u0007\u0007\u0000\u0000X\u0014\u0001\u0000"+
		"\u0000\u0000YZ\u0007\b\u0000\u0000Z\u0016\u0001\u0000\u0000\u0000[\\\u0007"+
		"\t\u0000\u0000\\\u0018\u0001\u0000\u0000\u0000]^\u0007\n\u0000\u0000^"+
		"\u001a\u0001\u0000\u0000\u0000_`\u0007\u000b\u0000\u0000`\u001c\u0001"+
		"\u0000\u0000\u0000ab\u0007\f\u0000\u0000b\u001e\u0001\u0000\u0000\u0000"+
		"cd\u0007\r\u0000\u0000d \u0001\u0000\u0000\u0000ef\u0007\u000e\u0000\u0000"+
		"f\"\u0001\u0000\u0000\u0000gh\u0007\u000f\u0000\u0000h$\u0001\u0000\u0000"+
		"\u0000ij\u0007\u0010\u0000\u0000j&\u0001\u0000\u0000\u0000kl\u0007\u0011"+
		"\u0000\u0000l(\u0001\u0000\u0000\u0000mn\u0007\u0012\u0000\u0000n*\u0001"+
		"\u0000\u0000\u0000op\u0007\u0013\u0000\u0000p,\u0001\u0000\u0000\u0000"+
		"qr\u0007\u0014\u0000\u0000r.\u0001\u0000\u0000\u0000st\u0007\u0015\u0000"+
		"\u0000t0\u0001\u0000\u0000\u0000uv\u0007\u0016\u0000\u0000v2\u0001\u0000"+
		"\u0000\u0000wx\u0007\u0017\u0000\u0000x4\u0001\u0000\u0000\u0000yz\u0007"+
		"\u0018\u0000\u0000z6\u0001\u0000\u0000\u0000{|\u0007\u0019\u0000\u0000"+
		"|8\u0001\u0000\u0000\u0000}~\u0007\u001a\u0000\u0000~:\u0001\u0000\u0000"+
		"\u0000\u0001\u0000\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}