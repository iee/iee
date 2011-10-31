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
   * The feature id for the '<em><b>Matrix Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__MATRIX_DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__FORMULA = 2;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FormulaImpl <em>Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FormulaImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFormula()
   * @generated
   */
  int FORMULA = 1;

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
  int EXPRESSION = 2;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FunctionDefinitionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 3;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixDefinitionImpl <em>Matrix Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixDefinitionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixDefinition()
   * @generated
   */
  int MATRIX_DEFINITION = 4;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.AdditionImpl <em>Addition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.AdditionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getAddition()
   * @generated
   */
  int ADDITION = 6;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.SubtractionImpl <em>Subtraction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.SubtractionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getSubtraction()
   * @generated
   */
  int SUBTRACTION = 7;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MultiplicationImpl <em>Multiplication</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MultiplicationImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMultiplication()
   * @generated
   */
  int MULTIPLICATION = 8;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.DivisionImpl <em>Division</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.DivisionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getDivision()
   * @generated
   */
  int DIVISION = 9;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.PowerImpl <em>Power</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.PowerImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getPower()
   * @generated
   */
  int POWER = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER__NAME = EXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER__PARAMETERS = EXPRESSION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Power</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.VariableImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 11;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FloatImpl <em>Float</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FloatImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFloat()
   * @generated
   */
  int FLOAT = 12;

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
   * The meta object id for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.iee.translator.jmole.math.math.impl.FunctionImpl
   * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 13;

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
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixDefinition <em>Matrix Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Matrix Definition</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixDefinition()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_MatrixDefinition();

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
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.jmole.math.math.Expression#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Expression#getName()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_Name();

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
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.MatrixDefinition <em>Matrix Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Definition</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixDefinition
   * @generated
   */
  EClass getMatrixDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.iee.translator.jmole.math.math.MatrixDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixDefinition#getName()
   * @see #getMatrixDefinition()
   * @generated
   */
  EAttribute getMatrixDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.iee.translator.jmole.math.math.MatrixDefinition#getRows <em>Rows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rows</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.MatrixDefinition#getRows()
   * @see #getMatrixDefinition()
   * @generated
   */
  EReference getMatrixDefinition_Rows();

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
   * Returns the meta object for class '{@link org.eclipse.iee.translator.jmole.math.math.Power <em>Power</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Power</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Power
   * @generated
   */
  EClass getPower();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Power#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Power#getLeft()
   * @see #getPower()
   * @generated
   */
  EReference getPower_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.iee.translator.jmole.math.math.Power#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.iee.translator.jmole.math.math.Power#getRight()
   * @see #getPower()
   * @generated
   */
  EReference getPower_Right();

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
     * The meta object literal for the '<em><b>Matrix Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__MATRIX_DEFINITION = eINSTANCE.getStatement_MatrixDefinition();

    /**
     * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__FORMULA = eINSTANCE.getStatement_Formula();

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
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixDefinitionImpl <em>Matrix Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MatrixDefinitionImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getMatrixDefinition()
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
     * The meta object literal for the '{@link org.eclipse.iee.translator.jmole.math.math.impl.PowerImpl <em>Power</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.iee.translator.jmole.math.math.impl.PowerImpl
     * @see org.eclipse.iee.translator.jmole.math.math.impl.MathPackageImpl#getPower()
     * @generated
     */
    EClass POWER = eINSTANCE.getPower();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POWER__LEFT = eINSTANCE.getPower_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POWER__RIGHT = eINSTANCE.getPower_Right();

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

  }

} //MathPackage
