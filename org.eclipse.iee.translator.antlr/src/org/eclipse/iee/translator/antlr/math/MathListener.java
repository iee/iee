// Generated from D:\sergey\antlr\math\Math.g4 by ANTLR 4.0
package org.eclipse.iee.translator.antlr.math;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MathListener extends ParseTreeListener {
	void enterMult(MathParser.MultContext ctx);
	void exitMult(MathParser.MultContext ctx);

	void enterVariable(MathParser.VariableContext ctx);
	void exitVariable(MathParser.VariableContext ctx);

	void enterPrimaryExpr(MathParser.PrimaryExprContext ctx);
	void exitPrimaryExpr(MathParser.PrimaryExprContext ctx);

	void enterPrimaryFunction(MathParser.PrimaryFunctionContext ctx);
	void exitPrimaryFunction(MathParser.PrimaryFunctionContext ctx);

	void enterPower(MathParser.PowerContext ctx);
	void exitPower(MathParser.PowerContext ctx);

	void enterMatrix(MathParser.MatrixContext ctx);
	void exitMatrix(MathParser.MatrixContext ctx);

	void enterLogicMult(MathParser.LogicMultContext ctx);
	void exitLogicMult(MathParser.LogicMultContext ctx);

	void enterFloatNumber(MathParser.FloatNumberContext ctx);
	void exitFloatNumber(MathParser.FloatNumberContext ctx);

	void enterLogicComparison(MathParser.LogicComparisonContext ctx);
	void exitLogicComparison(MathParser.LogicComparisonContext ctx);

	void enterLogicBrackets(MathParser.LogicBracketsContext ctx);
	void exitLogicBrackets(MathParser.LogicBracketsContext ctx);

	void enterProperty(MathParser.PropertyContext ctx);
	void exitProperty(MathParser.PropertyContext ctx);

	void enterLogicAdd(MathParser.LogicAddContext ctx);
	void exitLogicAdd(MathParser.LogicAddContext ctx);

	void enterMethodCall(MathParser.MethodCallContext ctx);
	void exitMethodCall(MathParser.MethodCallContext ctx);

	void enterMatrixElement(MathParser.MatrixElementContext ctx);
	void exitMatrixElement(MathParser.MatrixElementContext ctx);

	void enterUnary(MathParser.UnaryContext ctx);
	void exitUnary(MathParser.UnaryContext ctx);

	void enterFunction(MathParser.FunctionContext ctx);
	void exitFunction(MathParser.FunctionContext ctx);

	void enterExprBrackets(MathParser.ExprBracketsContext ctx);
	void exitExprBrackets(MathParser.ExprBracketsContext ctx);

	void enterStatement(MathParser.StatementContext ctx);
	void exitStatement(MathParser.StatementContext ctx);

	void enterFunctionDefinition(MathParser.FunctionDefinitionContext ctx);
	void exitFunctionDefinition(MathParser.FunctionDefinitionContext ctx);

	void enterMatrixDefinition(MathParser.MatrixDefinitionContext ctx);
	void exitMatrixDefinition(MathParser.MatrixDefinitionContext ctx);

	void enterMatrixRow(MathParser.MatrixRowContext ctx);
	void exitMatrixRow(MathParser.MatrixRowContext ctx);

	void enterIntNumber(MathParser.IntNumberContext ctx);
	void exitIntNumber(MathParser.IntNumberContext ctx);

	void enterAdd(MathParser.AddContext ctx);
	void exitAdd(MathParser.AddContext ctx);

	void enterVariableAssignment(MathParser.VariableAssignmentContext ctx);
	void exitVariableAssignment(MathParser.VariableAssignmentContext ctx);
}