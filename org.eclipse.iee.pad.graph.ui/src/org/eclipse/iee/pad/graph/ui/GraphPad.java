package org.eclipse.iee.pad.graph.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.iee.core.utils.ArrayUtils;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.editor.core.utils.runtime.file.IFileMessageListener;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.GraphPart;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.PaintUtilities;

public class GraphPad extends Pad<GraphPart> implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean fIsAdvancedMode;

	private transient GraphModelPresenter graphModelPresenter;
	private transient XYPlot plot;
	private transient XYDataset dataset;
	private Map<Integer, double[][]> results;
	
	private UIFormulaRenderer formulaRenderer;
	
	public GraphPad(GraphPart part, UIFormulaRenderer formulaRenderer) {
		super(part);
		this.formulaRenderer = formulaRenderer;
		fIsAdvancedMode = false;
	}

	private IFileMessageListener fFileMessageListener = new IFileMessageListener() {

		@Override
		public void messageReceived(FileMessageEvent e) {
			updateResult(e.getMessage());
		}

		@Override
		public String getRequesterID() {
			return getDocumentPart().getId();
		}

	};

	private Shell shell;

	private Canvas canvas;

	@Override
	public void createPartControl(final Composite parent) {
		GridLayout layout = new GridLayout(2,false);
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		parent.setLayout(layout);

		GridData gd_frame = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_frame.exclude = false;
		gd_frame.widthHint = 720;
		gd_frame.heightHint = 300;
		shell = parent.getShell();
		canvas = new Canvas(parent, SWT.NONE);
		canvas.setLayoutData(gd_frame);
		LightweightSystem lws = new LightweightSystem(canvas);
		JFreeChart chart = createChart();
		GraphFigure root = new GraphFigure(chart, canvas);
		lws.setContents(root);

		initModelView(root, getDocumentPart().getModel());

		FileMessager.getInstance().addFileMessageListener(fFileMessageListener, 
				getContainer().getContainerManager().getStoragePath());
	}


	public void initModelView(GraphFigure root, GraphModel model) {
		graphModelPresenter = new GraphModelPresenter(this, root, model, plot, formulaRenderer);
	}

	@Override
	public GraphPad copy() {
		GraphPad newPad = new GraphPad(getDocumentPart().copy(), formulaRenderer);
		newPad.results = this.results;
		newPad.fIsAdvancedMode = this.fIsAdvancedMode;
		return newPad;
	}

	// Save&Load operations, use it for serialization

	public void save() {
		if (graphModelPresenter != null) {
			graphModelPresenter.save();
			if (plot.getDomainAxis().isAutoRange()) {
				getDocumentPart().getModel().setMinX(null);
				getDocumentPart().getModel().setMaxX(null);
			} else {
				Range range = plot.getDomainAxis().getRange();
				getDocumentPart().getModel().setMinX(range.getLowerBound());
				getDocumentPart().getModel().setMaxX(range.getUpperBound());
			}
			if (plot.getRangeAxis().isAutoRange()) {
				getDocumentPart().getModel().setMinY(null);
				getDocumentPart().getModel().setMaxY(null);
			} else {
				Range range = plot.getRangeAxis().getRange();
				getDocumentPart().getModel().setMinY(range.getLowerBound());
				getDocumentPart().getModel().setMaxY(range.getUpperBound());
			}
			
			
			processInput(getDocumentPart().getModel());
		}
	}

	@Override
	public void unsave() {
	}

	/**
	 * Creates the demo chart.
	 * 
	 * @return The chart.
	 */
	public JFreeChart createChart() {

		XYDataset dataset = createDataset("Series 1");

		JFreeChart chart = ChartFactory.createXYLineChart(null, null,
				null, dataset, PlotOrientation.HORIZONTAL, false, false, false);

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
		
		GraphModel model = getDocumentPart().getModel();
		
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
			public Comparable<Integer> getSeriesKey(int arg0) {
				return Integer.valueOf(arg0);
			}

			@Override
			public int getSeriesCount() {
				return getDocumentPart().getModel().getElements().size();
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
		getContainer().updateDocument();
	}

	public void updateResult(String result) {
		if (result == null || result.isEmpty()) {
			getResults().clear();
			return;
		}
		double[][][] parseTrippleArray;
		try {
			parseTrippleArray = ArrayUtils.parseTrippleArray(new StringReader(result));
			for (int i = 0; i < parseTrippleArray.length; i++) {
				getResults().put(i, parseTrippleArray[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				XYItemRenderer renderer = plot.getRenderer();
				List<GraphElement> elements = getDocumentPart().getModel().getElements();
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
			}
		});
	}
	
	public Map<Integer, double[][]> getResults() {
		if (results == null) {
			results = new HashMap<Integer, double[][]>();
		}
		return results;
	}
	

	@Override
	public void onContainerAttached() {
	}

	@Override
	public void activate() {
	}

	@Override
	public void updateData(Map<String, String> params, String value) {
	}
	
	@Override
	public String getType() {
		return "Graph";
	}

	@Override
	public String getTex() {
		return "";
	}


	public Shell getShell() {
		return shell;
	}


	public Canvas getCanvas() {
		return canvas;
	}
	
}
