package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ITextLocation;

public class CopyCtx extends BaseCtx {

	public CopyCtx(ITextLocation from, ITextLocation to) {
		super(from, to);
	}

	private StringBuilder fSb = new StringBuilder();
	
	public void append(CharSequence str) {
		fSb.append(str);
	}
	
	public String getString() {
		return fSb.toString();
	}
	
}
