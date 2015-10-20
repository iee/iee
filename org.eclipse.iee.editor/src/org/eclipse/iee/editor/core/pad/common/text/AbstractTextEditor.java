package org.eclipse.iee.editor.core.pad.common.text;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.IObserver;
import org.eclipse.iee.editor.core.container.EditorManager;
import org.eclipse.iee.editor.core.container.ITextEditor;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;


public abstract class AbstractTextEditor<T, F extends IFigure> implements ITextEditor<T, F>, IAdaptable {

	private Optional<? extends IObservableValue<T>> fModel = Optional.absent();
	
	private Optional<ITextEditor<?, ?>> fParent = Optional.absent();

	private List<ITextEditor<?, ?>> fChildren = Lists.newArrayList();
	
	private F fFigure;
	
	private Optional<EditorManager> fManager = Optional.absent();
	
	private IObserver<T> fObserver = new IObserver<T>() {
		@Override
		public void valueChanged(T oldValue, T newValue) {
			onValueChanged(oldValue, newValue);
		}

	};
	
	@Override
	public F getFigure() {
		if (fFigure == null) {
			fFigure = createFigure();
		}
		return fFigure;
	}
	
	abstract protected F createFigure();
	
	@Override
	public Optional<TextLocation> getTextLocation(int x, int y) {
		return Optional.absent();
	}
	
	@Override
	public Optional<TextLocation> getNext(ITextEditor<?, ?> textPart) {
		int indexOf = getChildren().indexOf(textPart);
		if (indexOf < 0) {
			throw new IllegalArgumentException("Editor is not a child of this container");
		} else if (indexOf + 1 == getChildren().size()) {
			if (getParent().isPresent()) {
				return getParent().get().getNext(this);
			} else {
				return Optional.<TextLocation> absent();
			}
		} else {
			return getChildren().get(indexOf + 1).getStart();
		}
	}
	
	@Override
	public Optional<TextLocation> getPrevious(ITextEditor<?, ?> textPart) {
		int indexOf = getChildren().indexOf(textPart);
		if (indexOf < 0) {
			throw new IllegalArgumentException("Editor is not a child of this container");
		} else if (indexOf - 1 < 0) {
			if (getParent().isPresent()) {
				return getParent().get().getPrevious(this);
			} else {
				return Optional.<TextLocation> absent();
			}
		} else {
			return getChildren().get(indexOf - 1).getEnd();
		}
	}
	
	@Override
	public Optional<TextLocation> getAbove(TextLocation textLocation) {
		ITextEditor<?, ?> editor = textLocation.getEditor();
		return getAbove(textLocation, editor);
	}

	public Optional<TextLocation> getAbove(TextLocation textLocation, ITextEditor<?, ?> editor) {
		CaretInfo caretInfo = textLocation.getCaretInfo();
		int y = editor.getFigure().getBounds().y() - 1;
		Optional<ITextEditor<?, ?>> editorAt = fManager.get().getEditorAt(new Point(caretInfo.getX(), y));
		if (editorAt.isPresent()) {
			return editorAt.get().getTextLocation(caretInfo.getX(), y);
		} else if (getParent().isPresent()) {
			return getAbove(textLocation, getParent().get());
		}
		return Optional.<TextLocation> absent();
	}
	
	@Override
	public Optional<TextLocation> getBelow(TextLocation textLocation) {
		ITextEditor<?, ?> editor = textLocation.getEditor();
		return getBelow(textLocation, editor);
	}

	private Optional<TextLocation> getBelow(TextLocation textLocation, ITextEditor<?, ?> editor) {
		CaretInfo caretInfo = textLocation.getCaretInfo();
		int y = editor.getFigure().getBounds().bottom() + 1;
		Optional<ITextEditor<?, ?>> editorAt = fManager.get().getEditorAt(new Point(caretInfo.getX(), y));
		if (editorAt.isPresent()) {
			return editorAt.get().getTextLocation(caretInfo.getX(), y);
		} else if (getParent().isPresent()) {
			return getBelow(textLocation, getParent().get());
		}
		return Optional.<TextLocation> absent();
	}
	
	@Override
	public Optional<TextLocation> getStart() {
		if (getChildren().size() > 0) {
			return getChildren().get(0).getStart();
		}
		return Optional.<TextLocation> absent();
	}
	
	@Override
	public Optional<TextLocation> getEnd() {
		if (getChildren().size() > 0) {
			return getChildren().get(getChildren().size() - 1).getEnd();
		}
		return Optional.<TextLocation> absent();
	}
	
	@Override
	public T getModel() {
		return fModel.isPresent() ? fModel.get().getValue() : null;
	}
	
