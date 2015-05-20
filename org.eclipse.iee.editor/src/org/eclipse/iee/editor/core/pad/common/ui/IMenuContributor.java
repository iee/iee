package org.eclipse.iee.editor.core.pad.common.ui;

import org.eclipse.jface.action.MenuManager;

public interface IMenuContributor<T> {

	void contribute(MenuManager menuManager, T object);

}
