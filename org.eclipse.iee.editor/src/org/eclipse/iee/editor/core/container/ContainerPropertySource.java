package org.eclipse.iee.editor.core.container;

import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.Property;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.google.common.base.Converter;
import com.google.common.primitives.Ints;

public class ContainerPropertySource implements IPropertySource2 {
	private static final String TEXT = "TEXT";

	private Container fContainer;
	private IPropertyDescriptor[] fDescriptors; 
	
	public ContainerPropertySource(Container container) {
		super();
		fContainer = container;
		fDescriptors = calculateDescriptors(container.getPadPart());
	}

	private Map<String, Field> propertyFields = new HashMap<>();
	
	private Map<String, Method> propertyGetters = new HashMap<>();
	
	private Map<String, Collection<Method>> propertySetters = new HashMap<>();
	
	
	private IPropertyDescriptor[] calculateDescriptors(PadDocumentPart padPart) {
		List<IPropertyDescriptor> descriptors = new ArrayList<>();
		
		Class<? extends PadDocumentPart> clz = padPart.getClass();
		Field[] declaredFields = clz.getDeclaredFields();
		for (Field field : declaredFields) {
			if (isProperty(field)) {
				propertyFields.put(getPropertyNameFromField(field), field);
			}
		}
		Method[] declaredMethods = clz.getDeclaredMethods();

		for (Method method : declaredMethods) {
			if (isGetter(method)) {
				propertyGetters.put(getPropertyNameFromGetter(method), method);
				
			} else if (isSetter(method)) {
				String name = getPropertyNameFromSetter(method);
				Collection<Method> methods = propertySetters.get(name);
				if (methods == null) {
					methods = new HashSet<>();
					propertySetters.put(name, methods);
				}
				methods.add(method);
			}
		}
		
		Set<String> properties = new HashSet<>();
		properties.addAll(propertyFields.keySet());
		properties.addAll(propertyGetters.keySet());
		properties.addAll(propertySetters.keySet());
		for (String string : properties) {
			Property property = getPropertyAnnotation(string, Property.class);
			if (property != null) {
				final Class<?> propertyType = getPropertyType(string);
				PropertyDescriptor descriptor = new PropertyDescriptor(string, property.name()) {
					@Override
					public CellEditor createPropertyEditor(Composite parent) {
						final Converter<String, ?> converter;
						if (int.class.equals(propertyType) ||
								Integer.class.equals(propertyType)) {
							converter = Ints.stringConverter();
						} else {
							converter = Converter.identity();
						}
						
						return new TextCellEditor(parent) {
							@Override
							protected void doSetValue(Object value) {
								Converter<Object, String> reverse = (Converter<Object, String>) converter.reverse();
								String str = reverse.convert(value);
								super.doSetValue(str);
							}
							
							@Override
							protected Object doGetValue() {
								return converter.convert((String) super.doGetValue());
							}
							
						};
					}
				};
				descriptors.add(descriptor);
				if (property.description() != null) {
					descriptor.setDescription(property.description());
				}
			}
		}
		return (IPropertyDescriptor[]) descriptors.toArray(new IPropertyDescriptor[descriptors.size()]);
	}
	
	private String getPropertyNameFromField(Field field) {
		String name = field.getName();
		if (name.length() > 1 && name.startsWith("f") && Character.isUpperCase(name.charAt(1))) {
			name = Introspector.decapitalize(name.substring(1));
		}
		return name;
	}

	private <A extends Annotation> A getPropertyAnnotation(String string, Class<A> clz) {
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

	private Method getPropertySetter(String string) {
		Class<?> type = getPropertyType(string);
		Collection<Method> methods = propertySetters.get(string);
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

	private Class<?> getPropertyType(String string) {
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

	private Method getPropertyGetter(String string) {
		return propertyGetters.get(string);
	}

	private Field getPropertyField(String string) {
		return propertyFields.get(string);
	}

	private String getPropertyNameFromSetter(Method method) {
		String name = method.getName();
		if (name.startsWith("set")) {
			return Introspector.decapitalize(name.substring(3));
		} 
		throw new IllegalArgumentException("Method is not setter:" + method);
	}

	private String getPropertyNameFromGetter(Method method) {
		String name = method.getName();
		if (name.startsWith("get")) {
			return Introspector.decapitalize(name.substring(3));
		} else if (name.startsWith("is")) {
			return Introspector.decapitalize(name.substring(2));
		}
		throw new IllegalArgumentException("Method is not getter:" + method);
	}

	private boolean isSetter(Method method) {
		String name = method.getName();
		return method.getParameterTypes().length == 1
			&& name.length() > 3 && name.startsWith("set");
	}

	private boolean isGetter(Method method) {
		String name = method.getName();
		return method.getParameterTypes().length == 0
			&& name.length() > 3 && (name.startsWith("get") || name.startsWith("is"));
	}



	private boolean isProperty(Field field) {
		return !Modifier.isStatic(field.getModifiers());
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		Method propertySetter = getPropertySetter((String) id);
		if (propertySetter != null) {
			try {
				propertySetter.invoke(fContainer.getPadPart(), value);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void resetPropertyValue(Object id) {
		
	}

	@Override
	public Object getPropertyValue(Object id) {
		Method propertyGetter = getPropertyGetter((String) id);
		if (propertyGetter != null) {
			try {
				Object result = propertyGetter.invoke(fContainer.getPadPart());
				return convertResult(result);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private Object convertResult(Object result) {
		return result;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return fDescriptors;
	}

	@Override
	public Object getEditableValue() {
		return this;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public boolean isPropertyResettable(Object id) {
		return false;
	}
	
}