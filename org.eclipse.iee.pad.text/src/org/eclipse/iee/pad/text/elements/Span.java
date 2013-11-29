package org.eclipse.iee.pad.text.elements;

import java.awt.Color;

import com.google.common.base.Optional;

public class Span extends Element {

	private Boolean italic;
	
	private Boolean bold;
	
	private String font;
	
	private Integer fontSize;

	private Color fgColor;
	
	private Color bgColor;
	
	public Optional<Boolean> isItalic() {
		return Optional.fromNullable(italic);
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public Optional<Boolean> isBold() {
		return Optional.fromNullable(bold);
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public Optional<String> getFont() {
		return Optional.fromNullable(font);
	}

	public void setFont(String font) {
		this.font = font;
	}

	public Optional<Integer> getFontSize() {
		return Optional.fromNullable(fontSize);
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Optional<Color> getFgColor() {
		return Optional.fromNullable(fgColor);
	}

	public void setFgColor(Color fgColor) {
		this.fgColor = fgColor;
	}

	public Optional<Color> getBgColor() {
		return Optional.fromNullable(bgColor);
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
	
}
