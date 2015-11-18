package org.eclipse.iee.editor.core.pad.common.text;


public class TextInterval {

	private IEditorLocation from;
	
	private IEditorLocation to;

	public TextInterval(IEditorLocation from, IEditorLocation to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public IEditorLocation getFrom() {
		return from;
	}
	
	public IEditorLocation getTo() {
		return to;
	}
	
}
