/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixDefinition <em>Matrix Definition</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFormula <em>Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement()
 * @model
 * @generated
 */
public interface Statement extends EObject
{
  /**
   * Returns the value of the '<em><b>Function Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Definition</em>' containment reference.
   * @see #setFunctionDefinition(FunctionDefinition)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_FunctionDefinition()
   * @model containment="true"
   * @generated
   */
  FunctionDefinition getFunctionDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefinition <em>Function Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Definition</em>' containment reference.
   * @see #getFunctionDefinition()
   * @generated
   */
  void setFunctionDefinition(FunctionDefinition value);

  /**
   * Returns the value of the '<em><b>Matrix Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Matrix Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Matrix Definition</em>' containment reference.
   * @see #setMatrixDefinition(MatrixDefinition)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_MatrixDefinition()
   * @model containment="true"
   * @generated
   */
  MatrixDefinition getMatrixDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixDefinition <em>Matrix Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Matrix Definition</em>' containment reference.
   * @see #getMatrixDefinition()
   * @generated
   */
  void setMatrixDefinition(MatrixDefinition value);

  /**
   * Returns the value of the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formula</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formula</em>' containment reference.
   * @see #setFormula(Formula)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_Formula()
   * @model containment="true"
   * @generated
   */
  Formula getFormula();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFormula <em>Formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formula</em>' containment reference.
   * @see #getFormula()
   * @generated
   */
  void setFormula(Formula value);

} // Statement
