/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.math.math;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.math.math.MatrixRow#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.math.math.MathPackage#getMatrixRow()
 * @model
 * @generated
 */
public interface MatrixRow extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' attribute list.
   * @see org.eclipse.iee.translator.molex.math.math.MathPackage#getMatrixRow_Elements()
   * @model unique="false"
   * @generated
   */
  EList<String> getElements();

} // MatrixRow
