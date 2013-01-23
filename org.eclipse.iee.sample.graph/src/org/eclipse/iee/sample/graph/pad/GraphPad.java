package org.eclipse.iee.sample.graph.pad;

import java.awt.Color;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.runtime.console.ConsoleMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.console.ConsoleMessager;
import org.eclipse.iee.editor.core.utils.runtime.console.IConsoleMessageListener;
import org.eclipse.iee.sample.formula.pad.Translator;
import org.eclipse.iee.sample.graph.FileStorage;
import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.iee.sample.graph.pad.model.GraphModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

public class GraphPad extends Pad implements Serializable {

	private static final long serialVersionUID = 1L;

	private GraphModel model;

	private boolean fIsAdvancedMode;
	private transient static FileStorage fFileStorage;

	private transient GraphModelPresenter graphModelPresenter;
	private transient XYPlot plot;
	private transient XYDataset dataset;
	private Map<Integer, double[][]> results;
	
	public GraphPad() {
		super();
		fIsAdvancedMode = false;
		model = new GraphModel();
		model.getElements().add(new GraphElement());
		save();
	}

	private IConsoleMessageListener fConsoleMessageListener = new IConsoleMessageListener() {
		@Override
		public void messageReceived(ConsoleMessageEvent e) {
			System.out.println("Message received:" + e.getMessage());
			updateResult(e.getMessage());
		}

		@Override
		public String getRequesterID() {
			return getContainerID();
		}
	};

	

	

	@Override
	public void createPartControl(final Composite parent) {
		parent.setLayout(new FillLayout());
		GraphComposite graphComposite = new GraphComposite(parent, SWT.NONE);

		JFreeChart chart = createChart();
		graphComposite.getGraphComposite().setChart(chart);

		initModelView(graphComposite, model);

		ConsoleMessager.getInstance().addConsoleMessageListener(
				fConsoleMessageListener);
	}

	public void initModelView(GraphComposite parent, GraphModel model) {
		graphModelPresenter = new GraphModelPresenter(this, parent, model);
	}

	protected GraphPad(String containerID) {
		super();
		model = new GraphModel();
		save();
	}

	public static void setStorage(FileStorage fStorage) {
		GraphPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		GraphPad newPad = new GraphPad();
		newPad.results = this.results;
		newPad.model = this.model.clone();
		newPad.fIsAdvancedMode = this.fIsAdvancedMode;
		return newPad;
	}

	// Save&Load operations, use it for serialization

	public void save() {
		if (graphModelPresenter != null) {
			graphModelPresenter.save();
			processInput(model);
		}
		GraphPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		GraphPad.fFileStorage.removeFile(getContainerID());
	}

