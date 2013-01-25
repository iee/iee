// Generated from D:\sergey\antlr\math\Math.g4 by ANTLR 4.0
package org.eclipse.iee.translator.antlr.math;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MathVisitor<T> extends ParseTreeVisitor<T> {
	T visitMult(MathParser.MultContext ctx);

	T visitVariable(MathParser.VariableContext ctx);

	T visitPrimaryExpr(MathParser.PrimaryExprContext ctx);

	T visitPrimaryFunction(MathParser.PrimaryFunctionContext ctx);

	T visitPower(MathParser.PowerContext ctx);

	T visitMatrix(MathParser.MatrixContext ctx);

	T visitLogicMult(MathParser.LogicMultContext ctx);

	T visitFloatNumber(MathParser.FloatNumberContext ctx);

	T visitLogicComparison(MathParser.LogicComparisonContext ctx);

	T visitLogicBrackets(MathParser.LogicBracketsContext ctx);

	T visitProperty(MathParser.PropertyContext ctx);

	T visitLogicAdd(MathParser.LogicAddContext ctx);

	T visitMethodCall(MathParser.MethodCallContext ctx);

	T visitMatrixElement(MathParser.MatrixElementContext ctx);

	T visitUnary(MathParser.UnaryContext ctx);

	T visitFunction(MathParser.FunctionContext ctx);

	T visitExprBrackets(MathParser.ExprBracketsContext ctx);

	T visitStatement(MathParser.StatementContext ctx);

	T visitFunctionDefinition(MathParser.FunctionDefinitionContext ctx);

	T visitMatrixDefinition(MathParser.MatrixDefinitionContext ctx);

	T visitMatrixRow(MathParser.MatrixRowContext ctx);

	T visitIntNumber(MathParser.IntNumberContext ctx);

	T visitAdd(MathParser.AddContext ctx);

	T visitVariableAssignment(MathParser.VariableAssignmentContext ctx);
}