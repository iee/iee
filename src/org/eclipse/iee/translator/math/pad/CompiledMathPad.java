package org.eclipse.iee.translator.math.pad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.translator.math.Activator;
import org.eclipse.iee.translator.math.FileStorage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class CompiledMathPad extends Pad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private transient static FileStorage fFileStorage;

	private String fText;
	private String fLatexContent;
	private String fJavaContent;
	private String fImagePath;
	private boolean fIsTextVisible;

	public CompiledMathPad() {
		super();
		fImagePath = fFileStorage.getDirectoryPath() + this.getContainerID()
				+ ".jpg";
		setType("CompiledMath");
		fText = "";
		fIsTextVisible = true;
		fLatexContent = "";
		fJavaContent = "";
		// save();
	}

	@Override
	public void createPartControl(final Composite parent) {
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		// It is hint operation now
		parent.setBackground(new Color(null, 255, 255, 255));
		SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.BORDER);
		sashForm.setLayout(new FillLayout());
		final StyledText styledText = new StyledText(sashForm, SWT.NONE);
		styledText.setText(fText);
		styledText.setVisible(fIsTextVisible);

		final Label label = new Label(sashForm, SWT.NONE | SWT.RESIZE);
		if (!fImagePath.isEmpty()) {
			File imageFile = new File(fImagePath);
			Image image = null;
			if (imageFile.exists()) {
				try {
					image = new Image(parent.getDisplay(), fImagePath);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				label.setImage(image);
				parent.pack();
			}
		}
		label.setToolTipText("Use DoubleClick for edit");
		// It is hint operation now
		label.setBackground(new Color(null, 255, 255, 255));
		label.setVisible(!fIsTextVisible);

		parent.pack();

		// Listeners
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
						System.out.println(fJavaContent);
						if (fJavaContent.matches(";")) {
							fJavaContent = "";
							getContainer().setTextContent(fJavaContent);
						} else
							getContainer().setTextContent(fJavaContent);
					} catch (Exception e1) {
						fJavaContent = "";
						getContainer().setTextContent(fJavaContent);
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
					label.setImage(image);
					label.setSize(image.getBounds().width,
							image.getBounds().height);
					label.setVisible(true);
					parent.pack();
				}
			}

		});

		label.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (!fIsTextVisible) {
					fIsTextVisible = true;
					styledText.setText(fText);
					styledText.setVisible(fIsTextVisible);
					label.setVisible(!fIsTextVisible);
					parent.pack();
					save();
				}
			}
		});

		MouseEventManager mouseManager = new MouseEventManager(parent, label);
		parent.addMouseTrackListener(mouseManager);
		parent.addMouseMoveListener(mouseManager);
		parent.addMouseListener(mouseManager);

	}

	protected CompiledMathPad(String containerID) {
		super(containerID);
		fImagePath = fFileStorage.getDirectoryPath() + containerID + ".jpg";
		fLatexContent = "";
		fJavaContent = "";
		fIsTextVisible = true;
		fText = "";
		save();
	}

	public static void setStorage(FileStorage fStorage) {
		CompiledMathPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		CompiledMathPad newPad = new CompiledMathPad();
		newPad.fText = this.fText;
		newPad.fLatexContent = this.fLatexContent;
		newPad.fJavaContent = this.fJavaContent;
		newPad.fIsTextVisible = this.fIsTextVisible;
		// newPad.getContainer().setTextContent(fJavaContent);

		File inputFile = new File(this.fImagePath);
		File outputFile = new File(newPad.fImagePath);

		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(inputFile), 4096);
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(outputFile), 4096);
			int buffer;
			while ((buffer = bis.read()) != -1) {
				bos.write(buffer);
			}
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newPad;
	}

	// Save&Load operations, use it for serialization

	public void save() {
		CompiledMathPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		CompiledMathPad.fFileStorage.removeFile(getContainerID());
	}

	@Override
	public void onContainerAttached() {
		getContainer().setTextContent(fJavaContent);
	}
}
