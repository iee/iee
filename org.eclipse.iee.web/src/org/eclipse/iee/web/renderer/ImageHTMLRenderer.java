package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.eclipse.iee.pad.image.ImagePart;
import org.osgi.service.component.annotations.Component;

@Component
public class ImageHTMLRenderer implements IHTMLRenderer<ImagePart> {

	@Override
	public void renderPad(ImagePart pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<img src='").append(context.createResourceURL(pad.getId(), "image", new HashMap<String, String>())).append("' />");
	}

	@Override
	public void renderResource(ImagePart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
		InputStream is = context.getResourceAsStream("image/" + pad.getImagePath());
		context.setContentType("application/octet-stream");
		OutputStream outputStream = context.getOutputStream();
		try {
			IOUtils.copy(is, outputStream);
		} finally {
			is.close();
			outputStream.close();
		}
	}

}
