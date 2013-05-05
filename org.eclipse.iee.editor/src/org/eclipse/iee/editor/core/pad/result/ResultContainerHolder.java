package org.eclipse.iee.editor.core.pad.result;


public class ResultContainerHolder {

	private static final ThreadLocal<IResultContainer> CONTAINER = new ThreadLocal<IResultContainer>();
	
	public static IResultContainer getResultContainer() {
		IResultContainer container = CONTAINER.get();
		if(container == null) {
			container = new FileResultContainer();
		}
		return container;
	}
	
	public static void setResultContainer(IResultContainer container) {
		CONTAINER.set(container);
	}
	
	public static void removeResultContainer() {
		CONTAINER.remove();
	}
	
	public static void putResult(String padId, String result) {
		getResultContainer().putResult(padId, result);
	}
	
	public static String getResult(String padId) {
		return getResultContainer().getResult(padId);
	}
	
}
