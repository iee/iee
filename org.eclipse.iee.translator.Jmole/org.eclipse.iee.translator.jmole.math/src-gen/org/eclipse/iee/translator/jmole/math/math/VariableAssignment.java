/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' attribute.
   * @see #setVariable(String)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getVariableAssignment_Variable()
   * @model
   * @generated
   */
  String getVariable();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getVariable <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' attribute.
   * @see #getVariable()
   * @generated
   */
  void setVariable(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Formula)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getVariableAssignment_Value()
   * @model containment="true"
   * @generated
   */
  Formula getValue();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.VariableAssignment#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Formula value);

} // VariableAssignment
