/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrixAddition()
 * @model
 * @generated
 */
public interface MatrixAddition extends MatrixExpression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(MatrixExpression)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrixAddition_Left()
   * @model containment="true"
   * @generated
   */
  MatrixExpression getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(MatrixExpression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(MatrixExpression)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrixAddition_Right()
   * @model containment="true"
   * @generated
   */
  MatrixExpression getRight();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.MatrixAddition#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(MatrixExpression value);

} // MatrixAddition
