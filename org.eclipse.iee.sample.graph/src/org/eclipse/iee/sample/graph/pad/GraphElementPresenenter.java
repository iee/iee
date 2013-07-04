package org.eclipse.iee.sample.graph.pad;

import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

public class GraphElementPresenenter {

	private GraphElementComposite composite;

	private GraphModelPresenter modelPresenter;

	private GraphElement graphElement;

	public GraphElementPresenenter(GraphElementComposite composite,
			GraphModelPresenter modelPresenter, GraphElement graphElement) {
		super();
		this.composite = composite;
		this.modelPresenter = modelPresenter;
		this.graphElement = graphElement;
		
		Button plusButton = composite.getPlusButton();
		plusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GraphElementPresenenter.this.modelPresenter.addNewElement();
			}
		});
		Button minusButton = composite.getMinusButton();
		minusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GraphElementPresenenter.this.modelPresenter.removeElement(GraphElementPresenenter.this);
			}
		});
		restore();
	}
	
	public GraphElement getGraphElement() {
		return graphElement;
	}
	
	public void remove() {
		composite.dispose();
	}
	
	public void save() {
		getGraphElement().setfDomainCardinality(Integer.parseInt(composite.getPointsText().getText()));
		getGraphElement().setfFunction(composite.getFormulaText().getText());
	}
	
	public void restore() {
		composite.getPointsText().setText(String.valueOf(getGraphElement().getfDomainCardinality()));
		if (getGraphElement().getfFunction() !=  null) {
			composite.getFormulaText().setText(getGraphElement().getfFunction());
		} else {
			composite.getFormulaText().setText("");
		}
	}
	

}
