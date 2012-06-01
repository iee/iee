/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matrix Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.MatrixElement#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.MatrixElement#getRow <em>Row</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.MatrixElement#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixElement()
 * @model
 * @generated
 */
public interface MatrixElement extends Expression
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' attribute.
   * @see #setElement(String)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixElement_Element()
   * @model
   * @generated
   */
  String getElement();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixElement#getElement <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' attribute.
   * @see #getElement()
   * @generated
   */
  void setElement(String value);

  /**
   * Returns the value of the '<em><b>Row</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Row</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Row</em>' attribute.
   * @see #setRow(String)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixElement_Row()
   * @model
   * @generated
   */
  String getRow();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixElement#getRow <em>Row</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Row</em>' attribute.
   * @see #getRow()
   * @generated
   */
  void setRow(String value);

  /**
   * Returns the value of the '<em><b>Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Column</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Column</em>' attribute.
   * @see #setColumn(String)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getMatrixElement_Column()
   * @model
   * @generated
   */
  String getColumn();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.MatrixElement#getColumn <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Column</em>' attribute.
   * @see #getColumn()
   * @generated
   */
  void setColumn(String value);

} // MatrixElement
