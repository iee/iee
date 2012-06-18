package org.eclipse.iee.translator.jmole.math.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.jmole.math.math.Addition;
import org.eclipse.iee.translator.jmole.math.math.ClassFunction;
import org.eclipse.iee.translator.jmole.math.math.ClassMember;
import org.eclipse.iee.translator.jmole.math.math.Division;
import org.eclipse.iee.translator.jmole.math.math.Exponent;
import org.eclipse.iee.translator.jmole.math.math.Expression;
import org.eclipse.iee.translator.jmole.math.math.Factorial;
import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.Function;
import org.eclipse.iee.translator.jmole.math.math.FunctionDefinition;
import org.eclipse.iee.translator.jmole.math.math.Invert;
import org.eclipse.iee.translator.jmole.math.math.MathName;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;
import org.eclipse.iee.translator.jmole.math.math.Matrix;
import org.eclipse.iee.translator.jmole.math.math.MatrixAddition;
import org.eclipse.iee.translator.jmole.math.math.MatrixAssignment;
import org.eclipse.iee.translator.jmole.math.math.MatrixElement;
import org.eclipse.iee.translator.jmole.math.math.MatrixFormula;
import org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication;
import org.eclipse.iee.translator.jmole.math.math.MatrixRow;
import org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction;
import org.eclipse.iee.translator.jmole.math.math.MatrixVariable;
import org.eclipse.iee.translator.jmole.math.math.Modulo;
import org.eclipse.iee.translator.jmole.math.math.Multiplication;
import org.eclipse.iee.translator.jmole.math.math.NewMatrix;
import org.eclipse.iee.translator.jmole.math.math.Statement;
import org.eclipse.iee.translator.jmole.math.math.Subtraction;
import org.eclipse.iee.translator.jmole.math.math.TransposeMatrix;
import org.eclipse.iee.translator.jmole.math.math.Variable;
import org.eclipse.iee.translator.jmole.math.math.VariableAssignment;
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
					sequence_Addition(context, (Addition) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.CLASS_FUNCTION:
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
					sequence_Primary(context, (ClassFunction) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.CLASS_MEMBER:
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
					sequence_Primary(context, (ClassMember) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.DIVISION:
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
					sequence_Multiplication(context, (Division) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.EXPONENT:
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
					sequence_Exponent(context, (Exponent) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.EXPRESSION:
				if(context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.FACTORIAL:
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
					sequence_UnaryExpression(context, (Factorial) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.FLOAT:
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
			case MathPackage.FUNCTION_DEFINITION:
				if(context == grammarAccess.getFunctionDefinitionRule()) {
					sequence_FunctionDefinition(context, (FunctionDefinition) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.INVERT:
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
					sequence_UnaryExpression(context, (Invert) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATH_NAME:
				if(context == grammarAccess.getMathNameRule()) {
					sequence_MathName(context, (MathName) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATRIX:
				if(context == grammarAccess.getMatrixRule()) {
					sequence_Matrix(context, (Matrix) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATRIX_ADDITION:
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
			case MathPackage.MATRIX_ASSIGNMENT:
				if(context == grammarAccess.getMatrixAssignmentRule()) {
					sequence_MatrixAssignment(context, (MatrixAssignment) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATRIX_ELEMENT:
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
			case MathPackage.MATRIX_FORMULA:
				if(context == grammarAccess.getMatrixFormulaRule()) {
					sequence_MatrixFormula(context, (MatrixFormula) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATRIX_MULTIPLICATION:
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
			case MathPackage.MATRIX_ROW:
				if(context == grammarAccess.getMatrixRowRule()) {
					sequence_MatrixRow(context, (MatrixRow) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MATRIX_SUBTRACTION:
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
			case MathPackage.MATRIX_VARIABLE:
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
			case MathPackage.MODULO:
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
					sequence_Multiplication(context, (Modulo) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.MULTIPLICATION:
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
					sequence_Multiplication(context, (Multiplication) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.NEW_MATRIX:
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
			case MathPackage.STATEMENT:
				if(context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (Statement) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.SUBTRACTION:
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
					sequence_Addition(context, (Subtraction) semanticObject); 
					return; 
				}
				else break;
			case MathPackage.TRANSPOSE_MATRIX:
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
			case MathPackage.VARIABLE:
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
			case MathPackage.VARIABLE_ASSIGNMENT:
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
	 *     (name=MathName (parameters+=Formula parameters+=Formula*)?)
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
	 *     mathName=MATH_NAME
	 *
	 * Features:
	 *    mathName[1, 1]
	 */
	protected void sequence_MathName(EObject context, MathName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATH_NAME__MATH_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATH_NAME__MATH_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMathNameAccess().getMathNameMATH_NAMETerminalRuleCall_0(), semanticObject.getMathName());
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
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_ADDITION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_ADDITION__LEFT));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_ADDITION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_ADDITION__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_0_2_0(), semanticObject.getRight());
		feeder.finish();
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
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_SUBTRACTION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_SUBTRACTION__LEFT));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_SUBTRACTION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_SUBTRACTION__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (variable=MathName value=MatrixFormula)
	 *
	 * Features:
	 *    variable[1, 1]
	 *    value[1, 1]
	 */
	protected void sequence_MatrixAssignment(EObject context, MatrixAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_ASSIGNMENT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_ASSIGNMENT__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_ASSIGNMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMatrixAssignmentAccess().getVariableMathNameParserRuleCall_1_0(), semanticObject.getVariable());
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
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_FORMULA__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_FORMULA__EXPRESSION));
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
	 *     (elements+=Formula elements+=Formula*)?
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
	 *     name=MathName
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_PrimaryMatrix(EObject context, MatrixVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATRIX_VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATRIX_VARIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryMatrixAccess().getNameMathNameParserRuleCall_2_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     matrix=Matrix
	 *
	 * Features:
	 *    matrix[1, 1]
	 */
	protected void sequence_PrimaryMatrix(EObject context, NewMatrix semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.NEW_MATRIX__MATRIX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.NEW_MATRIX__MATRIX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryMatrixAccess().getMatrixMatrixParserRuleCall_0_1_0(), semanticObject.getMatrix());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=MathName
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_PrimaryMatrix(EObject context, TransposeMatrix semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.TRANSPOSE_MATRIX__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.TRANSPOSE_MATRIX__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryMatrixAccess().getNameMathNameParserRuleCall_1_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (class_=MathName function=Function)
	 *
	 * Features:
	 *    class_[1, 1]
	 *    function[1, 1]
	 */
	protected void sequence_Primary(EObject context, ClassFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (class_=MathName member=MathName)
	 *
	 * Features:
	 *    class_[1, 1]
	 *    member[1, 1]
	 */
	protected void sequence_Primary(EObject context, ClassMember semanticObject) {
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
	 *     (element=MathName row=Formula column=Formula)
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
	 *     name=MathName
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
	 *     (variable=MathName value=Formula)
	 *
	 * Features:
	 *    variable[1, 1]
	 *    value[1, 1]
	 */
	protected void sequence_VariableAssignment(EObject context, VariableAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE_ASSIGNMENT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE_ASSIGNMENT__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE_ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE_ASSIGNMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableAssignmentAccess().getVariableMathNameParserRuleCall_0_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getVariableAssignmentAccess().getValueFormulaParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
}
