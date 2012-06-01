package org.eclipse.iee.translator.jmole.math.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.iee.translator.jmole.math.math.Addition;
import org.eclipse.iee.translator.jmole.math.math.Division;
import org.eclipse.iee.translator.jmole.math.math.Exponent;
import org.eclipse.iee.translator.jmole.math.math.Expression;
import org.eclipse.iee.translator.jmole.math.math.Factorial;
import org.eclipse.iee.translator.jmole.math.math.Float;
import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.Function;
import org.eclipse.iee.translator.jmole.math.math.FunctionDefinition;
import org.eclipse.iee.translator.jmole.math.math.Invert;
import org.eclipse.iee.translator.jmole.math.math.Matrix;
import org.eclipse.iee.translator.jmole.math.math.MatrixAddition;
import org.eclipse.iee.translator.jmole.math.math.MatrixAssignment;
import org.eclipse.iee.translator.jmole.math.math.MatrixElement;
import org.eclipse.iee.translator.jmole.math.math.MatrixExpression;
import org.eclipse.iee.translator.jmole.math.math.MatrixFormula;
import org.eclipse.iee.translator.jmole.math.math.MatrixMultiplication;
import org.eclipse.iee.translator.jmole.math.math.MatrixRow;
import org.eclipse.iee.translator.jmole.math.math.MatrixSubtraction;
import org.eclipse.iee.translator.jmole.math.math.MatrixVariable;
import org.eclipse.iee.translator.jmole.math.math.Modulo;
import org.eclipse.iee.translator.jmole.math.math.Multiplication;
import org.eclipse.iee.translator.jmole.math.math.NewMatrix;
import org.eclipse.iee.translator.jmole.math.math.Statement;
import org.eclipse.iee.translator.jmole.math.math.Subtraction;
import org.eclipse.iee.translator.jmole.math.math.TransposeMatrix;
import org.eclipse.iee.translator.jmole.math.math.Variable;
import org.eclipse.iee.translator.jmole.math.math.VariableAssignment;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
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
      Iterable<Statement> _filter = IterableExtensions.<Statement>filter(_allContentsIterable, org.eclipse.iee.translator.jmole.math.math.Statement.class);
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
      VariableAssignment _variableAssignment = s.getVariableAssignment();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_variableAssignment, null);
      if (_operator_notEquals_1) {
        VariableAssignment _variableAssignment_1 = s.getVariableAssignment();
        StringConcatenation _compileVariableAssignment = this.compileVariableAssignment(_variableAssignment_1);
        _builder.append(_compileVariableAssignment, "");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      MatrixAssignment _matrixAssignment = s.getMatrixAssignment();
      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_matrixAssignment, null);
      if (_operator_notEquals_2) {
        MatrixAssignment _matrixAssignment_1 = s.getMatrixAssignment();
        StringConcatenation _compileMatrixAssignment = this.compileMatrixAssignment(_matrixAssignment_1);
        _builder.append(_compileMatrixAssignment, "");
        _builder.append(";");
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
        _builder.append(";");
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
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileFunctionDefinition(final FunctionDefinition funcDef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static double ");
    Expression _function = funcDef.getFunction();
    String _name = _function.getName();
    _builder.append(_name, "");
    _builder.append(" ( ");
    _builder.newLineIfNotEmpty();
    {
      Expression _function_1 = funcDef.getFunction();
      EList<Formula> _parameters = _function_1.getParameters();
      for(final Formula param : _parameters) {
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(param, null);
          if (_operator_notEquals) {
            _builder.append("double ");
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
    _builder.append(") ");
    _builder.newLineIfNotEmpty();
    _builder.append("{ ");
    {
      Formula _formula = funcDef.getFormula();
      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_formula, null);
      if (_operator_notEquals_2) {
        _builder.append(" return ");
        Formula _formula_1 = funcDef.getFormula();
        StringConcatenation _compileFormula_1 = this.compileFormula(_formula_1);
        _builder.append(_compileFormula_1, "");
        _builder.append(";");
      }
    }
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileVariableAssignment(final VariableAssignment a) {
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
    String _variable = a.getVariable();
    _builder.append(_variable, "");
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
    String _name = _function.getName();
    _builder.append(_name, "");
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
  
  protected StringConcatenation _compileExpression(final MatrixElement e) {
    StringConcatenation _builder = new StringConcatenation();
    String _element = e.getElement();
    _builder.append(_element, "");
    _builder.append(".get(");
    String _row = e.getRow();
    _builder.append(_row, "");
    _builder.append(",");
    String _column = e.getColumn();
    _builder.append(_column, "");
    _builder.append(")");
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
    _builder.append("(");
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(") + (");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Subtraction op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(") - (");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Multiplication op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(") * (");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Division op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(") / (");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Modulo op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(") % (");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append(")");
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
        _builder.append(" (");
        Expression _expression_1 = op.getExpression();
        StringConcatenation _compileExpression = this.compileExpression(_expression_1);
        _builder.append(_compileExpression, "");
        _builder.append(")! ");
      }
    }
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Exponent op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Math.pow((");
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append("),(");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.append("))");
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
    _builder.append("new Matrix(new double[][]");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    int j = 0;
    _builder.newLineIfNotEmpty();
    {
      Matrix _matrix = m.getMatrix();
      EList<MatrixRow> _rows = _matrix.getRows();
      for(final MatrixRow row : _rows) {
        {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(row, null);
          if (_operator_notEquals) {
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            int i = 0;
            _builder.newLineIfNotEmpty();
            {
              EList<String> _elements = row.getElements();
              for(final String element : _elements) {
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
                  EList<String> _elements_1 = row.getElements();
                  int _size = _elements_1.size();
                  boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(((Integer)_i), ((Integer)_size));
                  if (_operator_notEquals_2) {
                    _builder.append(",");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)j), ((Integer)1));
          int _j = j = _operator_plus_1;
          Matrix _matrix_1 = m.getMatrix();
          EList<MatrixRow> _rows_1 = _matrix_1.getRows();
          int _size_1 = _rows_1.size();
          boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(((Integer)_j), ((Integer)_size_1));
          if (_operator_notEquals_3) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("})");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final TransposeMatrix n) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = n.getName();
    _builder.append(_name, "");
    _builder.append(".transpose()");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixAddition op) {
    StringConcatenation _builder = new StringConcatenation();
    MatrixExpression _left = op.getLeft();
    StringConcatenation _compileMatrixExpression = this.compileMatrixExpression(_left);
    _builder.append(_compileMatrixExpression, "");
    _builder.append(".plus(");
    MatrixExpression _right = op.getRight();
    StringConcatenation _compileMatrixExpression_1 = this.compileMatrixExpression(_right);
    _builder.append(_compileMatrixExpression_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compileMatrixExpression(final MatrixSubtraction op) {
    StringConcatenation _builder = new StringConcatenation();
    MatrixExpression _left = op.getLeft();
    StringConcatenation _compileMatrixExpression = this.compileMatrixExpression(_left);
    _builder.append(_compileMatrixExpression, "");
    _builder.append(".minus(");
    MatrixExpression _right = op.getRight();
    StringConcatenation _compileMatrixExpression_1 = this.compileMatrixExpression(_right);
    _builder.append(_compileMatrixExpression_1, "");
    _builder.append(")");
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
        _builder.append(".times(");
        MatrixExpression _rightMatrix_1 = op.getRightMatrix();
        StringConcatenation _compileMatrixExpression_1 = this.compileMatrixExpression(_rightMatrix_1);
        _builder.append(_compileMatrixExpression_1, "");
        _builder.append(")");
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
        _builder.append(".times(");
        Formula _rightScalar_1 = op.getRightScalar();
        StringConcatenation _compileFormula = this.compileFormula(_rightScalar_1);
        _builder.append(_compileFormula, "");
        _builder.append(")");
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