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
		HELLO=1, HARD=2, WORLD=3, LIZURT=4, WORK=5, WS=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"HELLO", "HARD", "WORLD", "LIZURT", "WORK", "WS", "A", "B", "C", "D", 
			"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
			"S", "T", "U", "V", "W", "X", "Y", "Z"
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
			null, "HELLO", "HARD", "WORLD", "LIZURT", "WORK", "WS"
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
		"\u0004\u0000\u0006\u0096\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0000\u0000 \u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0000\u000f\u0000\u0011\u0000\u0013\u0000"+
		"\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u0000\u001f\u0000"+
		"!\u0000#\u0000%\u0000\'\u0000)\u0000+\u0000-\u0000/\u00001\u00003\u0000"+
		"5\u00007\u00009\u0000;\u0000=\u0000?\u0000\u0001\u0000\u001b\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000AAaa\u0002\u0000BBbb\u0002\u0000CCcc\u0002\u0000"+
		"DDdd\u0002\u0000EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002\u0000HHhh\u0002"+
		"\u0000IIii\u0002\u0000JJjj\u0002\u0000KKkk\u0002\u0000LLll\u0002\u0000"+
		"MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000QQqq\u0002"+
		"\u0000RRrr\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000"+
		"VVvv\u0002\u0000WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002\u0000ZZzz{"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0001"+
		"A\u0001\u0000\u0000\u0000\u0003G\u0001\u0000\u0000\u0000\u0005L\u0001"+
		"\u0000\u0000\u0000\u0007R\u0001\u0000\u0000\u0000\tY\u0001\u0000\u0000"+
		"\u0000\u000b^\u0001\u0000\u0000\u0000\rb\u0001\u0000\u0000\u0000\u000f"+
		"d\u0001\u0000\u0000\u0000\u0011f\u0001\u0000\u0000\u0000\u0013h\u0001"+
		"\u0000\u0000\u0000\u0015j\u0001\u0000\u0000\u0000\u0017l\u0001\u0000\u0000"+
		"\u0000\u0019n\u0001\u0000\u0000\u0000\u001bp\u0001\u0000\u0000\u0000\u001d"+
		"r\u0001\u0000\u0000\u0000\u001ft\u0001\u0000\u0000\u0000!v\u0001\u0000"+
		"\u0000\u0000#x\u0001\u0000\u0000\u0000%z\u0001\u0000\u0000\u0000\'|\u0001"+
		"\u0000\u0000\u0000)~\u0001\u0000\u0000\u0000+\u0080\u0001\u0000\u0000"+
		"\u0000-\u0082\u0001\u0000\u0000\u0000/\u0084\u0001\u0000\u0000\u00001"+
		"\u0086\u0001\u0000\u0000\u00003\u0088\u0001\u0000\u0000\u00005\u008a\u0001"+
		"\u0000\u0000\u00007\u008c\u0001\u0000\u0000\u00009\u008e\u0001\u0000\u0000"+
		"\u0000;\u0090\u0001\u0000\u0000\u0000=\u0092\u0001\u0000\u0000\u0000?"+
		"\u0094\u0001\u0000\u0000\u0000AB\u0003\u001b\r\u0000BC\u0003\u0015\n\u0000"+
		"CD\u0003#\u0011\u0000DE\u0003#\u0011\u0000EF\u0003)\u0014\u0000F\u0002"+
		"\u0001\u0000\u0000\u0000GH\u0003\u001b\r\u0000HI\u0003\r\u0006\u0000I"+
		"J\u0003/\u0017\u0000JK\u0003\u0013\t\u0000K\u0004\u0001\u0000\u0000\u0000"+
		"LM\u00039\u001c\u0000MN\u0003)\u0014\u0000NO\u0003/\u0017\u0000OP\u0003"+
		"#\u0011\u0000PQ\u0003\u0013\t\u0000Q\u0006\u0001\u0000\u0000\u0000RS\u0003"+
		"#\u0011\u0000ST\u0003\u001d\u000e\u0000TU\u0003?\u001f\u0000UV\u00035"+
		"\u001a\u0000VW\u0003/\u0017\u0000WX\u00033\u0019\u0000X\b\u0001\u0000"+
		"\u0000\u0000YZ\u00039\u001c\u0000Z[\u0003)\u0014\u0000[\\\u0003/\u0017"+
		"\u0000\\]\u0003!\u0010\u0000]\n\u0001\u0000\u0000\u0000^_\u0007\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0006\u0005\u0000\u0000a\f\u0001"+
		"\u0000\u0000\u0000bc\u0007\u0001\u0000\u0000c\u000e\u0001\u0000\u0000"+
		"\u0000de\u0007\u0002\u0000\u0000e\u0010\u0001\u0000\u0000\u0000fg\u0007"+
		"\u0003\u0000\u0000g\u0012\u0001\u0000\u0000\u0000hi\u0007\u0004\u0000"+
		"\u0000i\u0014\u0001\u0000\u0000\u0000jk\u0007\u0005\u0000\u0000k\u0016"+
		"\u0001\u0000\u0000\u0000lm\u0007\u0006\u0000\u0000m\u0018\u0001\u0000"+
		"\u0000\u0000no\u0007\u0007\u0000\u0000o\u001a\u0001\u0000\u0000\u0000"+
		"pq\u0007\b\u0000\u0000q\u001c\u0001\u0000\u0000\u0000rs\u0007\t\u0000"+
		"\u0000s\u001e\u0001\u0000\u0000\u0000tu\u0007\n\u0000\u0000u \u0001\u0000"+
		"\u0000\u0000vw\u0007\u000b\u0000\u0000w\"\u0001\u0000\u0000\u0000xy\u0007"+
		"\f\u0000\u0000y$\u0001\u0000\u0000\u0000z{\u0007\r\u0000\u0000{&\u0001"+
		"\u0000\u0000\u0000|}\u0007\u000e\u0000\u0000}(\u0001\u0000\u0000\u0000"+
		"~\u007f\u0007\u000f\u0000\u0000\u007f*\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0007\u0010\u0000\u0000\u0081,\u0001\u0000\u0000\u0000\u0082\u0083\u0007"+
		"\u0011\u0000\u0000\u0083.\u0001\u0000\u0000\u0000\u0084\u0085\u0007\u0012"+
		"\u0000\u0000\u00850\u0001\u0000\u0000\u0000\u0086\u0087\u0007\u0013\u0000"+
		"\u0000\u00872\u0001\u0000\u0000\u0000\u0088\u0089\u0007\u0014\u0000\u0000"+
		"\u00894\u0001\u0000\u0000\u0000\u008a\u008b\u0007\u0015\u0000\u0000\u008b"+
		"6\u0001\u0000\u0000\u0000\u008c\u008d\u0007\u0016\u0000\u0000\u008d8\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0007\u0017\u0000\u0000\u008f:\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0007\u0018\u0000\u0000\u0091<\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0007\u0019\u0000\u0000\u0093>\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0007\u001a\u0000\u0000\u0095@\u0001\u0000\u0000\u0000\u0001"+
		"\u0000\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}