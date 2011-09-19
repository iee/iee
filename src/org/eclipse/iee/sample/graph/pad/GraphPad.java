package org.eclipse.iee.sample.graph.pad;

import java.awt.Color;
import java.io.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.graph.FileStorage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.ui.RectangleInsets;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class GraphPad extends Pad implements Serializable {

	private String fFunction;
	private double[][] fData;
	private double fDomainMin;
	private double fDomainMax;
	private int fDomainCardinality;
	private boolean fIsAdvancedMode;
	private boolean fIsActive;
	private transient static FileStorage fFileStorage;

	public GraphPad() {
		super();
		fFunction = "";
		fData = null;
		fDomainMin = 0;
		fDomainMax = 0;
		fDomainCardinality = 0;
		fIsAdvancedMode = false;
		fIsActive = false;
		save();
	}

	@Override
	public void createPartControl(final Composite parent) {
		//GridLayout layout = new GridLayout(1, false);
		GridLayout layout = new GridLayout(9,false);
		layout.verticalSpacing = 5;
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		
		final Label functionLabel = new Label(parent, SWT.NONE);
		functionLabel.setText("f(x) = ");
		final Text function = new Text(parent, SWT.BORDER);
		function.setText("");

		new Label(parent, SWT.NONE).setText("#(points): ");
		final Text points = new Text(parent, SWT.BORDER | SWT.RIGHT);
		points.setText("100");

		new Label(parent, SWT.NONE).setText("From");
		final Text initialValue = new Text(parent, SWT.BORDER | SWT.RIGHT);
		initialValue.setText("-100");

		new Label(parent, SWT.NONE).setText("To");
		final Text finalValue = new Text(parent, SWT.BORDER | SWT.LEFT);
		finalValue.setText("100");

		Button draw = new Button(parent, SWT.NONE);
		draw.setText("Plot graph");

		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.exclude = false;
		gridData.widthHint = 720;
		gridData.heightHint = 300;
		gridData.horizontalSpan = 9;
		
		JFreeChart chart = createChart();
		final ChartComposite frame = new ChartComposite(parent, SWT.BORDER_DASH,
				chart, true);
		frame.setDisplayToolTips(false);
		frame.setHorizontalAxisTrace(true);
		frame.setVerticalAxisTrace(true);
		frame.setLayoutData(gridData);
		
		// Listeners
		draw.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);				
				gridData.exclude = false;
				gridData.horizontalSpan = 9;
				fFunction = function.getText();
				fDomainMax = Double.valueOf(initialValue.getText());
				fDomainMin = Double.valueOf(finalValue.getText());
				fDomainCardinality = Integer.valueOf(points.getText());
				JFreeChart chart = createChart();
				frame.setChart(chart);
				frame.redraw();
				frame.setLayoutData(gridData);	
			
			}
		});

		MouseEventManager mouseManager = new MouseEventManager(parent, false);
		parent.addMouseTrackListener(mouseManager);
		parent.addMouseMoveListener(mouseManager);
		parent.addMouseListener(mouseManager);

	}

	protected GraphPad(String containerID) {
		super(containerID);
		fFunction = "";
		save();
	}

	public static void setStorage(FileStorage fStorage) {
		GraphPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		GraphPad newPad = new GraphPad();
		newPad.fFunction = this.fFunction;
		newPad.fData = this.fData;
		newPad.fDomainMin = this.fDomainMin;
		newPad.fDomainMax = this.fDomainMax;
		newPad.fDomainCardinality = this.fDomainCardinality;
		newPad.fIsAdvancedMode = this.fIsAdvancedMode;
		newPad.fIsActive = false;
		return newPad;
	}

	@Override
	public String getType() {
		return "Graph";
	}

	// Save&Load operations, use it for serialization

	public void save() {
		GraphPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		GraphPad.fFileStorage.removeFile(getContainerID());
	}

	// Getters&Setters

	public void setFunction(String function) {
		fFunction = function;
	}

	public String getFunction() {
		return fFunction;
	}

	public void setDomainMin(Double value) {
		fDomainMin = value;
	}

	public Double getDomainMin() {
		return fDomainMin;
	}

	public void setDomainMax(Double value) {
		fDomainMax = value;
	}

	public Double getDomainMax() {
		return fDomainMax;
	}

	public void setDomainCardinality(int value) {
		fDomainCardinality = value;
	}

	public int getDomainCardinality() {
		return fDomainCardinality;
	}

	/**
	 * Creates the demo chart.
	 * 
	 * @return The chart.
	 */
	public JFreeChart createChart() {

		XYDataset dataset = createDataset("Series 1");

		JFreeChart chart = ChartFactory.createXYLineChart("XY plot demo", "X",
				"Y", dataset, PlotOrientation.HORIZONTAL, false, false, false);

		chart.setBackgroundPaint(Color.white);
		chart.setBorderVisible(true);
		chart.setBorderPaint(Color.BLACK);
		TextTitle subtitle = new TextTitle("Sample.");
		chart.addSubtitle(subtitle);
		XYPlot plot = (XYPlot) chart.getPlot();
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
		DefaultXYDataset dataset = new DefaultXYDataset();

		JEP jep = new JEP();
		jep.addStandardFunctions();
		jep.addStandardConstants();
		jep.setImplicitMul(true);

		Node node;
		try {
			jep.addVariable("x", 0);

			node = jep.parse(getFunction());

			double init = getDomainMin();
			double end = getDomainMax();
			int nValues = getDomainCardinality();
			double step = Math.abs((end - init) / nValues);

			int i = 0;
			fData = new double[2][nValues];
			for (double x = Math.min(init, end); x < Math.max(init, end); x += step) {
				jep.setVarValue("x", x);

				Object obj = jep.evaluate(node);
				if (obj instanceof Double) {
					double y = (Double) obj;
					fData[0][i] = x;
					fData[1][i] = y;
					i++;
				}
			}

			dataset.addSeries(1, fData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataset;
	}
}
