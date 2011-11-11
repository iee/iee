/*
* generated by Xtext
*/

package org.eclipse.iee.translator.jmole.math.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class MathGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class StatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Statement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cFunctionDefinitionAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cFunctionDefinitionFunctionDefinitionParserRuleCall_0_0 = (RuleCall)cFunctionDefinitionAssignment_0.eContents().get(0);
		private final Assignment cMatrixDefinitionAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cMatrixDefinitionMatrixDefinitionParserRuleCall_1_0 = (RuleCall)cMatrixDefinitionAssignment_1.eContents().get(0);
		private final Assignment cAssignmentAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cAssignmentAssignmentParserRuleCall_2_0 = (RuleCall)cAssignmentAssignment_2.eContents().get(0);
		private final Assignment cFormulaAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final RuleCall cFormulaFormulaParserRuleCall_3_0 = (RuleCall)cFormulaAssignment_3.eContents().get(0);
		
		//Statement:
		//	functionDefinition=FunctionDefinition | matrixDefinition=MatrixDefinition | assignment=Assignment | formula=Formula;
		public ParserRule getRule() { return rule; }

		//functionDefinition=FunctionDefinition | matrixDefinition=MatrixDefinition | assignment=Assignment | formula=Formula
		public Alternatives getAlternatives() { return cAlternatives; }

		//functionDefinition=FunctionDefinition
		public Assignment getFunctionDefinitionAssignment_0() { return cFunctionDefinitionAssignment_0; }

		//FunctionDefinition
		public RuleCall getFunctionDefinitionFunctionDefinitionParserRuleCall_0_0() { return cFunctionDefinitionFunctionDefinitionParserRuleCall_0_0; }

		//matrixDefinition=MatrixDefinition
		public Assignment getMatrixDefinitionAssignment_1() { return cMatrixDefinitionAssignment_1; }

		//MatrixDefinition
		public RuleCall getMatrixDefinitionMatrixDefinitionParserRuleCall_1_0() { return cMatrixDefinitionMatrixDefinitionParserRuleCall_1_0; }

		//assignment=Assignment
		public Assignment getAssignmentAssignment_2() { return cAssignmentAssignment_2; }

		//Assignment
		public RuleCall getAssignmentAssignmentParserRuleCall_2_0() { return cAssignmentAssignmentParserRuleCall_2_0; }

		//formula=Formula
		public Assignment getFormulaAssignment_3() { return cFormulaAssignment_3; }

		//Formula
		public RuleCall getFormulaFormulaParserRuleCall_3_0() { return cFormulaFormulaParserRuleCall_3_0; }
	}

	public class AssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Assignment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVariableAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cVariableMATH_NAMETerminalRuleCall_0_0 = (RuleCall)cVariableAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueFormulaParserRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//Assignment:
		//	variable=MATH_NAME "=" value=Formula;
		public ParserRule getRule() { return rule; }

		//variable=MATH_NAME "=" value=Formula
		public Group getGroup() { return cGroup; }

		//variable=MATH_NAME
		public Assignment getVariableAssignment_0() { return cVariableAssignment_0; }

		//MATH_NAME
		public RuleCall getVariableMATH_NAMETerminalRuleCall_0_0() { return cVariableMATH_NAMETerminalRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//value=Formula
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//Formula
		public RuleCall getValueFormulaParserRuleCall_2_0() { return cValueFormulaParserRuleCall_2_0; }
	}

	public class FormulaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Formula");
		private final Assignment cExpressionAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cExpressionAdditionParserRuleCall_0 = (RuleCall)cExpressionAssignment.eContents().get(0);
		
		//Formula:
		//	expression=Addition;
		public ParserRule getRule() { return rule; }

		//expression=Addition
		public Assignment getExpressionAssignment() { return cExpressionAssignment; }

		//Addition
		public RuleCall getExpressionAdditionParserRuleCall_0() { return cExpressionAdditionParserRuleCall_0; }
	}

	public class AdditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Addition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cMultiplicationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Keyword cPlusSignKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Action cAdditionLeftAction_1_0_1 = (Action)cGroup_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cRightMultiplicationParserRuleCall_1_0_2_0 = (RuleCall)cRightAssignment_1_0_2.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Action cSubtractionLeftAction_1_1_1 = (Action)cGroup_1_1.eContents().get(1);
		private final Assignment cRightAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final RuleCall cRightMultiplicationParserRuleCall_1_1_2_0 = (RuleCall)cRightAssignment_1_1_2.eContents().get(0);
		
		//// addition/subtraction: left associative, priority 0
		//Addition returns Expression:
		//	Multiplication ("+" {Addition.left=current} right=Multiplication | "-" {Subtraction.left=current}
		//	right=Multiplication)*;
		public ParserRule getRule() { return rule; }

		//Multiplication ("+" {Addition.left=current} right=Multiplication | "-" {Subtraction.left=current} right=Multiplication)*
		public Group getGroup() { return cGroup; }

		//Multiplication
		public RuleCall getMultiplicationParserRuleCall_0() { return cMultiplicationParserRuleCall_0; }

		//("+" {Addition.left=current} right=Multiplication | "-" {Subtraction.left=current} right=Multiplication)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//"+" {Addition.left=current} right=Multiplication
		public Group getGroup_1_0() { return cGroup_1_0; }

		//"+"
		public Keyword getPlusSignKeyword_1_0_0() { return cPlusSignKeyword_1_0_0; }

		//{Addition.left=current}
		public Action getAdditionLeftAction_1_0_1() { return cAdditionLeftAction_1_0_1; }

		//right=Multiplication
		public Assignment getRightAssignment_1_0_2() { return cRightAssignment_1_0_2; }

		//Multiplication
		public RuleCall getRightMultiplicationParserRuleCall_1_0_2_0() { return cRightMultiplicationParserRuleCall_1_0_2_0; }

		//"-" {Subtraction.left=current} right=Multiplication
		public Group getGroup_1_1() { return cGroup_1_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_1_1_0() { return cHyphenMinusKeyword_1_1_0; }

		//{Subtraction.left=current}
		public Action getSubtractionLeftAction_1_1_1() { return cSubtractionLeftAction_1_1_1; }

		//right=Multiplication
		public Assignment getRightAssignment_1_1_2() { return cRightAssignment_1_1_2; }

		//Multiplication
		public RuleCall getRightMultiplicationParserRuleCall_1_1_2_0() { return cRightMultiplicationParserRuleCall_1_1_2_0; }
	}

	public class MultiplicationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Multiplication");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cUnaryExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Keyword cAsteriskKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Action cMultiplicationLeftAction_1_0_1 = (Action)cGroup_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cRightUnaryExpressionParserRuleCall_1_0_2_0 = (RuleCall)cRightAssignment_1_0_2.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cSolidusKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Action cDivisionLeftAction_1_1_1 = (Action)cGroup_1_1.eContents().get(1);
		private final Assignment cRightAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final RuleCall cRightUnaryExpressionParserRuleCall_1_1_2_0 = (RuleCall)cRightAssignment_1_1_2.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cAlternatives_1.eContents().get(2);
		private final Keyword cPercentSignKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Action cModuloLeftAction_1_2_1 = (Action)cGroup_1_2.eContents().get(1);
		private final Assignment cRightAssignment_1_2_2 = (Assignment)cGroup_1_2.eContents().get(2);
		private final RuleCall cRightUnaryExpressionParserRuleCall_1_2_2_0 = (RuleCall)cRightAssignment_1_2_2.eContents().get(0);
		
		//// multiplication/division, left associative, priority 1
		//Multiplication returns Expression:
		//	UnaryExpression ("*" {Multiplication.left=current} right=UnaryExpression | "/" {Division.left=current}
		//	right=UnaryExpression | "%" {Modulo.left=current} right=UnaryExpression)*;
		public ParserRule getRule() { return rule; }

		//UnaryExpression ("*" {Multiplication.left=current} right=UnaryExpression | "/" {Division.left=current}
		//right=UnaryExpression | "%" {Modulo.left=current} right=UnaryExpression)*
		public Group getGroup() { return cGroup; }

		//UnaryExpression
		public RuleCall getUnaryExpressionParserRuleCall_0() { return cUnaryExpressionParserRuleCall_0; }

		//("*" {Multiplication.left=current} right=UnaryExpression | "/" {Division.left=current} right=UnaryExpression | "%"
		//{Modulo.left=current} right=UnaryExpression)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//"*" {Multiplication.left=current} right=UnaryExpression
		public Group getGroup_1_0() { return cGroup_1_0; }

		//"*"
		public Keyword getAsteriskKeyword_1_0_0() { return cAsteriskKeyword_1_0_0; }

		//{Multiplication.left=current}
		public Action getMultiplicationLeftAction_1_0_1() { return cMultiplicationLeftAction_1_0_1; }

		//right=UnaryExpression
		public Assignment getRightAssignment_1_0_2() { return cRightAssignment_1_0_2; }

		//UnaryExpression
		public RuleCall getRightUnaryExpressionParserRuleCall_1_0_2_0() { return cRightUnaryExpressionParserRuleCall_1_0_2_0; }

		//"/" {Division.left=current} right=UnaryExpression
		public Group getGroup_1_1() { return cGroup_1_1; }

		//"/"
		public Keyword getSolidusKeyword_1_1_0() { return cSolidusKeyword_1_1_0; }

		//{Division.left=current}
		public Action getDivisionLeftAction_1_1_1() { return cDivisionLeftAction_1_1_1; }

		//right=UnaryExpression
		public Assignment getRightAssignment_1_1_2() { return cRightAssignment_1_1_2; }

		//UnaryExpression
		public RuleCall getRightUnaryExpressionParserRuleCall_1_1_2_0() { return cRightUnaryExpressionParserRuleCall_1_1_2_0; }

		//"%" {Modulo.left=current} right=UnaryExpression
		public Group getGroup_1_2() { return cGroup_1_2; }

		//"%"
		public Keyword getPercentSignKeyword_1_2_0() { return cPercentSignKeyword_1_2_0; }

		//{Modulo.left=current}
		public Action getModuloLeftAction_1_2_1() { return cModuloLeftAction_1_2_1; }

		//right=UnaryExpression
		public Assignment getRightAssignment_1_2_2() { return cRightAssignment_1_2_2; }

		//UnaryExpression
		public RuleCall getRightUnaryExpressionParserRuleCall_1_2_2_0() { return cRightUnaryExpressionParserRuleCall_1_2_2_0; }
	}

	public class UnaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cExponentParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Action cInvertAction_1_1 = (Action)cGroup_1.eContents().get(1);
		private final Assignment cExpressionAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cExpressionUnaryExpressionParserRuleCall_1_2_0 = (RuleCall)cExpressionAssignment_1_2.eContents().get(0);
		
		//// Unary operators: right associative, priority 2
		//UnaryExpression returns Expression:
		//	Exponent | "-" {Invert} expression=UnaryExpression;
		public ParserRule getRule() { return rule; }

		//Exponent | "-" {Invert} expression=UnaryExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//Exponent
		public RuleCall getExponentParserRuleCall_0() { return cExponentParserRuleCall_0; }

		//"-" {Invert} expression=UnaryExpression
		public Group getGroup_1() { return cGroup_1; }

		//"-"
		public Keyword getHyphenMinusKeyword_1_0() { return cHyphenMinusKeyword_1_0; }

		//{Invert}
		public Action getInvertAction_1_1() { return cInvertAction_1_1; }

		//expression=UnaryExpression
		public Assignment getExpressionAssignment_1_2() { return cExpressionAssignment_1_2; }

		//UnaryExpression
		public RuleCall getExpressionUnaryExpressionParserRuleCall_1_2_0() { return cExpressionUnaryExpressionParserRuleCall_1_2_0; }
	}

	public class ExponentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Exponent");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExponentLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cCircumflexAccentKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightPrimaryParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//// exponentiation: right associative, priority 3
		//Exponent returns Expression:
		//	Primary ({Exponent.left=current} "^" right=Primary)?;
		public ParserRule getRule() { return rule; }

		//Primary ({Exponent.left=current} "^" right=Primary)?
		public Group getGroup() { return cGroup; }

		//Primary
		public RuleCall getPrimaryParserRuleCall_0() { return cPrimaryParserRuleCall_0; }

		//({Exponent.left=current} "^" right=Primary)?
		public Group getGroup_1() { return cGroup_1; }

		//{Exponent.left=current}
		public Action getExponentLeftAction_1_0() { return cExponentLeftAction_1_0; }

		//"^"
		public Keyword getCircumflexAccentKeyword_1_1() { return cCircumflexAccentKeyword_1_1; }

		//right=Primary
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//Primary
		public RuleCall getRightPrimaryParserRuleCall_1_2_0() { return cRightPrimaryParserRuleCall_1_2_0; }
	}

	public class PrimaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Primary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cVariableAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cNameMATH_NAMETerminalRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cFloatAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cValueAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cValueFloatParserRuleCall_1_1_0 = (RuleCall)cValueAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cFunctionAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Assignment cFunctionAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cFunctionFunctionParserRuleCall_2_1_0 = (RuleCall)cFunctionAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final RuleCall cAdditionParserRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//Primary returns Expression:
		//	{Variable} name=MATH_NAME | {Float} value=Float | {Function} function=Function | "(" Addition ")";
		public ParserRule getRule() { return rule; }

		//{Variable} name=MATH_NAME | {Float} value=Float | {Function} function=Function | "(" Addition ")"
		public Alternatives getAlternatives() { return cAlternatives; }

		//{Variable} name=MATH_NAME
		public Group getGroup_0() { return cGroup_0; }

		//{Variable}
		public Action getVariableAction_0_0() { return cVariableAction_0_0; }

		//name=MATH_NAME
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//MATH_NAME
		public RuleCall getNameMATH_NAMETerminalRuleCall_0_1_0() { return cNameMATH_NAMETerminalRuleCall_0_1_0; }

		//{Float} value=Float
		public Group getGroup_1() { return cGroup_1; }

		//{Float}
		public Action getFloatAction_1_0() { return cFloatAction_1_0; }

		//value=Float
		public Assignment getValueAssignment_1_1() { return cValueAssignment_1_1; }

		//Float
		public RuleCall getValueFloatParserRuleCall_1_1_0() { return cValueFloatParserRuleCall_1_1_0; }

		//{Function} function=Function
		public Group getGroup_2() { return cGroup_2; }

		//{Function}
		public Action getFunctionAction_2_0() { return cFunctionAction_2_0; }

		//function=Function
		public Assignment getFunctionAssignment_2_1() { return cFunctionAssignment_2_1; }

		//Function
		public RuleCall getFunctionFunctionParserRuleCall_2_1_0() { return cFunctionFunctionParserRuleCall_2_1_0; }

		//"(" Addition ")"
		public Group getGroup_3() { return cGroup_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//Addition
		public RuleCall getAdditionParserRuleCall_3_1() { return cAdditionParserRuleCall_3_1; }

		//")"
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
	}

	public class FloatElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Float");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Alternatives cAlternatives_1_2_0 = (Alternatives)cGroup_1_2.eContents().get(0);
		private final Keyword cEKeyword_1_2_0_0 = (Keyword)cAlternatives_1_2_0.eContents().get(0);
		private final Keyword cEKeyword_1_2_0_1 = (Keyword)cAlternatives_1_2_0.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_1_2_1 = (Keyword)cGroup_1_2.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1_2_2 = (RuleCall)cGroup_1_2.eContents().get(2);
		
		//Float:
		//	INT+ ("." INT+ (("E" | "e") "-"? INT+)?)?;
		public ParserRule getRule() { return rule; }

		//INT+ ("." INT+ (("E" | "e") "-"? INT+)?)?
		public Group getGroup() { return cGroup; }

		//INT+
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//("." INT+ (("E" | "e") "-"? INT+)?)?
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//INT+
		public RuleCall getINTTerminalRuleCall_1_1() { return cINTTerminalRuleCall_1_1; }

		//(("E" | "e") "-"? INT+)?
		public Group getGroup_1_2() { return cGroup_1_2; }

		//"E" | "e"
		public Alternatives getAlternatives_1_2_0() { return cAlternatives_1_2_0; }

		//"E"
		public Keyword getEKeyword_1_2_0_0() { return cEKeyword_1_2_0_0; }

		//"e"
		public Keyword getEKeyword_1_2_0_1() { return cEKeyword_1_2_0_1; }

		//"-"?
		public Keyword getHyphenMinusKeyword_1_2_1() { return cHyphenMinusKeyword_1_2_1; }

		//INT+
		public RuleCall getINTTerminalRuleCall_1_2_2() { return cINTTerminalRuleCall_1_2_2; }
	}

	public class FunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Function");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameMATH_NAMETerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cParametersAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cParametersFormulaParserRuleCall_2_0_0 = (RuleCall)cParametersAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cParametersAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cParametersFormulaParserRuleCall_2_1_1_0 = (RuleCall)cParametersAssignment_2_1_1.eContents().get(0);
		private final Keyword cCommaKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Function returns Expression:
		//	name=MATH_NAME "(" (parameters+=Formula ("," parameters+=Formula)* ","?)? ")";
		public ParserRule getRule() { return rule; }

		//name=MATH_NAME "(" (parameters+=Formula ("," parameters+=Formula)* ","?)? ")"
		public Group getGroup() { return cGroup; }

		//name=MATH_NAME
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//MATH_NAME
		public RuleCall getNameMATH_NAMETerminalRuleCall_0_0() { return cNameMATH_NAMETerminalRuleCall_0_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(parameters+=Formula ("," parameters+=Formula)* ","?)?
		public Group getGroup_2() { return cGroup_2; }

		//parameters+=Formula
		public Assignment getParametersAssignment_2_0() { return cParametersAssignment_2_0; }

		//Formula
		public RuleCall getParametersFormulaParserRuleCall_2_0_0() { return cParametersFormulaParserRuleCall_2_0_0; }

		//("," parameters+=Formula)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//parameters+=Formula
		public Assignment getParametersAssignment_2_1_1() { return cParametersAssignment_2_1_1; }

		//Formula
		public RuleCall getParametersFormulaParserRuleCall_2_1_1_0() { return cParametersFormulaParserRuleCall_2_1_1_0; }

		//","?
		public Keyword getCommaKeyword_2_2() { return cCommaKeyword_2_2; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class FunctionDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FunctionDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cFunctionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cFunctionFunctionParserRuleCall_0_0 = (RuleCall)cFunctionAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cFormulaAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cFormulaFormulaParserRuleCall_2_0 = (RuleCall)cFormulaAssignment_2.eContents().get(0);
		
		//FunctionDefinition:
		//	function=Function "=" formula=Formula;
		public ParserRule getRule() { return rule; }

		//function=Function "=" formula=Formula
		public Group getGroup() { return cGroup; }

		//function=Function
		public Assignment getFunctionAssignment_0() { return cFunctionAssignment_0; }

		//Function
		public RuleCall getFunctionFunctionParserRuleCall_0_0() { return cFunctionFunctionParserRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//formula=Formula
		public Assignment getFormulaAssignment_2() { return cFormulaAssignment_2; }

		//Formula
		public RuleCall getFormulaFormulaParserRuleCall_2_0() { return cFormulaFormulaParserRuleCall_2_0; }
	}

	public class MatrixDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MatrixDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameMATH_NAMETerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cRowsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cRowsMatrixRowParserRuleCall_3_0_0 = (RuleCall)cRowsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cRowsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cRowsMatrixRowParserRuleCall_3_1_1_0 = (RuleCall)cRowsAssignment_3_1_1.eContents().get(0);
		private final Keyword cCommaKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//MatrixDefinition:
		//	name=MATH_NAME "=" "{" (rows+=MatrixRow ("," rows+=MatrixRow)* ","?)? "}";
		public ParserRule getRule() { return rule; }

		//name=MATH_NAME "=" "{" (rows+=MatrixRow ("," rows+=MatrixRow)* ","?)? "}"
		public Group getGroup() { return cGroup; }

		//name=MATH_NAME
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//MATH_NAME
		public RuleCall getNameMATH_NAMETerminalRuleCall_0_0() { return cNameMATH_NAMETerminalRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//(rows+=MatrixRow ("," rows+=MatrixRow)* ","?)?
		public Group getGroup_3() { return cGroup_3; }

		//rows+=MatrixRow
		public Assignment getRowsAssignment_3_0() { return cRowsAssignment_3_0; }

		//MatrixRow
		public RuleCall getRowsMatrixRowParserRuleCall_3_0_0() { return cRowsMatrixRowParserRuleCall_3_0_0; }

		//("," rows+=MatrixRow)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//rows+=MatrixRow
		public Assignment getRowsAssignment_3_1_1() { return cRowsAssignment_3_1_1; }

		//MatrixRow
		public RuleCall getRowsMatrixRowParserRuleCall_3_1_1_0() { return cRowsMatrixRowParserRuleCall_3_1_1_0; }

		//","?
		public Keyword getCommaKeyword_3_2() { return cCommaKeyword_3_2; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class MatrixRowElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MatrixRow");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cElementsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cElementsFloatParserRuleCall_1_0_0 = (RuleCall)cElementsAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cCommaKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cElementsFloatParserRuleCall_1_1_1_0 = (RuleCall)cElementsAssignment_1_1_1.eContents().get(0);
		private final Keyword cCommaKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Keyword cRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//MatrixRow:
		//	"{" (elements+=Float ("," elements+=Float)* ","?)? "}";
		public ParserRule getRule() { return rule; }

		//"{" (elements+=Float ("," elements+=Float)* ","?)? "}"
		public Group getGroup() { return cGroup; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//(elements+=Float ("," elements+=Float)* ","?)?
		public Group getGroup_1() { return cGroup_1; }

		//elements+=Float
		public Assignment getElementsAssignment_1_0() { return cElementsAssignment_1_0; }

		//Float
		public RuleCall getElementsFloatParserRuleCall_1_0_0() { return cElementsFloatParserRuleCall_1_0_0; }

		//("," elements+=Float)*
		public Group getGroup_1_1() { return cGroup_1_1; }

		//","
		public Keyword getCommaKeyword_1_1_0() { return cCommaKeyword_1_1_0; }

		//elements+=Float
		public Assignment getElementsAssignment_1_1_1() { return cElementsAssignment_1_1_1; }

		//Float
		public RuleCall getElementsFloatParserRuleCall_1_1_1_0() { return cElementsFloatParserRuleCall_1_1_1_0; }

		//","?
		public Keyword getCommaKeyword_1_2() { return cCommaKeyword_1_2; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2() { return cRightCurlyBracketKeyword_2; }
	}
	
	
	private StatementElements pStatement;
	private AssignmentElements pAssignment;
	private FormulaElements pFormula;
	private AdditionElements pAddition;
	private MultiplicationElements pMultiplication;
	private UnaryExpressionElements pUnaryExpression;
	private ExponentElements pExponent;
	private PrimaryElements pPrimary;
	private FloatElements pFloat;
	private FunctionElements pFunction;
	private FunctionDefinitionElements pFunctionDefinition;
	private MatrixDefinitionElements pMatrixDefinition;
	private MatrixRowElements pMatrixRow;
	private TerminalRule tMATH_NAME;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public MathGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammarProvider = grammarProvider;
		this.gaTerminals = gaTerminals;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Statement:
	//	functionDefinition=FunctionDefinition | matrixDefinition=MatrixDefinition | assignment=Assignment | formula=Formula;
	public StatementElements getStatementAccess() {
		return (pStatement != null) ? pStatement : (pStatement = new StatementElements());
	}
	
	public ParserRule getStatementRule() {
		return getStatementAccess().getRule();
	}

	//Assignment:
	//	variable=MATH_NAME "=" value=Formula;
	public AssignmentElements getAssignmentAccess() {
		return (pAssignment != null) ? pAssignment : (pAssignment = new AssignmentElements());
	}
	
	public ParserRule getAssignmentRule() {
		return getAssignmentAccess().getRule();
	}

	//Formula:
	//	expression=Addition;
	public FormulaElements getFormulaAccess() {
		return (pFormula != null) ? pFormula : (pFormula = new FormulaElements());
	}
	
	public ParserRule getFormulaRule() {
		return getFormulaAccess().getRule();
	}

	//// addition/subtraction: left associative, priority 0
	//Addition returns Expression:
	//	Multiplication ("+" {Addition.left=current} right=Multiplication | "-" {Subtraction.left=current}
	//	right=Multiplication)*;
	public AdditionElements getAdditionAccess() {
		return (pAddition != null) ? pAddition : (pAddition = new AdditionElements());
	}
	
	public ParserRule getAdditionRule() {
		return getAdditionAccess().getRule();
	}

	//// multiplication/division, left associative, priority 1
	//Multiplication returns Expression:
	//	UnaryExpression ("*" {Multiplication.left=current} right=UnaryExpression | "/" {Division.left=current}
	//	right=UnaryExpression | "%" {Modulo.left=current} right=UnaryExpression)*;
	public MultiplicationElements getMultiplicationAccess() {
		return (pMultiplication != null) ? pMultiplication : (pMultiplication = new MultiplicationElements());
	}
	
	public ParserRule getMultiplicationRule() {
		return getMultiplicationAccess().getRule();
	}

	//// Unary operators: right associative, priority 2
	//UnaryExpression returns Expression:
	//	Exponent | "-" {Invert} expression=UnaryExpression;
	public UnaryExpressionElements getUnaryExpressionAccess() {
		return (pUnaryExpression != null) ? pUnaryExpression : (pUnaryExpression = new UnaryExpressionElements());
	}
	
	public ParserRule getUnaryExpressionRule() {
		return getUnaryExpressionAccess().getRule();
	}

	//// exponentiation: right associative, priority 3
	//Exponent returns Expression:
	//	Primary ({Exponent.left=current} "^" right=Primary)?;
	public ExponentElements getExponentAccess() {
		return (pExponent != null) ? pExponent : (pExponent = new ExponentElements());
	}
	
	public ParserRule getExponentRule() {
		return getExponentAccess().getRule();
	}

	//Primary returns Expression:
	//	{Variable} name=MATH_NAME | {Float} value=Float | {Function} function=Function | "(" Addition ")";
	public PrimaryElements getPrimaryAccess() {
		return (pPrimary != null) ? pPrimary : (pPrimary = new PrimaryElements());
	}
	
	public ParserRule getPrimaryRule() {
		return getPrimaryAccess().getRule();
	}

	//Float:
	//	INT+ ("." INT+ (("E" | "e") "-"? INT+)?)?;
	public FloatElements getFloatAccess() {
		return (pFloat != null) ? pFloat : (pFloat = new FloatElements());
	}
	
	public ParserRule getFloatRule() {
		return getFloatAccess().getRule();
	}

	//Function returns Expression:
	//	name=MATH_NAME "(" (parameters+=Formula ("," parameters+=Formula)* ","?)? ")";
	public FunctionElements getFunctionAccess() {
		return (pFunction != null) ? pFunction : (pFunction = new FunctionElements());
	}
	
	public ParserRule getFunctionRule() {
		return getFunctionAccess().getRule();
	}

	//FunctionDefinition:
	//	function=Function "=" formula=Formula;
	public FunctionDefinitionElements getFunctionDefinitionAccess() {
		return (pFunctionDefinition != null) ? pFunctionDefinition : (pFunctionDefinition = new FunctionDefinitionElements());
	}
	
	public ParserRule getFunctionDefinitionRule() {
		return getFunctionDefinitionAccess().getRule();
	}

	//MatrixDefinition:
	//	name=MATH_NAME "=" "{" (rows+=MatrixRow ("," rows+=MatrixRow)* ","?)? "}";
	public MatrixDefinitionElements getMatrixDefinitionAccess() {
		return (pMatrixDefinition != null) ? pMatrixDefinition : (pMatrixDefinition = new MatrixDefinitionElements());
	}
	
	public ParserRule getMatrixDefinitionRule() {
		return getMatrixDefinitionAccess().getRule();
	}

	//MatrixRow:
	//	"{" (elements+=Float ("," elements+=Float)* ","?)? "}";
	public MatrixRowElements getMatrixRowAccess() {
		return (pMatrixRow != null) ? pMatrixRow : (pMatrixRow = new MatrixRowElements());
	}
	
	public ParserRule getMatrixRowRule() {
		return getMatrixRowAccess().getRule();
	}

	//terminal MATH_NAME:
	//	("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getMATH_NAMERule() {
		return (tMATH_NAME != null) ? tMATH_NAME : (tMATH_NAME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "MATH_NAME"));
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
