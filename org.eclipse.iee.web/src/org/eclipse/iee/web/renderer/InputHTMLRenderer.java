package org.eclipse.iee.web.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.eclipse.iee.pad.formula.InputPart;

public class InputHTMLRenderer implements IHTMLRenderer<InputPart> {

	private FormulaImageRenderer formulaImageRenderer;
	
	public InputHTMLRenderer(FormulaImageRenderer formulaImageRenderer) {
		this.formulaImageRenderer = formulaImageRenderer;
	}
	
	@Override
	public void renderPad(InputPart pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<img src='").append(context.createResourceURL(pad.getId(), "formula", new HashMap<String, String>())).append("' />");
		if (!context.isEditMode()) {
			HashMap<String, String> params = new HashMap<String, String>();
			writer.append("<img src='").append(context.createResourceURL(pad.getId(), "result", params)).append("' />");
		} else {
			writer.append("<input name='").append(pad.getId()).append("' type='text' value='").append(getValue(pad, context)).append("'/>");
		}
	}

	@Override
	public void renderResource(InputPart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
		String text;
		if (!"result".equals(resourceId)) {
			text = pad.getVariable() + "=";
		} else {
			String result = getValue(pad, context);
			text = result;
		}
		BufferedImage image = (BufferedImage) formulaImageRenderer.getFormulaImage(text, java.awt.Color.black, null);
		context.setContentType("image/png");
		OutputStream outputStream = context.getOutputStream();
		try {
			ImageIO.write(image, "png", outputStream);
		} finally {
			outputStream.close();
		}
	}

	private String getValue(InputPart pad, IHTMLRendererContext context) {
		String result = context.getParameterProvider().getParameterValue(pad.getId());
		if (result == null) {
			result = pad.getDefaultValue();
		}
		return result;
	}

}
