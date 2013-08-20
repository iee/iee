package org.eclipse.iee.web.store;

import org.eclipse.iee.document.api.IParameterProvider;
import org.eclipse.iee.document.api.IResultContainer;

public interface IEvaluationContextStore {

	IResultContainer getResultContainer(String evaluationId);
	
	IParameterProvider getParameterProvider(String evaluationId);
	
	void putResultContainer(String evaluationId, IResultContainer container);
	
	void putParameterProvider(String evaluationId, IParameterProvider container);
	
}
