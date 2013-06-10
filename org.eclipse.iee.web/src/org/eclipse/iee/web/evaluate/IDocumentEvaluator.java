package org.eclipse.iee.web.evaluate;

import org.eclipse.iee.editor.core.pad.result.IResultContainer;
import org.eclipse.iee.web.document.Document;

public interface IDocumentEvaluator {

	IResultContainer evaluate(Document document);
	
}
