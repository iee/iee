package org.eclipse.iee.editor.core.pad.common.text;

import com.google.common.base.Optional;

public interface ICompositeTextPart extends ITextPart {

	Optional<ITextPart> getPrevious(ITextPart textPart);
	
	Optional<ITextPart> getNext(ITextPart textPart);
	
}
