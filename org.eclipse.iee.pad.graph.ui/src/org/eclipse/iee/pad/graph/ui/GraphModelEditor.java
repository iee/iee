package org.eclipse.iee.pad.graph.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.iee.editor.core.bindings.ConvertedObservableValue;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.IObserver;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.bindings.converter.DoubleConverter;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Caret;
import org.jfree.chart.JFreeChart;
import org.jfree.util.PaintUtilities;

import com.google.common.base.Converter;
import com.google.common.reflect.TypeToken;

public class GraphModelEditor extends AbstractTextEditor<GraphModel, IFigure> {

	private Map<GraphElement, GraphElementEditor> editors = new HashMap<>();
	
	private UIFormulaRenderer fFormulaRenderer;

	private IObserver<List<GraphElement>> fListener;
	
	private Figure fSeries;
	
	private IShellProvider fShellProvider;

	private ChartEditor fChartEditor;

	private ObservableProperty<Double> fMinXValue;

	private ObservableProperty<Double> fMaxXValue;

	private ObservableProperty<Double> fMinYValue;

	private ObservableProperty<Double> fMaxYValue;

	private ObservableProperty<List<String>> fVariablesValue;

	private ObservableProperty<List<GraphElement>> fElementsValue;
	
	public GraphModelEditor(UIFormulaRenderer formulaRenderer, IShellProvider shellProvider) {
		fFormulaRenderer = formulaRenderer;
		fShellProvider = shellProvider;
		fListener = new IObserver<List<GraphElement>>() {
			@Override
			public void valueChanged(List<GraphElement> oldValue, List<GraphElement> newValue) {
				updateElements(newValue);
			}
		};
	}
	
	protected IFigure createFigure() {
		IFigure figure = new Figure();
		GridLayout manager = new GridLayout();
		manager.numColumns = 2;
		figure.setLayoutManager(manager);
		fChartEditor = new ChartEditor(fShellProvider);
		IFigure seriesFigure = createSeriesFigure();
		GridData seriesData = new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.GRAB_VERTICAL);
		figure.add(seriesFigure, seriesData);
		addEditor(fChartEditor);
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
		GridData maxXdata = new GridData();
		TextPartEditor maxY = new TextPartEditor();
		maxY.bindValue(ConvertedObservableValue.from(fMaxYValue, DoubleConverter.REVERSE_INSTANCE));
		figure.add(maxY.getFigure(), maxXdata);
		addEditor(maxY);
		fSeries = new Figure();
		fSeries.setLayoutManager(new ToolbarLayout(false));
		GridData seriesData = new GridData(GridData.GRAB_VERTICAL | GridData.VERTICAL_ALIGN_CENTER);
		figure.add(fSeries, seriesData);
		GridData minXdata = new GridData();
		TextPartEditor minY = new TextPartEditor();
		minY.bindValue(ConvertedObservableValue.from(fMinYValue, DoubleConverter.REVERSE_INSTANCE));
		addEditor(minY);
		figure.add(minY.getFigure(), minXdata);
		
		updateElements(getModel()!= null ? getModel().getElements() : Collections.<GraphElement> emptyList());
		
		return figure;
	}
	
	public IFigure createVariablesFigure() {
		IFigure figure = new Figure();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		figure.setLayoutManager(layout);
		GridData minXdata = new GridData();
		TextPartEditor minX = new TextPartEditor();
		minX.bindValue(ConvertedObservableValue.from(fMinXValue, DoubleConverter.REVERSE_INSTANCE));
		addEditor(minX);
		figure.add(minX.getFigure(), minXdata);
		GridData varsData = new GridData();
		varsData.horizontalAlignment = GridData.CENTER;
		varsData.grabExcessHorizontalSpace = true;
		TextPartEditor vars = new TextPartEditor();
		vars.bindValue(ConvertedObservableValue.from(fVariablesValue, new Converter<List<String>, String>() {
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
		}));
		addEditor(vars);
		figure.add(vars.getFigure(), varsData);
		GridData maxXdata = new GridData();
		maxXdata.horizontalAlignment = GridData.END;
		TextPartEditor maxX = new TextPartEditor();
		maxX.bindValue(ConvertedObservableValue.from(fMaxXValue, DoubleConverter.REVERSE_INSTANCE));
		addEditor(maxX);
		figure.add(maxX.getFigure(), maxXdata);
		return figure;
	}
	
	private void addElementComposite(final GraphElement graphElement) {
		GraphElementEditor elementEditor = new GraphElementEditor(fFormulaRenderer, fChartEditor.getDrawingSupplier(), fShellProvider);
		addEditor(elementEditor);
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
		if (fSeries == null) {
			return;
		}
		for (GraphElementEditor editor: editors.values()) {
			fSeries.remove(editor.getFigure());
			removeEditor(editor);
			editor.dispose();
		}
		editors.clear();
		for (GraphElement graphElement : elements) {
			addElementComposite(graphElement);
		}
	}
	
	public void bindGraphElementModel(IObservableValue<GraphModel> model) {
		bindObservableValue(model);
	}
	
	@SuppressWarnings("serial")
	@Override
	protected void doBindValue(GraphModel value) {
		fMinXValue = new ObservableProperty<Double>(value, "minX", Double.class);
		fMaxXValue = new ObservableProperty<Double>(value, "maxX", Double.class);
		fMinYValue = new ObservableProperty<Double>(value, "minY", Double.class);
		fMaxYValue = new ObservableProperty<Double>(value, "maxY", Double.class);
		fVariablesValue = new ObservableProperty<List<String>>(value, "variables", new TypeToken<List<String>> (){});
		fElementsValue = new ObservableProperty<List<GraphElement>>(value, "elements", new TypeToken<List<GraphElement>>() {});
		fElementsValue.addObserver(fListener);
	}
	
	@Override
	protected void doUnbindValue(GraphModel oldValue) {
		fMaxXValue.dispose();
		fMaxYValue.dispose();
		fMinXValue.dispose();
		fMinYValue.dispose();
		fVariablesValue.dispose();
		fElementsValue.dispose();
	}
	
	@Override
	protected void onValueChanged(GraphModel oldValue, GraphModel newValue) {
		updateElements(newValue.getElements());
	}

	public String getNextColor() {
		return PaintUtilities.colorToString((java.awt.Color) fChartEditor.getDrawingSupplier().getNextPaint());
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

	public JFreeChart getChart() {
		return fChartEditor.getChart();
	}

}
