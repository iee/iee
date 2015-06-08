package org.eclipse.iee.editor.core.pad.common.text;

public interface IHasValue<T> {

	T getValue();
	
	void setValue(T value);
	
}
