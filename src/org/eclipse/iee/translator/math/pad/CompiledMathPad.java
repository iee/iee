package org.eclipse.iee.translator.math.pad;

import java.io.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.translator.math.FileStorage;

public class CompiledMathPad extends Pad implements Serializable {

		private transient static FileStorage fFileStorage;

	public CompiledMathPad() {
		super();
		save();
	}

	@Override
	public void createPartControl(final Composite parent) {
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		
	}

	protected CompiledMathPad(String containerID) {
		super(containerID);
		save();
	}

	public static void setStorage(FileStorage fStorage) {
		CompiledMathPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		CompiledMathPad newPad = new CompiledMathPad();
		newPad = this;
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
