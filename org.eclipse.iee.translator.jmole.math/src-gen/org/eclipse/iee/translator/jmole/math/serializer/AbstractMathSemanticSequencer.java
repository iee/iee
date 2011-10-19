package org.eclipse.iee.translator.jmole.math.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.jmole.math.math.Div;
import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;
import org.eclipse.iee.translator.jmole.math.math.Minus;
import org.eclipse.iee.translator.jmole.math.math.Mult;
import org.eclipse.iee.translator.jmole.math.math.Plus;
import org.eclipse.iee.translator.jmole.math.math.Pow;
import org.eclipse.iee.translator.jmole.math.math.Variable;
import org.eclipse.iee.translator.jmole.math.services.MathGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractMathSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected MathGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MathPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MathPackage.DIV:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getPlusLeftAction_0_1() ||
				   context == grammarAccess.getExpressionAccess().getMinusLeftAction_1_1() ||
				   context == grammarAccess.getExpressionAccess().getMultLeftAction_2_1() ||
				   context == grammarAccess.getExpressionAccess().getDivLeftAction_3_1() ||
				   context == grammarAccess.getExpressionAccess().getPowBaseAction_4_1() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Expression_Div(context, (Div) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.FORMULA:
				if(context == grammarAccess.getFormulaRule()) {
					sequence_Formula_Formula(context, (Formula) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MINUS:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getPlusLeftAction_0_1() ||
				   context == grammarAccess.getExpressionAccess().getMinusLeftAction_1_1() ||
				   context == grammarAccess.getExpressionAccess().getMultLeftAction_2_1() ||
				   context == grammarAccess.getExpressionAccess().getDivLeftAction_3_1() ||
				   context == grammarAccess.getExpressionAccess().getPowBaseAction_4_1() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Expression_Minus(context, (Minus) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MULT:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getPlusLeftAction_0_1() ||
				   context == grammarAccess.getExpressionAccess().getMinusLeftAction_1_1() ||
				   context == grammarAccess.getExpressionAccess().getMultLeftAction_2_1() ||
				   context == grammarAccess.getExpressionAccess().getDivLeftAction_3_1() ||
				   context == grammarAccess.getExpressionAccess().getPowBaseAction_4_1() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Expression_Mult(context, (Mult) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.NUMBER:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getPlusLeftAction_0_1() ||
				   context == grammarAccess.getExpressionAccess().getMinusLeftAction_1_1() ||
				   context == grammarAccess.getExpressionAccess().getMultLeftAction_2_1() ||
				   context == grammarAccess.getExpressionAccess().getDivLeftAction_3_1() ||
				   context == grammarAccess.getExpressionAccess().getPowBaseAction_4_1() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_PrimaryExpression_Number(context, (org.eclipse.iee.translator.jmole.math.math.Number) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.PLUS:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getPlusLeftAction_0_1() ||
				   context == grammarAccess.getExpressionAccess().getMinusLeftAction_1_1() ||
				   context == grammarAccess.getExpressionAccess().getMultLeftAction_2_1() ||
				   context == grammarAccess.getExpressionAccess().getDivLeftAction_3_1() ||
				   context == grammarAccess.getExpressionAccess().getPowBaseAction_4_1() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Expression_Plus(context, (Plus) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.POW:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getPlusLeftAction_0_1() ||
				   context == grammarAccess.getExpressionAccess().getMinusLeftAction_1_1() ||
				   context == grammarAccess.getExpressionAccess().getMultLeftAction_2_1() ||
				   context == grammarAccess.getExpressionAccess().getDivLeftAction_3_1() ||
				   context == grammarAccess.getExpressionAccess().getPowBaseAction_4_1() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Expression_Pow(context, (Pow) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.VARIABLE:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getPlusLeftAction_0_1() ||
				   context == grammarAccess.getExpressionAccess().getMinusLeftAction_1_1() ||
				   context == grammarAccess.getExpressionAccess().getMultLeftAction_2_1() ||
				   context == grammarAccess.getExpressionAccess().getDivLeftAction_3_1() ||
				   context == grammarAccess.getExpressionAccess().getPowBaseAction_4_1() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_PrimaryExpression_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=Expression_Div_3_1 right=Expression)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Expression_Div(EObject context, Div semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.DIV__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.DIV__LEFT));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.DIV__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.DIV__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionAccess().getDivLeftAction_3_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_3_3_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=Expression_Minus_1_1 right=Expression)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Expression_Minus(EObject context, Minus semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MINUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MINUS__LEFT));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MINUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MINUS__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionAccess().getMinusLeftAction_1_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_1_3_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=Expression_Mult_2_1 right=Expression)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Expression_Mult(EObject context, Mult semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MULT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MULT__LEFT));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MULT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MULT__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionAccess().getMultLeftAction_2_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_2_3_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=Expression_Plus_0_1 right=Expression)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Expression_Plus(EObject context, Plus semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.PLUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PLUS__LEFT));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.PLUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PLUS__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionAccess().getPlusLeftAction_0_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_0_3_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (base=Expression_Pow_4_1 power=PrimaryExpression)
	 *
	 * Features:
	 *    base[1, 1]
	 *    power[1, 1]
	 */
	protected void sequence_Expression_Pow(EObject context, Pow semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.POW__BASE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.POW__BASE));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.POW__POWER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.POW__POWER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionAccess().getPowBaseAction_4_1(), semanticObject.getBase());
		feeder.accept(grammarAccess.getExpressionAccess().getPowerPrimaryExpressionParserRuleCall_4_3_0(), semanticObject.getPower());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_Formula_Formula(EObject context, Formula semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.FORMULA__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.FORMULA__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFormulaAccess().getExpressionExpressionParserRuleCall_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_PrimaryExpression_Number(EObject context, org.eclipse.iee.translator.jmole.math.math.Number semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.NUMBER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.NUMBER__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryExpressionAccess().getValueINTTerminalRuleCall_2_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_PrimaryExpression_Variable(EObject context, Variable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryExpressionAccess().getNameIDTerminalRuleCall_1_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
