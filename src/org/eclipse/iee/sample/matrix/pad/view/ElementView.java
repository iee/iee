package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.pad.FormulaRenderer;
import org.eclipse.iee.sample.matrix.pad.IConfiguration;
import org.eclipse.iee.sample.matrix.pad.Translator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ElementView extends Composite {

	private int fCurrentState = -1;
	private final int ST_IMAGE = 0;
	private final int ST_EDIT = 1;
	private final int ST_INVALID = 2;

	
	private Color fElementBorderColor = IConfiguration.ELEMENT_BORDER_COLOR_NOT_SELECTED;
	
	private boolean fIsSelected = false;
	
	private boolean fIsContentValid;
	private String fContent;
	
	/* Controls */
	
	private StyledText fStyledText;
	private Label fImageLabel;
	private Label fErrorLabel;
	
	
	/* Actions: */
	
	protected void applyNewContent(String text) {
		fContent = text;
		// XXX modify model
		showImageView();
	}
	
	protected void revertContent() {
		/* Leaving fContent without modifications */
		fIsContentValid = true;
		showImageView();
	}
	
	protected void removeSelection() {
		fIsSelected = false;
		// XXX notify parent
	}
	
	protected void processText(String text) {
		if (Translator.isTextValid(text) && FormulaRenderer.isTextValid(text)) {
			fIsContentValid = true;
			this.setBackground(IConfiguration.ELEMENT_BORDER_COLOR_SELECTED);
		} else {
			fIsContentValid = false;
			this.setBackground(IConfiguration.ELEMENT_BORDER_COLOR_INVALID);
		}
	}
		
	public ElementView(final Composite parent, String content) {
		
		/* Initialize */
		super(parent, SWT.NONE);
		initControls(parent);
		initListeners();
		
		/* Process initial content */
		processText(content);
		
		if (fIsContentValid) {
			showImageView();
		} else {
			showErrorView();
		}
	}
	
	protected void initControls(Composite parent) {
		
		FillLayout layout = new FillLayout();
		layout.marginHeight = IConfiguration.ELEMENT_BORDER_WIDTH;
		layout.marginWidth = IConfiguration.ELEMENT_BORDER_WIDTH;
		this.setLayout(layout);
		this.setBackground(fElementBorderColor);
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setLayout(new FillLayout());
		
		fStyledText = new StyledText(sashForm, SWT.BORDER);
		fStyledText.setVisible(true);
		
		fImageLabel = new Label(sashForm, SWT.RESIZE);
		fImageLabel.setVisible(false);
		
		fErrorLabel = new Label(sashForm, SWT.RESIZE);
		fErrorLabel.setVisible(false);

		this.pack();
	}
	
	protected void initListeners() {
		fStyledText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				processText(fStyledText.getText());
			}
		});
		
		fStyledText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				
				switch (event.keyCode) {
				
				case SWT.CR:
					if (fIsContentValid) {
						applyNewContent(fStyledText.getText());
					} else {
						revertContent();						
					}
					break;
					
				case SWT.ESC:
					revertContent();
					break;
				}
			}
		});
		
		fStyledText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				removeSelection();
				revertContent();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	}
	
	protected void showImageView() {
		/* Disable other views*/
		fStyledText.setVisible(false);
		fErrorLabel.setVisible(false);
		
		if (fIsSelected) {
			this.setBackground(IConfiguration.ELEMENT_BORDER_COLOR_SELECTED);
		} else {
			this.setBackground(IConfiguration.ELEMENT_BORDER_COLOR_NOT_SELECTED);
		}
		
		Image image = FormulaRenderer.getFormulaImage(fContent);
		fImageLabel.setImage(image);
		fImageLabel.setVisible(true);
		fImageLabel.pack();
		redraw();
	}
	
	protected void showEditView() {
	}
	
	protected void showErrorView() {
		
	}
}
