/**
 * 
 */
package org.eclipse.iee.pad.fem3d;

import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;
import org.osgi.service.component.annotations.Component;

/**
 * @author aefimchuk
 *
 */
@Component
public class Fem3DSourceGenerator implements ISourceGenerator<Fem3DPart> {

	@Override
	public String getSource(Fem3DPart part, ISourceGeneratorContext context) {
		String file = part.getId();
		StringBuilder generatedText = new StringBuilder();
		generatedText.append(part.getModelVariable()).append(".savePreview(\"").append(file).append("\");");
		return generatedText.toString();
	}

}
