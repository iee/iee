package org.eclipse.iee.pad.image;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.Property;

public class ImagePart extends PadDocumentPart {

	private String fImagePath;
	private int fImageWidth = -1;
	private int fImageHeigth = -1;

	public String getImagePath() {
		return fImagePath;
	}

	public void setImagePath(String imagePath) {
		fImagePath = imagePath;
	}

	@Property(name = "Width", description = "Image width")
	public int getImageWidth() {
		return fImageWidth;
	}

	public void setImageWidth(int imageWidth) {
		int oldValue = fImageWidth;
		fImageWidth = imageWidth;
		getPropertyChangeSupport().firePropertyChange("imageWidth", oldValue, imageWidth);
	}

	@Property(name = "Height", description = "Image height")
	public int getImageHeigth() {
		return fImageHeigth;
	}

	public void setImageHeigth(int imageHeigth) {
		int oldValue = fImageHeigth;
		fImageHeigth = imageHeigth;
		getPropertyChangeSupport().firePropertyChange("imageWidth", oldValue, imageHeigth);
	}

	public void setSize(int width, int height) {
		setImageWidth(width);
		setImageHeigth(height);
	}
	
	public ImagePart copy() {
		ImagePart clone = new ImagePart();
		clone.setImageHeigth(getImageHeigth());
		clone.setImagePath(getImagePath());
		clone.setImageWidth(getImageWidth());
		return clone;
	}

}
