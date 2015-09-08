package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.editor.core.pad.common.ProgressDocumentPart;
import org.osgi.service.component.annotations.Component;

@Component
public class ProgressPadFactory implements IPadFactory<ProgressDocumentPart> {

	@Override
	public ProgressPad create(ProgressDocumentPart documentPart, IPadFactoryContext factoryContext) {
		ProgressPad progressPad = new ProgressPad(IeeEditorPlugin.getDefault().getImageRegistry());
		progressPad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return progressPad;
	}

}
