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

import org.eclipse.iee.translator.jmole.math.math.MathPackage;
import org.eclipse.iee.translator.jmole.math.math.MatrixAddition;
import org.eclipse.iee.translator.jmole.math.math.MatrixExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix Addition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixAdditionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.MatrixAdditionImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixAdditionImpl extends MatrixExpressionImpl implements MatrixAddition
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected MatrixExpression left;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected MatrixExpression right;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatrixAdditionImpl()
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
    return MathPackage.Literals.MATRIX_ADDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixExpression getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(MatrixExpression newLeft, NotificationChain msgs)
  {
    MatrixExpression oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ADDITION__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeft(MatrixExpression newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ADDITION__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ADDITION__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ADDITION__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixExpression getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRight(MatrixExpression newRight, NotificationChain msgs)
  {
    MatrixExpression oldRight = right;
    right = newRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ADDITION__RIGHT, oldRight, newRight);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRight(MatrixExpression newRight)
  {
    if (newRight != right)
    {
      NotificationChain msgs = null;
      if (right != null)
        msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ADDITION__RIGHT, null, msgs);
      if (newRight != null)
        msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.MATRIX_ADDITION__RIGHT, null, msgs);
      msgs = basicSetRight(newRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.MATRIX_ADDITION__RIGHT, newRight, newRight));
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
      case MathPackage.MATRIX_ADDITION__LEFT:
        return basicSetLeft(null, msgs);
      case MathPackage.MATRIX_ADDITION__RIGHT:
        return basicSetRight(null, msgs);
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
      case MathPackage.MATRIX_ADDITION__LEFT:
        return getLeft();
      case MathPackage.MATRIX_ADDITION__RIGHT:
        return getRight();
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
      case MathPackage.MATRIX_ADDITION__LEFT:
        setLeft((MatrixExpression)newValue);
        return;
      case MathPackage.MATRIX_ADDITION__RIGHT:
        setRight((MatrixExpression)newValue);
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
      case MathPackage.MATRIX_ADDITION__LEFT:
        setLeft((MatrixExpression)null);
        return;
      case MathPackage.MATRIX_ADDITION__RIGHT:
        setRight((MatrixExpression)null);
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
      case MathPackage.MATRIX_ADDITION__LEFT:
        return left != null;
      case MathPackage.MATRIX_ADDITION__RIGHT:
        return right != null;
    }
    return super.eIsSet(featureID);
  }

} //MatrixAdditionImpl
