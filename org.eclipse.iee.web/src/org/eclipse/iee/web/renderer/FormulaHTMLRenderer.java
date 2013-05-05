package org.eclipse.iee.web.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class FormulaHTMLRenderer implements IHTMLRenderer<FormulaPad> {

	@Override
	public void renderPad(FormulaPad pad, Writer writer,
			IHTMLRendererContext context) throws IOException {
			
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), new HashMap<String, String>())).append("' />");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("type", "result");
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), params)).append("' />");
	}

	@Override
	public void renderResource(FormulaPad pad, IResourceRenderContext context)
			throws IOException {
		BufferedImage image;
		if (!"result".equals(context.getRequest().getParameter("type"))) {
			image = (BufferedImage) TeXFormula.createBufferedImage(FormulaPad.translateToLatex(pad.getTranslatingExpression()),
					TeXConstants.STYLE_TEXT, 20,
					java.awt.Color.black, null);
		} else {
			String result = context.getResultContainer().getResult(pad.getContainerID());
			if (result == null) {
				result = "";
			}
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

}
