/*
* generated by Xtext
*/
grammar InternalMath;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
	
}

@lexer::header {
package org.eclipse.iee.translator.molex.math.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.iee.translator.molex.math.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.iee.translator.molex.math.services.MathGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/
 
 	private MathGrammarAccess grammarAccess;
 	
    public InternalMathParser(TokenStream input, MathGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Statement";	
   	}
   	
   	@Override
   	protected MathGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleStatement
entryRuleStatement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStatementRule()); }
	 iv_ruleStatement=ruleStatement 
	 { $current=$iv_ruleStatement.current; } 
	 EOF 
;

// Rule Statement
ruleStatement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getStatementAccess().getFunctionDefinitionFunctionDefinitionParserRuleCall_0_0()); 
	    }
		lv_functionDefinition_0_0=ruleFunctionDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStatementRule());
	        }
       		set(
       			$current, 
       			"functionDefinition",
        		lv_functionDefinition_0_0, 
        		"FunctionDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixDefinitionMatrixDefinitionParserRuleCall_1_0()); 
	    }
		lv_matrixDefinition_1_0=ruleMatrixDefinition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStatementRule());
	        }
       		set(
       			$current, 
       			"matrixDefinition",
        		lv_matrixDefinition_1_0, 
        		"MatrixDefinition");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getStatementAccess().getAssignmentAssignmentParserRuleCall_2_0()); 
	    }
		lv_assignment_2_0=ruleAssignment		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStatementRule());
	        }
       		set(
       			$current, 
       			"assignment",
        		lv_assignment_2_0, 
        		"Assignment");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getStatementAccess().getFormulaFormulaParserRuleCall_3_0()); 
	    }
		lv_formula_3_0=ruleFormula		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStatementRule());
	        }
       		set(
       			$current, 
       			"formula",
        		lv_formula_3_0, 
        		"Formula");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleAssignment
entryRuleAssignment returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssignmentRule()); }
	 iv_ruleAssignment=ruleAssignment 
	 { $current=$iv_ruleAssignment.current; } 
	 EOF 
;

// Rule Assignment
ruleAssignment returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_variable_0_0=RULE_MATH_NAME
		{
			newLeafNode(lv_variable_0_0, grammarAccess.getAssignmentAccess().getVariableMATH_NAMETerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssignmentRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"variable",
        		lv_variable_0_0, 
        		"MATH_NAME");
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssignmentAccess().getValueFormulaParserRuleCall_2_0()); 
	    }
		lv_value_2_0=ruleFormula		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssignmentRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"Formula");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleFormula
entryRuleFormula returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFormulaRule()); }
	 iv_ruleFormula=ruleFormula 
	 { $current=$iv_ruleFormula.current; } 
	 EOF 
;

// Rule Formula
ruleFormula returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getFormulaAccess().getExpressionAdditionParserRuleCall_0()); 
	    }
		lv_expression_0_0=ruleAddition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFormulaRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_0_0, 
        		"Addition");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleAddition
entryRuleAddition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAdditionRule()); }
	 iv_ruleAddition=ruleAddition 
	 { $current=$iv_ruleAddition.current; } 
	 EOF 
;

// Rule Addition
ruleAddition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
    }
    this_Multiplication_0=ruleMultiplication
    { 
        $current = $this_Multiplication_0.current; 
        afterParserOrEnumRuleCall();
    }
((	otherlv_1='+' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0());
    }
(
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_0_2_0()); 
	    }
		lv_right_3_0=ruleMultiplication		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAdditionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"Multiplication");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(	otherlv_4='-' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_1_0());
    }
(
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_2_0()); 
	    }
		lv_right_6_0=ruleMultiplication		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAdditionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_6_0, 
        		"Multiplication");
	        afterParserOrEnumRuleCall();
	    }

)
)))*)
;





// Entry rule entryRuleMultiplication
entryRuleMultiplication returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMultiplicationRule()); }
	 iv_ruleMultiplication=ruleMultiplication 
	 { $current=$iv_ruleMultiplication.current; } 
	 EOF 
