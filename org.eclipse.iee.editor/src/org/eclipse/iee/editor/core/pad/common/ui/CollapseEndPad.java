package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.iee.editor.core.pad.FigurePad;
import org.eclipse.iee.editor.core.pad.common.CollapseEndPart;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

public class CollapseEndPad extends FigurePad<CollapseEndPart, ImageFigure> {

	private Image image;

	public CollapseEndPad(ImageRegistry imageRegistry) {
		image = imageRegistry.get("visibility-on");
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
