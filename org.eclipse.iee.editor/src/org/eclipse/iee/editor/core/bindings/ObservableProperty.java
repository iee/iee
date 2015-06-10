package org.eclipse.iee.editor.core.bindings;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.iee.core.IHasPropertyChangeListener;

import com.google.common.base.Throwables;
import com.google.common.reflect.TypeToken;

public class ObservableProperty<T> implements IObservableValue<T> {

	private IHasPropertyChangeListener fModel;
	
	private String fProperty;
	
	private PropertyChangeListener fListener;
	
	private Method fGetter;
	
	private Method fSetter;
	
	private List<IObserver<T>> observers = new CopyOnWriteArrayList<>();
	
	public ObservableProperty(IHasPropertyChangeListener model, String property, Class<T> propertyType) {
		this(model, property, TypeToken.of(propertyType));
	}
	
	public ObservableProperty(IHasPropertyChangeListener model, String property, TypeToken<T> propertyType) {
		fModel = model;
		fProperty = property;
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
			fSetter = model.getClass().getMethod("set" + property.substring(0, 1).toUpperCase() + property.substring(1), new Class[] {propertyType.getRawType()} );
		} catch (NoSuchMethodException | SecurityException e) {
			throw Throwables.propagate(e);
		}
	}
	
	@Override
	public void setValue(T value) {
		try {
			fSetter.invoke(fModel);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw Throwables.propagate(e);
		}
	}

	@Override
	public T getValue() {
		try {
			return (T) fGetter.invoke(fModel, new Object() {});
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
	public void removeObserver(IObserver<T> observer) {
		observers.remove(observer);
	}
	
	public void dispose() {
		fModel.removePropertyChangeListener(fListener);
	}

}
