package org.eclipse.iee.pad.graph.ui;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.core.utils.ArrayUtils;
import org.eclipse.iee.editor.core.pad.FigurePad;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.editor.core.utils.runtime.file.IFileMessageListener;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.GraphPart;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Throwables;

public class GraphPad extends FigurePad<GraphPart> implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean fIsAdvancedMode;

	private GraphModelEditor fGraphModelEditor;
	
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

	private PropertyChangeListener fModelListener;
	
	@Override
	public IFigure createFigure() {
		fGraphModelEditor = new GraphModelEditor(formulaRenderer, new IShellProvider() {
			@Override
			public Shell getShell() {
				return getContainer().getTextWidget().getShell();
			}
		});
		FileMessager.getInstance().addFileMessageListener(fFileMessageListener, 
				getContainer().getContainerManager().getStoragePath());
		return fGraphModelEditor.getFigure();
	}


	public void initModelView(final IGraphView root, GraphModel model) {
		
	}

	@Override
	public GraphPad copy() {
		GraphPad newPad = new GraphPad(getDocumentPart().copy(), formulaRenderer);
		newPad.fIsAdvancedMode = this.fIsAdvancedMode;
		return newPad;
	}

	public void save() {
		processInput(getDocumentPart().getModel());
	}

	@Override
	public void unsave() {
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
	public void dispose() {
		super.dispose();
		getDocumentPart().getModel().addPropertyChangeListener(fModelListener);
		fGraphModelEditor.dispose();
	}

}
