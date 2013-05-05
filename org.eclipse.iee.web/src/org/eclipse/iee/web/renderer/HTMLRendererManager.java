package org.eclipse.iee.web.renderer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.iee.editor.core.pad.Pad;

public class HTMLRendererManager {

	/** Registered pad html renderers. */
	private Map<String, IHTMLRenderer> fhtmlRenderers = new HashMap<String, IHTMLRenderer>();
	
	public void registerPadHTMLRenderer(String type, IHTMLRenderer renderer) {
		fhtmlRenderers.put(type, renderer);
	}

	public void unregisterPadHTMLRenderer(IHTMLRenderer<?> factory) {
		Set<Entry<String, IHTMLRenderer>> entrySet = fhtmlRenderers.entrySet();
		for (Iterator<Entry<String, IHTMLRenderer>> iterator = entrySet
				.iterator(); iterator.hasNext();) {
			Entry<String, IHTMLRenderer> entry = iterator.next();
			if (entry.getValue() == factory) {
				iterator.remove();
			}
		}
	}
	
	public IHTMLRenderer<Pad> getPadHTMLRenderer(String type) {
		return fhtmlRenderers.get(type);
	}
	
}
