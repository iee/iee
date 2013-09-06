package org.eclipse.iee.sample.graph.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.eclipse.swt.layout.FillLayout;

public class GraphComposite extends Composite {
	private ChartComposite frame;
	private Composite composite;
	private Text variablesText;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GraphComposite(Composite parent, int style) {
		super(parent, style);
		
		GridLayout layout = new GridLayout(2,false);
		layout.verticalSpacing = 5;
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		setLayout(layout);
		
		composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		GridData gd_frame = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_frame.exclude = false;
		gd_frame.widthHint = 720;
		gd_frame.heightHint = 300;
		
		frame = new ChartComposite(this, SWT.BORDER_DASH);
		frame.setDisplayToolTips(false);
		frame.setHorizontalAxisTrace(true);
		frame.setVerticalAxisTrace(true);
		frame.setLayoutData(gd_frame);
		
		Label label = new Label(this, SWT.NONE);

		GridData xData = new GridData(SWT.CENTER, SWT.FILL, true, true);
		xData.exclude = false;
		variablesText = new Text(this, SWT.NONE);
		variablesText.setLayoutData(xData);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public ChartComposite getGraphComposite() {
		return frame;
	}
	public Composite getComposite() {
		return composite;
	}
	public Text getVariablesText() {
		return variablesText;
	}
}
