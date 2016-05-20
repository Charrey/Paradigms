package homework.pim.exercise2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaDecimal extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DECIMALFLOAT=1, DECIMALDOUBLE=2;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DECIMALFLOAT", "DECIMALDOUBLE", "DECIMALANYTHING", "DECIMALINT", "FSUFFIX", 
		"DSUFFIX"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DECIMALFLOAT", "DECIMALDOUBLE"
	};
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


	public JavaDecimal(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JavaDecimal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\4P\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\3\3\3\5\3#\n\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3,\n\3\5\3.\n\3\3\4\3\4\7\4\62\n\4\f\4\16\4\65\13\4\3"+
		"\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13\5\3\5\7\5"+
		"F\n\5\f\5\16\5I\13\5\5\5K\n\5\3\6\3\6\3\7\3\7\2\2\b\3\3\5\4\7\2\t\2\13"+
		"\2\r\2\3\2\7\4\2GGgg\3\2\62;\3\2\63;\4\2HHhh\4\2FFffV\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\3\34\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\tJ\3\2\2\2\13L\3\2\2\2\rN"+
		"\3\2\2\2\17\20\5\t\5\2\20\21\7\60\2\2\21\22\5\7\4\2\22\23\5\13\6\2\23"+
		"\35\3\2\2\2\24\25\5\t\5\2\25\26\5\13\6\2\26\35\3\2\2\2\27\30\5\t\5\2\30"+
		"\31\t\2\2\2\31\32\5\t\5\2\32\33\5\13\6\2\33\35\3\2\2\2\34\17\3\2\2\2\34"+
		"\24\3\2\2\2\34\27\3\2\2\2\35\4\3\2\2\2\36\37\5\t\5\2\37 \7\60\2\2 \"\5"+
		"\7\4\2!#\5\r\7\2\"!\3\2\2\2\"#\3\2\2\2#.\3\2\2\2$%\5\t\5\2%&\5\r\7\2&"+
		".\3\2\2\2\'(\5\t\5\2()\t\2\2\2)+\5\t\5\2*,\5\r\7\2+*\3\2\2\2+,\3\2\2\2"+
		",.\3\2\2\2-\36\3\2\2\2-$\3\2\2\2-\'\3\2\2\2.\6\3\2\2\2/9\t\3\2\2\60\62"+
		"\7a\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66"+
		"\3\2\2\2\65\63\3\2\2\2\668\t\3\2\2\67\63\3\2\2\28;\3\2\2\29\67\3\2\2\2"+
		"9:\3\2\2\2:\b\3\2\2\2;9\3\2\2\2<K\7\62\2\2=G\t\4\2\2>@\7a\2\2?>\3\2\2"+
		"\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DF\t\3\2\2EA\3\2\2"+
		"\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2\2J<\3\2\2\2J=\3\2\2"+
		"\2K\n\3\2\2\2LM\t\5\2\2M\f\3\2\2\2NO\t\6\2\2O\16\3\2\2\2\f\2\34\"+-\63"+
		"9AGJ\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}