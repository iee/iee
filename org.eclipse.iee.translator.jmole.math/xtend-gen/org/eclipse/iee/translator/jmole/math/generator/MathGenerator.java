package org.eclipse.iee.translator.jmole.math.generator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.iee.translator.jmole.math.math.Expression;
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
      Iterable<Expression> _filter = IterableExtensions.<Expression>filter(_allContentsIterable, org.eclipse.iee.translator.jmole.math.math.Expression.class);
      Iterable<Expression> expressions = _filter;
      StringConcatenation _compile = this.compile(expressions);
      String _string = _compile.toString();
      return _string;
    }
  }
  
  public StringConcatenation compile(final Iterable<Expression> expressions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class HelloWorld {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    {
      for(Expression e : expressions) {
        _builder.append("\t\t");
        _builder.append("System.out.println(\"Hello, ");
        String _string = e.toString();
        _builder.append(_string, "		");
        _builder.append("!\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}