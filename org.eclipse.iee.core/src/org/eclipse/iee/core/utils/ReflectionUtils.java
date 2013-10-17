package org.eclipse.iee.core.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {

	public static Class getGenericParameterClass(final Class actualClass,
			final Class genericClass, final int parameterIndex) {
		Type[] genericInterfaces = actualClass.getGenericInterfaces();
		for (Type type : genericInterfaces) {
			if (type instanceof ParameterizedType) {
				Type rawType = ((ParameterizedType) type).getRawType();
				if (rawType.equals(genericClass)) {
					Type[] actualTypeArguments = ((ParameterizedType)type).getActualTypeArguments();
					return (Class) actualTypeArguments[0];
				}
			}
		}
		return null;
	}
}