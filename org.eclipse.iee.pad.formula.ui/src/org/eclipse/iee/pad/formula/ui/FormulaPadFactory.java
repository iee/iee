package org.eclipse.iee.pad.formula.ui;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.FormulaPart;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
public class FormulaPadFactory implements IPadFactory<FormulaPart> {

	@Override
	public Pad create(FormulaPart part) {
		FormulaPad formulaPad = new FormulaPad(part);
		return formulaPad;
	}

	public static void main(String[] args) {
		Type[] genericInterfaces = FormulaPadFactory.class.getGenericInterfaces();
		for (Type type : genericInterfaces) {
			System.out.println(type);
			if (type instanceof ParameterizedType) {
				Type rawType = ((ParameterizedType) type).getRawType();
				if (rawType.equals(IPadFactory.class)) {
					Type[] actualTypeArguments = ((ParameterizedType)type).getActualTypeArguments();
					System.out.println(actualTypeArguments[0]);
				}
			}
		}
		
	}
	
}