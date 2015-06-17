package org.eclipse.iee.editor.core.pad.common.text;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.IObserver;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.jface.action.MenuManager;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;


public abstract class AbstractTextEditor<T> implements ITextEditor<T> {

	private Optional<IObservableValue<T>> fModel = Optional.absent();
	
	private Optional<ITextEditor<?>> fParent = Optional.absent();

	private List<ITextEditor<?>> fChildren = Lists.newArrayList();
	
	private Optional<IMenuContributor<? super T>> fMenuContributor = Optional.absent();
	
	private IFigure fFigure;
	
	private IObserver<T> fObserver = new IObserver<T>() {
		@Override
		public void valueChanged(T oldValue, T newValue) {
			onValueChanged(oldValue, newValue);
		}

	};
	
	@Override
	public IFigure getFigure() {
		if (fFigure == null) {
			fFigure = createFigure();
		}
		return fFigure;
	}
	
	abstract protected IFigure createFigure();
	
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
	
	public void addEditor(ITextEditor<?> child) {
		child.setParent(Optional.<ITextEditor<?>> of(this));
		fChildren.add(child);
		Optional<ContainerManager> containerManager = getContainerManager();
		if (containerManager.isPresent()) {
			child.attach(containerManager.get());
		}
	}
	
	public void attach(ContainerManager containerManager) {
		containerManager.registerVisual(this, getFigure());
		for (ITextEditor<?> iTextEditor : fChildren) {
			iTextEditor.attach(containerManager);
		}
	}
	
	public void removeEditor(ITextEditor<?> child) {
		Optional<ContainerManager> containerManager = getContainerManager();
		if (containerManager.isPresent()) {
			child.attach(containerManager.get());
		}
		fChildren.remove(child);
		child.setParent(Optional.<ITextEditor<?>> absent());
	}
	
	public void detach(ContainerManager containerManager) {
		containerManager.unregisterVisual(getFigure());
		for (ITextEditor<?> iTextEditor : fChildren) {
			iTextEditor.detach(containerManager);
		}
	}
	
	protected void setMenuContributor(IMenuContributor<? super T> instance) {
		fMenuContributor = Optional.<IMenuContributor<? super T>> of(instance);
	}
	
	@Override
	public void contribute(MenuManager menuManager) {
		Optional<ITextEditor<?>> parent = getParent();
		if (parent.isPresent()) {
			parent.get().contribute(menuManager);
		}
		if (fMenuContributor.isPresent()) {
			fMenuContributor.get().contribute(menuManager, getModel());
		}
	}
	
	protected void bindObservableValue(IObservableValue<T> value) {
		IObservableValue<T> oldValue = getObservableValue().isPresent() ? getObservableValue().get() : null;
		fModel = Optional.of(value);
		if (oldValue != value) {
			T old = null;
			if (oldValue != null) {
				old = oldValue.getValue();
				if (old != null) {
					doUnbindValue(old);
				}
				oldValue.removeObserver(fObserver);
			}
			value.addObserver(fObserver);
			T newV = value.getValue();
			if (newV != null) {
				doBindValue(newV);
			}
			onValueChanged(old, newV);
		}
	}

	protected void doBindValue(T value) {
	}

	protected void doUnbindValue(T oldValue) {
	}

	protected void onValueChanged(T oldValue, T newValue) {
	}
	
	protected Optional<IObservableValue<T>> getObservableValue() {
		return fModel;
	}

	public T getValue() {
		return getObservableValue().isPresent() ? getObservableValue().get().getValue() : null;
	}
	
	public Optional<ContainerManager> getContainerManager() {
		Optional<ITextEditor<?>> parent = getParent();
		if (parent.isPresent()) {
			return parent.get().getContainerManager();
		} else {
			return Optional.absent();
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
	
}
