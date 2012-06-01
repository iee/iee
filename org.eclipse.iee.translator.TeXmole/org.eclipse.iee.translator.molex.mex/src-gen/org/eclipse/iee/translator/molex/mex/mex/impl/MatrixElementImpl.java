/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.iee.translator.molex.mex.mex.MatrixElement;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixElementImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixElementImpl#getRow <em>Row</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixElementImpl#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixElementImpl extends ExpressionImpl implements MatrixElement
{
  /**
   * The default value of the '{@link #getElement() <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected String element = ELEMENT_EDEFAULT;

  /**
   * The default value of the '{@link #getRow() <em>Row</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRow()
   * @generated
   * @ordered
   */
  protected static final String ROW_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRow() <em>Row</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRow()
   * @generated
   * @ordered
   */
  protected String row = ROW_EDEFAULT;

  /**
   * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected static final String COLUMN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected String column = COLUMN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatrixElementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MexPackage.Literals.MATRIX_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(String newElement)
  {
    String oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_ELEMENT__ELEMENT, oldElement, element));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRow()
  {
    return row;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRow(String newRow)
  {
    String oldRow = row;
    row = newRow;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_ELEMENT__ROW, oldRow, row));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getColumn()
  {
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColumn(String newColumn)
  {
    String oldColumn = column;
    column = newColumn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_ELEMENT__COLUMN, oldColumn, column));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MexPackage.MATRIX_ELEMENT__ELEMENT:
        return getElement();
      case MexPackage.MATRIX_ELEMENT__ROW:
        return getRow();
      case MexPackage.MATRIX_ELEMENT__COLUMN:
        return getColumn();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MexPackage.MATRIX_ELEMENT__ELEMENT:
        setElement((String)newValue);
        return;
      case MexPackage.MATRIX_ELEMENT__ROW:
        setRow((String)newValue);
        return;
      case MexPackage.MATRIX_ELEMENT__COLUMN:
        setColumn((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MexPackage.MATRIX_ELEMENT__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case MexPackage.MATRIX_ELEMENT__ROW:
        setRow(ROW_EDEFAULT);
        return;
      case MexPackage.MATRIX_ELEMENT__COLUMN:
        setColumn(COLUMN_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MexPackage.MATRIX_ELEMENT__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case MexPackage.MATRIX_ELEMENT__ROW:
        return ROW_EDEFAULT == null ? row != null : !ROW_EDEFAULT.equals(row);
      case MexPackage.MATRIX_ELEMENT__COLUMN:
        return COLUMN_EDEFAULT == null ? column != null : !COLUMN_EDEFAULT.equals(column);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (element: ");
    result.append(element);
    result.append(", row: ");
    result.append(row);
    result.append(", column: ");
    result.append(column);
    result.append(')');
    return result.toString();
  }

} //MatrixElementImpl
