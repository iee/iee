/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;

import org.eclipse.iee.core.document.DocumentPart;
import org.osgi.service.component.annotations.Component;

/**
 * @author Toxin
 *
 */
@Component
public class DefaultHTMLRenderer implements IHTMLRenderer<DocumentPart> {

	@Override
	public void renderPad(DocumentPart pad, IHTMLRendererContext context) throws IOException {
		context.getWriter().write("Unknown pad here");
	}

	@Override
	public void renderResource(DocumentPart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
	}

}
