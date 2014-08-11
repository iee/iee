package org.eclipse.iee.pad.graph.ui;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Shell;
import org.jfree.chart.JFreeChart;

public class GraphFigure extends Figure {
	
	private VariablesFigure variablesFigure;
	
	private SeriesFigure seriesFigure;
	
	private ChartFigure chartFigure;

	public GraphFigure(JFreeChart chart, final Canvas canvas) {
		GridLayout manager = new GridLayout();
		manager.numColumns = 2;
		setLayoutManager(manager);
		seriesFigure = new SeriesFigure(new Caret(canvas, SWT.NONE));
		GridData seriesData = new GridData(GridData.VERTICAL_ALIGN_FILL
                | GridData.GRAB_VERTICAL);
		add(seriesFigure, seriesData);
		chartFigure = new ChartFigure(chart, new IShellProvider() {
			@Override
			public Shell getShell() {
				return canvas.getShell();
			}
		});
		GridData chartData = new GridData(GridData.HORIZONTAL_ALIGN_FILL
                | GridData.GRAB_HORIZONTAL
                | GridData.VERTICAL_ALIGN_FILL
                | GridData.GRAB_VERTICAL);
		add(chartFigure, chartData);
		add(new Figure());
		variablesFigure = new VariablesFigure(new Caret(canvas, SWT.NONE));
		GridData varsData = new GridData(GridData.HORIZONTAL_ALIGN_FILL
                | GridData.GRAB_HORIZONTAL);
		
		add(variablesFigure, varsData);	
	}

	public SeriesFigure getSeriesFigure() {
		return seriesFigure;
	}

	public VariablesFigure getVariablesFigure() {
		return variablesFigure;
	}
	
	public ChartFigure getChartFigure() {
		return chartFigure;
	}

}
