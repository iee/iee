// Generated from D:\sergey\antlr\math\Math.g4 by ANTLR 4.0
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
		T__6=17, T__5=18, T__4=19, T__3=20, T__2=21, T__1=22, T__0=23, INTERNAL_FUNCTION_NAME=24, 
		MATH_NAME=25, LETTER=26, INT=27, WS=28, FLOAT=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'%'", "']'", "'^'", "')'", "'.'", "','", "'+'", "'*'", "'-'", 
		"'['", "'('", "'<'", "'='", "'!='", "'<='", "'&&'", "'||'", "'>'", "'{'", 
		"'/'", "'=='", "'>='", "'}'", "INTERNAL_FUNCTION_NAME", "MATH_NAME", "LETTER", 
		"INT", "WS", "FLOAT"
	};
	public static final int
		RULE_statement = 0, RULE_functionDefinition = 1, RULE_function = 2, RULE_internalFunction = 3, 
		RULE_standardFunction = 4, RULE_variableAssignment = 5, RULE_expression = 6, 
		RULE_logicalExpression = 7, RULE_primary = 8, RULE_parameter = 9, RULE_matrix = 10, 
		RULE_matrixRow = 11;
	public static final String[] ruleNames = {
		"statement", "functionDefinition", "function", "internalFunction", "standardFunction", 
		"variableAssignment", "expression", "logicalExpression", "primary", "parameter", 
		"matrix", "matrixRow"
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
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		try {
			setState(28);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); functionDefinition();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); variableAssignment();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26); expression(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(27); logicalExpression(0);
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
		public StandardFunctionContext name;
		public ExpressionContext value;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StandardFunctionContext standardFunction() {
			return getRuleContext(StandardFunctionContext.class,0);
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
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); ((FunctionDefinitionContext)_localctx).name = standardFunction();
			setState(31); match(13);
			setState(32); ((FunctionDefinitionContext)_localctx).value = expression(0);
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
		public InternalFunctionContext internalFunction() {
			return getRuleContext(InternalFunctionContext.class,0);
		}
		public StandardFunctionContext standardFunction() {
			return getRuleContext(StandardFunctionContext.class,0);
		}
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
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			setState(36);
			switch (_input.LA(1)) {
			case MATH_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); standardFunction();
				}
				break;
			case INTERNAL_FUNCTION_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(35); internalFunction();
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

	public static class InternalFunctionContext extends ParserRuleContext {
		public Token name;
		public ExpressionContext func;
		public ParameterContext parameter;
		public List<ParameterContext> params = new ArrayList<ParameterContext>();
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public TerminalNode INTERNAL_FUNCTION_NAME() { return getToken(MathParser.INTERNAL_FUNCTION_NAME, 0); }
		public InternalFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_internalFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterInternalFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitInternalFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitInternalFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InternalFunctionContext internalFunction() throws RecognitionException {
		InternalFunctionContext _localctx = new InternalFunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_internalFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); ((InternalFunctionContext)_localctx).name = match(INTERNAL_FUNCTION_NAME);
			setState(39); match(11);
			setState(40); ((InternalFunctionContext)_localctx).func = expression(0);
			setState(52);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(41); match(6);
				setState(50);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(42); ((InternalFunctionContext)_localctx).parameter = parameter();
					((InternalFunctionContext)_localctx).params.add(((InternalFunctionContext)_localctx).parameter);
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==6) {
						{
						{
						setState(43); match(6);
						setState(44); ((InternalFunctionContext)_localctx).parameter = parameter();
						((InternalFunctionContext)_localctx).params.add(((InternalFunctionContext)_localctx).parameter);
						}
						}
						setState(49);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
			}

			setState(54); match(4);
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

	public static class StandardFunctionContext extends ParserRuleContext {
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
		public StandardFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standardFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterStandardFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitStandardFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitStandardFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandardFunctionContext standardFunction() throws RecognitionException {
		StandardFunctionContext _localctx = new StandardFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_standardFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); ((StandardFunctionContext)_localctx).name = match(MATH_NAME);
			setState(57); match(11);
			setState(66);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 11) | (1L << 19) | (1L << INTERNAL_FUNCTION_NAME) | (1L << MATH_NAME) | (1L << INT) | (1L << FLOAT))) != 0)) {
				{
				setState(58); ((StandardFunctionContext)_localctx).expression = expression(0);
				((StandardFunctionContext)_localctx).params.add(((StandardFunctionContext)_localctx).expression);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==6) {
					{
					{
					setState(59); match(6);
					setState(60); ((StandardFunctionContext)_localctx).expression = expression(0);
					((StandardFunctionContext)_localctx).params.add(((StandardFunctionContext)_localctx).expression);
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(68); match(4);
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
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); ((VariableAssignmentContext)_localctx).name = expression(0);
			setState(71); match(13);
			setState(72); ((VariableAssignmentContext)_localctx).value = expression(0);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			switch (_input.LA(1)) {
			case 7:
			case 9:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(75);
				((UnaryContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==7 || _la==9) ) {
					((UnaryContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(76); ((UnaryContext)_localctx).unaryExpr = expression(5);
				}
				break;
			case 11:
				{
				_localctx = new ExprBracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); match(11);
				setState(78); ((ExprBracketsContext)_localctx).bracketedExpr = expression(0);
				setState(79); match(4);
				}
				break;
			case 19:
			case INTERNAL_FUNCTION_NAME:
			case MATH_NAME:
			case INT:
			case FLOAT:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81); primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExpressionContext(_parentctx, _parentState, _p));
						((PowerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(85); match(3);
						setState(86); ((PowerContext)_localctx).right = expression(6);
						}
						break;

					case 2:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState, _p));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(88);
						((MultContext)_localctx).sign = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 8) | (1L << 20))) != 0)) ) {
							((MultContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(89); ((MultContext)_localctx).right = expression(5);
						}
						break;

					case 3:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState, _p));
						((AddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(91);
						((AddContext)_localctx).sign = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==7 || _la==9) ) {
							((AddContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(92); ((AddContext)_localctx).right = expression(4);
						}
						break;
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, _parentState, _p);
		LogicalExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_logicalExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new LogicBracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(99); match(11);
				setState(100); ((LogicBracketsContext)_localctx).expr = logicalExpression(0);
				setState(101); match(4);
				}
				break;

			case 2:
				{
				_localctx = new LogicComparisonContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103); ((LogicComparisonContext)_localctx).left = expression(0);
				setState(104);
				((LogicComparisonContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 21) | (1L << 22))) != 0)) ) {
					((LogicComparisonContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(105); ((LogicComparisonContext)_localctx).right = expression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(115);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new LogicMultContext(new LogicalExpressionContext(_parentctx, _parentState, _p));
						((LogicMultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(109);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(110); ((LogicMultContext)_localctx).sign = match(16);
						setState(111); ((LogicMultContext)_localctx).right = logicalExpression(5);
						}
						break;

					case 2:
						{
						_localctx = new LogicAddContext(new LogicalExpressionContext(_parentctx, _parentState, _p));
						((LogicAddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(112);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(113); ((LogicAddContext)_localctx).sign = match(17);
						setState(114); ((LogicAddContext)_localctx).right = logicalExpression(4);
						}
						break;
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
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
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primary);
		try {
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120); match(MATH_NAME);
				}
				break;

			case 2:
				_localctx = new FloatNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121); match(FLOAT);
				}
				break;

			case 3:
				_localctx = new IntNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122); match(INT);
				}
				break;

			case 4:
				_localctx = new MatrixDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123); matrix();
				}
				break;

			case 5:
				_localctx = new MatrixElementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(124); ((MatrixElementContext)_localctx).name = match(MATH_NAME);
				setState(125); match(10);
				setState(126); ((MatrixElementContext)_localctx).rowIdx = expression(0);
				setState(127); match(2);
				setState(128); match(10);
				setState(129); ((MatrixElementContext)_localctx).columnIdx = expression(0);
				setState(130); match(2);
				}
				break;

			case 6:
				_localctx = new PrimaryFunctionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(132); function();
				}
				break;

			case 7:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(133); ((MethodCallContext)_localctx).objName = match(MATH_NAME);
				setState(134); match(5);
				setState(135); ((MethodCallContext)_localctx).objFunction = function();
				}
				break;

			case 8:
				_localctx = new PropertyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(136); ((PropertyContext)_localctx).objName = match(MATH_NAME);
				setState(137); match(5);
				setState(138); ((PropertyContext)_localctx).objProperty = match(MATH_NAME);
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

	public static class ParameterContext extends ParserRuleContext {
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	 
		public ParameterContext() { }
		public void copyFrom(ParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueParameterContext extends ParameterContext {
		public Token variable;
		public Token value;
		public TerminalNode FLOAT() { return getToken(MathParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(MathParser.INT, 0); }
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public ValueParameterContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterValueParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitValueParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitValueParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntervalParameterContext extends ParameterContext {
		public Token variable;
		public Token min;
		public Token max;
		public List<TerminalNode> FLOAT() { return getTokens(MathParser.FLOAT); }
		public List<TerminalNode> INT() { return getTokens(MathParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(MathParser.INT, i);
		}
		public TerminalNode FLOAT(int i) {
			return getToken(MathParser.FLOAT, i);
		}
		public TerminalNode MATH_NAME() { return getToken(MathParser.MATH_NAME, 0); }
		public IntervalParameterContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterIntervalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitIntervalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathVisitor ) return ((MathVisitor<? extends T>)visitor).visitIntervalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter);
		int _la;
		try {
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ValueParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141); match(19);
				setState(142); ((ValueParameterContext)_localctx).variable = match(MATH_NAME);
				setState(143); match(6);
				setState(144);
				((ValueParameterContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
					((ValueParameterContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(145); match(23);
				}
				break;

			case 2:
				_localctx = new IntervalParameterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146); match(19);
				setState(147); ((IntervalParameterContext)_localctx).variable = match(MATH_NAME);
				setState(148); match(6);
				setState(149);
				((IntervalParameterContext)_localctx).min = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
					((IntervalParameterContext)_localctx).min = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(150); match(6);
				setState(151);
				((IntervalParameterContext)_localctx).max = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
					((IntervalParameterContext)_localctx).max = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(152); match(23);
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
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_matrix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155); match(19);
			setState(167);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(156); ((MatrixContext)_localctx).matrixRow = matrixRow();
				((MatrixContext)_localctx).rows.add(((MatrixContext)_localctx).matrixRow);
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(157); match(6);
						setState(158); ((MatrixContext)_localctx).matrixRow = matrixRow();
						((MatrixContext)_localctx).rows.add(((MatrixContext)_localctx).matrixRow);
						}
						} 
					}
					setState(163);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(165);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(164); match(6);
					}
				}

				}
			}

			setState(169); match(23);
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
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixRowContext matrixRow() throws RecognitionException {
		MatrixRowContext _localctx = new MatrixRowContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_matrixRow);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171); match(19);
			setState(183);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 11) | (1L << 19) | (1L << INTERNAL_FUNCTION_NAME) | (1L << MATH_NAME) | (1L << INT) | (1L << FLOAT))) != 0)) {
				{
				setState(172); ((MatrixRowContext)_localctx).expression = expression(0);
				((MatrixRowContext)_localctx).elements.add(((MatrixRowContext)_localctx).expression);
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(173); match(6);
						setState(174); ((MatrixRowContext)_localctx).expression = expression(0);
						((MatrixRowContext)_localctx).elements.add(((MatrixRowContext)_localctx).expression);
						}
						} 
					}
					setState(179);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(181);
				_la = _input.LA(1);
				if (_la==6) {
					{
					setState(180); match(6);
					}
				}

				}
			}

			setState(185); match(23);
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
		case 6: return expression_sempred((ExpressionContext)_localctx, predIndex);

		case 7: return logicalExpression_sempred((LogicalExpressionContext)_localctx, predIndex);
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
		"\2\3\37\u00be\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\5\2\37\n\2"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\5\4\'\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\60"+
		"\n\5\f\5\16\5\63\13\5\5\5\65\n\5\5\5\67\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\7\6@\n\6\f\6\16\6C\13\6\5\6E\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\bU\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\b`\n\b\f\b\16\bc\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008e\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009c\n\13"+
		"\3\f\3\f\3\f\3\f\7\f\u00a2\n\f\f\f\16\f\u00a5\13\f\3\f\5\f\u00a8\n\f\5"+
		"\f\u00aa\n\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00b2\n\r\f\r\16\r\u00b5\13\r"+
		"\3\r\5\r\u00b8\n\r\5\r\u00ba\n\r\3\r\3\r\3\r\2\16\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\2\t\4\t\t\13\13\5\3\3\n\n\26\26\4\t\t\13\13\6\16\16\20\21\24"+
		"\24\27\30\4\35\35\37\37\4\35\35\37\37\4\35\35\37\37\u00d0\2\36\3\2\2\2"+
		"\4 \3\2\2\2\6&\3\2\2\2\b(\3\2\2\2\n:\3\2\2\2\fH\3\2\2\2\16T\3\2\2\2\20"+
		"m\3\2\2\2\22\u008d\3\2\2\2\24\u009b\3\2\2\2\26\u009d\3\2\2\2\30\u00ad"+
		"\3\2\2\2\32\37\5\4\3\2\33\37\5\f\7\2\34\37\5\16\b\2\35\37\5\20\t\2\36"+
		"\32\3\2\2\2\36\33\3\2\2\2\36\34\3\2\2\2\36\35\3\2\2\2\37\3\3\2\2\2 !\5"+
		"\n\6\2!\"\7\17\2\2\"#\5\16\b\2#\5\3\2\2\2$\'\5\n\6\2%\'\5\b\5\2&$\3\2"+
		"\2\2&%\3\2\2\2\'\7\3\2\2\2()\7\32\2\2)*\7\r\2\2*\66\5\16\b\2+\64\7\b\2"+
		"\2,\61\5\24\13\2-.\7\b\2\2.\60\5\24\13\2/-\3\2\2\2\60\63\3\2\2\2\61/\3"+
		"\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\64,\3\2\2\2\64\65\3\2"+
		"\2\2\65\67\3\2\2\2\66+\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\6\2\29\t"+
		"\3\2\2\2:;\7\33\2\2;D\7\r\2\2<A\5\16\b\2=>\7\b\2\2>@\5\16\b\2?=\3\2\2"+
		"\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BE\3\2\2\2CA\3\2\2\2D<\3\2\2\2DE\3\2\2"+
		"\2EF\3\2\2\2FG\7\6\2\2G\13\3\2\2\2HI\5\16\b\2IJ\7\17\2\2JK\5\16\b\2K\r"+
		"\3\2\2\2LM\b\b\1\2MN\t\2\2\2NU\5\16\b\2OP\7\r\2\2PQ\5\16\b\2QR\7\6\2\2"+
		"RU\3\2\2\2SU\5\22\n\2TL\3\2\2\2TO\3\2\2\2TS\3\2\2\2Ua\3\2\2\2VW\6\b\2"+
		"\3WX\7\5\2\2X`\5\16\b\2YZ\6\b\3\3Z[\t\3\2\2[`\5\16\b\2\\]\6\b\4\3]^\t"+
		"\4\2\2^`\5\16\b\2_V\3\2\2\2_Y\3\2\2\2_\\\3\2\2\2`c\3\2\2\2a_\3\2\2\2a"+
		"b\3\2\2\2b\17\3\2\2\2ca\3\2\2\2de\b\t\1\2ef\7\r\2\2fg\5\20\t\2gh\7\6\2"+
		"\2hn\3\2\2\2ij\5\16\b\2jk\t\5\2\2kl\5\16\b\2ln\3\2\2\2md\3\2\2\2mi\3\2"+
		"\2\2nw\3\2\2\2op\6\t\5\3pq\7\22\2\2qv\5\20\t\2rs\6\t\6\3st\7\23\2\2tv"+
		"\5\20\t\2uo\3\2\2\2ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\21\3\2\2"+
		"\2yw\3\2\2\2z\u008e\7\33\2\2{\u008e\7\37\2\2|\u008e\7\35\2\2}\u008e\5"+
		"\26\f\2~\177\7\33\2\2\177\u0080\7\f\2\2\u0080\u0081\5\16\b\2\u0081\u0082"+
		"\7\4\2\2\u0082\u0083\7\f\2\2\u0083\u0084\5\16\b\2\u0084\u0085\7\4\2\2"+
		"\u0085\u008e\3\2\2\2\u0086\u008e\5\6\4\2\u0087\u0088\7\33\2\2\u0088\u0089"+
		"\7\7\2\2\u0089\u008e\5\6\4\2\u008a\u008b\7\33\2\2\u008b\u008c\7\7\2\2"+
		"\u008c\u008e\7\33\2\2\u008dz\3\2\2\2\u008d{\3\2\2\2\u008d|\3\2\2\2\u008d"+
		"}\3\2\2\2\u008d~\3\2\2\2\u008d\u0086\3\2\2\2\u008d\u0087\3\2\2\2\u008d"+
		"\u008a\3\2\2\2\u008e\23\3\2\2\2\u008f\u0090\7\25\2\2\u0090\u0091\7\33"+
		"\2\2\u0091\u0092\7\b\2\2\u0092\u0093\t\6\2\2\u0093\u009c\7\31\2\2\u0094"+
		"\u0095\7\25\2\2\u0095\u0096\7\33\2\2\u0096\u0097\7\b\2\2\u0097\u0098\t"+
		"\7\2\2\u0098\u0099\7\b\2\2\u0099\u009a\t\b\2\2\u009a\u009c\7\31\2\2\u009b"+
		"\u008f\3\2\2\2\u009b\u0094\3\2\2\2\u009c\25\3\2\2\2\u009d\u00a9\7\25\2"+
		"\2\u009e\u00a3\5\30\r\2\u009f\u00a0\7\b\2\2\u00a0\u00a2\5\30\r\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8\7\b\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u009e\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\31\2\2\u00ac"+
		"\27\3\2\2\2\u00ad\u00b9\7\25\2\2\u00ae\u00b3\5\16\b\2\u00af\u00b0\7\b"+
		"\2\2\u00b0\u00b2\5\16\b\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b6\u00b8\7\b\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00ae\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bc\7\31\2\2\u00bc\31\3\2\2\2\27\36&\61\64\66ADT_amuw\u008d"+
		"\u009b\u00a3\u00a7\u00a9\u00b3\u00b7\u00b9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}