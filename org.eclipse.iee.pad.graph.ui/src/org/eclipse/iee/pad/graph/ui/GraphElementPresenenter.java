package org.eclipse.iee.pad.graph.ui;

import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.jfree.experimental.swt.SWTUtils;
import org.jfree.util.PaintUtilities;

public class GraphElementPresenenter {

	private GraphElementFigure fFigure;

	private GraphModelPresenter fModelPresenter;

	private GraphElement fGraphElement;

	public GraphElementPresenenter(final GraphElementFigure figure,
			GraphModelPresenter modelPresenter, final GraphElement graphElement) {
		super();
		this.fFigure = figure;
		this.fModelPresenter = modelPresenter;
		this.fGraphElement = graphElement;
		
		figure.addMouseListener(new org.eclipse.draw2d.MouseListener() {
			
			@Override
			public void mouseReleased(org.eclipse.draw2d.MouseEvent me) {
				if (me.button == 1) {
					figure.toggleInputText();
				}
			}
			
			@Override
			public void mousePressed(org.eclipse.draw2d.MouseEvent me) {
			}
			
			@Override
			public void mouseDoubleClicked(org.eclipse.draw2d.MouseEvent me) {
			}
		});
		figure.addFocusListener(new org.eclipse.draw2d.FocusListener() {

			@Override
			public void focusGained(org.eclipse.draw2d.FocusEvent fe) {
			}

			@Override
			public void focusLost(org.eclipse.draw2d.FocusEvent fe) {
				figure.toggleFormulaImage();
				GraphElementPresenenter.this.fModelPresenter.pack();
				
			}});
		figure.toggleFormulaImage();
		String color = graphElement.getColor();
		if (color == null) {
			color = modelPresenter.getNextColor();
			graphElement.setColor(color);
		}
		figure.setColor(PaintUtilities.stringToColor(color));
		figure.setWidth(graphElement.getWidth());
		figure.addAddClickListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GraphElementPresenenter.this.fModelPresenter.addNewElement();
			}
		});
		figure.addRemoveClickListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GraphElementPresenenter.this.fModelPresenter.removeElement(GraphElementPresenenter.this);
			}
		});
		figure.addPropertiesClickListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				Dialog dialog = new Dialog(fModelPresenter.getShell()) {
					
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
						figure.setColor(awtColor);
						figure.setWidth(width);
					}
					
				};
				dialog.open();
			}
		});
		
		restore();
	}
	
	public GraphElement getGraphElement() {
		return fGraphElement;
	}
	
	public void remove() {
	}
	
	public void save() {
		getGraphElement().setNumberOfPoints(100);
		getGraphElement().setFunction(fFigure.getFormulaText());
	}
	
	public void restore() {
		if (getGraphElement().getFunction() !=  null) {
			fFigure.setFormulaText(getGraphElement().getFunction());
		} else {
			fFigure.setFormulaText("");
		}
	}
	

}
