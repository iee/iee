package org.eclipse.iee.editor.core.pad.common.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.iee.editor.core.pad.CompositePad;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.common.CollapseEndPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class CollapseEndPad extends CompositePad<CollapseEndPart> {

	private PropertyChangeListener fListener;
	private static Image image;

	static {
		image = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.iee.editor", "images/visibility-on.png").createImage();
	}
	
	
	public CollapseEndPad(CollapseEndPart imagePart) {
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
			}
		};
		imagePart.addPropertyChangeListener(fListener);
	}

	@Override
	public void createPartControl(final Composite parent) {
		initView(parent);
	}

	protected void initView(Composite parent) {
		Rectangle bounds = image.getBounds();
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		final Label label = new Label(parent, SWT.WRAP | SWT.CENTER);
		label.setImage(image);
		label.setSize(bounds.width, bounds.height);
		parent.pack();
	}

	@Override
	public Pad<CollapseEndPart> copy() {
		return new CollapseEndPad(getDocumentPart().copy());
	}

	@Override
	public void save() {
	}

	@Override
	public void unsave() {
	}

	@Override
	public void activate() {
	}

	@Override
	public String getType() {
		return "CollapseBegin";
	}

	@Override
	public String getTex() {
		return "";
	}
	
	@Override
	public void dispose() {
		getDocumentPart().removePropertyChangeListener(fListener);
		image.dispose();
	}

}
