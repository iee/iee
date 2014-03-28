package org.eclipse.iee.core.document.writer;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;

public interface IDocumentWriter {

	public abstract <T extends PadDocumentPart> IPadWriter<T> getWriterSupport(
			T partType);

	public abstract <T extends PadDocumentPart> ISourceGenerator<T> getSourceGenerator(
			T part);

	public abstract String getPrologue();

	public abstract String getEpilogue();

	public abstract String writeInternalsToString(PadDocumentPart part,
			ISourceGeneratorContext context);

}