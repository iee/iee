package org.eclipse.iee.core;

import java.beans.PropertyChangeListener;

public interface IHasPropertyChangeListener {

	public abstract void addPropertyChangeListener(PropertyChangeListener listener);

	public abstract void removePropertyChangeListener(PropertyChangeListener listener);

}