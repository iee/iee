package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class ElementView extends Composite {

	private String fText;
	private String fLatexContent;
	private String fJavaContent;
	private boolean fIsTextVisible;
	private boolean fIsSelected;
	
	private String fImagePath;

	private int fRowIndex;
	private int fColumnIndex;

	public ElementView(Composite parent, int style) {
		super(parent, style);
	}

	public ElementView(final Composite parent, int rowIndex,
			int columnIndex, boolean isTextVisible, String imagePath) {
		super(parent, SWT.NONE);

		fRowIndex = rowIndex;
		fColumnIndex = columnIndex;
		fImagePath = imagePath;

		/*
		 * Drawing
		 */
		this.setLayout(new FillLayout(SWT.HORIZONTAL));
		this.setBounds(0, 0, 500, 500);

		final SashForm sashForm = new SashForm(this, SWT.HORIZONTAL);
		sashForm.setLayout(new FillLayout(SWT.HORIZONTAL));
		final StyledText styledText = new StyledText(sashForm, SWT.BORDER);
		styledText.setVisible(true);
		styledText.setText("TestTestTest");

		final Label fFormulaImage = new Label(sashForm, SWT.RESIZE);
		fFormulaImage.setVisible(false);
		
		this.pack();
		// Listeners
		styledText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (!styledText.getText().contains("\n")) {
					
					//translate to java 

					System.out.println("before translation to TeX");
					try {
						String resultTex = Activator.getMolex().translateMath(
								styledText.getText());
						String hidden = resultTex.trim();
						fLatexContent = hidden;
						System.out.println(fLatexContent);
						TeXFormula texFormula = new TeXFormula(fLatexContent);
						texFormula.createJPEG(TeXConstants.STYLE_DISPLAY, 60,
								fImagePath, java.awt.Color.white,
								java.awt.Color.black);
					} catch (Exception e1) {
						fLatexContent = "";
						// e1.printStackTrace();
					}
				} else {
					styledText.setVisible(false);
					fIsTextVisible = false;
					Image image = null;
					try {
						image = new Image(parent.getDisplay(), fImagePath);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
					fFormulaImage.setImage(image);
					fFormulaImage.setSize(image.getBounds().width,
							image.getBounds().height);
					fFormulaImage.setVisible(true);
					//parent.pack();
				}
			}

		});
	}

	/*
	 * Getters
	 */

	public int getRowIndex() {
		return fRowIndex;
	}

	public int getColumnIndex() {
		return fColumnIndex;
	}

}