;

// Rule Multiplication
ruleMultiplication returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryExpressionParserRuleCall_0()); 
    }
    this_UnaryExpression_0=ruleUnaryExpression
    { 
        $current = $this_UnaryExpression_0.current; 
        afterParserOrEnumRuleCall();
    }
((	otherlv_1='*' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0());
    }
(
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_0_2_0()); 
	    }
		lv_right_3_0=ruleUnaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicationRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"UnaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(	otherlv_4='/' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_1_0());
    }
(
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_1_2_0()); 
	    }
		lv_right_6_0=ruleUnaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicationRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_6_0, 
        		"UnaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(	otherlv_7='%' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_2_0());
    }
(
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_2_2_0()); 
	    }
		lv_right_9_0=ruleUnaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicationRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_9_0, 
        		"UnaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)))*)
;





// Entry rule entryRuleUnaryExpression
entryRuleUnaryExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnaryExpressionRule()); }
	 iv_ruleUnaryExpression=ruleUnaryExpression 
	 { $current=$iv_ruleUnaryExpression.current; } 
	 EOF 
;

// Rule UnaryExpression
ruleUnaryExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExponentParserRuleCall_0()); 
    }
    this_Exponent_0=ruleExponent
    { 
        $current = $this_Exponent_0.current; 
        afterParserOrEnumRuleCall();
    }

    |(	otherlv_1='-' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUnaryExpressionAccess().getHyphenMinusKeyword_1_0());
    }
(
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getUnaryExpressionAccess().getInvertAction_1_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_1_2_0()); 
	    }
		lv_expression_3_0=ruleUnaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_3_0, 
        		"UnaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(	otherlv_4='(' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_2_0());
    }
(
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getUnaryExpressionAccess().getFactorialAction_2_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_2_2_0()); 
	    }
		lv_expression_6_0=ruleUnaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_6_0, 
        		"UnaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=')!' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getUnaryExpressionAccess().getRightParenthesisExclamationMarkKeyword_2_3());
    }
)
    |((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getUnaryExpressionAccess().getIntervalAction_3_0(),
            $current);
    }
)(
(
(
		lv_openingBracket_9_1=	'[' 
    {
        newLeafNode(lv_openingBracket_9_1, grammarAccess.getUnaryExpressionAccess().getOpeningBracketLeftSquareBracketKeyword_3_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUnaryExpressionRule());
	        }
       		setWithLastConsumed($current, "openingBracket", lv_openingBracket_9_1, null);
	    }

    |		lv_openingBracket_9_2=	'(' 
    {
        newLeafNode(lv_openingBracket_9_2, grammarAccess.getUnaryExpressionAccess().getOpeningBracketLeftParenthesisKeyword_3_1_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUnaryExpressionRule());
	        }
       		setWithLastConsumed($current, "openingBracket", lv_openingBracket_9_2, null);
	    }

)

)
)	otherlv_10='(' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_3_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getCeilUnaryExpressionParserRuleCall_3_3_0()); 
	    }
		lv_ceil_11_0=ruleUnaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
	        }
       		set(
       			$current, 
       			"ceil",
        		lv_ceil_11_0, 
        		"UnaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_12=')' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getUnaryExpressionAccess().getRightParenthesisKeyword_3_4());
    }
	otherlv_13='..' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getUnaryExpressionAccess().getFullStopFullStopKeyword_3_5());
    }
	otherlv_14='(' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_3_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getFloorUnaryExpressionParserRuleCall_3_7_0()); 
	    }
		lv_floor_15_0=ruleUnaryExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
	        }
       		set(
       			$current, 
       			"floor",
        		lv_floor_15_0, 
        		"UnaryExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_16=')' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getUnaryExpressionAccess().getRightParenthesisKeyword_3_8());
    }
