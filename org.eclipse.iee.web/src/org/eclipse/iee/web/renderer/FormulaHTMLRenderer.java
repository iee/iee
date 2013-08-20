package org.eclipse.iee.web.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.eclipse.iee.sample.formula.pad.FormulaPad;

public class FormulaHTMLRenderer implements IHTMLRenderer<FormulaPad> {

	private FormulaImageRenderer formulaImageRenderer;
	
	public FormulaHTMLRenderer(FormulaImageRenderer formulaImageRenderer) {
		this.formulaImageRenderer = formulaImageRenderer;
	}

	@Override
	public void renderPad(FormulaPad pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), "formula", new HashMap<String, String>())).append("' />");
		String result = context.getResultContainer().getResult(pad.getContainerID());
		if (result != null) {
			HashMap<String, String> params = new HashMap<String, String>();
			writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), "result", params)).append("' />");
		}
	}

	@Override
	public void renderResource(FormulaPad pad, String resourceId, IResourceRenderContext context)
			throws IOException {
		String text;
		if (!"result".equals(resourceId)) {
			text = pad.getTranslatingExpression();
		} else {
			String result = context.getResultContainer().getResult(pad.getContainerID());
			if (result == null) {
				result = "";
			}
			text = result;
		}
		BufferedImage image = formulaImageRenderer.getFormulaImage(text, java.awt.Color.black, null);
		context.setContentType("image/png");
		OutputStream outputStream = context.getOutputStream();
		try {
			ImageIO.write(image, "png", outputStream);
		} finally {
			outputStream.close();
		}
	}

}
