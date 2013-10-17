package org.eclipse.iee.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.iee.core.utils.ReflectionUtils;

public class HandlerManager<T> {

    private Class<T> type;
    
    private Map<Class<?>, T> objects = new HashMap<>();

    public HandlerManager(Class<T> type) {
        this.type = type;
    }

    public void registerHandler(T handler) {
    	objects.put(extractType(handler), handler);
    }
    
    private Class<?> extractType(T handler) {
    	return ReflectionUtils.getGenericParameterClass(handler.getClass(), type, 0);
	}

	public void unregisterHandler(T handler) {
    	Set<Entry<Class<?>, T>> entrySet = objects.entrySet();
		for (Iterator<Entry<Class<?>, T>> iterator = entrySet
				.iterator(); iterator.hasNext();) {
			Entry<Class<?>, T> entry = iterator.next();
			if (entry.getValue() == handler) {
				iterator.remove();
			}
		}
    }
    
	public T getHandler(Class<?> type) {
    	T object = objects.get(type);
    	if (object != null) {
    		return object;
    	}
    	return null;
    }
    
	
}
