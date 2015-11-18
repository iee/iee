package org.eclipse.iee.editor.core.container;

import java.awt.Rectangle;

public interface IView {

	Rectangle getBounds();

	<T> T getWrapped(Class<T> type);
	
}
