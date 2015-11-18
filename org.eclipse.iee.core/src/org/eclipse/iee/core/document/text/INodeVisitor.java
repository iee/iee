package org.eclipse.iee.core.document.text;

public interface INodeVisitor<C, R> {

	R visitText(Text text, C ctx);

	R visitDocument(Document document, C ctx);

	R visitSpan(Span span, C ctx);
	
}
