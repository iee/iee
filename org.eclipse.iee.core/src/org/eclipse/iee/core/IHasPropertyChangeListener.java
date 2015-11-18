package org.eclipse.iee.core;

import java.beans.PropertyChangeListener;

public interface IHasPropertyChangeListener {

	void addPropertyChangeListener(PropertyChangeListener listener);

	void removePropertyChangeListener(PropertyChangeListener listener);

}