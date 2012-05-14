/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.iee.translator.molex.mex.mex.Matrix;
import org.eclipse.iee.translator.molex.mex.mex.MatrixRow;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.MatrixImpl#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixImpl extends MinimalEObjectImpl.Container implements Matrix
{
  /**
   * The cached value of the '{@link #getRows() <em>Rows</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRows()
   * @generated
   * @ordered
   */
  protected EList<MatrixRow> rows;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatrixImpl()
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
    return MexPackage.Literals.MATRIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MatrixRow> getRows()
  {
    if (rows == null)
    {
      rows = new EObjectContainmentEList<MatrixRow>(MatrixRow.class, this, MexPackage.MATRIX__ROWS);
    }
    return rows;
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
      case MexPackage.MATRIX__ROWS:
        return ((InternalEList<?>)getRows()).basicRemove(otherEnd, msgs);
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
      case MexPackage.MATRIX__ROWS:
        return getRows();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MexPackage.MATRIX__ROWS:
        getRows().clear();
        getRows().addAll((Collection<? extends MatrixRow>)newValue);
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
      case MexPackage.MATRIX__ROWS:
        getRows().clear();
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
      case MexPackage.MATRIX__ROWS:
        return rows != null && !rows.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MatrixImpl
