package org.eclipse.iee.editor.properties;

import java.beans.Introspector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.iee.core.document.PropertiesContainer;
import org.eclipse.iee.core.document.Property;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import com.google.common.base.Converter;
import com.google.common.base.Strings;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

public class ContainerPropertySource implements IPropertySource2 {

	private Object fObject;
	private IPropertyDescriptor[] fDescriptors; 
	private PropertiesInfo root;
	
	public ContainerPropertySource(Object adaptableObject) {
		super();
		fObject = adaptableObject;
		root = calculateInfo(fObject.getClass());
		fDescriptors = calculateDescriptors(root, null, "");
	}

	private PropertiesInfo calculateInfo(Class<?> clz) {
		PropertiesInfo info = new PropertiesInfo();


		Field[] declaredFields = clz.getDeclaredFields();
		for (Field field : declaredFields) {
			if (isProperty(field)) {
				info.getPropertyFields().put(getPropertyNameFromField(field), field);
			}
		}
		Method[] declaredMethods = clz.getDeclaredMethods();

		for (Method method : declaredMethods) {
			if (isGetter(method)) {
				info.getPropertyGetters().put(getPropertyNameFromGetter(method), method);
				
			} else if (isSetter(method)) {
				String name = getPropertyNameFromSetter(method);
				Collection<Method> methods = info.getPropertySetters().get(name);
				if (methods == null) {
					methods = new HashSet<>();
					info.getPropertySetters().put(name, methods);
				}
				methods.add(method);
			}
		}
		return info;
	}


	private IPropertyDescriptor[] calculateDescriptors(PropertiesInfo info, String category, String parentPath) {
		List<IPropertyDescriptor> descriptors = new ArrayList<>();
		
		Set<String> properties = new HashSet<>();
		properties.addAll(info.getPropertyFields().keySet());
		properties.addAll(info.getPropertyGetters().keySet());
		properties.addAll(info.getPropertySetters().keySet());
		for (String string : properties) {
			PropertiesContainer propertiesContainer = info.getPropertyAnnotation(string, PropertiesContainer.class);
			String propertyPath = parentPath.length() > 0 ? parentPath + "." + string : string;
			if (propertiesContainer != null) {
				Class<?> propertyType = info.getPropertyType(string);
				PropertiesInfo subInfo = calculateInfo(propertyType);
				IPropertyDescriptor[] calculatedDescriptors = calculateDescriptors(subInfo, propertiesContainer.name(), propertyPath);
				List<IPropertyDescriptor> asList = Arrays.asList(calculatedDescriptors);
				descriptors.addAll(asList);
			}
			
			Property property = info.getPropertyAnnotation(string, Property.class);
			if (property != null) {
				final Class<?> propertyType = info.getPropertyType(string);
				String description = property.description();
				PropertyDescriptor descriptor = new PropertyDescriptor(propertyPath, property.name()) {
					@Override
					public CellEditor createPropertyEditor(Composite parent) {
						final Converter<String, ?> converter;
						if (int.class.equals(propertyType) ||
								Integer.class.equals(propertyType)) {
							converter = Ints.stringConverter();
						} else if (double.class.equals(propertyType) ||
									Double.class.equals(propertyType)) {
							converter = Doubles.stringConverter();
						} else {
							converter = Converter.identity();
						}
						
						return new TextCellEditor(parent) {
							@Override
							protected void doSetValue(Object value) {
								String str;
								if (value != null) {
									@SuppressWarnings("unchecked")
									Converter<Object, String> reverse = (Converter<Object, String>) converter.reverse();
									str = reverse.convert(value);
								} else {
									str = "";
								}
								super.doSetValue(str);
							}
							
							@Override
							protected Object doGetValue() {
								String value = (String) super.doGetValue();
								if (Strings.isNullOrEmpty(value)) {
									return null;
								}
								return converter.convert(value);
							}
							
						};
					}
				};
				if (category != null) {
					descriptor.setCategory(category);
				}
				if (description != null) {
					descriptor.setDescription(description);
				}
				descriptors.add(descriptor);
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
		String strId = (String) id;
		String[] pathElements = strId.split("\\.");
		Object bean = fObject;
		if (pathElements.length > 1) {
			for (String string : Arrays.copyOf(pathElements, pathElements.length - 1)) {
				Method propertyGetter = calculateInfo(bean.getClass()).getPropertyGetter(string);
				if (propertyGetter != null) {
					try {
						bean = propertyGetter.invoke(bean);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				} 
			}
		}
		Method propertySetter = calculateInfo(bean.getClass()).getPropertySetter(pathElements[pathElements.length - 1]);
		if (propertySetter != null) {
			try {
				propertySetter.invoke(bean, value);
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
		String strId = (String) id;
		String[] pathElements = strId.split("\\.");
		Object result = fObject;
		for (String string : pathElements) {
			Method propertyGetter = calculateInfo(result.getClass()).getPropertyGetter(string);
			if (propertyGetter != null) {
				try {
					result = propertyGetter.invoke(result);
					if (result == null) {
						return null;
					}
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			} else {
				return null;
			}
		}
		return convertResult(result);
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