(
(
(
		lv_closingBracket_17_1=	']' 
    {
        newLeafNode(lv_closingBracket_17_1, grammarAccess.getUnaryExpressionAccess().getClosingBracketRightSquareBracketKeyword_3_9_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUnaryExpressionRule());
	        }
       		setWithLastConsumed($current, "closingBracket", lv_closingBracket_17_1, null);
	    }

    |		lv_closingBracket_17_2=	')' 
    {
        newLeafNode(lv_closingBracket_17_2, grammarAccess.getUnaryExpressionAccess().getClosingBracketRightParenthesisKeyword_3_9_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUnaryExpressionRule());
	        }
       		setWithLastConsumed($current, "closingBracket", lv_closingBracket_17_2, null);
	    }

)

)
)))
;





// Entry rule entryRuleExponent
entryRuleExponent returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExponentRule()); }
	 iv_ruleExponent=ruleExponent 
	 { $current=$iv_ruleExponent.current; } 
	 EOF 
;

// Rule Exponent
ruleExponent returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getExponentAccess().getPrimaryParserRuleCall_0()); 
    }
    this_Primary_0=rulePrimary
    { 
        $current = $this_Primary_0.current; 
        afterParserOrEnumRuleCall();
    }
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getExponentAccess().getExponentLeftAction_1_0(),
            $current);
    }
)	otherlv_2='^' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getExponentAccess().getRightPrimaryParserRuleCall_1_2_0()); 
	    }
		lv_right_3_0=rulePrimary		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExponentRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_3_0, 
        		"Primary");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRulePrimary
entryRulePrimary returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrimaryRule()); }
	 iv_rulePrimary=rulePrimary 
	 { $current=$iv_rulePrimary.current; } 
	 EOF 
;

// Rule Primary
rulePrimary returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrimaryAccess().getVariableAction_0_0(),
            $current);
    }
)(
(
		lv_name_1_0=RULE_MATH_NAME
		{
			newLeafNode(lv_name_1_0, grammarAccess.getPrimaryAccess().getNameMATH_NAMETerminalRuleCall_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPrimaryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"MATH_NAME");
	    }

)
))
    |((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrimaryAccess().getFloatAction_1_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPrimaryAccess().getValueFloatParserRuleCall_1_1_0()); 
	    }
		lv_value_3_0=ruleFloat		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrimaryRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_3_0, 
        		"Float");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrimaryAccess().getFunctionAction_2_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPrimaryAccess().getFunctionFunctionParserRuleCall_2_1_0()); 
	    }
		lv_function_5_0=ruleFunction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrimaryRule());
	        }
       		set(
       			$current, 
       			"function",
        		lv_function_5_0, 
        		"Function");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |(	otherlv_6='(' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_3_0());
    }

	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryAccess().getAdditionParserRuleCall_3_1()); 
    }
    this_Addition_7=ruleAddition
    { 
        $current = $this_Addition_7.current; 
        afterParserOrEnumRuleCall();
    }
	otherlv_8=')' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_3_2());
    }
))
;





// Entry rule entryRuleFloat
entryRuleFloat returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getFloatRule()); } 
	 iv_ruleFloat=ruleFloat 
	 { $current=$iv_ruleFloat.current.getText(); }  
	 EOF 
;

// Rule Float
ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getFloatAccess().getINTTerminalRuleCall_0()); 
    }
)+(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1_0()); 
    }
(    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_1()); 
    }
)+((
	kw='E' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_0()); 
    }

    |
	kw='e' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_1()); 
    }
)(
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFloatAccess().getHyphenMinusKeyword_1_2_1()); 
    }
)?(    this_INT_6=RULE_INT    {
		$current.merge(this_INT_6);
    }

    { 
    newLeafNode(this_INT_6, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_2_2()); 
    }
)+)?)?)
    ;





// Entry rule entryRuleFunction
entryRuleFunction returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFunctionRule()); }
	 iv_ruleFunction=ruleFunction 
	 { $current=$iv_ruleFunction.current; } 
	 EOF 
;

