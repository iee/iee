package org.eclipse.iee.core.store;

import java.util.concurrent.TimeUnit;

import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class InMemoryEvaluationContextStore implements IEvaluationContextStore {

	private Cache<String, IParameterProvider> provider = 
			CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.MINUTES).build();
	
	private Cache<String, IResultContainer> containers = 
			CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.MINUTES).build();

	@Override
	public IResultContainer getResultContainer(String evaluationId) {
		return containers.getIfPresent(evaluationId);
	}

	@Override
	public IParameterProvider getParameterProvider(String evaluationId) {
		return provider.getIfPresent(evaluationId);
	}

	@Override
	public void putResultContainer(String evaluationId,
			IResultContainer container) {
		containers.put(evaluationId, container);
	}

	@Override
	public void putParameterProvider(String evaluationId,
			IParameterProvider container) {
		provider.put(evaluationId, container);
	}
	
}
