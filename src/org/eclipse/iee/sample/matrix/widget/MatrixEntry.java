package org.eclipse.iee.sample.matrix.widget;

import org.eclipse.iee.sample.matrix.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class MatrixEntry extends Composite {

	private String fText;
	private String fLatexContent;
	private String fJavaContent;
	private boolean fIsTextVisible;
	private boolean fIsSelected;
	
	private String fImagePath;

	private int fRowIndex;
	private int fColumnIndex;

	public MatrixEntry(Composite parent, int style) {
		super(parent, style);
	}

	public MatrixEntry(final Composite parent, int style, int rowIndex,
			int columnIndex, boolean isTextVisible, String imagePath) {
		super(parent, style);

		fRowIndex = rowIndex;
		fColumnIndex = columnIndex;
		fImagePath = imagePath;

		/*
		 * Drawing
		 */
		FillLayout entryLayout = new FillLayout(SWT.HORIZONTAL);
		entryLayout.marginHeight = 1;
		entryLayout.marginWidth = 1;
		this.setLayout(entryLayout);
		this.setSize(300, 300);
		this.setBounds(0, 0, 300, 300);
		this.setBackground(new Color(null, 255, 255, 255));

		final SashForm sashForm = new SashForm(this, SWT.HORIZONTAL);
		sashForm.setLayout(new FillLayout(SWT.HORIZONTAL));
		final StyledText styledText = new StyledText(sashForm, SWT.BORDER);
		styledText.setVisible(true);
		styledText.setText("TestTestTest");

		final Label formulaImage = new Label(sashForm, SWT.RESIZE);
		formulaImage.setVisible(false);
		
		// Listeners
		styledText.addMouseTrackListener(new MouseTrackListener() {
			
			@Override
			public void mouseHover(MouseEvent e) {
				setBackground(new Color(null, 0, 0, 0));
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				setBackground(new Color(null, 255, 255, 255));
			}
			
			@Override
			public void mouseEnter(MouseEvent e) {	
				setBackground(new Color(null, 0, 0, 0));
			}
		});
		
		formulaImage.addMouseTrackListener(new MouseTrackListener() {
			
			@Override
			public void mouseHover(MouseEvent e) {
				setBackground(new Color(null, 0, 0, 0));
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				setBackground(new Color(null, 255, 255, 255));
			}
			
			@Override
			public void mouseEnter(MouseEvent e) {	
				setBackground(new Color(null, 0, 0, 0));
			}
		});

		styledText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (!styledText.getText().contains("\n")) {
					System.out.println("before translation to Java");
					try {
						fText = styledText.getText();
						String resultJava = Activator.getMole().translateMath(
								styledText.getText());
						fJavaContent = resultJava.trim();
						if (fJavaContent.matches(";")) {
							fJavaContent = "";
						}
						System.out.println(fJavaContent);
						
					} catch (Exception e1) {
						fJavaContent = "";
						// e1.printStackTrace();
					}

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
					formulaImage.setImage(image);
					formulaImage.setSize(image.getBounds().width,
							image.getBounds().height);
					formulaImage.setVisible(true);
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
