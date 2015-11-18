package org.eclipse.iee.core.document.text;

import java.util.List;

public interface ICompositeNode<C extends INode> extends INode {

	List<C> getChildren();
	
	void addChild(C child);
	
	void removeChild(C child);

	void addChildAfter(C right, C text);

	void addChildBefore(C left, C text);

	void replace(C replaced, C with);
	
}
