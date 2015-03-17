/**
 * 
 */
package org.eclipse.iee.editor.core.pad.common;

import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;
import org.osgi.service.component.annotations.Component;

@Component
public class ProgressSourceGenerator implements ISourceGenerator<ProgressDocumentPart> {

	@Override
	public String getSource(ProgressDocumentPart part, ISourceGeneratorContext context) {
		StringBuilder generatedText = new StringBuilder();
		generatedText.append("org.eclipse.iee.core.EvaluationContextHolder.putResult(\"status\", \"").append(part.getStatus()).append("\");");
		generatedText.append("org.eclipse.iee.core.EvaluationContextHolder.putResult(\"progress\", \"").append(part.getProgress()).append("\");");
		return generatedText.toString();
	}

}
