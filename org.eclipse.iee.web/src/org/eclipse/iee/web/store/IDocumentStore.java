package org.eclipse.iee.web.store;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.misc.Nullable;
import org.eclipse.iee.web.document.Document;

public interface IDocumentStore {

	@Nullable Document getDocument(String bundle, String document) throws IOException;
	
	Class<?> getDocumentClass(String bundle, String document) throws IOException, ClassNotFoundException;
	
	InputStream getResourceAsStream(String bundle, String document, String resource) throws IOException;
	
}
