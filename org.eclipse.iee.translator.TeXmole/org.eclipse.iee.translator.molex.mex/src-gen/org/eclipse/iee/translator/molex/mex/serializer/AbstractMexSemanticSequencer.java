package org.eclipse.iee.translator.molex.mex.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.molex.mex.mex.Addition;
import org.eclipse.iee.translator.molex.mex.mex.Division;
import org.eclipse.iee.translator.molex.mex.mex.Exponent;
import org.eclipse.iee.translator.molex.mex.mex.Expression;
import org.eclipse.iee.translator.molex.mex.mex.Factorial;
import org.eclipse.iee.translator.molex.mex.mex.Formula;
import org.eclipse.iee.translator.molex.mex.mex.Function;
import org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition;
import org.eclipse.iee.translator.molex.mex.mex.InBrackets;
import org.eclipse.iee.translator.molex.mex.mex.Invert;
import org.eclipse.iee.translator.molex.mex.mex.Matrix;
import org.eclipse.iee.translator.molex.mex.mex.MatrixAddition;
import org.eclipse.iee.translator.molex.mex.mex.MatrixAssignment;
import org.eclipse.iee.translator.molex.mex.mex.MatrixElement;
import org.eclipse.iee.translator.molex.mex.mex.MatrixExpression;
import org.eclipse.iee.translator.molex.mex.mex.MatrixFormula;
import org.eclipse.iee.translator.molex.mex.mex.MatrixInBrackets;
import org.eclipse.iee.translator.molex.mex.mex.MatrixMultiplication;
import org.eclipse.iee.translator.molex.mex.mex.MatrixRow;
import org.eclipse.iee.translator.molex.mex.mex.MatrixSubtraction;
import org.eclipse.iee.translator.molex.mex.mex.MatrixVariable;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;
import org.eclipse.iee.translator.molex.mex.mex.Modulo;
import org.eclipse.iee.translator.molex.mex.mex.Multiplication;
import org.eclipse.iee.translator.molex.mex.mex.NewMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Statement;
import org.eclipse.iee.translator.molex.mex.mex.Subtraction;
import org.eclipse.iee.translator.molex.mex.mex.TransposeMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Variable;
import org.eclipse.iee.translator.molex.mex.mex.VariableAssignment;
import org.eclipse.iee.translator.molex.mex.services.MexGrammarAccess;
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
public class AbstractMexSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected MexGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == MexPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MexPackage.ADDITION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1()) {
					sequence_Addition(context, (Addition) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.DIVISION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1()) {
					sequence_Multiplication(context, (Division) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.EXPONENT:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getExponentRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_Exponent(context, (Exponent) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.EXPRESSION:
				if(context == grammarAccess.getAdditionInBracketsRule()) {
					sequence_AdditionInBrackets(context, (Expression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.FACTORIAL:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_UnaryExpression(context, (Factorial) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.FLOAT:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getExponentRule() ||
				   context == grammarAccess.getExponentAccess().getExponentLeftAction_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getPrimaryRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_Primary(context, (org.eclipse.iee.translator.molex.mex.mex.Float) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.FORMULA:
				if(context == grammarAccess.getFormulaRule()) {
					sequence_Formula(context, (Formula) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.FUNCTION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getExponentRule() ||
				   context == grammarAccess.getExponentAccess().getExponentLeftAction_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getPrimaryRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_Primary(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.FUNCTION_DEFINITION:
				if(context == grammarAccess.getFunctionDefinitionRule()) {
					sequence_FunctionDefinition(context, (FunctionDefinition) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.IN_BRACKETS:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getExponentRule() ||
				   context == grammarAccess.getExponentAccess().getExponentLeftAction_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getPrimaryRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_Primary(context, (InBrackets) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.INVERT:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_UnaryExpression(context, (Invert) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX:
				if(context == grammarAccess.getMatrixRule()) {
					sequence_Matrix(context, (Matrix) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_ADDITION:
				if(context == grammarAccess.getMatrixAdditionRule() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMatrixMultiplicationRule() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1() ||
				   context == grammarAccess.getPrimaryMatrixRule()) {
					sequence_MatrixAddition(context, (MatrixAddition) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_ASSIGNMENT:
				if(context == grammarAccess.getMatrixAssignmentRule()) {
					sequence_MatrixAssignment(context, (MatrixAssignment) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_ELEMENT:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getExponentRule() ||
				   context == grammarAccess.getExponentAccess().getExponentLeftAction_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getPrimaryRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_Primary(context, (MatrixElement) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_EXPRESSION:
				if(context == grammarAccess.getMatrixAdditionInBracketsRule()) {
					sequence_MatrixAdditionInBrackets(context, (MatrixExpression) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_FORMULA:
				if(context == grammarAccess.getMatrixFormulaRule()) {
					sequence_MatrixFormula(context, (MatrixFormula) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_IN_BRACKETS:
				if(context == grammarAccess.getMatrixAdditionRule() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMatrixMultiplicationRule() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1() ||
				   context == grammarAccess.getPrimaryMatrixRule()) {
					sequence_PrimaryMatrix(context, (MatrixInBrackets) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_MULTIPLICATION:
				if(context == grammarAccess.getMatrixAdditionRule() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMatrixMultiplicationRule() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1() ||
				   context == grammarAccess.getPrimaryMatrixRule()) {
					sequence_MatrixMultiplication(context, (MatrixMultiplication) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_ROW:
				if(context == grammarAccess.getMatrixRowRule()) {
					sequence_MatrixRow(context, (MatrixRow) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_SUBTRACTION:
				if(context == grammarAccess.getMatrixAdditionRule() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMatrixMultiplicationRule() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1() ||
				   context == grammarAccess.getPrimaryMatrixRule()) {
					sequence_MatrixAddition(context, (MatrixSubtraction) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_VARIABLE:
				if(context == grammarAccess.getMatrixAdditionRule() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMatrixMultiplicationRule() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1() ||
				   context == grammarAccess.getPrimaryMatrixRule()) {
					sequence_PrimaryMatrix(context, (MatrixVariable) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MODULO:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1()) {
					sequence_Multiplication(context, (Modulo) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MULTIPLICATION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1()) {
					sequence_Multiplication(context, (Multiplication) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.NEW_MATRIX:
				if(context == grammarAccess.getMatrixAdditionRule() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMatrixMultiplicationRule() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1() ||
				   context == grammarAccess.getPrimaryMatrixRule()) {
					sequence_PrimaryMatrix(context, (NewMatrix) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.STATEMENT:
				if(context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (Statement) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.SUBTRACTION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1()) {
					sequence_Addition(context, (Subtraction) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.TRANSPOSE_MATRIX:
				if(context == grammarAccess.getMatrixAdditionRule() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getMatrixMultiplicationRule() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1() ||
				   context == grammarAccess.getPrimaryMatrixRule()) {
					sequence_PrimaryMatrix(context, (TransposeMatrix) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.VARIABLE:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1() ||
				   context == grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1() ||
				   context == grammarAccess.getExponentRule() ||
				   context == grammarAccess.getExponentAccess().getExponentLeftAction_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1() ||
				   context == grammarAccess.getPrimaryRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_Primary(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.VARIABLE_ASSIGNMENT:
				if(context == grammarAccess.getVariableAssignmentRule()) {
					sequence_VariableAssignment(context, (VariableAssignment) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     addition=Addition
	 *
	 * Features:
	 *    addition[1, 1]
	 */
	protected void sequence_AdditionInBrackets(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition_Addition_1_0_1 right=Multiplication)
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
	 *     (left=Addition_Subtraction_1_1_1 right=Multiplication)
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
	 *     (left=Exponent_Exponent_1_0 right=Primary)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Exponent(EObject context, Exponent semanticObject) {
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
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.FORMULA__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.FORMULA__EXPRESSION));
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
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.FUNCTION_DEFINITION__FUNCTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.FUNCTION_DEFINITION__FUNCTION));
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.FUNCTION_DEFINITION__FORMULA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.FUNCTION_DEFINITION__FORMULA));
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
	 *     addition=MatrixAddition
	 *
	 * Features:
	 *    addition[1, 1]
	 */
	protected void sequence_MatrixAdditionInBrackets(EObject context, MatrixExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.MATRIX_EXPRESSION__ADDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.MATRIX_EXPRESSION__ADDITION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMatrixAdditionInBracketsAccess().getAdditionMatrixAdditionParserRuleCall_1_0(), semanticObject.getAddition());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=MatrixAddition_MatrixAddition_1_0_1 right=MatrixMultiplication)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_MatrixAddition(EObject context, MatrixAddition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=MatrixAddition_MatrixSubtraction_1_1_1 right=MatrixMultiplication)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_MatrixAddition(EObject context, MatrixSubtraction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (variable=MATH_NAME value=MatrixFormula)
	 *
	 * Features:
	 *    variable[1, 1]
	 *    value[1, 1]
	 */
	protected void sequence_MatrixAssignment(EObject context, MatrixAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.MATRIX_ASSIGNMENT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.MATRIX_ASSIGNMENT__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.MATRIX_ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.MATRIX_ASSIGNMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMatrixAssignmentAccess().getVariableMATH_NAMETerminalRuleCall_1_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getMatrixAssignmentAccess().getValueMatrixFormulaParserRuleCall_4_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=MatrixAddition
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_MatrixFormula(EObject context, MatrixFormula semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.MATRIX_FORMULA__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.MATRIX_FORMULA__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMatrixFormulaAccess().getExpressionMatrixAdditionParserRuleCall_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (left=MatrixMultiplication_MatrixMultiplication_1_0_1 rightMatrix=PrimaryMatrix) | 
	 *         (left=MatrixMultiplication_MatrixMultiplication_1_1_1 rightScalar=Formula)
	 *     )
	 *
	 * Features:
	 *    left[0, 2]
	 *    rightMatrix[0, 1]
	 *         EXCLUDE_IF_UNSET left
	 *         MANDATORY_IF_SET left
	 *         EXCLUDE_IF_SET left
	 *         EXCLUDE_IF_SET rightScalar
	 *    rightScalar[0, 1]
	 *         EXCLUDE_IF_UNSET left
	 *         MANDATORY_IF_SET left
	 *         EXCLUDE_IF_SET left
	 *         EXCLUDE_IF_SET rightMatrix
	 */
	protected void sequence_MatrixMultiplication(EObject context, MatrixMultiplication semanticObject) {
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
	 *     (rows+=MatrixRow rows+=MatrixRow*)?
	 *
	 * Features:
	 *    rows[0, *]
	 */
	protected void sequence_Matrix(EObject context, Matrix semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Division_1_1_1 right=UnaryExpression)
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
	 *     (left=Multiplication_Modulo_1_2_1 right=UnaryExpression)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication(EObject context, Modulo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Multiplication_1_0_1 right=UnaryExpression)
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
	 *     inBrackets=MatrixAdditionInBrackets
	 *
	 * Features:
	 *    inBrackets[1, 1]
	 */
	protected void sequence_PrimaryMatrix(EObject context, MatrixInBrackets semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=MATH_NAME
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_PrimaryMatrix(EObject context, MatrixVariable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     matrix=Matrix
	 *
	 * Features:
	 *    matrix[1, 1]
	 */
	protected void sequence_PrimaryMatrix(EObject context, NewMatrix semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=MATH_NAME
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_PrimaryMatrix(EObject context, TransposeMatrix semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=Float
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_Primary(EObject context, org.eclipse.iee.translator.molex.mex.mex.Float semanticObject) {
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
	 *     inBrackets=AdditionInBrackets
	 *
	 * Features:
	 *    inBrackets[1, 1]
	 */
	protected void sequence_Primary(EObject context, InBrackets semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (element=MATH_NAME row=Float column=Float)
	 *
	 * Features:
	 *    element[1, 1]
	 *    row[1, 1]
	 *    column[1, 1]
	 */
	protected void sequence_Primary(EObject context, MatrixElement semanticObject) {
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
	 *     (
	 *         functionDefinition=FunctionDefinition | 
	 *         variableAssignment=VariableAssignment | 
	 *         formula=Formula | 
	 *         matrixAssignment=MatrixAssignment | 
	 *         matrixFormula=MatrixFormula
	 *     )
	 *
	 * Features:
	 *    functionDefinition[0, 1]
	 *         EXCLUDE_IF_SET variableAssignment
	 *         EXCLUDE_IF_SET formula
	 *         EXCLUDE_IF_SET matrixAssignment
	 *         EXCLUDE_IF_SET matrixFormula
	 *    variableAssignment[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET formula
	 *         EXCLUDE_IF_SET matrixAssignment
	 *         EXCLUDE_IF_SET matrixFormula
	 *    formula[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET variableAssignment
	 *         EXCLUDE_IF_SET matrixAssignment
	 *         EXCLUDE_IF_SET matrixFormula
	 *    matrixAssignment[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET variableAssignment
	 *         EXCLUDE_IF_SET formula
	 *         EXCLUDE_IF_SET matrixFormula
	 *    matrixFormula[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET variableAssignment
	 *         EXCLUDE_IF_SET formula
	 *         EXCLUDE_IF_SET matrixAssignment
	 */
	protected void sequence_Statement(EObject context, Statement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=UnaryExpression
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_UnaryExpression(EObject context, Factorial semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=UnaryExpression
	 *
	 * Features:
	 *    expression[1, 1]
	 */
	protected void sequence_UnaryExpression(EObject context, Invert semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (variable=MATH_NAME value=Formula)
	 *
	 * Features:
	 *    variable[1, 1]
	 *    value[1, 1]
	 */
	protected void sequence_VariableAssignment(EObject context, VariableAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.VARIABLE_ASSIGNMENT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.VARIABLE_ASSIGNMENT__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.VARIABLE_ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.VARIABLE_ASSIGNMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableAssignmentAccess().getVariableMATH_NAMETerminalRuleCall_0_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getVariableAssignmentAccess().getValueFormulaParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
}
