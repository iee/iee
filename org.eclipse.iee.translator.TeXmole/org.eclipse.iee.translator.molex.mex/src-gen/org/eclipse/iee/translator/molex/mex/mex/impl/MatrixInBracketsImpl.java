/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.iee.translator.molex.mex.mex.MatrixExpression;
import org.eclipse.iee.translator.molex.mex.mex.MatrixInBrackets;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix In Brackets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixInBracketsImpl#getInBrackets <em>In Brackets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixInBracketsImpl extends MatrixExpressionImpl implements MatrixInBrackets
{
  /**
   * The cached value of the '{@link #getInBrackets() <em>In Brackets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInBrackets()
   * @generated
   * @ordered
   */
  protected MatrixExpression inBrackets;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatrixInBracketsImpl()
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
    return MexPackage.Literals.MATRIX_IN_BRACKETS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixExpression getInBrackets()
  {
    return inBrackets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInBrackets(MatrixExpression newInBrackets, NotificationChain msgs)
  {
    MatrixExpression oldInBrackets = inBrackets;
    inBrackets = newInBrackets;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS, oldInBrackets, newInBrackets);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInBrackets(MatrixExpression newInBrackets)
  {
    if (newInBrackets != inBrackets)
    {
      NotificationChain msgs = null;
      if (inBrackets != null)
        msgs = ((InternalEObject)inBrackets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS, null, msgs);
      if (newInBrackets != null)
        msgs = ((InternalEObject)newInBrackets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS, null, msgs);
      msgs = basicSetInBrackets(newInBrackets, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS, newInBrackets, newInBrackets));
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
      case MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS:
        return basicSetInBrackets(null, msgs);
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
      case MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS:
        return getInBrackets();
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
      case MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS:
        setInBrackets((MatrixExpression)newValue);
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
      case MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS:
        setInBrackets((MatrixExpression)null);
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
      case MexPackage.MATRIX_IN_BRACKETS__IN_BRACKETS:
        return inBrackets != null;
    }
    return super.eIsSet(featureID);
  }

} //MatrixInBracketsImpl
