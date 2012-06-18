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

import org.eclipse.iee.translator.molex.mex.mex.ClassMember;
import org.eclipse.iee.translator.molex.mex.mex.MathName;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.ClassMemberImpl#getClass_ <em>Class </em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.ClassMemberImpl#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassMemberImpl extends ExpressionImpl implements ClassMember
{
  /**
   * The cached value of the '{@link #getClass_() <em>Class </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClass_()
   * @generated
   * @ordered
   */
  protected MathName class_;

  /**
   * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMember()
   * @generated
   * @ordered
   */
  protected MathName member;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassMemberImpl()
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
    return MexPackage.Literals.CLASS_MEMBER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MathName getClass_()
  {
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClass_(MathName newClass_, NotificationChain msgs)
  {
    MathName oldClass_ = class_;
    class_ = newClass_;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.CLASS_MEMBER__CLASS_, oldClass_, newClass_);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClass_(MathName newClass_)
  {
    if (newClass_ != class_)
    {
      NotificationChain msgs = null;
      if (class_ != null)
        msgs = ((InternalEObject)class_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.CLASS_MEMBER__CLASS_, null, msgs);
      if (newClass_ != null)
        msgs = ((InternalEObject)newClass_).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.CLASS_MEMBER__CLASS_, null, msgs);
      msgs = basicSetClass_(newClass_, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.CLASS_MEMBER__CLASS_, newClass_, newClass_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MathName getMember()
  {
    return member;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMember(MathName newMember, NotificationChain msgs)
  {
    MathName oldMember = member;
    member = newMember;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.CLASS_MEMBER__MEMBER, oldMember, newMember);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMember(MathName newMember)
  {
    if (newMember != member)
    {
      NotificationChain msgs = null;
      if (member != null)
        msgs = ((InternalEObject)member).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.CLASS_MEMBER__MEMBER, null, msgs);
      if (newMember != null)
        msgs = ((InternalEObject)newMember).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.CLASS_MEMBER__MEMBER, null, msgs);
      msgs = basicSetMember(newMember, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.CLASS_MEMBER__MEMBER, newMember, newMember));
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
      case MexPackage.CLASS_MEMBER__CLASS_:
        return basicSetClass_(null, msgs);
      case MexPackage.CLASS_MEMBER__MEMBER:
        return basicSetMember(null, msgs);
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
      case MexPackage.CLASS_MEMBER__CLASS_:
        return getClass_();
      case MexPackage.CLASS_MEMBER__MEMBER:
        return getMember();
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
      case MexPackage.CLASS_MEMBER__CLASS_:
        setClass_((MathName)newValue);
        return;
      case MexPackage.CLASS_MEMBER__MEMBER:
        setMember((MathName)newValue);
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
      case MexPackage.CLASS_MEMBER__CLASS_:
        setClass_((MathName)null);
        return;
      case MexPackage.CLASS_MEMBER__MEMBER:
        setMember((MathName)null);
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
      case MexPackage.CLASS_MEMBER__CLASS_:
        return class_ != null;
      case MexPackage.CLASS_MEMBER__MEMBER:
        return member != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassMemberImpl
