/**
 * 
 */
package org.eclipse.iee.pad.graph.ui;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Shell;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.XYPlot;
import org.jfree.util.PaintUtilities;

import com.google.common.base.Strings;

public class GraphModelPresenter {

	private List<GraphElementPresenenter> presenenters = new ArrayList<GraphElementPresenenter>();
	
	private GraphPad graphPad;
	
	private GraphFigure root;
	
	private GraphModel model;

	private XYPlot plot;

	private UIFormulaRenderer formulaRenderer;

	private PropertyChangeListener fListener;
	
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
	
	public void setModel(final GraphModel model) {
		for (GraphElementPresenenter presenter : presenenters) {
			presenter.remove();
		}
		presenenters.clear();
		this.model = model;
		final SeriesFigure seriesFigure = root.getSeriesFigure();
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
		
		final VariablesFigure variablesFigure = root.getVariablesFigure();
		variablesFigure.setMinXText(model.getMinX() != null ? String.valueOf(model.getMinX()) : "");
		variablesFigure.setVarsText(sb.toString());
		variablesFigure.setMaxXText(model.getMaxX() != null ? String.valueOf(model.getMaxX()) : "");
		seriesFigure.setMinYText(model.getMinY() != null ? String.valueOf(model.getMinY()) : "");
		seriesFigure.setMaxYText(model.getMaxY() != null ? String.valueOf(model.getMaxY()) : "");


		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				String propertyName = evt.getPropertyName();
				if ("minX".equals(propertyName)) {
					Double value = (Double) evt.getNewValue();
					variablesFigure.setMinXText(value != null ? String.valueOf(value) : null);
				} else if ("maxX".equals(propertyName)) {
					Double value = (Double) evt.getNewValue();
					variablesFigure.setMaxXText(value != null ? String.valueOf(value) : null);
				} else if ("minY".equals(propertyName)) {
					Double value = (Double) evt.getNewValue();
					seriesFigure.setMinYText(value != null ? String.valueOf(value) : null);
				} else if ("maxY".equals(propertyName)) {
					Double value = (Double) evt.getNewValue();
					seriesFigure.setMaxYText(value != null ? String.valueOf(value) : null);
				} 
			}
		};
		model.addPropertyChangeListener(fListener);
		
		variablesFigure.addMinXFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent fe) {
				String minXText = variablesFigure.getMinXText();
				if (Strings.isNullOrEmpty(minXText)) {
					model.setMinX(null);
				} else {
					model.setMinX(new Double(minXText));
				}
			}
			
			@Override
			public void focusGained(FocusEvent fe) {
			}
		});
		variablesFigure.addMaxXFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent fe) {
				String maxXText = variablesFigure.getMaxXText();
				if (Strings.isNullOrEmpty(maxXText)) {
					model.setMaxX(null);
				} else {
					model.setMaxX(new Double(maxXText));
				}
			}
			
			@Override
			public void focusGained(FocusEvent fe) {
			}
		});
		seriesFigure.addMinYFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent fe) {
				String minYText = seriesFigure.getMinYText();
				if (Strings.isNullOrEmpty(minYText)) {
					model.setMinY(null);
				} else {
					model.setMinY(new Double(minYText));
				}
			}
			
			@Override
			public void focusGained(FocusEvent fe) {
			}
		});
		seriesFigure.addMaxYFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent fe) {
				String maxYText = seriesFigure.getMaxYText();
				if (Strings.isNullOrEmpty(maxYText)) {
					model.setMaxY(null);
				} else {
					model.setMaxY(new Double(maxYText));
				}
			}
			
			@Override
			public void focusGained(FocusEvent fe) {
			}
		});
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

	public void dispose() {
		model.removePropertyChangeListener(fListener);

	}
	
}
