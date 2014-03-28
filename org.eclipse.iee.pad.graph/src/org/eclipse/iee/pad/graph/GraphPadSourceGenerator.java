package org.eclipse.iee.pad.graph;

import java.util.List;

import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.osgi.service.component.annotations.Component;

@Component
public class GraphPadSourceGenerator implements ISourceGenerator<GraphPart> {

	@Override
	public String getSource(GraphPart part, ISourceGeneratorContext context) {

		GraphModel model = part.getModel();
		
		List<GraphElement> elements = model.getElements();
		List<String> variables = model.getVariables();
		StringBuilder generatedText = new StringBuilder();

		double minX = model.getMinX() != null ? model.getMinX() : 0;
		double maxX = model.getMaxX() != null ? model.getMaxX() : 1.0;
		
		generatedText.append("{");
		generatedText.append("StringBuilder result").append(" = new StringBuilder();");
		if (variables.size() > 0) {
			for (int i = 0; i < elements.size(); i++) {
				GraphElement graphElement = elements.get(i);
				String variable;
				if (i < variables.size()) {
					variable = variables.get(i);
				} else {
					variable = variables.get(variables.size() - 1);
				}
				if (variable != null && variable.length() > 0) {
					String function = graphElement.getFunction();
					if (function != null && function.trim().length() > 0) {
						String translateElement = context.translateFunction(function, part.getId());
						generatedText.append("StringBuilder sb").append(i).append(" = new StringBuilder();");
						generatedText.append("sb").append(i).append(".append(\"{\");");
						generatedText.append("for (double ").append(variable).append(" = ")
						.append(minX).append("; ").append(variable).append(" < ")
						.append(maxX)
						.append("; ").append(variable).append(" += Math.abs((")
						.append(minX).append(" - ")
						.append(maxX).append(") / ")
						.append(graphElement.getNumberOfPoints())
						.append(")) {");
						generatedText.append("double __grpVal = ").append(translateElement)
						.append(";");
						generatedText.append("sb").append(i).append(".append(\"{\").append(").append(variable).append(").append(\",\").append(__grpVal).append(\"},\");");
						generatedText.append("}");
						generatedText.append("sb").append(i).append(".append(\"}\");");
						generatedText.append("result.append(\"").append(i).append(": \" + ").append("sb").append(i).append(".toString()").append(");");
						generatedText.append("result.append(\"\\n\");");
					}
				}
			}
		}
		generatedText.append("org.eclipse.iee.core.EvaluationContextHolder.putResult(\"").append(part.getId()).append("\", result.toString());");
		generatedText.append("}");

		return generatedText.toString();
	}

}
