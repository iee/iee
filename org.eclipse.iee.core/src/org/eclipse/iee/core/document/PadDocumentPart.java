package org.eclipse.iee.core.document;

public abstract class PadDocumentPart extends DocumentPart {

	private String id;
	
	public PadDocumentPart() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public abstract PadDocumentPart copy();
	
}
