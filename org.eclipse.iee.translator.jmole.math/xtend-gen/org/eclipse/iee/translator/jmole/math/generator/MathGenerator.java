package org.eclipse.iee.translator.jmole.math.generator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.iee.translator.jmole.math.math.Expression;
import org.eclipse.iee.translator.jmole.math.math.Formula;
import org.eclipse.iee.translator.jmole.math.math.Mult;
import org.eclipse.iee.translator.jmole.math.math.NumberLiteral;
import org.eclipse.iee.translator.jmole.math.math.Plus;
import org.eclipse.iee.translator.jmole.math.math.Pow;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtend2.lib.ResourceExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MathGenerator implements IGenerator {
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
  }
  
  public String generateText(final Resource resource) {
    {
      Iterable<EObject> _allContentsIterable = ResourceExtensions.allContentsIterable(resource);
      Iterable<Formula> _filter = IterableExtensions.<Formula>filter(_allContentsIterable, org.eclipse.iee.translator.jmole.math.math.Formula.class);
      Iterable<Formula> formulas = _filter;
      boolean _isEmpty = IterableExtensions.isEmpty(formulas);
      if (_isEmpty) {
        return null;
      }
      Formula _head = IterableExtensions.<Formula>head(formulas);
      StringConcatenation _compileFormula = this.compileFormula(_head);
      String _string = _compileFormula.toString();
      return _string;
    }
  }
  
  public StringConcatenation compileFormula(final Formula f) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _expression = f.getExpression();
    StringConcatenation _compileExpression = this.compileExpression(_expression);
    _builder.append(_compileExpression, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final NumberLiteral n) {
    StringConcatenation _builder = new StringConcatenation();
    String _value = n.getValue();
    _builder.append(_value, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Plus op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(" PLUS ");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Mult op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = op.getLeft();
    StringConcatenation _compileExpression = this.compileExpression(_left);
    _builder.append(_compileExpression, "");
    _builder.append(" MINUS ");
    Expression _right = op.getRight();
    StringConcatenation _compileExpression_1 = this.compileExpression(_right);
    _builder.append(_compileExpression_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected StringConcatenation _compileExpression(final Pow op) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _base = op.getBase();
    StringConcatenation _compileExpression = this.compileExpression(_base);
    _builder.append(_compileExpression, "");
    _builder.append(" POWER ");
    Expression _power = op.getPower();
    StringConcatenation _compileExpression_1 = this.compileExpression(_power);
    _builder.append(_compileExpression_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation compileExpression(final Expression op) {
    if ((op instanceof Mult)) {
      return _compileExpression((Mult)op);
    } else if ((op instanceof NumberLiteral)) {
      return _compileExpression((NumberLiteral)op);
    } else if ((op instanceof Plus)) {
      return _compileExpression((Plus)op);
    } else if ((op instanceof Pow)) {
      return _compileExpression((Pow)op);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(op).toString());
    }
  }
}