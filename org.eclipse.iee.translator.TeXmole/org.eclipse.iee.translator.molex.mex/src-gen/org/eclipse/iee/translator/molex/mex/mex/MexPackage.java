/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;

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
 * @see org.eclipse.iee.translator.molex.mex.mex.MexFactory
 * @model kind="package"
 * @generated
 */
public interface MexPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mex";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/iee/translator/molex/mex/Mex";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mex";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MexPackage eINSTANCE = org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getStatement()
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
   * The feature id for the '<em><b>Matrix Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__MATRIX_DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__ASSIGNMENT = 2;

  /**
   * The feature id for the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__FORMULA = 3;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.AssignmentImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 1;

  /**
   * The feature id for the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FormulaImpl <em>Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.FormulaImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFormula()
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.ExpressionImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.FunctionDefinitionImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 4;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixDefinitionImpl <em>Matrix Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MatrixDefinitionImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getMatrixDefinition()
   * @generated
   */
  int MATRIX_DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Rows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_DEFINITION__ROWS = 1;

  /**
   * The number of structural features of the '<em>Matrix Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixRowImpl <em>Matrix Row</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MatrixRowImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getMatrixRow()
   * @generated
   */
  int MATRIX_ROW = 6;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.AdditionImpl <em>Addition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.AdditionImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getAddition()
   * @generated
   */
  int ADDITION = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.SubtractionImpl <em>Subtraction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.SubtractionImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getSubtraction()
   * @generated
   */
  int SUBTRACTION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.MultiplicationImpl <em>Multiplication</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MultiplicationImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getMultiplication()
   * @generated
   */
  int MULTIPLICATION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.DivisionImpl <em>Division</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.DivisionImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getDivision()
   * @generated
   */
  int DIVISION = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.ModuloImpl <em>Modulo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.ModuloImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getModulo()
   * @generated
   */
  int MODULO = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.InvertImpl <em>Invert</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.InvertImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getInvert()
   * @generated
   */
  int INVERT = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FactorialImpl <em>Factorial</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.FactorialImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFactorial()
   * @generated
   */
  int FACTORIAL = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.IntervalImpl <em>Interval</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.IntervalImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getInterval()
   * @generated
   */
  int INTERVAL = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Opening Bracket</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__OPENING_BRACKET = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ceil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__CEIL = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Floor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__FLOOR = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Closing Bracket</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__CLOSING_BRACKET = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Interval</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.ExponentImpl <em>Exponent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.ExponentImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getExponent()
   * @generated
   */
  int EXPONENT = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.VariableImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FloatImpl <em>Float</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.FloatImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFloat()
   * @generated
   */
  int FLOAT = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * The meta object id for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.FunctionImpl
   * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
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
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Statement#getFunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Definition</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Statement#getFunctionDefinition()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_FunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Statement#getMatrixDefinition <em>Matrix Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Matrix Definition</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Statement#getMatrixDefinition()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_MatrixDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Statement#getAssignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assignment</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Statement#getAssignment()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Assignment();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Statement#getFormula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formula</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Statement#getFormula()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Formula();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.molex.mex.mex.Assignment#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Assignment#getVariable()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Assignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Assignment#getValue()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Formula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formula</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Formula
   * @generated
   */
  EClass getFormula();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Formula#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Formula#getExpression()
   * @see #getFormula()
   * @generated
   */
  EReference getFormula_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.molex.mex.mex.Expression#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Expression#getName()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.iee.translator.molex.mex.mex.Expression#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Expression#getParameters()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Definition</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition
   * @generated
   */
  EClass getFunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition#getFunction()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Function();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition#getFormula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formula</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition#getFormula()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Formula();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition <em>Matrix Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Definition</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition
   * @generated
   */
  EClass getMatrixDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition#getName()
   * @see #getMatrixDefinition()
   * @generated
   */
  EAttribute getMatrixDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition#getRows <em>Rows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rows</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition#getRows()
   * @see #getMatrixDefinition()
   * @generated
   */
  EReference getMatrixDefinition_Rows();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixRow <em>Matrix Row</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Row</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.MatrixRow
   * @generated
   */
  EClass getMatrixRow();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixRow#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Elements</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.MatrixRow#getElements()
   * @see #getMatrixRow()
   * @generated
   */
  EAttribute getMatrixRow_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Addition <em>Addition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Addition</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Addition
   * @generated
   */
  EClass getAddition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Addition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Addition#getLeft()
   * @see #getAddition()
   * @generated
   */
  EReference getAddition_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Addition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Addition#getRight()
   * @see #getAddition()
   * @generated
   */
  EReference getAddition_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Subtraction <em>Subtraction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtraction</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Subtraction
   * @generated
   */
  EClass getSubtraction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Subtraction#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Subtraction#getLeft()
   * @see #getSubtraction()
   * @generated
   */
  EReference getSubtraction_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Subtraction#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Subtraction#getRight()
   * @see #getSubtraction()
   * @generated
   */
  EReference getSubtraction_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Multiplication <em>Multiplication</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplication</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Multiplication
   * @generated
   */
  EClass getMultiplication();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Multiplication#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Multiplication#getLeft()
   * @see #getMultiplication()
   * @generated
   */
  EReference getMultiplication_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Multiplication#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Multiplication#getRight()
   * @see #getMultiplication()
   * @generated
   */
  EReference getMultiplication_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Division <em>Division</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Division</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Division
   * @generated
   */
  EClass getDivision();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Division#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Division#getLeft()
   * @see #getDivision()
   * @generated
   */
  EReference getDivision_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Division#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Division#getRight()
   * @see #getDivision()
   * @generated
   */
  EReference getDivision_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Modulo <em>Modulo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modulo</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Modulo
   * @generated
   */
  EClass getModulo();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Modulo#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Modulo#getLeft()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Modulo#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Modulo#getRight()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Invert <em>Invert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invert</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Invert
   * @generated
   */
  EClass getInvert();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Invert#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Invert#getExpression()
   * @see #getInvert()
   * @generated
   */
  EReference getInvert_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Factorial <em>Factorial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factorial</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Factorial
   * @generated
   */
  EClass getFactorial();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Factorial#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Factorial#getExpression()
   * @see #getFactorial()
   * @generated
   */
  EReference getFactorial_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Interval <em>Interval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interval</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Interval
   * @generated
   */
  EClass getInterval();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getOpeningBracket <em>Opening Bracket</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opening Bracket</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Interval#getOpeningBracket()
   * @see #getInterval()
   * @generated
   */
  EAttribute getInterval_OpeningBracket();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getCeil <em>Ceil</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ceil</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Interval#getCeil()
   * @see #getInterval()
   * @generated
   */
  EReference getInterval_Ceil();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getFloor <em>Floor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Floor</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Interval#getFloor()
   * @see #getInterval()
   * @generated
   */
  EReference getInterval_Floor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getClosingBracket <em>Closing Bracket</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Closing Bracket</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Interval#getClosingBracket()
   * @see #getInterval()
   * @generated
   */
  EAttribute getInterval_ClosingBracket();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Exponent <em>Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exponent</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Exponent
   * @generated
   */
  EClass getExponent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Exponent#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Exponent#getLeft()
   * @see #getExponent()
   * @generated
   */
  EReference getExponent_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Exponent#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Exponent#getRight()
   * @see #getExponent()
   * @generated
   */
  EReference getExponent_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Float <em>Float</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Float</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Float
   * @generated
   */
  EClass getFloat();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.molex.mex.mex.Float#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Float#getValue()
   * @see #getFloat()
   * @generated
   */
  EAttribute getFloat_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.iee.translator.molex.mex.mex.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.molex.mex.mex.Function#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see org.eclipse.iee.translator.molex.mex.mex.Function#getFunction()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Function();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MexFactory getMexFactory();

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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getStatement()
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
     * The meta object literal for the '<em><b>Matrix Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__MATRIX_DEFINITION = eINSTANCE.getStatement_MatrixDefinition();

    /**
     * The meta object literal for the '<em><b>Assignment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__ASSIGNMENT = eINSTANCE.getStatement_Assignment();

    /**
     * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__FORMULA = eINSTANCE.getStatement_Formula();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.AssignmentImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT__VARIABLE = eINSTANCE.getAssignment_Variable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FormulaImpl <em>Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.FormulaImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFormula()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.ExpressionImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION__NAME = eINSTANCE.getExpression_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__PARAMETERS = eINSTANCE.getExpression_Parameters();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.FunctionDefinitionImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFunctionDefinition()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixDefinitionImpl <em>Matrix Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MatrixDefinitionImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getMatrixDefinition()
     * @generated
     */
    EClass MATRIX_DEFINITION = eINSTANCE.getMatrixDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATRIX_DEFINITION__NAME = eINSTANCE.getMatrixDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_DEFINITION__ROWS = eINSTANCE.getMatrixDefinition_Rows();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixRowImpl <em>Matrix Row</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MatrixRowImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getMatrixRow()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.AdditionImpl <em>Addition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.AdditionImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getAddition()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.SubtractionImpl <em>Subtraction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.SubtractionImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getSubtraction()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.MultiplicationImpl <em>Multiplication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MultiplicationImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getMultiplication()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.DivisionImpl <em>Division</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.DivisionImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getDivision()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.ModuloImpl <em>Modulo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.ModuloImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getModulo()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.InvertImpl <em>Invert</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.InvertImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getInvert()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FactorialImpl <em>Factorial</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.FactorialImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFactorial()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.IntervalImpl <em>Interval</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.IntervalImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getInterval()
     * @generated
     */
    EClass INTERVAL = eINSTANCE.getInterval();

    /**
     * The meta object literal for the '<em><b>Opening Bracket</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__OPENING_BRACKET = eINSTANCE.getInterval_OpeningBracket();

    /**
     * The meta object literal for the '<em><b>Ceil</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL__CEIL = eINSTANCE.getInterval_Ceil();

    /**
     * The meta object literal for the '<em><b>Floor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL__FLOOR = eINSTANCE.getInterval_Floor();

    /**
     * The meta object literal for the '<em><b>Closing Bracket</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__CLOSING_BRACKET = eINSTANCE.getInterval_ClosingBracket();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.ExponentImpl <em>Exponent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.ExponentImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getExponent()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.VariableImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FloatImpl <em>Float</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.FloatImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFloat()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.molex.mex.mex.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.FunctionImpl
     * @see org.eclipse.iee.translator.molex.mex.mex.impl.MexPackageImpl#getFunction()
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

  }

} //MexPackage
