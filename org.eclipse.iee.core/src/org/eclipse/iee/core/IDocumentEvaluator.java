package org.eclipse.iee.core;

import org.eclipse.iee.core.document.Document;

public interface IDocumentEvaluator {

	IResultContainer evaluate(Document document);
	
}
