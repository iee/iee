package org.eclipse.iee.core.document.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCompositeNode<C extends INode> extends AbstractNode implements ICompositeNode<C> {
	
	private List<C> fChildren = new ArrayList<>();
	
	public List<C> getChildren() {
		return Collections.unmodifiableList(fChildren);
	}
	
	public void traverse(NodeVisitor visitor) {
		traverse(visitor, 0);
	}
	
	void traverse(NodeVisitor visitor, int depth) {
		visitor.head(this);
		for (C child : getChildren()) {
			child.traverse(visitor);
		}
        visitor.tail(this);
    }
	
	public boolean hasText() {
		for (C node : getChildren()) {
			if (node.hasText()) {
				return true;
			}
		}
		return false;
	}
	
	public void addChild(C child) {
		List<C> oldValue = this.fChildren;
		this.fChildren = new ArrayList<>(fChildren);
		fChildren.add(child);
		child.setParent(this);
		getEventBusSupport().firePropertyChange("children", oldValue, fChildren);
	}

	public void removeChild(C child) {
		List<C> oldValue = this.fChildren;
		this.fChildren = new ArrayList<>(fChildren);
		fChildren.remove(child);
		getEventBusSupport().firePropertyChange("children", oldValue, fChildren);
	}
	
	@Override
	public boolean isOrContains(INode node) {
		if (this == node) {
			return true;
		} else {
			for (C c : fChildren) {
				if (c.isOrContains(node)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public void addChildAfter(C right, C text) {
		List<C> oldValue = this.fChildren;
		this.fChildren = new ArrayList<>(fChildren);
		int indexOf = fChildren.indexOf(text);
		fChildren.add(indexOf + 1, right);
		right.setParent(this);
		getEventBusSupport().firePropertyChange("children", oldValue, fChildren);
		
	}

	@Override
	public void addChildBefore(C left, C text) {
		List<C> oldValue = this.fChildren;
		this.fChildren = new ArrayList<>(fChildren);
		int indexOf = fChildren.indexOf(text);
		fChildren.add(indexOf, left);
		left.setParent(this);
		getEventBusSupport().firePropertyChange("children", oldValue, fChildren);
	}
	
	@Override
	public void replace(C replaced, C with) {
		List<C> oldValue = this.fChildren;
		this.fChildren = new ArrayList<>(fChildren);
		int indexOf = fChildren.indexOf(replaced);
		fChildren.set(indexOf, with);
		with.setParent(this);
		replaced.setParent(null);
		getEventBusSupport().firePropertyChange("children", oldValue, fChildren);
	}
}
