package org.eclipse.iee.core.store;

import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;

public interface IEvaluationContextStore {

	IResultContainer getResultContainer(String evaluationId);
	
	IParameterProvider getParameterProvider(String evaluationId);
	
	void putResultContainer(String evaluationId, IResultContainer container);
	
	void putParameterProvider(String evaluationId, IParameterProvider container);
	
}
