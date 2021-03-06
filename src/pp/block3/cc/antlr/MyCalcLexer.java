// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/antlr\MyCalc.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyCalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HAT=1, TIMES=2, PLUS=3, EQUALS=4, MINUS=5, LPAR=6, RPAR=7, NUMBER=8, BOOL=9, 
		STRING=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"HAT", "TIMES", "PLUS", "EQUALS", "MINUS", "LPAR", "RPAR", "NUMBER", "BOOL", 
		"STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'^'", "'*'", "'+'", "'=='", "'-'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HAT", "TIMES", "PLUS", "EQUALS", "MINUS", "LPAR", "RPAR", "NUMBER", 
		"BOOL", "STRING", "WS"
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


	public MyCalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rE\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\6\t*\n\t\r\t\16\t+\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\67\n"+
		"\n\3\13\3\13\7\13;\n\13\f\13\16\13>\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"<\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\4\3\2\62"+
		";\5\2\13\f\17\17\"\"G\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37\3\2"+
		"\2\2\13\"\3\2\2\2\r$\3\2\2\2\17&\3\2\2\2\21)\3\2\2\2\23\66\3\2\2\2\25"+
		"8\3\2\2\2\27A\3\2\2\2\31\32\7`\2\2\32\4\3\2\2\2\33\34\7,\2\2\34\6\3\2"+
		"\2\2\35\36\7-\2\2\36\b\3\2\2\2\37 \7?\2\2 !\7?\2\2!\n\3\2\2\2\"#\7/\2"+
		"\2#\f\3\2\2\2$%\7*\2\2%\16\3\2\2\2&\'\7+\2\2\'\20\3\2\2\2(*\t\2\2\2)("+
		"\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\22\3\2\2\2-.\7V\2\2./\7t\2\2/"+
		"\60\7w\2\2\60\67\7g\2\2\61\62\7H\2\2\62\63\7c\2\2\63\64\7n\2\2\64\65\7"+
		"u\2\2\65\67\7g\2\2\66-\3\2\2\2\66\61\3\2\2\2\67\24\3\2\2\28<\7$\2\29;"+
		"\13\2\2\2:9\3\2\2\2;>\3\2\2\2<=\3\2\2\2<:\3\2\2\2=?\3\2\2\2><\3\2\2\2"+
		"?@\7$\2\2@\26\3\2\2\2AB\t\3\2\2BC\3\2\2\2CD\b\f\2\2D\30\3\2\2\2\6\2+\66"+
		"<\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}