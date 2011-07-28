package org.eclipse.iee.sample.math.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.iee.editor.core.pad.Pad;

public class MathPad extends Pad {
	
	public MathPad() {
		super();
	}
	
	@Override
	public void createPartControl(Composite parent)
	{
		parent.setLayout(new RowLayout());
		//@SuppressWarnings("unused")
		Button Math = new Button(parent, SWT.BUTTON1);
	}

	
	protected MathPad(String containerID) {
		super(containerID);
	}
	
	
	@Override
	public Pad copy() {
		// TODO Auto-generated method stub
		return new MathPad();
	}

	@Override
	public String getType() {
		return "Math";
	}

}

