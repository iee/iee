/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Matrix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.NewMatrix#getMatrix <em>Matrix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getNewMatrix()
 * @model
 * @generated
 */
public interface NewMatrix extends MatrixExpression
{
  /**
   * Returns the value of the '<em><b>Matrix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Matrix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Matrix</em>' containment reference.
   * @see #setMatrix(Matrix)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getNewMatrix_Matrix()
   * @model containment="true"
   * @generated
   */
  Matrix getMatrix();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.NewMatrix#getMatrix <em>Matrix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Matrix</em>' containment reference.
   * @see #getMatrix()
   * @generated
   */
  void setMatrix(Matrix value);

} // NewMatrix
