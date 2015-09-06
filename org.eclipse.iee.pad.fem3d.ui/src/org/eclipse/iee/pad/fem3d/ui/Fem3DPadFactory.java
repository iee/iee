package org.eclipse.iee.pad.fem3d.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.fem3d.Fem3DPart;
import org.osgi.service.component.annotations.Component;

@Component
public class Fem3DPadFactory implements IPadFactory<Fem3DPart> {

	@Override
	public Fem3DPad create(Fem3DPart documentPart, IPadFactoryContext factoryContext) {
		Fem3DPad fem3dPad = new Fem3DPad();
		fem3dPad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return fem3dPad;
	}

}
