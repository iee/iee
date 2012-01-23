package org.eclipse.iee.sample.math.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.math.FileStorage;
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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MathPad extends Pad implements Serializable {

	private transient static FileStorage fFileStorage;
	
	private Composite fParent;
	private Label fFormulaImageLabel;
	private StyledText fInputText;
	
	private boolean fIsInputValid;
	private String fExpression = "1337";
	
	private final Color INPUT_VALID_COLOR = new Color(null, 255, 255, 255);
	private final Color INPUT_INVALID_COLOR = new Color(null, 128, 255, 255);
	
	public MathPad() {
		setType("Math");
	}
	
	protected MathPad(String containerID) {
		super(containerID);
		setType("Math");
	}
		
	public void toggleInputText() {
		fFormulaImageLabel.setVisible(false);
		
		fInputText.setText(fExpression);
		fInputText.setVisible(true);
		
		fParent.pack();
		
		fInputText.forceFocus();
	}
	
	public void toggleFormulaImage() {
		fInputText.setVisible(false);
		fFormulaImageLabel.setVisible(true);
		
		fParent.pack();
	}

	public void setInputIsValid() {
		fIsInputValid = true;
		fInputText.setBackground(INPUT_VALID_COLOR);
	}
	
	public void setInputIsInvalid() {
		fIsInputValid = false;
		fInputText.setBackground(INPUT_INVALID_COLOR);
	}
	
	public void validateInput() {
		String text = fInputText.getText();
		if (Translator.isTextValid(text) && FormulaRenderer.isTextValid(text)) {
			setInputIsValid();	
		} else {
			setInputIsInvalid();
		}
	}
	
	public void processInput() {
		if (fIsInputValid) {
			fExpression = fInputText.getText();
		}
		
		Image image = FormulaRenderer.getFormulaImage(fExpression);
		fFormulaImageLabel.setImage(image);

		String generated = Translator.translateElement(fExpression);
		getContainer().setTextContent(generated);
	}

	public void setListeners() {
		fFormulaImageLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				moveCaretToCurrentPad();
				toggleInputText();
			}

			@Override public void mouseDown(MouseEvent e) {
				moveCaretToCurrentPad();
			}
			
			@Override public void mouseUp(MouseEvent e) {}		
		});
		
		fInputText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateInput();
				
				/* Resize fInputText */
				Point size = fInputText.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
				fInputText.setSize(size);
				fParent.pack();
			}
		});
						
		fInputText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent e) {
				if (e.keyCode == SWT.CR) {
					e.doit = false;
					processInput();
					moveCaretToCurrentPad();
					toggleFormulaImage();
				}
			}
		});
		
		fInputText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				toggleFormulaImage();
			}
			
			@Override public void focusGained(FocusEvent e) {}
		});
	}

	@Override
	public void createPartControl(final Composite parent) {		
		fParent = parent;
		
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		parent.setLayout(layout);
		SashForm sashForm = new SashForm(fParent, SWT.HORIZONTAL);
		sashForm.setLayout(new FillLayout());
		
		fInputText = new StyledText(sashForm, SWT.SINGLE | SWT.RESIZE);
		fFormulaImageLabel = new Label(sashForm, SWT.NONE | SWT.RESIZE);
		setListeners();
		
		validateInput();
		processInput();
		toggleFormulaImage();
	}

	public static void setStorage(FileStorage fStorage) {
		MathPad.fFileStorage = fStorage;
	}
	
	@Override
	public void activate() {
		toggleInputText();
	}

	@Override
	public Pad copy() {
		MathPad newPad = new MathPad();
		newPad.fExpression = this.fExpression;
		return newPad;
	}

	// Save&Load operations, use it for serialization

	public void save() {
		//MathPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		//MathPad.fFileStorage.removeFile(getContainerID());
	}

	@Override
	public void onContainerAttached() {
	}


}
