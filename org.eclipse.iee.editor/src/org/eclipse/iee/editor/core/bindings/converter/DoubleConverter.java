package org.eclipse.iee.editor.core.bindings.converter;

import com.google.common.base.Converter;
import com.google.common.base.Strings;

public class DoubleConverter extends Converter<String, Double> {

	public static final DoubleConverter INSTANCE = new DoubleConverter();
	
	public static final Converter<Double,String> REVERSE_INSTANCE = new DoubleConverter().reverse();
	
	
	
	@Override
	protected Double doForward(String a) {
		if (Strings.isNullOrEmpty(a)) {
			return null;
		}
		return Double.valueOf(a);
	}

	@Override
	protected String doBackward(Double b) {
		if (b == null) {
			return null;
		}
		return String.valueOf(b);
	}

}
