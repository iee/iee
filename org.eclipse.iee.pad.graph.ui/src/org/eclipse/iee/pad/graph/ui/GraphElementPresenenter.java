package org.eclipse.iee.pad.graph.ui;

import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.jfree.experimental.swt.SWTUtils;
import org.jfree.util.PaintUtilities;

public class GraphElementPresenenter {

	private GraphElementComposite composite;

	private GraphModelPresenter modelPresenter;

	private GraphElement graphElement;

	public GraphElementPresenenter(final GraphElementComposite composite,
			GraphModelPresenter modelPresenter, final GraphElement graphElement) {
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
		composite.getPropertiesItem().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				Dialog dialog = new Dialog(composite.getShell()) {
					
					private ElementProperties elementProperties;

					@Override
					protected Control createDialogArea(Composite parent) {
						elementProperties = new ElementProperties(parent, SWT.NONE);
						elementProperties.getWidthSpinner().setSelection(graphElement.getWidth());
						elementProperties.getColorSelector().setColorValue(SWTUtils.toSwtColor(e.display, PaintUtilities.stringToColor(graphElement.getColor())).getRGB());
						elementProperties.getPointsText().setText(StringConverter.asString(graphElement.getNumberOfPoints()));
						return elementProperties;
					}
					
					@Override
					protected void okPressed() {
						int width = elementProperties.getWidthSpinner().getSelection();
						graphElement.setWidth(width);
						RGB colorValue = elementProperties.getColorSelector().getColorValue();
						java.awt.Color awtColor = SWTUtils.toAwtColor(new Color(e.display, colorValue));
						graphElement.setColor(PaintUtilities.colorToString(awtColor));
						graphElement.setNumberOfPoints(StringConverter.asInt(elementProperties.getPointsText().getText()));
						super.okPressed();
						composite.setColor(awtColor);
						composite.setWidth(width);
					}
					
				};
				dialog.open();
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
