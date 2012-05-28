package org.eclipse.iee.translator.molex.mex.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.molex.mex.services.MexGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractMexSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MexGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Function_CommaKeyword_2_2_q;
	protected AbstractElementAlias match_MatrixRow_CommaKeyword_1_2_q;
	protected AbstractElementAlias match_Matrix_CommaKeyword_1_2_q;
	protected AbstractElementAlias match_PrimaryMatrix_LeftParenthesisKeyword_3_0_a;
	protected AbstractElementAlias match_PrimaryMatrix_LeftParenthesisKeyword_3_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MexGrammarAccess) access;
		match_Function_CommaKeyword_2_2_q = new TokenAlias(true, false, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
		match_MatrixRow_CommaKeyword_1_2_q = new TokenAlias(true, false, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
		match_Matrix_CommaKeyword_1_2_q = new TokenAlias(true, false, grammarAccess.getMatrixAccess().getCommaKeyword_1_2());
		match_PrimaryMatrix_LeftParenthesisKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryMatrixAccess().getLeftParenthesisKeyword_3_0());
		match_PrimaryMatrix_LeftParenthesisKeyword_3_0_p = new TokenAlias(false, true, grammarAccess.getPrimaryMatrixAccess().getLeftParenthesisKeyword_3_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		if(match_Function_CommaKeyword_2_2_q.equals(transition.getAmbiguousSyntax()))
			emit_Function_CommaKeyword_2_2_q(semanticObject, transition, fromNode, toNode);
		else if(match_MatrixRow_CommaKeyword_1_2_q.equals(transition.getAmbiguousSyntax()))
			emit_MatrixRow_CommaKeyword_1_2_q(semanticObject, transition, fromNode, toNode);
		else if(match_Matrix_CommaKeyword_1_2_q.equals(transition.getAmbiguousSyntax()))
			emit_Matrix_CommaKeyword_1_2_q(semanticObject, transition, fromNode, toNode);
		else if(match_PrimaryMatrix_LeftParenthesisKeyword_3_0_a.equals(transition.getAmbiguousSyntax()))
			emit_PrimaryMatrix_LeftParenthesisKeyword_3_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_PrimaryMatrix_LeftParenthesisKeyword_3_0_p.equals(transition.getAmbiguousSyntax()))
			emit_PrimaryMatrix_LeftParenthesisKeyword_3_0_p(semanticObject, transition, fromNode, toNode);
		else acceptNodes(transition, fromNode, toNode);
	}

	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_Function_CommaKeyword_2_2_q(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_MatrixRow_CommaKeyword_1_2_q(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_Matrix_CommaKeyword_1_2_q(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_PrimaryMatrix_LeftParenthesisKeyword_3_0_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_PrimaryMatrix_LeftParenthesisKeyword_3_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
}
