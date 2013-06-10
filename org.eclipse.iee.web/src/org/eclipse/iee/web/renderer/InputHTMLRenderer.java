package org.eclipse.iee.web.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.eclipse.iee.sample.formula.pad.InputPad;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class InputHTMLRenderer implements IHTMLRenderer<InputPad> {

	@Override
	public void renderPad(InputPad pad, Writer writer,
			IHTMLRendererContext context) throws IOException {
			
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), new HashMap<String, String>())).append("' />");
		if (!context.isEditMode()) {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("type", "result");
			writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), params)).append("' />");
		} else {
			writer.append("<input name='").append(pad.getContainerID()).append("' type='text' value='").append(getValue(pad, context)).append("'/>");
		}
	}

	@Override
	public void renderResource(InputPad pad, IResourceRenderContext context)
			throws IOException {
		BufferedImage image;
		if (!"result".equals(context.getRequest().getParameter("type"))) {
			image = (BufferedImage) TeXFormula.createBufferedImage(FormulaPad.translateToLatex(pad.getVariableExpression()),
					TeXConstants.STYLE_TEXT, 20,
					java.awt.Color.black, null);
		} else {
			String result = getValue(pad, context);
			image = (BufferedImage) TeXFormula.createBufferedImage(FormulaPad.translateToLatex(result),
					TeXConstants.STYLE_TEXT, 20,
					java.awt.Color.black, null);
		}
		context.getResponse().setContentType("image/png");
		ServletOutputStream outputStream = context.getResponse().getOutputStream();
		try {
			ImageIO.write(image, "png", outputStream);
		} finally {
			outputStream.close();
		}
	}

	private String getValue(InputPad pad, IHTMLRendererContext context) {
		String result = context.getParameterProvider().getParameterValue(pad.getContainerID());
		if (result == null) {
			result = pad.getDefaultValue();
		}
		return result;
	}

}
