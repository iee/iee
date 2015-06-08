package org.eclipse.iee.pad.graph.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.iee.editor.core.bindings.IObservableModel;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Caret;
import org.jfree.util.PaintUtilities;

import com.google.common.base.Converter;
import com.google.common.primitives.Doubles;

public class GraphModelEditor extends AbstractTextEditor<GraphModel> {

	private Map<GraphElement, GraphElementEditor> editors = new HashMap<>();
	
	private UIFormulaRenderer fFormulaRenderer;

	private PropertyChangeListener fListener;
	
	private TextPartEditor fMinY;
	
	private Figure fSeries;
	
	private TextPartEditor fMaxY;
	
	private TextPartEditor fMinX;
	
	private TextPartEditor fVars;
	
	private TextPartEditor fMaxX;
	
	private IShellProvider fShellProvider;

	private ChartEditor fChartEditor;
	
	public GraphModelEditor(UIFormulaRenderer formulaRenderer, IShellProvider shellProvider) {
		fFormulaRenderer = formulaRenderer;
		fShellProvider = shellProvider;
		fListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (getModel() == evt.getSource() &&
						"elements".equals(evt.getPropertyName())) {
					
				}
			}
		};
	}
	
	protected IFigure createFigure() {
		IFigure figure = new Figure();
		GridLayout manager = new GridLayout();
		manager.numColumns = 2;
		figure.setLayoutManager(manager);
		IFigure seriesFigure = createSeriesFigure();
		GridData seriesData = new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.GRAB_VERTICAL);
		figure.add(seriesFigure, seriesData);
		fChartEditor = new ChartEditor(fShellProvider);
		IFigure chartFigure = fChartEditor.getFigure();
		GridData chartData = new GridData(
				GridData.HORIZONTAL_ALIGN_FILL
                | GridData.GRAB_HORIZONTAL
                | GridData.VERTICAL_ALIGN_FILL
                | GridData.GRAB_VERTICAL);
		figure.add(chartFigure, chartData);
		figure.add(new Figure());
		IFigure variablesFigure = createVariablesFigure();
		GridData varsData = new GridData(
				GridData.HORIZONTAL_ALIGN_FILL
                | GridData.GRAB_HORIZONTAL);
		
		figure.add(variablesFigure, varsData);	
		return figure;
	}
	
	public IFigure createSeriesFigure() {
		IFigure figure = new Figure();
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		figure.setLayoutManager(layout);
		fMaxY = new TextPartEditor();
		GridData maxXdata = new GridData();
		figure.add(fMaxY.getFigure(), maxXdata);
		fSeries = new Figure();
		fSeries.setLayoutManager(new ToolbarLayout(false));
		GridData seriesData = new GridData(
				GridData.GRAB_VERTICAL 
				| GridData.VERTICAL_ALIGN_CENTER);
		figure.add(fSeries, seriesData);
		fMinY = new TextPartEditor();
		GridData minXdata = new GridData();
		figure.add(fMinY.getFigure(), minXdata);
		return figure;
	}
	
	public IFigure createVariablesFigure() {
		IFigure figure = new Figure();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		figure.setLayoutManager(layout);
		fMinX = new TextPartEditor();
		GridData minXdata = new GridData();
		figure.add(fMinX.getFigure(), minXdata);
		fVars = new TextPartEditor();
		GridData varsData = new GridData();
		varsData.horizontalAlignment = GridData.CENTER;
		varsData.grabExcessHorizontalSpace = true;
		figure.add(fVars.getFigure(), varsData);
		fMaxX = new TextPartEditor();
		GridData maxXdata = new GridData();
		maxXdata.horizontalAlignment = GridData.END;
		figure.add(fMaxX.getFigure(), maxXdata);
		return figure;
	}
	
	private void addElementComposite(final GraphElement graphElement) {
		GraphElementEditor elementEditor = new GraphElementEditor(fFormulaRenderer, fChartEditor.getDrawingSupplier(), fShellProvider);
		editors.put(graphElement, elementEditor);
		fSeries.add(elementEditor.getFigure());
	}
	
	public void addNewElement() {
		GraphElement newElement = new GraphElement();
		newElement.setNumberOfPoints(100);
		newElement.setColor(getNextColor());
		getModel().getElements().add(newElement);
		addElementComposite(newElement);
	}
	
	public void removeElement(GraphElement element) {
		GraphElementEditor editor = editors.get(element);
		fSeries.remove(editor.getFigure());
		editor.dispose();
		editors.remove(element);
	}
	
	private void updateElements(List<GraphElement> elements) {
		for (GraphElementEditor editor: editors.values()) {
			fSeries.remove(editor.getFigure());
			editor.dispose();
		}
		editors.clear();
		fSeries.removeAll();
		for (GraphElement graphElement : elements) {
			addElementComposite(graphElement);
		}
	}
	
	public void bindGraphElementModel(IObservableModel<GraphModel> model) {
		bindObservableValue(model);
		fMinX.bindValue((IObservableValue<String>) model.getObservableValue("minX"));
		fMaxX.bindValue((IObservableValue<String>) model.getObservableValue("maxX"));
		fMinY.bindValue((IObservableValue<String>) model.getObservableValue("minY"));
		fMaxY.bindValue((IObservableValue<String>) model.getObservableValue("maxY"));
	}
	
	@Override
	protected void onValueChanged(GraphModel oldValue, GraphModel newValue) {

		updateElements(newValue.getElements());

		
		fVarsProperty = new ObservableProperty<String, List<String>>(getModel(), "variables", List.class, String.class, new Converter<List<String>, String>() {
			@Override
			protected String doForward(List<String> variables) {
				StringBuilder sb = new StringBuilder();
				for (String variable : variables) {
					if (sb.length() > 0) {
						sb.append(",");
					}
					sb.append(variable);
				}
				return sb.toString();
			}

			@Override
			protected List<String> doBackward(String b) {
				String[] variables = b.split(",");
				return Arrays.asList(variables);
			}
		});
		fVars.setValue(fVarsProperty);
	
	}

	public String getNextColor() {
		return PaintUtilities.colorToString((java.awt.Color) fChartEditor.getDrawingSupplier().getNextPaint());
	}

	public void dispose() {
		fMaxX.dispose();
		fMaxY.dispose();
		fMinX.dispose();
		fMinY.dispose();
		disposeModelListeners();
		fChartEditor.dispose();
	}

	private void disposeModelListeners() {
		getModel().removePropertyChangeListener(fListener);
		if (fMaxXProperty != null) {
			fMaxXProperty.dispose();
		}
		if (fMaxYProperty != null) {
			fMaxYProperty.dispose();
		}
		if (fMinXProperty != null) {
			fMinXProperty.dispose();
		}
		if (fMinYProperty != null) {
			fMinYProperty.dispose();
		}
		if (fVarsProperty != null) {
			fVarsProperty.dispose();
		}
	}

	@Override
	public TextLocation getTextLocation(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptCaret(Caret caret, TextLocation textLocation) {
		// TODO Auto-generated method stub
		
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

	public void setResult(Map<Integer, double[][]> result) {
		fChartEditor.setResult(result);
	}

}
