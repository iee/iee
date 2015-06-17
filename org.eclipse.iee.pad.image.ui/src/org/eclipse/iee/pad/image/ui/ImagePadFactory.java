package org.eclipse.iee.pad.image.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.image.ImagePart;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("unused")
@Component
public class ImagePadFactory implements IPadFactory<ImagePart> {

	@Override
	public ImagePad create(ImagePart documentPart) {
		ImagePad imagePad = new ImagePad();
		imagePad.bindDocumentPart(DefaultObservableValue.fromValue(documentPart));
		return imagePad;
	}

}
