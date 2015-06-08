package org.eclipse.iee.editor.core.bindings;


public interface IObservableModel<T> extends IObservableValue<T> {

	IObservableValue<?> getObservableValue(String property);
	
	IObservableModel<?> getObservableModel(String property); 
	
}
