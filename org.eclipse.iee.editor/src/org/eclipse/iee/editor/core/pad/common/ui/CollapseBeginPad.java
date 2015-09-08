package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.iee.editor.core.pad.FigurePad;
import org.eclipse.iee.editor.core.pad.common.CollapseBeginPart;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

public class CollapseBeginPad extends FigurePad<CollapseBeginPart, ImageFigure> {

	private Image image;

	public CollapseBeginPad(ImageRegistry imageRegistry) {
		image = imageRegistry.get("visibility-off");
	}

	@Override
	public void save() {
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
	protected ImageFigure createFigure() {
		return new ImageFigure(image);
	}

}
