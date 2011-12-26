package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.Activator;
import org.eclipse.iee.sample.matrix.pad.FormulaRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
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

	private FormulaRenderer fRenderer;

	private String fImagePath;
	protected Image fElementImage = null;

	private int fRowIndex;
	private int fColumnIndex;

	public ElementView(Composite parent, int style) {
		super(parent, style);
	}

	public ElementView(final Composite parent, int rowIndex, int columnIndex,
			boolean isTextVisible, String imagePath) {
		super(parent, SWT.NONE);

		fRenderer = new FormulaRenderer(parent.getDisplay());

		fRowIndex = rowIndex;
		fColumnIndex = columnIndex;
		fImagePath = imagePath;

		/*
		 * Drawing
		 */
		this.setLayout(new FillLayout(SWT.HORIZONTAL));

		final SashForm sashForm = new SashForm(this, SWT.HORIZONTAL);
		sashForm.setLayout(new FillLayout(SWT.HORIZONTAL));
		final StyledText styledText = new StyledText(sashForm, SWT.BORDER);
		styledText.setVisible(true);
		styledText.setText("TestTestTest");

		final Label label = new Label(sashForm, SWT.RESIZE);
		label.setImage(fElementImage);
		label.setVisible(false);

		this.pack();
		// Listeners
		styledText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (!styledText.getText().contains("\n")) {

					// translate to java

					System.out.println("before translation to TeX");
					try {
						String resultTex = Activator.getMolex().translateMath(
								styledText.getText());
						String hidden = resultTex.trim();
						fLatexContent = hidden;
						System.out.println(fLatexContent);

					} catch (Exception e1) {
						fLatexContent = "";
						// e1.printStackTrace();
					}
				} else {
					styledText.setVisible(false);
					fIsTextVisible = false;
					try {
						fElementImage = fRenderer
								.getFormulaImage(fLatexContent);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
					Point size = getSize();

					final Image resizedImage = new Image(parent.getDisplay(),
							fElementImage.getImageData().scaledTo(size.x,
									size.y));

					label.setImage(resizedImage);
					label.setVisible(true);
					redraw();
					label.pack();
					// pack();
				}
			}

		});

		this.addMouseTrackListener(new MouseTrackListener() {

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


		this.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent e) {

				if (fElementImage != null) {
					Point size = getSize();
					final Image resizedImage = new Image(parent.getDisplay(),
							fElementImage.getImageData().scaledTo(size.x,
									size.y));
					label.setImage(resizedImage);
					redraw();
				}

			}

			@Override
			public void controlMoved(ControlEvent e) {
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
