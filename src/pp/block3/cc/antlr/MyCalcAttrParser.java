// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/antlr\MyCalcAttr.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import pp.block2.cc.ParseException;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyCalcAttrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HAT=1, TIMES=2, PLUS=3, EQUALS=4, MINUS=5, LPAR=6, RPAR=7, NUMBER=8, BOOL=9, 
		STRING=10, WS=11;
	public static final int
		RULE_t = 0;
	public static final String[] ruleNames = {
		"t"
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

	@Override
	public String getGrammarFileName() { return "MyCalcAttr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private void error(Type t1, Type t2, String operator) throws ParseException {
	        throw new ParseException("Operator " + operator + " is incompatible with types: " + t1.toString() + " and " + t2.toString() );
	    }

	public MyCalcAttrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TContext extends ParserRuleContext {
		public Type type;
		public TContext t0;
		public TContext t1;
		public TerminalNode LPAR() { return getToken(MyCalcAttrParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MyCalcAttrParser.RPAR, 0); }
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TerminalNode BOOL() { return getToken(MyCalcAttrParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(MyCalcAttrParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(MyCalcAttrParser.NUMBER, 0); }
		public TerminalNode HAT() { return getToken(MyCalcAttrParser.HAT, 0); }
		public TerminalNode PLUS() { return getToken(MyCalcAttrParser.PLUS, 0); }
		public TerminalNode EQUALS() { return getToken(MyCalcAttrParser.EQUALS, 0); }
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyCalcAttrListener ) ((MyCalcAttrListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyCalcAttrListener ) ((MyCalcAttrListener)listener).exitT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyCalcAttrVisitor ) return ((MyCalcAttrVisitor<? extends T>)visitor).visitT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TContext t() throws RecognitionException, ParseException {
		return t(0);
	}

	private TContext t(int _p) throws RecognitionException, ParseException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TContext _localctx = new TContext(_ctx, _parentState);
		TContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_t, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(3);
				match(LPAR);
				setState(4);
				((TContext)_localctx).t0 = t(0);
				setState(5);
				match(RPAR);
				 ((TContext)_localctx).type =  ((TContext)_localctx).t0.type;
				}
				break;
			case BOOL:
				{
				setState(8);
				match(BOOL);
				 ((TContext)_localctx).type =  Type.BOOL;
				}
				break;
			case STRING:
				{
				setState(10);
				match(STRING);
				 ((TContext)_localctx).type =  Type.STR;
				}
				break;
			case NUMBER:
				{
				setState(12);
				match(NUMBER);
				 ((TContext)_localctx).type =  Type.NUM;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(31);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new TContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(16);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(17);
						match(HAT);
						setState(18);
						((TContext)_localctx).t1 = t(8);

						                  if(((TContext)_localctx).t0.type==Type.NUM&&((TContext)_localctx).t1.type==Type.NUM){
						                      ((TContext)_localctx).type =  Type.NUM;
						                  }
						                  else if(((TContext)_localctx).t0.type==Type.STR&&((TContext)_localctx).t1.type==Type.NUM){
						                      ((TContext)_localctx).type =  Type.STR;
						                  }else{
						                      error(((TContext)_localctx).t0.type, ((TContext)_localctx).t1.type, "^" );
						                      ((TContext)_localctx).type =  Type.ERR;
						                  }
						              
						}
						break;
					case 2:
						{
						_localctx = new TContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(21);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(22);
						match(PLUS);
						setState(23);
						((TContext)_localctx).t1 = t(7);

						                  if(((TContext)_localctx).t0.type== Type.STR || ((TContext)_localctx).t1.type == Type.STR){
						                      ((TContext)_localctx).type =  Type.STR;
						                  }
						                  else if(((TContext)_localctx).t0.type==((TContext)_localctx).t1.type){
						                      ((TContext)_localctx).type =  ((TContext)_localctx).t0.type;
						                  }else{
						                      error(((TContext)_localctx).t0.type, ((TContext)_localctx).t1.type, "+" );
						                      ((TContext)_localctx).type =  Type.ERR;
						                  }
						              
						}
						break;
					case 3:
						{
						_localctx = new TContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(26);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(27);
						match(EQUALS);
						setState(28);
						((TContext)_localctx).t1 = t(6);
						 ((TContext)_localctx).type =  Type.BOOL;
						}
						break;
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return t_sempred((TContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean t_sempred(TContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\'\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2%\13\2"+
		"\3\2\2\3\2\3\2\2\2+\2\20\3\2\2\2\4\5\b\2\1\2\5\6\7\b\2\2\6\7\5\2\2\2\7"+
		"\b\7\t\2\2\b\t\b\2\1\2\t\21\3\2\2\2\n\13\7\13\2\2\13\21\b\2\1\2\f\r\7"+
		"\f\2\2\r\21\b\2\1\2\16\17\7\n\2\2\17\21\b\2\1\2\20\4\3\2\2\2\20\n\3\2"+
		"\2\2\20\f\3\2\2\2\20\16\3\2\2\2\21#\3\2\2\2\22\23\f\t\2\2\23\24\7\3\2"+
		"\2\24\25\5\2\2\n\25\26\b\2\1\2\26\"\3\2\2\2\27\30\f\b\2\2\30\31\7\5\2"+
		"\2\31\32\5\2\2\t\32\33\b\2\1\2\33\"\3\2\2\2\34\35\f\7\2\2\35\36\7\6\2"+
		"\2\36\37\5\2\2\b\37 \b\2\1\2 \"\3\2\2\2!\22\3\2\2\2!\27\3\2\2\2!\34\3"+
		"\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%#\3\2\2\2\5\20!#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}