package org.eclipse.iee.editor.core.container;

import java.util.List;

import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.swt.events.VerifyEvent;

import com.google.common.base.Optional;

public interface ITextEditor<M> {

	Optional<IEditorLocation> getTextLocation(int x, int y);

	boolean isSelectable();
	
	void setSelected(boolean b);

	void setActive(boolean b);
	
	M getModel();
	
	IView getView();
	
	Optional<? extends IObservableValue<M>> getValue();
	
	void setValue(Optional<? extends IObservableValue<M>> value);

	void setParent(Optional<ITextEditor<?>> parent);
	
	Optional<ITextEditor<?>> getParent();
	
	void dispose();

	void attach(EditorManager containerManager);

	void detach(EditorManager containerManager);

	Optional<IEditorLocation> getPrevious(ITextEditor<?> textPart);
	
	Optional<IEditorLocation> getNext(ITextEditor<?> textPart);

	Optional<IEditorLocation> getEnd();

	Optional<IEditorLocation> getStart();
	
	Optional<IEditorLocation> getAbove(IEditorLocation textLocation);

	Optional<IEditorLocation> getBelow(IEditorLocation textLocation);

	void selectBetween(IEditorLocation start, IEditorLocation end);

	void unselectBetween(IEditorLocation start, IEditorLocation end);

	List<ITextEditor<?>> getChildren();

	boolean handleKey(VerifyEvent e);

}
