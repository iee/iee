package org.eclipse.iee.sample.graph.pad;

import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jfree.util.PaintUtilities;

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
		
		Label inputView = composite.getfFormulaImageLabel();
		inputView.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				if (e.button == 1) {
					composite.toggleInputText();
				}
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
				GraphElementPresenenter.this.modelPresenter.pack();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		composite.toggleFormulaImage();
		String color = graphElement.getColor();
		if (color == null) {
			color = modelPresenter.getNextColor();
			graphElement.setColor(color);
		}
		composite.setColor(PaintUtilities.stringToColor(color));
		composite.setWidth(graphElement.getWidth());
		composite.getAddItem().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GraphElementPresenenter.this.modelPresenter.addNewElement();
			}
		});
		composite.getRemoveItem().addSelectionListener(new SelectionAdapter() {
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
		getGraphElement().setNumberOfPoints(100);
		getGraphElement().setFunction(composite.getFormulaText().getDocument().get());
	}
	
	public void restore() {
		if (getGraphElement().getFunction() !=  null) {
			composite.getFormulaText().getDocument().set(getGraphElement().getFunction());
		} else {
			composite.getFormulaText().getDocument().set("");
		}
		composite.processInput();
	}
	

}
