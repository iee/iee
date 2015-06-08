package org.eclipse.iee.editor.core.bindings;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.common.base.Converter;

public class ConvertedObservableValue<T> implements IObservableValue<T> {

	private Converter<P, T> fConverter;
	
	private List<IObserver<T>> observers = new CopyOnWriteArrayList<>();
	
	@Override
	public void setValue(T value) {
	}

	@Override
	public T getValue() {
		return null;
	}

	@Override
	public void addObserver(IObserver<T> observer) {
		
	}

	@Override
	public void removerObserver(IObserver<T> observer) {
		// TODO Auto-generated method stub
		
	}

}
