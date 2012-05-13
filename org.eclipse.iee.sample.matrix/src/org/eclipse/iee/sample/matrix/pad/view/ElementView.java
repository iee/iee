package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.pad.FormulaRenderer;
import org.eclipse.iee.sample.matrix.pad.controller.Controller;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

	
public class ElementView {
	private Controller fController;
	
	private Composite fParent;
	private Composite fComposite;
	
	
	/* View variables */
	
	private final Color INPUT_VALID_COLOR = new Color(null, 255, 255, 255);
	private final Color INPUT_INVALID_COLOR = new Color(null, 128, 255, 255);
	
	private Label fFormulaImageLabel;
	private StyledText fInputText;
	
	private HoverShell fHoverShell;
	
	
	/* Model variables */
	
	private int fRow;
	private int fColumn;
	
	private String fExpression = "0";
	private String fLastValidText = "0";
	
	
	/* Logic functions */
	
	public ElementView(Controller controller, int row, int column) {
		fController = controller;
		fRow = row;
		fColumn = column;
	}
	
	public String getExpression() {
		return fExpression;
	}
	
	public Composite getComposite() {
		return fComposite;
	}
	
	public void setExpression(String expression) {
		fExpression = expression;
		toggleFormulaImage();
	}
	
	public void proccessUserInput() {
		if (validateExpression(fInputText.getText())) {
			fExpression = fInputText.getText();
			fController.setElementValue(fRow, fColumn, fExpression);
		}		
	}
		
	public boolean validateExpression(String expression) {
		return fController.validateExpression(expression) && FormulaRenderer.isTextValid(expression); 
	}
	
	public void setListeners() {
		fFormulaImageLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				fController.selectCurrentPad();
				toggleInputText();
			}

			@Override public void mouseDown(MouseEvent e) {	
				fController.selectCurrentPad();
			}
			
			@Override public void mouseUp(MouseEvent e) {}
		});
				
		fInputText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String text = fInputText.getText(); 
				if (validateExpression(text)) {
					setInputIsValid();
					fLastValidText = text;
				} else {
					setInputIsInvalid();
				}
				
				Image image = FormulaRenderer.getFormulaImage(fInputText
						.getText());
				if (image == null)
					image = FormulaRenderer.getFormulaImage(fLastValidText);
				if (fHoverShell != null)
					fHoverShell.dispose();
				fHoverShell = new HoverShell(fComposite, image);
				
				resizeInputText();
			}
		});
						
		fInputText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent e) {
				switch (e.keyCode) {
				case SWT.CR:
					e.doit = false;
					fController.selectCurrentPad();
					proccessUserInput();
					toggleFormulaImage();
					fHoverShell.dispose();
					break;
					
				case SWT.ESC:
					fController.selectCurrentPad();
					toggleFormulaImage();
					fHoverShell.dispose();
					break;
				}
			}
		});
		
		fInputText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				toggleFormulaImage();
				fHoverShell.dispose();
			}
			
			@Override public void focusGained(FocusEvent e) {}
		});
	}
	
	
	/* View functions */
	
	public void toggleFormulaImage() {		
		// OFF
		fInputText.setVisible(false);
		
		// ON
		Image image = FormulaRenderer.getFormulaImage(fExpression);
		fFormulaImageLabel.setImage(image);
		fFormulaImageLabel.setVisible(true);
		
		fParent.pack();
	}
	
	public void toggleInputText() {
		// OFF
		fFormulaImageLabel.setVisible(false);
		
		// ON
		fInputText.setText(fExpression);
		fInputText.setVisible(true);
		
		fParent.pack();
		
		fInputText.forceFocus();
	}

	public void resizeInputText() {
		Point size = fInputText.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
		fInputText.setSize(size);
		fParent.pack();
	}
	
	public void setInputIsValid() {
		fInputText.setBackground(INPUT_VALID_COLOR);
	}
	
	public void setInputIsInvalid() {
		fInputText.setBackground(INPUT_INVALID_COLOR);
	}

	public void createPartControl(final Composite parent) {		
		fParent = parent;

		fComposite =  new SashForm(parent, SWT.VERTICAL);
		GridData elementLayoutData = new GridData(SWT.CENTER, SWT.FILL, true, true);
		fComposite.setLayoutData(elementLayoutData);
		/* First view */
		fFormulaImageLabel = new Label(fComposite, SWT.NONE | SWT.RESIZE);
				
		/* Second view */
		fInputText = new StyledText(fComposite, SWT.SINGLE | SWT.RESIZE);
		
		setListeners();
		
		toggleFormulaImage();
	}
	
	public boolean isDisposed() {
		return fComposite == null || fComposite.isDisposed();
	}
	
	public void dispose() {
		fComposite.dispose();
	}
}
