// Generated from D:\sergey\antlr\math\Math.g4 by ANTLR 4.0
package org.eclipse.iee.translator.antlr.math;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MathListener extends ParseTreeListener {
	void enterPrimaryFunction(MathParser.PrimaryFunctionContext ctx);
	void exitPrimaryFunction(MathParser.PrimaryFunctionContext ctx);

	void enterLogicComparison(MathParser.LogicComparisonContext ctx);
	void exitLogicComparison(MathParser.LogicComparisonContext ctx);

	void enterFloatNumber(MathParser.FloatNumberContext ctx);
	void exitFloatNumber(MathParser.FloatNumberContext ctx);

	void enterProperty(MathParser.PropertyContext ctx);
	void exitProperty(MathParser.PropertyContext ctx);

	void enterMethodCall(MathParser.MethodCallContext ctx);
	void exitMethodCall(MathParser.MethodCallContext ctx);

	void enterStandardFunction(MathParser.StandardFunctionContext ctx);
	void exitStandardFunction(MathParser.StandardFunctionContext ctx);

	void enterBitwiseOr(MathParser.BitwiseOrContext ctx);
	void exitBitwiseOr(MathParser.BitwiseOrContext ctx);

	void enterFunction(MathParser.FunctionContext ctx);
	void exitFunction(MathParser.FunctionContext ctx);

	void enterInternalFunction(MathParser.InternalFunctionContext ctx);
	void exitInternalFunction(MathParser.InternalFunctionContext ctx);

	void enterMatrixDefinition(MathParser.MatrixDefinitionContext ctx);
	void exitMatrixDefinition(MathParser.MatrixDefinitionContext ctx);

	void enterIntervalParameter(MathParser.IntervalParameterContext ctx);
	void exitIntervalParameter(MathParser.IntervalParameterContext ctx);

	void enterAdd(MathParser.AddContext ctx);
	void exitAdd(MathParser.AddContext ctx);

	void enterIntNumber(MathParser.IntNumberContext ctx);
	void exitIntNumber(MathParser.IntNumberContext ctx);

	void enterXor(MathParser.XorContext ctx);
	void exitXor(MathParser.XorContext ctx);

	void enterMult(MathParser.MultContext ctx);
	void exitMult(MathParser.MultContext ctx);

	void enterPrimaryExpr(MathParser.PrimaryExprContext ctx);
	void exitPrimaryExpr(MathParser.PrimaryExprContext ctx);

	void enterVariable(MathParser.VariableContext ctx);
	void exitVariable(MathParser.VariableContext ctx);

	void enterPower(MathParser.PowerContext ctx);
	void exitPower(MathParser.PowerContext ctx);

	void enterMatrix(MathParser.MatrixContext ctx);
	void exitMatrix(MathParser.MatrixContext ctx);

	void enterLogicMult(MathParser.LogicMultContext ctx);
	void exitLogicMult(MathParser.LogicMultContext ctx);

	void enterShift(MathParser.ShiftContext ctx);
	void exitShift(MathParser.ShiftContext ctx);

	void enterLogicBrackets(MathParser.LogicBracketsContext ctx);
	void exitLogicBrackets(MathParser.LogicBracketsContext ctx);

	void enterLogicAdd(MathParser.LogicAddContext ctx);
	void exitLogicAdd(MathParser.LogicAddContext ctx);

	void enterMatrixElement(MathParser.MatrixElementContext ctx);
	void exitMatrixElement(MathParser.MatrixElementContext ctx);

	void enterUnary(MathParser.UnaryContext ctx);
	void exitUnary(MathParser.UnaryContext ctx);

	void enterExprBrackets(MathParser.ExprBracketsContext ctx);
	void exitExprBrackets(MathParser.ExprBracketsContext ctx);

	void enterStatement(MathParser.StatementContext ctx);
	void exitStatement(MathParser.StatementContext ctx);

	void enterFunctionDefinition(MathParser.FunctionDefinitionContext ctx);
	void exitFunctionDefinition(MathParser.FunctionDefinitionContext ctx);

	void enterValueParameter(MathParser.ValueParameterContext ctx);
	void exitValueParameter(MathParser.ValueParameterContext ctx);

	void enterMatrixRow(MathParser.MatrixRowContext ctx);
	void exitMatrixRow(MathParser.MatrixRowContext ctx);

	void enterVariableAssignment(MathParser.VariableAssignmentContext ctx);
	void exitVariableAssignment(MathParser.VariableAssignmentContext ctx);

	void enterBitwiseAdd(MathParser.BitwiseAddContext ctx);
	void exitBitwiseAdd(MathParser.BitwiseAddContext ctx);
}