package org.eclipse.iee.sample.matrix.pad.view;

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

	public HoverShell(Composite parent, Image image) {
		
		fShell = new Shell(SWT.TOOL | SWT.RESIZE);
		Point pt = parent.toDisplay(1, 1);
		fShell.setLocation(pt.x + 10, pt.y +30);
		fShell.setSize(100, 100);
		fShell.setLayout(new FillLayout());
		fLabel = new Label(fShell, SWT.NONE);
		setImage(image);
		fShell.setVisible(true);
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

}

