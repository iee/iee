package org.eclipse.iee.pad.text.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.pad.text.TextPart;
import org.osgi.service.component.annotations.Component;

@Component
public class TextPadFactory implements IPadFactory<TextPart> {

	@Override
	public TextPad create(TextPart documentPart) {
		TextPad textPad = new TextPad();
		textPad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return textPad;
	}

}
