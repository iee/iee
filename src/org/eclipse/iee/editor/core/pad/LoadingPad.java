package org.eclipse.iee.editor.core.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class LoadingPad extends Pad {

	public LoadingPad() {
		super();
	}
	
	public LoadingPad(String containerID) {
		super(containerID);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		final Label label = new Label(parent, SWT.WRAP | SWT.CENTER);
		label.setText("Loading...");
		label.setSize(200, 100);		
		parent.pack();
	}

	@Override
	public Pad copy() {
		return new LoadingPad();
	}
}
