package org.eclipse.iee.translator.antlr.math;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MathVisitor<T> {
	T visitPrimaryFunction(MathParser.PrimaryFunctionContext ctx);
	T visitLogicComparison(MathParser.LogicComparisonContext ctx);
	T visitFloatNumber(MathParser.FloatNumberContext ctx);
	T visitProperty(MathParser.PropertyContext ctx);
	T visitMethodCall(MathParser.MethodCallContext ctx);
	T visitFunction(MathParser.FunctionContext ctx);
	T visitMatrixDefinition(MathParser.MatrixDefinitionContext ctx);
	T visitTransposeMatrix(MathParser.TransposeMatrixContext ctx);
	T visitAdd(MathParser.AddContext ctx);
	T visitIntNumber(MathParser.IntNumberContext ctx);
	T visitLogicalFormula(MathParser.LogicalFormulaContext ctx);
	T visitMult(MathParser.MultContext ctx);
	T visitPrimaryExpr(MathParser.PrimaryExprContext ctx);
	T visitVariable(MathParser.VariableContext ctx);
	T visitPower(MathParser.PowerContext ctx);
	T visitMatrix(MathParser.MatrixContext ctx);
	T visitLogicMult(MathParser.LogicMultContext ctx);
	T visitLogicBrackets(MathParser.LogicBracketsContext ctx);
	T visitLogicAdd(MathParser.LogicAddContext ctx);
	T visitMatrixElement(MathParser.MatrixElementContext ctx);
	T visitUnary(MathParser.UnaryContext ctx);
	T visitExprBrackets(MathParser.ExprBracketsContext ctx);
	T visitStatement(MathParser.StatementContext ctx);
	T visitFunctionDefinition(MathParser.FunctionDefinitionContext ctx);
	T visitMatrixRow(MathParser.MatrixRowContext ctx);
	T visitVariableAssignment(MathParser.VariableAssignmentContext ctx);
	T visitFormula(MathParser.FormulaContext ctx);
}