package org.eclipse.iee.editor.core.pad.common.text;

import com.google.common.base.Optional;

public interface TextLocation {

	IContentTextPart getTextPart();
	
	int getPosition();

	Optional<TextLocation> getPrevious();
	
	Optional<TextLocation> getNext();
	
}
