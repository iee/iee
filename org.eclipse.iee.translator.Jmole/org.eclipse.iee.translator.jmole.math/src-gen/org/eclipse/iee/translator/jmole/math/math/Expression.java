/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Expression#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Expression#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject
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
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getExpression_Name()
   * @model containment="true"
   * @generated
   */
  MathName getName();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Expression#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(MathName value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.iee.translator.jmole.math.math.Formula}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getExpression_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Formula> getParameters();

} // Expression
