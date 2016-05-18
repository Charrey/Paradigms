// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/tabular\tabularGram.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tabularGramLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STARTTABLE=1, ENDTABLE=2, ARGUMENT=3, BEGIN=4, END=5, ROWSEP=6, COLSEP=7, 
		STRING=8, WS=9, NEWLINE=10, COMMENT=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"STARTTABLE", "ENDTABLE", "ARGUMENT", "BEGIN", "END", "ROWSEP", "COLSEP", 
		"LETTER", "NUMBER", "CHAR", "STRING", "WS", "NEWLINE", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'\\begin{tabular}'", "'\\end{tabular}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STARTTABLE", "ENDTABLE", "ARGUMENT", "BEGIN", "END", "ROWSEP", 
		"COLSEP", "STRING", "WS", "NEWLINE", "COMMENT"
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


	public tabularGramLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "tabularGram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\r\u0084\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\6\3"+
		"&\n\3\r\3\16\3\'\3\4\3\4\6\4,\n\4\r\4\16\4-\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\5\7Q\n\7\3\7\3\7\3\7\3\7\5\7W\n\7"+
		"\3\b\5\bZ\n\b\3\b\3\b\5\b^\n\b\3\t\3\t\3\n\6\nc\n\n\r\n\16\nd\3\13\3\13"+
		"\5\13i\n\13\3\f\6\fl\n\f\r\f\16\fm\3\r\6\rq\n\r\r\r\16\rr\3\16\5\16v\n"+
		"\16\3\16\3\16\3\17\3\17\7\17|\n\17\f\17\16\17\177\13\17\3\17\3\17\3\17"+
		"\3\17\3}\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\n\31\13"+
		"\33\f\35\r\3\2\6\5\2eenntt\4\2C\\c|\3\2\62;\3\2^^\u008c\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5"+
		"#\3\2\2\2\7)\3\2\2\2\t\61\3\2\2\2\13A\3\2\2\2\rP\3\2\2\2\17Y\3\2\2\2\21"+
		"_\3\2\2\2\23b\3\2\2\2\25h\3\2\2\2\27k\3\2\2\2\31p\3\2\2\2\33u\3\2\2\2"+
		"\35y\3\2\2\2\37 \5\t\5\2 !\5\7\4\2!\"\5\33\16\2\"\4\3\2\2\2#%\5\13\6\2"+
		"$&\5\33\16\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\6\3\2\2\2)+\7"+
		"}\2\2*,\t\2\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60"+
		"\7\177\2\2\60\b\3\2\2\2\61\62\7^\2\2\62\63\7d\2\2\63\64\7g\2\2\64\65\7"+
		"i\2\2\65\66\7k\2\2\66\67\7p\2\2\678\7}\2\289\7v\2\29:\7c\2\2:;\7d\2\2"+
		";<\7w\2\2<=\7n\2\2=>\7c\2\2>?\7t\2\2?@\7\177\2\2@\n\3\2\2\2AB\7^\2\2B"+
		"C\7g\2\2CD\7p\2\2DE\7f\2\2EF\7}\2\2FG\7v\2\2GH\7c\2\2HI\7d\2\2IJ\7w\2"+
		"\2JK\7n\2\2KL\7c\2\2LM\7t\2\2MN\7\177\2\2N\f\3\2\2\2OQ\5\31\r\2PO\3\2"+
		"\2\2PQ\3\2\2\2QR\3\2\2\2RS\7^\2\2ST\7^\2\2TV\3\2\2\2UW\5\31\r\2VU\3\2"+
		"\2\2VW\3\2\2\2W\16\3\2\2\2XZ\5\31\r\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[]"+
		"\7(\2\2\\^\5\31\r\2]\\\3\2\2\2]^\3\2\2\2^\20\3\2\2\2_`\t\3\2\2`\22\3\2"+
		"\2\2ac\t\4\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\24\3\2\2\2fi\5"+
		"\21\t\2gi\5\23\n\2hf\3\2\2\2hg\3\2\2\2i\26\3\2\2\2jl\5\25\13\2kj\3\2\2"+
		"\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\30\3\2\2\2oq\7\"\2\2po\3\2\2\2qr\3\2"+
		"\2\2rp\3\2\2\2rs\3\2\2\2s\32\3\2\2\2tv\7\17\2\2ut\3\2\2\2uv\3\2\2\2vw"+
		"\3\2\2\2wx\7\f\2\2x\34\3\2\2\2y}\7\'\2\2z|\n\5\2\2{z\3\2\2\2|\177\3\2"+
		"\2\2}~\3\2\2\2}{\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\5\33"+
		"\16\2\u0081\u0082\3\2\2\2\u0082\u0083\b\17\2\2\u0083\36\3\2\2\2\17\2\'"+
		"-PVY]dhmru}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}