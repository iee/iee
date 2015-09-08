package org.eclipse.iee.editor.core.container;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public interface ITextEditor<M, F extends IFigure> {

	TextLocation getTextLocation(int x, int y);

	void acceptCaret(Caret caret, TextLocation textLocation);

	boolean isSelectable();
	
	void setSelected(boolean b);

	void setActive(boolean b);
	
	M getModel();

	void setParent(Optional<ITextEditor<?, ?>> parent);
	
	Optional<ITextEditor<?, ?>> getParent();
	
	F getFigure();
	
	void dispose();

	Optional<ContainerManager> getContainerManager();

	void attach(ContainerManager containerManager);

	void detach(ContainerManager containerManager);

}
