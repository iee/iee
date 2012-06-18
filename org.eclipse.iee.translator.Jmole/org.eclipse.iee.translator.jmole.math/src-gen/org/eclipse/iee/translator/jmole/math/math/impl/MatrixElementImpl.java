/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.MathName;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;
import org.eclipse.iee.translator.jmole.math.math.MatrixElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixElementImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixElementImpl#getRow <em>Row</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixElementImpl#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixElementImpl extends ExpressionImpl implements MatrixElement
{
  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected MathName element;

  /**
   * The cached value of the '{@link #getRow() <em>Row</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRow()
   * @generated
   * @ordered
   */
  protected Formula row;

  /**
   * The cached value of the '{@link #getColumn() <em>Column</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected Formula column;

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
    return MathPackage.Literals.MATRIX_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MathName getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(MathName newElement, NotificationChain msgs)
  {
    MathName oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ELEMENT__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(MathName newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ELEMENT__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ELEMENT__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ELEMENT__ELEMENT, newElement, newElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Formula getRow()
  {
    return row;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRow(Formula newRow, NotificationChain msgs)
  {
    Formula oldRow = row;
    row = newRow;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ELEMENT__ROW, oldRow, newRow);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRow(Formula newRow)
  {
    if (newRow != row)
    {
      NotificationChain msgs = null;
      if (row != null)
        msgs = ((InternalEObject)row).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ELEMENT__ROW, null, msgs);
      if (newRow != null)
        msgs = ((InternalEObject)newRow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ELEMENT__ROW, null, msgs);
      msgs = basicSetRow(newRow, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ELEMENT__ROW, newRow, newRow));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Formula getColumn()
  {
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetColumn(Formula newColumn, NotificationChain msgs)
  {
    Formula oldColumn = column;
    column = newColumn;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ELEMENT__COLUMN, oldColumn, newColumn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColumn(Formula newColumn)
  {
    if (newColumn != column)
    {
      NotificationChain msgs = null;
      if (column != null)
        msgs = ((InternalEObject)column).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ELEMENT__COLUMN, null, msgs);
      if (newColumn != null)
        msgs = ((InternalEObject)newColumn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ELEMENT__COLUMN, null, msgs);
      msgs = basicSetColumn(newColumn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ELEMENT__COLUMN, newColumn, newColumn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MathPackage.MATRIX_ELEMENT__ELEMENT:
        return basicSetElement(null, msgs);
      case MathPackage.MATRIX_ELEMENT__ROW:
        return basicSetRow(null, msgs);
      case MathPackage.MATRIX_ELEMENT__COLUMN:
        return basicSetColumn(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case MathPackage.MATRIX_ELEMENT__ELEMENT:
        return getElement();
      case MathPackage.MATRIX_ELEMENT__ROW:
        return getRow();
      case MathPackage.MATRIX_ELEMENT__COLUMN:
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
      case MathPackage.MATRIX_ELEMENT__ELEMENT:
        setElement((MathName)newValue);
        return;
      case MathPackage.MATRIX_ELEMENT__ROW:
        setRow((Formula)newValue);
        return;
      case MathPackage.MATRIX_ELEMENT__COLUMN:
        setColumn((Formula)newValue);
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
      case MathPackage.MATRIX_ELEMENT__ELEMENT:
        setElement((MathName)null);
        return;
      case MathPackage.MATRIX_ELEMENT__ROW:
        setRow((Formula)null);
        return;
      case MathPackage.MATRIX_ELEMENT__COLUMN:
        setColumn((Formula)null);
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
      case MathPackage.MATRIX_ELEMENT__ELEMENT:
        return element != null;
      case MathPackage.MATRIX_ELEMENT__ROW:
        return row != null;
      case MathPackage.MATRIX_ELEMENT__COLUMN:
        return column != null;
    }
    return super.eIsSet(featureID);
  }

} //MatrixElementImpl
