/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.MatrixExpression#getAddition <em>Addition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixExpression()
 * @model
 * @generated
 */
public interface MatrixExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Addition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Addition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Addition</em>' containment reference.
   * @see #setAddition(MatrixExpression)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixExpression_Addition()
   * @model containment="true"
   * @generated
   */
  MatrixExpression getAddition();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixExpression#getAddition <em>Addition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Addition</em>' containment reference.
   * @see #getAddition()
   * @generated
   */
  void setAddition(MatrixExpression value);

} // MatrixExpression
