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
		T__22=1, T__21=2, T__20=3, T__19=4, T__18=5, T__17=6, T__16=7, T__15=8, 
		T__14=9, T__13=10, T__12=11, T__11=12, T__10=13, T__9=14, T__8=15, T__7=16, 
		T__6=17, T__5=18, T__4=19, T__3=20, T__2=21, T__1=22, T__0=23, MATH_NAME=24, 
		INT=25, WS=26, FLOAT=27;
	public static final String[] tokenNames = {
		"<INVALID>", "'%'", "']'", "'^'", "')'", "'.'", "','", "'+'", "'*'", "'-'", 
		"'['", "'('", "'<'", "'='", "'!='", "'<='", "'&&'", "'||'", "'>'", "'{'", 
		"'/'", "'=='", "'>='", "'}'", "MATH_NAME", "INT", "WS", "FLOAT"
	};
	public static final int
		RULE_statement = 0, RULE_functionDefinition = 1, RULE_function = 2, RULE_variableAssignment = 3, 
		RULE_expression = 4, RULE_logicalExpression = 5, RULE_primary = 6, RULE_matrix = 7, 
		RULE_matrixRow = 8;
	public static final String[] ruleNames = {
		"statement", "functionDefinition", "function", "variableAssignment", "expression", 
		"logicalExpression", "primary", "matrix", "matrixRow"
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitStatement(this);
			else return null;
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		try {
			setState(22);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(18); functionDefinition();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19); variableAssignment();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(20); expression(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(21); logicalExpression(0);
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
		public ExpressionContext value;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return null;
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); ((FunctionDefinitionContext)_localctx).name = function();
			setState(25); match(13);
			setState(26); ((FunctionDefinitionContext)_localctx).value = expression(0);
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
		public ExpressionContext expression;
		public List<ExpressionContext> params = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitFunction(this);
			else return null;
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); ((FunctionContext)_localctx).name = match(MATH_NAME);
			setState(29); match(11);
			setState(38);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 11) | (1L << 19) | (1L << MATH_NAME) | (1L << INT) | (1L << FLOAT))) != 0)) {
				{
				setState(30); ((FunctionContext)_localctx).expression = expression(0);
				((FunctionContext)_localctx).params.add(((FunctionContext)_localctx).expression);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==6) {
					{
					{
					setState(31); match(6);
					setState(32); ((FunctionContext)_localctx).expression = expression(0);
					((FunctionContext)_localctx).params.add(((FunctionContext)_localctx).expression);
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(40); match(4);
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
		public ExpressionContext name;
		public ExpressionContext value;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return null;
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); ((VariableAssignmentContext)_localctx).name = expression(0);
			setState(43); match(13);
			setState(44); ((VariableAssignmentContext)_localctx).value = expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class MultContext extends ExpressionContext {
		public ExpressionContext left;
		public Token sign;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultContext(ExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitMult(this);
			else return null;
		}
	}
	public static class PrimaryExprContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return null;
		}
	}
	public static class PowerContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowerContext(ExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitPower(this);
			else return null;
		}
	}
	public static class AddContext extends ExpressionContext {
		public ExpressionContext left;
		public Token sign;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddContext(ExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitAdd(this);
			else return null;
		}
	}
	public static class UnaryContext extends ExpressionContext {
		public Token sign;
		public ExpressionContext unaryExpr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitUnary(this);
			else return null;
		}
	}
	public static class ExprBracketsContext extends ExpressionContext {
		public ExpressionContext bracketedExpr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprBracketsContext(ExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitExprBrackets(this);
			else return null;
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			switch (_input.LA(1)) {
			case 7:
			case 9:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(47);
				((UnaryContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==7 || _la==9) ) {
					((UnaryContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(48); ((UnaryContext)_localctx).unaryExpr = expression(5);
				}
				break;
			case 11:
				{
				_localctx = new ExprBracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49); match(11);
				setState(50); ((ExprBracketsContext)_localctx).bracketedExpr = expression(0);
				setState(51); match(4);
				}
				break;
			case 19:
			case MATH_NAME:
			case INT:
			case FLOAT:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53); primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(65);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExpressionContext(_parentctx, _parentState, _p));
						((PowerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(56);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(57); match(3);
						setState(58); ((PowerContext)_localctx).right = expression(6);
						}
						break;

					case 2:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState, _p));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(59);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(60);
						((MultContext)_localctx).sign = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 8) | (1L << 20))) != 0)) ) {
							((MultContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(61); ((MultContext)_localctx).right = expression(5);
						}
						break;

					case 3:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState, _p));
						((AddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(62);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(63);
						((AddContext)_localctx).sign = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==7 || _la==9) ) {
							((AddContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(64); ((AddContext)_localctx).right = expression(4);
						}
						break;
					}
					} 
				}
				setState(69);
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

	public static class LogicalExpressionContext extends ParserRuleContext {
		public int _p;
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
	 
		public LogicalExpressionContext() { }
		public void copyFrom(LogicalExpressionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class LogicMultContext extends LogicalExpressionContext {
		public LogicalExpressionContext left;
		public Token sign;
		public LogicalExpressionContext right;
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicMultContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitLogicMult(this);
			else return null;
		}
	}
	public static class LogicComparisonContext extends LogicalExpressionContext {
		public ExpressionContext left;
		public Token sign;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicComparisonContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitLogicComparison(this);
			else return null;
		}
	}
	public static class LogicBracketsContext extends LogicalExpressionContext {
		public LogicalExpressionContext expr;
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public LogicBracketsContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitLogicBrackets(this);
			else return null;
		}
	}
	public static class LogicAddContext extends LogicalExpressionContext {
		public LogicalExpressionContext left;
		public Token sign;
		public LogicalExpressionContext right;
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicAddContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitLogicAdd(this);
			else return null;
		}
	}

	public final LogicalExpressionContext logicalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, _parentState, _p);
		LogicalExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_logicalExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new LogicBracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71); match(11);
				setState(72); ((LogicBracketsContext)_localctx).expr = logicalExpression(0);
				setState(73); match(4);
				}
				break;

			case 2:
				{
				_localctx = new LogicComparisonContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75); ((LogicComparisonContext)_localctx).left = expression(0);
				setState(76);
				((LogicComparisonContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 21) | (1L << 22))) != 0)) ) {
					((LogicComparisonContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(77); ((LogicComparisonContext)_localctx).right = expression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(87);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new LogicMultContext(new LogicalExpressionContext(_parentctx, _parentState, _p));
						((LogicMultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(81);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(82); ((LogicMultContext)_localctx).sign = match(16);
						setState(83); ((LogicMultContext)_localctx).right = logicalExpression(5);
						}
						break;

					case 2:
						{
						_localctx = new LogicAddContext(new LogicalExpressionContext(_parentctx, _parentState, _p));
						((LogicAddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(84);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(85); ((LogicAddContext)_localctx).sign = match(17);
						setState(86); ((LogicAddContext)_localctx).right = logicalExpression(4);
						}
						break;
					}
					} 
				}
				setState(91);
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
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitVariable(this);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitMatrixDefinition(this);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitPrimaryFunction(this);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitFloatNumber(this);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitIntNumber(this);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitProperty(this);
			else return null;
		}
	}
	public static class MatrixElementContext extends PrimaryContext {
		public Token name;
		public ExpressionContext rowIdx;
		public ExpressionContext columnIdx;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitMatrixElement(this);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitMethodCall(this);
			else return null;
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primary);
		try {
			setState(111);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92); match(MATH_NAME);
				}
				break;

			case 2:
				_localctx = new FloatNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93); match(FLOAT);
				}
				break;

			case 3:
				_localctx = new IntNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94); match(INT);
				}
				break;

			case 4:
				_localctx = new MatrixDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(95); matrix();
				}
				break;

			case 5:
				_localctx = new MatrixElementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(96); ((MatrixElementContext)_localctx).name = match(MATH_NAME);
				setState(97); match(10);
				setState(98); ((MatrixElementContext)_localctx).rowIdx = expression(0);
				setState(99); match(2);
				setState(100); match(10);
				setState(101); ((MatrixElementContext)_localctx).columnIdx = expression(0);
				setState(102); match(2);
				}
				break;

			case 6:
				_localctx = new PrimaryFunctionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(104); function();
				}
				break;

			case 7:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(105); ((MethodCallContext)_localctx).objName = match(MATH_NAME);
				setState(106); match(5);
				setState(107); ((MethodCallContext)_localctx).objFunction = function();
				}
				break;

			case 8:
				_localctx = new PropertyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(108); ((PropertyContext)_localctx).objName = match(MATH_NAME);
				setState(109); match(5);
				setState(110); ((PropertyContext)_localctx).objProperty = match(MATH_NAME);
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
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitMatrix(this);
			else return null;
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_matrix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(19);
			setState(125);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(114); ((MatrixContext)_localctx).matrixRow = matrixRow();
				((MatrixContext)_localctx).rows.add(((MatrixContext)_localctx).matrixRow);
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(115); match(6);
						setState(116); ((MatrixContext)_localctx).matrixRow = matrixRow();
						((MatrixContext)_localctx).rows.add(((MatrixContext)_localctx).matrixRow);
						}
						} 
					}
					setState(121);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(123);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(122); match(6);
					}
				}

				}
			}

			setState(127); match(23);
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
		public ExpressionContext expression;
		public List<ExpressionContext> elements = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MatrixRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitMatrixRow(this);
			else return null;
		}
	}

	public final MatrixRowContext matrixRow() throws RecognitionException {
		MatrixRowContext _localctx = new MatrixRowContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_matrixRow);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(19);
			setState(141);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 11) | (1L << 19) | (1L << MATH_NAME) | (1L << INT) | (1L << FLOAT))) != 0)) {
				{
				setState(130); ((MatrixRowContext)_localctx).expression = expression(0);
				((MatrixRowContext)_localctx).elements.add(((MatrixRowContext)_localctx).expression);
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(131); match(6);
						setState(132); ((MatrixRowContext)_localctx).expression = expression(0);
						((MatrixRowContext)_localctx).elements.add(((MatrixRowContext)_localctx).expression);
						}
						} 
					}
					setState(137);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(139);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(138); match(6);
					}
				}

				}
			}

			setState(143); match(23);
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
		case 4: return expression_sempred((ExpressionContext)_localctx, predIndex);

		case 5: return logicalExpression_sempred((LogicalExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 6 >= _localctx._p;

		case 1: return 4 >= _localctx._p;

		case 2: return 3 >= _localctx._p;
		}
		return true;
	}
	private boolean logicalExpression_sempred(LogicalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 4 >= _localctx._p;

		case 4: return 3 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\1\3\33\u0092\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6"+
		"\2\7\7\7\2\b\7\b\1\0\1\0\1\0\1\0\3\0\27\b\0\1\1\1\1\1\1\1\1\1\2\1\2\1"+
		"\2\1\2\1\2\5\2\"\b\2\n\2\f\2%\t\2\3\2\'\b\2\1\2\1\2\1\3\1\3\1\3\1\3\1"+
		"\4\1\4\1\4\1\4\1\4\1\4\1\4\1\4\3\4\67\b\4\1\4\1\4\1\4\1\4\1\4\1\4\1\4"+
		"\1\4\1\4\5\4B\b\4\n\4\f\4E\t\4\1\5\1\5\1\5\1\5\1\5\1\5\1\5\1\5\1\5\3\5"+
		"P\b\5\1\5\1\5\1\5\1\5\1\5\1\5\5\5X\b\5\n\5\f\5[\t\5\1\6\1\6\1\6\1\6\1"+
		"\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\1\6\3\6p\b\6\1"+
		"\7\1\7\1\7\1\7\5\7v\b\7\n\7\f\7y\t\7\1\7\3\7|\b\7\3\7~\b\7\1\7\1\7\1\b"+
		"\1\b\1\b\1\b\5\b\u0086\b\b\n\b\f\b\u0089\t\b\1\b\3\b\u008c\b\b\3\b\u008e"+
		"\b\b\1\b\1\b\1\b\0\t\0\2\4\6\b\n\f\16\20\0\4\2\7\7\t\t\3\1\1\b\b\24\24"+
		"\2\7\7\t\t\4\f\f\16\17\22\22\25\26\u00a2\0\26\1\0\0\0\2\30\1\0\0\0\4\34"+
		"\1\0\0\0\6*\1\0\0\0\b\66\1\0\0\0\nO\1\0\0\0\fo\1\0\0\0\16q\1\0\0\0\20"+
		"\u0081\1\0\0\0\22\27\3\2\1\0\23\27\3\6\3\0\24\27\3\b\4\0\25\27\3\n\5\0"+
		"\26\22\1\0\0\0\26\23\1\0\0\0\26\24\1\0\0\0\26\25\1\0\0\0\27\1\1\0\0\0"+
		"\30\31\3\4\2\0\31\32\5\r\0\0\32\33\3\b\4\0\33\3\1\0\0\0\34\35\5\30\0\0"+
		"\35&\5\13\0\0\36#\3\b\4\0\37 \5\6\0\0 \"\3\b\4\0!\37\1\0\0\0\"%\1\0\0"+
		"\0#!\1\0\0\0#$\1\0\0\0$\'\1\0\0\0%#\1\0\0\0&\36\1\0\0\0&\'\1\0\0\0\'("+
		"\1\0\0\0()\5\4\0\0)\5\1\0\0\0*+\3\b\4\0+,\5\r\0\0,-\3\b\4\0-\7\1\0\0\0"+
		"./\6\4\uffff\0/\60\7\0\0\0\60\67\3\b\4\0\61\62\5\13\0\0\62\63\3\b\4\0"+
		"\63\64\5\4\0\0\64\67\1\0\0\0\65\67\3\f\6\0\66.\1\0\0\0\66\61\1\0\0\0\66"+
		"\65\1\0\0\0\67C\1\0\0\089\4\4\0\19:\5\3\0\0:B\3\b\4\0;<\4\4\1\1<=\7\1"+
		"\0\0=B\3\b\4\0>?\4\4\2\1?@\7\2\0\0@B\3\b\4\0A8\1\0\0\0A;\1\0\0\0A>\1\0"+
		"\0\0BE\1\0\0\0CA\1\0\0\0CD\1\0\0\0D\t\1\0\0\0EC\1\0\0\0FG\6\5\uffff\0"+
		"GH\5\13\0\0HI\3\n\5\0IJ\5\4\0\0JP\1\0\0\0KL\3\b\4\0LM\7\3\0\0MN\3\b\4"+
		"\0NP\1\0\0\0OF\1\0\0\0OK\1\0\0\0PY\1\0\0\0QR\4\5\3\1RS\5\20\0\0SX\3\n"+
		"\5\0TU\4\5\4\1UV\5\21\0\0VX\3\n\5\0WQ\1\0\0\0WT\1\0\0\0X[\1\0\0\0YW\1"+
		"\0\0\0YZ\1\0\0\0Z\13\1\0\0\0[Y\1\0\0\0\\p\5\30\0\0]p\5\33\0\0^p\5\31\0"+
		"\0_p\3\16\7\0`a\5\30\0\0ab\5\n\0\0bc\3\b\4\0cd\5\2\0\0de\5\n\0\0ef\3\b"+
		"\4\0fg\5\2\0\0gp\1\0\0\0hp\3\4\2\0ij\5\30\0\0jk\5\5\0\0kp\3\4\2\0lm\5"+
		"\30\0\0mn\5\5\0\0np\5\30\0\0o\\\1\0\0\0o]\1\0\0\0o^\1\0\0\0o_\1\0\0\0"+
		"o`\1\0\0\0oh\1\0\0\0oi\1\0\0\0ol\1\0\0\0p\r\1\0\0\0q}\5\23\0\0rw\3\20"+
		"\b\0st\5\6\0\0tv\3\20\b\0us\1\0\0\0vy\1\0\0\0wu\1\0\0\0wx\1\0\0\0x{\1"+
		"\0\0\0yw\1\0\0\0z|\5\6\0\0{z\1\0\0\0{|\1\0\0\0|~\1\0\0\0}r\1\0\0\0}~\1"+
		"\0\0\0~\177\1\0\0\0\177\u0080\5\27\0\0\u0080\17\1\0\0\0\u0081\u008d\5"+
		"\23\0\0\u0082\u0087\3\b\4\0\u0083\u0084\5\6\0\0\u0084\u0086\3\b\4\0\u0085"+
		"\u0083\1\0\0\0\u0086\u0089\1\0\0\0\u0087\u0085\1\0\0\0\u0087\u0088\1\0"+
		"\0\0\u0088\u008b\1\0\0\0\u0089\u0087\1\0\0\0\u008a\u008c\5\6\0\0\u008b"+
		"\u008a\1\0\0\0\u008b\u008c\1\0\0\0\u008c\u008e\1\0\0\0\u008d\u0082\1\0"+
		"\0\0\u008d\u008e\1\0\0\0\u008e\u008f\1\0\0\0\u008f\u0090\5\27\0\0\u0090"+
		"\21\1\0\0\0\20\26#&\66ACOWYow{}\u0087\u008b\u008d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}