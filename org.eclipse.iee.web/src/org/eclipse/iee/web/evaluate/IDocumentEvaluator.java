package org.eclipse.iee.web.evaluate;

import org.eclipse.iee.document.api.IResultContainer;
import org.eclipse.iee.web.document.Document;

public interface IDocumentEvaluator {

	IResultContainer evaluate(Document document);
	
}
