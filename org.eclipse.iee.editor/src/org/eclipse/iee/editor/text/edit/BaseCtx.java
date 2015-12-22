package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.ITextLocation;

public class BaseCtx {

	private ITextLocation fFrom;
	
	private ITextLocation fTo;
	
	private CompositeCommand fCommand = new CompositeCommand();

	private boolean started = false;
	
	public BaseCtx(ITextLocation from, ITextLocation to) {
		fFrom = from;
		fTo = to;
	}

	public boolean isFrom(INode text) {
		return fFrom.getModel() == text;
	}

	public boolean isTo(INode text) {
		return fTo.getModel() == text;
	}

	public void append(IEditCommand editCommand) {
		fCommand.append(editCommand);
	}

	public ITextLocation getFrom() {
		return fFrom;
	}

	public ITextLocation getTo() {
		return fTo;
	}

	public CompositeCommand getCommand() {
		return fCommand;
	}
	
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

}