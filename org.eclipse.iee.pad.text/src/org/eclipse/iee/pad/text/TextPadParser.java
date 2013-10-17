package org.eclipse.iee.pad.text;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;

/**
 * {@link IPadParser} implementation. Creates instance of text pad.
 */
public class TextPadParser implements IPadParser {

	@Override
	public TextPart create(Map<String, String> padParams, String value) {
		TextPart textPad = new TextPart();
		textPad.setId(padParams.get("id"));
		textPad.setText(value);
		return textPad;
	}
	
	@Override
	public String getType() {
		return "Text";
	}
	
}