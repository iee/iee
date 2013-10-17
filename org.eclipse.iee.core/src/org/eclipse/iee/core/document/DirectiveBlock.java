package org.eclipse.iee.core.document;

import java.util.List;

public class DirectiveBlock extends DocumentPart {

	private String directive;

	public DirectiveBlock(String directive, List<DocumentPart> children) {
		super(children);
		this.directive = directive;
	}

	public String getDirective() {
		return directive;
	}
	
}
