package org.eclipse.iee.editor.core.pad.common.text;

import java.awt.Rectangle;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.IObserver;
import org.eclipse.iee.editor.core.container.EditorManager;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.container.IView;
import org.eclipse.swt.events.VerifyEvent;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public abstract class AbstractTextEditor<T> implements ITextEditor<T>, IAdaptable {

	private Optional<? extends IObservableValue<T>> fModel = Optional.absent();
	
	private Optional<ITextEditor<?>> fParent = Optional.absent();
	
	private List<ITextEditor<?>> fChildren = Lists.newArrayList();
	
	private Optional<EditorManager> fManager = Optional.absent();
	
	private IView fView;
	
	private IObserver<T> fObserver = new IObserver<T>() {
			@Override
			public void valueChanged(T oldValue, T newValue) {
				onValueChanged(oldValue, newValue);
			}
	
		};

	public AbstractTextEditor() {
	}
	
	@Override
	public IView getView() {
		if (fView == null) {
			fView = createView();
		}
		return fView;
	}
	
	abstract protected IView createView();
	
	@Override
	public Optional<IEditorLocation> getTextLocation(int x, int y) {
		return Optional.absent();
	}

	@Override
	public Optional<IEditorLocation> getNext(ITextEditor<?> textPart) {
		int indexOf = getChildren().indexOf(textPart);
		if (indexOf < 0) {
			throw new IllegalArgumentException("Editor is not a child of this container");
		} else if (indexOf + 1 == getChildren().size()) {
			if (getParent().isPresent()) {
				return getParent().get().getNext(this);
			} else {
				return Optional.<IEditorLocation> absent();
			}
		} else {
			return getChildren().get(indexOf + 1).getStart();
		}
	}

	@Override
	public Optional<IEditorLocation> getPrevious(ITextEditor<?> textPart) {
		int indexOf = getChildren().indexOf(textPart);
		if (indexOf < 0) {
			throw new IllegalArgumentException("Editor is not a child of this container");
		} else if (indexOf - 1 < 0) {
			if (getParent().isPresent()) {
				return getParent().get().getPrevious(this);
			} else {
				return Optional.<IEditorLocation> absent();
			}
		} else {
			return getChildren().get(indexOf - 1).getEnd();
		}
	}

	@Override
	public Optional<IEditorLocation> getAbove(IEditorLocation textLocation) {
		ITextEditor<?> editor = textLocation.getEditor();
		return getAbove(textLocation, editor);
	}

	public Optional<IEditorLocation> getAbove(IEditorLocation textLocation, ITextEditor<?> editor) {
		CaretInfo caretInfo = textLocation.getCaretInfo();
		int y = getView().getBounds().y - 1;
		Optional<ITextEditor<?>> editorAt = getManager().get().getEditorAt(new Point(caretInfo.getX(), y));
		if (editorAt.isPresent()) {
			return editorAt.get().getTextLocation(caretInfo.getX(), y);
		} else if (getParent().isPresent()) {
			return getAbove(textLocation, getParent().get());
		}
		return Optional.<IEditorLocation> absent();
	}

	@Override
	public Optional<IEditorLocation> getBelow(IEditorLocation textLocation) {
		ITextEditor<?> editor = textLocation.getEditor();
		return getBelow(textLocation, editor);
	}

	private Optional<IEditorLocation> getBelow(IEditorLocation textLocation, ITextEditor<?> editor) {
		CaretInfo caretInfo = textLocation.getCaretInfo();
		Rectangle bounds = getView().getBounds();
		int y = bounds.y + bounds.height + 1;
		Optional<ITextEditor<?>> editorAt = getManager().get().getEditorAt(new Point(caretInfo.getX(), y));
		if (editorAt.isPresent()) {
			return editorAt.get().getTextLocation(caretInfo.getX(), y);
		} else if (getParent().isPresent()) {
			return getBelow(textLocation, getParent().get());
		}
		return Optional.<IEditorLocation> absent();
	}

	@Override
	public Optional<IEditorLocation> getStart() {
		if (getChildren().size() > 0) {
			return getChildren().get(0).getStart();
		}
		return Optional.<IEditorLocation> absent();
	}

	@Override
	public Optional<IEditorLocation> getEnd() {
		if (getChildren().size() > 0) {
			return getChildren().get(getChildren().size() - 1).getEnd();
		}
		return Optional.<IEditorLocation> absent();
	}

	@Override
	public T getModel() {
		return fModel.isPresent() ? fModel.get().getValue() : null;
	}

	public void setParent(Optional<ITextEditor<?>> parent) {
		fParent = parent;
	}

	@Override
	public Optional<ITextEditor<?>> getParent() {
		return fParent;
	}

	public ITextEditor<?> addEditor(ITextEditor<?> child) {
		child.setParent(Optional.<ITextEditor<?>> of(this));
		fChildren.add(child);
		if (getManager().isPresent()) {
			getManager().get().addEditor(child);
		}
		return child;
	}

	public void attach(EditorManager manager) {
		setManager(Optional.of(manager));
		T model = getModel();
		if (model != null) {
			manager.registerModel(model, this);
		}
		getManager().get().registerVisual(this, getView());
		for (ITextEditor<?> iTextEditor : fChildren) {
			iTextEditor.attach(manager);
		}
	}

	public void removeEditor(ITextEditor<?> child) {
		if (getManager().isPresent()) {
			getManager().get().removeEditor(child);
		}
		fChildren.remove(child);
		child.setParent(Optional.<ITextEditor<?>> absent());
	}

	public void detach(EditorManager manager) {
		for (ITextEditor<?> iTextEditor : fChildren) {
			iTextEditor.detach(manager);
		}
		manager.unregisterVisual(getView());
		T model = getModel();
		if (model != null) {
			manager.unregisterModel(model);
		}
		setManager(Optional.<EditorManager> absent());
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
					if (fManager.isPresent()) {
						fManager.get().unregisterModel(old);
					}
					doUnbindValue(old);
				}
				oldValue.removeObserver(fObserver);
			}
			if (value.isPresent()) {
				value.get().addObserver(fObserver);
				T newV = value.get().getValue();
				if (newV != null) {
					if (fManager.isPresent()) {
						fManager.get().registerModel(newV, this);
					}
					doBindValue(newV);
				}
				onValueChanged(old, newV);
			}
		}
	}

	public List<ITextEditor<?>> getChildren() {
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
	public void selectBetween(IEditorLocation start, IEditorLocation end) {
		List<ITextEditor<?>> children = getChildren();
		Optional<ITextEditor<?>> startContainer = getChildContaining(start.getEditor());
		int startindex = startContainer.isPresent() ? children.indexOf(startContainer.get()) : 0;
		Optional<ITextEditor<?>> endContainer = getChildContaining(end.getEditor());
		int endindex = endContainer.isPresent() ? children.indexOf(endContainer.get()) + 1 : children.size();
		for(int i = startindex; i < endindex; i++) {
			children.get(i).selectBetween(start, end);
		}
	}

	private Optional<ITextEditor<?>> getChildContaining(ITextEditor<?> editor) {
		Optional<ITextEditor<?>> t = Optional.<ITextEditor<?>> of(editor);
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
	public void unselectBetween(IEditorLocation start, IEditorLocation end) {
		List<ITextEditor<?>> children = getChildren();
		Optional<ITextEditor<?>> startContainer = getChildContaining(start.getEditor());
		int startindex = startContainer.isPresent() ? children.indexOf(startContainer.get()) : 0;
		Optional<ITextEditor<?>> endContainer = getChildContaining(end.getEditor());
		int endindex = endContainer.isPresent() ? children.indexOf(endContainer.get()) + 1 : children.size();
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
		for (ITextEditor<?> child : fChildren) {
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

	protected Optional<EditorManager> getManager() {
		return fManager;
	}

	protected void setManager(Optional<EditorManager> manager) {
		fManager = manager;
	}
	
	@Override
	public boolean handleKey(VerifyEvent e) {
		if (getParent().isPresent()) {
			return getParent().get().handleKey(e);
		}
		return false;
	}

}