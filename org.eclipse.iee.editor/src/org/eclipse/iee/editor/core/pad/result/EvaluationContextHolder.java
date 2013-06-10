package org.eclipse.iee.editor.core.pad.result;


public class EvaluationContextHolder {

	private static final ThreadLocal<IResultContainer> CONTAINER = new ThreadLocal<IResultContainer>();
	
	private static final ThreadLocal<IParameterProvider> PARAMETER_PROVIDER = new ThreadLocal<IParameterProvider>();
	
	public static IResultContainer getResultContainer() {
		IResultContainer container = CONTAINER.get();
		if(container == null) {
			container = new FileResultContainer();
		}
		return container;
	}
	
	public static IParameterProvider getParameterProvider() {
		IParameterProvider provider = PARAMETER_PROVIDER.get();
		if (provider == null) {
			provider = new NullParameterProvider();
		}
		return provider;
	}
	
	public static void setResultContainer(IResultContainer container) {
		CONTAINER.set(container);
	}
	
	public static void setParameterProvider(IParameterProvider parameterProvider) {
		PARAMETER_PROVIDER.set(parameterProvider);
	}
	
	public static void cleanContext() {
		CONTAINER.remove();
		PARAMETER_PROVIDER.remove();
	}
	
	public static void putResult(String padId, String result) {
		getResultContainer().putResult(padId, result);
	}
	
	public static String getResult(String padId) {
		return getResultContainer().getResult(padId);
	}
	
	public static String getParameter(String parameter) {
		return getParameterProvider().getParameterValue(parameter);
	}
	
	
}
