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

import org.eclipse.iee.translator.molex.mex.mex.Expression;
import org.eclipse.iee.translator.molex.mex.mex.InBrackets;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Brackets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.InBracketsImpl#getInBrackets <em>In Brackets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InBracketsImpl extends ExpressionImpl implements InBrackets
{
  /**
   * The cached value of the '{@link #getInBrackets() <em>In Brackets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInBrackets()
   * @generated
   * @ordered
   */
  protected Expression inBrackets;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InBracketsImpl()
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
    return MexPackage.Literals.IN_BRACKETS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getInBrackets()
  {
    return inBrackets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInBrackets(Expression newInBrackets, NotificationChain msgs)
  {
    Expression oldInBrackets = inBrackets;
    inBrackets = newInBrackets;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.IN_BRACKETS__IN_BRACKETS, oldInBrackets, newInBrackets);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInBrackets(Expression newInBrackets)
  {
    if (newInBrackets != inBrackets)
    {
      NotificationChain msgs = null;
      if (inBrackets != null)
        msgs = ((InternalEObject)inBrackets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.IN_BRACKETS__IN_BRACKETS, null, msgs);
      if (newInBrackets != null)
        msgs = ((InternalEObject)newInBrackets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.IN_BRACKETS__IN_BRACKETS, null, msgs);
      msgs = basicSetInBrackets(newInBrackets, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.IN_BRACKETS__IN_BRACKETS, newInBrackets, newInBrackets));
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
      case MexPackage.IN_BRACKETS__IN_BRACKETS:
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
      case MexPackage.IN_BRACKETS__IN_BRACKETS:
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
      case MexPackage.IN_BRACKETS__IN_BRACKETS:
        setInBrackets((Expression)newValue);
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
      case MexPackage.IN_BRACKETS__IN_BRACKETS:
        setInBrackets((Expression)null);
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
      case MexPackage.IN_BRACKETS__IN_BRACKETS:
        return inBrackets != null;
    }
    return super.eIsSet(featureID);
  }

} //InBracketsImpl
