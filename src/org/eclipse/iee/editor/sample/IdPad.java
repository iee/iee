package org.eclipse.iee.editor.sample;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class IdPad extends Pad {

	public IdPad() {
		super();
	}
	
	public IdPad(String containerID) {
		super(containerID);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		final Label label = new Label(parent, SWT.WRAP | SWT.CENTER);
				
		label.setText(getContainerID());
		label.setSize(200, 100);
		label.setBackground(new Color(parent.getDisplay(), 100, 0, 0));
		parent.pack();
	}

	@Override
	public Pad copy() {
		return new IdPad();
	}

	@Override
	public String getType() {
		return "Id Pad";
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
	}
}
