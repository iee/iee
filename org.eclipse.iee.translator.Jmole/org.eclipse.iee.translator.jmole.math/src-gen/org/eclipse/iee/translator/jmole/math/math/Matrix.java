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
 * A representation of the model object '<em><b>Matrix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Matrix#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrix()
 * @model
 * @generated
 */
public interface Matrix extends EObject
{
  /**
   * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.iee.translator.jmole.math.math.MatrixRow}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rows</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rows</em>' containment reference list.
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getMatrix_Rows()
   * @model containment="true"
   * @generated
   */
  EList<MatrixRow> getRows();

} // Matrix
