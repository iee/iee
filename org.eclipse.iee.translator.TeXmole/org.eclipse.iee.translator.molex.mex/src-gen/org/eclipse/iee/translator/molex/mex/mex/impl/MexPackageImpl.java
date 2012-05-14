/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.iee.translator.molex.mex.mex.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.iee.translator.molex.mex.mex.Addition;
import org.eclipse.iee.translator.molex.mex.mex.Division;
import org.eclipse.iee.translator.molex.mex.mex.Exponent;
import org.eclipse.iee.translator.molex.mex.mex.Expression;
import org.eclipse.iee.translator.molex.mex.mex.Factorial;
import org.eclipse.iee.translator.molex.mex.mex.Formula;
import org.eclipse.iee.translator.molex.mex.mex.Function;
import org.eclipse.iee.translator.molex.mex.mex.FunctionDefinition;
import org.eclipse.iee.translator.molex.mex.mex.InBrackets;
import org.eclipse.iee.translator.molex.mex.mex.Invert;
import org.eclipse.iee.translator.molex.mex.mex.Matrix;
import org.eclipse.iee.translator.molex.mex.mex.MatrixAddition;
import org.eclipse.iee.translator.molex.mex.mex.MatrixAssignment;
import org.eclipse.iee.translator.molex.mex.mex.MatrixElement;
import org.eclipse.iee.translator.molex.mex.mex.MatrixExpression;
import org.eclipse.iee.translator.molex.mex.mex.MatrixFormula;
import org.eclipse.iee.translator.molex.mex.mex.MatrixInBrackets;
import org.eclipse.iee.translator.molex.mex.mex.MatrixMultiplication;
import org.eclipse.iee.translator.molex.mex.mex.MatrixRow;
import org.eclipse.iee.translator.molex.mex.mex.MatrixSubtraction;
import org.eclipse.iee.translator.molex.mex.mex.MatrixVariable;
import org.eclipse.iee.translator.molex.mex.mex.MexFactory;
import org.eclipse.iee.translator.molex.mex.mex.MexPackage;
import org.eclipse.iee.translator.molex.mex.mex.Modulo;
import org.eclipse.iee.translator.molex.mex.mex.Multiplication;
import org.eclipse.iee.translator.molex.mex.mex.NewMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Statement;
import org.eclipse.iee.translator.molex.mex.mex.Subtraction;
import org.eclipse.iee.translator.molex.mex.mex.TransposeMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Variable;
import org.eclipse.iee.translator.molex.mex.mex.VariableAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MexPackageImpl extends EPackageImpl implements MexPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixRowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subtractionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass divisionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduloEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invertEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factorialEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inBracketsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixAdditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixSubtractionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixMultiplicationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass newMatrixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transposeMatrixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matrixInBracketsEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.iee.translator.molex.mex.mex.MexPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MexPackageImpl()
  {
    super(eNS_URI, MexFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link MexPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MexPackage init()
  {
    if (isInited) return (MexPackage)EPackage.Registry.INSTANCE.getEPackage(MexPackage.eNS_URI);

    // Obtain or create and register package
    MexPackageImpl theMexPackage = (MexPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MexPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MexPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMexPackage.createPackageContents();

    // Initialize created meta-data
    theMexPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMexPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MexPackage.eNS_URI, theMexPackage);
    return theMexPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_FunctionDefinition()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_VariableAssignment()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_Formula()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_MatrixAssignment()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_MatrixFormula()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableAssignment()
  {
    return variableAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableAssignment_Variable()
  {
    return (EAttribute)variableAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableAssignment_Value()
  {
    return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormula()
  {
    return formulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormula_Expression()
  {
    return (EReference)formulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Addition()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpression_Name()
  {
    return (EAttribute)expressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Parameters()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrix()
  {
    return matrixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrix_Rows()
  {
    return (EReference)matrixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixRow()
  {
    return matrixRowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMatrixRow_Elements()
  {
    return (EAttribute)matrixRowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixAssignment()
  {
    return matrixAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMatrixAssignment_Variable()
  {
    return (EAttribute)matrixAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixAssignment_Value()
  {
    return (EReference)matrixAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixFormula()
  {
    return matrixFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixFormula_Expression()
  {
    return (EReference)matrixFormulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixExpression()
  {
    return matrixExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixExpression_Addition()
  {
    return (EReference)matrixExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDefinition()
  {
    return functionDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Function()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Formula()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddition()
  {
    return additionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddition_Left()
  {
    return (EReference)additionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddition_Right()
  {
    return (EReference)additionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubtraction()
  {
    return subtractionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtraction_Left()
  {
    return (EReference)subtractionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtraction_Right()
  {
    return (EReference)subtractionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplication()
  {
    return multiplicationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplication_Left()
  {
    return (EReference)multiplicationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplication_Right()
  {
    return (EReference)multiplicationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDivision()
  {
    return divisionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDivision_Left()
  {
    return (EReference)divisionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDivision_Right()
  {
    return (EReference)divisionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModulo()
  {
    return moduloEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModulo_Left()
  {
    return (EReference)moduloEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModulo_Right()
  {
    return (EReference)moduloEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvert()
  {
    return invertEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvert_Expression()
  {
    return (EReference)invertEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactorial()
  {
    return factorialEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactorial_Expression()
  {
    return (EReference)factorialEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExponent()
  {
    return exponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExponent_Left()
  {
    return (EReference)exponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExponent_Right()
  {
    return (EReference)exponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloat()
  {
    return floatEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFloat_Value()
  {
    return (EAttribute)floatEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunction()
  {
    return functionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Function()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixElement()
  {
    return matrixElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMatrixElement_Element()
  {
    return (EAttribute)matrixElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMatrixElement_Row()
  {
    return (EAttribute)matrixElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMatrixElement_Column()
  {
    return (EAttribute)matrixElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInBrackets()
  {
    return inBracketsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInBrackets_InBrackets()
  {
    return (EReference)inBracketsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixAddition()
  {
    return matrixAdditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixAddition_Left()
  {
    return (EReference)matrixAdditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixAddition_Right()
  {
    return (EReference)matrixAdditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixSubtraction()
  {
    return matrixSubtractionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixSubtraction_Left()
  {
    return (EReference)matrixSubtractionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixSubtraction_Right()
  {
    return (EReference)matrixSubtractionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixMultiplication()
  {
    return matrixMultiplicationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixMultiplication_Left()
  {
    return (EReference)matrixMultiplicationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixMultiplication_RightMatrix()
  {
    return (EReference)matrixMultiplicationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixMultiplication_RightScalar()
  {
    return (EReference)matrixMultiplicationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNewMatrix()
  {
    return newMatrixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNewMatrix_Matrix()
  {
    return (EReference)newMatrixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransposeMatrix()
  {
    return transposeMatrixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransposeMatrix_Name()
  {
    return (EAttribute)transposeMatrixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixVariable()
  {
    return matrixVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMatrixVariable_Name()
  {
    return (EAttribute)matrixVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatrixInBrackets()
  {
    return matrixInBracketsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixInBrackets_InBrackets()
  {
    return (EReference)matrixInBracketsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MexFactory getMexFactory()
  {
    return (MexFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    statementEClass = createEClass(STATEMENT);
    createEReference(statementEClass, STATEMENT__FUNCTION_DEFINITION);
    createEReference(statementEClass, STATEMENT__VARIABLE_ASSIGNMENT);
    createEReference(statementEClass, STATEMENT__FORMULA);
    createEReference(statementEClass, STATEMENT__MATRIX_ASSIGNMENT);
    createEReference(statementEClass, STATEMENT__MATRIX_FORMULA);

    variableAssignmentEClass = createEClass(VARIABLE_ASSIGNMENT);
    createEAttribute(variableAssignmentEClass, VARIABLE_ASSIGNMENT__VARIABLE);
    createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__VALUE);

    formulaEClass = createEClass(FORMULA);
    createEReference(formulaEClass, FORMULA__EXPRESSION);

    expressionEClass = createEClass(EXPRESSION);
    createEReference(expressionEClass, EXPRESSION__ADDITION);
    createEAttribute(expressionEClass, EXPRESSION__NAME);
    createEReference(expressionEClass, EXPRESSION__PARAMETERS);

    matrixEClass = createEClass(MATRIX);
    createEReference(matrixEClass, MATRIX__ROWS);

    matrixRowEClass = createEClass(MATRIX_ROW);
    createEAttribute(matrixRowEClass, MATRIX_ROW__ELEMENTS);

    matrixAssignmentEClass = createEClass(MATRIX_ASSIGNMENT);
    createEAttribute(matrixAssignmentEClass, MATRIX_ASSIGNMENT__VARIABLE);
    createEReference(matrixAssignmentEClass, MATRIX_ASSIGNMENT__VALUE);

    matrixFormulaEClass = createEClass(MATRIX_FORMULA);
    createEReference(matrixFormulaEClass, MATRIX_FORMULA__EXPRESSION);

    matrixExpressionEClass = createEClass(MATRIX_EXPRESSION);
    createEReference(matrixExpressionEClass, MATRIX_EXPRESSION__ADDITION);

    functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__FUNCTION);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__FORMULA);

    additionEClass = createEClass(ADDITION);
    createEReference(additionEClass, ADDITION__LEFT);
    createEReference(additionEClass, ADDITION__RIGHT);

    subtractionEClass = createEClass(SUBTRACTION);
    createEReference(subtractionEClass, SUBTRACTION__LEFT);
    createEReference(subtractionEClass, SUBTRACTION__RIGHT);

    multiplicationEClass = createEClass(MULTIPLICATION);
    createEReference(multiplicationEClass, MULTIPLICATION__LEFT);
    createEReference(multiplicationEClass, MULTIPLICATION__RIGHT);

    divisionEClass = createEClass(DIVISION);
    createEReference(divisionEClass, DIVISION__LEFT);
    createEReference(divisionEClass, DIVISION__RIGHT);

    moduloEClass = createEClass(MODULO);
    createEReference(moduloEClass, MODULO__LEFT);
    createEReference(moduloEClass, MODULO__RIGHT);

    invertEClass = createEClass(INVERT);
    createEReference(invertEClass, INVERT__EXPRESSION);

    factorialEClass = createEClass(FACTORIAL);
    createEReference(factorialEClass, FACTORIAL__EXPRESSION);

    exponentEClass = createEClass(EXPONENT);
    createEReference(exponentEClass, EXPONENT__LEFT);
    createEReference(exponentEClass, EXPONENT__RIGHT);

    variableEClass = createEClass(VARIABLE);

    floatEClass = createEClass(FLOAT);
    createEAttribute(floatEClass, FLOAT__VALUE);

    functionEClass = createEClass(FUNCTION);
    createEReference(functionEClass, FUNCTION__FUNCTION);

    matrixElementEClass = createEClass(MATRIX_ELEMENT);
    createEAttribute(matrixElementEClass, MATRIX_ELEMENT__ELEMENT);
    createEAttribute(matrixElementEClass, MATRIX_ELEMENT__ROW);
    createEAttribute(matrixElementEClass, MATRIX_ELEMENT__COLUMN);

    inBracketsEClass = createEClass(IN_BRACKETS);
    createEReference(inBracketsEClass, IN_BRACKETS__IN_BRACKETS);

    matrixAdditionEClass = createEClass(MATRIX_ADDITION);
    createEReference(matrixAdditionEClass, MATRIX_ADDITION__LEFT);
    createEReference(matrixAdditionEClass, MATRIX_ADDITION__RIGHT);

    matrixSubtractionEClass = createEClass(MATRIX_SUBTRACTION);
    createEReference(matrixSubtractionEClass, MATRIX_SUBTRACTION__LEFT);
    createEReference(matrixSubtractionEClass, MATRIX_SUBTRACTION__RIGHT);

    matrixMultiplicationEClass = createEClass(MATRIX_MULTIPLICATION);
    createEReference(matrixMultiplicationEClass, MATRIX_MULTIPLICATION__LEFT);
    createEReference(matrixMultiplicationEClass, MATRIX_MULTIPLICATION__RIGHT_MATRIX);
    createEReference(matrixMultiplicationEClass, MATRIX_MULTIPLICATION__RIGHT_SCALAR);

    newMatrixEClass = createEClass(NEW_MATRIX);
    createEReference(newMatrixEClass, NEW_MATRIX__MATRIX);

    transposeMatrixEClass = createEClass(TRANSPOSE_MATRIX);
    createEAttribute(transposeMatrixEClass, TRANSPOSE_MATRIX__NAME);

    matrixVariableEClass = createEClass(MATRIX_VARIABLE);
    createEAttribute(matrixVariableEClass, MATRIX_VARIABLE__NAME);

    matrixInBracketsEClass = createEClass(MATRIX_IN_BRACKETS);
    createEReference(matrixInBracketsEClass, MATRIX_IN_BRACKETS__IN_BRACKETS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    additionEClass.getESuperTypes().add(this.getExpression());
    subtractionEClass.getESuperTypes().add(this.getExpression());
    multiplicationEClass.getESuperTypes().add(this.getExpression());
    divisionEClass.getESuperTypes().add(this.getExpression());
    moduloEClass.getESuperTypes().add(this.getExpression());
    invertEClass.getESuperTypes().add(this.getExpression());
    factorialEClass.getESuperTypes().add(this.getExpression());
    exponentEClass.getESuperTypes().add(this.getExpression());
    variableEClass.getESuperTypes().add(this.getExpression());
    floatEClass.getESuperTypes().add(this.getExpression());
    functionEClass.getESuperTypes().add(this.getExpression());
    matrixElementEClass.getESuperTypes().add(this.getExpression());
    inBracketsEClass.getESuperTypes().add(this.getExpression());
    matrixAdditionEClass.getESuperTypes().add(this.getMatrixExpression());
    matrixSubtractionEClass.getESuperTypes().add(this.getMatrixExpression());
    matrixMultiplicationEClass.getESuperTypes().add(this.getMatrixExpression());
    newMatrixEClass.getESuperTypes().add(this.getMatrixExpression());
    transposeMatrixEClass.getESuperTypes().add(this.getMatrixExpression());
    matrixVariableEClass.getESuperTypes().add(this.getMatrixExpression());
    matrixInBracketsEClass.getESuperTypes().add(this.getMatrixExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatement_FunctionDefinition(), this.getFunctionDefinition(), null, "functionDefinition", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStatement_VariableAssignment(), this.getVariableAssignment(), null, "variableAssignment", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStatement_Formula(), this.getFormula(), null, "formula", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStatement_MatrixAssignment(), this.getMatrixAssignment(), null, "matrixAssignment", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStatement_MatrixFormula(), this.getMatrixFormula(), null, "matrixFormula", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableAssignmentEClass, VariableAssignment.class, "VariableAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableAssignment_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableAssignment_Value(), this.getFormula(), null, "value", null, 0, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formulaEClass, Formula.class, "Formula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormula_Expression(), this.getExpression(), null, "expression", null, 0, 1, Formula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Addition(), this.getExpression(), null, "addition", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExpression_Name(), ecorePackage.getEString(), "name", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Parameters(), this.getFormula(), null, "parameters", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixEClass, Matrix.class, "Matrix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrix_Rows(), this.getMatrixRow(), null, "rows", null, 0, -1, Matrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixRowEClass, MatrixRow.class, "MatrixRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMatrixRow_Elements(), ecorePackage.getEString(), "elements", null, 0, -1, MatrixRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixAssignmentEClass, MatrixAssignment.class, "MatrixAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMatrixAssignment_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, MatrixAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMatrixAssignment_Value(), this.getMatrixFormula(), null, "value", null, 0, 1, MatrixAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixFormulaEClass, MatrixFormula.class, "MatrixFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrixFormula_Expression(), this.getMatrixExpression(), null, "expression", null, 0, 1, MatrixFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixExpressionEClass, MatrixExpression.class, "MatrixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrixExpression_Addition(), this.getMatrixExpression(), null, "addition", null, 0, 1, MatrixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionDefinition_Function(), this.getExpression(), null, "function", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionDefinition_Formula(), this.getFormula(), null, "formula", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(additionEClass, Addition.class, "Addition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAddition_Left(), this.getExpression(), null, "left", null, 0, 1, Addition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAddition_Right(), this.getExpression(), null, "right", null, 0, 1, Addition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subtractionEClass, Subtraction.class, "Subtraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubtraction_Left(), this.getExpression(), null, "left", null, 0, 1, Subtraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubtraction_Right(), this.getExpression(), null, "right", null, 0, 1, Subtraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicationEClass, Multiplication.class, "Multiplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplication_Left(), this.getExpression(), null, "left", null, 0, 1, Multiplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultiplication_Right(), this.getExpression(), null, "right", null, 0, 1, Multiplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(divisionEClass, Division.class, "Division", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDivision_Left(), this.getExpression(), null, "left", null, 0, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDivision_Right(), this.getExpression(), null, "right", null, 0, 1, Division.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduloEClass, Modulo.class, "Modulo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModulo_Left(), this.getExpression(), null, "left", null, 0, 1, Modulo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModulo_Right(), this.getExpression(), null, "right", null, 0, 1, Modulo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invertEClass, Invert.class, "Invert", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInvert_Expression(), this.getExpression(), null, "expression", null, 0, 1, Invert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(factorialEClass, Factorial.class, "Factorial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFactorial_Expression(), this.getExpression(), null, "expression", null, 0, 1, Factorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exponentEClass, Exponent.class, "Exponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExponent_Left(), this.getExpression(), null, "left", null, 0, 1, Exponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExponent_Right(), this.getExpression(), null, "right", null, 0, 1, Exponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(floatEClass, org.eclipse.iee.translator.molex.mex.mex.Float.class, "Float", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFloat_Value(), ecorePackage.getEString(), "value", null, 0, 1, org.eclipse.iee.translator.molex.mex.mex.Float.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunction_Function(), this.getExpression(), null, "function", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixElementEClass, MatrixElement.class, "MatrixElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMatrixElement_Element(), ecorePackage.getEString(), "element", null, 0, 1, MatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMatrixElement_Row(), ecorePackage.getEInt(), "row", null, 0, 1, MatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMatrixElement_Column(), ecorePackage.getEInt(), "column", null, 0, 1, MatrixElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inBracketsEClass, InBrackets.class, "InBrackets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInBrackets_InBrackets(), this.getExpression(), null, "inBrackets", null, 0, 1, InBrackets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixAdditionEClass, MatrixAddition.class, "MatrixAddition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrixAddition_Left(), this.getMatrixExpression(), null, "left", null, 0, 1, MatrixAddition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMatrixAddition_Right(), this.getMatrixExpression(), null, "right", null, 0, 1, MatrixAddition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixSubtractionEClass, MatrixSubtraction.class, "MatrixSubtraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrixSubtraction_Left(), this.getMatrixExpression(), null, "left", null, 0, 1, MatrixSubtraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMatrixSubtraction_Right(), this.getMatrixExpression(), null, "right", null, 0, 1, MatrixSubtraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixMultiplicationEClass, MatrixMultiplication.class, "MatrixMultiplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrixMultiplication_Left(), this.getMatrixExpression(), null, "left", null, 0, 1, MatrixMultiplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMatrixMultiplication_RightMatrix(), this.getMatrixExpression(), null, "rightMatrix", null, 0, 1, MatrixMultiplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMatrixMultiplication_RightScalar(), this.getFormula(), null, "rightScalar", null, 0, 1, MatrixMultiplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(newMatrixEClass, NewMatrix.class, "NewMatrix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNewMatrix_Matrix(), this.getMatrix(), null, "matrix", null, 0, 1, NewMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transposeMatrixEClass, TransposeMatrix.class, "TransposeMatrix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransposeMatrix_Name(), ecorePackage.getEString(), "name", null, 0, 1, TransposeMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixVariableEClass, MatrixVariable.class, "MatrixVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMatrixVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, MatrixVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixInBracketsEClass, MatrixInBrackets.class, "MatrixInBrackets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrixInBrackets_InBrackets(), this.getMatrixExpression(), null, "inBrackets", null, 0, 1, MatrixInBrackets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //MexPackageImpl
