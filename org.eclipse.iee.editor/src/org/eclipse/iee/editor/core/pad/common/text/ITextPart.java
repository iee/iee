package org.eclipse.iee.editor.core.pad.common.text;

import com.google.common.base.Optional;


public interface ITextPart {

	Optional<ICompositeTextPart> getParentTextPart();
	
	IEditorLocation getStart();
	
	IEditorLocation getEnd();
	
}
