package org.eclipse.iee.translator.antlr.math;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class MathBaseVisitor<T> extends ParseTreeVisitor<T> implements MathVisitor<T> {
	@Override public T visitMult(MathParser.MultContext ctx) { return visitChildren(ctx); }
	@Override public T visitVariable(MathParser.VariableContext ctx) { return visitChildren(ctx); }
	@Override public T visitPrimaryExpr(MathParser.PrimaryExprContext ctx) { return visitChildren(ctx); }
	@Override public T visitPrimaryFunction(MathParser.PrimaryFunctionContext ctx) { return visitChildren(ctx); }
	@Override public T visitPower(MathParser.PowerContext ctx) { return visitChildren(ctx); }
	@Override public T visitMatrix(MathParser.MatrixContext ctx) { return visitChildren(ctx); }
	@Override public T visitLogicMult(MathParser.LogicMultContext ctx) { return visitChildren(ctx); }
	@Override public T visitFloatNumber(MathParser.FloatNumberContext ctx) { return visitChildren(ctx); }
	@Override public T visitLogicComparison(MathParser.LogicComparisonContext ctx) { return visitChildren(ctx); }
	@Override public T visitLogicBrackets(MathParser.LogicBracketsContext ctx) { return visitChildren(ctx); }
	@Override public T visitProperty(MathParser.PropertyContext ctx) { return visitChildren(ctx); }
	@Override public T visitLogicAdd(MathParser.LogicAddContext ctx) { return visitChildren(ctx); }
	@Override public T visitMethodCall(MathParser.MethodCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitMatrixElement(MathParser.MatrixElementContext ctx) { return visitChildren(ctx); }
	@Override public T visitUnary(MathParser.UnaryContext ctx) { return visitChildren(ctx); }
	@Override public T visitFunction(MathParser.FunctionContext ctx) { return visitChildren(ctx); }
	@Override public T visitExprBrackets(MathParser.ExprBracketsContext ctx) { return visitChildren(ctx); }
	@Override public T visitStatement(MathParser.StatementContext ctx) { return visitChildren(ctx); }
	@Override public T visitFunctionDefinition(MathParser.FunctionDefinitionContext ctx) { return visitChildren(ctx); }
	@Override public T visitMatrixDefinition(MathParser.MatrixDefinitionContext ctx) { return visitChildren(ctx); }
	@Override public T visitMatrixRow(MathParser.MatrixRowContext ctx) { return visitChildren(ctx); }
	@Override public T visitIntNumber(MathParser.IntNumberContext ctx) { return visitChildren(ctx); }
	@Override public T visitAdd(MathParser.AddContext ctx) { return visitChildren(ctx); }
	@Override public T visitVariableAssignment(MathParser.VariableAssignmentContext ctx) { return visitChildren(ctx); }
}