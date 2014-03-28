package org.eclipse.iee.core.document.parser;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.document.PadDocumentPart;

public interface IDocumentParser {

	public abstract DocumentPart parseDocument(InputStream is)
			throws IOException;

	public abstract PadDocumentPart parsePadPart(String content);

}