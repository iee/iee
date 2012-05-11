package org.eclipse.iee.sample.matrix.storage;

import org.eclipse.iee.sample.matrix.pad.MatrixPad;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class MatrixPadConverter implements Converter  {
	
	@Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
        return type.equals(MatrixPad.class);
    }
	
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		MatrixPad pad = (MatrixPad) source;
		writer.addAttribute("type", pad.getType());
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		MatrixPad pad = new MatrixPad();
		return pad;
	}
}