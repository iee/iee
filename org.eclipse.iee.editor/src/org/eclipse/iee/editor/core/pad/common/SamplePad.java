package org.eclipse.iee.editor.core.pad.common;

import org.eclipse.iee.editor.core.pad.Pad;
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

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onContainerAttached() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
	}
}