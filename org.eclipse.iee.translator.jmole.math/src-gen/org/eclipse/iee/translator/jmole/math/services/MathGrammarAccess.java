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
	
	
	public class FormulaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Formula");
		private final Assignment cExpressionAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cExpressionAdditionParserRuleCall_0 = (RuleCall)cExpressionAssignment.eContents().get(0);
		
		////Formula:
		//
		////	expression=Expression;
		//
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
		private final Action cAdditionLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Keyword cPlusSignKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cRightMultiplicationParserRuleCall_1_0_2_0 = (RuleCall)cRightAssignment_1_0_2.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Action cSubtractionLeftAction_1_1_0 = (Action)cGroup_1_1.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final Assignment cRightAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final RuleCall cRightMultiplicationParserRuleCall_1_1_2_0 = (RuleCall)cRightAssignment_1_1_2.eContents().get(0);
		
		//Addition returns Expression:
		//	Multiplication ({Addition.left=current} "+" right=Multiplication | {Subtraction.left=current} "-"
		//	right=Multiplication)*;
		public ParserRule getRule() { return rule; }

		//Multiplication ({Addition.left=current} "+" right=Multiplication | {Subtraction.left=current} "-" right=Multiplication)*
		public Group getGroup() { return cGroup; }

		//Multiplication
		public RuleCall getMultiplicationParserRuleCall_0() { return cMultiplicationParserRuleCall_0; }

		//({Addition.left=current} "+" right=Multiplication | {Subtraction.left=current} "-" right=Multiplication)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//{Addition.left=current} "+" right=Multiplication
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Addition.left=current}
		public Action getAdditionLeftAction_1_0_0() { return cAdditionLeftAction_1_0_0; }

		//"+"
		public Keyword getPlusSignKeyword_1_0_1() { return cPlusSignKeyword_1_0_1; }

		//right=Multiplication
		public Assignment getRightAssignment_1_0_2() { return cRightAssignment_1_0_2; }

		//Multiplication
		public RuleCall getRightMultiplicationParserRuleCall_1_0_2_0() { return cRightMultiplicationParserRuleCall_1_0_2_0; }

		//{Subtraction.left=current} "-" right=Multiplication
		public Group getGroup_1_1() { return cGroup_1_1; }

		//{Subtraction.left=current}
		public Action getSubtractionLeftAction_1_1_0() { return cSubtractionLeftAction_1_1_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_1_1_1() { return cHyphenMinusKeyword_1_1_1; }

		//right=Multiplication
		public Assignment getRightAssignment_1_1_2() { return cRightAssignment_1_1_2; }

		//Multiplication
		public RuleCall getRightMultiplicationParserRuleCall_1_1_2_0() { return cRightMultiplicationParserRuleCall_1_1_2_0; }
	}

	public class MultiplicationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Multiplication");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPowerParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Action cMultiplicationLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Keyword cAsteriskKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cRightPowerParserRuleCall_1_0_2_0 = (RuleCall)cRightAssignment_1_0_2.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Action cDivisionLeftAction_1_1_0 = (Action)cGroup_1_1.eContents().get(0);
		private final Keyword cSolidusKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final Assignment cRightAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final RuleCall cRightPowerParserRuleCall_1_1_2_0 = (RuleCall)cRightAssignment_1_1_2.eContents().get(0);
		
		//Multiplication returns Expression:
		//	Power ({Multiplication.left=current} "*" right=Power | {Division.left=current} "/" right=Power)*;
		public ParserRule getRule() { return rule; }

		//Power ({Multiplication.left=current} "*" right=Power | {Division.left=current} "/" right=Power)*
		public Group getGroup() { return cGroup; }

		//Power
		public RuleCall getPowerParserRuleCall_0() { return cPowerParserRuleCall_0; }

		//({Multiplication.left=current} "*" right=Power | {Division.left=current} "/" right=Power)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//{Multiplication.left=current} "*" right=Power
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Multiplication.left=current}
		public Action getMultiplicationLeftAction_1_0_0() { return cMultiplicationLeftAction_1_0_0; }

		//"*"
		public Keyword getAsteriskKeyword_1_0_1() { return cAsteriskKeyword_1_0_1; }

		//right=Power
		public Assignment getRightAssignment_1_0_2() { return cRightAssignment_1_0_2; }

		//Power
		public RuleCall getRightPowerParserRuleCall_1_0_2_0() { return cRightPowerParserRuleCall_1_0_2_0; }

		//{Division.left=current} "/" right=Power
		public Group getGroup_1_1() { return cGroup_1_1; }

		//{Division.left=current}
		public Action getDivisionLeftAction_1_1_0() { return cDivisionLeftAction_1_1_0; }

		//"/"
		public Keyword getSolidusKeyword_1_1_1() { return cSolidusKeyword_1_1_1; }

		//right=Power
		public Assignment getRightAssignment_1_1_2() { return cRightAssignment_1_1_2; }

		//Power
		public RuleCall getRightPowerParserRuleCall_1_1_2_0() { return cRightPowerParserRuleCall_1_1_2_0; }
	}

	public class PowerElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Power");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cPowerLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cCircumflexAccentKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightPrimaryParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Power returns Expression:
		//	Primary ({Power.left=current} "^" right=Primary)?;
		public ParserRule getRule() { return rule; }

		//Primary ({Power.left=current} "^" right=Primary)?
		public Group getGroup() { return cGroup; }

		//Primary
		public RuleCall getPrimaryParserRuleCall_0() { return cPrimaryParserRuleCall_0; }

		//({Power.left=current} "^" right=Primary)?
		public Group getGroup_1() { return cGroup_1; }

		//{Power.left=current}
		public Action getPowerLeftAction_1_0() { return cPowerLeftAction_1_0; }

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
		private final RuleCall cNameIDTerminalRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cFloatAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cValueAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cValueFloatParserRuleCall_1_1_0 = (RuleCall)cValueAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cAdditionParserRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		
		//Primary returns Expression:
		//	{Variable} name=ID | //{Number} value=INT |
		//
		//	{Float} value=Float | "(" Addition ")";
		public ParserRule getRule() { return rule; }

		//{Variable} name=ID | //{Number} value=INT |
		//
		//{Float} value=Float | "(" Addition ")"
		public Alternatives getAlternatives() { return cAlternatives; }

		//{Variable} name=ID
		public Group getGroup_0() { return cGroup_0; }

		//{Variable}
		public Action getVariableAction_0_0() { return cVariableAction_0_0; }

		//name=ID
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_1_0() { return cNameIDTerminalRuleCall_0_1_0; }

		////{Number} value=INT |
		//
		//{Float} value=Float
		public Group getGroup_1() { return cGroup_1; }

		////{Number} value=INT |
		//
		//{Float}
		public Action getFloatAction_1_0() { return cFloatAction_1_0; }

		//value=Float
		public Assignment getValueAssignment_1_1() { return cValueAssignment_1_1; }

		//Float
		public RuleCall getValueFloatParserRuleCall_1_1_0() { return cValueFloatParserRuleCall_1_1_0; }

		//"(" Addition ")"
		public Group getGroup_2() { return cGroup_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//Addition
		public RuleCall getAdditionParserRuleCall_2_1() { return cAdditionParserRuleCall_2_1; }

		//")"
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }
	}

	public class FloatElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Float");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		/// *
		//
		//Expression:
		//
		//	PrimaryExpression {Plus.left=current} '+' right=Expression |
		//
		//	PrimaryExpression {Minus.left=current} '-' right=Expression |
		//
		//	PrimaryExpression {Mult.left=current} '*' right=Expression |
		//
		//	PrimaryExpression {Div.left=current} '/' right=Expression |
		//
		//	PrimaryExpression {Pow.base=current} '^' power=Expression |
		//
		//	PrimaryExpression;
		//
		//
		//
		//PrimaryExpression returns Expression:
		//
		//	'(' Expression ')' |
		//
		//	{Variable} name=ID |
		//
		//	{Number} value=INT;
		//
		// * / Float:
		//	INT* ("." INT+)?;
		public ParserRule getRule() { return rule; }

		//INT* ("." INT+)? / *
		//
		//Expression:
		//
		//	PrimaryExpression {Plus.left=current} '+' right=Expression |
		//
		//	PrimaryExpression {Minus.left=current} '-' right=Expression |
		//
		//	PrimaryExpression {Mult.left=current} '*' right=Expression |
		//
		//	PrimaryExpression {Div.left=current} '/' right=Expression |
		//
		//	PrimaryExpression {Pow.base=current} '^' power=Expression |
		//
		//	PrimaryExpression;
		//
		//
		//
		//PrimaryExpression returns Expression:
		//
		//	'(' Expression ')' |
		//
		//	{Variable} name=ID |
		//
		//	{Number} value=INT;
		//
		// * /
		public Group getGroup() { return cGroup; }

		//INT*
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//("." INT+ / *
		//
		//Expression:
		//
		//	PrimaryExpression {Plus.left=current} '+' right=Expression |
		//
		//	PrimaryExpression {Minus.left=current} '-' right=Expression |
		//
		//	PrimaryExpression {Mult.left=current} '*' right=Expression |
		//
		//	PrimaryExpression {Div.left=current} '/' right=Expression |
		//
		//	PrimaryExpression {Pow.base=current} '^' power=Expression |
		//
		//	PrimaryExpression;
		//
		//
		//
		//PrimaryExpression returns Expression:
		//
		//	'(' Expression ')' |
		//
		//	{Variable} name=ID |
		//
		//	{Number} value=INT;
		//
		// * /)?
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//INT+
		public RuleCall getINTTerminalRuleCall_1_1() { return cINTTerminalRuleCall_1_1; }
	}
	
	
	private FormulaElements pFormula;
	private AdditionElements pAddition;
	private MultiplicationElements pMultiplication;
	private PowerElements pPower;
	private PrimaryElements pPrimary;
	private FloatElements pFloat;
	
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

	
	////Formula:
	//
	////	expression=Expression;
	//
	//Formula:
	//	expression=Addition;
	public FormulaElements getFormulaAccess() {
		return (pFormula != null) ? pFormula : (pFormula = new FormulaElements());
	}
	
	public ParserRule getFormulaRule() {
		return getFormulaAccess().getRule();
	}

	//Addition returns Expression:
	//	Multiplication ({Addition.left=current} "+" right=Multiplication | {Subtraction.left=current} "-"
	//	right=Multiplication)*;
	public AdditionElements getAdditionAccess() {
		return (pAddition != null) ? pAddition : (pAddition = new AdditionElements());
	}
	
	public ParserRule getAdditionRule() {
		return getAdditionAccess().getRule();
	}

	//Multiplication returns Expression:
	//	Power ({Multiplication.left=current} "*" right=Power | {Division.left=current} "/" right=Power)*;
	public MultiplicationElements getMultiplicationAccess() {
		return (pMultiplication != null) ? pMultiplication : (pMultiplication = new MultiplicationElements());
	}
	
	public ParserRule getMultiplicationRule() {
		return getMultiplicationAccess().getRule();
	}

	//Power returns Expression:
	//	Primary ({Power.left=current} "^" right=Primary)?;
	public PowerElements getPowerAccess() {
		return (pPower != null) ? pPower : (pPower = new PowerElements());
	}
	
	public ParserRule getPowerRule() {
		return getPowerAccess().getRule();
	}

	//Primary returns Expression:
	//	{Variable} name=ID | //{Number} value=INT |
	//
	//	{Float} value=Float | "(" Addition ")";
	public PrimaryElements getPrimaryAccess() {
		return (pPrimary != null) ? pPrimary : (pPrimary = new PrimaryElements());
	}
	
	public ParserRule getPrimaryRule() {
		return getPrimaryAccess().getRule();
	}

	/// *
	//
	//Expression:
	//
	//	PrimaryExpression {Plus.left=current} '+' right=Expression |
	//
	//	PrimaryExpression {Minus.left=current} '-' right=Expression |
	//
	//	PrimaryExpression {Mult.left=current} '*' right=Expression |
	//
	//	PrimaryExpression {Div.left=current} '/' right=Expression |
	//
	//	PrimaryExpression {Pow.base=current} '^' power=Expression |
	//
	//	PrimaryExpression;
	//
	//
	//
	//PrimaryExpression returns Expression:
	//
	//	'(' Expression ')' |
	//
	//	{Variable} name=ID |
	//
	//	{Number} value=INT;
	//
	// * / Float:
	//	INT* ("." INT+)?;
	public FloatElements getFloatAccess() {
		return (pFloat != null) ? pFloat : (pFloat = new FloatElements());
	}
	
	public ParserRule getFloatRule() {
		return getFloatAccess().getRule();
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
