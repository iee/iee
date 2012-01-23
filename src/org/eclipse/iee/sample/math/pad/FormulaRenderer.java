package org.eclipse.iee.sample.math.pad;

import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.iee.sample.math.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class FormulaRenderer {
	
	protected static Display fDisplay;
	
	protected static Map<String, Image> fCachedImages = new TreeMap<String, Image>();
	
	
	public static void setDisplay(Display display) {
		fDisplay = display;
	}
	
	public static boolean isTextValid(String text) {
		if (fCachedImages.containsKey(text)) {
			return true;
		}
		
		if (getFormulaImage(text) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public static Image getFormulaImage(String text) {
		Image cachedImage = fCachedImages.get(text);
		if (cachedImage != null) {
			return cachedImage;
		}
		
		try {
			/* Translating to Latex */
			String latex = Activator.getMolex().translateMath(text).trim();
			
			java.awt.Image awtImage =
				TeXFormula.createBufferedImage(
					latex,
					TeXConstants.STYLE_TEXT,
					60,
					java.awt.Color.black,
					java.awt.Color.white);
			
			ImageData swtImageData = convertToSWT((BufferedImage) awtImage);
			
			Image formulaImage = new Image(fDisplay, swtImageData);
			
			fCachedImages.put(text, formulaImage);
			return formulaImage;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected static ImageData convertToSWT(BufferedImage bufferedImage) {
		if (bufferedImage.getColorModel() instanceof DirectColorModel) {	
			DirectColorModel colorModel =
				(DirectColorModel) bufferedImage.getColorModel();
			
			PaletteData palette = new PaletteData(
				colorModel.getRedMask(),
				colorModel.getGreenMask(),
				colorModel.getBlueMask());
			
			ImageData data = new ImageData(
				bufferedImage.getWidth(),
				bufferedImage.getHeight(),
				colorModel.getPixelSize(),
				palette);
			
			WritableRaster raster = bufferedImage.getRaster();
			
			int[] pixelArray = new int[3];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					int pixel = palette.getPixel(
						new RGB(pixelArray[0],pixelArray[1], pixelArray[2]));
					data.setPixel(x, y, pixel);
				}
			}			
			return data;
		}
		else if (bufferedImage.getColorModel() instanceof IndexColorModel) {
			IndexColorModel colorModel =
				(IndexColorModel) bufferedImage.getColorModel();
			
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
			ImageData data = new ImageData(
				bufferedImage.getWidth(),
				bufferedImage.getHeight(),
				colorModel.getPixelSize(),
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
}
