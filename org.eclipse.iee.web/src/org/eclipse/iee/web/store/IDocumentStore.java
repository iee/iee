package org.eclipse.iee.web.store;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.iee.web.document.Document;

public interface IDocumentStore {

	Document getDocument(String bundle, String document) throws IOException;
	
	ClassLoader getDocumentClassLoader(String bundle, String document) throws IOException;
	
	InputStream getResourceAsStream(String bundle, String document, String resource) throws IOException;
	
}
