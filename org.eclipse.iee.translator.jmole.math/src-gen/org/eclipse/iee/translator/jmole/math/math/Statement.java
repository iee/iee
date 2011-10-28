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
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefenition <em>Function Defenition</em>}</li>
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
   * Returns the value of the '<em><b>Function Defenition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Defenition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Defenition</em>' containment reference.
   * @see #setFunctionDefenition(FunctionDefinition)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_FunctionDefenition()
   * @model containment="true"
   * @generated
   */
  FunctionDefinition getFunctionDefenition();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefenition <em>Function Defenition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Defenition</em>' containment reference.
   * @see #getFunctionDefenition()
   * @generated
   */
  void setFunctionDefenition(FunctionDefinition value);

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
