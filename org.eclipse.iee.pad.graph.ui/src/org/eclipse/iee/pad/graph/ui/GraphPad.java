package org.eclipse.iee.pad.graph.ui;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.core.utils.ArrayUtils;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.pad.FigurePad;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.editor.core.utils.runtime.file.IFileMessageListener;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.GraphPart;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Shell;
import org.jfree.chart.JFreeChart;

import com.google.common.base.Throwables;

public class GraphPad extends FigurePad<GraphPart, IFigure> implements Serializable {

	private static final long serialVersionUID = 1L;

	private GraphModelEditor fGraphModelEditor;
	
	public GraphPad(UIFormulaRenderer formulaRenderer) {
		fGraphModelEditor = new GraphModelEditor(formulaRenderer, new IShellProvider() {
			@Override
			public Shell getShell() {
				return getContainer().getTextWidget().getShell();
			}
		});
		addEditor(fGraphModelEditor);
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

	private ObservableProperty<GraphModel> fModelValue;

	@Override
	public IFigure createFigure() {
		return fGraphModelEditor.getFigure();
	}


	public void initModelView(final IGraphView root, GraphModel model) {
		
	}

	public void save() {
		processInput(getDocumentPart().getModel());
	}

	public void processInput(GraphModel model) {
		getContainer().updateDocument();
	}

	public void updateResult(String result) {
		Map<Integer, double[][]> resultMap = new HashMap<>();
		double[][][] parseTrippleArray;
		try {
			parseTrippleArray = ArrayUtils.parseTrippleArray(new StringReader(result));
			for (int i = 0; i < parseTrippleArray.length; i++) {
				resultMap.put(i, parseTrippleArray[i]);
			}
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
		fGraphModelEditor.setResult(resultMap);
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
	
	@Override
	public void attachContainer(Container container) {
		super.attachContainer(container);
		FileMessager.getInstance().addFileMessageListener(fFileMessageListener, 
				container.getContainerManager().getStoragePath());
	}

	@Override
	protected void doBindValue(GraphPart value) {
		fModelValue = new ObservableProperty<GraphModel>(value, "model", GraphModel.class);
		fGraphModelEditor.bindGraphElementModel(fModelValue);
	}
	
	@Override
	protected void doUnbindValue(GraphPart oldValue) {
		fModelValue.dispose();
	}


	public JFreeChart getChart() {
		return fGraphModelEditor.getChart();
	}
	
}
