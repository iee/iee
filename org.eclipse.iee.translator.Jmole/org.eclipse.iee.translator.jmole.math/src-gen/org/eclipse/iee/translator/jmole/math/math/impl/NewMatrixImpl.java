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
import org.eclipse.iee.translator.jmole.math.math.Matrix;
import org.eclipse.iee.translator.jmole.math.math.NewMatrix;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Matrix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.NewMatrixImpl#getMatrix <em>Matrix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewMatrixImpl extends MatrixExpressionImpl implements NewMatrix
{
  /**
   * The cached value of the '{@link #getMatrix() <em>Matrix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatrix()
   * @generated
   * @ordered
   */
  protected Matrix matrix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NewMatrixImpl()
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
    return MathPackage.Literals.NEW_MATRIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Matrix getMatrix()
  {
    return matrix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMatrix(Matrix newMatrix, NotificationChain msgs)
  {
    Matrix oldMatrix = matrix;
    matrix = newMatrix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.NEW_MATRIX__MATRIX, oldMatrix, newMatrix);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMatrix(Matrix newMatrix)
  {
    if (newMatrix != matrix)
    {
      NotificationChain msgs = null;
      if (matrix != null)
        msgs = ((InternalEObject)matrix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.NEW_MATRIX__MATRIX, null, msgs);
      if (newMatrix != null)
        msgs = ((InternalEObject)newMatrix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.NEW_MATRIX__MATRIX, null, msgs);
      msgs = basicSetMatrix(newMatrix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.NEW_MATRIX__MATRIX, newMatrix, newMatrix));
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
      case MathPackage.NEW_MATRIX__MATRIX:
        return basicSetMatrix(null, msgs);
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
      case MathPackage.NEW_MATRIX__MATRIX:
        return getMatrix();
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
      case MathPackage.NEW_MATRIX__MATRIX:
        setMatrix((Matrix)newValue);
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
      case MathPackage.NEW_MATRIX__MATRIX:
        setMatrix((Matrix)null);
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
      case MathPackage.NEW_MATRIX__MATRIX:
        return matrix != null;
    }
    return super.eIsSet(featureID);
  }

} //NewMatrixImpl
