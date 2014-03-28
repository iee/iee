package org.eclipse.iee.web.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.eclipse.iee.pad.formula.FormulaPart;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class FormulaHTMLRenderer implements IHTMLRenderer<FormulaPart> {

	private FormulaImageRenderer formulaImageRenderer;
	
	@Override
	public void renderPad(FormulaPart pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<img src='").append(context.createResourceURL(pad.getId(), "formula", new HashMap<String, String>())).append("' />");
		String result = context.getResultContainer().getResult(pad.getId());
		if (result != null) {
			HashMap<String, String> params = new HashMap<String, String>();
			writer.append("<img src='").append(context.createResourceURL(pad.getId(), "result", params)).append("' />");
		}
	}

	@Override
	public void renderResource(FormulaPart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
		String text;
		if (!"result".equals(resourceId)) {
			text = pad.getFormula();
		} else {
			String result = context.getResultContainer().getResult(pad.getId());
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
	
	@Reference(unbind = "unbindFormulaImageRenderer", policy = ReferencePolicy.DYNAMIC)
	public void bindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = renderer;
	}
	
	public void unbindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = null;
	}

}
