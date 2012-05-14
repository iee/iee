/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.MatrixFormula#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixFormula()
 * @model
 * @generated
 */
public interface MatrixFormula extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(MatrixExpression)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixFormula_Expression()
   * @model containment="true"
   * @generated
   */
  MatrixExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixFormula#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(MatrixExpression value);

} // MatrixFormula
