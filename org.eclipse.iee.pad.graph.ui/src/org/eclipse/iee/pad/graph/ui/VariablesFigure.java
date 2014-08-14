package org.eclipse.iee.pad.graph.ui;


import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.swt.widgets.Caret;

public class VariablesFigure extends Figure {

	private TextFigure fMinX;
	private TextFigure fVars;
	private TextFigure fMaxX;

	public VariablesFigure(Caret caret) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		setLayoutManager(layout);
		fMinX = new TextFigure(caret);
		GridData minXdata = new GridData();
		add(fMinX, minXdata);
		fVars = new TextFigure(caret);
		GridData varsData = new GridData();
		varsData.horizontalAlignment = GridData.CENTER;
		varsData.grabExcessHorizontalSpace = true;
		add(fVars, varsData);
		fMaxX = new TextFigure(caret);
		GridData maxXdata = new GridData();
		maxXdata.horizontalAlignment = GridData.END;
		add(fMaxX, maxXdata);
	}
	
	public void setVarsText(String string) {
		fVars.setText(string);
	}

	public String getVarsText() {
		return fVars.getText();
	}
	
	public void setMinXText(String string) {
		fMinX.setText(string);
	}

	public String getMinXText() {
		return fMinX.getText();
	}
	
	public void setMaxXText(String string) {
		fMaxX.setText(string);
	}

	public String getMaxXText() {
		return fMaxX.getText();
	}

	public void addMinXFocusListener(FocusListener focusListener) {
		fMinX.addFocusListener(focusListener);
	}

	public void addMaxXFocusListener(FocusListener focusListener) {
		fMaxX.addFocusListener(focusListener);
	}

}
