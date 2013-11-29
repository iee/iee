package org.eclipse.iee.pad.text;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.pad.text.elements.Node;

public class TextPart extends PadDocumentPart {

	private Node root;

	public Node getRoot() {
		if (root == null) {
			return new Node();
		}
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public TextPart copy() {
		TextPart clone = new TextPart();
		clone.setRoot(getRoot());
		return clone;
	}

}
