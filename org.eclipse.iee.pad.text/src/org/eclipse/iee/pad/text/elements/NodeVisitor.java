package org.eclipse.iee.pad.text.elements;

public interface NodeVisitor {

	public void head(Node node, int depth);

    public void tail(Node node, int depth);
    
}