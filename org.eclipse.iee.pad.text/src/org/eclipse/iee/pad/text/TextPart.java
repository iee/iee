package org.eclipse.iee.pad.text;

import org.eclipse.iee.core.document.PadDocumentPart;

public class TextPart extends PadDocumentPart {

	private String fText;

	public String getText() {
		return fText != null ? fText : "";
	}

	public void setText(String text) {
		fText = text;
	}

	public TextPart copy() {
		TextPart clone = new TextPart();
		clone.setText(getText());
		return clone;
	}

}
