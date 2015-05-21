package org.eclipse.iee.pad.text.elements;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;

public class Node {

	private List<Node> children = new ArrayList<>();
	
	public void appendChild(Node child) {
		children.add(child);
	}
	
	public void traverse(NodeVisitor visitor) {
		traverse(visitor, 0);
	}
	
	void traverse(NodeVisitor visitor, int depth) {
		visitor.head(this, depth);
		depth++;
		for (Node child : children) {
			child.traverse(visitor, depth);
		}
		depth--;
        visitor.tail(this, depth);
    }
	
	public boolean hasText() {
		for (Node node : children) {
			if (node.hasText()) {
				return true;
			}
		}
		return false;
	}

	public List<Node> getChildren() {
		return children;
	}
	
}
