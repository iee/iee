package org.eclipse.iee.core.document.parser;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.RootDocumentPart;

public interface IDocumentParser {

	public abstract RootDocumentPart parseDocument(InputStream is)
			throws IOException;

	public abstract PadDocumentPart parsePadPart(String content);

}