// Rule Function
ruleFunction returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_MATH_NAME
		{
			newLeafNode(lv_name_0_0, grammarAccess.getFunctionAccess().getNameMATH_NAMETerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFunctionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"MATH_NAME");
	    }

)
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_0_0()); 
	    }
		lv_parameters_2_0=ruleFormula		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionRule());
	        }
       		add(
       			$current, 
       			"parameters",
        		lv_parameters_2_0, 
        		"Formula");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_1_1_0()); 
	    }
		lv_parameters_4_0=ruleFormula		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionRule());
	        }
       		add(
       			$current, 
       			"parameters",
        		lv_parameters_4_0, 
        		"Formula");
	        afterParserOrEnumRuleCall();
	    }

)
))*(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
    }
)?)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleFunctionDefinition
entryRuleFunctionDefinition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFunctionDefinitionRule()); }
	 iv_ruleFunctionDefinition=ruleFunctionDefinition 
	 { $current=$iv_ruleFunctionDefinition.current; } 
	 EOF 
;

// Rule FunctionDefinition
ruleFunctionDefinition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctionFunctionParserRuleCall_0_0()); 
	    }
		lv_function_0_0=ruleFunction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
	        }
       		set(
       			$current, 
       			"function",
        		lv_function_0_0, 
        		"Function");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getEqualsSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_2_0()); 
	    }
		lv_formula_2_0=ruleFormula		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
	        }
       		set(
       			$current, 
       			"formula",
        		lv_formula_2_0, 
        		"Formula");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleMatrixDefinition
entryRuleMatrixDefinition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMatrixDefinitionRule()); }
	 iv_ruleMatrixDefinition=ruleMatrixDefinition 
	 { $current=$iv_ruleMatrixDefinition.current; } 
	 EOF 
;

// Rule MatrixDefinition
ruleMatrixDefinition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_MATH_NAME
		{
			newLeafNode(lv_name_0_0, grammarAccess.getMatrixDefinitionAccess().getNameMATH_NAMETerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMatrixDefinitionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"MATH_NAME");
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMatrixDefinitionAccess().getEqualsSignKeyword_1());
    }
	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMatrixDefinitionAccess().getLeftCurlyBracketKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getMatrixDefinitionAccess().getRowsMatrixRowParserRuleCall_3_0_0()); 
	    }
		lv_rows_3_0=ruleMatrixRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMatrixDefinitionRule());
	        }
       		add(
       			$current, 
       			"rows",
        		lv_rows_3_0, 
        		"MatrixRow");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMatrixDefinitionAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMatrixDefinitionAccess().getRowsMatrixRowParserRuleCall_3_1_1_0()); 
	    }
		lv_rows_5_0=ruleMatrixRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMatrixDefinitionRule());
	        }
       		add(
       			$current, 
       			"rows",
        		lv_rows_5_0, 
        		"MatrixRow");
	        afterParserOrEnumRuleCall();
	    }

)
))*(	otherlv_6=',' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMatrixDefinitionAccess().getCommaKeyword_3_2());
    }
)?)?	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getMatrixDefinitionAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleMatrixRow
entryRuleMatrixRow returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMatrixRowRule()); }
	 iv_ruleMatrixRow=ruleMatrixRow 
	 { $current=$iv_ruleMatrixRow.current; } 
	 EOF 
;

// Rule MatrixRow
ruleMatrixRow returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMatrixRowAccess().getLeftCurlyBracketKeyword_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_0_0()); 
	    }
		lv_elements_1_0=ruleFloat		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMatrixRowRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_1_0, 
        		"Float");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=',' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_1_1_0()); 
	    }
		lv_elements_3_0=ruleFloat		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMatrixRowRule());
	        }
       		add(
       			$current, 
       			"elements",
        		lv_elements_3_0, 
        		"Float");
	        afterParserOrEnumRuleCall();
	    }

)
))*(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
    }
)?)?	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMatrixRowAccess().getRightCurlyBracketKeyword_2());
    }
)
;





RULE_MATH_NAME : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


