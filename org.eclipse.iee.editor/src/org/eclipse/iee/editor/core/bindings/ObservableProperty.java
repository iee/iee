package org.eclipse.iee.editor.core.bindings;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.iee.core.IHasPropertyChangeListener;

import com.google.common.base.Converter;
import com.google.common.base.Throwables;

public class ObservableProperty<T, P> implements IObservableValue<T> {

	private IHasPropertyChangeListener fModel;
	
	private String fProperty;
	
	private PropertyChangeListener fListener;
	
	private Method fGetter;
	
	private Method fSetter;
	
	private Type fPropertyType;
	
	private Type fValueType;
	
	private Converter<P, T> fConverter;
	
	private List<IObserver<T>> observers = new CopyOnWriteArrayList<>();
	
	public ObservableProperty(IHasPropertyChangeListener model, String property, Type propertyType, Type valueType, Converter<P, T> converter) {
		fModel = model;
		fProperty = property;
		fPropertyType = propertyType;
		fValueType = valueType;
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getSource() == fModel && evt.getPropertyName().equals(fProperty)) {
					for (IObserver<T> observer : observers) {
						observer.valueChanged((T) evt.getOldValue(), (T) evt.getNewValue());
					}
				}
			}
		};
		model.addPropertyChangeListener(fListener);
		try {
			fGetter = model.getClass().getMethod("get" + property.substring(0, 1).toUpperCase() + property.substring(1), new Class[]{});
			fSetter = model.getClass().getMethod("set" + property.substring(0, 1).toUpperCase() + property.substring(1), new Class[] {(Class) propertyType} );
		} catch (NoSuchMethodException | SecurityException e) {
			throw Throwables.propagate(e);
		}
	}
	
	@Override
	public void setValue(T value) {
		try {
			fSetter.invoke(fModel, fConverter.reverse().convert(value));
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw Throwables.propagate(e);
		}
	}

	@Override
	public T getValue() {
		try {
			return fConverter.convert((P) fGetter.invoke(fModel, new Object() {}));
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw Throwables.propagate(e);
		}
	}

	@Override
	public void addObserver(IObserver<T> observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void removerObserver(IObserver<T> observer) {
		observers.remove(observer);
	}
	
	public void dispose() {
		fModel.removePropertyChangeListener(fListener);
	}

}
