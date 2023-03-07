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
		IDENTIFIER=1, IDENTIFIER_START=2, IDENTIFIER_PART=3, WS=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENTIFIER", "IDENTIFIER_START", "IDENTIFIER_PART", "WS", "A", "B", 
			"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
			null, "IDENTIFIER", "IDENTIFIER_START", "IDENTIFIER_PART", "WS"
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
		"\u0004\u0000\u0004\u0082\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0005\u0000@\b\u0000\n\u0000\f\u0000C\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002I\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0000\u0000\u001e"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0000\u000b\u0000\r"+
		"\u0000\u000f\u0000\u0011\u0000\u0013\u0000\u0015\u0000\u0017\u0000\u0019"+
		"\u0000\u001b\u0000\u001d\u0000\u001f\u0000!\u0000#\u0000%\u0000\'\u0000"+
		")\u0000+\u0000-\u0000/\u00001\u00003\u00005\u00007\u00009\u0000;\u0000"+
		"\u0001\u0000\u001d\u0001\u0000AZ\u0001\u0000az\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000AAaa\u0002\u0000BBbb\u0002\u0000CCcc\u0002\u0000DDdd\u0002\u0000"+
		"EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002\u0000HHhh\u0002\u0000IIii\u0002"+
		"\u0000JJjj\u0002\u0000KKkk\u0002\u0000LLll\u0002\u0000MMmm\u0002\u0000"+
		"NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000QQqq\u0002\u0000RRrr\u0002"+
		"\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000VVvv\u0002\u0000"+
		"WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002\u0000ZZzzi\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0001=\u0001\u0000"+
		"\u0000\u0000\u0003D\u0001\u0000\u0000\u0000\u0005H\u0001\u0000\u0000\u0000"+
		"\u0007J\u0001\u0000\u0000\u0000\tN\u0001\u0000\u0000\u0000\u000bP\u0001"+
		"\u0000\u0000\u0000\rR\u0001\u0000\u0000\u0000\u000fT\u0001\u0000\u0000"+
		"\u0000\u0011V\u0001\u0000\u0000\u0000\u0013X\u0001\u0000\u0000\u0000\u0015"+
		"Z\u0001\u0000\u0000\u0000\u0017\\\u0001\u0000\u0000\u0000\u0019^\u0001"+
		"\u0000\u0000\u0000\u001b`\u0001\u0000\u0000\u0000\u001db\u0001\u0000\u0000"+
		"\u0000\u001fd\u0001\u0000\u0000\u0000!f\u0001\u0000\u0000\u0000#h\u0001"+
		"\u0000\u0000\u0000%j\u0001\u0000\u0000\u0000\'l\u0001\u0000\u0000\u0000"+
		")n\u0001\u0000\u0000\u0000+p\u0001\u0000\u0000\u0000-r\u0001\u0000\u0000"+
		"\u0000/t\u0001\u0000\u0000\u00001v\u0001\u0000\u0000\u00003x\u0001\u0000"+
		"\u0000\u00005z\u0001\u0000\u0000\u00007|\u0001\u0000\u0000\u00009~\u0001"+
		"\u0000\u0000\u0000;\u0080\u0001\u0000\u0000\u0000=A\u0003\u0003\u0001"+
		"\u0000>@\u0003\u0005\u0002\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\u0002"+
		"\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0007\u0000\u0000"+
		"\u0000E\u0004\u0001\u0000\u0000\u0000FI\u0003\u0003\u0001\u0000GI\u0007"+
		"\u0001\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000"+
		"I\u0006\u0001\u0000\u0000\u0000JK\u0007\u0002\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000LM\u0006\u0003\u0000\u0000M\b\u0001\u0000\u0000\u0000NO\u0007"+
		"\u0003\u0000\u0000O\n\u0001\u0000\u0000\u0000PQ\u0007\u0004\u0000\u0000"+
		"Q\f\u0001\u0000\u0000\u0000RS\u0007\u0005\u0000\u0000S\u000e\u0001\u0000"+
		"\u0000\u0000TU\u0007\u0006\u0000\u0000U\u0010\u0001\u0000\u0000\u0000"+
		"VW\u0007\u0007\u0000\u0000W\u0012\u0001\u0000\u0000\u0000XY\u0007\b\u0000"+
		"\u0000Y\u0014\u0001\u0000\u0000\u0000Z[\u0007\t\u0000\u0000[\u0016\u0001"+
		"\u0000\u0000\u0000\\]\u0007\n\u0000\u0000]\u0018\u0001\u0000\u0000\u0000"+
		"^_\u0007\u000b\u0000\u0000_\u001a\u0001\u0000\u0000\u0000`a\u0007\f\u0000"+
		"\u0000a\u001c\u0001\u0000\u0000\u0000bc\u0007\r\u0000\u0000c\u001e\u0001"+
		"\u0000\u0000\u0000de\u0007\u000e\u0000\u0000e \u0001\u0000\u0000\u0000"+
		"fg\u0007\u000f\u0000\u0000g\"\u0001\u0000\u0000\u0000hi\u0007\u0010\u0000"+
		"\u0000i$\u0001\u0000\u0000\u0000jk\u0007\u0011\u0000\u0000k&\u0001\u0000"+
		"\u0000\u0000lm\u0007\u0012\u0000\u0000m(\u0001\u0000\u0000\u0000no\u0007"+
		"\u0013\u0000\u0000o*\u0001\u0000\u0000\u0000pq\u0007\u0014\u0000\u0000"+
		"q,\u0001\u0000\u0000\u0000rs\u0007\u0015\u0000\u0000s.\u0001\u0000\u0000"+
		"\u0000tu\u0007\u0016\u0000\u0000u0\u0001\u0000\u0000\u0000vw\u0007\u0017"+
		"\u0000\u0000w2\u0001\u0000\u0000\u0000xy\u0007\u0018\u0000\u0000y4\u0001"+
		"\u0000\u0000\u0000z{\u0007\u0019\u0000\u0000{6\u0001\u0000\u0000\u0000"+
		"|}\u0007\u001a\u0000\u0000}8\u0001\u0000\u0000\u0000~\u007f\u0007\u001b"+
		"\u0000\u0000\u007f:\u0001\u0000\u0000\u0000\u0080\u0081\u0007\u001c\u0000"+
		"\u0000\u0081<\u0001\u0000\u0000\u0000\u0003\u0000AH\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}