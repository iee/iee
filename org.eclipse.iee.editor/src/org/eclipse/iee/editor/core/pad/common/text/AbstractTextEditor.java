package org.eclipse.iee.editor.core.pad.common.text;

import java.util.List;

import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.jface.action.MenuManager;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;


public abstract class AbstractTextEditor<T> implements ITextEditor<T> {

	private T fModel;
	
	private Optional<ITextEditor<?>> fParent = Optional.absent();

	private List<ITextEditor<?>> fChildren = Lists.newArrayList();
	
	private  Optional<IMenuContributor<? super T>> fMenuContributor = Optional.absent();
	
	public AbstractTextEditor(T model) {
		fModel = model;
	}

	@Override
	public T getModel() {
		return fModel;
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
	
	public void setMenuContributor(IMenuContributor<? super T> menuContributor) {
		fMenuContributor = Optional.<IMenuContributor<? super T>> of(menuContributor);
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

}
