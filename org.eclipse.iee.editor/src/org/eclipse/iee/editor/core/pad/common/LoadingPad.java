package org.eclipse.iee.editor.core.pad.common;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class LoadingPad extends Pad<PadDocumentPart> {

	@Override
	public String getType() {
		return "Loading Pad";
	}
	
	private String fOriginalContainerID;

	public void setOriginalContainerID(String originalContainerID) {
		fOriginalContainerID = originalContainerID;
	}

	public String getOriginalContainerID() {
		return fOriginalContainerID;
	}

	public LoadingPad(PadDocumentPart part) {
		super(part);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		final Label label = new Label(parent, SWT.WRAP | SWT.CENTER);
		label.setText("Loading...");
		label.setSize(200, 100);
		label.setBackground(new Color(parent.getDisplay(), 205, 181, 205));
		parent.pack();
	}

	@Override
	public LoadingPad copy() {
		return new LoadingPad(getDocumentPart().copy());
	}

	@Override
	public void save() {
	}

	@Override
	public void unsave() {
	}

	@Override
	public void onContainerAttached() {
	}

	@Override
	public void activate() {
	}

	@Override
	public String getTex() {
		return "";
	}
}
