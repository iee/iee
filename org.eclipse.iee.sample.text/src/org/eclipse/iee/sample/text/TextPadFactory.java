package org.eclipse.iee.sample.text;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.text.pad.TextPad;

/**
 * {@link IPadFactory} implementation. Creates instance of text pad.
 */
public class TextPadFactory implements IPadFactory {

	@Override
	public Pad create(Map<String, String> padParams, String value) {
		TextPad textPad = new TextPad();
		textPad.setText(value);
		return textPad;
	}
	
	@Override
	public String getType() {
		return "Text";
	}
	
}