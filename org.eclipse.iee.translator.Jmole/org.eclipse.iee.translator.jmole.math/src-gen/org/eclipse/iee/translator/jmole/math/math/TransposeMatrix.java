/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transpose Matrix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.TransposeMatrix#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getTransposeMatrix()
 * @model
 * @generated
 */
public interface TransposeMatrix extends MatrixExpression
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(MathName)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getTransposeMatrix_Name()
   * @model containment="true"
   * @generated
   */
  MathName getName();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.TransposeMatrix#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(MathName value);

} // TransposeMatrix
