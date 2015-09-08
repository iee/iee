package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class ProgressComposite extends Composite {

	private Image image;
	private TextViewer fTextViewer;
	private Spinner fSpinner;

	public ProgressComposite(Composite parent, int style, ImageRegistry imageRegistry) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(1, false);
		setLayout(gridLayout);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		image = imageRegistry.get("progress");
		lblNewLabel.setImage(image);
		
		fSpinner = new Spinner(composite, SWT.BORDER);
		
		fTextViewer = new TextViewer(composite, SWT.BORDER);
		StyledText styledText = fTextViewer.getTextWidget();
		GridData gd_styledText = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_styledText.minimumWidth = 120;
		styledText.setLayoutData(gd_styledText);

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

	public int getSpinner() {
		return fSpinner.getSelection();
	}

	public void setSpinner(int progress) {
		fSpinner.setSelection(progress);
	}
}
