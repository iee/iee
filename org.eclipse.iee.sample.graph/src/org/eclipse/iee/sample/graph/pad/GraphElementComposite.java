package org.eclipse.iee.sample.graph.pad;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class GraphElementComposite extends Composite {
	private Text text;
	private Text text_1;
	private Button button;
	private Button button_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GraphElementComposite(Composite parent, int style) {
		super(parent, style);
		GridLayout layout = new GridLayout(5, false);
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginBottom = 0;
		setLayout(layout);
		
		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text.setText("");
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("#(points): ");
		
		text_1 = new Text(this, SWT.BORDER | SWT.RIGHT);
		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 30;
		text_1.setLayoutData(gd_text_1);
		text_1.setText("100");
		
		button = new Button(this, SWT.NONE);
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button.widthHint = 20;
		button.setLayoutData(gd_button);
		button.setText("+");
		
		button_1 = new Button(this, SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_1.widthHint = 20;
		button_1.setLayoutData(gd_button_1);
		button_1.setText("-");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getFormulaText() {
		return text;
	}
	public Text getPointsText() {
		return text_1;
	}
	public Button getPlusButton() {
		return button;
	}
	public Button getMinusButton() {
		return button_1;
	}
}
