package org.eclipse.iee.web.document;

import org.eclipse.iee.editor.core.pad.Pad;

public class PadDocumentPart extends DocumentPart {

	private Pad pad;

	public PadDocumentPart(Pad pad) {
		super();
		this.pad = pad;
	}

	public Pad getPad() {
		return pad;
	}

}
