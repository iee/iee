package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.common.ProgressDocumentPart;
import org.osgi.service.component.annotations.Component;

@Component
public class ProgressPadFactory implements IPadFactory<ProgressDocumentPart> {

	@Override
	public Pad<ProgressDocumentPart> create(ProgressDocumentPart documentPart) {
		return new ProgressPad(documentPart);
	}

}
