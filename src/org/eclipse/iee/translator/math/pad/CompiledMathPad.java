package org.eclipse.iee.translator.math.pad;

import java.io.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.translator.math.FileStorage;
import org.eclipse.iee.translator.math.MathCompiler;

public class CompiledMathPad extends Pad implements Serializable {

	private transient static FileStorage fFileStorage;

	private String fText;

	public CompiledMathPad() {
		super();
	}

	@Override
	public void createPartControl(final Composite parent) {
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		StyledText styledText = new StyledText(parent, SWT.NONE);
		styledText.setText(fText);
		
		Button button = new Button(parent, SWT.PUSH);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseDown(MouseEvent e) {
				/* Switch to welcome state */
				getContainer();
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
			}
		});
		
	}

	protected CompiledMathPad(String containerID) {
		super(containerID);
	}

	public static void setStorage(FileStorage fStorage) {
		CompiledMathPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		CompiledMathPad newPad = new CompiledMathPad();
		newPad.fText = this.fText;
		return newPad;
	}

	@Override
	public String getType() {
		return "CompiledMath";
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
