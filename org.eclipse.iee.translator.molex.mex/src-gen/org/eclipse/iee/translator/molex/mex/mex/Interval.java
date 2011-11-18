/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getOpeningBracket <em>Opening Bracket</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getCeil <em>Ceil</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getFloor <em>Floor</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getClosingBracket <em>Closing Bracket</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getInterval()
 * @model
 * @generated
 */
public interface Interval extends Expression
{
  /**
   * Returns the value of the '<em><b>Opening Bracket</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opening Bracket</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opening Bracket</em>' attribute.
   * @see #setOpeningBracket(String)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getInterval_OpeningBracket()
   * @model
   * @generated
   */
  String getOpeningBracket();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getOpeningBracket <em>Opening Bracket</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opening Bracket</em>' attribute.
   * @see #getOpeningBracket()
   * @generated
   */
  void setOpeningBracket(String value);

  /**
   * Returns the value of the '<em><b>Ceil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ceil</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ceil</em>' containment reference.
   * @see #setCeil(Expression)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getInterval_Ceil()
   * @model containment="true"
   * @generated
   */
  Expression getCeil();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getCeil <em>Ceil</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ceil</em>' containment reference.
   * @see #getCeil()
   * @generated
   */
  void setCeil(Expression value);

  /**
   * Returns the value of the '<em><b>Floor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Floor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Floor</em>' containment reference.
   * @see #setFloor(Expression)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getInterval_Floor()
   * @model containment="true"
   * @generated
   */
  Expression getFloor();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getFloor <em>Floor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Floor</em>' containment reference.
   * @see #getFloor()
   * @generated
   */
  void setFloor(Expression value);

  /**
   * Returns the value of the '<em><b>Closing Bracket</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Closing Bracket</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Closing Bracket</em>' attribute.
   * @see #setClosingBracket(String)
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#getInterval_ClosingBracket()
   * @model
   * @generated
   */
  String getClosingBracket();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.molex.mex.mex.Interval#getClosingBracket <em>Closing Bracket</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Closing Bracket</em>' attribute.
   * @see #getClosingBracket()
   * @generated
   */
  void setClosingBracket(String value);

} // Interval
