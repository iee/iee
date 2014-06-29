package org.eclipse.iee.web.renderer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.utils.ArrayUtils;
import org.eclipse.iee.pad.graph.GraphPart;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.PaintUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class GraphHTMLRenderer implements IHTMLRenderer<GraphPart> {

	private FormulaImageRenderer formulaImageRenderer;
	
	@Override
	public void renderPad(GraphPart pad,
			IHTMLRendererContext context) throws IOException {
		
		Writer writer = context.getWriter();
		
		GraphModel model = pad.getModel();
		
		writer.append("<table>").append("<tr>").append("<td>");
		
		List<GraphElement> elements = model.getElements();
		for (int i = 0; i < elements.size(); i++) {
			writer.append("<div>");
			writer.append("<img src='").append(context.createResourceURL(pad.getId(), "formula/" + i, new HashMap<String, String>())).append("' />");
			writer.append("</div>");
		}
		writer.append("</td>").append("<td>");
		writer.append("<img src='").append(context.createResourceURL(pad.getId(), "graph", new HashMap<String, String>())).append("' />");
		writer.append("</td>").append("</tr>");
		writer.append("<tr>").append("<td>").append("</td>").append("<td style='text-align:center'>");
		writer.append("<img src='").append(context.createResourceURL(pad.getId(), "variables", new HashMap<String, String>())).append("' />");
		writer.append("</td>").append("</tr>").append("</table>");
	}

	@Override
	public void renderResource(GraphPart pad, String resourceId, IResourceRenderContext context)
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
			IResultContainer resultContainer = context.getResultContainer();
			Map<Integer, double[][]> parseResult = parseResult(resultContainer.getResult(pad.getId()));
			JFreeChart chart = createChart(pad.getModel(), parseResult);
			BufferedImage image = new BufferedImage(720, 300, BufferedImage.TYPE_4BYTE_ABGR);
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
		ImageIO.write(image, "png", outputStream);
	}
	
	private JFreeChart createChart(GraphModel model, Map<Integer, double[][]> results) {

		XYDataset dataset = createDataset(results, model);

		JFreeChart chart = ChartFactory.createXYLineChart(null, null,
				null, dataset, PlotOrientation.HORIZONTAL, false, false, false);

		chart.setBackgroundPaint(Color.white);
		chart.setBorderVisible(true);
		chart.setBorderPaint(Color.BLACK);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.getRangeAxis().setFixedDimension(15.0);
		XYItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesPaint(0, Color.black);
		
		if (model.getMaxX() != null && model.getMinX() != null) {
			plot.getDomainAxis().setRange(model.getMinX(), model.getMaxX());
		} else {
			plot.getDomainAxis().setAutoRange(true);
		}
		
		if (model.getMaxY() != null && model.getMinY() != null) {
			plot.getRangeAxis().setRange(model.getMinY(), model.getMaxY());
		} else {
			plot.getRangeAxis().setAutoRange(true);
		}
		
		List<GraphElement> elements = model.getElements();
		for (int i = 0; i < elements.size(); i++) {
			GraphElement element = elements.get(i);
			String color = element.getColor();
			if (color == null) {
				color = PaintUtilities.colorToString((Color) plot.getDrawingSupplier().getNextPaint());
			}
			renderer.setSeriesPaint(i, PaintUtilities.stringToColor(color));
			int width = element.getWidth();
			if (width < 1) {
				width = 1;
			}
			renderer.setSeriesStroke(i, new BasicStroke(width));
		}
		
		plot.datasetChanged(new DatasetChangeEvent(this, dataset));
		
		return chart;
	}
	
	public Map<Integer, double[][]> parseResult(String result) {
		Map<Integer, double[][]> results = new HashMap<>();
		double[][][] parseTrippleArray;
		try {
			parseTrippleArray = ArrayUtils.parseTrippleArray(new StringReader(result));
			for (int i = 0; i < parseTrippleArray.length; i++) {
				results.put(i, parseTrippleArray[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public XYDataset createDataset(final Map<Integer, double[][]> results, final GraphModel model) {
		XYDataset dataset = new AbstractXYDataset() {

			private static final long serialVersionUID = 1L;

			@Override
			public Number getY(int arg0, int arg1) {
				return getResult(arg0)[arg1][1];
			}

			@Override
			public Number getX(int arg0, int arg1) {
				return getResult(arg0)[arg1][0];
			}

			@Override
			public int getItemCount(int arg0) {
				return getResult(arg0).length;
			}

			@Override
			public Comparable<Integer> getSeriesKey(int arg0) {
				return Integer.valueOf(arg0);
			}

			@Override
			public int getSeriesCount() {
				return model.getElements().size();
			}
			
			private double[][] getResult(int number) {
				double[][] ds = results.get(Integer.valueOf(number));
				if (ds == null) {
					return new double[0][];
				}
				return ds;
			}
			
		};

		return dataset;
	}
	
	@Reference(unbind = "unbindFormulaImageRenderer", policy = ReferencePolicy.DYNAMIC)
	public void bindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = renderer;
	}
	
	public void unbindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = null;
	}

}
