package org.eclipse.iee.web.renderer;

import java.io.IOException;

import org.eclipse.iee.core.IHasPropertyChangeListener;

public interface IHTMLRenderer<T extends IHasPropertyChangeListener> {

	void renderPad(T pad, IHTMLRendererContext context) throws IOException;
	
	void renderResource(T pad, String resourceId, IResourceRenderContext context) throws IOException;
	
}
