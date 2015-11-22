package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ITextLocation;

public class ReplaceCtx extends BaseCtx {

	private String fText;
	
	private boolean started = false;
	
	public ReplaceCtx(ITextLocation from, ITextLocation to, String text) {
		super(from, to);
		fText = text;
	}

	public String getText() {
		return fText;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

}
