package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.editor.core.pad.common.CollapseBeginPart;
import org.osgi.service.component.annotations.Component;

@Component
public class CollapseBeginPadFactory implements IPadFactory<CollapseBeginPart> {

	@Override
	public CollapseBeginPad create(CollapseBeginPart documentPart, IPadFactoryContext factoryContext) {
		CollapseBeginPad collapseBeginPad = new CollapseBeginPad();
		collapseBeginPad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return collapseBeginPad;
	}

}
