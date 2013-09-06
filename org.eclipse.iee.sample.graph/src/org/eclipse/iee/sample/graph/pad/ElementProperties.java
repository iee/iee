package org.eclipse.iee.sample.graph.pad;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class ElementProperties extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text text;
	private Button btnSelect;
	private Spinner spinner;
	private ColorSelector colorSelector;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ElementProperties(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new GridLayout(2, false));
		
		Label lblWidth = new Label(this, SWT.NONE);
		toolkit.adapt(lblWidth, true, true);
		lblWidth.setText("Width");
		
		spinner = new Spinner(this, SWT.BORDER);
		toolkit.adapt(spinner);
		toolkit.paintBordersFor(spinner);
		
		Label lblColor = new Label(this, SWT.NONE);
		toolkit.adapt(lblColor, true, true);
		lblColor.setText("Color");
		
		colorSelector = new ColorSelector(this);
		btnSelect = colorSelector.getButton();
		btnSelect.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		toolkit.adapt(btnSelect, true, true);
		
		Label lblNewLabel = toolkit.createLabel(this, "Points", SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(text, true, true);

	}

	public Button getSelectButton() {
		return btnSelect;
	}
	public Spinner getWidthSpinner() {
		return spinner;
	}
	public Text getPointsText() {
		return text;
	}
	public ColorSelector getColorSelector() {
		return colorSelector;
	}
}
