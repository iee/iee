package org.eclipse.iee.pad.graph.ui;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Display;
import org.jfree.experimental.swt.SWTUtils;

public class GraphElementFigure extends Figure {

	private ImageFigure fFormulaImage;
	private TextFigure fTextFigure;
	private Label fLine;
	
	private UIFormulaRenderer formulaRenderer;
	
	public GraphElementFigure(Caret caret, UIFormulaRenderer formulaRenderer) {
		this.formulaRenderer = formulaRenderer;
		setLayoutManager(new ToolbarLayout(false));
		fFormulaImage = new ImageFigure();
		fTextFigure = new TextFigure(caret);
		fLine = new Label();
		toggleFormulaImage();
		
		fTextFigure.addDocumentListener(new IDocumentListener() {
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
			}

			@Override
			public void documentChanged(DocumentEvent event) {
				String s = event.getDocument().get();
				Image newImage = createImage();
				if (newImage != null) {
					fFormulaImage.setImage(newImage);
				}
				revalidate();
			}
		});
	}
	
	public String getFormulaText() {
		return fTextFigure.getText();
	}

	public void setFormulaText(String function) {
		fTextFigure.setText(function);
	}

	public void setColor(java.awt.Color awtColor) {
		fLine.setBackgroundColor(SWTUtils.toSwtColor(Display.getDefault(), awtColor));
	}

	public void setWidth(int width) {
		fLine.setSize(getSize().width, width);
	}

	public void addAddClickListener(SelectionAdapter selectionAdapter) {
		// TODO Auto-generated method stub
		
	}

	public void addRemoveClickListener(SelectionAdapter selectionAdapter) {
		// TODO Auto-generated method stub
		
	}

	public void toggleInputText() {
		removeAll();
		add(fTextFigure);
		add(fLine);
		fTextFigure.requestFocus();
	}

	public void toggleFormulaImage() {
		removeAll();
		add(fFormulaImage);
		add(fLine);
	}

	public void addPropertiesClickListener(SelectionAdapter selectionAdapter) {
		// TODO Auto-generated method stub
		
	}
	

	
	private Image createImage() {
		String fTexExpression = fTextFigure.getText();
		Image image = null;
		if (fTexExpression != null) {
			image = formulaRenderer.getFormulaImage(fTexExpression);
		}
		return image;
	}
	
	@Override
	public void addFocusListener(FocusListener listener) {
		fTextFigure.addFocusListener(listener);
	}
	
	@Override
	public void removeFocusListener(FocusListener listener) {
		fTextFigure.removeFocusListener(listener);
	}

}