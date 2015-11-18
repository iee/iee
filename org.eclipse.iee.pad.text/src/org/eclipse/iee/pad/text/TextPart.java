package org.eclipse.iee.pad.text;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.text.Document;

public class TextPart extends PadDocumentPart {

	private Document root;

	public Document getRoot() {
		if (root == null) {
			root = new Document();
		}
		return root;
	}

	public void setRoot(Document root) {
		this.root = root;
	}

	public TextPart copy() {
		TextPart clone = new TextPart();
		clone.setRoot(getRoot());
		return clone;
	}

}
