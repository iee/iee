package org.eclipse.iee.pad.image;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.core.document.writer.IPadWriter;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadParser} implementation. Creates instance of image pad.
 */
@Component
public class ImagePadWriter implements IPadWriter<ImagePart> {

	@Override
	public String getType() {
		return "Image";
	}

	@Override
	public String getValue(ImagePart part) {
		return part.getImagePath();
	}

	@Override
	public Map<String, String> getParams(ImagePart part) {
		Map<String, String> params = new HashMap<>();
		if (part.getImageWidth() > 0) {
			params.put("width", String.valueOf(part.getImageWidth()));
		}
		if (part.getImageHeigth() > 0) {
			params.put("height", String.valueOf(part.getImageHeigth()));
		}
		return params;
	}

}