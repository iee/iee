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

import org.eclipse.iee.translator.molex.mex.mex.Assignment;
import org.eclipse.iee.translator.molex.mex.mex.Formula;
import org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition;
import org.eclipse.iee.translator.molex.mex.mex.MatrixDefinition;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;
import org.eclipse.iee.translator.molex.mex.mex.Statement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl#getMatrixDefinition <em>Matrix Definition</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.molex.mex.mex.impl.StatementImpl#getFormula <em>Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatementImpl extends MinimalEObjectImpl.Container implements Statement
{
  /**
   * The cached value of the '{@link #getFunctionDefinition() <em>Function Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionDefinition()
   * @generated
   * @ordered
   */
  protected FunctionDefinition functionDefinition;

  /**
   * The cached value of the '{@link #getMatrixDefinition() <em>Matrix Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatrixDefinition()
   * @generated
   * @ordered
   */
  protected MatrixDefinition matrixDefinition;

  /**
   * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignment()
   * @generated
   * @ordered
   */
  protected Assignment assignment;

  /**
   * The cached value of the '{@link #getFormula() <em>Formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormula()
   * @generated
   * @ordered
   */
  protected Formula formula;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatementImpl()
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
    return MexPackage.Literals.STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition getFunctionDefinition()
  {
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunctionDefinition(FunctionDefinition newFunctionDefinition, NotificationChain msgs)
  {
    FunctionDefinition oldFunctionDefinition = functionDefinition;
    functionDefinition = newFunctionDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__FUNCTION_DEFINITION, oldFunctionDefinition, newFunctionDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionDefinition(FunctionDefinition newFunctionDefinition)
  {
    if (newFunctionDefinition != functionDefinition)
    {
      NotificationChain msgs = null;
      if (functionDefinition != null)
        msgs = ((InternalEObject)functionDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__FUNCTION_DEFINITION, null, msgs);
      if (newFunctionDefinition != null)
        msgs = ((InternalEObject)newFunctionDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__FUNCTION_DEFINITION, null, msgs);
      msgs = basicSetFunctionDefinition(newFunctionDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__FUNCTION_DEFINITION, newFunctionDefinition, newFunctionDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixDefinition getMatrixDefinition()
  {
    return matrixDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMatrixDefinition(MatrixDefinition newMatrixDefinition, NotificationChain msgs)
  {
    MatrixDefinition oldMatrixDefinition = matrixDefinition;
    matrixDefinition = newMatrixDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__MATRIX_DEFINITION, oldMatrixDefinition, newMatrixDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMatrixDefinition(MatrixDefinition newMatrixDefinition)
  {
    if (newMatrixDefinition != matrixDefinition)
    {
      NotificationChain msgs = null;
      if (matrixDefinition != null)
        msgs = ((InternalEObject)matrixDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__MATRIX_DEFINITION, null, msgs);
      if (newMatrixDefinition != null)
        msgs = ((InternalEObject)newMatrixDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__MATRIX_DEFINITION, null, msgs);
      msgs = basicSetMatrixDefinition(newMatrixDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__MATRIX_DEFINITION, newMatrixDefinition, newMatrixDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment getAssignment()
  {
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignment(Assignment newAssignment, NotificationChain msgs)
  {
    Assignment oldAssignment = assignment;
    assignment = newAssignment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__ASSIGNMENT, oldAssignment, newAssignment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignment(Assignment newAssignment)
  {
    if (newAssignment != assignment)
    {
      NotificationChain msgs = null;
      if (assignment != null)
        msgs = ((InternalEObject)assignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__ASSIGNMENT, null, msgs);
      if (newAssignment != null)
        msgs = ((InternalEObject)newAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__ASSIGNMENT, null, msgs);
      msgs = basicSetAssignment(newAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__ASSIGNMENT, newAssignment, newAssignment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Formula getFormula()
  {
    return formula;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormula(Formula newFormula, NotificationChain msgs)
  {
    Formula oldFormula = formula;
    formula = newFormula;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__FORMULA, oldFormula, newFormula);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormula(Formula newFormula)
  {
    if (newFormula != formula)
    {
      NotificationChain msgs = null;
      if (formula != null)
        msgs = ((InternalEObject)formula).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__FORMULA, null, msgs);
      if (newFormula != null)
        msgs = ((InternalEObject)newFormula).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MexPackage.STATEMENT__FORMULA, null, msgs);
      msgs = basicSetFormula(newFormula, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MexPackage.STATEMENT__FORMULA, newFormula, newFormula));
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
      case MexPackage.STATEMENT__FUNCTION_DEFINITION:
        return basicSetFunctionDefinition(null, msgs);
      case MexPackage.STATEMENT__MATRIX_DEFINITION:
        return basicSetMatrixDefinition(null, msgs);
      case MexPackage.STATEMENT__ASSIGNMENT:
        return basicSetAssignment(null, msgs);
      case MexPackage.STATEMENT__FORMULA:
        return basicSetFormula(null, msgs);
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
      case MexPackage.STATEMENT__FUNCTION_DEFINITION:
        return getFunctionDefinition();
      case MexPackage.STATEMENT__MATRIX_DEFINITION:
        return getMatrixDefinition();
      case MexPackage.STATEMENT__ASSIGNMENT:
        return getAssignment();
      case MexPackage.STATEMENT__FORMULA:
        return getFormula();
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
      case MexPackage.STATEMENT__FUNCTION_DEFINITION:
        setFunctionDefinition((FunctionDefinition)newValue);
        return;
      case MexPackage.STATEMENT__MATRIX_DEFINITION:
        setMatrixDefinition((MatrixDefinition)newValue);
        return;
      case MexPackage.STATEMENT__ASSIGNMENT:
        setAssignment((Assignment)newValue);
        return;
      case MexPackage.STATEMENT__FORMULA:
        setFormula((Formula)newValue);
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
      case MexPackage.STATEMENT__FUNCTION_DEFINITION:
        setFunctionDefinition((FunctionDefinition)null);
        return;
      case MexPackage.STATEMENT__MATRIX_DEFINITION:
        setMatrixDefinition((MatrixDefinition)null);
        return;
      case MexPackage.STATEMENT__ASSIGNMENT:
        setAssignment((Assignment)null);
        return;
      case MexPackage.STATEMENT__FORMULA:
        setFormula((Formula)null);
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
      case MexPackage.STATEMENT__FUNCTION_DEFINITION:
        return functionDefinition != null;
      case MexPackage.STATEMENT__MATRIX_DEFINITION:
        return matrixDefinition != null;
      case MexPackage.STATEMENT__ASSIGNMENT:
        return assignment != null;
      case MexPackage.STATEMENT__FORMULA:
        return formula != null;
    }
    return super.eIsSet(featureID);
  }

} //StatementImpl
