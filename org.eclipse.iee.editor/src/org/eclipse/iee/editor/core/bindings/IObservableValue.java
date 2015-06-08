package org.eclipse.iee.editor.core.bindings;

public interface IObservableValue<T> {

	void setValue(T value);
	
	T getValue();
	
	void addObserver(IObserver<T> observer);
	
	void removerObserver(IObserver<T> observer);
	
}
