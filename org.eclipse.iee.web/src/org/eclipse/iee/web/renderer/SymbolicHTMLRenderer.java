package org.eclipse.iee.web.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.eclipse.iee.pad.formula.SymbolicEngine;
import org.eclipse.iee.pad.formula.SymbolicPart;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class SymbolicHTMLRenderer implements IHTMLRenderer<SymbolicPart> {

	private SymbolicEngine symbolicEngine;
	
	private FormulaImageRenderer formulaImageRenderer;
	
	@Override
	public void renderPad(SymbolicPart pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<img src='").append(context.createResourceURL(pad.getId(), "formula", new HashMap<String, String>())).append("' />");
		HashMap<String, String> params = new HashMap<String, String>();
		writer.append("<img src='").append(context.createResourceURL(pad.getId(), "result", params)).append("' />");
	}

	@Override
	public void renderResource(SymbolicPart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
		String text;
		if (!"result".equals(resourceId)) {
			text = pad.getFormula();
		} else {
			String variable = pad.getFormula();
			char lastVariable = variable.charAt(variable.length() - 1);
			if (lastVariable == '=')
				variable = variable.substring(0, variable.lastIndexOf('='));
			String result = symbolicEngine.getOutput(variable);
			if (result == null) {
				result = "";
			}
			text = result;
		}
		BufferedImage image = formulaImageRenderer.getFormulaImage(text, new java.awt.Color(63, 127, 95), null);
		context.setContentType("image/png");
		OutputStream outputStream = context.getOutputStream();
		try {
			ImageIO.write(image, "png", outputStream);
		} finally {
			outputStream.close();
		}
	}
	
	@Reference(unbind = "unbindFormulaImageRenderer", policy = ReferencePolicy.DYNAMIC)
	public void bindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = renderer;
	}
	
	public void unbindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = null;
	}
	
	@Reference(unbind = "unbindSymbolicEngine", policy = ReferencePolicy.DYNAMIC)
	public void bindSymbolicEngine(SymbolicEngine engine) {
		symbolicEngine = engine;
	}
	
	public void unbindSymbolicEngine(SymbolicEngine engine) {
		symbolicEngine = null;
	}

}
