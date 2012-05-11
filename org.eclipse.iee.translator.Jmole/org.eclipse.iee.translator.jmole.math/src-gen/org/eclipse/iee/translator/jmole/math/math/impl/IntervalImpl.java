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

import org.eclipse.iee.translator.jmole.math.math.Expression;
import org.eclipse.iee.translator.jmole.math.math.Interval;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.IntervalImpl#getOpeningBracket <em>Opening Bracket</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.IntervalImpl#getCeil <em>Ceil</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.IntervalImpl#getFloor <em>Floor</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.IntervalImpl#getClosingBracket <em>Closing Bracket</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntervalImpl extends ExpressionImpl implements Interval
{
  /**
   * The default value of the '{@link #getOpeningBracket() <em>Opening Bracket</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpeningBracket()
   * @generated
   * @ordered
   */
  protected static final String OPENING_BRACKET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOpeningBracket() <em>Opening Bracket</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpeningBracket()
   * @generated
   * @ordered
   */
  protected String openingBracket = OPENING_BRACKET_EDEFAULT;

  /**
   * The cached value of the '{@link #getCeil() <em>Ceil</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCeil()
   * @generated
   * @ordered
   */
  protected Expression ceil;

  /**
   * The cached value of the '{@link #getFloor() <em>Floor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloor()
   * @generated
   * @ordered
   */
  protected Expression floor;

  /**
   * The default value of the '{@link #getClosingBracket() <em>Closing Bracket</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClosingBracket()
   * @generated
   * @ordered
   */
  protected static final String CLOSING_BRACKET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClosingBracket() <em>Closing Bracket</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClosingBracket()
   * @generated
   * @ordered
   */
  protected String closingBracket = CLOSING_BRACKET_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntervalImpl()
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
    return MathPackage.Literals.INTERVAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOpeningBracket()
  {
    return openingBracket;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpeningBracket(String newOpeningBracket)
  {
    String oldOpeningBracket = openingBracket;
    openingBracket = newOpeningBracket;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.INTERVAL__OPENING_BRACKET, oldOpeningBracket, openingBracket));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCeil()
  {
    return ceil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCeil(Expression newCeil, NotificationChain msgs)
  {
    Expression oldCeil = ceil;
    ceil = newCeil;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.INTERVAL__CEIL, oldCeil, newCeil);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCeil(Expression newCeil)
  {
    if (newCeil != ceil)
    {
      NotificationChain msgs = null;
      if (ceil != null)
        msgs = ((InternalEObject)ceil).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.INTERVAL__CEIL, null, msgs);
      if (newCeil != null)
        msgs = ((InternalEObject)newCeil).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.INTERVAL__CEIL, null, msgs);
      msgs = basicSetCeil(newCeil, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.INTERVAL__CEIL, newCeil, newCeil));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getFloor()
  {
    return floor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFloor(Expression newFloor, NotificationChain msgs)
  {
    Expression oldFloor = floor;
    floor = newFloor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.INTERVAL__FLOOR, oldFloor, newFloor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFloor(Expression newFloor)
  {
    if (newFloor != floor)
    {
      NotificationChain msgs = null;
      if (floor != null)
        msgs = ((InternalEObject)floor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.INTERVAL__FLOOR, null, msgs);
      if (newFloor != null)
        msgs = ((InternalEObject)newFloor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.INTERVAL__FLOOR, null, msgs);
      msgs = basicSetFloor(newFloor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.INTERVAL__FLOOR, newFloor, newFloor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClosingBracket()
  {
    return closingBracket;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClosingBracket(String newClosingBracket)
  {
    String oldClosingBracket = closingBracket;
    closingBracket = newClosingBracket;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.INTERVAL__CLOSING_BRACKET, oldClosingBracket, closingBracket));
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
      case MathPackage.INTERVAL__CEIL:
        return basicSetCeil(null, msgs);
      case MathPackage.INTERVAL__FLOOR:
        return basicSetFloor(null, msgs);
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
      case MathPackage.INTERVAL__OPENING_BRACKET:
        return getOpeningBracket();
      case MathPackage.INTERVAL__CEIL:
        return getCeil();
      case MathPackage.INTERVAL__FLOOR:
        return getFloor();
      case MathPackage.INTERVAL__CLOSING_BRACKET:
        return getClosingBracket();
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
      case MathPackage.INTERVAL__OPENING_BRACKET:
        setOpeningBracket((String)newValue);
        return;
      case MathPackage.INTERVAL__CEIL:
        setCeil((Expression)newValue);
        return;
      case MathPackage.INTERVAL__FLOOR:
        setFloor((Expression)newValue);
        return;
      case MathPackage.INTERVAL__CLOSING_BRACKET:
        setClosingBracket((String)newValue);
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
      case MathPackage.INTERVAL__OPENING_BRACKET:
        setOpeningBracket(OPENING_BRACKET_EDEFAULT);
        return;
      case MathPackage.INTERVAL__CEIL:
        setCeil((Expression)null);
        return;
      case MathPackage.INTERVAL__FLOOR:
        setFloor((Expression)null);
        return;
      case MathPackage.INTERVAL__CLOSING_BRACKET:
        setClosingBracket(CLOSING_BRACKET_EDEFAULT);
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
      case MathPackage.INTERVAL__OPENING_BRACKET:
        return OPENING_BRACKET_EDEFAULT == null ? openingBracket != null : !OPENING_BRACKET_EDEFAULT.equals(openingBracket);
      case MathPackage.INTERVAL__CEIL:
        return ceil != null;
      case MathPackage.INTERVAL__FLOOR:
        return floor != null;
      case MathPackage.INTERVAL__CLOSING_BRACKET:
        return CLOSING_BRACKET_EDEFAULT == null ? closingBracket != null : !CLOSING_BRACKET_EDEFAULT.equals(closingBracket);
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
    result.append(" (openingBracket: ");
    result.append(openingBracket);
    result.append(", closingBracket: ");
    result.append(closingBracket);
    result.append(')');
    return result.toString();
  }

} //IntervalImpl
