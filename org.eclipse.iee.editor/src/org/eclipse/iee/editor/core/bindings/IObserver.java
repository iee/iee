package org.eclipse.iee.editor.core.bindings;

public interface IObserver<T> {

	void valueChanged(T oldValue, T newValue);
	
}
