package org.eclipse.iee.pad.text.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.pad.text.TextPart;
import org.osgi.service.component.annotations.Component;

@Component
public class TextPadFactory implements IPadFactory<TextPart> {

	@Override
	public TextPad create(TextPart documentPart, IPadFactoryContext factoryContext) {
		TextPad textPad = new TextPad(factoryContext.getRenderContext());
		textPad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return textPad;
	}
	
}
