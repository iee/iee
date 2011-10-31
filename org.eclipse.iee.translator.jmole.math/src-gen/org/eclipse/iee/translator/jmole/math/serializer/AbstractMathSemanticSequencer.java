package org.eclipse.iee.translator.jmole.math.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.jmole.math.math.Addition;
import org.eclipse.iee.translator.jmole.math.math.Division;
import org.eclipse.iee.translator.jmole.math.math.Expression;
import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.Function;
import org.eclipse.iee.translator.jmole.math.math.FunctionDefinition;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;
import org.eclipse.iee.translator.jmole.math.math.MatrixDefinition;
import org.eclipse.iee.translator.jmole.math.math.MatrixRow;
import org.eclipse.iee.translator.jmole.math.math.Multiplication;
import org.eclipse.iee.translator.jmole.math.math.Power;
import org.eclipse.iee.translator.jmole.math.math.Statement;
import org.eclipse.iee.translator.jmole.math.math.Subtraction;
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
			case MathPackage.ADDITION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Addition(context, (Addition) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.DIVISION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Multiplication(context, (Division) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.EXPRESSION:
				if(context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.FLOAT:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (org.eclipse.iee.translator.jmole.math.math.Float) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.FORMULA:
				if(context == grammarAccess.getFormulaRule()) {
					sequence_Formula(context, (Formula) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.FUNCTION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.FUNCTION_DEFINITION:
				if(context == grammarAccess.getFunctionDefinitionRule()) {
					sequence_FunctionDefinition(context, (FunctionDefinition) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATRIX_DEFINITION:
				if(context == grammarAccess.getMatrixDefinitionRule()) {
					sequence_MatrixDefinition(context, (MatrixDefinition) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATRIX_ROW:
				if(context == grammarAccess.getMatrixRowRule()) {
					sequence_MatrixRow(context, (MatrixRow) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MULTIPLICATION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Multiplication(context, (Multiplication) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.POWER:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Power(context, (Power) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.STATEMENT:
				if(context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (Statement) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.SUBTRACTION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Addition(context, (Subtraction) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.VARIABLE:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0() ||
				   context == grammarAccess.getPowerRule() ||
				   context == grammarAccess.getPowerAccess().getPowerLeftAction_1_0() ||
				   context == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=Addition_Addition_1_0_0 right=Multiplication)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition(EObject context, Addition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition_Subtraction_1_1_0 right=Multiplication)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition(EObject context, Subtraction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Addition
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_Formula(EObject context, Formula semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.FORMULA__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.FORMULA__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFormulaAccess().getExpressionAdditionParserRuleCall_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (function=Function formula=Formula)
	 *
	 * Features:
	 *    function[1, 1]
	 *    formula[1, 1]
	 */
	protected void sequence_FunctionDefinition(EObject context, FunctionDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.FUNCTION_DEFINITION__FUNCTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.FUNCTION_DEFINITION__FUNCTION));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.FUNCTION_DEFINITION__FORMULA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.FUNCTION_DEFINITION__FORMULA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionDefinitionAccess().getFunctionFunctionParserRuleCall_0_0(), semanticObject.getFunction());
		feeder.accept(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_2_0(), semanticObject.getFormula());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=MATH_NAME (parameters+=Formula parameters+=Formula*)?)
	 *
	 * Features:
	 *    name[1, 1]
	 *    parameters[0, *]
	 */
	protected void sequence_Function(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=MATH_NAME (rows+=MatrixRow rows+=MatrixRow*)?)
	 *
	 * Features:
	 *    name[1, 1]
	 *    rows[0, *]
	 */
	protected void sequence_MatrixDefinition(EObject context, MatrixDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (elements+=Float elements+=Float*)?
	 *
	 * Features:
	 *    elements[0, *]
	 */
	protected void sequence_MatrixRow(EObject context, MatrixRow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Division_1_1_0 right=Power)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication(EObject context, Division semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Multiplication_1_0_0 right=Power)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication(EObject context, Multiplication semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Power_Power_1_0 right=Primary)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Power(EObject context, Power semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=Float
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_Primary(EObject context, org.eclipse.iee.translator.jmole.math.math.Float semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     function=Function
	 *
	 * Features:
	 *    function[1, 1]
	 */
	protected void sequence_Primary(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=MATH_NAME
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_Primary(EObject context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (functionDefinition=FunctionDefinition | matrixDefinition=MatrixDefinition | formula=Formula)
	 *
	 * Features:
	 *    functionDefinition[0, 1]
	 *         EXCLUDE_IF_SET matrixDefinition
	 *         EXCLUDE_IF_SET formula
	 *    matrixDefinition[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET formula
	 *    formula[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET matrixDefinition
	 */
	protected void sequence_Statement(EObject context, Statement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
