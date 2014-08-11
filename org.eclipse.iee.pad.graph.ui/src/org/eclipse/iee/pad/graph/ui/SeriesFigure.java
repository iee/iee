package org.eclipse.iee.pad.graph.ui;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.widgets.Caret;

public class SeriesFigure extends Figure {
	
	private TextFigure fMinY;
	private Figure fSeries;
	private TextFigure fMaxY;
	
	public SeriesFigure(Caret caret) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		setLayoutManager(layout);
		fMinY = new TextFigure(caret);
		GridData minXdata = new GridData();
		add(fMinY, minXdata);
		fSeries = new Figure();
		fSeries.setLayoutManager(new ToolbarLayout(false));
		GridData seriesData = new GridData(GridData.GRAB_VERTICAL 
				| GridData.VERTICAL_ALIGN_CENTER);
		add(fSeries, seriesData);
		fMaxY = new TextFigure(caret);
		GridData maxXdata = new GridData();
		maxXdata.horizontalAlignment = GridData.END;
		add(fMaxY, maxXdata);
	}

	public void addElement(GraphElementFigure elementComposite) {
		fSeries.add(elementComposite);
	}
	
	public void setMinYText(String string) {
		fMinY.setText(string);
	}

	public String getMinYText() {
		return fMinY.getText();
	}
	
	public void setMaxYText(String string) {
		fMaxY.setText(string);
	}

	public String getMaxYText() {
		return fMaxY.getText();
	}

}
