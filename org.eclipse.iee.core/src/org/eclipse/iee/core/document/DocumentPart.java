package org.eclipse.iee.core.document;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public abstract class DocumentPart {

	private final PropertyChangeSupport fpcs = new PropertyChangeSupport(this);
	
	private DocumentPart parent;
	
	private List<DocumentPart> children;

	public DocumentPart() {
		this(new ArrayList<DocumentPart>());
	}
	
	public DocumentPart(List<DocumentPart> children) {
		super();
		for (DocumentPart documentPart : children) {
			addPart(documentPart);
		}
	}
	
	private void addPart(DocumentPart documentPart) {
		if (documentPart.getParent() != null) {
			documentPart.getParent().removePart(documentPart);
		}
		if (children == null) {
			children = new ArrayList<>();
		}
		children.add(documentPart);
		documentPart.setParent(this);
	}
	
	private void removePart(DocumentPart documentPart) {
		if (children != null) {
			children.remove(documentPart);
		}
		if (documentPart.getParent() == this) {
			documentPart.setParent(null);
		}
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
	
	public Document getDocument() {
		return parent.getDocument();
	}
	
	public DocumentPart getParent() {
		return parent;
	}
	
	void setParent(DocumentPart parent) {
		DocumentPart oldValue = this.parent;
		this.parent = parent;
		getPropertyChangeSupport().firePropertyChange("parent", oldValue, parent);
	}

	
}
