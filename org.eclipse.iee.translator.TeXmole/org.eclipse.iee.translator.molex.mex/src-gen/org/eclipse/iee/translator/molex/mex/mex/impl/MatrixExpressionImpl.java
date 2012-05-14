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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.iee.translator.molex.mex.mex.MatrixExpression;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixExpressionImpl#getAddition <em>Addition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixExpressionImpl extends MinimalEObjectImpl.Container implements MatrixExpression
{
  /**
   * The cached value of the '{@link #getAddition() <em>Addition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAddition()
   * @generated
   * @ordered
   */
  protected MatrixExpression addition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatrixExpressionImpl()
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
    return MexPackage.Literals.MATRIX_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixExpression getAddition()
  {
    return addition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAddition(MatrixExpression newAddition, NotificationChain msgs)
  {
    MatrixExpression oldAddition = addition;
    addition = newAddition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_EXPRESSION__ADDITION, oldAddition, newAddition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAddition(MatrixExpression newAddition)
  {
    if (newAddition != addition)
    {
      NotificationChain msgs = null;
      if (addition != null)
        msgs = ((InternalEObject)addition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_EXPRESSION__ADDITION, null, msgs);
      if (newAddition != null)
        msgs = ((InternalEObject)newAddition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_EXPRESSION__ADDITION, null, msgs);
      msgs = basicSetAddition(newAddition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_EXPRESSION__ADDITION, newAddition, newAddition));
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
      case MexPackage.MATRIX_EXPRESSION__ADDITION:
        return basicSetAddition(null, msgs);
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
      case MexPackage.MATRIX_EXPRESSION__ADDITION:
        return getAddition();
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
      case MexPackage.MATRIX_EXPRESSION__ADDITION:
        setAddition((MatrixExpression)newValue);
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
      case MexPackage.MATRIX_EXPRESSION__ADDITION:
        setAddition((MatrixExpression)null);
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
      case MexPackage.MATRIX_EXPRESSION__ADDITION:
        return addition != null;
    }
    return super.eIsSet(featureID);
  }

} //MatrixExpressionImpl
