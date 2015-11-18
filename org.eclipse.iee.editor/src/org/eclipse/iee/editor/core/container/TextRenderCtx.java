package org.eclipse.iee.editor.core.container;

import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

import com.google.common.base.Optional;

public class TextRenderCtx {

	private TextStyle fDefaultStyle;

	private ResourceManager fResourceManager;
	
	public TextRenderCtx(TextStyle defaultStyle, ResourceManager resourceManager) {
		fResourceManager = resourceManager;
		fDefaultStyle = defaultStyle;
	}
	
	public Optional<Integer> getFontSize(Optional<TextStyle> style) {
		if (style.isPresent() && style.get().getFontSize().isPresent()) {
			return style.get().getFontSize();
		} else {
			return fDefaultStyle.getFontSize();
		}
	}
	
	public Optional<Boolean> getItalic(Optional<TextStyle> style) {
		if (style.isPresent() && style.get().getFontSize().isPresent()) {
			return style.get().isItalic();
		} else {
			return fDefaultStyle.isItalic();
		}
	}
	
	public Optional<Boolean> getBold(Optional<TextStyle> style) {
		if (style.isPresent() && style.get().isBold().isPresent()) {
			return style.get().isBold();
		} else {
			return fDefaultStyle.isBold();
		}
	}
	
	public Font getFont(Optional<TextStyle> style) {
		FontDescriptor createFrom = FontDescriptor.createFrom(JFaceResources.getDefaultFont());
		if (getFontSize(style).isPresent()) {
			createFrom = createFrom.setHeight(getFontSize(style).get());
		}
		if (getItalic(style).isPresent()) {
			if (getItalic(style).get()) {
				createFrom = createFrom.withStyle(SWT.ITALIC);
			}
		}
		if (getBold(style).isPresent()) {
			if (getBold(style).get()) {
				createFrom = createFrom.withStyle(SWT.BOLD);
			}
		}
		return fResourceManager.createFont(createFrom);
	}

	public TextStyle getDefaultStyle() {
		return fDefaultStyle;
	}
	
	public Color getErrorColor() {
		return fResourceManager.createColor(ColorDescriptor.createFrom(new RGB(255, 0, 0)));
	}

	public Optional<Color> getBackground(Optional<TextStyle> style) {
		Optional<java.awt.Color> c = Optional.absent();
		if (style.isPresent() && style.get().getBgColor().isPresent()) {
			c = style.get().getBgColor();
		} else {
			c = fDefaultStyle.getBgColor();
		}
		if (c.isPresent()) {
			RGB rgb = new RGB(c.get().getRed(), c.get().getGreen(), c.get().getBlue());
			return Optional.of(fResourceManager.createColor(ColorDescriptor.createFrom(rgb)));
		}
		return Optional.absent();
	}
	
	public Optional<Color> getForeground(Optional<TextStyle> style) {
		Optional<java.awt.Color> c = Optional.absent();
		if (style.isPresent() && style.get().getFgColor().isPresent()) {
			c = style.get().getFgColor();
		} else {
			c = fDefaultStyle.getFgColor();
		}
		if (c.isPresent()) {
			RGB rgb = new RGB(c.get().getRed(), c.get().getGreen(), c.get().getBlue());
			return Optional.of(fResourceManager.createColor(ColorDescriptor.createFrom(rgb)));
		}
		return Optional.absent();
	}
	
	public TextRenderCtx createSuperscriptCtx() {
		TextStyle textStyle = new TextStyle();
//		textStyle.setFontSize((int) Math.ceil(getFontSize().get() * 0.66));
		TextRenderCtx renderCtx = new TextRenderCtx(fDefaultStyle, fResourceManager);
//		renderCtx.setTextSyle(textStyle);
		return renderCtx;
	}

	public TextRenderCtx createSubscriptCtx() {
		TextStyle textStyle = new TextStyle();
//		textStyle.setFontSize((int) Math.ceil(getFontSize().get() * 0.66));
		TextRenderCtx renderCtx = new TextRenderCtx(fDefaultStyle, fResourceManager);
//		renderCtx.setTextSyle(textStyle);
		return renderCtx;
	}
	
	public TextRenderCtx createNAryFigureCtx() {
		TextStyle textStyle = new TextStyle();
//		textStyle.setFontSize((int) Math.ceil(getFontSize().get() * 0.2));
		TextRenderCtx renderCtx = new TextRenderCtx(fDefaultStyle, fResourceManager);
//		renderCtx.setTextSyle(textStyle);
		return renderCtx;
	}

}
