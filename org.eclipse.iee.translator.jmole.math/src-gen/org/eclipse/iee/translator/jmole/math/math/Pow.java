/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.iee.translator.jmole.math.math;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Pow#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Pow#getPower <em>Power</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getPow()
 * @model
 * @generated
 */
public interface Pow extends Expression
{
  /**
   * Returns the value of the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference.
   * @see #setBase(Expression)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getPow_Base()
   * @model containment="true"
   * @generated
   */
  Expression getBase();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Pow#getBase <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' containment reference.
   * @see #getBase()
   * @generated
   */
  void setBase(Expression value);

  /**
   * Returns the value of the '<em><b>Power</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Power</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Power</em>' containment reference.
   * @see #setPower(Expression)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getPow_Power()
   * @model containment="true"
   * @generated
   */
  Expression getPower();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Pow#getPower <em>Power</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Power</em>' containment reference.
   * @see #getPower()
   * @generated
   */
  void setPower(Expression value);

} // Pow
