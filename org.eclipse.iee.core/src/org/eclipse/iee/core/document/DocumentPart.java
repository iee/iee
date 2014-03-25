package org.eclipse.iee.core.document;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DocumentPart {

	private final PropertyChangeSupport fpcs = new PropertyChangeSupport(this);
	
	private List<DocumentPart> children;

	public DocumentPart() {
		this(new ArrayList<DocumentPart>());
	}
	
	public DocumentPart(List<DocumentPart> children) {
		super();
		this.children = children;
	}
	
	public List<DocumentPart> getChildren() {
		return children;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		fpcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		fpcs.removePropertyChangeListener(listener);
	}
	
	protected PropertyChangeSupport getPropertyChangeSupport() {
		return fpcs;
	}
	
}
