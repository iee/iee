package org.eclipse.iee.sample.graph.pad;

import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class GraphElementPresenenter {

	private GraphElementComposite composite;

	private GraphModelPresenter modelPresenter;

	private GraphElement graphElement;

	public GraphElementPresenenter(final GraphElementComposite composite,
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
		Label inputView = composite.getfFormulaImageLabel();
		inputView.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				composite.toggleInputText();
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		composite.getFormulaText().getControl().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				composite.toggleFormulaImage();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
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
		getGraphElement().setNumberOfPoints(Integer.parseInt(composite.getPointsText().getText()));
		getGraphElement().setFunction(composite.getFormulaText().getDocument().get());
	}
	
	public void restore() {
		composite.getPointsText().setText(String.valueOf(getGraphElement().getNumberOfPoints()));
		if (getGraphElement().getFunction() !=  null) {
			composite.getFormulaText().getDocument().set(getGraphElement().getFunction());
		} else {
			composite.getFormulaText().getDocument().set("");
		}
	}
	

}
