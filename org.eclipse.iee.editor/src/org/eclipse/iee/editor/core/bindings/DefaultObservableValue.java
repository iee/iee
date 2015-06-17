package org.eclipse.iee.editor.core.bindings;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultObservableValue<T> implements IObservableValue<T> {

	private T fModel;
	
	private List<IObserver<T>> observers = new CopyOnWriteArrayList<>();

	@Override
	public void setValue(T value) {
		T oldValue = fModel;
		fModel = value;
		for (IObserver<T> observer : observers) {
			observer.valueChanged(oldValue, value);
		}
	}

	@Override
	public T getValue() {
		return fModel;
	}

	@Override
	public void addObserver(IObserver<T> observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void removeObserver(IObserver<T> observer) {
		observers.remove(observer);
	}
	
	public void dispose() {
	}
	
	public static <T> DefaultObservableValue<T> fromValue(T value) {
		DefaultObservableValue<T> observableValue = new DefaultObservableValue<T>();
		observableValue.setValue(value);
		return observableValue;
	}
	
}
