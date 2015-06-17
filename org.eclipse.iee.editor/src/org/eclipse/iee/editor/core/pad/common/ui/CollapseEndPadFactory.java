package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.common.CollapseEndPart;
import org.osgi.service.component.annotations.Component;

@Component
public class CollapseEndPadFactory implements IPadFactory<CollapseEndPart> {

	@Override
	public CollapseEndPad create(CollapseEndPart documentPart) {
		CollapseEndPad collapseEndPad = new CollapseEndPad();
		collapseEndPad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return collapseEndPad;
	}

}
