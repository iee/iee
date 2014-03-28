package org.eclipse.iee.pad.text.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.text.TextPart;
import org.osgi.service.component.annotations.Component;

@Component
public class TextPadFactory implements IPadFactory<TextPart> {

	@Override
	public Pad create(TextPart documentPart) {
		return new TextPad(documentPart);
	}

}