	public void setParent(Optional<ITextEditor<?, ?>> parent) {
		fParent = parent;
	}
	
	@Override
	public Optional<ITextEditor<?, ?>> getParent() {
		return fParent;
	}
	
	public ITextEditor<?, ?> addEditor(ITextEditor<?, ?> child) {
		child.setParent(Optional.<ITextEditor<?, ?>> of(this));
		fChildren.add(child);
		if (fManager.isPresent()) {
			fManager.get().addEditor(child);
		}
		return child;
	}
	
	public void attach(EditorManager manager) {
		fManager = Optional.of(manager);
		manager.registerVisual(this, getFigure());
		for (ITextEditor<?, ?> iTextEditor : fChildren) {
			iTextEditor.attach(manager);
		}
	}
	
	public void removeEditor(ITextEditor<?, ?> child) {
		if (fManager.isPresent()) {
			fManager.get().removeEditor(child);
		}
		fChildren.remove(child);
		child.setParent(Optional.<ITextEditor<?, ?>> absent());
	}
	
	public void detach(EditorManager manager) {
		for (ITextEditor<?, ?> iTextEditor : fChildren) {
			iTextEditor.detach(manager);
		}
		manager.unregisterVisual(getFigure());
		fManager = Optional.absent();
	}
		
	@Override
	public void setValue(Optional<? extends IObservableValue<T>> value) {
		IObservableValue<T> oldValue = getValue().isPresent() ? getValue().get() : null;
		fModel = value;
		if (oldValue != value) {
			T old = null;
			if (oldValue != null) {
				old = oldValue.getValue();
				if (old != null) {
					doUnbindValue(old);
				}
				oldValue.removeObserver(fObserver);
			}
			if (value.isPresent()) {
				value.get().addObserver(fObserver);
				T newV = value.get().getValue();
				if (newV != null) {
					doBindValue(newV);
				}
				onValueChanged(old, newV);
			}
		}
	}
	
	public List<ITextEditor<?, ?>> getChildren() {
		return fChildren;
	}

	protected void doBindValue(T value) {
	}

	protected void doUnbindValue(T oldValue) {
	}

	protected void onValueChanged(T oldValue, T newValue) {
	}
	
	@Override
	public Optional<? extends IObservableValue<T>> getValue() {
		return fModel;
	}
	
	@Override
	public void selectBetween(TextLocation start, TextLocation end) {
		List<ITextEditor<?,?>> children = getChildren();
		Optional<ITextEditor<?, ?>> startContainer = getChildContaining(start.getEditor());
		int startindex = startContainer.isPresent() ? children.indexOf(startContainer.get()) : 0;
		Optional<ITextEditor<?, ?>> endContainer = getChildContaining(end.getEditor());
		int endindex = endContainer.isPresent() ? children.indexOf(endContainer.get()) + 1 : children.size();
		for(int i = startindex; i < endindex; i++) {
			children.get(i).selectBetween(start, end);
		}
	}
	
	private Optional<ITextEditor<?, ?>> getChildContaining(ITextEditor<?, ?> editor) {
		Optional<ITextEditor<?, ?>> t = Optional.<ITextEditor<?, ?>> of(editor);
		if (t.get().getParent().isPresent() && t.get().getParent().get() == this) {
			return t;
		}
		while(t.get().getParent().isPresent() && t.get().getParent().get() != this) {
			t = t.get().getParent();
		}
		if (!t.get().getParent().isPresent()) {
			return Optional.absent();
		}
		return t;
	}
	
	@Override
	public void unselectBetween(TextLocation start, TextLocation end) {
		List<ITextEditor<?,?>> children = getChildren();
		Optional<ITextEditor<?, ?>> startContainer = getChildContaining(start.getEditor());
		int startindex = startContainer.isPresent() ? children.indexOf(startContainer.get()) : 0;
		Optional<ITextEditor<?, ?>> endContainer = getChildContaining(end.getEditor());
		int endindex = endContainer.isPresent() ? children.indexOf(endContainer) + 1 : children.size();
		for(int i = startindex; i < endindex; i++) {
			children.get(i).unselectBetween(start, end);
		}
	}

	public void dispose() {
		if (fModel.isPresent()) {
			if (fModel.get().getValue() != null) {
				doUnbindValue(fModel.get().getValue());
			}
			fModel.get().removeObserver(fObserver);
		}
		for (ITextEditor<?, ?> child : fChildren) {
			child.dispose();
		}
		doDispose();
	}

	protected void doDispose() {
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (getModel() == null) {
			return null;
		}
		if (adapter.isAssignableFrom(getModel().getClass())) {
			return adapter;
		}
		return null;
	}
	
}
