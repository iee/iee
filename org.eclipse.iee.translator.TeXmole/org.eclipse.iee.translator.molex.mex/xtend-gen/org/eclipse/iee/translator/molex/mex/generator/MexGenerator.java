package org.eclipse.iee.translator.molex.mex.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.iee.translator.molex.mex.mex.Addition;
import org.eclipse.iee.translator.molex.mex.mex.ClassFunction;
import org.eclipse.iee.translator.molex.mex.mex.ClassMember;
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
import org.eclipse.iee.translator.molex.mex.mex.MathName;
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
    Expression _function = funcDef.getFunction();
    MathName _name = _function.getName();
    StringConcatenation _compileName = this.compileName(_name);
    _builder.append(_compileName, "");
    _builder.append(" ( ");
    _builder.newLineIfNotEmpty();
    {
      Expression _function_1 = funcDef.getFunction();
      EList<Formula> _parameters = _function_1.getParameters();
      for(final Formula param : _parameters) {
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(param, null);
          if (_operator_notEquals) {
            StringConcatenation _compileFormula = this.compileFormula(param);
            _builder.append(_compileFormula, "");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          Expression _function_2 = funcDef.getFunction();
          EList<Formula> _parameters_1 = _function_2.getParameters();
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
    MathName _variable = a.getVariable();
    StringConcatenation _compileName = this.compileName(_variable);
    _builder.append(_compileName, "");
    _builder.append(" = ");
    Formula _value = a.getValue();
    StringConcatenation _compileFormula = this.compileFormula(_value);
    _builder.append(_compileFormula, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileName(final MathName name) {
    StringConcatenation _builder = new StringConcatenation();
    String _mathName = name.getMathName();
    String temp = _mathName;
    _builder.newLineIfNotEmpty();
    {
      boolean _contains = temp.contains("");
      if (_contains) {
      }
    }
    String _replaceAll = temp.replaceAll("alpha", "\\\\alpha");
    String _replaceAll_1 = _replaceAll.replaceAll("beta", "\\\\beta");
    String _replaceAll_2 = _replaceAll_1.replaceAll("delta", "\\\\delta");
    String _replaceAll_3 = _replaceAll_2.replaceAll("epsilon", "\\\\epsilon");
    String _replaceAll_4 = _replaceAll_3.replaceAll("zeta", "\\\\zeta");
    String _replaceAll_5 = _replaceAll_4.replaceAll("theta", "\\\\theta");
    String _replaceAll_6 = _replaceAll_5.replaceAll("gamma", "\\\\gamma");
    String _replaceAll_7 = _replaceAll_6.replaceAll("kappa", "\\\\kappa");
    String _replaceAll_8 = _replaceAll_7.replaceAll("lambda", "\\\\lambda");
    String _replaceAll_9 = _replaceAll_8.replaceAll("mu", "\\\\mu");
    String _replaceAll_10 = _replaceAll_9.replaceAll("nu", "\\\\nu");
    String _replaceAll_11 = _replaceAll_10.replaceAll("xi", "\\\\xi");
    String _replaceAll_12 = _replaceAll_11.replaceAll("pi", "\\\\pi");
    String _replaceAll_13 = _replaceAll_12.replaceAll("rho", "\\\\rho");
    String _replaceAll_14 = _replaceAll_13.replaceAll("sigma", "\\\\sigma");
    String _replaceAll_15 = _replaceAll_14.replaceAll("tau", "\\\\tau");
    String _replaceAll_16 = _replaceAll_15.replaceAll("upsilon", "\\\\upsilon");
    String _replaceAll_17 = _replaceAll_16.replaceAll("phi", "\\\\phi");
    String _replaceAll_18 = _replaceAll_17.replaceAll("chi", "\\\\chi");
    String _replaceAll_19 = _replaceAll_18.replaceAll("omega", "\\\\omega");
    String _replaceAll_20 = _replaceAll_19.replaceAll("Gamma", "\\\\Gamma");
    String _replaceAll_21 = _replaceAll_20.replaceAll("Delta", "\\\\Delta");
    String _replaceAll_22 = _replaceAll_21.replaceAll("Theta", "\\\\Theta");
    String _replaceAll_23 = _replaceAll_22.replaceAll("Lambda", "\\\\Lambda");
    String _replaceAll_24 = _replaceAll_23.replaceAll("Xi", "\\\\Xi");
    String _replaceAll_25 = _replaceAll_24.replaceAll("Pi", "\\\\Pi");
    String _replaceAll_26 = _replaceAll_25.replaceAll("Sigma", "\\\\Sigma");
    String _replaceAll_27 = _replaceAll_26.replaceAll("Upsilon", "\\\\Upsilon");
    String _replaceAll_28 = _replaceAll_27.replaceAll("Phi", "\\\\Phi");
    String _replaceAll_29 = _replaceAll_28.replaceAll("Psi", "\\\\Psi");
    String _replaceAll_30 = _replaceAll_29.replaceAll("Omega", "\\\\Omega");
    _builder.append(_replaceAll_30, "");
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
    MathName _variable = a.getVariable();
    StringConcatenation _compileName = this.compileName(_variable);
    _builder.append(_compileName, "");
    _builder.append(" = ");
    MatrixFormula _value = a.getValue();
    StringConcatenation _compileMatrixFormula = this.compileMatrixFormula(_value);
    _builder.append(_compileMatrixFormula, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileFunction(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _function = f.getFunction();
    MathName _name = _function.getName();
    StringConcatenation _compileName = this.compileName(_name);
    _builder.append(_compileName, "");
    _builder.newLineIfNotEmpty();
    _builder.append("(");
    {
      Expression _function_1 = f.getFunction();
      EList<Formula> _parameters = _function_1.getParameters();
      for(final Formula param : _parameters) {
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
          Expression _function_2 = f.getFunction();
          EList<Formula> _parameters_1 = _function_2.getParameters();
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
    MathName _name = n.getName();
    StringConcatenation _compileName = this.compileName(_name);
    _builder.append(_compileName, "");
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
    MathName _element = e.getElement();
    StringConcatenation _compileName = this.compileName(_element);
    _builder.append(_compileName, "");
    _builder.append("_{");
    Formula _row = e.getRow();
    StringConcatenation _compileFormula = this.compileFormula(_row);
    _builder.append(_compileFormula, "");
    _builder.append(",");
    Formula _column = e.getColumn();
    StringConcatenation _compileFormula_1 = this.compileFormula(_column);
    _builder.append(_compileFormula_1, "");
    _builder.append("}");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _compileFunction = this.compileFunction(f);
    _builder.append(_compileFunction, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final ClassFunction call) {
    StringConcatenation _builder = new StringConcatenation();
    MathName _class_ = call.getClass_();
    StringConcatenation _compileName = this.compileName(_class_);
    _builder.append(_compileName, "");
    _builder.append(".");
    Expression _function = call.getFunction();
    MathName _name = _function.getName();
    StringConcatenation _compileName_1 = this.compileName(_name);
    _builder.append(_compileName_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("(");
    {
      Expression _function_1 = call.getFunction();
      EList<Formula> _parameters = _function_1.getParameters();
      for(final Formula param : _parameters) {
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
          Expression _function_2 = call.getFunction();
          EList<Formula> _parameters_1 = _function_2.getParameters();
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
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final ClassMember call) {
    StringConcatenation _builder = new StringConcatenation();
    MathName _class_ = call.getClass_();
    StringConcatenation _compileName = this.compileName(_class_);
    _builder.append(_compileName, "");
    _builder.append(".");
    MathName _member = call.getMember();
    StringConcatenation _compileName_1 = this.compileName(_member);
    _builder.append(_compileName_1, "");
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
    _builder.append("^{");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append("}");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixVariable n) {
    StringConcatenation _builder = new StringConcatenation();
    MathName _name = n.getName();
    StringConcatenation _compileName = this.compileName(_name);
    _builder.append(_compileName, "");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final NewMatrix m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$$\\left(\\begin{array}{");
    _builder.newLine();
    {
      Matrix _matrix = m.getMatrix();
      EList<MatrixRow> _rows = _matrix.getRows();
      for(final MatrixRow row : _rows) {
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
      for(final MatrixRow row_1 : _rows_1) {
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(row_1, null);
          if (_operator_notEquals) {
            int i = 0;
            _builder.newLineIfNotEmpty();
            {
              EList<Formula> _elements = row_1.getElements();
              for(final Formula element : _elements) {
                {
                  boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(element, null);
                  if (_operator_notEquals_1) {
                    StringConcatenation _compileFormula = this.compileFormula(element);
                    _builder.append(_compileFormula, "");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  int _operator_plus = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
                  int _i = i = _operator_plus;
                  EList<Formula> _elements_1 = row_1.getElements();
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
    MathName _name = n.getName();
    StringConcatenation _compileName = this.compileName(_name);
    _builder.append(_compileName, "");
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
    } else if ((op instanceof ClassFunction)) {
      return _compileExpression((ClassFunction)op);
    } else if ((op instanceof ClassMember)) {
      return _compileExpression((ClassMember)op);
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