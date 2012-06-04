/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.iee.translator.jmole.math.math.MathFactory
 * @model kind="package"
 * @generated
 */
public interface MathPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "math";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/iee/translator/jmole/math/Math";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "math";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MathPackage eINSTANCE = org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 0;

  /**
   * The feature id for the '<em><b>Function Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__FUNCTION_DEFINITION = 0;

  /**
   * The feature id for the '<em><b>Variable Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__VARIABLE_ASSIGNMENT = 1;

  /**
   * The feature id for the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__FORMULA = 2;

  /**
   * The feature id for the '<em><b>Matrix Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__MATRIX_ASSIGNMENT = 3;

  /**
   * The feature id for the '<em><b>Matrix Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__MATRIX_FORMULA = 4;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.VariableAssignmentImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getVariableAssignment()
   * @generated
   */
  int VARIABLE_ASSIGNMENT = 1;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Variable Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FormulaImpl <em>Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FormulaImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFormula()
   * @generated
   */
  int FORMULA = 2;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMULA__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMULA_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.ExpressionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__PARAMETERS = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixImpl <em>Matrix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrix()
   * @generated
   */
  int MATRIX = 4;

  /**
   * The feature id for the '<em><b>Rows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX__ROWS = 0;

  /**
   * The number of structural features of the '<em>Matrix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixRowImpl <em>Matrix Row</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixRowImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixRow()
   * @generated
   */
  int MATRIX_ROW = 5;

  /**
   * The feature id for the '<em><b>Elements</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ROW__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Matrix Row</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ROW_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixAssignmentImpl <em>Matrix Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixAssignmentImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixAssignment()
   * @generated
   */
  int MATRIX_ASSIGNMENT = 6;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ASSIGNMENT__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ASSIGNMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Matrix Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixFormulaImpl <em>Matrix Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixFormulaImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixFormula()
   * @generated
   */
  int MATRIX_FORMULA = 7;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_FORMULA__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Matrix Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_FORMULA_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixExpressionImpl <em>Matrix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixExpressionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixExpression()
   * @generated
   */
  int MATRIX_EXPRESSION = 8;

  /**
   * The number of structural features of the '<em>Matrix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FunctionDefinitionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 9;

  /**
   * The feature id for the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__FUNCTION = 0;

  /**
   * The feature id for the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__FORMULA = 1;

  /**
   * The number of structural features of the '<em>Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MathNameImpl <em>Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathNameImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMathName()
   * @generated
   */
  int MATH_NAME = 10;

  /**
   * The feature id for the '<em><b>Math Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATH_NAME__MATH_NAME = 0;

  /**
   * The number of structural features of the '<em>Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATH_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.AdditionImpl <em>Addition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.AdditionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getAddition()
   * @generated
   */
  int ADDITION = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Addition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.SubtractionImpl <em>Subtraction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.SubtractionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getSubtraction()
   * @generated
   */
  int SUBTRACTION = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Subtraction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MultiplicationImpl <em>Multiplication</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MultiplicationImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMultiplication()
   * @generated
   */
  int MULTIPLICATION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATION__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATION__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiplication</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.DivisionImpl <em>Division</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.DivisionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getDivision()
   * @generated
   */
  int DIVISION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVISION__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVISION__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVISION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVISION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Division</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVISION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.ModuloImpl <em>Modulo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.ModuloImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getModulo()
   * @generated
   */
  int MODULO = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Modulo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.InvertImpl <em>Invert</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.InvertImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getInvert()
   * @generated
   */
  int INVERT = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVERT__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVERT__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVERT__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Invert</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVERT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FactorialImpl <em>Factorial</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FactorialImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFactorial()
   * @generated
   */
  int FACTORIAL = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORIAL__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORIAL__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORIAL__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Factorial</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORIAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.ExponentImpl <em>Exponent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.ExponentImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getExponent()
   * @generated
   */
  int EXPONENT = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPONENT__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPONENT__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPONENT__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPONENT__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Exponent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPONENT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.VariableImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FloatImpl <em>Float</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FloatImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFloat()
   * @generated
   */
  int FLOAT = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Float</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixElementImpl <em>Matrix Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixElementImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixElement()
   * @generated
   */
  int MATRIX_ELEMENT = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ELEMENT__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ELEMENT__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ELEMENT__ELEMENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Row</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ELEMENT__ROW = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ELEMENT__COLUMN = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Matrix Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ELEMENT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FunctionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__FUNCTION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixAdditionImpl <em>Matrix Addition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixAdditionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixAddition()
   * @generated
   */
  int MATRIX_ADDITION = 23;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ADDITION__LEFT = MATRIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ADDITION__RIGHT = MATRIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Matrix Addition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_ADDITION_FEATURE_COUNT = MATRIX_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixSubtractionImpl <em>Matrix Subtraction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixSubtractionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixSubtraction()
   * @generated
   */
  int MATRIX_SUBTRACTION = 24;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_SUBTRACTION__LEFT = MATRIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_SUBTRACTION__RIGHT = MATRIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Matrix Subtraction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_SUBTRACTION_FEATURE_COUNT = MATRIX_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixMultiplicationImpl <em>Matrix Multiplication</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixMultiplicationImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixMultiplication()
   * @generated
   */
  int MATRIX_MULTIPLICATION = 25;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_MULTIPLICATION__LEFT = MATRIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Matrix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_MULTIPLICATION__RIGHT_MATRIX = MATRIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Scalar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_MULTIPLICATION__RIGHT_SCALAR = MATRIX_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Matrix Multiplication</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_MULTIPLICATION_FEATURE_COUNT = MATRIX_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.NewMatrixImpl <em>New Matrix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.NewMatrixImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getNewMatrix()
   * @generated
   */
  int NEW_MATRIX = 26;

  /**
   * The feature id for the '<em><b>Matrix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_MATRIX__MATRIX = MATRIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>New Matrix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_MATRIX_FEATURE_COUNT = MATRIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.TransposeMatrixImpl <em>Transpose Matrix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.TransposeMatrixImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getTransposeMatrix()
   * @generated
   */
  int TRANSPOSE_MATRIX = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPOSE_MATRIX__NAME = MATRIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Transpose Matrix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPOSE_MATRIX_FEATURE_COUNT = MATRIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixVariableImpl <em>Matrix Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixVariableImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixVariable()
   * @generated
   */
  int MATRIX_VARIABLE = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_VARIABLE__NAME = MATRIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Matrix Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_VARIABLE_FEATURE_COUNT = MATRIX_EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Definition</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefinition()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_FunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getVariableAssignment <em>Variable Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable Assignment</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Statement#getVariableAssignment()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_VariableAssignment();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFormula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formula</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Statement#getFormula()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Formula();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixAssignment <em>Matrix Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Matrix Assignment</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixAssignment()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_MatrixAssignment();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixFormula <em>Matrix Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Matrix Formula</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixFormula()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_MatrixFormula();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.VariableAssignment <em>Variable Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Assignment</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.VariableAssignment
   * @generated
   */
  EClass getVariableAssignment();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getVariable()
   * @see #getVariableAssignment()
   * @generated
   */
  EReference getVariableAssignment_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getValue()
   * @see #getVariableAssignment()
   * @generated
   */
  EReference getVariableAssignment_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Formula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formula</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Formula
   * @generated
   */
  EClass getFormula();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Formula#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Formula#getExpression()
   * @see #getFormula()
   * @generated
   */
  EReference getFormula_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Expression#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Expression#getName()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.iee.translator.jmole.math.math.Expression#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Expression#getParameters()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Matrix <em>Matrix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Matrix
   * @generated
   */
  EClass getMatrix();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.iee.translator.jmole.math.math.Matrix#getRows <em>Rows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rows</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Matrix#getRows()
   * @see #getMatrix()
   * @generated
   */
  EReference getMatrix_Rows();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixRow <em>Matrix Row</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Row</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixRow
   * @generated
   */
  EClass getMatrixRow();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.iee.translator.jmole.math.math.MatrixRow#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Elements</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixRow#getElements()
   * @see #getMatrixRow()
   * @generated
   */
  EAttribute getMatrixRow_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAssignment <em>Matrix Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Assignment</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixAssignment
   * @generated
   */
  EClass getMatrixAssignment();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAssignment#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixAssignment#getVariable()
   * @see #getMatrixAssignment()
   * @generated
   */
  EReference getMatrixAssignment_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAssignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixAssignment#getValue()
   * @see #getMatrixAssignment()
   * @generated
   */
  EReference getMatrixAssignment_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixFormula <em>Matrix Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Formula</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixFormula
   * @generated
   */
  EClass getMatrixFormula();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixFormula#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixFormula#getExpression()
   * @see #getMatrixFormula()
   * @generated
   */
  EReference getMatrixFormula_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixExpression <em>Matrix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Expression</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixExpression
   * @generated
   */
  EClass getMatrixExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Definition</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.FunctionDefinition
   * @generated
   */
  EClass getFunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.FunctionDefinition#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.FunctionDefinition#getFunction()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Function();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.FunctionDefinition#getFormula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formula</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.FunctionDefinition#getFormula()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Formula();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MathName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MathName
   * @generated
   */
  EClass getMathName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.jmole.math.math.MathName#getMathName <em>Math Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Math Name</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MathName#getMathName()
   * @see #getMathName()
   * @generated
   */
  EAttribute getMathName_MathName();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Addition <em>Addition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Addition</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Addition
   * @generated
   */
  EClass getAddition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Addition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Addition#getLeft()
   * @see #getAddition()
   * @generated
   */
  EReference getAddition_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Addition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Addition#getRight()
   * @see #getAddition()
   * @generated
   */
  EReference getAddition_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Subtraction <em>Subtraction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtraction</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Subtraction
   * @generated
   */
  EClass getSubtraction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Subtraction#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Subtraction#getLeft()
   * @see #getSubtraction()
   * @generated
   */
  EReference getSubtraction_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Subtraction#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Subtraction#getRight()
   * @see #getSubtraction()
   * @generated
   */
  EReference getSubtraction_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Multiplication <em>Multiplication</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplication</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Multiplication
   * @generated
   */
  EClass getMultiplication();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Multiplication#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Multiplication#getLeft()
   * @see #getMultiplication()
   * @generated
   */
  EReference getMultiplication_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Multiplication#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Multiplication#getRight()
   * @see #getMultiplication()
   * @generated
   */
  EReference getMultiplication_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Division <em>Division</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Division</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Division
   * @generated
   */
  EClass getDivision();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Division#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Division#getLeft()
   * @see #getDivision()
   * @generated
   */
  EReference getDivision_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Division#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Division#getRight()
   * @see #getDivision()
   * @generated
   */
  EReference getDivision_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Modulo <em>Modulo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modulo</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Modulo
   * @generated
   */
  EClass getModulo();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Modulo#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Modulo#getLeft()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Modulo#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Modulo#getRight()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Invert <em>Invert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invert</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Invert
   * @generated
   */
  EClass getInvert();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Invert#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Invert#getExpression()
   * @see #getInvert()
   * @generated
   */
  EReference getInvert_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Factorial <em>Factorial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factorial</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Factorial
   * @generated
   */
  EClass getFactorial();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Factorial#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Factorial#getExpression()
   * @see #getFactorial()
   * @generated
   */
  EReference getFactorial_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Exponent <em>Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exponent</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Exponent
   * @generated
   */
  EClass getExponent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Exponent#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Exponent#getLeft()
   * @see #getExponent()
   * @generated
   */
  EReference getExponent_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Exponent#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Exponent#getRight()
   * @see #getExponent()
   * @generated
   */
  EReference getExponent_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Float <em>Float</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Float</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Float
   * @generated
   */
  EClass getFloat();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.jmole.math.math.Float#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Float#getValue()
   * @see #getFloat()
   * @generated
   */
  EAttribute getFloat_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixElement <em>Matrix Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Element</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixElement
   * @generated
   */
  EClass getMatrixElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixElement#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixElement#getElement()
   * @see #getMatrixElement()
   * @generated
   */
  EReference getMatrixElement_Element();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.jmole.math.math.MatrixElement#getRow <em>Row</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Row</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixElement#getRow()
   * @see #getMatrixElement()
   * @generated
   */
  EAttribute getMatrixElement_Row();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.jmole.math.math.MatrixElement#getColumn <em>Column</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Column</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixElement#getColumn()
   * @see #getMatrixElement()
   * @generated
   */
  EAttribute getMatrixElement_Column();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Function#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Function#getFunction()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Function();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAddition <em>Matrix Addition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Addition</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixAddition
   * @generated
   */
  EClass getMatrixAddition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getLeft()
   * @see #getMatrixAddition()
   * @generated
   */
  EReference getMatrixAddition_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getRight()
   * @see #getMatrixAddition()
   * @generated
   */
  EReference getMatrixAddition_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction <em>Matrix Subtraction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Subtraction</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction
   * @generated
   */
  EClass getMatrixSubtraction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction#getLeft()
   * @see #getMatrixSubtraction()
   * @generated
   */
  EReference getMatrixSubtraction_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction#getRight()
   * @see #getMatrixSubtraction()
   * @generated
   */
  EReference getMatrixSubtraction_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication <em>Matrix Multiplication</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Multiplication</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication
   * @generated
   */
  EClass getMatrixMultiplication();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getLeft()
   * @see #getMatrixMultiplication()
   * @generated
   */
  EReference getMatrixMultiplication_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightMatrix <em>Right Matrix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Matrix</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightMatrix()
   * @see #getMatrixMultiplication()
   * @generated
   */
  EReference getMatrixMultiplication_RightMatrix();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightScalar <em>Right Scalar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Scalar</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightScalar()
   * @see #getMatrixMultiplication()
   * @generated
   */
  EReference getMatrixMultiplication_RightScalar();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.NewMatrix <em>New Matrix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>New Matrix</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.NewMatrix
   * @generated
   */
  EClass getNewMatrix();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.NewMatrix#getMatrix <em>Matrix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Matrix</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.NewMatrix#getMatrix()
   * @see #getNewMatrix()
   * @generated
   */
  EReference getNewMatrix_Matrix();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.TransposeMatrix <em>Transpose Matrix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transpose Matrix</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.TransposeMatrix
   * @generated
   */
  EClass getTransposeMatrix();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.TransposeMatrix#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.TransposeMatrix#getName()
   * @see #getTransposeMatrix()
   * @generated
   */
  EReference getTransposeMatrix_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixVariable <em>Matrix Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Variable</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixVariable
   * @generated
   */
  EClass getMatrixVariable();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.MatrixVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixVariable#getName()
   * @see #getMatrixVariable()
   * @generated
   */
  EReference getMatrixVariable_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MathFactory getMathFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '<em><b>Function Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__FUNCTION_DEFINITION = eINSTANCE.getStatement_FunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Variable Assignment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__VARIABLE_ASSIGNMENT = eINSTANCE.getStatement_VariableAssignment();

    /**
     * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__FORMULA = eINSTANCE.getStatement_Formula();

    /**
     * The meta object literal for the '<em><b>Matrix Assignment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__MATRIX_ASSIGNMENT = eINSTANCE.getStatement_MatrixAssignment();

    /**
     * The meta object literal for the '<em><b>Matrix Formula</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__MATRIX_FORMULA = eINSTANCE.getStatement_MatrixFormula();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.VariableAssignmentImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getVariableAssignment()
     * @generated
     */
    EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ASSIGNMENT__VARIABLE = eINSTANCE.getVariableAssignment_Variable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getVariableAssignment_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FormulaImpl <em>Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.FormulaImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFormula()
     * @generated
     */
    EClass FORMULA = eINSTANCE.getFormula();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMULA__EXPRESSION = eINSTANCE.getFormula_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.ExpressionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__NAME = eINSTANCE.getExpression_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__PARAMETERS = eINSTANCE.getExpression_Parameters();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixImpl <em>Matrix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrix()
     * @generated
     */
    EClass MATRIX = eINSTANCE.getMatrix();

    /**
     * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX__ROWS = eINSTANCE.getMatrix_Rows();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixRowImpl <em>Matrix Row</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixRowImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixRow()
     * @generated
     */
    EClass MATRIX_ROW = eINSTANCE.getMatrixRow();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATRIX_ROW__ELEMENTS = eINSTANCE.getMatrixRow_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixAssignmentImpl <em>Matrix Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixAssignmentImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixAssignment()
     * @generated
     */
    EClass MATRIX_ASSIGNMENT = eINSTANCE.getMatrixAssignment();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_ASSIGNMENT__VARIABLE = eINSTANCE.getMatrixAssignment_Variable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_ASSIGNMENT__VALUE = eINSTANCE.getMatrixAssignment_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixFormulaImpl <em>Matrix Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixFormulaImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixFormula()
     * @generated
     */
    EClass MATRIX_FORMULA = eINSTANCE.getMatrixFormula();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_FORMULA__EXPRESSION = eINSTANCE.getMatrixFormula_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixExpressionImpl <em>Matrix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixExpressionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixExpression()
     * @generated
     */
    EClass MATRIX_EXPRESSION = eINSTANCE.getMatrixExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.FunctionDefinitionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFunctionDefinition()
     * @generated
     */
    EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__FUNCTION = eINSTANCE.getFunctionDefinition_Function();

    /**
     * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__FORMULA = eINSTANCE.getFunctionDefinition_Formula();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MathNameImpl <em>Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathNameImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMathName()
     * @generated
     */
    EClass MATH_NAME = eINSTANCE.getMathName();

    /**
     * The meta object literal for the '<em><b>Math Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATH_NAME__MATH_NAME = eINSTANCE.getMathName_MathName();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.AdditionImpl <em>Addition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.AdditionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getAddition()
     * @generated
     */
    EClass ADDITION = eINSTANCE.getAddition();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITION__LEFT = eINSTANCE.getAddition_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITION__RIGHT = eINSTANCE.getAddition_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.SubtractionImpl <em>Subtraction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.SubtractionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getSubtraction()
     * @generated
     */
    EClass SUBTRACTION = eINSTANCE.getSubtraction();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTRACTION__LEFT = eINSTANCE.getSubtraction_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTRACTION__RIGHT = eINSTANCE.getSubtraction_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MultiplicationImpl <em>Multiplication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MultiplicationImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMultiplication()
     * @generated
     */
    EClass MULTIPLICATION = eINSTANCE.getMultiplication();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATION__LEFT = eINSTANCE.getMultiplication_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATION__RIGHT = eINSTANCE.getMultiplication_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.DivisionImpl <em>Division</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.DivisionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getDivision()
     * @generated
     */
    EClass DIVISION = eINSTANCE.getDivision();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIVISION__LEFT = eINSTANCE.getDivision_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIVISION__RIGHT = eINSTANCE.getDivision_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.ModuloImpl <em>Modulo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.ModuloImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getModulo()
     * @generated
     */
    EClass MODULO = eINSTANCE.getModulo();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULO__LEFT = eINSTANCE.getModulo_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULO__RIGHT = eINSTANCE.getModulo_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.InvertImpl <em>Invert</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.InvertImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getInvert()
     * @generated
     */
    EClass INVERT = eINSTANCE.getInvert();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVERT__EXPRESSION = eINSTANCE.getInvert_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FactorialImpl <em>Factorial</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.FactorialImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFactorial()
     * @generated
     */
    EClass FACTORIAL = eINSTANCE.getFactorial();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORIAL__EXPRESSION = eINSTANCE.getFactorial_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.ExponentImpl <em>Exponent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.ExponentImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getExponent()
     * @generated
     */
    EClass EXPONENT = eINSTANCE.getExponent();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPONENT__LEFT = eINSTANCE.getExponent_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPONENT__RIGHT = eINSTANCE.getExponent_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.VariableImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FloatImpl <em>Float</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.FloatImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFloat()
     * @generated
     */
    EClass FLOAT = eINSTANCE.getFloat();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOAT__VALUE = eINSTANCE.getFloat_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixElementImpl <em>Matrix Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixElementImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixElement()
     * @generated
     */
    EClass MATRIX_ELEMENT = eINSTANCE.getMatrixElement();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_ELEMENT__ELEMENT = eINSTANCE.getMatrixElement_Element();

    /**
     * The meta object literal for the '<em><b>Row</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATRIX_ELEMENT__ROW = eINSTANCE.getMatrixElement_Row();

    /**
     * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATRIX_ELEMENT__COLUMN = eINSTANCE.getMatrixElement_Column();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.FunctionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__FUNCTION = eINSTANCE.getFunction_Function();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixAdditionImpl <em>Matrix Addition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixAdditionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixAddition()
     * @generated
     */
    EClass MATRIX_ADDITION = eINSTANCE.getMatrixAddition();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_ADDITION__LEFT = eINSTANCE.getMatrixAddition_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_ADDITION__RIGHT = eINSTANCE.getMatrixAddition_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixSubtractionImpl <em>Matrix Subtraction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixSubtractionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixSubtraction()
     * @generated
     */
    EClass MATRIX_SUBTRACTION = eINSTANCE.getMatrixSubtraction();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_SUBTRACTION__LEFT = eINSTANCE.getMatrixSubtraction_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_SUBTRACTION__RIGHT = eINSTANCE.getMatrixSubtraction_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixMultiplicationImpl <em>Matrix Multiplication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixMultiplicationImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixMultiplication()
     * @generated
     */
    EClass MATRIX_MULTIPLICATION = eINSTANCE.getMatrixMultiplication();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_MULTIPLICATION__LEFT = eINSTANCE.getMatrixMultiplication_Left();

    /**
     * The meta object literal for the '<em><b>Right Matrix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_MULTIPLICATION__RIGHT_MATRIX = eINSTANCE.getMatrixMultiplication_RightMatrix();

    /**
     * The meta object literal for the '<em><b>Right Scalar</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_MULTIPLICATION__RIGHT_SCALAR = eINSTANCE.getMatrixMultiplication_RightScalar();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.NewMatrixImpl <em>New Matrix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.NewMatrixImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getNewMatrix()
     * @generated
     */
    EClass NEW_MATRIX = eINSTANCE.getNewMatrix();

    /**
     * The meta object literal for the '<em><b>Matrix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEW_MATRIX__MATRIX = eINSTANCE.getNewMatrix_Matrix();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.TransposeMatrixImpl <em>Transpose Matrix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.TransposeMatrixImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getTransposeMatrix()
     * @generated
     */
    EClass TRANSPOSE_MATRIX = eINSTANCE.getTransposeMatrix();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSPOSE_MATRIX__NAME = eINSTANCE.getTransposeMatrix_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixVariableImpl <em>Matrix Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixVariableImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixVariable()
     * @generated
     */
    EClass MATRIX_VARIABLE = eINSTANCE.getMatrixVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_VARIABLE__NAME = eINSTANCE.getMatrixVariable_Name();

  }

} //MathPackage
