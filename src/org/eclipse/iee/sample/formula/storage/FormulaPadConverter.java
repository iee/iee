package org.eclipse.iee.sample.formula.storage;

import org.eclipse.iee.sample.formula.pad.FormulaPad;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class FormulaPadConverter implements Converter  {
	
	@Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		System.out.println("FormulaPadConverter.canConvert()");
        return type.equals(FormulaPad.class);
    }
	
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		FormulaPad pad = (FormulaPad) source;
		//writer.addAttribute("containerId", pad.getContainerID());
		writer.addAttribute("type", pad.getType());
		writer.addAttribute("expression", pad.getExpression());
		
		System.out.println("Marshal: " + pad.getExpression());
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		//FormulaPad pad = new FormulaPad(reader.getAttribute("containerId"));
		FormulaPad pad = new FormulaPad();
		pad.setType(reader.getAttribute("type"));
		pad.setExression(reader.getAttribute("expression"));
		
		System.out.println("Unmarshal: " + pad.getExpression());
		return pad;
	}
}