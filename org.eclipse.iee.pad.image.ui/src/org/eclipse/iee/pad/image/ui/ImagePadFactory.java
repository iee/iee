package org.eclipse.iee.pad.image.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.image.ImagePart;

public class ImagePadFactory implements IPadFactory<ImagePart> {

	@Override
	public Pad create(ImagePart documentPart) {
		return new ImagePad(documentPart);
	}

}
