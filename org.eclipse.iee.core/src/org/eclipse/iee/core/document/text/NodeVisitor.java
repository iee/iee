package org.eclipse.iee.core.document.text;

public interface NodeVisitor {

	public void head(INode node);

    public void tail(INode node);
    
}