package org.eclipse.iee.translator.math.pad;

import java.awt.Color;
import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.translator.math.Activator;
import org.eclipse.iee.translator.math.FileStorage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class CompiledMathPad extends Pad implements Serializable {

	private transient static FileStorage fFileStorage;

	private String fText;
	private String fLatexContent;
	private String fJavaContent;
	private String fImagePath;

	public CompiledMathPad() {
		super();
		fImagePath = fFileStorage.getDirectoryPath() + this.getContainerID()
				+ ".jpg";
		setType("CompiledMath");
		fText = "";
		fLatexContent = "";
		fJavaContent = "";
		//save();
	}

	@Override
	public void createPartControl(final Composite parent) {
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		final StyledText styledText = new StyledText(parent, SWT.NONE);
		styledText.setText(fText);

//		final Label label = new Label(parent, SWT.NONE | SWT.RESIZE);
//		label.setVisible(false);

		// Listeners
		styledText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				System.out.println("before translation to Java");
				try {
					String resultJava = Activator.getMole().translateMath(
							styledText.getText());
					fJavaContent = resultJava.trim();
					System.out.println(fJavaContent);
					if (fJavaContent.matches(";")) {
						fJavaContent = "";
						getContainer().writeAtContainerRegionTail(fJavaContent);
					} else
						getContainer().writeAtContainerRegionTail(fJavaContent);
				} catch (Exception e1) {
					fJavaContent = "";
					getContainer().writeAtContainerRegionTail(fJavaContent);
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
					texFormula.createJPEG(TeXConstants.STYLE_DISPLAY, 40,
							fImagePath, Color.white, Color.black);
				} catch (Exception e1) {
					fLatexContent = "";
					// e1.printStackTrace();
				}

			}

		});

		MouseEventManager mouseManager = new MouseEventManager(parent);
		parent.addMouseTrackListener(mouseManager);
		parent.addMouseMoveListener(mouseManager);
		parent.addMouseListener(mouseManager);

	}

	protected CompiledMathPad(String containerID) {
		super(containerID);
		fImagePath = fFileStorage.getDirectoryPath() + containerID + ".jpg";
		fLatexContent = "";
		fJavaContent = "";
		//save();
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
}
