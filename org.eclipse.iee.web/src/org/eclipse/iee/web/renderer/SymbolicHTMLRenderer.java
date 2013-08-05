package org.eclipse.iee.web.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.eclipse.iee.editor.core.utils.symbolic.SymbolicEngine;
import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.eclipse.iee.sample.formula.pad.SymbolicPad;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class SymbolicHTMLRenderer implements IHTMLRenderer<SymbolicPad> {

	private SymbolicEngine symbolicEngine;
	
	public SymbolicHTMLRenderer(SymbolicEngine symbolicEngine) {
		this.symbolicEngine = symbolicEngine;
	}

	@Override
	public void renderPad(SymbolicPad pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), "formula", new HashMap<String, String>())).append("' />");
		HashMap<String, String> params = new HashMap<String, String>();
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), "result", params)).append("' />");
	}

	@Override
	public void renderResource(SymbolicPad pad, String resourceId, IResourceRenderContext context)
			throws IOException {
		BufferedImage image;
		if (!"result".equals(resourceId)) {
			image = (BufferedImage) TeXFormula.createBufferedImage(SymbolicPad.translateToLatex(pad.getTranslatingExpression()),
					TeXConstants.STYLE_TEXT, 20,
					new java.awt.Color(63, 127, 95), null);
		} else {
			String variable = pad.getTranslatingExpression();
			char lastVariable = variable.charAt(variable.length() - 1);
			if (lastVariable == '=')
				variable = variable.substring(0, variable.lastIndexOf('='));
			String result = symbolicEngine.getOutput(variable);
			if (result == null) {
				result = "";
			}
			image = (BufferedImage) TeXFormula.createBufferedImage(SymbolicPad.translateToLatex(result),
					TeXConstants.STYLE_TEXT, 20,
					new java.awt.Color(63, 127, 95), null);
		}
		context.setContentType("image/png");
		OutputStream outputStream = context.getOutputStream();
		try {
			ImageIO.write(image, "png", outputStream);
		} finally {
			outputStream.close();
		}
	}

}
