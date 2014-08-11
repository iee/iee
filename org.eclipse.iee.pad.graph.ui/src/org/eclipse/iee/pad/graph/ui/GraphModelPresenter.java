/**
 * 
 */
package org.eclipse.iee.pad.graph.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.XYPlot;
import org.jfree.util.PaintUtilities;

/**
 * @author Efimchuk.A
 *
 */
public class GraphModelPresenter {

	private List<GraphElementPresenenter> presenenters = new ArrayList<GraphElementPresenenter>();
	
	private GraphPad graphPad;
	
	private GraphFigure root;
	
	private GraphModel model;

	private XYPlot plot;

	private UIFormulaRenderer formulaRenderer;
	
	public GraphModelPresenter(GraphPad graphPad, GraphFigure root, GraphModel model, XYPlot plot, UIFormulaRenderer formulaRenderer) {
		this.graphPad = graphPad;
		this.root = root;
		this.plot = plot;
		this.formulaRenderer = formulaRenderer;
		setModel(model);
	}
	
	private void addElementComposite(final GraphModel model,
			final GraphElement graphElement, final SeriesFigure figure) {
		GraphElementFigure elementComposite = new GraphElementFigure(new Caret(graphPad.getCanvas(), SWT.NONE), formulaRenderer);
		figure.addElement(elementComposite);
		presenenters.add(new GraphElementPresenenter(elementComposite, this, graphElement));
	}
	
	public void addNewElement() {
		GraphElement newElement = new GraphElement();
		newElement.setNumberOfPoints(100);
		newElement.setColor(getNextColor());
		model.getElements().add(newElement);
		addElementComposite(model, newElement, root.getSeriesFigure());
		graphPad.processInput(model);
	}
	
	public void removeElement(GraphElementPresenenter elementPresenenter) {
		presenenters.remove(elementPresenenter);
		model.getElements().remove(elementPresenenter.getGraphElement());
		elementPresenenter.remove();
		graphPad.processInput(model);
	}

	public void save() {
		String text = root.getVariablesFigure().getVarsText();
		String[] variables = text.split(",");
		model.setVariables(Arrays.asList(variables));
		for (GraphElementPresenenter presenter : presenenters) {
			presenter.save();
		}
	}
	
	public void setModel(GraphModel model) {
		for (GraphElementPresenenter presenter : presenenters) {
			presenter.remove();
		}
		presenenters.clear();
		this.model = model;
		SeriesFigure seriesFigure = root.getSeriesFigure();
		List<GraphElement> elements = model.getElements();
		for (GraphElement graphElement : elements) {
			addElementComposite(model, graphElement, seriesFigure);
		}
		StringBuilder sb = new StringBuilder();
		List<String> variables = model.getVariables();
		for (String variable : variables) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(variable);
		}
		
		VariablesFigure variablesFigure = root.getVariablesFigure();
		variablesFigure.setMinXText(model.getMinX() != null ? String.valueOf(model.getMinX()) : "");
		variablesFigure.setVarsText(sb.toString());
		variablesFigure.setMaxXText(model.getMaxX() != null ? String.valueOf(model.getMaxX()) : "");
		seriesFigure.setMinYText(model.getMinY() != null ? String.valueOf(model.getMinY()) : "");
		seriesFigure.setMaxYText(model.getMaxY() != null ? String.valueOf(model.getMaxY()) : "");
	}

	public void pack() {
	}

	public String getNextColor() {
		DrawingSupplier drawingSupplier = plot.getDrawingSupplier();
		return PaintUtilities.colorToString((Color) drawingSupplier.getNextPaint());
	}

	public Shell getShell() {
		return graphPad.getShell();
	}
	
}
