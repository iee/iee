/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix In Brackets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.MatrixInBrackets#getInBrackets <em>In Brackets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixInBrackets()
 * @model
 * @generated
 */
public interface MatrixInBrackets extends MatrixExpression
{
  /**
   * Returns the value of the '<em><b>In Brackets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In Brackets</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In Brackets</em>' containment reference.
   * @see #setInBrackets(MatrixExpression)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixInBrackets_InBrackets()
   * @model containment="true"
   * @generated
   */
  MatrixExpression getInBrackets();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixInBrackets#getInBrackets <em>In Brackets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>In Brackets</em>' containment reference.
   * @see #getInBrackets()
   * @generated
   */
  void setInBrackets(MatrixExpression value);

} // MatrixInBrackets
