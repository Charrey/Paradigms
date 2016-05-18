// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/tabular\tabularGram.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tabularGramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STARTTABLE=1, ENDTABLE=2, ARGUMENT=3, BEGIN=4, END=5, ROWSEP=6, COLSEP=7, 
		STRING=8, WS=9, NEWLINE=10, COMMENT=11;
	public static final int
		RULE_table = 0, RULE_row = 1, RULE_entry = 2, RULE_lastentry = 3;
	public static final String[] ruleNames = {
		"table", "row", "entry", "lastentry"
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

	@Override
	public String getGrammarFileName() { return "tabularGram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tabularGramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TableContext extends ParserRuleContext {
		public TerminalNode STARTTABLE() { return getToken(tabularGramParser.STARTTABLE, 0); }
		public TerminalNode ENDTABLE() { return getToken(tabularGramParser.ENDTABLE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(tabularGramParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(tabularGramParser.NEWLINE, i);
		}
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tabularGramVisitor ) return ((tabularGramVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(8);
				match(NEWLINE);
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(14);
			match(STARTTABLE);
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(15);
				row();
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ROWSEP) | (1L << COLSEP) | (1L << STRING) | (1L << WS))) != 0) );
			setState(20);
			match(ENDTABLE);
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

	public static class RowContext extends ParserRuleContext {
		public LastentryContext lastentry() {
			return getRuleContext(LastentryContext.class,0);
		}
		public TerminalNode WS() { return getToken(tabularGramParser.WS, 0); }
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).exitRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tabularGramVisitor ) return ((tabularGramVisitor<? extends T>)visitor).visitRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_row);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(22);
				match(WS);
				}
			}

			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(25);
					entry();
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(31);
			lastentry();
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

	public static class EntryContext extends ParserRuleContext {
		public TerminalNode COLSEP() { return getToken(tabularGramParser.COLSEP, 0); }
		public TerminalNode STRING() { return getToken(tabularGramParser.STRING, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(tabularGramParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(tabularGramParser.NEWLINE, i);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).exitEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tabularGramVisitor ) return ((tabularGramVisitor<? extends T>)visitor).visitEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(33);
				match(STRING);
				}
			}

			setState(36);
			match(COLSEP);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(37);
				match(NEWLINE);
				}
				}
				setState(42);
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

	public static class LastentryContext extends ParserRuleContext {
		public TerminalNode ROWSEP() { return getToken(tabularGramParser.ROWSEP, 0); }
		public TerminalNode STRING() { return getToken(tabularGramParser.STRING, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(tabularGramParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(tabularGramParser.NEWLINE, i);
		}
		public LastentryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastentry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).enterLastentry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tabularGramListener ) ((tabularGramListener)listener).exitLastentry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tabularGramVisitor ) return ((tabularGramVisitor<? extends T>)visitor).visitLastentry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastentryContext lastentry() throws RecognitionException {
		LastentryContext _localctx = new LastentryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lastentry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(43);
				match(STRING);
				}
			}

			setState(46);
			match(ROWSEP);
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47);
				match(NEWLINE);
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\67\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\3\2\6\2\23\n\2"+
		"\r\2\16\2\24\3\2\3\2\3\3\5\3\32\n\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3"+
		"\3\3\3\4\5\4%\n\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\5\5\5/\n\5\3\5\3\5"+
		"\6\5\63\n\5\r\5\16\5\64\3\5\2\2\6\2\4\6\b\2\2:\2\r\3\2\2\2\4\31\3\2\2"+
		"\2\6$\3\2\2\2\b.\3\2\2\2\n\f\7\f\2\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3"+
		"\2\2\2\r\16\3\2\2\2\16\20\3\2\2\2\17\r\3\2\2\2\20\22\7\3\2\2\21\23\5\4"+
		"\3\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\26\3\2"+
		"\2\2\26\27\7\4\2\2\27\3\3\2\2\2\30\32\7\13\2\2\31\30\3\2\2\2\31\32\3\2"+
		"\2\2\32\36\3\2\2\2\33\35\5\6\4\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2"+
		"\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\5\b\5\2\"\5\3\2\2\2#%\7\n"+
		"\2\2$#\3\2\2\2$%\3\2\2\2%&\3\2\2\2&*\7\t\2\2\')\7\f\2\2(\'\3\2\2\2),\3"+
		"\2\2\2*(\3\2\2\2*+\3\2\2\2+\7\3\2\2\2,*\3\2\2\2-/\7\n\2\2.-\3\2\2\2./"+
		"\3\2\2\2/\60\3\2\2\2\60\62\7\b\2\2\61\63\7\f\2\2\62\61\3\2\2\2\63\64\3"+
		"\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\t\3\2\2\2\n\r\24\31\36$*.\64";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}