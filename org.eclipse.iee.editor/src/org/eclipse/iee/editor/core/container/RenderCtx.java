package org.eclipse.iee.editor.core.container;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;

public class RenderCtx {

	private Optional<RenderCtx> fParent = Optional.absent();

	private Optional<Integer> fFontSize = Optional.absent();
	
	private Optional<Boolean> fItalic = Optional.absent();
	
	private Optional<Boolean> fBold = Optional.absent();
	
	private Optional<Color> fErrorColor = Optional.absent();
	
	private ResourceManager fResourceManager = JFaceResources.getResources();
	
	public RenderCtx() {
		fFontSize = Optional.of(16);
	}
	
	public RenderCtx(RenderCtx parent) {
		Preconditions.checkNotNull(parent);
		this.fParent = Optional.of(parent);
	}
	
	public Optional<Integer> getFontSize() {
		if (!fFontSize.isPresent() && fParent.isPresent()) {
			return fParent.get().getFontSize();
		}
		return fFontSize;
	}
	
	public Optional<Boolean> getItalic() {
		if (!fItalic.isPresent() && fParent.isPresent()) {
			return fParent.get().getItalic();
		}
		return fItalic;
	}
	
	public Optional<Boolean> getBold() {
		if (!fBold.isPresent() && fParent.isPresent()) {
			return fParent.get().getBold();
		}
		return fBold;
	}
	
	public void setFontSize(int fontSize) {
		this.fFontSize = Optional.of(fontSize);
	}
	
	private void setItalic(boolean italic) {
		this.fItalic = Optional.of(italic);
	}

	private void setBold(boolean bold) {
		this.fBold = Optional.of(bold);
	}
	
	public Font getFont() {
		FontDescriptor createFrom = FontDescriptor.createFrom(JFaceResources.getDefaultFont());
		if (getFontSize().isPresent()) {
			createFrom = createFrom.setHeight(getFontSize().get());
		}
		if (getItalic().isPresent()) {
			if (getItalic().get()) {
				createFrom = createFrom.withStyle(SWT.ITALIC);
			}
		}
		if (getBold().isPresent()) {
			if (getBold().get()) {
				createFrom = createFrom.withStyle(SWT.BOLD);
			}
		}
		return fResourceManager.createFont(createFrom);
	}
	
	public RenderCtx createSuperscriptCtx() {
		RenderCtx renderCtx = new RenderCtx(this);
		renderCtx.setFontSize((int) Math.ceil(getFontSize().get() * 0.66));
		return renderCtx;
	}

	public RenderCtx createSubscriptCtx() {
		RenderCtx renderCtx = new RenderCtx(this);
		renderCtx.setFontSize((int) Math.ceil(getFontSize().get() * 0.66));
		return renderCtx;
	}


	public Optional<RenderCtx> getParent() {
		return fParent;
	}

	public Color getErrorColor() {
		return fErrorColor.or(new Supplier<Color>() {

			@Override
			public Color get() {
				return fResourceManager.createColor(ColorDescriptor.createFrom(new RGB(255, 0, 0)));
			}
		});
	}

	public RenderCtx createNAryFigureCtx() {
		RenderCtx renderCtx = new RenderCtx(this);
		renderCtx.setFontSize((int) Math.ceil(getFontSize().get() * 2));
		return renderCtx;
	}


}
