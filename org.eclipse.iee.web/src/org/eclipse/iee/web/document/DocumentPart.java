package org.eclipse.iee.web.document;

import java.util.ArrayList;
import java.util.List;

public class DocumentPart {

	private List<DocumentPart> children;

	public DocumentPart() {
		this(new ArrayList<DocumentPart>());
	}
	
	public DocumentPart(List<DocumentPart> children) {
		super();
		this.children = children;
	}
	
	public List<DocumentPart> getChildren() {
		return children;
	}
	
}
