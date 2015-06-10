package org.eclipse.iee.editor.core.bindings;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Converter;

public class ConvertedObservableValue<T, O> implements IObservableValue<T> {

	private IObservableValue<O> fOriginal;

	private Converter<O, T> fConverter;
	
	private Map<IObserver<T>, IObserver<O>> fObservers = new HashMap<>();
	
	public ConvertedObservableValue(IObservableValue<O> original, Converter<O, T> converter) {
		fOriginal = original;
		fConverter = converter;
	}

	@Override
	public void setValue(T value) {
		fOriginal.setValue(fConverter.reverse().convert(value));
	}

	@Override
	public T getValue() {
		return fConverter.convert(fOriginal.getValue());
	}

	@Override
	public void addObserver(final IObserver<T> observer) {
		IObserver<O> originalObserver = new IObserver<O>() {
			@Override
			public void valueChanged(O oldValue, O newValue) {
				observer.valueChanged(fConverter.convert(oldValue), fConverter.convert(newValue));
			}
		}; 
		fObservers.put(observer, originalObserver);
		fOriginal.addObserver(originalObserver);
	}

	@Override
	public void removeObserver(IObserver<T> observer) {
		IObserver<O> originalObserver = fObservers.get(observer);
		if (originalObserver != null) {
			fOriginal.removeObserver(originalObserver);
		}
	}
	
	public static <T, O> IObservableValue<T> from(IObservableValue<O> original, Converter<O, T> converter) {
		return new ConvertedObservableValue<T, O>(original, converter);
	}

}
