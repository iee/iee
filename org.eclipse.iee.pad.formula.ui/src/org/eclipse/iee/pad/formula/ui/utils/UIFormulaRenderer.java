package org.eclipse.iee.pad.formula.ui.utils;

import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.iee.pad.formula.image.FormulaImageRenderer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = UIFormulaRenderer.class)
public class UIFormulaRenderer {

	private static final Logger logger = LoggerFactory.getLogger(UIFormulaRenderer.class);

	protected static Display fDisplay;

	protected static Map<String, Image> fCachedImages = new TreeMap<String, Image>();

	private FormulaImageRenderer formulaImageRenderer;
	
	public static void setDisplay(Display display) {
		fDisplay = display;
	}

	public Image getFormulaImage(String text) {
		if (text == null || text.trim().isEmpty())
			return null;
		Image cachedImage = fCachedImages.get(text);

		if (cachedImage != null) {
			return cachedImage;
		}

		try {
			java.awt.Image awtImage = formulaImageRenderer.getFormulaImage(text, java.awt.Color.black,
					java.awt.Color.white);
			ImageData swtImageData = convertToSWT((BufferedImage) awtImage);
			Image formulaImage = new Image(fDisplay, swtImageData);
			fCachedImages.put(text, formulaImage);
			return formulaImage;

		} catch (Exception e) {
			logger.error("Failed create formula image: " + text, e);
			return null;
		}
	}

	public Image getSymbolicImage(String text) {
		if (text.trim().isEmpty())
			return null;

		try {
			java.awt.Image awtImage = formulaImageRenderer.getFormulaImage(text, new java.awt.Color(63, 127, 95), java.awt.Color.white);

			ImageData swtImageData = convertToSWT((BufferedImage) awtImage);
			Image formulaImage = new Image(fDisplay, swtImageData);

			return formulaImage;

		} catch (Exception e) {
			logger.error("Failed create formula image: " + text, e);
			return null;
		}
	}

	protected static ImageData convertToSWT(BufferedImage bufferedImage) {
		if (bufferedImage.getColorModel() instanceof DirectColorModel) {
			DirectColorModel colorModel = (DirectColorModel) bufferedImage
					.getColorModel();
			PaletteData palette = new PaletteData(colorModel.getRedMask(),
					colorModel.getGreenMask(), colorModel.getBlueMask());
			ImageData data = new ImageData(bufferedImage.getWidth(),
					bufferedImage.getHeight(), colorModel.getPixelSize(),
					palette);
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					int rgb = bufferedImage.getRGB(x, y);
					int pixel = palette.getPixel(new RGB((rgb >> 16) & 0xFF,
							(rgb >> 8) & 0xFF, rgb & 0xFF));
					data.setPixel(x, y, pixel);
					if (colorModel.hasAlpha()) {
						data.setAlpha(x, y, (rgb >> 24) & 0xFF);
					}
				}
			}
			return data;
		} else if (bufferedImage.getColorModel() instanceof IndexColorModel) {
			IndexColorModel colorModel = (IndexColorModel) bufferedImage
					.getColorModel();
			int size = colorModel.getMapSize();
			byte[] reds = new byte[size];
			byte[] greens = new byte[size];
			byte[] blues = new byte[size];
			colorModel.getReds(reds);
			colorModel.getGreens(greens);
			colorModel.getBlues(blues);
			RGB[] rgbs = new RGB[size];
			for (int i = 0; i < rgbs.length; i++) {
				rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF,
						blues[i] & 0xFF);
			}
			PaletteData palette = new PaletteData(rgbs);
			ImageData data = new ImageData(bufferedImage.getWidth(),
					bufferedImage.getHeight(), colorModel.getPixelSize(),
					palette);
			data.transparentPixel = colorModel.getTransparentPixel();
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[1];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					data.setPixel(x, y, pixelArray[0]);
				}
			}
			return data;
		}
		return null;
	}
	@Reference(unbind = "unbindFormulaImageRenderer", policy = ReferencePolicy.DYNAMIC)
	public void bindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = renderer;
	}
	
	public void unbindFormulaImageRenderer(FormulaImageRenderer renderer) {
		formulaImageRenderer = null;
	}
}
