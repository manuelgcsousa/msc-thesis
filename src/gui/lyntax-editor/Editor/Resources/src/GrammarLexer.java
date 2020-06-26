// Generated from src/Grammar.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, WS=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WORD", "WS", "CHAR", "COMMENT"
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
			null, "WORD", "WS"
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




	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\4.\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\6\2\r\n\2\r\2\16\2\16\3\3\3\3\5\3\23\n\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5\35\n\5\f\5\16\5 \13\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5(\n\5\f\5\16\5+\13\5\5\5-\n\5\3\36\2\6\3\3\5\4\7\2\t\2\3"+
		"\2\5\5\2\13\f\17\17\"\"\17\2C\\aac|\u00c2\u00c5\u00c9\u00cc\u00ce\u00d0"+
		"\u00d4\u00d7\u00db\u00dd\u00e2\u00e5\u00e9\u00ec\u00ee\u00f0\u00f4\u00f7"+
		"\u00fb\u00fd\4\2\f\f\17\17\2\60\2\3\3\2\2\2\2\5\3\2\2\2\3\f\3\2\2\2\5"+
		"\22\3\2\2\2\7\26\3\2\2\2\t,\3\2\2\2\13\r\5\7\4\2\f\13\3\2\2\2\r\16\3\2"+
		"\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\4\3\2\2\2\20\23\t\2\2\2\21\23\5\t\5"+
		"\2\22\20\3\2\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24\25\b\3\2\2\25\6\3\2\2"+
		"\2\26\27\t\3\2\2\27\b\3\2\2\2\30\31\7\61\2\2\31\32\7,\2\2\32\36\3\2\2"+
		"\2\33\35\13\2\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\37\3\2\2\2\36\34\3\2\2"+
		"\2\37!\3\2\2\2 \36\3\2\2\2!\"\7,\2\2\"-\7\61\2\2#$\7\61\2\2$%\7\61\2\2"+
		"%)\3\2\2\2&(\n\4\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*-\3\2\2"+
		"\2+)\3\2\2\2,\30\3\2\2\2,#\3\2\2\2-\n\3\2\2\2\b\2\16\22\36),\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}