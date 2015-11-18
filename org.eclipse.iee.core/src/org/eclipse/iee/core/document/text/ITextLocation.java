package org.eclipse.iee.core.document.text;

public interface ITextLocation {

	public Text getModel();
	
	public int getOffset();

	public INode findCommonAncestor(ITextLocation to);
	
}
