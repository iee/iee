/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.jmole.math.math;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getVariableAssignment <em>Variable Assignment</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFormula <em>Formula</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixAssignment <em>Matrix Assignment</em>}</li>
 *   <li>{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixFormula <em>Matrix Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement()
 * @model
 * @generated
 */
public interface Statement extends EObject
{
  /**
   * Returns the value of the '<em><b>Function Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Definition</em>' containment reference.
   * @see #setFunctionDefinition(FunctionDefinition)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_FunctionDefinition()
   * @model containment="true"
   * @generated
   */
  FunctionDefinition getFunctionDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFunctionDefinition <em>Function Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Definition</em>' containment reference.
   * @see #getFunctionDefinition()
   * @generated
   */
  void setFunctionDefinition(FunctionDefinition value);

  /**
   * Returns the value of the '<em><b>Variable Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Assignment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Assignment</em>' containment reference.
   * @see #setVariableAssignment(VariableAssignment)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_VariableAssignment()
   * @model containment="true"
   * @generated
   */
  VariableAssignment getVariableAssignment();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getVariableAssignment <em>Variable Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Assignment</em>' containment reference.
   * @see #getVariableAssignment()
   * @generated
   */
  void setVariableAssignment(VariableAssignment value);

  /**
   * Returns the value of the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formula</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formula</em>' containment reference.
   * @see #setFormula(Formula)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_Formula()
   * @model containment="true"
   * @generated
   */
  Formula getFormula();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getFormula <em>Formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formula</em>' containment reference.
   * @see #getFormula()
   * @generated
   */
  void setFormula(Formula value);

  /**
   * Returns the value of the '<em><b>Matrix Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Matrix Assignment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Matrix Assignment</em>' containment reference.
   * @see #setMatrixAssignment(MatrixAssignment)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_MatrixAssignment()
   * @model containment="true"
   * @generated
   */
  MatrixAssignment getMatrixAssignment();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixAssignment <em>Matrix Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Matrix Assignment</em>' containment reference.
   * @see #getMatrixAssignment()
   * @generated
   */
  void setMatrixAssignment(MatrixAssignment value);

  /**
   * Returns the value of the '<em><b>Matrix Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Matrix Formula</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Matrix Formula</em>' containment reference.
   * @see #setMatrixFormula(MatrixFormula)
   * @see org.eclipse.iee.translator.jmole.math.math.MathPackage#getStatement_MatrixFormula()
   * @model containment="true"
   * @generated
   */
  MatrixFormula getMatrixFormula();

  /**
   * Sets the value of the '{@link org.eclipse.iee.translator.jmole.math.math.Statement#getMatrixFormula <em>Matrix Formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Matrix Formula</em>' containment reference.
   * @see #getMatrixFormula()
   * @generated
   */
  void setMatrixFormula(MatrixFormula value);

} // Statement
