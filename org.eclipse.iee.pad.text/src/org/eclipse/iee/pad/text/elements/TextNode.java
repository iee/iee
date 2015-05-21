package org.eclipse.iee.pad.text.elements;

public class TextNode extends Node {

	private String text;

	public String getText() {
		return text;
	}

	public TextNode setText(String text) {
		this.text = text;
		return this;
	}
	
	@Override
	public boolean hasText() {
		return true;
	}
	
}
