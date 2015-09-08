package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.editor.core.pad.common.CollapseEndPart;
import org.osgi.service.component.annotations.Component;

@Component
public class CollapseEndPadFactory implements IPadFactory<CollapseEndPart> {

	@Override
	public CollapseEndPad create(CollapseEndPart documentPart, IPadFactoryContext factoryContext) {
		CollapseEndPad collapseEndPad = new CollapseEndPad(IeeEditorPlugin.getDefault().getImageRegistry());
		collapseEndPad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return collapseEndPad;
	}

}
