// Generated from C:/Users/poesd_000/IdeaProjects/Paradigms/src/pp/block2/cc/ll\BoogyQ.g4 by ANTLR 4.5.1
package pp.block2.cc.ll;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoogyQ extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, OPTIONALNUMBER=2, IF=3, BRACKETOPEN=4, BRACKETCLOSE=5, COLON=6, 
		TAB=7, ARROW=8, BIGARROW=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NUMBER", "OPTIONALNUMBER", "IF", "BRACKETOPEN", "BRACKETCLOSE", "COLON", 
		"TAB", "ARROW", "BIGARROW"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'if'", "'('", "')'", "':'", "'\t'", "'->'", "'=>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUMBER", "OPTIONALNUMBER", "IF", "BRACKETOPEN", "BRACKETCLOSE", 
		"COLON", "TAB", "ARROW", "BIGARROW"
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


	public BoogyQ(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BoogyQ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13\61\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\2\2\13\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\3\2\4\3\2\63;\3\2\62;\61\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\36\3\2\2\2\7 \3\2\2\2\t#\3\2\2"+
		"\2\13%\3\2\2\2\r\'\3\2\2\2\17)\3\2\2\2\21+\3\2\2\2\23.\3\2\2\2\25\31\t"+
		"\2\2\2\26\30\t\3\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3"+
		"\2\2\2\32\4\3\2\2\2\33\31\3\2\2\2\34\37\5\3\2\2\36\34\3\2\2\2\36\35\3"+
		"\2\2\2\37\6\3\2\2\2 !\7k\2\2!\"\7h\2\2\"\b\3\2\2\2#$\7*\2\2$\n\3\2\2\2"+
		"%&\7+\2\2&\f\3\2\2\2\'(\7<\2\2(\16\3\2\2\2)*\7\13\2\2*\20\3\2\2\2+,\7"+
		"/\2\2,-\7@\2\2-\22\3\2\2\2./\7?\2\2/\60\7@\2\2\60\24\3\2\2\2\5\2\31\36"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}