package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ITextLocation;

public class ReplaceCtx extends BaseCtx {

	private String fText;
	
	public ReplaceCtx(ITextLocation from, ITextLocation to, String text) {
		super(from, to);
		fText = text;
	}

	public String getText() {
		return fText;
	}
	
}
