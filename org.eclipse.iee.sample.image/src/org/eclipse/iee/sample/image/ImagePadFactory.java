package org.eclipse.iee.sample.image;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.image.pad.ImagePad;

/**
 * {@link IPadFactory} implementation. Creates instance of image pad.
 */
public class ImagePadFactory implements IPadFactory {

	@Override
	public Pad create(Map<String, String> padParams, String value) {
		ImagePad imagePad;
		if (value.length() != 0) {
			imagePad = new ImagePad(ImagePad.STATE_IMAGE, value);
		} else {
			imagePad = new ImagePad();
		}
		int width = padParams.get("width") != null ? Integer.parseInt(padParams.get("width")) : -1;
		int height = padParams.get("height") != null ? Integer.parseInt(padParams.get("height")) : -1;
		imagePad.setSize(width, height);
		return imagePad;
	}
	
	@Override
	public String getType() {
		return "Image";
	}

}