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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.FunctionDefinition;
import org.eclipse.iee.translator.jmole.math.math.MathPackage;
import org.eclipse.iee.translator.jmole.math.math.MatrixAssignment;
import org.eclipse.iee.translator.jmole.math.math.MatrixFormula;
import org.eclipse.iee.translator.jmole.math.math.Statement;
import org.eclipse.iee.translator.jmole.math.math.VariableAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl#getVariableAssignment <em>Variable Assignment</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl#getFormula <em>Formula</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl#getMatrixAssignment <em>Matrix Assignment</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.impl.StatementImpl#getMatrixFormula <em>Matrix Formula</em>}</li>
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
   * The cached value of the '{@link #getVariableAssignment() <em>Variable Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableAssignment()
   * @generated
   * @ordered
   */
  protected VariableAssignment variableAssignment;

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
   * The cached value of the '{@link #getMatrixAssignment() <em>Matrix Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatrixAssignment()
   * @generated
   * @ordered
   */
  protected MatrixAssignment matrixAssignment;

  /**
   * The cached value of the '{@link #getMatrixFormula() <em>Matrix Formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatrixFormula()
   * @generated
   * @ordered
   */
  protected MatrixFormula matrixFormula;

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
    return MathPackage.Literals.STATEMENT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__FUNCTION_DEFINITION, oldFunctionDefinition, newFunctionDefinition);
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
        msgs = ((InternalEObject)functionDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__FUNCTION_DEFINITION, null, msgs);
      if (newFunctionDefinition != null)
        msgs = ((InternalEObject)newFunctionDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__FUNCTION_DEFINITION, null, msgs);
      msgs = basicSetFunctionDefinition(newFunctionDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__FUNCTION_DEFINITION, newFunctionDefinition, newFunctionDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableAssignment getVariableAssignment()
  {
    return variableAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariableAssignment(VariableAssignment newVariableAssignment, NotificationChain msgs)
  {
    VariableAssignment oldVariableAssignment = variableAssignment;
    variableAssignment = newVariableAssignment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__VARIABLE_ASSIGNMENT, oldVariableAssignment, newVariableAssignment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableAssignment(VariableAssignment newVariableAssignment)
  {
    if (newVariableAssignment != variableAssignment)
    {
      NotificationChain msgs = null;
      if (variableAssignment != null)
        msgs = ((InternalEObject)variableAssignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__VARIABLE_ASSIGNMENT, null, msgs);
      if (newVariableAssignment != null)
        msgs = ((InternalEObject)newVariableAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__VARIABLE_ASSIGNMENT, null, msgs);
      msgs = basicSetVariableAssignment(newVariableAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__VARIABLE_ASSIGNMENT, newVariableAssignment, newVariableAssignment));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__FORMULA, oldFormula, newFormula);
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
        msgs = ((InternalEObject)formula).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__FORMULA, null, msgs);
      if (newFormula != null)
        msgs = ((InternalEObject)newFormula).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__FORMULA, null, msgs);
      msgs = basicSetFormula(newFormula, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__FORMULA, newFormula, newFormula));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixAssignment getMatrixAssignment()
  {
    return matrixAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMatrixAssignment(MatrixAssignment newMatrixAssignment, NotificationChain msgs)
  {
    MatrixAssignment oldMatrixAssignment = matrixAssignment;
    matrixAssignment = newMatrixAssignment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__MATRIX_ASSIGNMENT, oldMatrixAssignment, newMatrixAssignment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMatrixAssignment(MatrixAssignment newMatrixAssignment)
  {
    if (newMatrixAssignment != matrixAssignment)
    {
      NotificationChain msgs = null;
      if (matrixAssignment != null)
        msgs = ((InternalEObject)matrixAssignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__MATRIX_ASSIGNMENT, null, msgs);
      if (newMatrixAssignment != null)
        msgs = ((InternalEObject)newMatrixAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__MATRIX_ASSIGNMENT, null, msgs);
      msgs = basicSetMatrixAssignment(newMatrixAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__MATRIX_ASSIGNMENT, newMatrixAssignment, newMatrixAssignment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatrixFormula getMatrixFormula()
  {
    return matrixFormula;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMatrixFormula(MatrixFormula newMatrixFormula, NotificationChain msgs)
  {
    MatrixFormula oldMatrixFormula = matrixFormula;
    matrixFormula = newMatrixFormula;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__MATRIX_FORMULA, oldMatrixFormula, newMatrixFormula);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMatrixFormula(MatrixFormula newMatrixFormula)
  {
    if (newMatrixFormula != matrixFormula)
    {
      NotificationChain msgs = null;
      if (matrixFormula != null)
        msgs = ((InternalEObject)matrixFormula).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__MATRIX_FORMULA, null, msgs);
      if (newMatrixFormula != null)
        msgs = ((InternalEObject)newMatrixFormula).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MathPackage.STATEMENT__MATRIX_FORMULA, null, msgs);
      msgs = basicSetMatrixFormula(newMatrixFormula, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MathPackage.STATEMENT__MATRIX_FORMULA, newMatrixFormula, newMatrixFormula));
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
      case MathPackage.STATEMENT__FUNCTION_DEFINITION:
        return basicSetFunctionDefinition(null, msgs);
      case MathPackage.STATEMENT__VARIABLE_ASSIGNMENT:
        return basicSetVariableAssignment(null, msgs);
      case MathPackage.STATEMENT__FORMULA:
        return basicSetFormula(null, msgs);
      case MathPackage.STATEMENT__MATRIX_ASSIGNMENT:
        return basicSetMatrixAssignment(null, msgs);
      case MathPackage.STATEMENT__MATRIX_FORMULA:
        return basicSetMatrixFormula(null, msgs);
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
      case MathPackage.STATEMENT__FUNCTION_DEFINITION:
        return getFunctionDefinition();
      case MathPackage.STATEMENT__VARIABLE_ASSIGNMENT:
        return getVariableAssignment();
      case MathPackage.STATEMENT__FORMULA:
        return getFormula();
      case MathPackage.STATEMENT__MATRIX_ASSIGNMENT:
        return getMatrixAssignment();
      case MathPackage.STATEMENT__MATRIX_FORMULA:
        return getMatrixFormula();
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
      case MathPackage.STATEMENT__FUNCTION_DEFINITION:
        setFunctionDefinition((FunctionDefinition)newValue);
        return;
      case MathPackage.STATEMENT__VARIABLE_ASSIGNMENT:
        setVariableAssignment((VariableAssignment)newValue);
        return;
      case MathPackage.STATEMENT__FORMULA:
        setFormula((Formula)newValue);
        return;
      case MathPackage.STATEMENT__MATRIX_ASSIGNMENT:
        setMatrixAssignment((MatrixAssignment)newValue);
        return;
      case MathPackage.STATEMENT__MATRIX_FORMULA:
        setMatrixFormula((MatrixFormula)newValue);
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
      case MathPackage.STATEMENT__FUNCTION_DEFINITION:
        setFunctionDefinition((FunctionDefinition)null);
        return;
      case MathPackage.STATEMENT__VARIABLE_ASSIGNMENT:
        setVariableAssignment((VariableAssignment)null);
        return;
      case MathPackage.STATEMENT__FORMULA:
        setFormula((Formula)null);
        return;
      case MathPackage.STATEMENT__MATRIX_ASSIGNMENT:
        setMatrixAssignment((MatrixAssignment)null);
        return;
      case MathPackage.STATEMENT__MATRIX_FORMULA:
        setMatrixFormula((MatrixFormula)null);
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
      case MathPackage.STATEMENT__FUNCTION_DEFINITION:
        return functionDefinition != null;
      case MathPackage.STATEMENT__VARIABLE_ASSIGNMENT:
        return variableAssignment != null;
      case MathPackage.STATEMENT__FORMULA:
        return formula != null;
      case MathPackage.STATEMENT__MATRIX_ASSIGNMENT:
        return matrixAssignment != null;
      case MathPackage.STATEMENT__MATRIX_FORMULA:
        return matrixFormula != null;
    }
    return super.eIsSet(featureID);
  }

} //StatementImpl
