package org.eclipse.iee.sample.formula.pad;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.console.ConsoleMessageEvent;
import org.eclipse.iee.editor.core.utils.console.ConsoleMessager;
import org.eclipse.iee.editor.core.utils.console.IConsoleMessageListener;
import org.eclipse.iee.sample.formula.FileStorage;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class FormulaPad extends Pad implements Serializable {

	private transient static FileStorage fFileStorage;
	
	private Composite fParent;
	
	private Label fFormulaImageLabel;
	private Label fLastResultImageLabel;
	
	private StyledText fInputText;
	private Label fTempFormulaImageLabel;
	
	private boolean fIsInputValid;
	private String fExpression = "x = 123";
	
	private final Color INPUT_VALID_COLOR = new Color(null, 255, 255, 255);
	private final Color INPUT_INVALID_COLOR = new Color(null, 128, 255, 255);

	private IConsoleMessageListener fConsoleMessageListener = new IConsoleMessageListener() {
		@Override
		public void messageReceived(ConsoleMessageEvent e) {
			System.out.println("Message received:" + e.getMessage());
			updateLastResult(e.getMessage());
		}
		
		@Override
		public String getRequesterID() {
			return getContainerID();
		}
	};
	
	public FormulaPad() {
		setType("Math");
	}
	
	protected FormulaPad(String containerID) {
		super(containerID);
		setType("Math");
	}
		
	public void toggleInputText() {
		// OFF
		fFormulaImageLabel.setVisible(false);
		fLastResultImageLabel.setVisible(false);
		
		// ON
		fInputText.setText(fExpression);
		fInputText.setVisible(true);
		fTempFormulaImageLabel.setVisible(true);
		
		fParent.pack();
		
		fInputText.forceFocus();
	}
	
	public void toggleFormulaImage() {
		// OFF
		fInputText.setVisible(false);
		fTempFormulaImageLabel.setVisible(false);
		
		// ON
		fFormulaImageLabel.setVisible(true);
		fLastResultImageLabel.setVisible(true);
		
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
		
		/* Set formula image */
		Image image = FormulaRenderer.getFormulaImage(fExpression);
		fFormulaImageLabel.setImage(image);
		
		/* Generate code */
		String generated = Translator.translateElement(fExpression);
		
		/* Add result output */
		generated += generateOutputCode(fExpression);
		getContainer().setTextContent(generated);
	}
	
	public String generateOutputCode(String expresion) {
	
		System.out.println("Original: " + expresion);
		
		Pattern p = Pattern.compile("\\s*\\w+\\s*=.+");
		Matcher m = p.matcher(expresion);
		if (m.matches()) {
			System.out.println("Match");
			String variable = expresion.substring(0, expresion.indexOf('='));
			variable = variable.trim();
			return "System.out.println(\"" + getContainerID() + "\" + " + variable + ");";
		} else {
			System.out.println("Not match");
			return "";
		}
	}
	
	public void updateLastResult(String result) {
		Image image = FormulaRenderer.getFormulaImage(result);
		fLastResultImageLabel.setImage(image);
	}

	public void setListeners() {
		ConsoleMessager.getInstance().addConsoleMessageListener(fConsoleMessageListener);
		
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
				
				if (fIsInputValid) {
					// render temp image
					Image image = FormulaRenderer.getFormulaImage(fInputText.getText());
					fTempFormulaImageLabel.setImage(image);
				} else {
					fTempFormulaImageLabel.setImage(null);
				}
				
				/* Resize fInputText */
				Point size = fInputText.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
				fInputText.setSize(size);
				fParent.pack();
			}
		});
						
		fInputText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent e) {
				switch (e.keyCode) {
				case SWT.CR:
					e.doit = false;
					processInput();
					moveCaretToCurrentPad();
					toggleFormulaImage();
					break;
					
				case SWT.ESC:
					moveCaretToCurrentPad();
					toggleFormulaImage();
					break;
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
		SashForm sashForm = new SashForm(fParent, SWT.VERTICAL);
		sashForm.setLayout(new GridLayout());
		
		SashForm tempForm = new SashForm(fParent, SWT.VERTICAL);
		tempForm.setLayout(new GridLayout());
		tempForm.setVisible(true);
		
		/* First view */
		
		fFormulaImageLabel = new Label(sashForm, SWT.NONE | SWT.RESIZE);
		GridData formulaImageGridData = new GridData();
		formulaImageGridData.verticalAlignment = GridData.FILL;
		formulaImageGridData.grabExcessVerticalSpace = true;
		formulaImageGridData.horizontalAlignment = GridData.FILL;
		formulaImageGridData.grabExcessHorizontalSpace = true;
		fFormulaImageLabel.setLayoutData(formulaImageGridData);
		
		fLastResultImageLabel = new Label(tempForm,  SWT.BORDER | SWT.RESIZE);
		GridData lastResultImageGridData = new GridData();
		lastResultImageGridData.verticalAlignment = GridData.FILL;
		lastResultImageGridData.grabExcessVerticalSpace = true;
		lastResultImageGridData.horizontalAlignment = GridData.FILL;
		lastResultImageGridData.grabExcessHorizontalSpace = true;
		fLastResultImageLabel.setLayoutData(lastResultImageGridData);
		
		/* Second view */
		
		fInputText = new StyledText(sashForm, SWT.SINGLE | SWT.RESIZE);
		GridData inputTextGridData =  new GridData();
		inputTextGridData.horizontalAlignment = GridData.FILL;
		fInputText.setLayoutData(inputTextGridData);
		fInputText.setSize(50, 100);
		
		fTempFormulaImageLabel = new Label(sashForm, SWT.NONE | SWT.RESIZE);
		GridData tempLabelGridData = new GridData();
		tempLabelGridData.verticalAlignment = GridData.FILL;
		tempLabelGridData.grabExcessVerticalSpace = true;
		tempLabelGridData.horizontalAlignment = GridData.FILL;
		tempLabelGridData.grabExcessHorizontalSpace = true;
		fTempFormulaImageLabel.setLayoutData(tempLabelGridData);
		
		setListeners();
		
		validateInput();
		processInput();
		toggleFormulaImage();
	}

	public static void setStorage(FileStorage fStorage) {
		FormulaPad.fFileStorage = fStorage;
	}
	
	@Override
	public void activate() {
		toggleInputText();
	}

	@Override
	public Pad copy() {
		FormulaPad newPad = new FormulaPad();
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
