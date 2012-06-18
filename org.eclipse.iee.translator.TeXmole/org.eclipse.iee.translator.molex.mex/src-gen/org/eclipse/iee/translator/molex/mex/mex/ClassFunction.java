/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.ClassFunction#getClass_ <em>Class </em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.ClassFunction#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getClassFunction()
 * @model
 * @generated
 */
public interface ClassFunction extends Expression
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
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getClassFunction_Class_()
   * @model containment="true"
   * @generated
   */
  MathName getClass_();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.ClassFunction#getClass_ <em>Class </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class </em>' containment reference.
   * @see #getClass_()
   * @generated
   */
  void setClass_(MathName value);

  /**
   * Returns the value of the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' containment reference.
   * @see #setFunction(Expression)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getClassFunction_Function()
   * @model containment="true"
   * @generated
   */
  Expression getFunction();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.ClassFunction#getFunction <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' containment reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(Expression value);

} // ClassFunction
