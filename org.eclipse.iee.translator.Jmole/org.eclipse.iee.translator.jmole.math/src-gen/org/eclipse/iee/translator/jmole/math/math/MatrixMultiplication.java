/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix Multiplication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightMatrix <em>Right Matrix</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightScalar <em>Right Scalar</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrixMultiplication()
 * @model
 * @generated
 */
public interface MatrixMultiplication extends MatrixExpression
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
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrixMultiplication_Left()
   * @model containment="true"
   * @generated
   */
  MatrixExpression getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(MatrixExpression value);

  /**
   * Returns the value of the '<em><b>Right Matrix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Matrix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Matrix</em>' containment reference.
   * @see #setRightMatrix(MatrixExpression)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrixMultiplication_RightMatrix()
   * @model containment="true"
   * @generated
   */
  MatrixExpression getRightMatrix();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightMatrix <em>Right Matrix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Matrix</em>' containment reference.
   * @see #getRightMatrix()
   * @generated
   */
  void setRightMatrix(MatrixExpression value);

  /**
   * Returns the value of the '<em><b>Right Scalar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Scalar</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Scalar</em>' containment reference.
   * @see #setRightScalar(Formula)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrixMultiplication_RightScalar()
   * @model containment="true"
   * @generated
   */
  Formula getRightScalar();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication#getRightScalar <em>Right Scalar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Scalar</em>' containment reference.
   * @see #getRightScalar()
   * @generated
   */
  void setRightScalar(Formula value);

} // MatrixMultiplication
