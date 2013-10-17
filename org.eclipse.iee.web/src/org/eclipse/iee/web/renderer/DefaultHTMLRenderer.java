/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;

import org.eclipse.iee.core.document.PadDocumentPart;

/**
 * @author Toxin
 *
 */
public class DefaultHTMLRenderer implements IHTMLRenderer<PadDocumentPart> {

	@Override
	public void renderPad(PadDocumentPart pad, IHTMLRendererContext context) throws IOException {
		context.getWriter().write("Unknown pad here");
	}

	@Override
	public void renderResource(PadDocumentPart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
	}

}
