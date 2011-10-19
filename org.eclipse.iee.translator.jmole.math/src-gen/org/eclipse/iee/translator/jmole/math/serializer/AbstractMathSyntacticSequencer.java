package org.eclipse.iee.translator.jmole.math.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.jmole.math.services.MathGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractMathSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MathGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_2_0_a;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_2_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MathGrammarAccess) access;
		match_Primary_LeftParenthesisKeyword_2_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_2_0());
		match_Primary_LeftParenthesisKeyword_2_0_p = new TokenAlias(false, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		if(match_Primary_LeftParenthesisKeyword_2_0_a.equals(transition.getAmbiguousSyntax()))
			emit_Primary_LeftParenthesisKeyword_2_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_Primary_LeftParenthesisKeyword_2_0_p.equals(transition.getAmbiguousSyntax()))
			emit_Primary_LeftParenthesisKeyword_2_0_p(semanticObject, transition, fromNode, toNode);
		else acceptNodes(transition, fromNode, toNode);
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Primary_LeftParenthesisKeyword_2_0_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Primary_LeftParenthesisKeyword_2_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
}
