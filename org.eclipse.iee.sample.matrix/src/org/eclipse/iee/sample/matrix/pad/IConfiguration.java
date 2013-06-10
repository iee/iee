package org.eclipse.iee.sample.matrix.pad;

import org.eclipse.swt.graphics.Color;

public interface IConfiguration {
	
	public final int ELEMENT_BORDER_WIDTH = 2;
	
	public final Color ELEMENT_BORDER_COLOR_NOT_SELECTED = new Color(null, 255, 255, 255);
	
	public final Color ELEMENT_BORDER_COLOR_SELECTED = new Color(null, 0, 0, 0);
	
	public final Color ELEMENT_BORDER_COLOR_INVALID = new Color(null, 255, 0, 0);
}