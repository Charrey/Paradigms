// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/homework/hans/excercice5\Emote.g4 by ANTLR 4.5.1
package homework.code.excercice5;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EmoteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, WORD=4, EXCL=5, WS=6;
	public static final int
		RULE_text = 0, RULE_item = 1;
	public static final String[] ruleNames = {
		"text", "item"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "WORD", "EXCL", "WS"
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
	public String getGrammarFileName() { return "Emote.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EmoteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TextContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EmoteParser.EOF, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoteVisitor ) return ((EmoteVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << WORD))) != 0)) {
				{
				{
				setState(4);
				item();
				}
				}
				setState(9);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(10);
			match(EOF);
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

	public static class ItemContext extends ParserRuleContext {
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	 
		public ItemContext() { }
		public void copyFrom(ItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WordItemContext extends ItemContext {
		public TerminalNode WORD() { return getToken(EmoteParser.WORD, 0); }
		public TerminalNode EXCL() { return getToken(EmoteParser.EXCL, 0); }
		public WordItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).enterWordItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).exitWordItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoteVisitor ) return ((EmoteVisitor<? extends T>)visitor).visitWordItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RaiseItemContext extends ItemContext {
		public TerminalNode WORD() { return getToken(EmoteParser.WORD, 0); }
		public RaiseItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).enterRaiseItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).exitRaiseItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoteVisitor ) return ((EmoteVisitor<? extends T>)visitor).visitRaiseItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextItemContext extends ItemContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TextItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).enterTextItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoteListener ) ((EmoteListener)listener).exitTextItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoteVisitor ) return ((EmoteVisitor<? extends T>)visitor).visitTextItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_item);
		int _la;
		try {
			setState(26);
			switch (_input.LA(1)) {
			case WORD:
				_localctx = new WordItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				match(WORD);
				setState(14);
				_la = _input.LA(1);
				if (_la==EXCL) {
					{
					setState(13);
					match(EXCL);
					}
				}

				}
				break;
			case T__0:
				_localctx = new TextItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				match(T__0);
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << WORD))) != 0)) {
					{
					{
					setState(17);
					item();
					}
					}
					setState(22);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(23);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new RaiseItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				match(T__2);
				setState(25);
				match(WORD);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\37\4\2\t\2\4\3"+
		"\t\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\2\3\2\3\3\3\3\5\3\21\n\3\3\3\3\3"+
		"\7\3\25\n\3\f\3\16\3\30\13\3\3\3\3\3\3\3\5\3\35\n\3\3\3\2\2\4\2\4\2\2"+
		"!\2\t\3\2\2\2\4\34\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\13\3\2\2\2\t\7\3"+
		"\2\2\2\t\n\3\2\2\2\n\f\3\2\2\2\13\t\3\2\2\2\f\r\7\2\2\3\r\3\3\2\2\2\16"+
		"\20\7\6\2\2\17\21\7\7\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\35\3\2\2\2\22"+
		"\26\7\3\2\2\23\25\5\4\3\2\24\23\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26"+
		"\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31\35\7\4\2\2\32\33\7\5\2\2\33"+
		"\35\7\6\2\2\34\16\3\2\2\2\34\22\3\2\2\2\34\32\3\2\2\2\35\5\3\2\2\2\6\t"+
		"\20\26\34";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}