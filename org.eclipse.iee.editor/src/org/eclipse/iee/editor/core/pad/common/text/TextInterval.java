package org.eclipse.iee.editor.core.pad.common.text;


public class TextInterval {

	private TextLocation from;
	
	private TextLocation to;

	public TextInterval(TextLocation from, TextLocation to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public TextLocation getFrom() {
		return from;
	}
	
	public TextLocation getTo() {
		return to;
	}
	
}
