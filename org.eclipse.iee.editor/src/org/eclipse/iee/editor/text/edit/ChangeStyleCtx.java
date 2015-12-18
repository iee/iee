package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ITextLocation;
import org.eclipse.iee.core.document.text.Span;

import com.google.common.base.Supplier;

public abstract class ChangeStyleCtx extends BaseCtx {

	private boolean started = false;
	
	public ChangeStyleCtx(ITextLocation from, ITextLocation to) {
		super(from, to);
	}

	public boolean isStarted() {
		return started;
	}
	
	public void setStarted(boolean started) {
		this.started = started;
	}

	protected abstract IEditCommand do_(Supplier<Span> supplier);
	
}
