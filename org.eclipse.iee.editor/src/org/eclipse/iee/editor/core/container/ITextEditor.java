package org.eclipse.iee.editor.core.container;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;

import com.google.common.base.Optional;

public interface ITextEditor<M, F extends IFigure> {

	Optional<TextLocation> getTextLocation(int x, int y);

	boolean isSelectable();
	
	void setSelected(boolean b);

	void setActive(boolean b);
	
	M getModel();
	
	Optional<? extends IObservableValue<M>> getValue();
	
	void setValue(Optional<? extends IObservableValue<M>> value);

	void setParent(Optional<ITextEditor<?, ?>> parent);
	
	Optional<ITextEditor<?, ?>> getParent();
	
	F getFigure();
	
	void dispose();

	void attach(EditorManager containerManager);

	void detach(EditorManager containerManager);

	Optional<TextLocation> getPrevious(ITextEditor<?, ?> textPart);
	
	Optional<TextLocation> getNext(ITextEditor<?, ?> textPart);

	Optional<TextLocation> getEnd();

	Optional<TextLocation> getStart();

	Optional<TextLocation> getAbove(TextLocation textLocation);

	Optional<TextLocation> getBelow(TextLocation textLocation);

}
