package org.eclipse.iee.pad.fem3d.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.fem3d.Fem3DPart;
import org.osgi.service.component.annotations.Component;

@Component
public class Fem3DPadFactory implements IPadFactory<Fem3DPart> {

	@Override
	public Pad<Fem3DPart> create(Fem3DPart documentPart) {
		return new Fem3DPad(documentPart);
	}

}
