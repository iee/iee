package org.eclipse.iee.editor.core.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SamplePad extends Pad {

	@Override
	public void createPartControl(Composite parent) {
		final Label label = new Label(parent, SWT.WRAP | SWT.CENTER);
		label.setText("Sample pad");
		parent.pack();
	}

	@Override
	public Pad copy() {
		return new SamplePad();
	}

	@Override
	public String getType() {
		return "Sample Pad";
	}
}
