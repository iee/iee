package org.eclipse.iee.editor.core.pad.common.text;

import java.util.Collection;
import java.util.HashSet;
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

	private IObservableValue<T> fModel;
	
	private Optional<ITextEditor<?>> fParent = Optional.absent();

	private List<ITextEditor<?>> fChildren = Lists.newArrayList();
	
	private Optional<IMenuContributor<? super T>> fMenuContributor = Optional.absent();
	
	private Collection<ITextEditor<?>> children = new HashSet<>();
	
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
		return fModel.getValue();
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
	}
	
	public void removeEditor(ITextEditor<?> child) {
		child.setParent(Optional.<ITextEditor<?>> absent());
		fChildren.remove(child);
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
		IObservableValue<T> oldValue = fModel;
		fModel = value;
		if (oldValue != value) {
			T old = oldValue.getValue();
			if (oldValue != null) {
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
	
	protected IObservableValue<T> getObservableValue() {
		return fModel;
	}

	public T getValue() {
		return getObservableValue().getValue();
	}
	
	protected void addChildEditor(ITextEditor<?> child) {
		children.add(child);
		getContainerManager().registerVisual(child, child.getFigure());
	}
	
	public ContainerManager getContainerManager() {
		return getParent().get().getContainerManager();
	}

	protected void removeChildEditor(ITextEditor<?> child) {
		children.remove(child);
		getContainerManager().unregisterVisual(child.getFigure());
	}
	
	public void dispose() {
		if (fModel != null) {
			if (fModel.getValue() != null) {
				doUnbindValue(fModel.getValue());
			}
			fModel.removeObserver(fObserver);
		}
		for (ITextEditor<?> child : children) {
			child.dispose();
		}
		doDispose();
	}

	protected void doDispose() {
	}
	
}
