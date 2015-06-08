package org.eclipse.iee.web.renderer;

import org.eclipse.iee.core.IHasPropertyChangeListener;

public interface IHTMLRendererManager {

	public abstract <T extends IHasPropertyChangeListener> IHTMLRenderer<T> getPadHTMLRenderer(
			T part);

}