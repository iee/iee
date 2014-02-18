package org.eclipse.iee.core.document;

public class Document {

	private String fBundle;
	
	private String fName;
	
	private DocumentPart fRoot;

	public Document(String bundle, String name, DocumentPart root) {
		super();
		fBundle = bundle;
		fName = name;
		fRoot = root;
	}
	
	public DocumentPart getRoot() {
		return fRoot;
	}

	public String getBundle() {
		return fBundle;
	}

	public void setBundle(String bundle) {
		this.fBundle = bundle;
	}

	public String getName() {
		return fName;
	}

	public void setName(String name) {
		this.fName = name;
	}
	
	
	
}
