/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.ClassMember#getClass_ <em>Class </em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.ClassMember#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getClassMember()
 * @model
 * @generated
 */
public interface ClassMember extends Expression
{
  /**
   * Returns the value of the '<em><b>Class </b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class </em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class </em>' containment reference.
   * @see #setClass_(MathName)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getClassMember_Class_()
   * @model containment="true"
   * @generated
   */
  MathName getClass_();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.ClassMember#getClass_ <em>Class </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class </em>' containment reference.
   * @see #getClass_()
   * @generated
   */
  void setClass_(MathName value);

  /**
   * Returns the value of the '<em><b>Member</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Member</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Member</em>' containment reference.
   * @see #setMember(MathName)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getClassMember_Member()
   * @model containment="true"
   * @generated
   */
  MathName getMember();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.ClassMember#getMember <em>Member</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Member</em>' containment reference.
   * @see #getMember()
   * @generated
   */
  void setMember(MathName value);

} // ClassMember
