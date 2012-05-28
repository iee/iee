package org.eclipse.iee.translator.molex.mex.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.iee.translator.molex.mex.mex.Addition;
import org.eclipse.iee.translator.molex.mex.mex.Division;
import org.eclipse.iee.translator.molex.mex.mex.Exponent;
import org.eclipse.iee.translator.molex.mex.mex.Expression;
import org.eclipse.iee.translator.molex.mex.mex.Factorial;
import org.eclipse.iee.translator.molex.mex.mex.Float;
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
import org.eclipse.iee.translator.molex.mex.mex.Modulo;
import org.eclipse.iee.translator.molex.mex.mex.Multiplication;
import org.eclipse.iee.translator.molex.mex.mex.NewMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Statement;
import org.eclipse.iee.translator.molex.mex.mex.Subtraction;
import org.eclipse.iee.translator.molex.mex.mex.TransposeMatrix;
import org.eclipse.iee.translator.molex.mex.mex.Variable;
import org.eclipse.iee.translator.molex.mex.mex.VariableAssignment;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.ResourceExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MexGenerator implements IGenerator {
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
  }
  
  public String generateText(final Resource resource) {
    {
      Iterable<EObject> _allContentsIterable = ResourceExtensions.allContentsIterable(resource);
      Iterable<Statement> _filter = IterableExtensions.<Statement>filter(_allContentsIterable, org.eclipse.iee.translator.molex.mex.mex.Statement.class);
      Iterable<Statement> statements = _filter;
      boolean _isEmpty = IterableExtensions.isEmpty(statements);
      if (_isEmpty) {
        return null;
      }
      Statement _head = IterableExtensions.<Statement>head(statements);
      StringConcatenation _compileStatement = this.compileStatement(_head);
      String _string = _compileStatement.toString();
      return _string;
    }
  }
  
  public StringConcatenation compileStatement(final Statement s) {
    StringConcatenation _builder = new StringConcatenation();
    {
      FunctionDefinition _functionDefinition = s.getFunctionDefinition();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_functionDefinition, null);
      if (_operator_notEquals) {
        FunctionDefinition _functionDefinition_1 = s.getFunctionDefinition();
        StringConcatenation _compileFunctionDefinition = this.compileFunctionDefinition(_functionDefinition_1);
        _builder.append(_compileFunctionDefinition, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      Formula _formula = s.getFormula();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_formula, null);
      if (_operator_notEquals_1) {
        Formula _formula_1 = s.getFormula();
        StringConcatenation _compileFormula = this.compileFormula(_formula_1);
        _builder.append(_compileFormula, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      VariableAssignment _variableAssignment = s.getVariableAssignment();
      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_variableAssignment, null);
      if (_operator_notEquals_2) {
        VariableAssignment _variableAssignment_1 = s.getVariableAssignment();
        StringConcatenation _compileVariableAssignment = this.compileVariableAssignment(_variableAssignment_1);
        _builder.append(_compileVariableAssignment, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      MatrixAssignment _matrixAssignment = s.getMatrixAssignment();
      boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_matrixAssignment, null);
      if (_operator_notEquals_3) {
        MatrixAssignment _matrixAssignment_1 = s.getMatrixAssignment();
        StringConcatenation _compileMatrixAssignment = this.compileMatrixAssignment(_matrixAssignment_1);
        _builder.append(_compileMatrixAssignment, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      MatrixFormula _matrixFormula = s.getMatrixFormula();
      boolean _operator_notEquals_4 = ObjectExtensions.operator_notEquals(_matrixFormula, null);
      if (_operator_notEquals_4) {
        MatrixFormula _matrixFormula_1 = s.getMatrixFormula();
        StringConcatenation _compileMatrixFormula = this.compileMatrixFormula(_matrixFormula_1);
        _builder.append(_compileMatrixFormula, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileFunctionDefinition(final FunctionDefinition funcDef) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_or = false;
      boolean _operator_or_1 = false;
      boolean _operator_or_2 = false;
      boolean _operator_or_3 = false;
      boolean _operator_or_4 = false;
      boolean _operator_or_5 = false;
      boolean _operator_or_6 = false;
      boolean _operator_or_7 = false;
      boolean _operator_or_8 = false;
      boolean _operator_or_9 = false;
      boolean _operator_or_10 = false;
      boolean _operator_or_11 = false;
      boolean _operator_or_12 = false;
      boolean _operator_or_13 = false;
      boolean _operator_or_14 = false;
      boolean _operator_or_15 = false;
      boolean _operator_or_16 = false;
      boolean _operator_or_17 = false;
      boolean _operator_or_18 = false;
      boolean _operator_or_19 = false;
      boolean _operator_or_20 = false;
      boolean _operator_or_21 = false;
      boolean _operator_or_22 = false;
      boolean _operator_or_23 = false;
      boolean _operator_or_24 = false;
      boolean _operator_or_25 = false;
      boolean _operator_or_26 = false;
      boolean _operator_or_27 = false;
      boolean _operator_or_28 = false;
      boolean _operator_or_29 = false;
      boolean _operator_or_30 = false;
      boolean _operator_or_31 = false;
      boolean _operator_or_32 = false;
      boolean _operator_or_33 = false;
      boolean _operator_or_34 = false;
      boolean _operator_or_35 = false;
      boolean _operator_or_36 = false;
      boolean _operator_or_37 = false;
      boolean _operator_or_38 = false;
      Expression _function = funcDef.getFunction();
      String _name = _function.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "alpha");
      if (_operator_equals) {
        _operator_or_38 = true;
      } else {
        Expression _function_1 = funcDef.getFunction();
        String _name_1 = _function_1.getName();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, "beta");
        _operator_or_38 = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or_38) {
        _operator_or_37 = true;
      } else {
        Expression _function_2 = funcDef.getFunction();
        String _name_2 = _function_2.getName();
        boolean _operator_equals_2 = ObjectExtensions.operator_equals(_name_2, "gamma");
        _operator_or_37 = BooleanExtensions.operator_or(_operator_or_38, _operator_equals_2);
      }
      if (_operator_or_37) {
        _operator_or_36 = true;
      } else {
        Expression _function_3 = funcDef.getFunction();
        String _name_3 = _function_3.getName();
        boolean _operator_equals_3 = ObjectExtensions.operator_equals(_name_3, "delta");
        _operator_or_36 = BooleanExtensions.operator_or(_operator_or_37, _operator_equals_3);
      }
      if (_operator_or_36) {
        _operator_or_35 = true;
      } else {
        Expression _function_4 = funcDef.getFunction();
        String _name_4 = _function_4.getName();
        boolean _operator_equals_4 = ObjectExtensions.operator_equals(_name_4, "epsilon");
        _operator_or_35 = BooleanExtensions.operator_or(_operator_or_36, _operator_equals_4);
      }
      if (_operator_or_35) {
        _operator_or_34 = true;
      } else {
        Expression _function_5 = funcDef.getFunction();
        String _name_5 = _function_5.getName();
        boolean _operator_equals_5 = ObjectExtensions.operator_equals(_name_5, "varepsilon");
        _operator_or_34 = BooleanExtensions.operator_or(_operator_or_35, _operator_equals_5);
      }
      if (_operator_or_34) {
        _operator_or_33 = true;
      } else {
        Expression _function_6 = funcDef.getFunction();
        String _name_6 = _function_6.getName();
        boolean _operator_equals_6 = ObjectExtensions.operator_equals(_name_6, "zeta");
        _operator_or_33 = BooleanExtensions.operator_or(_operator_or_34, _operator_equals_6);
      }
      if (_operator_or_33) {
        _operator_or_32 = true;
      } else {
        Expression _function_7 = funcDef.getFunction();
        String _name_7 = _function_7.getName();
        boolean _operator_equals_7 = ObjectExtensions.operator_equals(_name_7, "eta");
        _operator_or_32 = BooleanExtensions.operator_or(_operator_or_33, _operator_equals_7);
      }
      if (_operator_or_32) {
        _operator_or_31 = true;
      } else {
        Expression _function_8 = funcDef.getFunction();
        String _name_8 = _function_8.getName();
        boolean _operator_equals_8 = ObjectExtensions.operator_equals(_name_8, "theta");
        _operator_or_31 = BooleanExtensions.operator_or(_operator_or_32, _operator_equals_8);
      }
      if (_operator_or_31) {
        _operator_or_30 = true;
      } else {
        Expression _function_9 = funcDef.getFunction();
        String _name_9 = _function_9.getName();
        boolean _operator_equals_9 = ObjectExtensions.operator_equals(_name_9, "vartheta");
        _operator_or_30 = BooleanExtensions.operator_or(_operator_or_31, _operator_equals_9);
      }
      if (_operator_or_30) {
        _operator_or_29 = true;
      } else {
        Expression _function_10 = funcDef.getFunction();
        String _name_10 = _function_10.getName();
        boolean _operator_equals_10 = ObjectExtensions.operator_equals(_name_10, "gamma");
        _operator_or_29 = BooleanExtensions.operator_or(_operator_or_30, _operator_equals_10);
      }
      if (_operator_or_29) {
        _operator_or_28 = true;
      } else {
        Expression _function_11 = funcDef.getFunction();
        String _name_11 = _function_11.getName();
        boolean _operator_equals_11 = ObjectExtensions.operator_equals(_name_11, "kappa");
        _operator_or_28 = BooleanExtensions.operator_or(_operator_or_29, _operator_equals_11);
      }
      if (_operator_or_28) {
        _operator_or_27 = true;
      } else {
        Expression _function_12 = funcDef.getFunction();
        String _name_12 = _function_12.getName();
        boolean _operator_equals_12 = ObjectExtensions.operator_equals(_name_12, "lambda");
        _operator_or_27 = BooleanExtensions.operator_or(_operator_or_28, _operator_equals_12);
      }
      if (_operator_or_27) {
        _operator_or_26 = true;
      } else {
        Expression _function_13 = funcDef.getFunction();
        String _name_13 = _function_13.getName();
        boolean _operator_equals_13 = ObjectExtensions.operator_equals(_name_13, "mu");
        _operator_or_26 = BooleanExtensions.operator_or(_operator_or_27, _operator_equals_13);
      }
      if (_operator_or_26) {
        _operator_or_25 = true;
      } else {
        Expression _function_14 = funcDef.getFunction();
        String _name_14 = _function_14.getName();
        boolean _operator_equals_14 = ObjectExtensions.operator_equals(_name_14, "nu");
        _operator_or_25 = BooleanExtensions.operator_or(_operator_or_26, _operator_equals_14);
      }
      if (_operator_or_25) {
        _operator_or_24 = true;
      } else {
        Expression _function_15 = funcDef.getFunction();
        String _name_15 = _function_15.getName();
        boolean _operator_equals_15 = ObjectExtensions.operator_equals(_name_15, "xi");
        _operator_or_24 = BooleanExtensions.operator_or(_operator_or_25, _operator_equals_15);
      }
      if (_operator_or_24) {
        _operator_or_23 = true;
      } else {
        Expression _function_16 = funcDef.getFunction();
        String _name_16 = _function_16.getName();
        boolean _operator_equals_16 = ObjectExtensions.operator_equals(_name_16, "pi");
        _operator_or_23 = BooleanExtensions.operator_or(_operator_or_24, _operator_equals_16);
      }
      if (_operator_or_23) {
        _operator_or_22 = true;
      } else {
        Expression _function_17 = funcDef.getFunction();
        String _name_17 = _function_17.getName();
        boolean _operator_equals_17 = ObjectExtensions.operator_equals(_name_17, "varpi");
        _operator_or_22 = BooleanExtensions.operator_or(_operator_or_23, _operator_equals_17);
      }
      if (_operator_or_22) {
        _operator_or_21 = true;
      } else {
        Expression _function_18 = funcDef.getFunction();
        String _name_18 = _function_18.getName();
        boolean _operator_equals_18 = ObjectExtensions.operator_equals(_name_18, "rho");
        _operator_or_21 = BooleanExtensions.operator_or(_operator_or_22, _operator_equals_18);
      }
      if (_operator_or_21) {
        _operator_or_20 = true;
      } else {
        Expression _function_19 = funcDef.getFunction();
        String _name_19 = _function_19.getName();
        boolean _operator_equals_19 = ObjectExtensions.operator_equals(_name_19, "varrho");
        _operator_or_20 = BooleanExtensions.operator_or(_operator_or_21, _operator_equals_19);
      }
      if (_operator_or_20) {
        _operator_or_19 = true;
      } else {
        Expression _function_20 = funcDef.getFunction();
        String _name_20 = _function_20.getName();
        boolean _operator_equals_20 = ObjectExtensions.operator_equals(_name_20, "sigma");
        _operator_or_19 = BooleanExtensions.operator_or(_operator_or_20, _operator_equals_20);
      }
      if (_operator_or_19) {
        _operator_or_18 = true;
      } else {
        Expression _function_21 = funcDef.getFunction();
        String _name_21 = _function_21.getName();
        boolean _operator_equals_21 = ObjectExtensions.operator_equals(_name_21, "varsigma");
        _operator_or_18 = BooleanExtensions.operator_or(_operator_or_19, _operator_equals_21);
      }
      if (_operator_or_18) {
        _operator_or_17 = true;
      } else {
        Expression _function_22 = funcDef.getFunction();
        String _name_22 = _function_22.getName();
        boolean _operator_equals_22 = ObjectExtensions.operator_equals(_name_22, "tau");
        _operator_or_17 = BooleanExtensions.operator_or(_operator_or_18, _operator_equals_22);
      }
      if (_operator_or_17) {
        _operator_or_16 = true;
      } else {
        Expression _function_23 = funcDef.getFunction();
        String _name_23 = _function_23.getName();
        boolean _operator_equals_23 = ObjectExtensions.operator_equals(_name_23, "upsilon");
        _operator_or_16 = BooleanExtensions.operator_or(_operator_or_17, _operator_equals_23);
      }
      if (_operator_or_16) {
        _operator_or_15 = true;
      } else {
        Expression _function_24 = funcDef.getFunction();
        String _name_24 = _function_24.getName();
        boolean _operator_equals_24 = ObjectExtensions.operator_equals(_name_24, "phi");
        _operator_or_15 = BooleanExtensions.operator_or(_operator_or_16, _operator_equals_24);
      }
      if (_operator_or_15) {
        _operator_or_14 = true;
      } else {
        Expression _function_25 = funcDef.getFunction();
        String _name_25 = _function_25.getName();
        boolean _operator_equals_25 = ObjectExtensions.operator_equals(_name_25, "varphi");
        _operator_or_14 = BooleanExtensions.operator_or(_operator_or_15, _operator_equals_25);
      }
      if (_operator_or_14) {
        _operator_or_13 = true;
      } else {
        Expression _function_26 = funcDef.getFunction();
        String _name_26 = _function_26.getName();
        boolean _operator_equals_26 = ObjectExtensions.operator_equals(_name_26, "chi");
        _operator_or_13 = BooleanExtensions.operator_or(_operator_or_14, _operator_equals_26);
      }
      if (_operator_or_13) {
        _operator_or_12 = true;
      } else {
        Expression _function_27 = funcDef.getFunction();
        String _name_27 = _function_27.getName();
        boolean _operator_equals_27 = ObjectExtensions.operator_equals(_name_27, "psi");
        _operator_or_12 = BooleanExtensions.operator_or(_operator_or_13, _operator_equals_27);
      }
      if (_operator_or_12) {
        _operator_or_11 = true;
      } else {
        Expression _function_28 = funcDef.getFunction();
        String _name_28 = _function_28.getName();
        boolean _operator_equals_28 = ObjectExtensions.operator_equals(_name_28, "omega");
        _operator_or_11 = BooleanExtensions.operator_or(_operator_or_12, _operator_equals_28);
      }
      if (_operator_or_11) {
        _operator_or_10 = true;
      } else {
        Expression _function_29 = funcDef.getFunction();
        String _name_29 = _function_29.getName();
        boolean _operator_equals_29 = ObjectExtensions.operator_equals(_name_29, "Gamma");
        _operator_or_10 = BooleanExtensions.operator_or(_operator_or_11, _operator_equals_29);
      }
      if (_operator_or_10) {
        _operator_or_9 = true;
      } else {
        Expression _function_30 = funcDef.getFunction();
        String _name_30 = _function_30.getName();
        boolean _operator_equals_30 = ObjectExtensions.operator_equals(_name_30, "Delta");
        _operator_or_9 = BooleanExtensions.operator_or(_operator_or_10, _operator_equals_30);
      }
      if (_operator_or_9) {
        _operator_or_8 = true;
      } else {
        Expression _function_31 = funcDef.getFunction();
        String _name_31 = _function_31.getName();
        boolean _operator_equals_31 = ObjectExtensions.operator_equals(_name_31, "Theta");
        _operator_or_8 = BooleanExtensions.operator_or(_operator_or_9, _operator_equals_31);
      }
      if (_operator_or_8) {
        _operator_or_7 = true;
      } else {
        Expression _function_32 = funcDef.getFunction();
        String _name_32 = _function_32.getName();
        boolean _operator_equals_32 = ObjectExtensions.operator_equals(_name_32, "Lambda");
        _operator_or_7 = BooleanExtensions.operator_or(_operator_or_8, _operator_equals_32);
      }
      if (_operator_or_7) {
        _operator_or_6 = true;
      } else {
        Expression _function_33 = funcDef.getFunction();
        String _name_33 = _function_33.getName();
        boolean _operator_equals_33 = ObjectExtensions.operator_equals(_name_33, "Xi");
        _operator_or_6 = BooleanExtensions.operator_or(_operator_or_7, _operator_equals_33);
      }
      if (_operator_or_6) {
        _operator_or_5 = true;
      } else {
        Expression _function_34 = funcDef.getFunction();
        String _name_34 = _function_34.getName();
        boolean _operator_equals_34 = ObjectExtensions.operator_equals(_name_34, "Pi");
        _operator_or_5 = BooleanExtensions.operator_or(_operator_or_6, _operator_equals_34);
      }
      if (_operator_or_5) {
        _operator_or_4 = true;
      } else {
        Expression _function_35 = funcDef.getFunction();
        String _name_35 = _function_35.getName();
        boolean _operator_equals_35 = ObjectExtensions.operator_equals(_name_35, "Sigma");
        _operator_or_4 = BooleanExtensions.operator_or(_operator_or_5, _operator_equals_35);
      }
      if (_operator_or_4) {
        _operator_or_3 = true;
      } else {
        Expression _function_36 = funcDef.getFunction();
        String _name_36 = _function_36.getName();
        boolean _operator_equals_36 = ObjectExtensions.operator_equals(_name_36, "Upsilon");
        _operator_or_3 = BooleanExtensions.operator_or(_operator_or_4, _operator_equals_36);
      }
      if (_operator_or_3) {
        _operator_or_2 = true;
      } else {
        Expression _function_37 = funcDef.getFunction();
        String _name_37 = _function_37.getName();
        boolean _operator_equals_37 = ObjectExtensions.operator_equals(_name_37, "Phi");
        _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, _operator_equals_37);
      }
      if (_operator_or_2) {
        _operator_or_1 = true;
      } else {
        Expression _function_38 = funcDef.getFunction();
        String _name_38 = _function_38.getName();
        boolean _operator_equals_38 = ObjectExtensions.operator_equals(_name_38, "Psi");
        _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, _operator_equals_38);
      }
      if (_operator_or_1) {
        _operator_or = true;
      } else {
        Expression _function_39 = funcDef.getFunction();
        String _name_39 = _function_39.getName();
        boolean _operator_equals_39 = ObjectExtensions.operator_equals(_name_39, "Omega");
        _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_39);
      }
      if (_operator_or) {
        _builder.append("\\");
        _builder.newLine();
      }
    }
    Expression _function_40 = funcDef.getFunction();
    String _name_40 = _function_40.getName();
    _builder.append(_name_40, "");
    _builder.append(" ( ");
    _builder.newLineIfNotEmpty();
    {
      Expression _function_41 = funcDef.getFunction();
      EList<Formula> _parameters = _function_41.getParameters();
      for(Formula param : _parameters) {
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(param, null);
          if (_operator_notEquals) {
            StringConcatenation _compileFormula = this.compileFormula(param);
            _builder.append(_compileFormula, "");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          Expression _function_42 = funcDef.getFunction();
          EList<Formula> _parameters_1 = _function_42.getParameters();
          Formula _last = IterableExtensions.<Formula>last(_parameters_1);
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_last, param);
          if (_operator_notEquals_1) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      Formula _formula = funcDef.getFormula();
      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_formula, null);
      if (_operator_notEquals_2) {
        _builder.append("=");
        Formula _formula_1 = funcDef.getFormula();
        StringConcatenation _compileFormula_1 = this.compileFormula(_formula_1);
        _builder.append(_compileFormula_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileVariableAssignment(final VariableAssignment a) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_or = false;
      boolean _operator_or_1 = false;
      boolean _operator_or_2 = false;
      boolean _operator_or_3 = false;
      boolean _operator_or_4 = false;
      boolean _operator_or_5 = false;
      boolean _operator_or_6 = false;
      boolean _operator_or_7 = false;
      boolean _operator_or_8 = false;
      boolean _operator_or_9 = false;
      boolean _operator_or_10 = false;
      boolean _operator_or_11 = false;
      boolean _operator_or_12 = false;
      boolean _operator_or_13 = false;
      boolean _operator_or_14 = false;
      boolean _operator_or_15 = false;
      boolean _operator_or_16 = false;
      boolean _operator_or_17 = false;
      boolean _operator_or_18 = false;
      boolean _operator_or_19 = false;
      boolean _operator_or_20 = false;
      boolean _operator_or_21 = false;
      boolean _operator_or_22 = false;
      boolean _operator_or_23 = false;
      boolean _operator_or_24 = false;
      boolean _operator_or_25 = false;
      boolean _operator_or_26 = false;
      boolean _operator_or_27 = false;
      boolean _operator_or_28 = false;
      boolean _operator_or_29 = false;
      boolean _operator_or_30 = false;
      boolean _operator_or_31 = false;
      boolean _operator_or_32 = false;
      boolean _operator_or_33 = false;
      boolean _operator_or_34 = false;
      boolean _operator_or_35 = false;
      boolean _operator_or_36 = false;
      boolean _operator_or_37 = false;
      boolean _operator_or_38 = false;
      String _variable = a.getVariable();
      boolean _operator_equals = ObjectExtensions.operator_equals(_variable, "alpha");
      if (_operator_equals) {
        _operator_or_38 = true;
      } else {
        String _variable_1 = a.getVariable();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_variable_1, "beta");
        _operator_or_38 = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or_38) {
        _operator_or_37 = true;
      } else {
        String _variable_2 = a.getVariable();
        boolean _operator_equals_2 = ObjectExtensions.operator_equals(_variable_2, "gamma");
        _operator_or_37 = BooleanExtensions.operator_or(_operator_or_38, _operator_equals_2);
      }
      if (_operator_or_37) {
        _operator_or_36 = true;
      } else {
        String _variable_3 = a.getVariable();
        boolean _operator_equals_3 = ObjectExtensions.operator_equals(_variable_3, "delta");
        _operator_or_36 = BooleanExtensions.operator_or(_operator_or_37, _operator_equals_3);
      }
      if (_operator_or_36) {
        _operator_or_35 = true;
      } else {
        String _variable_4 = a.getVariable();
        boolean _operator_equals_4 = ObjectExtensions.operator_equals(_variable_4, "epsilon");
        _operator_or_35 = BooleanExtensions.operator_or(_operator_or_36, _operator_equals_4);
      }
      if (_operator_or_35) {
        _operator_or_34 = true;
      } else {
        String _variable_5 = a.getVariable();
        boolean _operator_equals_5 = ObjectExtensions.operator_equals(_variable_5, "varepsilon");
        _operator_or_34 = BooleanExtensions.operator_or(_operator_or_35, _operator_equals_5);
      }
      if (_operator_or_34) {
        _operator_or_33 = true;
      } else {
        String _variable_6 = a.getVariable();
        boolean _operator_equals_6 = ObjectExtensions.operator_equals(_variable_6, "zeta");
        _operator_or_33 = BooleanExtensions.operator_or(_operator_or_34, _operator_equals_6);
      }
      if (_operator_or_33) {
        _operator_or_32 = true;
      } else {
        String _variable_7 = a.getVariable();
        boolean _operator_equals_7 = ObjectExtensions.operator_equals(_variable_7, "eta");
        _operator_or_32 = BooleanExtensions.operator_or(_operator_or_33, _operator_equals_7);
      }
      if (_operator_or_32) {
        _operator_or_31 = true;
      } else {
        String _variable_8 = a.getVariable();
        boolean _operator_equals_8 = ObjectExtensions.operator_equals(_variable_8, "theta");
        _operator_or_31 = BooleanExtensions.operator_or(_operator_or_32, _operator_equals_8);
      }
      if (_operator_or_31) {
        _operator_or_30 = true;
      } else {
        String _variable_9 = a.getVariable();
        boolean _operator_equals_9 = ObjectExtensions.operator_equals(_variable_9, "vartheta");
        _operator_or_30 = BooleanExtensions.operator_or(_operator_or_31, _operator_equals_9);
      }
      if (_operator_or_30) {
        _operator_or_29 = true;
      } else {
        String _variable_10 = a.getVariable();
        boolean _operator_equals_10 = ObjectExtensions.operator_equals(_variable_10, "gamma");
        _operator_or_29 = BooleanExtensions.operator_or(_operator_or_30, _operator_equals_10);
      }
      if (_operator_or_29) {
        _operator_or_28 = true;
      } else {
        String _variable_11 = a.getVariable();
        boolean _operator_equals_11 = ObjectExtensions.operator_equals(_variable_11, "kappa");
        _operator_or_28 = BooleanExtensions.operator_or(_operator_or_29, _operator_equals_11);
      }
      if (_operator_or_28) {
        _operator_or_27 = true;
      } else {
        String _variable_12 = a.getVariable();
        boolean _operator_equals_12 = ObjectExtensions.operator_equals(_variable_12, "lambda");
        _operator_or_27 = BooleanExtensions.operator_or(_operator_or_28, _operator_equals_12);
      }
      if (_operator_or_27) {
        _operator_or_26 = true;
      } else {
        String _variable_13 = a.getVariable();
        boolean _operator_equals_13 = ObjectExtensions.operator_equals(_variable_13, "mu");
        _operator_or_26 = BooleanExtensions.operator_or(_operator_or_27, _operator_equals_13);
      }
      if (_operator_or_26) {
        _operator_or_25 = true;
      } else {
        String _variable_14 = a.getVariable();
        boolean _operator_equals_14 = ObjectExtensions.operator_equals(_variable_14, "nu");
        _operator_or_25 = BooleanExtensions.operator_or(_operator_or_26, _operator_equals_14);
      }
      if (_operator_or_25) {
        _operator_or_24 = true;
      } else {
        String _variable_15 = a.getVariable();
        boolean _operator_equals_15 = ObjectExtensions.operator_equals(_variable_15, "xi");
        _operator_or_24 = BooleanExtensions.operator_or(_operator_or_25, _operator_equals_15);
      }
      if (_operator_or_24) {
        _operator_or_23 = true;
      } else {
        String _variable_16 = a.getVariable();
        boolean _operator_equals_16 = ObjectExtensions.operator_equals(_variable_16, "pi");
        _operator_or_23 = BooleanExtensions.operator_or(_operator_or_24, _operator_equals_16);
      }
      if (_operator_or_23) {
        _operator_or_22 = true;
      } else {
        String _variable_17 = a.getVariable();
        boolean _operator_equals_17 = ObjectExtensions.operator_equals(_variable_17, "varpi");
        _operator_or_22 = BooleanExtensions.operator_or(_operator_or_23, _operator_equals_17);
      }
      if (_operator_or_22) {
        _operator_or_21 = true;
      } else {
        String _variable_18 = a.getVariable();
        boolean _operator_equals_18 = ObjectExtensions.operator_equals(_variable_18, "rho");
        _operator_or_21 = BooleanExtensions.operator_or(_operator_or_22, _operator_equals_18);
      }
      if (_operator_or_21) {
        _operator_or_20 = true;
      } else {
        String _variable_19 = a.getVariable();
        boolean _operator_equals_19 = ObjectExtensions.operator_equals(_variable_19, "varrho");
        _operator_or_20 = BooleanExtensions.operator_or(_operator_or_21, _operator_equals_19);
      }
      if (_operator_or_20) {
        _operator_or_19 = true;
      } else {
        String _variable_20 = a.getVariable();
        boolean _operator_equals_20 = ObjectExtensions.operator_equals(_variable_20, "sigma");
        _operator_or_19 = BooleanExtensions.operator_or(_operator_or_20, _operator_equals_20);
      }
      if (_operator_or_19) {
        _operator_or_18 = true;
      } else {
        String _variable_21 = a.getVariable();
        boolean _operator_equals_21 = ObjectExtensions.operator_equals(_variable_21, "varsigma");
        _operator_or_18 = BooleanExtensions.operator_or(_operator_or_19, _operator_equals_21);
      }
      if (_operator_or_18) {
        _operator_or_17 = true;
      } else {
        String _variable_22 = a.getVariable();
        boolean _operator_equals_22 = ObjectExtensions.operator_equals(_variable_22, "tau");
        _operator_or_17 = BooleanExtensions.operator_or(_operator_or_18, _operator_equals_22);
      }
      if (_operator_or_17) {
        _operator_or_16 = true;
      } else {
        String _variable_23 = a.getVariable();
        boolean _operator_equals_23 = ObjectExtensions.operator_equals(_variable_23, "upsilon");
        _operator_or_16 = BooleanExtensions.operator_or(_operator_or_17, _operator_equals_23);
      }
      if (_operator_or_16) {
        _operator_or_15 = true;
      } else {
        String _variable_24 = a.getVariable();
        boolean _operator_equals_24 = ObjectExtensions.operator_equals(_variable_24, "phi");
        _operator_or_15 = BooleanExtensions.operator_or(_operator_or_16, _operator_equals_24);
      }
      if (_operator_or_15) {
        _operator_or_14 = true;
      } else {
        String _variable_25 = a.getVariable();
        boolean _operator_equals_25 = ObjectExtensions.operator_equals(_variable_25, "varphi");
        _operator_or_14 = BooleanExtensions.operator_or(_operator_or_15, _operator_equals_25);
      }
      if (_operator_or_14) {
        _operator_or_13 = true;
      } else {
        String _variable_26 = a.getVariable();
        boolean _operator_equals_26 = ObjectExtensions.operator_equals(_variable_26, "chi");
        _operator_or_13 = BooleanExtensions.operator_or(_operator_or_14, _operator_equals_26);
      }
      if (_operator_or_13) {
        _operator_or_12 = true;
      } else {
        String _variable_27 = a.getVariable();
        boolean _operator_equals_27 = ObjectExtensions.operator_equals(_variable_27, "psi");
        _operator_or_12 = BooleanExtensions.operator_or(_operator_or_13, _operator_equals_27);
      }
      if (_operator_or_12) {
        _operator_or_11 = true;
      } else {
        String _variable_28 = a.getVariable();
        boolean _operator_equals_28 = ObjectExtensions.operator_equals(_variable_28, "omega");
        _operator_or_11 = BooleanExtensions.operator_or(_operator_or_12, _operator_equals_28);
      }
      if (_operator_or_11) {
        _operator_or_10 = true;
      } else {
        String _variable_29 = a.getVariable();
        boolean _operator_equals_29 = ObjectExtensions.operator_equals(_variable_29, "Gamma");
        _operator_or_10 = BooleanExtensions.operator_or(_operator_or_11, _operator_equals_29);
      }
      if (_operator_or_10) {
        _operator_or_9 = true;
      } else {
        String _variable_30 = a.getVariable();
        boolean _operator_equals_30 = ObjectExtensions.operator_equals(_variable_30, "Delta");
        _operator_or_9 = BooleanExtensions.operator_or(_operator_or_10, _operator_equals_30);
      }
      if (_operator_or_9) {
        _operator_or_8 = true;
      } else {
        String _variable_31 = a.getVariable();
        boolean _operator_equals_31 = ObjectExtensions.operator_equals(_variable_31, "Theta");
        _operator_or_8 = BooleanExtensions.operator_or(_operator_or_9, _operator_equals_31);
      }
      if (_operator_or_8) {
        _operator_or_7 = true;
      } else {
        String _variable_32 = a.getVariable();
        boolean _operator_equals_32 = ObjectExtensions.operator_equals(_variable_32, "Lambda");
        _operator_or_7 = BooleanExtensions.operator_or(_operator_or_8, _operator_equals_32);
      }
      if (_operator_or_7) {
        _operator_or_6 = true;
      } else {
        String _variable_33 = a.getVariable();
        boolean _operator_equals_33 = ObjectExtensions.operator_equals(_variable_33, "Xi");
        _operator_or_6 = BooleanExtensions.operator_or(_operator_or_7, _operator_equals_33);
      }
      if (_operator_or_6) {
        _operator_or_5 = true;
      } else {
        String _variable_34 = a.getVariable();
        boolean _operator_equals_34 = ObjectExtensions.operator_equals(_variable_34, "Pi");
        _operator_or_5 = BooleanExtensions.operator_or(_operator_or_6, _operator_equals_34);
      }
      if (_operator_or_5) {
        _operator_or_4 = true;
      } else {
        String _variable_35 = a.getVariable();
        boolean _operator_equals_35 = ObjectExtensions.operator_equals(_variable_35, "Sigma");
        _operator_or_4 = BooleanExtensions.operator_or(_operator_or_5, _operator_equals_35);
      }
      if (_operator_or_4) {
        _operator_or_3 = true;
      } else {
        String _variable_36 = a.getVariable();
        boolean _operator_equals_36 = ObjectExtensions.operator_equals(_variable_36, "Upsilon");
        _operator_or_3 = BooleanExtensions.operator_or(_operator_or_4, _operator_equals_36);
      }
      if (_operator_or_3) {
        _operator_or_2 = true;
      } else {
        String _variable_37 = a.getVariable();
        boolean _operator_equals_37 = ObjectExtensions.operator_equals(_variable_37, "Phi");
        _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, _operator_equals_37);
      }
      if (_operator_or_2) {
        _operator_or_1 = true;
      } else {
        String _variable_38 = a.getVariable();
        boolean _operator_equals_38 = ObjectExtensions.operator_equals(_variable_38, "Psi");
        _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, _operator_equals_38);
      }
      if (_operator_or_1) {
        _operator_or = true;
      } else {
        String _variable_39 = a.getVariable();
        boolean _operator_equals_39 = ObjectExtensions.operator_equals(_variable_39, "Omega");
        _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_39);
      }
      if (_operator_or) {
        _builder.append("\\");
        _builder.newLine();
      }
    }
    String _variable_40 = a.getVariable();
    _builder.append(_variable_40, "");
    _builder.append(" = ");
    Formula _value = a.getValue();
    StringConcatenation _compileFormula = this.compileFormula(_value);
    _builder.append(_compileFormula, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileFormula(final Formula f) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _expression = f.getExpression();
    StringConcatenation _compileExpression = this.compileExpression(_expression);
    _builder.append(_compileExpression, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileMatrixFormula(final MatrixFormula f) {
    StringConcatenation _builder = new StringConcatenation();
    MatrixExpression _expression = f.getExpression();
    StringConcatenation _compileMatrixExpression = this.compileMatrixExpression(_expression);
    _builder.append(_compileMatrixExpression, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileMatrixAssignment(final MatrixAssignment a) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_or = false;
      boolean _operator_or_1 = false;
      boolean _operator_or_2 = false;
      boolean _operator_or_3 = false;
      boolean _operator_or_4 = false;
      boolean _operator_or_5 = false;
      boolean _operator_or_6 = false;
      boolean _operator_or_7 = false;
      boolean _operator_or_8 = false;
      boolean _operator_or_9 = false;
      boolean _operator_or_10 = false;
      boolean _operator_or_11 = false;
      boolean _operator_or_12 = false;
      boolean _operator_or_13 = false;
      boolean _operator_or_14 = false;
      boolean _operator_or_15 = false;
      boolean _operator_or_16 = false;
      boolean _operator_or_17 = false;
      boolean _operator_or_18 = false;
      boolean _operator_or_19 = false;
      boolean _operator_or_20 = false;
      boolean _operator_or_21 = false;
      boolean _operator_or_22 = false;
      boolean _operator_or_23 = false;
      boolean _operator_or_24 = false;
      boolean _operator_or_25 = false;
      boolean _operator_or_26 = false;
      boolean _operator_or_27 = false;
      boolean _operator_or_28 = false;
      boolean _operator_or_29 = false;
      boolean _operator_or_30 = false;
      boolean _operator_or_31 = false;
      boolean _operator_or_32 = false;
      boolean _operator_or_33 = false;
      boolean _operator_or_34 = false;
      boolean _operator_or_35 = false;
      boolean _operator_or_36 = false;
      boolean _operator_or_37 = false;
      boolean _operator_or_38 = false;
      String _variable = a.getVariable();
      boolean _operator_equals = ObjectExtensions.operator_equals(_variable, "alpha");
      if (_operator_equals) {
        _operator_or_38 = true;
      } else {
        String _variable_1 = a.getVariable();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_variable_1, "beta");
        _operator_or_38 = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or_38) {
        _operator_or_37 = true;
      } else {
        String _variable_2 = a.getVariable();
        boolean _operator_equals_2 = ObjectExtensions.operator_equals(_variable_2, "gamma");
        _operator_or_37 = BooleanExtensions.operator_or(_operator_or_38, _operator_equals_2);
      }
      if (_operator_or_37) {
        _operator_or_36 = true;
      } else {
        String _variable_3 = a.getVariable();
        boolean _operator_equals_3 = ObjectExtensions.operator_equals(_variable_3, "delta");
        _operator_or_36 = BooleanExtensions.operator_or(_operator_or_37, _operator_equals_3);
      }
      if (_operator_or_36) {
        _operator_or_35 = true;
      } else {
        String _variable_4 = a.getVariable();
        boolean _operator_equals_4 = ObjectExtensions.operator_equals(_variable_4, "epsilon");
        _operator_or_35 = BooleanExtensions.operator_or(_operator_or_36, _operator_equals_4);
      }
      if (_operator_or_35) {
        _operator_or_34 = true;
      } else {
        String _variable_5 = a.getVariable();
        boolean _operator_equals_5 = ObjectExtensions.operator_equals(_variable_5, "varepsilon");
        _operator_or_34 = BooleanExtensions.operator_or(_operator_or_35, _operator_equals_5);
      }
      if (_operator_or_34) {
        _operator_or_33 = true;
      } else {
        String _variable_6 = a.getVariable();
        boolean _operator_equals_6 = ObjectExtensions.operator_equals(_variable_6, "zeta");
        _operator_or_33 = BooleanExtensions.operator_or(_operator_or_34, _operator_equals_6);
      }
      if (_operator_or_33) {
        _operator_or_32 = true;
      } else {
        String _variable_7 = a.getVariable();
        boolean _operator_equals_7 = ObjectExtensions.operator_equals(_variable_7, "eta");
        _operator_or_32 = BooleanExtensions.operator_or(_operator_or_33, _operator_equals_7);
      }
      if (_operator_or_32) {
        _operator_or_31 = true;
      } else {
        String _variable_8 = a.getVariable();
        boolean _operator_equals_8 = ObjectExtensions.operator_equals(_variable_8, "theta");
        _operator_or_31 = BooleanExtensions.operator_or(_operator_or_32, _operator_equals_8);
      }
      if (_operator_or_31) {
        _operator_or_30 = true;
      } else {
        String _variable_9 = a.getVariable();
        boolean _operator_equals_9 = ObjectExtensions.operator_equals(_variable_9, "vartheta");
        _operator_or_30 = BooleanExtensions.operator_or(_operator_or_31, _operator_equals_9);
      }
      if (_operator_or_30) {
        _operator_or_29 = true;
      } else {
        String _variable_10 = a.getVariable();
        boolean _operator_equals_10 = ObjectExtensions.operator_equals(_variable_10, "gamma");
        _operator_or_29 = BooleanExtensions.operator_or(_operator_or_30, _operator_equals_10);
      }
      if (_operator_or_29) {
        _operator_or_28 = true;
      } else {
        String _variable_11 = a.getVariable();
        boolean _operator_equals_11 = ObjectExtensions.operator_equals(_variable_11, "kappa");
        _operator_or_28 = BooleanExtensions.operator_or(_operator_or_29, _operator_equals_11);
      }
      if (_operator_or_28) {
        _operator_or_27 = true;
      } else {
        String _variable_12 = a.getVariable();
        boolean _operator_equals_12 = ObjectExtensions.operator_equals(_variable_12, "lambda");
        _operator_or_27 = BooleanExtensions.operator_or(_operator_or_28, _operator_equals_12);
      }
      if (_operator_or_27) {
        _operator_or_26 = true;
      } else {
        String _variable_13 = a.getVariable();
        boolean _operator_equals_13 = ObjectExtensions.operator_equals(_variable_13, "mu");
        _operator_or_26 = BooleanExtensions.operator_or(_operator_or_27, _operator_equals_13);
      }
      if (_operator_or_26) {
        _operator_or_25 = true;
      } else {
        String _variable_14 = a.getVariable();
        boolean _operator_equals_14 = ObjectExtensions.operator_equals(_variable_14, "nu");
        _operator_or_25 = BooleanExtensions.operator_or(_operator_or_26, _operator_equals_14);
      }
      if (_operator_or_25) {
        _operator_or_24 = true;
      } else {
        String _variable_15 = a.getVariable();
        boolean _operator_equals_15 = ObjectExtensions.operator_equals(_variable_15, "xi");
        _operator_or_24 = BooleanExtensions.operator_or(_operator_or_25, _operator_equals_15);
      }
      if (_operator_or_24) {
        _operator_or_23 = true;
      } else {
        String _variable_16 = a.getVariable();
        boolean _operator_equals_16 = ObjectExtensions.operator_equals(_variable_16, "pi");
        _operator_or_23 = BooleanExtensions.operator_or(_operator_or_24, _operator_equals_16);
      }
      if (_operator_or_23) {
        _operator_or_22 = true;
      } else {
        String _variable_17 = a.getVariable();
        boolean _operator_equals_17 = ObjectExtensions.operator_equals(_variable_17, "varpi");
        _operator_or_22 = BooleanExtensions.operator_or(_operator_or_23, _operator_equals_17);
      }
      if (_operator_or_22) {
        _operator_or_21 = true;
      } else {
        String _variable_18 = a.getVariable();
        boolean _operator_equals_18 = ObjectExtensions.operator_equals(_variable_18, "rho");
        _operator_or_21 = BooleanExtensions.operator_or(_operator_or_22, _operator_equals_18);
      }
      if (_operator_or_21) {
        _operator_or_20 = true;
      } else {
        String _variable_19 = a.getVariable();
        boolean _operator_equals_19 = ObjectExtensions.operator_equals(_variable_19, "varrho");
        _operator_or_20 = BooleanExtensions.operator_or(_operator_or_21, _operator_equals_19);
      }
      if (_operator_or_20) {
        _operator_or_19 = true;
      } else {
        String _variable_20 = a.getVariable();
        boolean _operator_equals_20 = ObjectExtensions.operator_equals(_variable_20, "sigma");
        _operator_or_19 = BooleanExtensions.operator_or(_operator_or_20, _operator_equals_20);
      }
      if (_operator_or_19) {
        _operator_or_18 = true;
      } else {
        String _variable_21 = a.getVariable();
        boolean _operator_equals_21 = ObjectExtensions.operator_equals(_variable_21, "varsigma");
        _operator_or_18 = BooleanExtensions.operator_or(_operator_or_19, _operator_equals_21);
      }
      if (_operator_or_18) {
        _operator_or_17 = true;
      } else {
        String _variable_22 = a.getVariable();
        boolean _operator_equals_22 = ObjectExtensions.operator_equals(_variable_22, "tau");
        _operator_or_17 = BooleanExtensions.operator_or(_operator_or_18, _operator_equals_22);
      }
      if (_operator_or_17) {
        _operator_or_16 = true;
      } else {
        String _variable_23 = a.getVariable();
        boolean _operator_equals_23 = ObjectExtensions.operator_equals(_variable_23, "upsilon");
        _operator_or_16 = BooleanExtensions.operator_or(_operator_or_17, _operator_equals_23);
      }
      if (_operator_or_16) {
        _operator_or_15 = true;
      } else {
        String _variable_24 = a.getVariable();
        boolean _operator_equals_24 = ObjectExtensions.operator_equals(_variable_24, "phi");
        _operator_or_15 = BooleanExtensions.operator_or(_operator_or_16, _operator_equals_24);
      }
      if (_operator_or_15) {
        _operator_or_14 = true;
      } else {
        String _variable_25 = a.getVariable();
        boolean _operator_equals_25 = ObjectExtensions.operator_equals(_variable_25, "varphi");
        _operator_or_14 = BooleanExtensions.operator_or(_operator_or_15, _operator_equals_25);
      }
      if (_operator_or_14) {
        _operator_or_13 = true;
      } else {
        String _variable_26 = a.getVariable();
        boolean _operator_equals_26 = ObjectExtensions.operator_equals(_variable_26, "chi");
        _operator_or_13 = BooleanExtensions.operator_or(_operator_or_14, _operator_equals_26);
      }
      if (_operator_or_13) {
        _operator_or_12 = true;
      } else {
        String _variable_27 = a.getVariable();
        boolean _operator_equals_27 = ObjectExtensions.operator_equals(_variable_27, "psi");
        _operator_or_12 = BooleanExtensions.operator_or(_operator_or_13, _operator_equals_27);
      }
      if (_operator_or_12) {
        _operator_or_11 = true;
      } else {
        String _variable_28 = a.getVariable();
        boolean _operator_equals_28 = ObjectExtensions.operator_equals(_variable_28, "omega");
        _operator_or_11 = BooleanExtensions.operator_or(_operator_or_12, _operator_equals_28);
      }
      if (_operator_or_11) {
        _operator_or_10 = true;
      } else {
        String _variable_29 = a.getVariable();
        boolean _operator_equals_29 = ObjectExtensions.operator_equals(_variable_29, "Gamma");
        _operator_or_10 = BooleanExtensions.operator_or(_operator_or_11, _operator_equals_29);
      }
      if (_operator_or_10) {
        _operator_or_9 = true;
      } else {
        String _variable_30 = a.getVariable();
        boolean _operator_equals_30 = ObjectExtensions.operator_equals(_variable_30, "Delta");
        _operator_or_9 = BooleanExtensions.operator_or(_operator_or_10, _operator_equals_30);
      }
      if (_operator_or_9) {
        _operator_or_8 = true;
      } else {
        String _variable_31 = a.getVariable();
        boolean _operator_equals_31 = ObjectExtensions.operator_equals(_variable_31, "Theta");
        _operator_or_8 = BooleanExtensions.operator_or(_operator_or_9, _operator_equals_31);
      }
      if (_operator_or_8) {
        _operator_or_7 = true;
      } else {
        String _variable_32 = a.getVariable();
        boolean _operator_equals_32 = ObjectExtensions.operator_equals(_variable_32, "Lambda");
        _operator_or_7 = BooleanExtensions.operator_or(_operator_or_8, _operator_equals_32);
      }
      if (_operator_or_7) {
        _operator_or_6 = true;
      } else {
        String _variable_33 = a.getVariable();
        boolean _operator_equals_33 = ObjectExtensions.operator_equals(_variable_33, "Xi");
        _operator_or_6 = BooleanExtensions.operator_or(_operator_or_7, _operator_equals_33);
      }
      if (_operator_or_6) {
        _operator_or_5 = true;
      } else {
        String _variable_34 = a.getVariable();
        boolean _operator_equals_34 = ObjectExtensions.operator_equals(_variable_34, "Pi");
        _operator_or_5 = BooleanExtensions.operator_or(_operator_or_6, _operator_equals_34);
      }
      if (_operator_or_5) {
        _operator_or_4 = true;
      } else {
        String _variable_35 = a.getVariable();
        boolean _operator_equals_35 = ObjectExtensions.operator_equals(_variable_35, "Sigma");
        _operator_or_4 = BooleanExtensions.operator_or(_operator_or_5, _operator_equals_35);
      }
      if (_operator_or_4) {
        _operator_or_3 = true;
      } else {
        String _variable_36 = a.getVariable();
        boolean _operator_equals_36 = ObjectExtensions.operator_equals(_variable_36, "Upsilon");
        _operator_or_3 = BooleanExtensions.operator_or(_operator_or_4, _operator_equals_36);
      }
      if (_operator_or_3) {
        _operator_or_2 = true;
      } else {
        String _variable_37 = a.getVariable();
        boolean _operator_equals_37 = ObjectExtensions.operator_equals(_variable_37, "Phi");
        _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, _operator_equals_37);
      }
      if (_operator_or_2) {
        _operator_or_1 = true;
      } else {
        String _variable_38 = a.getVariable();
        boolean _operator_equals_38 = ObjectExtensions.operator_equals(_variable_38, "Psi");
        _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, _operator_equals_38);
      }
      if (_operator_or_1) {
        _operator_or = true;
      } else {
        String _variable_39 = a.getVariable();
        boolean _operator_equals_39 = ObjectExtensions.operator_equals(_variable_39, "Omega");
        _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_39);
      }
      if (_operator_or) {
        _builder.append("\\");
        _builder.newLine();
      }
    }
    String _variable_40 = a.getVariable();
    _builder.append(_variable_40, "");
    _builder.append(" = ");
    MatrixFormula _value = a.getValue();
    StringConcatenation _compileMatrixFormula = this.compileMatrixFormula(_value);
    _builder.append(_compileMatrixFormula, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileFunction(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_or = false;
      boolean _operator_or_1 = false;
      boolean _operator_or_2 = false;
      boolean _operator_or_3 = false;
      boolean _operator_or_4 = false;
      boolean _operator_or_5 = false;
      boolean _operator_or_6 = false;
      boolean _operator_or_7 = false;
      boolean _operator_or_8 = false;
      boolean _operator_or_9 = false;
      boolean _operator_or_10 = false;
      boolean _operator_or_11 = false;
      boolean _operator_or_12 = false;
      boolean _operator_or_13 = false;
      boolean _operator_or_14 = false;
      boolean _operator_or_15 = false;
      boolean _operator_or_16 = false;
      boolean _operator_or_17 = false;
      boolean _operator_or_18 = false;
      boolean _operator_or_19 = false;
      boolean _operator_or_20 = false;
      boolean _operator_or_21 = false;
      boolean _operator_or_22 = false;
      boolean _operator_or_23 = false;
      boolean _operator_or_24 = false;
      boolean _operator_or_25 = false;
      boolean _operator_or_26 = false;
      boolean _operator_or_27 = false;
      boolean _operator_or_28 = false;
      boolean _operator_or_29 = false;
      boolean _operator_or_30 = false;
      boolean _operator_or_31 = false;
      boolean _operator_or_32 = false;
      boolean _operator_or_33 = false;
      boolean _operator_or_34 = false;
      boolean _operator_or_35 = false;
      boolean _operator_or_36 = false;
      boolean _operator_or_37 = false;
      boolean _operator_or_38 = false;
      Expression _function = f.getFunction();
      String _name = _function.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "alpha");
      if (_operator_equals) {
        _operator_or_38 = true;
      } else {
        Expression _function_1 = f.getFunction();
        String _name_1 = _function_1.getName();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, "beta");
        _operator_or_38 = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or_38) {
        _operator_or_37 = true;
      } else {
        Expression _function_2 = f.getFunction();
        String _name_2 = _function_2.getName();
        boolean _operator_equals_2 = ObjectExtensions.operator_equals(_name_2, "gamma");
        _operator_or_37 = BooleanExtensions.operator_or(_operator_or_38, _operator_equals_2);
      }
      if (_operator_or_37) {
        _operator_or_36 = true;
      } else {
        Expression _function_3 = f.getFunction();
        String _name_3 = _function_3.getName();
        boolean _operator_equals_3 = ObjectExtensions.operator_equals(_name_3, "delta");
        _operator_or_36 = BooleanExtensions.operator_or(_operator_or_37, _operator_equals_3);
      }
      if (_operator_or_36) {
        _operator_or_35 = true;
      } else {
        Expression _function_4 = f.getFunction();
        String _name_4 = _function_4.getName();
        boolean _operator_equals_4 = ObjectExtensions.operator_equals(_name_4, "epsilon");
        _operator_or_35 = BooleanExtensions.operator_or(_operator_or_36, _operator_equals_4);
      }
      if (_operator_or_35) {
        _operator_or_34 = true;
      } else {
        Expression _function_5 = f.getFunction();
        String _name_5 = _function_5.getName();
        boolean _operator_equals_5 = ObjectExtensions.operator_equals(_name_5, "varepsilon");
        _operator_or_34 = BooleanExtensions.operator_or(_operator_or_35, _operator_equals_5);
      }
      if (_operator_or_34) {
        _operator_or_33 = true;
      } else {
        Expression _function_6 = f.getFunction();
        String _name_6 = _function_6.getName();
        boolean _operator_equals_6 = ObjectExtensions.operator_equals(_name_6, "zeta");
        _operator_or_33 = BooleanExtensions.operator_or(_operator_or_34, _operator_equals_6);
      }
      if (_operator_or_33) {
        _operator_or_32 = true;
      } else {
        Expression _function_7 = f.getFunction();
        String _name_7 = _function_7.getName();
        boolean _operator_equals_7 = ObjectExtensions.operator_equals(_name_7, "eta");
        _operator_or_32 = BooleanExtensions.operator_or(_operator_or_33, _operator_equals_7);
      }
      if (_operator_or_32) {
        _operator_or_31 = true;
      } else {
        Expression _function_8 = f.getFunction();
        String _name_8 = _function_8.getName();
        boolean _operator_equals_8 = ObjectExtensions.operator_equals(_name_8, "theta");
        _operator_or_31 = BooleanExtensions.operator_or(_operator_or_32, _operator_equals_8);
      }
      if (_operator_or_31) {
        _operator_or_30 = true;
      } else {
        Expression _function_9 = f.getFunction();
        String _name_9 = _function_9.getName();
        boolean _operator_equals_9 = ObjectExtensions.operator_equals(_name_9, "vartheta");
        _operator_or_30 = BooleanExtensions.operator_or(_operator_or_31, _operator_equals_9);
      }
      if (_operator_or_30) {
        _operator_or_29 = true;
      } else {
        Expression _function_10 = f.getFunction();
        String _name_10 = _function_10.getName();
        boolean _operator_equals_10 = ObjectExtensions.operator_equals(_name_10, "gamma");
        _operator_or_29 = BooleanExtensions.operator_or(_operator_or_30, _operator_equals_10);
      }
      if (_operator_or_29) {
        _operator_or_28 = true;
      } else {
        Expression _function_11 = f.getFunction();
        String _name_11 = _function_11.getName();
        boolean _operator_equals_11 = ObjectExtensions.operator_equals(_name_11, "kappa");
        _operator_or_28 = BooleanExtensions.operator_or(_operator_or_29, _operator_equals_11);
      }
      if (_operator_or_28) {
        _operator_or_27 = true;
      } else {
        Expression _function_12 = f.getFunction();
        String _name_12 = _function_12.getName();
        boolean _operator_equals_12 = ObjectExtensions.operator_equals(_name_12, "lambda");
        _operator_or_27 = BooleanExtensions.operator_or(_operator_or_28, _operator_equals_12);
      }
      if (_operator_or_27) {
        _operator_or_26 = true;
      } else {
        Expression _function_13 = f.getFunction();
        String _name_13 = _function_13.getName();
        boolean _operator_equals_13 = ObjectExtensions.operator_equals(_name_13, "mu");
        _operator_or_26 = BooleanExtensions.operator_or(_operator_or_27, _operator_equals_13);
      }
      if (_operator_or_26) {
        _operator_or_25 = true;
      } else {
        Expression _function_14 = f.getFunction();
        String _name_14 = _function_14.getName();
        boolean _operator_equals_14 = ObjectExtensions.operator_equals(_name_14, "nu");
        _operator_or_25 = BooleanExtensions.operator_or(_operator_or_26, _operator_equals_14);
      }
      if (_operator_or_25) {
        _operator_or_24 = true;
      } else {
        Expression _function_15 = f.getFunction();
        String _name_15 = _function_15.getName();
        boolean _operator_equals_15 = ObjectExtensions.operator_equals(_name_15, "xi");
        _operator_or_24 = BooleanExtensions.operator_or(_operator_or_25, _operator_equals_15);
      }
      if (_operator_or_24) {
        _operator_or_23 = true;
      } else {
        Expression _function_16 = f.getFunction();
        String _name_16 = _function_16.getName();
        boolean _operator_equals_16 = ObjectExtensions.operator_equals(_name_16, "pi");
        _operator_or_23 = BooleanExtensions.operator_or(_operator_or_24, _operator_equals_16);
      }
      if (_operator_or_23) {
        _operator_or_22 = true;
      } else {
        Expression _function_17 = f.getFunction();
        String _name_17 = _function_17.getName();
        boolean _operator_equals_17 = ObjectExtensions.operator_equals(_name_17, "varpi");
        _operator_or_22 = BooleanExtensions.operator_or(_operator_or_23, _operator_equals_17);
      }
      if (_operator_or_22) {
        _operator_or_21 = true;
      } else {
        Expression _function_18 = f.getFunction();
        String _name_18 = _function_18.getName();
        boolean _operator_equals_18 = ObjectExtensions.operator_equals(_name_18, "rho");
        _operator_or_21 = BooleanExtensions.operator_or(_operator_or_22, _operator_equals_18);
      }
      if (_operator_or_21) {
        _operator_or_20 = true;
      } else {
        Expression _function_19 = f.getFunction();
        String _name_19 = _function_19.getName();
        boolean _operator_equals_19 = ObjectExtensions.operator_equals(_name_19, "varrho");
        _operator_or_20 = BooleanExtensions.operator_or(_operator_or_21, _operator_equals_19);
      }
      if (_operator_or_20) {
        _operator_or_19 = true;
      } else {
        Expression _function_20 = f.getFunction();
        String _name_20 = _function_20.getName();
        boolean _operator_equals_20 = ObjectExtensions.operator_equals(_name_20, "sigma");
        _operator_or_19 = BooleanExtensions.operator_or(_operator_or_20, _operator_equals_20);
      }
      if (_operator_or_19) {
        _operator_or_18 = true;
      } else {
        Expression _function_21 = f.getFunction();
        String _name_21 = _function_21.getName();
        boolean _operator_equals_21 = ObjectExtensions.operator_equals(_name_21, "varsigma");
        _operator_or_18 = BooleanExtensions.operator_or(_operator_or_19, _operator_equals_21);
      }
      if (_operator_or_18) {
        _operator_or_17 = true;
      } else {
        Expression _function_22 = f.getFunction();
        String _name_22 = _function_22.getName();
        boolean _operator_equals_22 = ObjectExtensions.operator_equals(_name_22, "tau");
        _operator_or_17 = BooleanExtensions.operator_or(_operator_or_18, _operator_equals_22);
      }
      if (_operator_or_17) {
        _operator_or_16 = true;
      } else {
        Expression _function_23 = f.getFunction();
        String _name_23 = _function_23.getName();
        boolean _operator_equals_23 = ObjectExtensions.operator_equals(_name_23, "upsilon");
        _operator_or_16 = BooleanExtensions.operator_or(_operator_or_17, _operator_equals_23);
      }
      if (_operator_or_16) {
        _operator_or_15 = true;
      } else {
        Expression _function_24 = f.getFunction();
        String _name_24 = _function_24.getName();
        boolean _operator_equals_24 = ObjectExtensions.operator_equals(_name_24, "phi");
        _operator_or_15 = BooleanExtensions.operator_or(_operator_or_16, _operator_equals_24);
      }
      if (_operator_or_15) {
        _operator_or_14 = true;
      } else {
        Expression _function_25 = f.getFunction();
        String _name_25 = _function_25.getName();
        boolean _operator_equals_25 = ObjectExtensions.operator_equals(_name_25, "varphi");
        _operator_or_14 = BooleanExtensions.operator_or(_operator_or_15, _operator_equals_25);
      }
      if (_operator_or_14) {
        _operator_or_13 = true;
      } else {
        Expression _function_26 = f.getFunction();
        String _name_26 = _function_26.getName();
        boolean _operator_equals_26 = ObjectExtensions.operator_equals(_name_26, "chi");
        _operator_or_13 = BooleanExtensions.operator_or(_operator_or_14, _operator_equals_26);
      }
      if (_operator_or_13) {
        _operator_or_12 = true;
      } else {
        Expression _function_27 = f.getFunction();
        String _name_27 = _function_27.getName();
        boolean _operator_equals_27 = ObjectExtensions.operator_equals(_name_27, "psi");
        _operator_or_12 = BooleanExtensions.operator_or(_operator_or_13, _operator_equals_27);
      }
      if (_operator_or_12) {
        _operator_or_11 = true;
      } else {
        Expression _function_28 = f.getFunction();
        String _name_28 = _function_28.getName();
        boolean _operator_equals_28 = ObjectExtensions.operator_equals(_name_28, "omega");
        _operator_or_11 = BooleanExtensions.operator_or(_operator_or_12, _operator_equals_28);
      }
      if (_operator_or_11) {
        _operator_or_10 = true;
      } else {
        Expression _function_29 = f.getFunction();
        String _name_29 = _function_29.getName();
        boolean _operator_equals_29 = ObjectExtensions.operator_equals(_name_29, "Gamma");
        _operator_or_10 = BooleanExtensions.operator_or(_operator_or_11, _operator_equals_29);
      }
      if (_operator_or_10) {
        _operator_or_9 = true;
      } else {
        Expression _function_30 = f.getFunction();
        String _name_30 = _function_30.getName();
        boolean _operator_equals_30 = ObjectExtensions.operator_equals(_name_30, "Delta");
        _operator_or_9 = BooleanExtensions.operator_or(_operator_or_10, _operator_equals_30);
      }
      if (_operator_or_9) {
        _operator_or_8 = true;
      } else {
        Expression _function_31 = f.getFunction();
        String _name_31 = _function_31.getName();
        boolean _operator_equals_31 = ObjectExtensions.operator_equals(_name_31, "Theta");
        _operator_or_8 = BooleanExtensions.operator_or(_operator_or_9, _operator_equals_31);
      }
      if (_operator_or_8) {
        _operator_or_7 = true;
      } else {
        Expression _function_32 = f.getFunction();
        String _name_32 = _function_32.getName();
        boolean _operator_equals_32 = ObjectExtensions.operator_equals(_name_32, "Lambda");
        _operator_or_7 = BooleanExtensions.operator_or(_operator_or_8, _operator_equals_32);
      }
      if (_operator_or_7) {
        _operator_or_6 = true;
      } else {
        Expression _function_33 = f.getFunction();
        String _name_33 = _function_33.getName();
        boolean _operator_equals_33 = ObjectExtensions.operator_equals(_name_33, "Xi");
        _operator_or_6 = BooleanExtensions.operator_or(_operator_or_7, _operator_equals_33);
      }
      if (_operator_or_6) {
        _operator_or_5 = true;
      } else {
        Expression _function_34 = f.getFunction();
        String _name_34 = _function_34.getName();
        boolean _operator_equals_34 = ObjectExtensions.operator_equals(_name_34, "Pi");
        _operator_or_5 = BooleanExtensions.operator_or(_operator_or_6, _operator_equals_34);
      }
      if (_operator_or_5) {
        _operator_or_4 = true;
      } else {
        Expression _function_35 = f.getFunction();
        String _name_35 = _function_35.getName();
        boolean _operator_equals_35 = ObjectExtensions.operator_equals(_name_35, "Sigma");
        _operator_or_4 = BooleanExtensions.operator_or(_operator_or_5, _operator_equals_35);
      }
      if (_operator_or_4) {
        _operator_or_3 = true;
      } else {
        Expression _function_36 = f.getFunction();
        String _name_36 = _function_36.getName();
        boolean _operator_equals_36 = ObjectExtensions.operator_equals(_name_36, "Upsilon");
        _operator_or_3 = BooleanExtensions.operator_or(_operator_or_4, _operator_equals_36);
      }
      if (_operator_or_3) {
        _operator_or_2 = true;
      } else {
        Expression _function_37 = f.getFunction();
        String _name_37 = _function_37.getName();
        boolean _operator_equals_37 = ObjectExtensions.operator_equals(_name_37, "Phi");
        _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, _operator_equals_37);
      }
      if (_operator_or_2) {
        _operator_or_1 = true;
      } else {
        Expression _function_38 = f.getFunction();
        String _name_38 = _function_38.getName();
        boolean _operator_equals_38 = ObjectExtensions.operator_equals(_name_38, "Psi");
        _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, _operator_equals_38);
      }
      if (_operator_or_1) {
        _operator_or = true;
      } else {
        Expression _function_39 = f.getFunction();
        String _name_39 = _function_39.getName();
        boolean _operator_equals_39 = ObjectExtensions.operator_equals(_name_39, "Omega");
        _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_39);
      }
      if (_operator_or) {
        _builder.append("\\");
        _builder.newLine();
      }
    }
    _builder.append("\\\\");
    Expression _function_40 = f.getFunction();
    String _name_40 = _function_40.getName();
    _builder.append(_name_40, "");
    _builder.newLineIfNotEmpty();
    _builder.append("(");
    {
      Expression _function_41 = f.getFunction();
      EList<Formula> _parameters = _function_41.getParameters();
      for(Formula param : _parameters) {
        _builder.newLineIfNotEmpty();
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(param, null);
          if (_operator_notEquals) {
            StringConcatenation _compileFormula = this.compileFormula(param);
            _builder.append(_compileFormula, "");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          Expression _function_42 = f.getFunction();
          EList<Formula> _parameters_1 = _function_42.getParameters();
          Formula _last = IterableExtensions.<Formula>last(_parameters_1);
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_last, param);
          if (_operator_notEquals_1) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Variable n) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_or = false;
      boolean _operator_or_1 = false;
      boolean _operator_or_2 = false;
      boolean _operator_or_3 = false;
      boolean _operator_or_4 = false;
      boolean _operator_or_5 = false;
      boolean _operator_or_6 = false;
      boolean _operator_or_7 = false;
      boolean _operator_or_8 = false;
      boolean _operator_or_9 = false;
      boolean _operator_or_10 = false;
      boolean _operator_or_11 = false;
      boolean _operator_or_12 = false;
      boolean _operator_or_13 = false;
      boolean _operator_or_14 = false;
      boolean _operator_or_15 = false;
      boolean _operator_or_16 = false;
      boolean _operator_or_17 = false;
      boolean _operator_or_18 = false;
      boolean _operator_or_19 = false;
      boolean _operator_or_20 = false;
      boolean _operator_or_21 = false;
      boolean _operator_or_22 = false;
      boolean _operator_or_23 = false;
      boolean _operator_or_24 = false;
      boolean _operator_or_25 = false;
      boolean _operator_or_26 = false;
      boolean _operator_or_27 = false;
      boolean _operator_or_28 = false;
      boolean _operator_or_29 = false;
      boolean _operator_or_30 = false;
      boolean _operator_or_31 = false;
      boolean _operator_or_32 = false;
      boolean _operator_or_33 = false;
      boolean _operator_or_34 = false;
      boolean _operator_or_35 = false;
      boolean _operator_or_36 = false;
      boolean _operator_or_37 = false;
      boolean _operator_or_38 = false;
      String _name = n.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, "alpha");
      if (_operator_equals) {
        _operator_or_38 = true;
      } else {
        String _name_1 = n.getName();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, "beta");
        _operator_or_38 = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or_38) {
        _operator_or_37 = true;
      } else {
        String _name_2 = n.getName();
        boolean _operator_equals_2 = ObjectExtensions.operator_equals(_name_2, "gamma");
        _operator_or_37 = BooleanExtensions.operator_or(_operator_or_38, _operator_equals_2);
      }
      if (_operator_or_37) {
        _operator_or_36 = true;
      } else {
        String _name_3 = n.getName();
        boolean _operator_equals_3 = ObjectExtensions.operator_equals(_name_3, "delta");
        _operator_or_36 = BooleanExtensions.operator_or(_operator_or_37, _operator_equals_3);
      }
      if (_operator_or_36) {
        _operator_or_35 = true;
      } else {
        String _name_4 = n.getName();
        boolean _operator_equals_4 = ObjectExtensions.operator_equals(_name_4, "epsilon");
        _operator_or_35 = BooleanExtensions.operator_or(_operator_or_36, _operator_equals_4);
      }
      if (_operator_or_35) {
        _operator_or_34 = true;
      } else {
        String _name_5 = n.getName();
        boolean _operator_equals_5 = ObjectExtensions.operator_equals(_name_5, "varepsilon");
        _operator_or_34 = BooleanExtensions.operator_or(_operator_or_35, _operator_equals_5);
      }
      if (_operator_or_34) {
        _operator_or_33 = true;
      } else {
        String _name_6 = n.getName();
        boolean _operator_equals_6 = ObjectExtensions.operator_equals(_name_6, "zeta");
        _operator_or_33 = BooleanExtensions.operator_or(_operator_or_34, _operator_equals_6);
      }
      if (_operator_or_33) {
        _operator_or_32 = true;
      } else {
        String _name_7 = n.getName();
        boolean _operator_equals_7 = ObjectExtensions.operator_equals(_name_7, "eta");
        _operator_or_32 = BooleanExtensions.operator_or(_operator_or_33, _operator_equals_7);
      }
      if (_operator_or_32) {
        _operator_or_31 = true;
      } else {
        String _name_8 = n.getName();
        boolean _operator_equals_8 = ObjectExtensions.operator_equals(_name_8, "theta");
        _operator_or_31 = BooleanExtensions.operator_or(_operator_or_32, _operator_equals_8);
      }
      if (_operator_or_31) {
        _operator_or_30 = true;
      } else {
        String _name_9 = n.getName();
        boolean _operator_equals_9 = ObjectExtensions.operator_equals(_name_9, "vartheta");
        _operator_or_30 = BooleanExtensions.operator_or(_operator_or_31, _operator_equals_9);
      }
      if (_operator_or_30) {
        _operator_or_29 = true;
      } else {
        String _name_10 = n.getName();
        boolean _operator_equals_10 = ObjectExtensions.operator_equals(_name_10, "gamma");
        _operator_or_29 = BooleanExtensions.operator_or(_operator_or_30, _operator_equals_10);
      }
      if (_operator_or_29) {
        _operator_or_28 = true;
      } else {
        String _name_11 = n.getName();
        boolean _operator_equals_11 = ObjectExtensions.operator_equals(_name_11, "kappa");
        _operator_or_28 = BooleanExtensions.operator_or(_operator_or_29, _operator_equals_11);
      }
      if (_operator_or_28) {
        _operator_or_27 = true;
      } else {
        String _name_12 = n.getName();
        boolean _operator_equals_12 = ObjectExtensions.operator_equals(_name_12, "lambda");
        _operator_or_27 = BooleanExtensions.operator_or(_operator_or_28, _operator_equals_12);
      }
      if (_operator_or_27) {
        _operator_or_26 = true;
      } else {
        String _name_13 = n.getName();
        boolean _operator_equals_13 = ObjectExtensions.operator_equals(_name_13, "mu");
        _operator_or_26 = BooleanExtensions.operator_or(_operator_or_27, _operator_equals_13);
      }
      if (_operator_or_26) {
        _operator_or_25 = true;
      } else {
        String _name_14 = n.getName();
        boolean _operator_equals_14 = ObjectExtensions.operator_equals(_name_14, "nu");
        _operator_or_25 = BooleanExtensions.operator_or(_operator_or_26, _operator_equals_14);
      }
      if (_operator_or_25) {
        _operator_or_24 = true;
      } else {
        String _name_15 = n.getName();
        boolean _operator_equals_15 = ObjectExtensions.operator_equals(_name_15, "xi");
        _operator_or_24 = BooleanExtensions.operator_or(_operator_or_25, _operator_equals_15);
      }
      if (_operator_or_24) {
        _operator_or_23 = true;
      } else {
        String _name_16 = n.getName();
        boolean _operator_equals_16 = ObjectExtensions.operator_equals(_name_16, "pi");
        _operator_or_23 = BooleanExtensions.operator_or(_operator_or_24, _operator_equals_16);
      }
      if (_operator_or_23) {
        _operator_or_22 = true;
      } else {
        String _name_17 = n.getName();
        boolean _operator_equals_17 = ObjectExtensions.operator_equals(_name_17, "varpi");
        _operator_or_22 = BooleanExtensions.operator_or(_operator_or_23, _operator_equals_17);
      }
      if (_operator_or_22) {
        _operator_or_21 = true;
      } else {
        String _name_18 = n.getName();
        boolean _operator_equals_18 = ObjectExtensions.operator_equals(_name_18, "rho");
        _operator_or_21 = BooleanExtensions.operator_or(_operator_or_22, _operator_equals_18);
      }
      if (_operator_or_21) {
        _operator_or_20 = true;
      } else {
        String _name_19 = n.getName();
        boolean _operator_equals_19 = ObjectExtensions.operator_equals(_name_19, "varrho");
        _operator_or_20 = BooleanExtensions.operator_or(_operator_or_21, _operator_equals_19);
      }
      if (_operator_or_20) {
        _operator_or_19 = true;
      } else {
        String _name_20 = n.getName();
        boolean _operator_equals_20 = ObjectExtensions.operator_equals(_name_20, "sigma");
        _operator_or_19 = BooleanExtensions.operator_or(_operator_or_20, _operator_equals_20);
      }
      if (_operator_or_19) {
        _operator_or_18 = true;
      } else {
        String _name_21 = n.getName();
        boolean _operator_equals_21 = ObjectExtensions.operator_equals(_name_21, "varsigma");
        _operator_or_18 = BooleanExtensions.operator_or(_operator_or_19, _operator_equals_21);
      }
      if (_operator_or_18) {
        _operator_or_17 = true;
      } else {
        String _name_22 = n.getName();
        boolean _operator_equals_22 = ObjectExtensions.operator_equals(_name_22, "tau");
        _operator_or_17 = BooleanExtensions.operator_or(_operator_or_18, _operator_equals_22);
      }
      if (_operator_or_17) {
        _operator_or_16 = true;
      } else {
        String _name_23 = n.getName();
        boolean _operator_equals_23 = ObjectExtensions.operator_equals(_name_23, "upsilon");
        _operator_or_16 = BooleanExtensions.operator_or(_operator_or_17, _operator_equals_23);
      }
      if (_operator_or_16) {
        _operator_or_15 = true;
      } else {
        String _name_24 = n.getName();
        boolean _operator_equals_24 = ObjectExtensions.operator_equals(_name_24, "phi");
        _operator_or_15 = BooleanExtensions.operator_or(_operator_or_16, _operator_equals_24);
      }
      if (_operator_or_15) {
        _operator_or_14 = true;
      } else {
        String _name_25 = n.getName();
        boolean _operator_equals_25 = ObjectExtensions.operator_equals(_name_25, "varphi");
        _operator_or_14 = BooleanExtensions.operator_or(_operator_or_15, _operator_equals_25);
      }
      if (_operator_or_14) {
        _operator_or_13 = true;
      } else {
        String _name_26 = n.getName();
        boolean _operator_equals_26 = ObjectExtensions.operator_equals(_name_26, "chi");
        _operator_or_13 = BooleanExtensions.operator_or(_operator_or_14, _operator_equals_26);
      }
      if (_operator_or_13) {
        _operator_or_12 = true;
      } else {
        String _name_27 = n.getName();
        boolean _operator_equals_27 = ObjectExtensions.operator_equals(_name_27, "psi");
        _operator_or_12 = BooleanExtensions.operator_or(_operator_or_13, _operator_equals_27);
      }
      if (_operator_or_12) {
        _operator_or_11 = true;
      } else {
        String _name_28 = n.getName();
        boolean _operator_equals_28 = ObjectExtensions.operator_equals(_name_28, "omega");
        _operator_or_11 = BooleanExtensions.operator_or(_operator_or_12, _operator_equals_28);
      }
      if (_operator_or_11) {
        _operator_or_10 = true;
      } else {
        String _name_29 = n.getName();
        boolean _operator_equals_29 = ObjectExtensions.operator_equals(_name_29, "Gamma");
        _operator_or_10 = BooleanExtensions.operator_or(_operator_or_11, _operator_equals_29);
      }
      if (_operator_or_10) {
        _operator_or_9 = true;
      } else {
        String _name_30 = n.getName();
        boolean _operator_equals_30 = ObjectExtensions.operator_equals(_name_30, "Delta");
        _operator_or_9 = BooleanExtensions.operator_or(_operator_or_10, _operator_equals_30);
      }
      if (_operator_or_9) {
        _operator_or_8 = true;
      } else {
        String _name_31 = n.getName();
        boolean _operator_equals_31 = ObjectExtensions.operator_equals(_name_31, "Theta");
        _operator_or_8 = BooleanExtensions.operator_or(_operator_or_9, _operator_equals_31);
      }
      if (_operator_or_8) {
        _operator_or_7 = true;
      } else {
        String _name_32 = n.getName();
        boolean _operator_equals_32 = ObjectExtensions.operator_equals(_name_32, "Lambda");
        _operator_or_7 = BooleanExtensions.operator_or(_operator_or_8, _operator_equals_32);
      }
      if (_operator_or_7) {
        _operator_or_6 = true;
      } else {
        String _name_33 = n.getName();
        boolean _operator_equals_33 = ObjectExtensions.operator_equals(_name_33, "Xi");
        _operator_or_6 = BooleanExtensions.operator_or(_operator_or_7, _operator_equals_33);
      }
      if (_operator_or_6) {
        _operator_or_5 = true;
      } else {
        String _name_34 = n.getName();
        boolean _operator_equals_34 = ObjectExtensions.operator_equals(_name_34, "Pi");
        _operator_or_5 = BooleanExtensions.operator_or(_operator_or_6, _operator_equals_34);
      }
      if (_operator_or_5) {
        _operator_or_4 = true;
      } else {
        String _name_35 = n.getName();
        boolean _operator_equals_35 = ObjectExtensions.operator_equals(_name_35, "Sigma");
        _operator_or_4 = BooleanExtensions.operator_or(_operator_or_5, _operator_equals_35);
      }
      if (_operator_or_4) {
        _operator_or_3 = true;
      } else {
        String _name_36 = n.getName();
        boolean _operator_equals_36 = ObjectExtensions.operator_equals(_name_36, "Upsilon");
        _operator_or_3 = BooleanExtensions.operator_or(_operator_or_4, _operator_equals_36);
      }
      if (_operator_or_3) {
        _operator_or_2 = true;
      } else {
        String _name_37 = n.getName();
        boolean _operator_equals_37 = ObjectExtensions.operator_equals(_name_37, "Phi");
        _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, _operator_equals_37);
      }
      if (_operator_or_2) {
        _operator_or_1 = true;
      } else {
        String _name_38 = n.getName();
        boolean _operator_equals_38 = ObjectExtensions.operator_equals(_name_38, "Psi");
        _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, _operator_equals_38);
      }
      if (_operator_or_1) {
        _operator_or = true;
      } else {
        String _name_39 = n.getName();
        boolean _operator_equals_39 = ObjectExtensions.operator_equals(_name_39, "Omega");
        _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_39);
      }
      if (_operator_or) {
        _builder.append("\\");
        _builder.newLine();
      }
    }
    String _name_40 = n.getName();
    _builder.append(_name_40, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Float n) {
    StringConcatenation _builder = new StringConcatenation();
    String _value = n.getValue();
    _builder.append(_value, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final MatrixElement e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_or = false;
      boolean _operator_or_1 = false;
      boolean _operator_or_2 = false;
      boolean _operator_or_3 = false;
      boolean _operator_or_4 = false;
      boolean _operator_or_5 = false;
      boolean _operator_or_6 = false;
      boolean _operator_or_7 = false;
      boolean _operator_or_8 = false;
      boolean _operator_or_9 = false;
      boolean _operator_or_10 = false;
      boolean _operator_or_11 = false;
      boolean _operator_or_12 = false;
      boolean _operator_or_13 = false;
      boolean _operator_or_14 = false;
      boolean _operator_or_15 = false;
      boolean _operator_or_16 = false;
      boolean _operator_or_17 = false;
      boolean _operator_or_18 = false;
      boolean _operator_or_19 = false;
      boolean _operator_or_20 = false;
      boolean _operator_or_21 = false;
      boolean _operator_or_22 = false;
      boolean _operator_or_23 = false;
      boolean _operator_or_24 = false;
      boolean _operator_or_25 = false;
      boolean _operator_or_26 = false;
      boolean _operator_or_27 = false;
      boolean _operator_or_28 = false;
      boolean _operator_or_29 = false;
      boolean _operator_or_30 = false;
      boolean _operator_or_31 = false;
      boolean _operator_or_32 = false;
      boolean _operator_or_33 = false;
      boolean _operator_or_34 = false;
      boolean _operator_or_35 = false;
      boolean _operator_or_36 = false;
      boolean _operator_or_37 = false;
      boolean _operator_or_38 = false;
      String _element = e.getElement();
      boolean _operator_equals = ObjectExtensions.operator_equals(_element, "alpha");
      if (_operator_equals) {
        _operator_or_38 = true;
      } else {
        String _element_1 = e.getElement();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_element_1, "beta");
        _operator_or_38 = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
      }
      if (_operator_or_38) {
        _operator_or_37 = true;
      } else {
        String _element_2 = e.getElement();
        boolean _operator_equals_2 = ObjectExtensions.operator_equals(_element_2, "gamma");
        _operator_or_37 = BooleanExtensions.operator_or(_operator_or_38, _operator_equals_2);
      }
      if (_operator_or_37) {
        _operator_or_36 = true;
      } else {
        String _element_3 = e.getElement();
        boolean _operator_equals_3 = ObjectExtensions.operator_equals(_element_3, "delta");
        _operator_or_36 = BooleanExtensions.operator_or(_operator_or_37, _operator_equals_3);
      }
      if (_operator_or_36) {
        _operator_or_35 = true;
      } else {
        String _element_4 = e.getElement();
        boolean _operator_equals_4 = ObjectExtensions.operator_equals(_element_4, "epsilon");
        _operator_or_35 = BooleanExtensions.operator_or(_operator_or_36, _operator_equals_4);
      }
      if (_operator_or_35) {
        _operator_or_34 = true;
      } else {
        String _element_5 = e.getElement();
        boolean _operator_equals_5 = ObjectExtensions.operator_equals(_element_5, "varepsilon");
        _operator_or_34 = BooleanExtensions.operator_or(_operator_or_35, _operator_equals_5);
      }
      if (_operator_or_34) {
        _operator_or_33 = true;
      } else {
        String _element_6 = e.getElement();
        boolean _operator_equals_6 = ObjectExtensions.operator_equals(_element_6, "zeta");
        _operator_or_33 = BooleanExtensions.operator_or(_operator_or_34, _operator_equals_6);
      }
      if (_operator_or_33) {
        _operator_or_32 = true;
      } else {
        String _element_7 = e.getElement();
        boolean _operator_equals_7 = ObjectExtensions.operator_equals(_element_7, "eta");
        _operator_or_32 = BooleanExtensions.operator_or(_operator_or_33, _operator_equals_7);
      }
      if (_operator_or_32) {
        _operator_or_31 = true;
      } else {
        String _element_8 = e.getElement();
        boolean _operator_equals_8 = ObjectExtensions.operator_equals(_element_8, "theta");
        _operator_or_31 = BooleanExtensions.operator_or(_operator_or_32, _operator_equals_8);
      }
      if (_operator_or_31) {
        _operator_or_30 = true;
      } else {
        String _element_9 = e.getElement();
        boolean _operator_equals_9 = ObjectExtensions.operator_equals(_element_9, "vartheta");
        _operator_or_30 = BooleanExtensions.operator_or(_operator_or_31, _operator_equals_9);
      }
      if (_operator_or_30) {
        _operator_or_29 = true;
      } else {
        String _element_10 = e.getElement();
        boolean _operator_equals_10 = ObjectExtensions.operator_equals(_element_10, "gamma");
        _operator_or_29 = BooleanExtensions.operator_or(_operator_or_30, _operator_equals_10);
      }
      if (_operator_or_29) {
        _operator_or_28 = true;
      } else {
        String _element_11 = e.getElement();
        boolean _operator_equals_11 = ObjectExtensions.operator_equals(_element_11, "kappa");
        _operator_or_28 = BooleanExtensions.operator_or(_operator_or_29, _operator_equals_11);
      }
      if (_operator_or_28) {
        _operator_or_27 = true;
      } else {
        String _element_12 = e.getElement();
        boolean _operator_equals_12 = ObjectExtensions.operator_equals(_element_12, "lambda");
        _operator_or_27 = BooleanExtensions.operator_or(_operator_or_28, _operator_equals_12);
      }
      if (_operator_or_27) {
        _operator_or_26 = true;
      } else {
        String _element_13 = e.getElement();
        boolean _operator_equals_13 = ObjectExtensions.operator_equals(_element_13, "mu");
        _operator_or_26 = BooleanExtensions.operator_or(_operator_or_27, _operator_equals_13);
      }
      if (_operator_or_26) {
        _operator_or_25 = true;
      } else {
        String _element_14 = e.getElement();
        boolean _operator_equals_14 = ObjectExtensions.operator_equals(_element_14, "nu");
        _operator_or_25 = BooleanExtensions.operator_or(_operator_or_26, _operator_equals_14);
      }
      if (_operator_or_25) {
        _operator_or_24 = true;
      } else {
        String _element_15 = e.getElement();
        boolean _operator_equals_15 = ObjectExtensions.operator_equals(_element_15, "xi");
        _operator_or_24 = BooleanExtensions.operator_or(_operator_or_25, _operator_equals_15);
      }
      if (_operator_or_24) {
        _operator_or_23 = true;
      } else {
        String _element_16 = e.getElement();
        boolean _operator_equals_16 = ObjectExtensions.operator_equals(_element_16, "pi");
        _operator_or_23 = BooleanExtensions.operator_or(_operator_or_24, _operator_equals_16);
      }
      if (_operator_or_23) {
        _operator_or_22 = true;
      } else {
        String _element_17 = e.getElement();
        boolean _operator_equals_17 = ObjectExtensions.operator_equals(_element_17, "varpi");
        _operator_or_22 = BooleanExtensions.operator_or(_operator_or_23, _operator_equals_17);
      }
      if (_operator_or_22) {
        _operator_or_21 = true;
      } else {
        String _element_18 = e.getElement();
        boolean _operator_equals_18 = ObjectExtensions.operator_equals(_element_18, "rho");
        _operator_or_21 = BooleanExtensions.operator_or(_operator_or_22, _operator_equals_18);
      }
      if (_operator_or_21) {
        _operator_or_20 = true;
      } else {
        String _element_19 = e.getElement();
        boolean _operator_equals_19 = ObjectExtensions.operator_equals(_element_19, "varrho");
        _operator_or_20 = BooleanExtensions.operator_or(_operator_or_21, _operator_equals_19);
      }
      if (_operator_or_20) {
        _operator_or_19 = true;
      } else {
        String _element_20 = e.getElement();
        boolean _operator_equals_20 = ObjectExtensions.operator_equals(_element_20, "sigma");
        _operator_or_19 = BooleanExtensions.operator_or(_operator_or_20, _operator_equals_20);
      }
      if (_operator_or_19) {
        _operator_or_18 = true;
      } else {
        String _element_21 = e.getElement();
        boolean _operator_equals_21 = ObjectExtensions.operator_equals(_element_21, "varsigma");
        _operator_or_18 = BooleanExtensions.operator_or(_operator_or_19, _operator_equals_21);
      }
      if (_operator_or_18) {
        _operator_or_17 = true;
      } else {
        String _element_22 = e.getElement();
        boolean _operator_equals_22 = ObjectExtensions.operator_equals(_element_22, "tau");
        _operator_or_17 = BooleanExtensions.operator_or(_operator_or_18, _operator_equals_22);
      }
      if (_operator_or_17) {
        _operator_or_16 = true;
      } else {
        String _element_23 = e.getElement();
        boolean _operator_equals_23 = ObjectExtensions.operator_equals(_element_23, "upsilon");
        _operator_or_16 = BooleanExtensions.operator_or(_operator_or_17, _operator_equals_23);
      }
      if (_operator_or_16) {
        _operator_or_15 = true;
      } else {
        String _element_24 = e.getElement();
        boolean _operator_equals_24 = ObjectExtensions.operator_equals(_element_24, "phi");
        _operator_or_15 = BooleanExtensions.operator_or(_operator_or_16, _operator_equals_24);
      }
      if (_operator_or_15) {
        _operator_or_14 = true;
      } else {
        String _element_25 = e.getElement();
        boolean _operator_equals_25 = ObjectExtensions.operator_equals(_element_25, "varphi");
        _operator_or_14 = BooleanExtensions.operator_or(_operator_or_15, _operator_equals_25);
      }
      if (_operator_or_14) {
        _operator_or_13 = true;
      } else {
        String _element_26 = e.getElement();
        boolean _operator_equals_26 = ObjectExtensions.operator_equals(_element_26, "chi");
        _operator_or_13 = BooleanExtensions.operator_or(_operator_or_14, _operator_equals_26);
      }
      if (_operator_or_13) {
        _operator_or_12 = true;
      } else {
        String _element_27 = e.getElement();
        boolean _operator_equals_27 = ObjectExtensions.operator_equals(_element_27, "psi");
        _operator_or_12 = BooleanExtensions.operator_or(_operator_or_13, _operator_equals_27);
      }
      if (_operator_or_12) {
        _operator_or_11 = true;
      } else {
        String _element_28 = e.getElement();
        boolean _operator_equals_28 = ObjectExtensions.operator_equals(_element_28, "omega");
        _operator_or_11 = BooleanExtensions.operator_or(_operator_or_12, _operator_equals_28);
      }
      if (_operator_or_11) {
        _operator_or_10 = true;
      } else {
        String _element_29 = e.getElement();
        boolean _operator_equals_29 = ObjectExtensions.operator_equals(_element_29, "Gamma");
        _operator_or_10 = BooleanExtensions.operator_or(_operator_or_11, _operator_equals_29);
      }
      if (_operator_or_10) {
        _operator_or_9 = true;
      } else {
        String _element_30 = e.getElement();
        boolean _operator_equals_30 = ObjectExtensions.operator_equals(_element_30, "Delta");
        _operator_or_9 = BooleanExtensions.operator_or(_operator_or_10, _operator_equals_30);
      }
      if (_operator_or_9) {
        _operator_or_8 = true;
      } else {
        String _element_31 = e.getElement();
        boolean _operator_equals_31 = ObjectExtensions.operator_equals(_element_31, "Theta");
        _operator_or_8 = BooleanExtensions.operator_or(_operator_or_9, _operator_equals_31);
      }
      if (_operator_or_8) {
        _operator_or_7 = true;
      } else {
        String _element_32 = e.getElement();
        boolean _operator_equals_32 = ObjectExtensions.operator_equals(_element_32, "Lambda");
        _operator_or_7 = BooleanExtensions.operator_or(_operator_or_8, _operator_equals_32);
      }
      if (_operator_or_7) {
        _operator_or_6 = true;
      } else {
        String _element_33 = e.getElement();
        boolean _operator_equals_33 = ObjectExtensions.operator_equals(_element_33, "Xi");
        _operator_or_6 = BooleanExtensions.operator_or(_operator_or_7, _operator_equals_33);
      }
      if (_operator_or_6) {
        _operator_or_5 = true;
      } else {
        String _element_34 = e.getElement();
        boolean _operator_equals_34 = ObjectExtensions.operator_equals(_element_34, "Pi");
        _operator_or_5 = BooleanExtensions.operator_or(_operator_or_6, _operator_equals_34);
      }
      if (_operator_or_5) {
        _operator_or_4 = true;
      } else {
        String _element_35 = e.getElement();
        boolean _operator_equals_35 = ObjectExtensions.operator_equals(_element_35, "Sigma");
        _operator_or_4 = BooleanExtensions.operator_or(_operator_or_5, _operator_equals_35);
      }
      if (_operator_or_4) {
        _operator_or_3 = true;
      } else {
        String _element_36 = e.getElement();
        boolean _operator_equals_36 = ObjectExtensions.operator_equals(_element_36, "Upsilon");
        _operator_or_3 = BooleanExtensions.operator_or(_operator_or_4, _operator_equals_36);
      }
      if (_operator_or_3) {
        _operator_or_2 = true;
      } else {
        String _element_37 = e.getElement();
        boolean _operator_equals_37 = ObjectExtensions.operator_equals(_element_37, "Phi");
        _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, _operator_equals_37);
      }
      if (_operator_or_2) {
        _operator_or_1 = true;
      } else {
        String _element_38 = e.getElement();
        boolean _operator_equals_38 = ObjectExtensions.operator_equals(_element_38, "Psi");
        _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, _operator_equals_38);
      }
      if (_operator_or_1) {
        _operator_or = true;
      } else {
        String _element_39 = e.getElement();
        boolean _operator_equals_39 = ObjectExtensions.operator_equals(_element_39, "Omega");
        _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_39);
      }
      if (_operator_or) {
        _builder.append("\\");
        _builder.newLine();
      }
    }
    String _element_40 = e.getElement();
    _builder.append(_element_40, "");
    _builder.append("_{");
    int _row = e.getRow();
    _builder.append(_row, "");
    _builder.append(",");
    int _column = e.getColumn();
    _builder.append(_column, "");
    _builder.append("}");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _compileFunction = this.compileFunction(f);
    _builder.append(_compileFunction, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final InBrackets op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Expression _inBrackets = op.getInBrackets();
    Expression _addition = _inBrackets.getAddition();
    StringConcatenation _compileExpression = this.compileExpression(_addition);
    _builder.append(_compileExpression, "");
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Addition op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append("+");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Subtraction op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append("-");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Multiplication op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append("*");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Division op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\frac{");
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append("}{");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append("}");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Modulo op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(" \\mod ");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Invert op) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Expression _expression = op.getExpression();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_expression, null);
      if (_operator_notEquals) {
        _builder.append(" (-");
        Expression _expression_1 = op.getExpression();
        StringConcatenation _compileExpression = this.compileExpression(_expression_1);
        _builder.append(_compileExpression, "");
        _builder.append(") ");
      }
    }
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Factorial op) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Expression _expression = op.getExpression();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_expression, null);
      if (_operator_notEquals) {
        _builder.append(" ");
        Expression _expression_1 = op.getExpression();
        StringConcatenation _compileExpression = this.compileExpression(_expression_1);
        _builder.append(_compileExpression, "");
        _builder.append("! ");
      }
    }
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Exponent op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append("^");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixVariable n) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = n.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final NewMatrix m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$$\\left(\\begin{array}{");
    _builder.newLine();
    {
      Matrix _matrix = m.getMatrix();
      EList<MatrixRow> _rows = _matrix.getRows();
      for(MatrixRow row : _rows) {
        _builder.append("c");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    int j = 0;
    _builder.newLineIfNotEmpty();
    {
      Matrix _matrix_1 = m.getMatrix();
      EList<MatrixRow> _rows_1 = _matrix_1.getRows();
      for(MatrixRow row_1 : _rows_1) {
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(row_1, null);
          if (_operator_notEquals) {
            int i = 0;
            _builder.newLineIfNotEmpty();
            {
              EList<String> _elements = row_1.getElements();
              for(String element : _elements) {
                {
                  boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(element, null);
                  if (_operator_notEquals_1) {
                    _builder.append(element, "");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  int _operator_plus = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
                  int _i = i = _operator_plus;
                  EList<String> _elements_1 = row_1.getElements();
                  int _size = _elements_1.size();
                  boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(((Integer)_i), ((Integer)_size));
                  if (_operator_notEquals_2) {
                    _builder.append("&");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)j), ((Integer)1));
          int _j = j = _operator_plus_1;
          Matrix _matrix_2 = m.getMatrix();
          EList<MatrixRow> _rows_2 = _matrix_2.getRows();
          int _size_1 = _rows_2.size();
          boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(((Integer)_j), ((Integer)_size_1));
          if (_operator_notEquals_3) {
            _builder.append("\\\\");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\\end{array}\\right)$$");
    _builder.newLine();
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final TransposeMatrix n) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = n.getName();
    _builder.append(_name, "");
    _builder.append("^T");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixInBrackets op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    MatrixExpression _inBrackets = op.getInBrackets();
    MatrixExpression _addition = _inBrackets.getAddition();
    StringConcatenation _compileMatrixExpression = this.compileMatrixExpression(_addition);
    _builder.append(_compileMatrixExpression, "");
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixAddition op) {
    StringConcatenation _builder = new StringConcatenation();
    MatrixExpression _left = op.getLeft();
    StringConcatenation _compileMatrixExpression = this.compileMatrixExpression(_left);
    _builder.append(_compileMatrixExpression, "");
    _builder.append("+");
    MatrixExpression _right = op.getRight();
    StringConcatenation _compileMatrixExpression_1 = this.compileMatrixExpression(_right);
    _builder.append(_compileMatrixExpression_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixSubtraction op) {
    StringConcatenation _builder = new StringConcatenation();
    MatrixExpression _left = op.getLeft();
    StringConcatenation _compileMatrixExpression = this.compileMatrixExpression(_left);
    _builder.append(_compileMatrixExpression, "");
    _builder.append("-");
    MatrixExpression _right = op.getRight();
    StringConcatenation _compileMatrixExpression_1 = this.compileMatrixExpression(_right);
    _builder.append(_compileMatrixExpression_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixMultiplication op) {
    StringConcatenation _builder = new StringConcatenation();
    {
      MatrixExpression _rightMatrix = op.getRightMatrix();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_rightMatrix, null);
      if (_operator_notEquals) {
        MatrixExpression _left = op.getLeft();
        StringConcatenation _compileMatrixExpression = this.compileMatrixExpression(_left);
        _builder.append(_compileMatrixExpression, "");
        _builder.append("*");
        MatrixExpression _rightMatrix_1 = op.getRightMatrix();
        StringConcatenation _compileMatrixExpression_1 = this.compileMatrixExpression(_rightMatrix_1);
        _builder.append(_compileMatrixExpression_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      Formula _rightScalar = op.getRightScalar();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_rightScalar, null);
      if (_operator_notEquals_1) {
        MatrixExpression _left_1 = op.getLeft();
        StringConcatenation _compileMatrixExpression_2 = this.compileMatrixExpression(_left_1);
        _builder.append(_compileMatrixExpression_2, "");
        _builder.append("*");
        Formula _rightScalar_1 = op.getRightScalar();
        StringConcatenation _compileFormula = this.compileFormula(_rightScalar_1);
        _builder.append(_compileFormula, "");
      }
    }
    return _builder;
  }
  
  public StringConcatenation compileExpression(final Expression op) {
    if ((op instanceof Addition)) {
      return _compileExpression((Addition)op);
    } else if ((op instanceof Division)) {
      return _compileExpression((Division)op);
    } else if ((op instanceof Exponent)) {
      return _compileExpression((Exponent)op);
    } else if ((op instanceof Factorial)) {
      return _compileExpression((Factorial)op);
    } else if ((op instanceof Float)) {
      return _compileExpression((Float)op);
    } else if ((op instanceof Function)) {
      return _compileExpression((Function)op);
    } else if ((op instanceof InBrackets)) {
      return _compileExpression((InBrackets)op);
    } else if ((op instanceof Invert)) {
      return _compileExpression((Invert)op);
    } else if ((op instanceof MatrixElement)) {
      return _compileExpression((MatrixElement)op);
    } else if ((op instanceof Modulo)) {
      return _compileExpression((Modulo)op);
    } else if ((op instanceof Multiplication)) {
      return _compileExpression((Multiplication)op);
    } else if ((op instanceof Subtraction)) {
      return _compileExpression((Subtraction)op);
    } else if ((op instanceof Variable)) {
      return _compileExpression((Variable)op);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(op).toString());
    }
  }
  
  public StringConcatenation compileMatrixExpression(final MatrixExpression op) {
    if ((op instanceof MatrixAddition)) {
      return _compileMatrixExpression((MatrixAddition)op);
    } else if ((op instanceof MatrixInBrackets)) {
      return _compileMatrixExpression((MatrixInBrackets)op);
    } else if ((op instanceof MatrixMultiplication)) {
      return _compileMatrixExpression((MatrixMultiplication)op);
    } else if ((op instanceof MatrixSubtraction)) {
      return _compileMatrixExpression((MatrixSubtraction)op);
    } else if ((op instanceof MatrixVariable)) {
      return _compileMatrixExpression((MatrixVariable)op);
    } else if ((op instanceof NewMatrix)) {
      return _compileMatrixExpression((NewMatrix)op);
    } else if ((op instanceof TransposeMatrix)) {
      return _compileMatrixExpression((TransposeMatrix)op);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(op).toString());
    }
  }
}