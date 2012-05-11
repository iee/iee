package org.eclipse.iee.translator.molex.mex.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.iee.translator.molex.mex.mex.Addition;
import org.eclipse.iee.translator.molex.mex.mex.Assignment;
import org.eclipse.iee.translator.molex.mex.mex.Division;
import org.eclipse.iee.translator.molex.mex.mex.Exponent;
import org.eclipse.iee.translator.molex.mex.mex.Expression;
import org.eclipse.iee.translator.molex.mex.mex.Factorial;
import org.eclipse.iee.translator.molex.mex.mex.Formula;
import org.eclipse.iee.translator.molex.mex.mex.Function;
import org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition;
import org.eclipse.iee.translator.molex.mex.mex.Interval;
import org.eclipse.iee.translator.molex.mex.mex.Invert;
import org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition;
import org.eclipse.iee.translator.molex.mex.mex.MatrixRow;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;
import org.eclipse.iee.translator.molex.mex.mex.Modulo;
import org.eclipse.iee.translator.molex.mex.mex.Multiplication;
import org.eclipse.iee.translator.molex.mex.mex.Statement;
import org.eclipse.iee.translator.molex.mex.mex.Subtraction;
import org.eclipse.iee.translator.molex.mex.mex.Variable;
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
			case MexPackage.ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.DIVISION:
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
			case MexPackage.EXPONENT:
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
			case MexPackage.EXPRESSION:
				if(context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.FACTORIAL:
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
			case MexPackage.INTERVAL:
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
					sequence_UnaryExpression(context, (Interval) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.INVERT:
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
			case MexPackage.MATRIX_DEFINITION:
				if(context == grammarAccess.getMatrixDefinitionRule()) {
					sequence_MatrixDefinition(context, (MatrixDefinition) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MATRIX_ROW:
				if(context == grammarAccess.getMatrixRowRule()) {
					sequence_MatrixRow(context, (MatrixRow) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.MODULO:
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
			case MexPackage.MULTIPLICATION:
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
			case MexPackage.STATEMENT:
				if(context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (Statement) semanticObject); 
					return; 
				}
				else break;
			case MexPackage.SUBTRACTION:
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
	 *     (variable=MATH_NAME value=Formula)
	 *
	 * Features:
	 *    variable[1, 1]
	 *    value[1, 1]
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.ASSIGNMENT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.ASSIGNMENT__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, MexPackage.Literals.ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MexPackage.Literals.ASSIGNMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentAccess().getVariableMATH_NAMETerminalRuleCall_0_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getAssignmentAccess().getValueFormulaParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
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
	 *     (functionDefinition=FunctionDefinition | matrixDefinition=MatrixDefinition | assignment=Assignment | formula=Formula)
	 *
	 * Features:
	 *    functionDefinition[0, 1]
	 *         EXCLUDE_IF_SET matrixDefinition
	 *         EXCLUDE_IF_SET assignment
	 *         EXCLUDE_IF_SET formula
	 *    matrixDefinition[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET assignment
	 *         EXCLUDE_IF_SET formula
	 *    assignment[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET matrixDefinition
	 *         EXCLUDE_IF_SET formula
	 *    formula[0, 1]
	 *         EXCLUDE_IF_SET functionDefinition
	 *         EXCLUDE_IF_SET matrixDefinition
	 *         EXCLUDE_IF_SET assignment
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
	 *     ((openingBracket='[' | openingBracket='(') ceil=UnaryExpression floor=UnaryExpression (closingBracket=']' | closingBracket=')'))
	 *
	 * Features:
	 *    openingBracket[0, 2]
	 *    ceil[1, 1]
	 *    floor[1, 1]
	 *    closingBracket[0, 2]
	 */
	protected void sequence_UnaryExpression(EObject context, Interval semanticObject) {
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
}
