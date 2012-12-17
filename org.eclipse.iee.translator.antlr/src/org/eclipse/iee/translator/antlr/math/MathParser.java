// $ANTLR ANTLRVersion> MathParser.java generatedTimestamp>
package org.eclipse.iee.translator.antlr.math;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		MATH_NAME=25, INT=26, WS=27, FLOAT=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'%'", "']'", "'^'", "')'", "'.'", "','", "'+'", "'^T'", 
		"'*'", "'-'", "'['", "'('", "'<'", "'='", "'!='", "'<='", "'&&'", "'||'", 
		"'>'", "'{'", "'/'", "'=='", "'>='", "'}'", "MATH_NAME", "INT", "WS", 
		"FLOAT"
	};
	public static final int
		RULE_statement = 0, RULE_functionDefinition = 1, RULE_function = 2, RULE_variableAssignment = 3, 
		RULE_formula = 4, RULE_logicalFormula = 5, RULE_expr = 6, RULE_logicalExpr = 7, 
		RULE_primary = 8, RULE_matrix = 9, RULE_matrixRow = 10;
	public static final String[] ruleNames = {
		"statement", "functionDefinition", "function", "variableAssignment", "formula", 
		"logicalFormula", "expr", "logicalExpr", "primary", "matrix", "matrixRow"
	};

	@Override
	public String getGrammarFileName() { return "Math.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public MathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatementContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public LogicalFormulaContext logicalFormula() {
			return getRuleContext(LogicalFormulaContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitStatement(this);
			else return null;
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, 0);
		enterRule(_localctx, RULE_statement);
		try {
			setState(26);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22); functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); variableAssignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24); formula();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(25); logicalFormula();
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionContext name;
		public FormulaContext value;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitFunctionDefinition(this);
			else return null;
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, 2);
		enterRule(_localctx, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); ((FunctionDefinitionContext)_localctx).name = function();
			setState(29); match(14);
			setState(30); ((FunctionDefinitionContext)_localctx).value = formula();
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

	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public FormulaContext formula;
		public List<FormulaContext> params = new ArrayList<FormulaContext>();
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FunctionContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitFunction(this);
			else return null;
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, 4);
		enterRule(_localctx, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); ((FunctionContext)_localctx).name = match(MATH_NAME);
			setState(33); match(12);
			setState(42);
			_la = _input.LA(1);
			if (_la==7 || _la==10 || _la==12 || _la==20 || _la==MATH_NAME || _la==INT || _la==FLOAT) {
				{
				setState(34); ((FunctionContext)_localctx).formula = formula();
				((FunctionContext)_localctx).params.add(((FunctionContext)_localctx).formula);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==6) {
					{
					{
					setState(35); match(6);
					setState(36); ((FunctionContext)_localctx).formula = formula();
					((FunctionContext)_localctx).params.add(((FunctionContext)_localctx).formula);
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(44); match(4);
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

	public static class VariableAssignmentContext extends ParserRuleContext {
		public FormulaContext name;
		public FormulaContext value;
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public VariableAssignmentContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitVariableAssignment(this);
			else return null;
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, 6);
		enterRule(_localctx, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); ((VariableAssignmentContext)_localctx).name = formula();
			setState(47); match(14);
			setState(48); ((VariableAssignmentContext)_localctx).value = formula();
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

	public static class FormulaContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FormulaContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitFormula(this);
			else return null;
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, 8);
		enterRule(_localctx, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); expr(0);
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

	public static class LogicalFormulaContext extends ParserRuleContext {
		public LogicalExprContext logicalExpr() {
			return getRuleContext(LogicalExprContext.class,0);
		}
		public LogicalFormulaContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_logicalFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterLogicalFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitLogicalFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitLogicalFormula(this);
			else return null;
		}
	}

	public final LogicalFormulaContext logicalFormula() throws RecognitionException {
		LogicalFormulaContext _localctx = new LogicalFormulaContext(_ctx, 10);
		enterRule(_localctx, RULE_logicalFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); logicalExpr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext(ParserRuleContext parent, int state) { super(parent, state); }
		public ExprContext(ParserRuleContext parent, int state, int _p) {
			super(parent, state);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class MultContext extends ExprContext {
		public ExprContext left;
		public Token sign;
		public ExprContext right;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public MultContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitMult(this);
			else return null;
		}
	}
	public static class PrimaryExprContext extends ExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitPrimaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitPrimaryExpr(this);
			else return null;
		}
	}
	public static class PowerContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public PowerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitPower(this);
			else return null;
		}
	}
	public static class AddContext extends ExprContext {
		public ExprContext left;
		public Token sign;
		public ExprContext right;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public AddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitAdd(this);
			else return null;
		}
	}
	public static class UnaryContext extends ExprContext {
		public Token sign;
		public ExprContext expression;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitUnary(this);
			else return null;
		}
	}
	public static class ExprBracketsContext extends ExprContext {
		public ExprContext expression;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprBracketsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterExprBrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitExprBrackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitExprBrackets(this);
			else return null;
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = _ctx.s;
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			switch (_input.LA(1)) {
			case 7:
			case 10:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(55);
				((UnaryContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==7 || _la==10) ) {
					((UnaryContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(56); ((UnaryContext)_localctx).expression = expr(5);
				}
				break;
			case 12:
				{
				_localctx = new ExprBracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57); match(12);
				setState(58); ((ExprBracketsContext)_localctx).expression = expr(0);
				setState(59); match(4);
				}
				break;
			case 20:
			case MATH_NAME:
			case INT:
			case FLOAT:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(73);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExprContext(_parentctx, _parentState, _p));
						((PowerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(65); match(3);
						setState(66); ((PowerContext)_localctx).right = expr(6);
						}
						break;
					case 2:
						{
						_localctx = new MultContext(new ExprContext(_parentctx, _parentState, _p));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(68);
						((MultContext)_localctx).sign = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==1 || _la==9 || _la==21) ) {
							((MultContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(69); ((MultContext)_localctx).right = expr(5);
						}
						break;
					case 3:
						{
						_localctx = new AddContext(new ExprContext(_parentctx, _parentState, _p));
						((AddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(71);
						((AddContext)_localctx).sign = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==7 || _la==10) ) {
							((AddContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(72); ((AddContext)_localctx).right = expr(4);
						}
						break;
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class LogicalExprContext extends ParserRuleContext {
		public int _p;
		public LogicalExprContext(ParserRuleContext parent, int state) { super(parent, state); }
		public LogicalExprContext(ParserRuleContext parent, int state, int _p) {
			super(parent, state);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_logicalExpr; }
	 
		public LogicalExprContext() { }
		public void copyFrom(LogicalExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class LogicMultContext extends LogicalExprContext {
		public LogicalExprContext left;
		public Token sign;
		public LogicalExprContext right;
		public List<LogicalExprContext> logicalExpr() {
			return getRuleContexts(LogicalExprContext.class);
		}
		public LogicalExprContext logicalExpr(int i) {
			return getRuleContext(LogicalExprContext.class,i);
		}
		public LogicMultContext(LogicalExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterLogicMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitLogicMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitLogicMult(this);
			else return null;
		}
	}
	public static class LogicComparisonContext extends LogicalExprContext {
		public ExprContext left;
		public Token sign;
		public ExprContext right;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public LogicComparisonContext(LogicalExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterLogicComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitLogicComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitLogicComparison(this);
			else return null;
		}
	}
	public static class LogicBracketsContext extends LogicalExprContext {
		public LogicalExprContext expression;
		public LogicalExprContext logicalExpr() {
			return getRuleContext(LogicalExprContext.class,0);
		}
		public LogicBracketsContext(LogicalExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterLogicBrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitLogicBrackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitLogicBrackets(this);
			else return null;
		}
	}
	public static class LogicAddContext extends LogicalExprContext {
		public LogicalExprContext left;
		public Token sign;
		public LogicalExprContext right;
		public List<LogicalExprContext> logicalExpr() {
			return getRuleContexts(LogicalExprContext.class);
		}
		public LogicalExprContext logicalExpr(int i) {
			return getRuleContext(LogicalExprContext.class,i);
		}
		public LogicAddContext(LogicalExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterLogicAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitLogicAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitLogicAdd(this);
			else return null;
		}
	}

	public final LogicalExprContext logicalExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = _ctx.s;
		LogicalExprContext _localctx = new LogicalExprContext(_ctx, _parentState, _p);
		LogicalExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_logicalExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new LogicBracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(79); match(12);
				setState(80); ((LogicBracketsContext)_localctx).expression = logicalExpr(0);
				setState(81); match(4);
				}
				break;
			case 2:
				{
				_localctx = new LogicComparisonContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83); ((LogicComparisonContext)_localctx).left = expr(0);
				setState(84);
				((LogicComparisonContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==13 || _la==15 || _la==16 || _la==19 || _la==22 || _la==23) ) {
					((LogicComparisonContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(85); ((LogicComparisonContext)_localctx).right = expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(95);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new LogicMultContext(new LogicalExprContext(_parentctx, _parentState, _p));
						((LogicMultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpr);
						setState(89);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(90); ((LogicMultContext)_localctx).sign = match(17);
						setState(91); ((LogicMultContext)_localctx).right = logicalExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new LogicAddContext(new LogicalExprContext(_parentctx, _parentState, _p));
						((LogicAddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpr);
						setState(92);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(93); ((LogicAddContext)_localctx).sign = match(18);
						setState(94); ((LogicAddContext)_localctx).right = logicalExpr(4);
						}
						break;
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableContext extends PrimaryContext {
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public VariableContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitVariable(this);
			else return null;
		}
	}
	public static class MatrixDefinitionContext extends PrimaryContext {
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public MatrixDefinitionContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterMatrixDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitMatrixDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitMatrixDefinition(this);
			else return null;
		}
	}
	public static class PrimaryFunctionContext extends PrimaryContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public PrimaryFunctionContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterPrimaryFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitPrimaryFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitPrimaryFunction(this);
			else return null;
		}
	}
	public static class TransposeMatrixContext extends PrimaryContext {
		public Token name;
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public TransposeMatrixContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterTransposeMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitTransposeMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitTransposeMatrix(this);
			else return null;
		}
	}
	public static class FloatNumberContext extends PrimaryContext {
		public TerminalNode FLOAT() { return getToken(MathParser.FLOAT, 0); }
		public FloatNumberContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterFloatNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitFloatNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitFloatNumber(this);
			else return null;
		}
	}
	public static class IntNumberContext extends PrimaryContext {
		public TerminalNode INT() { return getToken(MathParser.INT, 0); }
		public IntNumberContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterIntNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitIntNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitIntNumber(this);
			else return null;
		}
	}
	public static class PropertyContext extends PrimaryContext {
		public Token objName;
		public Token objProperty;
		public TerminalNode MATH_NAME(int i) {
			return getToken(MathParser.MATH_NAME, i);
		}
		public List<TerminalNode> MATH_NAME() { return getTokens(MathParser.MATH_NAME); }
		public PropertyContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitProperty(this);
			else return null;
		}
	}
	public static class MatrixElementContext extends PrimaryContext {
		public Token name;
		public FormulaContext rowIdx;
		public FormulaContext columnIdx;
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public MatrixElementContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterMatrixElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitMatrixElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitMatrixElement(this);
			else return null;
		}
	}
	public static class MethodCallContext extends PrimaryContext {
		public Token objName;
		public FunctionContext objFunction;
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public MethodCallContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitMethodCall(this);
			else return null;
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, 16);
		enterRule(_localctx, RULE_primary);
		try {
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100); match(MATH_NAME);
				}
				break;
			case 2:
				_localctx = new FloatNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101); match(FLOAT);
				}
				break;
			case 3:
				_localctx = new IntNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102); match(INT);
				}
				break;
			case 4:
				_localctx = new MatrixDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(103); matrix();
				}
				break;
			case 5:
				_localctx = new MatrixElementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(104); ((MatrixElementContext)_localctx).name = match(MATH_NAME);
				setState(105); match(11);
				setState(106); ((MatrixElementContext)_localctx).rowIdx = formula();
				setState(107); match(2);
				setState(108); match(11);
				setState(109); ((MatrixElementContext)_localctx).columnIdx = formula();
				setState(110); match(2);
				}
				break;
			case 6:
				_localctx = new PrimaryFunctionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(112); function();
				}
				break;
			case 7:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(113); ((MethodCallContext)_localctx).objName = match(MATH_NAME);
				setState(114); match(5);
				setState(115); ((MethodCallContext)_localctx).objFunction = function();
				}
				break;
			case 8:
				_localctx = new PropertyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(116); ((PropertyContext)_localctx).objName = match(MATH_NAME);
				setState(117); match(5);
				setState(118); ((PropertyContext)_localctx).objProperty = match(MATH_NAME);
				}
				break;
			case 9:
				_localctx = new TransposeMatrixContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(119); ((TransposeMatrixContext)_localctx).name = match(MATH_NAME);
				setState(120); match(8);
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

	public static class MatrixContext extends ParserRuleContext {
		public MatrixRowContext matrixRow;
		public List<MatrixRowContext> rows = new ArrayList<MatrixRowContext>();
		public List<MatrixRowContext> matrixRow() {
			return getRuleContexts(MatrixRowContext.class);
		}
		public MatrixRowContext matrixRow(int i) {
			return getRuleContext(MatrixRowContext.class,i);
		}
		public MatrixContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitMatrix(this);
			else return null;
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, 18);
		enterRule(_localctx, RULE_matrix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(20);
			setState(135);
			_la = _input.LA(1);
			if (_la==20) {
				{
				setState(124); ((MatrixContext)_localctx).matrixRow = matrixRow();
				((MatrixContext)_localctx).rows.add(((MatrixContext)_localctx).matrixRow);
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(125); match(6);
						setState(126); ((MatrixContext)_localctx).matrixRow = matrixRow();
						((MatrixContext)_localctx).rows.add(((MatrixContext)_localctx).matrixRow);
						}
						} 
					}
					setState(131);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(133);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(132); match(6);
					}
				}

				}
			}

			setState(137); match(24);
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

	public static class MatrixRowContext extends ParserRuleContext {
		public FormulaContext formula;
		public List<FormulaContext> elements = new ArrayList<FormulaContext>();
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public MatrixRowContext(ParserRuleContext parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_matrixRow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterMatrixRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitMatrixRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<T>)visitor).visitMatrixRow(this);
			else return null;
		}
	}

	public final MatrixRowContext matrixRow() throws RecognitionException {
		MatrixRowContext _localctx = new MatrixRowContext(_ctx, 20);
		enterRule(_localctx, RULE_matrixRow);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(20);
			setState(151);
			_la = _input.LA(1);
			if (_la==7 || _la==10 || _la==12 || _la==20 || _la==MATH_NAME || _la==INT || _la==FLOAT) {
				{
				setState(140); ((MatrixRowContext)_localctx).formula = formula();
				((MatrixRowContext)_localctx).elements.add(((MatrixRowContext)_localctx).formula);
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(141); match(6);
						setState(142); ((MatrixRowContext)_localctx).formula = formula();
						((MatrixRowContext)_localctx).elements.add(((MatrixRowContext)_localctx).formula);
						}
						} 
					}
					setState(147);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(149);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(148); match(6);
					}
				}

				}
			}

			setState(153); match(24);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6: return expr_sempred((ExprContext)_localctx, predIndex);
		case 7: return logicalExpr_sempred((LogicalExprContext)_localctx, predIndex);
		}
		return true;
	}
	public boolean logicalExpr_sempred(LogicalExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 4 >= _localctx._p;
		case 4: return 3 >= _localctx._p;
		}
		return true;
	}
	public boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 6 >= _localctx._p;
		case 1: return 4 >= _localctx._p;
		case 2: return 3 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\34\u009c\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6\2"+
		"\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\1\0\1\0\1\0\1\0\3\0\33\b\0\1\1\1\1\1\1"+
		"\1\1\1\2\1\2\1\2\1\2\1\2\5\2&\b\2\n\2\f\2)\t\2\3\2+\b\2\1\2\1\2\1\3\1"+
		"\3\1\3\1\3\1\4\1\4\1\5\1\5\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\3\6?\b\6\1"+
		"\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\5\6J\b\6\n\6\f\6M\t\6\1\7\1\7\1\7\1"+
		"\7\1\7\1\7\1\7\1\7\1\7\3\7X\b\7\1\7\1\7\1\7\1\7\1\7\1\7\5\7`\b\7\n\7\f"+
		"\7c\t\7\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1"+
		"\b\1\b\1\b\1\b\1\b\1\b\3\bz\b\b\1\t\1\t\1\t\1\t\5\t\u0080\b\t\n\t\f\t"+
		"\u0083\t\t\1\t\3\t\u0086\b\t\3\t\u0088\b\t\1\t\1\t\1\n\1\n\1\n\1\n\5\n"+
		"\u0090\b\n\n\n\f\n\u0093\t\n\1\n\3\n\u0096\b\n\3\n\u0098\b\n\1\n\1\n\1"+
		"\n\13\0\2\4\6\b\n\f\16\20\22\24\0\4\2\7\7\n\n\3\1\1\t\t\25\25\2\7\7\n"+
		"\n\4\r\r\17\20\23\23\26\27\u00ab\0\32\1\0\0\0\2\34\1\0\0\0\4 \1\0\0\0"+
		"\6.\1\0\0\0\b\62\1\0\0\0\n\64\1\0\0\0\f>\1\0\0\0\16W\1\0\0\0\20y\1\0\0"+
		"\0\22{\1\0\0\0\24\u008b\1\0\0\0\26\33\3\2\1\0\27\33\3\6\3\0\30\33\3\b"+
		"\4\0\31\33\3\n\5\0\32\26\1\0\0\0\32\27\1\0\0\0\32\30\1\0\0\0\32\31\1\0"+
		"\0\0\33\1\1\0\0\0\34\35\3\4\2\0\35\36\5\16\0\0\36\37\3\b\4\0\37\3\1\0"+
		"\0\0 !\5\31\0\0!*\5\f\0\0\"\'\3\b\4\0#$\5\6\0\0$&\3\b\4\0%#\1\0\0\0&)"+
		"\1\0\0\0\'%\1\0\0\0\'(\1\0\0\0(+\1\0\0\0)\'\1\0\0\0*\"\1\0\0\0*+\1\0\0"+
		"\0+,\1\0\0\0,-\5\4\0\0-\5\1\0\0\0./\3\b\4\0/\60\5\16\0\0\60\61\3\b\4\0"+
		"\61\7\1\0\0\0\62\63\3\f\6\0\63\t\1\0\0\0\64\65\3\16\7\0\65\13\1\0\0\0"+
		"\66\67\6\6\uffff\0\678\7\0\0\08?\3\f\6\09:\5\f\0\0:;\3\f\6\0;<\5\4\0\0"+
		"<?\1\0\0\0=?\3\20\b\0>\66\1\0\0\0>9\1\0\0\0>=\1\0\0\0?K\1\0\0\0@A\4\6"+
		"\0\1AB\5\3\0\0BJ\3\f\6\0CD\4\6\1\1DE\7\1\0\0EJ\3\f\6\0FG\4\6\2\1GH\7\2"+
		"\0\0HJ\3\f\6\0I@\1\0\0\0IC\1\0\0\0IF\1\0\0\0JM\1\0\0\0KI\1\0\0\0KL\1\0"+
		"\0\0L\r\1\0\0\0MK\1\0\0\0NO\6\7\uffff\0OP\5\f\0\0PQ\3\16\7\0QR\5\4\0\0"+
		"RX\1\0\0\0ST\3\f\6\0TU\7\3\0\0UV\3\f\6\0VX\1\0\0\0WN\1\0\0\0WS\1\0\0\0"+
		"Xa\1\0\0\0YZ\4\7\3\1Z[\5\21\0\0[`\3\16\7\0\\]\4\7\4\1]^\5\22\0\0^`\3\16"+
		"\7\0_Y\1\0\0\0_\\\1\0\0\0`c\1\0\0\0a_\1\0\0\0ab\1\0\0\0b\17\1\0\0\0ca"+
		"\1\0\0\0dz\5\31\0\0ez\5\34\0\0fz\5\32\0\0gz\3\22\t\0hi\5\31\0\0ij\5\13"+
		"\0\0jk\3\b\4\0kl\5\2\0\0lm\5\13\0\0mn\3\b\4\0no\5\2\0\0oz\1\0\0\0pz\3"+
		"\4\2\0qr\5\31\0\0rs\5\5\0\0sz\3\4\2\0tu\5\31\0\0uv\5\5\0\0vz\5\31\0\0"+
		"wx\5\31\0\0xz\5\b\0\0yd\1\0\0\0ye\1\0\0\0yf\1\0\0\0yg\1\0\0\0yh\1\0\0"+
		"\0yp\1\0\0\0yq\1\0\0\0yt\1\0\0\0yw\1\0\0\0z\21\1\0\0\0{\u0087\5\24\0\0"+
		"|\u0081\3\24\n\0}~\5\6\0\0~\u0080\3\24\n\0\177}\1\0\0\0\u0080\u0083\1"+
		"\0\0\0\u0081\177\1\0\0\0\u0081\u0082\1\0\0\0\u0082\u0085\1\0\0\0\u0083"+
		"\u0081\1\0\0\0\u0084\u0086\5\6\0\0\u0085\u0084\1\0\0\0\u0085\u0086\1\0"+
		"\0\0\u0086\u0088\1\0\0\0\u0087|\1\0\0\0\u0087\u0088\1\0\0\0\u0088\u0089"+
		"\1\0\0\0\u0089\u008a\5\30\0\0\u008a\23\1\0\0\0\u008b\u0097\5\24\0\0\u008c"+
		"\u0091\3\b\4\0\u008d\u008e\5\6\0\0\u008e\u0090\3\b\4\0\u008f\u008d\1\0"+
		"\0\0\u0090\u0093\1\0\0\0\u0091\u008f\1\0\0\0\u0091\u0092\1\0\0\0\u0092"+
		"\u0095\1\0\0\0\u0093\u0091\1\0\0\0\u0094\u0096\5\6\0\0\u0095\u0094\1\0"+
		"\0\0\u0095\u0096\1\0\0\0\u0096\u0098\1\0\0\0\u0097\u008c\1\0\0\0\u0097"+
		"\u0098\1\0\0\0\u0098\u0099\1\0\0\0\u0099\u009a\5\30\0\0\u009a\25\1\0\0"+
		"\0\20\32\'*>IKW_ay\u0081\u0085\u0087\u0091\u0095\u0097";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}