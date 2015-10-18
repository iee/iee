package org.eclipse.iee.editor.core.pad.common.text;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
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
