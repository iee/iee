package org.eclipse.iee.pad.text;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;

/**
 * {@link IPadWriter} implementation. Writes instance of text pad.
 */
public class TextPadWriter implements IPadWriter<TextPart> {

	@Override
	public String getType() {
		return "Text";
	}

	@Override
	public String getValue(TextPart part) {
		return part.getText();
	}

	@Override
	public Map<String, String> getParams(TextPart part) {
		return new HashMap<>();
	}
	
}