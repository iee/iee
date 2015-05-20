package org.eclipse.iee.editor.core.pad.table.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.table.TablePart;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadFactory} implementation. Creates instance of table pad.
 */
@Component
public class TablePadFactory implements IPadFactory<TablePart> {

	@Override
	public TablePad create(TablePart part) {
		TablePad tablePad = new TablePad(part);
		return tablePad;
	}
	
}
