package org.eclipse.iee.core.document;

public class TextDocumentPart extends DocumentPart {

	private String type;

	private String text;

	public TextDocumentPart(String type, String text) {
		super();
		this.type = type;
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

}
