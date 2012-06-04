/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.iee.translator.jmole.math.math.MathName;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.MathNameImpl#getMathName <em>Math Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MathNameImpl extends MinimalEObjectImpl.Container implements MathName
{
  /**
   * The default value of the '{@link #getMathName() <em>Math Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMathName()
   * @generated
   * @ordered
   */
  protected static final String MATH_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMathName() <em>Math Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMathName()
   * @generated
   * @ordered
   */
  protected String mathName = MATH_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MathNameImpl()
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
    return MathPackage.Literals.MATH_NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMathName()
  {
    return mathName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMathName(String newMathName)
  {
    String oldMathName = mathName;
    mathName = newMathName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.MATH_NAME__MATH_NAME, oldMathName, mathName));
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
      case MathPackage.MATH_NAME__MATH_NAME:
        return getMathName();
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
      case MathPackage.MATH_NAME__MATH_NAME:
        setMathName((String)newValue);
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
      case MathPackage.MATH_NAME__MATH_NAME:
        setMathName(MATH_NAME_EDEFAULT);
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
      case MathPackage.MATH_NAME__MATH_NAME:
        return MATH_NAME_EDEFAULT == null ? mathName != null : !MATH_NAME_EDEFAULT.equals(mathName);
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
    result.append(" (mathName: ");
    result.append(mathName);
    result.append(')');
    return result.toString();
  }

} //MathNameImpl
