package org.eclipse.iee.editor.core.pad.common.text;

public interface ITextAdapter<T> {

	String getText(T object);
	
	void setText(T object, String text);
	
}
