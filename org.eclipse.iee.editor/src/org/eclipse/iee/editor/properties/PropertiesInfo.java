package org.eclipse.iee.editor.properties;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PropertiesInfo {
	private Map<String, Field> propertyFields;
	private Map<String, Method> propertyGetters;
	private Map<String, Collection<Method>> propertySetters;

	public PropertiesInfo() {
		this.propertyFields = new HashMap<>();
		this.propertyGetters = new HashMap<>();
		this.propertySetters = new HashMap<>();
	}

	public Map<String, Field> getPropertyFields() {
		return propertyFields;
	}

	public void setPropertyFields(Map<String, Field> propertyFields) {
		this.propertyFields = propertyFields;
	}

	public Map<String, Method> getPropertyGetters() {
		return propertyGetters;
	}

	public void setPropertyGetters(Map<String, Method> propertyGetters) {
		this.propertyGetters = propertyGetters;
	}

	public Map<String, Collection<Method>> getPropertySetters() {
		return propertySetters;
	}

	public void setPropertySetters(
			Map<String, Collection<Method>> propertySetters) {
		this.propertySetters = propertySetters;
	}
	
	public <A extends Annotation> A getPropertyAnnotation(String string, Class<A> clz) {
		Field field = getPropertyField(string);
		if (field != null) {
			A annotation = field.getAnnotation(clz);
			if (annotation != null) {
				return annotation;
			}
		}
		Method getter = getPropertyGetter(string);
		if (getter != null) {
			A annotation = getter.getAnnotation(clz);
			if (annotation != null) {
				return annotation;
			}
		}
		Method setter = getPropertySetter(string);
		if (setter != null) {
			A annotation = setter.getAnnotation(clz);
			if (annotation != null) {
				return annotation;
			}
		}
		return null;
	}

	public Method getPropertySetter(String string) {
		Class<?> type = getPropertyType(string);
		Collection<Method> methods = getPropertySetters().get(string);
		if (methods != null) {
			for (Method method : methods) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				if (parameterTypes.length == 1 && parameterTypes[0].equals(type)) {
					return method;
				}
			}
		}
		return null;
	}

	public Class<?> getPropertyType(String string) {
		Field field = getPropertyField(string);
		if (field != null) {
			return field.getType();
		}
		Method getter = getPropertyGetter(string);
		if (getter != null) {
			return getter.getReturnType();
		}
		return null;
	}

	public Method getPropertyGetter(String string) {
		return getPropertyGetters().get(string);
	}

	private Field getPropertyField(String string) {
		return getPropertyFields().get(string);
	}
}