// Generated from C:/Users/poesd_000/IdeaProjects/Paradigms/src/homework/pim/exercise4\Number.g4 by ANTLR 4.5.1
package homework.pim.exercise4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NumberParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, DIGIT=3;
	public static final int
		RULE_num = 0, RULE_seq = 1, RULE_prf = 2, RULE_dig = 3;
	public static final String[] ruleNames = {
		"num", "seq", "prf", "dig"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'x'", "'b'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "DIGIT"
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
	public String getGrammarFileName() { return "Number.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NumberParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NumContext extends ParserRuleContext {
		public int val;
		public PrfContext a1;
		public SeqContext a2;
		public SeqContext a3;
		public PrfContext prf() {
			return getRuleContext(PrfContext.class,0);
		}
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NumberVisitor ) return ((NumberVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_num);
		try {
			setState(15);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				((NumContext)_localctx).a1 = prf();
				setState(9);
				((NumContext)_localctx).a2 = seq(((NumContext)_localctx).a1.type);

				        ((NumContext)_localctx).val =  ((NumContext)_localctx).a2.val;
				    
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				((NumContext)_localctx).a3 = seq(10);

				        ((NumContext)_localctx).val =  ((NumContext)_localctx).a3.val;
				    
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

	public static class SeqContext extends ParserRuleContext {
		public int type;
		public int val;
		public int length;
		public DigContext a1;
		public DigContext a2;
		public SeqContext a3;
		public DigContext dig() {
			return getRuleContext(DigContext.class,0);
		}
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public SeqContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SeqContext(ParserRuleContext parent, int invokingState, int type) {
			super(parent, invokingState);
			this.type = type;
		}
		@Override public int getRuleIndex() { return RULE_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).exitSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NumberVisitor ) return ((NumberVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqContext seq(int type) throws RecognitionException {
		SeqContext _localctx = new SeqContext(_ctx, getState(), type);
		enterRule(_localctx, 2, RULE_seq);
		try {
			setState(24);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				((SeqContext)_localctx).a1 = dig();

				        ((SeqContext)_localctx).length =  1;
				        ((SeqContext)_localctx).val =  ((SeqContext)_localctx).a1.val;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				((SeqContext)_localctx).a2 = dig();
				setState(21);
				((SeqContext)_localctx).a3 = seq(type);

				        ((SeqContext)_localctx).length =  ((SeqContext)_localctx).a3.length + 1;
				        ((SeqContext)_localctx).val =  (((SeqContext)_localctx).a2.val * (int) Math.pow(type, ((SeqContext)_localctx).a3.length)) + ((SeqContext)_localctx).a3.val;
				    
				}
				break;
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

	public static class PrfContext extends ParserRuleContext {
		public int type;
		public PrfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).enterPrf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).exitPrf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NumberVisitor ) return ((NumberVisitor<? extends T>)visitor).visitPrf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrfContext prf() throws RecognitionException {
		PrfContext _localctx = new PrfContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prf);
		try {
			setState(30);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(T__0);

				        ((PrfContext)_localctx).type =  16;
				    
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(T__1);

				        ((PrfContext)_localctx).type =  2;
				    
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

	public static class DigContext extends ParserRuleContext {
		public int val;
		public Token DIGIT;
		public TerminalNode DIGIT() { return getToken(NumberParser.DIGIT, 0); }
		public DigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).enterDig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumberListener ) ((NumberListener)listener).exitDig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NumberVisitor ) return ((NumberVisitor<? extends T>)visitor).visitDig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigContext dig() throws RecognitionException {
		DigContext _localctx = new DigContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((DigContext)_localctx).DIGIT = match(DIGIT);

			        char c = ((DigContext)_localctx).DIGIT.getText().charAt(0);
			        ((DigContext)_localctx).val =  c - (c < 'A' ? '0' : ('A'-10));
			    
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\5&\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\22\n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\5\4!\n\4\3\5\3\5\3\5\3\5\2"+
		"\2\6\2\4\6\b\2\2$\2\21\3\2\2\2\4\32\3\2\2\2\6 \3\2\2\2\b\"\3\2\2\2\n\13"+
		"\5\6\4\2\13\f\5\4\3\2\f\r\b\2\1\2\r\22\3\2\2\2\16\17\5\4\3\2\17\20\b\2"+
		"\1\2\20\22\3\2\2\2\21\n\3\2\2\2\21\16\3\2\2\2\22\3\3\2\2\2\23\24\5\b\5"+
		"\2\24\25\b\3\1\2\25\33\3\2\2\2\26\27\5\b\5\2\27\30\5\4\3\2\30\31\b\3\1"+
		"\2\31\33\3\2\2\2\32\23\3\2\2\2\32\26\3\2\2\2\33\5\3\2\2\2\34\35\7\3\2"+
		"\2\35!\b\4\1\2\36\37\7\4\2\2\37!\b\4\1\2 \34\3\2\2\2 \36\3\2\2\2!\7\3"+
		"\2\2\2\"#\7\5\2\2#$\b\5\1\2$\t\3\2\2\2\5\21\32 ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}