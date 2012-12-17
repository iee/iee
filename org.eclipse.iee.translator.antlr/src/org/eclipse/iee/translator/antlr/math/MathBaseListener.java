package org.eclipse.iee.translator.antlr.math;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class MathBaseListener implements MathListener {
	@Override public void enterPrimaryFunction(MathParser.PrimaryFunctionContext ctx) { }
	@Override public void exitPrimaryFunction(MathParser.PrimaryFunctionContext ctx) { }
	@Override public void enterLogicComparison(MathParser.LogicComparisonContext ctx) { }
	@Override public void exitLogicComparison(MathParser.LogicComparisonContext ctx) { }
	@Override public void enterFloatNumber(MathParser.FloatNumberContext ctx) { }
	@Override public void exitFloatNumber(MathParser.FloatNumberContext ctx) { }
	@Override public void enterProperty(MathParser.PropertyContext ctx) { }
	@Override public void exitProperty(MathParser.PropertyContext ctx) { }
	@Override public void enterMethodCall(MathParser.MethodCallContext ctx) { }
	@Override public void exitMethodCall(MathParser.MethodCallContext ctx) { }
	@Override public void enterFunction(MathParser.FunctionContext ctx) { }
	@Override public void exitFunction(MathParser.FunctionContext ctx) { }
	@Override public void enterMatrixDefinition(MathParser.MatrixDefinitionContext ctx) { }
	@Override public void exitMatrixDefinition(MathParser.MatrixDefinitionContext ctx) { }
	@Override public void enterTransposeMatrix(MathParser.TransposeMatrixContext ctx) { }
	@Override public void exitTransposeMatrix(MathParser.TransposeMatrixContext ctx) { }
	@Override public void enterAdd(MathParser.AddContext ctx) { }
	@Override public void exitAdd(MathParser.AddContext ctx) { }
	@Override public void enterIntNumber(MathParser.IntNumberContext ctx) { }
	@Override public void exitIntNumber(MathParser.IntNumberContext ctx) { }
	@Override public void enterLogicalFormula(MathParser.LogicalFormulaContext ctx) { }
	@Override public void exitLogicalFormula(MathParser.LogicalFormulaContext ctx) { }
	@Override public void enterMult(MathParser.MultContext ctx) { }
	@Override public void exitMult(MathParser.MultContext ctx) { }
	@Override public void enterPrimaryExpr(MathParser.PrimaryExprContext ctx) { }
	@Override public void exitPrimaryExpr(MathParser.PrimaryExprContext ctx) { }
	@Override public void enterVariable(MathParser.VariableContext ctx) { }
	@Override public void exitVariable(MathParser.VariableContext ctx) { }
	@Override public void enterPower(MathParser.PowerContext ctx) { }
	@Override public void exitPower(MathParser.PowerContext ctx) { }
	@Override public void enterMatrix(MathParser.MatrixContext ctx) { }
	@Override public void exitMatrix(MathParser.MatrixContext ctx) { }
	@Override public void enterLogicMult(MathParser.LogicMultContext ctx) { }
	@Override public void exitLogicMult(MathParser.LogicMultContext ctx) { }
	@Override public void enterLogicBrackets(MathParser.LogicBracketsContext ctx) { }
	@Override public void exitLogicBrackets(MathParser.LogicBracketsContext ctx) { }
	@Override public void enterLogicAdd(MathParser.LogicAddContext ctx) { }
	@Override public void exitLogicAdd(MathParser.LogicAddContext ctx) { }
	@Override public void enterMatrixElement(MathParser.MatrixElementContext ctx) { }
	@Override public void exitMatrixElement(MathParser.MatrixElementContext ctx) { }
	@Override public void enterUnary(MathParser.UnaryContext ctx) { }
	@Override public void exitUnary(MathParser.UnaryContext ctx) { }
	@Override public void enterExprBrackets(MathParser.ExprBracketsContext ctx) { }
	@Override public void exitExprBrackets(MathParser.ExprBracketsContext ctx) { }
	@Override public void enterStatement(MathParser.StatementContext ctx) { }
	@Override public void exitStatement(MathParser.StatementContext ctx) { }
	@Override public void enterFunctionDefinition(MathParser.FunctionDefinitionContext ctx) { }
	@Override public void exitFunctionDefinition(MathParser.FunctionDefinitionContext ctx) { }
	@Override public void enterMatrixRow(MathParser.MatrixRowContext ctx) { }
	@Override public void exitMatrixRow(MathParser.MatrixRowContext ctx) { }
	@Override public void enterVariableAssignment(MathParser.VariableAssignmentContext ctx) { }
	@Override public void exitVariableAssignment(MathParser.VariableAssignmentContext ctx) { }
	@Override public void enterFormula(MathParser.FormulaContext ctx) { }
	@Override public void exitFormula(MathParser.FormulaContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}