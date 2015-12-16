package org.eclipse.iee.pad.graph.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Display;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.util.ResourceBundleWrapper;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.PaintUtilities;

public class ChartEditor extends AbstractVisualTextEditor<GraphModel, ChartFigure> {

	private AxisChangeListener fDomainAxisListener;

	private AxisChangeListener fRangeAxisListener;

	private PropertyChangeListener fListener;

	private Map<Integer, double[][]> results = new HashMap<>();

	private XYDataset dataset;

	private IShellProvider fShellProvider;

	private JFreeChart fChart;

	/** The resourceBundle for the localization. */
	protected static ResourceBundle localizationResources = ResourceBundleWrapper
			.getBundle("org.jfree.chart.LocalizationBundle");

	public ChartEditor(IShellProvider fShellProvider) {
		this.fShellProvider = fShellProvider;
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				String propertyName = evt.getPropertyName();
				if ("maxX".equals(propertyName) || "minX".equals(propertyName) || "maxY".equals(propertyName)
						|| "minY".equals(propertyName)) {
					updateAxes(getPlot());
				}
			}
		};
	}

	@Override
	protected ChartFigure createFigure() {
		ChartFigure chartFigure = new ChartFigure(getChart(), fShellProvider);
		chartFigure.setPreferredSize(new Dimension(500, 250));
		return chartFigure;
	}

	public JFreeChart createChart() {

		XYDataset dataset = createDataset("Series 1");

		JFreeChart chart = ChartFactory.createXYLineChart(null, null, null, dataset, PlotOrientation.HORIZONTAL, false,
				false, false);

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

		updateAxes(plot);

		fDomainAxisListener = new AxisChangeListener() {
			@Override
			public void axisChanged(AxisChangeEvent event) {
				ValueAxis axis = (ValueAxis) event.getAxis();
				updateXAxis(axis);
			}
		};
		fRangeAxisListener = new AxisChangeListener() {
			@Override
			public void axisChanged(AxisChangeEvent event) {
				ValueAxis axis = (ValueAxis) event.getAxis();
				updateYAxis(axis);
			}
		};
		plot.getDomainAxis().addChangeListener(fDomainAxisListener);
		plot.getRangeAxis().addChangeListener(fRangeAxisListener);

		return chart;
	}

	@Override
	protected void doBindValue(GraphModel value) {
		value.addPropertyChangeListener(fListener);
	}

	@Override
	protected void doUnbindValue(GraphModel oldValue) {
		oldValue.removePropertyChangeListener(fListener);
	}

	private void updateAxes(XYPlot plot) {
		final GraphModel model = getModel();
		if (model != null && model.getMaxX() != null && model.getMinX() != null) {
			plot.getDomainAxis().setRange(model.getMinX(), model.getMaxX());
		} else {
			plot.getDomainAxis().setAutoRange(true);
		}

		if (model != null && model.getMaxY() != null && model.getMinY() != null) {
			plot.getRangeAxis().setRange(model.getMinY(), model.getMaxY());
		} else {
			plot.getRangeAxis().setAutoRange(true);
		}
	}

	private void updateXAxis(ValueAxis axis) {
		GraphModel model = getModel();
		if (axis.isAutoRange()) {
			model.setMinX(null);
			model.setMaxX(null);
		} else {
			model.setMinX(axis.getRange().getLowerBound());
			model.setMaxX(axis.getRange().getUpperBound());
		}
	}

	private void updateYAxis(ValueAxis axis) {
		GraphModel model = getModel();
		if (axis.isAutoRange()) {
			model.setMinY(null);
			model.setMaxY(null);
		} else {
			model.setMinY(axis.getRange().getLowerBound());
			model.setMaxY(axis.getRange().getUpperBound());
		}
	}

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
				GraphModel model = getModel();
				return model != null ? model.getElements().size() : 0;
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

	public Map<Integer, double[][]> getResults() {
		if (results == null) {
			results = new HashMap<Integer, double[][]>();
		}
		return results;
	}

	@Override
	public boolean isSelectable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSelected(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActive(boolean b) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		getModel().removePropertyChangeListener(fListener);
		getPlot().getDomainAxis().removeChangeListener(fDomainAxisListener);
		getPlot().getRangeAxis().removeChangeListener(fRangeAxisListener);
	}

	public void setResult(Map<Integer, double[][]> result) {
		results = new HashMap<>(result);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				XYItemRenderer renderer = getPlot().getRenderer();
				List<GraphElement> elements = getModel().getElements();
				for (int i = 0; i < elements.size(); i++) {
					GraphElement element = elements.get(i);
					String color = element.getColor();
					if (color == null) {
						color = PaintUtilities.colorToString((Color) getPlot().getDrawingSupplier().getNextPaint());
					}
					renderer.setSeriesPaint(i, PaintUtilities.stringToColor(color));
					int width = element.getWidth();
					if (width < 1) {
						width = 1;
					}
					renderer.setSeriesStroke(i, new BasicStroke(width));
				}

				getPlot().datasetChanged(new DatasetChangeEvent(this, dataset));
			}
		});

	}

	public DrawingSupplier getDrawingSupplier() {
		return getPlot().getDrawingSupplier();
	}

	private XYPlot getPlot() {
		return (XYPlot) getChart().getPlot();
	}

	JFreeChart getChart() {
		if (fChart == null) {
			fChart = createChart();
		}
		return fChart;
	}

}
