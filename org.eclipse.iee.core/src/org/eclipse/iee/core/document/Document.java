package org.eclipse.iee.core.document;

public class Document {

	private DocumentPart fRoot;

	public Document(DocumentPart root) {
		super();
		this.fRoot = root;
	}
	
	public DocumentPart getRoot() {
		return fRoot;
	}
	
	
}
