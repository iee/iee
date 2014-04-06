package org.eclipse.iee.core.document;

public class Document {

	private String fBundle;
	
	private String fName;
	
	private String fVersion;
	
	private RootDocumentPart fRoot;

	public Document(String bundle, String name, String version, RootDocumentPart root) {
		super();
		fBundle = bundle;
		fName = name;
		fRoot = root;
		fVersion = version;
		root.setDocument(this);
	}
	
	public DocumentPart getRoot() {
		return fRoot;
	}

	public String getBundle() {
		return fBundle;
	}

	public String getName() {
		return fName;
	}

	public String getVersion() {
		return fVersion;
	}
	
	
	
}
