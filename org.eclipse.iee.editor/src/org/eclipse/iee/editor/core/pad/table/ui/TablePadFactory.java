package org.eclipse.iee.editor.core.pad.table.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.editor.core.pad.table.TablePart;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadFactory} implementation. Creates instance of table pad.
 */
@Component
public class TablePadFactory implements IPadFactory<TablePart> {

	@Override
	public TablePad create(TablePart part, IPadFactoryContext factoryContext) {
		TablePad tablePad = new TablePad();
		DefaultObservableValue<TablePart> model = new DefaultObservableValue<TablePart>();
		model.setValue(part);
		tablePad.bindDocumentPart(model);
		return tablePad;
	}
	
}
