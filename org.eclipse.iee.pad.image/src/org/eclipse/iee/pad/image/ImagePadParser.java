package org.eclipse.iee.pad.image;

import java.util.Map;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.parser.IPadParser;

/**
 * {@link IPadParser} implementation. Creates instance of image pad.
 */
public class ImagePadParser implements IPadParser {

	@Override
	public PadDocumentPart create(Map<String, String> padParams, String value) {
		ImagePart imagePad = new ImagePart();
		int width = padParams.get("width") != null ? Integer.parseInt(padParams.get("width")) : -1;
		int height = padParams.get("height") != null ? Integer.parseInt(padParams.get("height")) : -1;
		imagePad.setSize(width, height);
		imagePad.setId(padParams.get("id"));
		imagePad.setImagePath(value);
		return imagePad;
	}
	
	@Override
	public String getType() {
		return "Image";
	}

}