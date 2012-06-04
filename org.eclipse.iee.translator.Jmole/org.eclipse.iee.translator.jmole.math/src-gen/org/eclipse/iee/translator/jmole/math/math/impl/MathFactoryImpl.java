/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.iee.translator.jmole.math.math.Addition;
import org.eclipse.iee.translator.jmole.math.math.Division;
import org.eclipse.iee.translator.jmole.math.math.Exponent;
import org.eclipse.iee.translator.jmole.math.math.Expression;
import org.eclipse.iee.translator.jmole.math.math.Factorial;
import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.Function;
import org.eclipse.iee.translator.jmole.math.math.FunctionDefinition;
import org.eclipse.iee.translator.jmole.math.math.Invert;
import org.eclipse.iee.translator.jmole.math.math.MathFactory;
import org.eclipse.iee.translator.jmole.math.math.MathName;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;
import org.eclipse.iee.translator.jmole.math.math.Matrix;
import org.eclipse.iee.translator.jmole.math.math.MatrixAddition;
import org.eclipse.iee.translator.jmole.math.math.MatrixAssignment;
import org.eclipse.iee.translator.jmole.math.math.MatrixElement;
import org.eclipse.iee.translator.jmole.math.math.MatrixExpression;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MathFactoryImpl extends EFactoryImpl implements MathFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MathFactory init()
  {
    try
    {
      MathFactory theMathFactory = (MathFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/iee/translator/jmole/math/Math"); 
      if (theMathFactory != null)
      {
        return theMathFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MathFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MathFactoryImpl()
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
      case MathPackage.STATEMENT: return createStatement();
      case MathPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
      case MathPackage.FORMULA: return createFormula();
      case MathPackage.EXPRESSION: return createExpression();
      case MathPackage.MATRIX: return createMatrix();
      case MathPackage.MATRIX_ROW: return createMatrixRow();
      case MathPackage.MATRIX_ASSIGNMENT: return createMatrixAssignment();
      case MathPackage.MATRIX_FORMULA: return createMatrixFormula();
      case MathPackage.MATRIX_EXPRESSION: return createMatrixExpression();
      case MathPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case MathPackage.MATH_NAME: return createMathName();
      case MathPackage.ADDITION: return createAddition();
      case MathPackage.SUBTRACTION: return createSubtraction();
      case MathPackage.MULTIPLICATION: return createMultiplication();
      case MathPackage.DIVISION: return createDivision();
      case MathPackage.MODULO: return createModulo();
      case MathPackage.INVERT: return createInvert();
      case MathPackage.FACTORIAL: return createFactorial();
      case MathPackage.EXPONENT: return createExponent();
      case MathPackage.VARIABLE: return createVariable();
      case MathPackage.FLOAT: return createFloat();
      case MathPackage.MATRIX_ELEMENT: return createMatrixElement();
      case MathPackage.FUNCTION: return createFunction();
      case MathPackage.MATRIX_ADDITION: return createMatrixAddition();
      case MathPackage.MATRIX_SUBTRACTION: return createMatrixSubtraction();
      case MathPackage.MATRIX_MULTIPLICATION: return createMatrixMultiplication();
      case MathPackage.NEW_MATRIX: return createNewMatrix();
      case MathPackage.TRANSPOSE_MATRIX: return createTransposeMatrix();
      case MathPackage.MATRIX_VARIABLE: return createMatrixVariable();
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
  public MathName createMathName()
  {
    MathNameImpl mathName = new MathNameImpl();
    return mathName;
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
  public org.eclipse.iee.translator.jmole.math.math.Float createFloat()
  {
    FloatImpl float_ = new FloatImpl();
    return float_;
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
  public MathPackage getMathPackage()
  {
    return (MathPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MathPackage getPackage()
  {
    return MathPackage.eINSTANCE;
  }

} //MathFactoryImpl
