package org.eclipse.iee.core.document.source;

import org.eclipse.iee.core.document.PadDocumentPart;

public interface ISourceGenerator<T extends PadDocumentPart> {

	public String getSource(T part, ISourceGeneratorContext context);
	
}
