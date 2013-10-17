package org.eclipse.iee.core.store;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.iee.core.document.Document;

public interface IDocumentStore {

	Document getDocument(String bundle, String document) throws IOException;
	
	Class<?> getDocumentClass(String bundle, String document) throws IOException, ClassNotFoundException;
	
	InputStream getResourceAsStream(String bundle, String document, String resource) throws IOException;
	
}
