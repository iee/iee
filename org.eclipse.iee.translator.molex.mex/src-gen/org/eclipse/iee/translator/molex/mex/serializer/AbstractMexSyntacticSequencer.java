package org.eclipse.iee.translator.molex.mex.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.molex.mex.services.MexGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractMexSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MexGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Function_CommaKeyword_2_2_q;
	protected AbstractElementAlias match_MatrixDefinition_CommaKeyword_3_2_q;
	protected AbstractElementAlias match_MatrixRow_CommaKeyword_1_2_q;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_3_0_a;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_3_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MexGrammarAccess) access;
		match_Function_CommaKeyword_2_2_q = new TokenAlias(true, false, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
		match_MatrixDefinition_CommaKeyword_3_2_q = new TokenAlias(true, false, grammarAccess.getMatrixDefinitionAccess().getCommaKeyword_3_2());
		match_MatrixRow_CommaKeyword_1_2_q = new TokenAlias(true, false, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
		match_Primary_LeftParenthesisKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_3_0());
		match_Primary_LeftParenthesisKeyword_3_0_p = new TokenAlias(false, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_3_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Function_CommaKeyword_2_2_q.equals(syntax))
				emit_Function_CommaKeyword_2_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MatrixDefinition_CommaKeyword_3_2_q.equals(syntax))
				emit_MatrixDefinition_CommaKeyword_3_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MatrixRow_CommaKeyword_1_2_q.equals(syntax))
				emit_MatrixRow_CommaKeyword_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Primary_LeftParenthesisKeyword_3_0_a.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_3_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Primary_LeftParenthesisKeyword_3_0_p.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_3_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_Function_CommaKeyword_2_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_MatrixDefinition_CommaKeyword_3_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_MatrixRow_CommaKeyword_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Primary_LeftParenthesisKeyword_3_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Primary_LeftParenthesisKeyword_3_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
