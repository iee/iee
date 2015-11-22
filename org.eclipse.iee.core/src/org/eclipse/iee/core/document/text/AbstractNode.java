package org.eclipse.iee.core.document.text;

public abstract class AbstractNode implements INode {
	
	private INode parent;

	private EventBusSupport febs;
	
	public AbstractNode() {
		febs = new EventBusSupport(this);
	}
	
	public INode getParent() {
		return parent;
	}
	
	public void setParent(INode parent) {
		INode oldParent = this.parent;
		this.parent = parent;
		if (parent != oldParent) {
			onParentChanged(oldParent, parent);
		}
	}
	
	protected void onParentChanged(INode oldParent, INode newParent) {
		
	}
	
	@Override
	public boolean isOrContains(INode node) {
		return node == this;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.iee.pad.text.elements.INode#traverse(org.eclipse.iee.pad.text.elements.NodeVisitor)
	 */
	@Override
	public void traverse(NodeVisitor visitor) {
		traverse(visitor, 0);
	}
	
	void traverse(NodeVisitor visitor, int depth) {
		visitor.head(this);
        visitor.tail(this);
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.iee.pad.text.elements.INode#hasText()
	 */
	@Override
	public boolean hasText() {
		return false;
	}
	
	public EventBusSupport getEventBusSupport() {
		return febs;
	}

	@Override
	public boolean hasParent(INode node) {
		return getParent() == node || (getParent() != null && getParent().hasParent(node));
	}

}
