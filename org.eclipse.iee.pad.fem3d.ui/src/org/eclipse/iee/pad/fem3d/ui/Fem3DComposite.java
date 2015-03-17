package org.eclipse.iee.pad.fem3d.ui;

import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.RowData;

public class Fem3DComposite extends Composite {

	private Image image;
	private TextViewer fTextViewer;

	public Fem3DComposite(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(1, false);
		setLayout(gridLayout);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		image = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.iee.pad.fem3d.ui", "icons/3d.png").createImage();
		lblNewLabel.setImage(image);
		
		fTextViewer = new TextViewer(composite, SWT.BORDER);
		StyledText styledText = fTextViewer.getTextWidget();
		styledText.setLayoutData(new RowData(120, SWT.DEFAULT));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	@Override
	public void dispose() {
		super.dispose();
		image.dispose();
	}

	public TextViewer getTextBox() {
		return fTextViewer;
	}
}