	/**
	 * Creates the demo chart.
	 * 
	 * @return The chart.
	 */
	public JFreeChart createChart() {

		XYDataset dataset = createDataset("Series 1");

		JFreeChart chart = ChartFactory.createXYLineChart(null, "X",
				"Y", dataset, PlotOrientation.HORIZONTAL, false, false, false);
		
		chart.setBackgroundPaint(Color.white);
		chart.setBorderVisible(true);
		chart.setBorderPaint(Color.BLACK);
		plot = (XYPlot) chart.getPlot();
		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.getRangeAxis().setFixedDimension(15.0);
		XYItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesPaint(0, Color.black);

		return chart;
	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @param name
	 *            the dataset name.
	 * 
	 * @return The dataset.
	 */
	public XYDataset createDataset(String name) {
		dataset = new AbstractXYDataset() {

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
			public Comparable getSeriesKey(int arg0) {
				return Integer.valueOf(arg0);
			}

			@Override
			public int getSeriesCount() {
				return model.getElements().size();
			}
			
			private double[][] getResult(int number) {
				double[][] ds = getResults().get(Integer.valueOf(number));
				if (ds == null) {
					return new double[0][];
				}
				return ds;
			}
			
		};

		return dataset;
	}

	public void processInput(GraphModel model) {

		List<GraphElement> elements = model.getElements();
		StringBuilder generatedText = new StringBuilder();

		int counter = 0;

		for (GraphElement graphElement : elements) {
			String function = graphElement.getfFunction();
			if (function != null && function.trim().length() > 0) {
				String translateElement = Translator.translateElement(function);
				generatedText.append("StringBuilder sb").append(counter).append(" = new StringBuilder();");
				generatedText.append("sb").append(counter).append(".append(\"{\");");
				generatedText.append("for (double x = ")
						.append(graphElement.getfDomainMin()).append("; x < ")
						.append(graphElement.getfDomainMax())
						.append("; x += Math.abs((")
						.append(graphElement.getfDomainMax()).append(" - ")
						.append(graphElement.getfDomainMin()).append(") / ")
						.append(graphElement.getfDomainCardinality())
						.append(")) {");
				generatedText.append("double y = ").append(translateElement)
						.append(";");
				generatedText.append("sb").append(counter).append(".append(\"{\").append(x).append(\",\").append(y).append(\"},\");");
				generatedText.append("}");
				generatedText.append("sb").append(counter).append(".append(\"}\");");
				generatedText.append("System.out.println(\"").append(getContainerID()).append(" ").append(counter).append(": \" + ").append("sb").append(counter).append(".toString()").append(");");
				
			}
			counter++;
		}

		getContainer().setTextContent(generatedText.toString());
	}

	public void updateResult(String result) {
		String[] splited = result.split("\\:");
		Integer number = Integer.valueOf(splited[0].trim());
		try {
			getResults().put(number, parseArray(splited[1].trim()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		plot.datasetChanged(new DatasetChangeEvent(this, dataset));
	}
	
	public Map<Integer, double[][]> getResults() {
		if (results == null) {
			results = new HashMap<Integer, double[][]>();
		}
		return results;
	}
	
	public double[][] parseArray(String arrayStr) throws IOException {
		StringReader reader = new StringReader(arrayStr);
		return parseArray(reader);
	}
	
	public double[][] parseArray(Reader reader) throws IOException {
		List<double[]> parsed = new ArrayList<double[]>();
		readChar(reader, '{', true);
		double[] readPair;
		while ((readPair = readPair(reader)) != null) {
			parsed.add(readPair);
			readChar(reader, ',', false);
		}
		readChar(reader, '}', true);
		double[][] result = new double[parsed.size()][];
		for (int i = 0; i < parsed.size(); i++) {
			result[i] = parsed.get(i);
		}
		return result;
	}
	
	public double[] readPair(Reader reader) throws IOException {
		double result[]; 
		if (readChar(reader, '{', false)) {
			result = new double[2];
			result[0] = readDouble(reader);
			readChar(reader, ',', true);
			result[1] = readDouble(reader);
			readChar(reader, '}', true);
		} else {
			result = null;
		}
		return result;
	}
	
	public double readDouble(Reader reader) throws IOException {
		
		StringBuilder str = new StringBuilder();
		while (true) {
			reader.mark(1);
			int i = reader.read();
			if (i == -1) {
				break;
			} 
			char c = (char) i;
			if (Character.isDigit(c) || c == '.' || c =='-' || c == 'e' || c == 'E') {
				str.append(c);
			} else {
				reader.reset();
				break;
			}
		}
		return Double.parseDouble(str.toString());
	}
	
	public boolean readChar(Reader reader, char character, boolean mandatory) throws IOException {
		while (true) {
			reader.mark(1);
			int i = reader.read();
			if (i == -1) {
				break;
			} 
			char c = (char) i;
			if (character == c) {
				return true;
			} else if (Character.isSpaceChar(c)) {
				continue;
			} else if (mandatory) {
				throw new IllegalArgumentException("Illegal symbol " + c);
			} else {
				reader.reset();
				return false;
			}
		}
		throw new IllegalArgumentException("Stream unexpectedly closed");
	}

	@Override
	public void onContainerAttached() {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
