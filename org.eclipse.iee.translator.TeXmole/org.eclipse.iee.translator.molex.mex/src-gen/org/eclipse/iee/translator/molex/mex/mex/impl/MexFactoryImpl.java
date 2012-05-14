/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import org.eclipse.iee.translator.molex.mex.mex.MexFactory;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;
import org.eclipse.iee.translator.molex.mex.mex.Modulo;
import org.eclipse.iee.translator.molex.mex.mex.Multiplication;
import org.eclipse.iee.translator.molex.mex.mex.NewMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Statement;
import org.eclipse.iee.translator.molex.mex.mex.Subtraction;
import org.eclipse.iee.translator.molex.mex.mex.TransposeMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Variable;
import org.eclipse.iee.translator.molex.mex.mex.VariableAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MexFactoryImpl extends EFactoryImpl implements MexFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MexFactory init()
  {
    try
    {
      MexFactory theMexFactory = (MexFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/iee/translator/molex/mex/Mex"); 
      if (theMexFactory != null)
      {
        return theMexFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MexFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MexFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MexPackage.STATEMENT: return createStatement();
      case MexPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
      case MexPackage.FORMULA: return createFormula();
      case MexPackage.EXPRESSION: return createExpression();
      case MexPackage.MATRIX: return createMatrix();
      case MexPackage.MATRIX_ROW: return createMatrixRow();
      case MexPackage.MATRIX_ASSIGNMENT: return createMatrixAssignment();
      case MexPackage.MATRIX_FORMULA: return createMatrixFormula();
      case MexPackage.MATRIX_EXPRESSION: return createMatrixExpression();
      case MexPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case MexPackage.ADDITION: return createAddition();
      case MexPackage.SUBTRACTION: return createSubtraction();
      case MexPackage.MULTIPLICATION: return createMultiplication();
      case MexPackage.DIVISION: return createDivision();
      case MexPackage.MODULO: return createModulo();
      case MexPackage.INVERT: return createInvert();
      case MexPackage.FACTORIAL: return createFactorial();
      case MexPackage.EXPONENT: return createExponent();
      case MexPackage.VARIABLE: return createVariable();
      case MexPackage.FLOAT: return createFloat();
      case MexPackage.FUNCTION: return createFunction();
      case MexPackage.MATRIX_ELEMENT: return createMatrixElement();
      case MexPackage.IN_BRACKETS: return createInBrackets();
      case MexPackage.MATRIX_ADDITION: return createMatrixAddition();
      case MexPackage.MATRIX_SUBTRACTION: return createMatrixSubtraction();
      case MexPackage.MATRIX_MULTIPLICATION: return createMatrixMultiplication();
      case MexPackage.NEW_MATRIX: return createNewMatrix();
      case MexPackage.TRANSPOSE_MATRIX: return createTransposeMatrix();
      case MexPackage.MATRIX_VARIABLE: return createMatrixVariable();
      case MexPackage.MATRIX_IN_BRACKETS: return createMatrixInBrackets();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableAssignment createVariableAssignment()
  {
    VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
    return variableAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Formula createFormula()
  {
    FormulaImpl formula = new FormulaImpl();
    return formula;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Matrix createMatrix()
  {
    MatrixImpl matrix = new MatrixImpl();
    return matrix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixRow createMatrixRow()
  {
    MatrixRowImpl matrixRow = new MatrixRowImpl();
    return matrixRow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixAssignment createMatrixAssignment()
  {
    MatrixAssignmentImpl matrixAssignment = new MatrixAssignmentImpl();
    return matrixAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixFormula createMatrixFormula()
  {
    MatrixFormulaImpl matrixFormula = new MatrixFormulaImpl();
    return matrixFormula;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixExpression createMatrixExpression()
  {
    MatrixExpressionImpl matrixExpression = new MatrixExpressionImpl();
    return matrixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition createFunctionDefinition()
  {
    FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Addition createAddition()
  {
    AdditionImpl addition = new AdditionImpl();
    return addition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Subtraction createSubtraction()
  {
    SubtractionImpl subtraction = new SubtractionImpl();
    return subtraction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiplication createMultiplication()
  {
    MultiplicationImpl multiplication = new MultiplicationImpl();
    return multiplication;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Division createDivision()
  {
    DivisionImpl division = new DivisionImpl();
    return division;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modulo createModulo()
  {
    ModuloImpl modulo = new ModuloImpl();
    return modulo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invert createInvert()
  {
    InvertImpl invert = new InvertImpl();
    return invert;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Factorial createFactorial()
  {
    FactorialImpl factorial = new FactorialImpl();
    return factorial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exponent createExponent()
  {
    ExponentImpl exponent = new ExponentImpl();
    return exponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.iee.translator.molex.mex.mex.Float createFloat()
  {
    FloatImpl float_ = new FloatImpl();
    return float_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixElement createMatrixElement()
  {
    MatrixElementImpl matrixElement = new MatrixElementImpl();
    return matrixElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InBrackets createInBrackets()
  {
    InBracketsImpl inBrackets = new InBracketsImpl();
    return inBrackets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixAddition createMatrixAddition()
  {
    MatrixAdditionImpl matrixAddition = new MatrixAdditionImpl();
    return matrixAddition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixSubtraction createMatrixSubtraction()
  {
    MatrixSubtractionImpl matrixSubtraction = new MatrixSubtractionImpl();
    return matrixSubtraction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixMultiplication createMatrixMultiplication()
  {
    MatrixMultiplicationImpl matrixMultiplication = new MatrixMultiplicationImpl();
    return matrixMultiplication;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NewMatrix createNewMatrix()
  {
    NewMatrixImpl newMatrix = new NewMatrixImpl();
    return newMatrix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransposeMatrix createTransposeMatrix()
  {
    TransposeMatrixImpl transposeMatrix = new TransposeMatrixImpl();
    return transposeMatrix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixVariable createMatrixVariable()
  {
    MatrixVariableImpl matrixVariable = new MatrixVariableImpl();
    return matrixVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixInBrackets createMatrixInBrackets()
  {
    MatrixInBracketsImpl matrixInBrackets = new MatrixInBracketsImpl();
    return matrixInBrackets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MexPackage getMexPackage()
  {
    return (MexPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MexPackage getPackage()
  {
    return MexPackage.eINSTANCE;
  }

} //MexFactoryImpl
