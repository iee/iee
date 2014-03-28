package org.eclipse.iee.web.renderer;

import org.eclipse.iee.core.document.DocumentPart;

public interface IHTMLRendererManager {

	public abstract <T extends DocumentPart> IHTMLRenderer<T> getPadHTMLRenderer(
			T part);

}