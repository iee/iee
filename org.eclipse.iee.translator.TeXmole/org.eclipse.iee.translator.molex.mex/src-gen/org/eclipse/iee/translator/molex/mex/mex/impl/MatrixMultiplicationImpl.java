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

import org.eclipse.iee.translator.molex.mex.mex.Formula;
import org.eclipse.iee.translator.molex.mex.mex.MatrixExpression;
import org.eclipse.iee.translator.molex.mex.mex.MatrixMultiplication;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix Multiplication</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixMultiplicationImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixMultiplicationImpl#getRightMatrix <em>Right Matrix</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixMultiplicationImpl#getRightScalar <em>Right Scalar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixMultiplicationImpl extends MatrixExpressionImpl implements MatrixMultiplication
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
   * The cached value of the '{@link #getRightMatrix() <em>Right Matrix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightMatrix()
   * @generated
   * @ordered
   */
  protected MatrixExpression rightMatrix;

  /**
   * The cached value of the '{@link #getRightScalar() <em>Right Scalar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightScalar()
   * @generated
   * @ordered
   */
  protected Formula rightScalar;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatrixMultiplicationImpl()
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
    return MexPackage.Literals.MATRIX_MULTIPLICATION;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_MULTIPLICATION__LEFT, oldLeft, newLeft);
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
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_MULTIPLICATION__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_MULTIPLICATION__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_MULTIPLICATION__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixExpression getRightMatrix()
  {
    return rightMatrix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightMatrix(MatrixExpression newRightMatrix, NotificationChain msgs)
  {
    MatrixExpression oldRightMatrix = rightMatrix;
    rightMatrix = newRightMatrix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX, oldRightMatrix, newRightMatrix);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightMatrix(MatrixExpression newRightMatrix)
  {
    if (newRightMatrix != rightMatrix)
    {
      NotificationChain msgs = null;
      if (rightMatrix != null)
        msgs = ((InternalEObject)rightMatrix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX, null, msgs);
      if (newRightMatrix != null)
        msgs = ((InternalEObject)newRightMatrix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX, null, msgs);
      msgs = basicSetRightMatrix(newRightMatrix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX, newRightMatrix, newRightMatrix));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Formula getRightScalar()
  {
    return rightScalar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightScalar(Formula newRightScalar, NotificationChain msgs)
  {
    Formula oldRightScalar = rightScalar;
    rightScalar = newRightScalar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR, oldRightScalar, newRightScalar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightScalar(Formula newRightScalar)
  {
    if (newRightScalar != rightScalar)
    {
      NotificationChain msgs = null;
      if (rightScalar != null)
        msgs = ((InternalEObject)rightScalar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR, null, msgs);
      if (newRightScalar != null)
        msgs = ((InternalEObject)newRightScalar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR, null, msgs);
      msgs = basicSetRightScalar(newRightScalar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR, newRightScalar, newRightScalar));
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
      case MexPackage.MATRIX_MULTIPLICATION__LEFT:
        return basicSetLeft(null, msgs);
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX:
        return basicSetRightMatrix(null, msgs);
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR:
        return basicSetRightScalar(null, msgs);
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
      case MexPackage.MATRIX_MULTIPLICATION__LEFT:
        return getLeft();
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX:
        return getRightMatrix();
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR:
        return getRightScalar();
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
      case MexPackage.MATRIX_MULTIPLICATION__LEFT:
        setLeft((MatrixExpression)newValue);
        return;
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX:
        setRightMatrix((MatrixExpression)newValue);
        return;
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR:
        setRightScalar((Formula)newValue);
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
      case MexPackage.MATRIX_MULTIPLICATION__LEFT:
        setLeft((MatrixExpression)null);
        return;
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX:
        setRightMatrix((MatrixExpression)null);
        return;
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR:
        setRightScalar((Formula)null);
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
      case MexPackage.MATRIX_MULTIPLICATION__LEFT:
        return left != null;
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_MATRIX:
        return rightMatrix != null;
      case MexPackage.MATRIX_MULTIPLICATION__RIGHT_SCALAR:
        return rightScalar != null;
    }
    return super.eIsSet(featureID);
  }

} //MatrixMultiplicationImpl
