package org.eclipse.iee.translator.jmole.math.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.jmole.math.services.MathGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractMathSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MathGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Function_CosKeyword_0_1_or_LogKeyword_0_3_or_SinKeyword_0_0_or_TanKeyword_0_2;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_2_0_a;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_2_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MathGrammarAccess) access;
		match_Function_CosKeyword_0_1_or_LogKeyword_0_3_or_SinKeyword_0_0_or_TanKeyword_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getFunctionAccess().getCosKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getLogKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getSinKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getTanKeyword_0_2()));
		match_Primary_LeftParenthesisKeyword_2_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_2_0());
		match_Primary_LeftParenthesisKeyword_2_0_p = new TokenAlias(false, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_2_0());
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
			if(match_Function_CosKeyword_0_1_or_LogKeyword_0_3_or_SinKeyword_0_0_or_TanKeyword_0_2.equals(syntax))
				emit_Function_CosKeyword_0_1_or_LogKeyword_0_3_or_SinKeyword_0_0_or_TanKeyword_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Primary_LeftParenthesisKeyword_2_0_a.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_2_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Primary_LeftParenthesisKeyword_2_0_p.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_2_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'tan' | 'cos' | 'log' | 'sin'
	 */
	protected void emit_Function_CosKeyword_0_1_or_LogKeyword_0_3_or_SinKeyword_0_0_or_TanKeyword_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_Primary_LeftParenthesisKeyword_2_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_Primary_LeftParenthesisKeyword_2_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
