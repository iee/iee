package org.eclipse.iee.core.document.text;

public interface INode {

	INode getParent();
	
	void setParent(INode parent);
	
	void traverse(NodeVisitor visitor);

	boolean hasText();

	<C, R> R accept(INodeVisitor<C, R> visitor, C ctx);

	boolean isOrContains(INode node);

	TextStyle getStyle();

	boolean hasParent(INode span);
	
}