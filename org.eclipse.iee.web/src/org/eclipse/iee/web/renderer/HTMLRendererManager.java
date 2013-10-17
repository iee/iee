package org.eclipse.iee.web.renderer;

import org.eclipse.iee.core.HandlerManager;
import org.eclipse.iee.core.document.DocumentPart;

public class HTMLRendererManager {

	/** Registered pad html renderers. */
	@SuppressWarnings("rawtypes")
	private HandlerManager<IHTMLRenderer> fhtmlRenderers = new HandlerManager<>(IHTMLRenderer.class); 
	
	public void registerPadHTMLRenderer(IHTMLRenderer<?> renderer) {
		fhtmlRenderers.registerHandler(renderer);
	}

	public void unregisterPadHTMLRenderer(IHTMLRenderer<?> renderer) {
		fhtmlRenderers.unregisterHandler(renderer);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends DocumentPart> IHTMLRenderer<T> getPadHTMLRenderer(T part) {
		return fhtmlRenderers.getHandler(part.getClass());
	}
	
}
