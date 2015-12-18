package org.eclipse.iee.core.document.text;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

public class EventBusSupport {
	
	private static EventBus fDefaultEventBus = new EventBus(new SubscriberExceptionHandler() {
		
		@Override
		public void handleException(Throwable exception, SubscriberExceptionContext context) {
			exception.printStackTrace(System.err);
		}
	});
	
	public static EventBus getDefault() {
		return fDefaultEventBus;
	}
	
	private EventBus fEventBus;
	
	private Object fSource;

    public EventBusSupport(Object sourceBean) {
        fSource = sourceBean;
        fEventBus = getDefault();
    }
	
    public EventBusSupport(Object sourceBean, EventBus eventBus) {
        fSource = sourceBean;
        fEventBus = eventBus;
    }

    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            firePropertyChange(new PropertyChangeEvent(fSource, propertyName, oldValue, newValue));
        }
    }

    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        if (oldValue != newValue) {
            firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        }
    }

    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        if (oldValue != newValue) {
            firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        }
    }

    public void firePropertyChange(PropertyChangeEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            fEventBus.post(event);
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue) {
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            firePropertyChange(new IndexedPropertyChangeEvent(fSource, propertyName, oldValue, newValue, index));
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, int oldValue, int newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, boolean oldValue, boolean newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        }
    }

}
