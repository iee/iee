package org.eclipse.iee.pad.graph.ui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;

class Graphics2DRenderer {
	private static final PaletteData PALETTE_DATA = new PaletteData(0xFF0000,
			0xFF00, 0xFF);

	private BufferedImage awtImage;

	private Image swtImage;

	private ImageData swtImageData;

	private int[] awtPixels;

	private static final int TRANSPARENT_COLOR = 0x123456;

	public void prepareRendering(GC gc) {
		org.eclipse.swt.graphics.Rectangle clip = gc.getClipping();
		prepareRendering(clip.x, clip.y, clip.width, clip.height);
	}

	public void prepareRendering(org.eclipse.draw2d.Graphics graphics) {
		org.eclipse.draw2d.geometry.Rectangle clip = graphics
				.getClip(new org.eclipse.draw2d.geometry.Rectangle());
		prepareRendering(clip.x, clip.y, clip.width, clip.height);
	}

	private void prepareRendering(int clipX, int clipY, int clipW, int clipH) {
		checkOffScreenImages(clipX + clipW, clipY + clipH);
		java.awt.Graphics awtGraphics = awtImage.getGraphics();
		awtGraphics.setColor(new java.awt.Color(TRANSPARENT_COLOR));
		awtGraphics.fillRect(clipX, clipY, clipW, clipH);
	}

	public Graphics2D getGraphics2D() {
		if (awtImage == null)
			return null;
		return (Graphics2D) awtImage.getGraphics();
	}

	public void render(GC gc) {
		if (awtImage == null)
			return;

		org.eclipse.swt.graphics.Rectangle clip = gc.getClipping();
		transferPixels(clip.x, clip.y, clip.width, clip.height);
		gc.drawImage(swtImage, clip.x, clip.y, clip.width, clip.height, clip.x,
				clip.y, clip.width, clip.height);
	}

	public void render(org.eclipse.draw2d.Graphics graphics) {
		if (awtImage == null)
			return;

		org.eclipse.draw2d.geometry.Rectangle clip = graphics
				.getClip(new org.eclipse.draw2d.geometry.Rectangle());
		transferPixels(clip.x, clip.y, clip.width, clip.height);
		graphics.drawImage(swtImage, clip.x, clip.y, clip.width, clip.height,
				clip.x, clip.y, clip.width, clip.height); 
	}

	private void transferPixels(int clipX, int clipY, int clipW, int clipH) {
		int step = swtImageData.depth / 8;
		byte[] data = swtImageData.data;
		awtImage.getRGB(clipX, clipY, clipW, clipH, awtPixels, 0, clipW);
		for (int i = 0; i < clipH; i++) {
			int idx = (clipY + i) * swtImageData.bytesPerLine + clipX * step;
			for (int j = 0; j < clipW; j++) {
				int rgb = awtPixels[j + i * clipW];
				for (int k = swtImageData.depth - 8; k >= 0; k -= 8) {
					data[idx++] = (byte) ((rgb >> k) & 0xFF);
				}
			}
		}
		if (swtImage != null)
			swtImage.dispose();
		swtImage = new Image(Display.getDefault(), swtImageData);
	}

	public void dispose() {
		if (awtImage != null)
			awtImage.flush();
		if (swtImage != null)
			swtImage.dispose();
		awtImage = null;
		swtImageData = null;
		awtPixels = null;
	}

	private void checkOffScreenImages(int width, int height) {
		int currentImageWidth = 0;
		int currentImageHeight = 0;
		if (swtImage != null) {
			currentImageWidth = swtImage.getImageData().width;
			currentImageHeight = swtImage.getImageData().height;
		}

		if (width > currentImageWidth || height > currentImageHeight) {
			dispose();
			width = Math.max(width, currentImageWidth);
			height = Math.max(height, currentImageHeight);
			awtImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_ARGB);
			swtImageData = new ImageData(width, height, 24, PALETTE_DATA);
			swtImageData.transparentPixel = TRANSPARENT_COLOR;
			awtPixels = new int[width * height];
		}
	}
}