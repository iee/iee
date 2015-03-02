package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.common.CollapseEndPart;
import org.osgi.service.component.annotations.Component;

@Component
public class CollapseEndPadFactory implements IPadFactory<CollapseEndPart> {

	@Override
	public CollapseEndPad create(CollapseEndPart documentPart) {
		return new CollapseEndPad(documentPart);
	}

}
