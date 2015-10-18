package org.eclipse.iee.translator.antlr.translator.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.iee.core.IHasPropertyChangeListener;

public abstract class Expression implements IHasPropertyChangeListener {
	
	public static final String PLACEHOLDER = "[~!~]";
	
	private final PropertyChangeSupport fpcs = new PropertyChangeSupport(this);
	
	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.IHasPropertyChangeListener#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		fpcs.addPropertyChangeListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.IHasPropertyChangeListener#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		fpcs.removePropertyChangeListener(listener);
	}
	
	protected PropertyChangeSupport getPropertyChangeSupport() {
		return fpcs;
	}
	
	public abstract String getText();

	public abstract <R, C> R accept(Visitor<R, C> visitor, C context);


}
