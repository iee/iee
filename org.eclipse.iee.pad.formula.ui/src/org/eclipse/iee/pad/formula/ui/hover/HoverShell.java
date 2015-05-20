package org.eclipse.iee.pad.formula.ui.hover;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class HoverShell {
	public Shell fShell;
	public Label fLabel;
	private Composite fParent;

	public HoverShell(Composite parent, Image image) {
		
		fParent = parent;
		fShell = new Shell(SWT.TOOL | SWT.NO_FOCUS | SWT.ON_TOP);
		fShell.setVisible(false);
		
		fShell.setSize(0, 0);
		fShell.setLayout(new FillLayout());
		fLabel = new Label(fShell, SWT.NONE);
		setImage(image);
		pack();
		
	}

	public void dispose() {
		fShell.dispose();
		fLabel.dispose();
	}

	public void setImage(Image image) {
		fLabel.setImage(image);
	}

	public void pack() {
		fShell.pack();
	}
	
	public void setVisible(boolean visibility) {
		fShell.setVisible(visibility);
	}

	public void show() {
		Point pt = fParent.toDisplay(10, 30);
		fShell.setLocation(pt.x, pt.y);
		pack();
		setVisible(true);
	}

}
