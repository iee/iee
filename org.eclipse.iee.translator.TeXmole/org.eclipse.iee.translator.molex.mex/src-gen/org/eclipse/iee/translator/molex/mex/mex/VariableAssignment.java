/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.VariableAssignment#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.VariableAssignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(MathName)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getVariableAssignment_Variable()
   * @model containment="true"
   * @generated
   */
  MathName getVariable();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.VariableAssignment#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(MathName value);

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
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getVariableAssignment_Value()
   * @model containment="true"
   * @generated
   */
  Formula getValue();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.VariableAssignment#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Formula value);

} // VariableAssignment
