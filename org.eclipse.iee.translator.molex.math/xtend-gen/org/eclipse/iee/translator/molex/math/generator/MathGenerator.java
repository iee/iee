package org.eclipse.iee.translator.molex.math.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.iee.translator.molex.math.math.Addition;
import org.eclipse.iee.translator.molex.math.math.Assignment;
import org.eclipse.iee.translator.molex.math.math.Division;
import org.eclipse.iee.translator.molex.math.math.Exponent;
import org.eclipse.iee.translator.molex.math.math.Expression;
import org.eclipse.iee.translator.molex.math.math.Factorial;
import org.eclipse.iee.translator.molex.math.math.Float;
import org.eclipse.iee.translator.molex.math.math.Formula;
import org.eclipse.iee.translator.molex.math.math.Function;
import org.eclipse.iee.translator.molex.math.math.FunctionDefinition;
import org.eclipse.iee.translator.molex.math.math.Interval;
import org.eclipse.iee.translator.molex.math.math.Invert;
import org.eclipse.iee.translator.molex.math.math.MatrixDefinition;
import org.eclipse.iee.translator.molex.math.math.MatrixRow;
import org.eclipse.iee.translator.molex.math.math.Modulo;
import org.eclipse.iee.translator.molex.math.math.Multiplication;
import org.eclipse.iee.translator.molex.math.math.Statement;
import org.eclipse.iee.translator.molex.math.math.Subtraction;
import org.eclipse.iee.translator.molex.math.math.Variable;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.ResourceExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MathGenerator implements IGenerator {
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
  }
  
  public String generateText(final Resource resource) {
    {
      Iterable<EObject> _allContentsIterable = ResourceExtensions.allContentsIterable(resource);
      Iterable<Statement> _filter = IterableExtensions.<Statement>filter(_allContentsIterable, org.eclipse.iee.translator.molex.math.math.Statement.class);
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
      MatrixDefinition _matrixDefinition = s.getMatrixDefinition();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_matrixDefinition, null);
      if (_operator_notEquals_1) {
        MatrixDefinition _matrixDefinition_1 = s.getMatrixDefinition();
        StringConcatenation _compileMatrixDefinition = this.compileMatrixDefinition(_matrixDefinition_1);
        _builder.append(_compileMatrixDefinition, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      Assignment _assignment = s.getAssignment();
      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_assignment, null);
      if (_operator_notEquals_2) {
        Assignment _assignment_1 = s.getAssignment();
        StringConcatenation _compileAssignment = this.compileAssignment(_assignment_1);
        _builder.append(_compileAssignment, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      Formula _formula = s.getFormula();
      boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_formula, null);
      if (_operator_notEquals_3) {
        Formula _formula_1 = s.getFormula();
        StringConcatenation _compileFormula = this.compileFormula(_formula_1);
        _builder.append(_compileFormula, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation compileFunctionDefinition(final FunctionDefinition funcDef) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _function = funcDef.getFunction();
    String _name = _function.getName();
    _builder.append(_name, "");
    _builder.append(" ( ");
    _builder.newLineIfNotEmpty();
    {
      Expression _function_1 = funcDef.getFunction();
      EList<Formula> _parameters = _function_1.getParameters();
      for(final Formula param : _parameters) {
        _builder.append("(");
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(param, null);
          if (_operator_notEquals) {
            StringConcatenation _compileFormula = this.compileFormula(param);
            _builder.append(_compileFormula, "");
          }
        }
        _builder.append(")");
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
  
  public StringConcatenation compileAssignment(final Assignment a) {
    StringConcatenation _builder = new StringConcatenation();
    String _variable = a.getVariable();
    _builder.append(_variable, "");
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
  
  public StringConcatenation compileMatrixDefinition(final MatrixDefinition m) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("=");
    _builder.newLineIfNotEmpty();
    _builder.append("$$\\left(\\begin{array}{");
    _builder.newLine();
    {
      EList<MatrixRow> _rows = m.getRows();
      for(final MatrixRow row : _rows) {
        _builder.append("c");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    {
      EList<MatrixRow> _rows_1 = m.getRows();
      for(final MatrixRow row_1 : _rows_1) {
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(row_1, null);
          if (_operator_notEquals) {
            {
              EList<String> _elements = row_1.getElements();
              for(final String element : _elements) {
                {
                  boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(element, null);
                  if (_operator_notEquals_1) {
                    _builder.append(element, "");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  EList<String> _elements_1 = row_1.getElements();
                  String _last = IterableExtensions.<String>last(_elements_1);
                  boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_last, element);
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
          EList<MatrixRow> _rows_2 = m.getRows();
          MatrixRow _last_1 = IterableExtensions.<MatrixRow>last(_rows_2);
          boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_last_1, row_1);
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
  
  public StringConcatenation compileFunction(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\\\");
    Expression _function = f.getFunction();
    String _name = _function.getName();
    String _lowerCase = _name.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.newLineIfNotEmpty();
    {
      Expression _function_1 = f.getFunction();
      EList<Formula> _parameters = _function_1.getParameters();
      for(final Formula param : _parameters) {
        _builder.append("(");
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(param, null);
          if (_operator_notEquals) {
            StringConcatenation _compileFormula = this.compileFormula(param);
            _builder.append(_compileFormula, "");
          }
        }
        _builder.append(")");
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
      }
    }
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Variable n) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = n.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Float n) {
    StringConcatenation _builder = new StringConcatenation();
    String _value = n.getValue();
    _builder.append(_value, "");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _compileFunction = this.compileFunction(f);
    _builder.append(_compileFunction, "");
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
    _builder.append("\\\\frac{");
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
        _builder.append(" (-(");
        Expression _expression_1 = op.getExpression();
        StringConcatenation _compileExpression = this.compileExpression(_expression_1);
        _builder.append(_compileExpression, "");
        _builder.append(")) ");
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
  
  protected StringConcatenation _compileExpression(final Interval op) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_and = false;
      Expression _ceil = op.getCeil();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_ceil, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Expression _floor = op.getFloor();
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_floor, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
      }
      if (_operator_and) {
        String _openingBracket = op.getOpeningBracket();
        _builder.append(_openingBracket, "");
        _builder.append("(");
        Expression _ceil_1 = op.getCeil();
        StringConcatenation _compileExpression = this.compileExpression(_ceil_1);
        _builder.append(_compileExpression, "");
        _builder.append(")..(");
        Expression _floor_1 = op.getFloor();
        StringConcatenation _compileExpression_1 = this.compileExpression(_floor_1);
        _builder.append(_compileExpression_1, "");
        _builder.append(")");
        String _closingBracket = op.getClosingBracket();
        _builder.append(_closingBracket, "");
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
    } else if ((op instanceof Interval)) {
      return _compileExpression((Interval)op);
    } else if ((op instanceof Invert)) {
      return _compileExpression((Invert)op);
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
}