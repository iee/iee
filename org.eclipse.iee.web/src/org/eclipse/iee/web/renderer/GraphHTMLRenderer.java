package org.eclipse.iee.web.renderer;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.eclipse.iee.document.api.IResultContainer;
import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.eclipse.iee.sample.graph.pad.GraphPad;
import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.iee.sample.graph.pad.model.GraphModel;
import org.jfree.chart.JFreeChart;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class GraphHTMLRenderer implements IHTMLRenderer<GraphPad> {

	private FormulaImageRenderer formulaImageRenderer;
	
	public GraphHTMLRenderer(FormulaImageRenderer formulaImageRenderer) {
		this.formulaImageRenderer = formulaImageRenderer;
	}
	
	@Override
	public void renderPad(GraphPad pad,
			IHTMLRendererContext context) throws IOException {
		
		Writer writer = context.getWriter();
		
		GraphModel model = pad.getModel();
		
		writer.append("<table>").append("<tr>").append("<td>");
		
		List<GraphElement> elements = model.getElements();
		for (int i = 0; i < elements.size(); i++) {
			writer.append("<div>");
			writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), "formula/" + i, new HashMap<String, String>())).append("' />");
			writer.append("</div>");
		}
		writer.append("</td>").append("<td>");
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), "graph", new HashMap<String, String>())).append("' />");
		writer.append("</td>").append("</tr>");
		writer.append("<tr>").append("<td>").append("</td>").append("<td style='text-align:center'>");
		writer.append("<img src='").append(context.createResourceURL(pad.getContainerID(), "variables", new HashMap<String, String>())).append("' />");
		writer.append("</td>").append("</tr>").append("</table>");
	}

	@Override
	public void renderResource(GraphPad pad, String resourceId, IResourceRenderContext context)
			throws IOException {
		if (resourceId.startsWith("formula/")) {
			String nStr = resourceId.replace("formula/", "");
			int number = Integer.parseInt(nStr);
			GraphModel model = pad.getModel();
			List<GraphElement> elements = model.getElements();
			GraphElement graphElement = elements.get(number);
			BufferedImage image = formulaImageRenderer.getFormulaImage(graphElement.getFunction(), java.awt.Color.black, null);
			writeImage(context, image);
		} else if ("graph".equals(resourceId)) {
			JFreeChart chart = pad.createChart();
			BufferedImage image = new BufferedImage(720, 300, BufferedImage.TYPE_4BYTE_ABGR);
			IResultContainer resultContainer = context.getResultContainer();
			pad.updateResult(resultContainer.getResult(pad.getContainerID()));
			Graphics2D graphics = image.createGraphics();
			chart.draw(graphics, new Rectangle2D.Double(0, 0, 720, 300));
			writeImage(context, image);
		} else if ("variables".equals(resourceId)) {
			GraphModel model = pad.getModel();
			StringBuilder sb = new StringBuilder();
			for (String variable : model.getVariables()) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(variable);
			}
			BufferedImage image = formulaImageRenderer.getFormulaImage(sb.toString(), java.awt.Color.black, null);
			writeImage(context, image);
		}
	}

	private void writeImage(IResourceRenderContext context, BufferedImage image)
			throws IOException {
		context.setContentType("image/png");
		OutputStream outputStream = context.getOutputStream();
		try {
			ImageIO.write(image, "png", outputStream);
		} finally {
			outputStream.close();
		}
	}

}
