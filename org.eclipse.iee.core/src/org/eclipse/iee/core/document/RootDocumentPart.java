package org.eclipse.iee.core.document;

import java.util.List;

public class RootDocumentPart extends DocumentPart {

	private Document document;
	
	public RootDocumentPart(List<DocumentPart> children) {
		super(children);
	}

	void setDocument(Document document) {
		Document oldValue = this.document;
		this.document = document;
		getPropertyChangeSupport().firePropertyChange("document", oldValue, document);
	}
	
	public Document getDocument() {
		return document;
	}
	
}
