/**
 * 
 */
package org.eclipse.iee.pad.formula;

import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;
import org.osgi.service.component.annotations.Component;

/**
 * @author aefimchuk
 *
 */
@Component
public class FormulaSourceGenerator implements ISourceGenerator<FormulaPart> {

	@Override
	public String getSource(FormulaPart part, ISourceGeneratorContext context) {
		return context.translateFunction(part.getFormula(), part.getId());
	}

}
