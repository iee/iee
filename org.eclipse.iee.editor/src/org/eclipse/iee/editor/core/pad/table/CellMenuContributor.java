package org.eclipse.iee.editor.core.pad.table;

import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Event;

public class CellMenuContributor implements IMenuContributor<TableCell> {

	public final static CellMenuContributor INSTANCE = new CellMenuContributor(); 
	
	@Override
	public void contribute(MenuManager menuManager, final TableCell object) {
		
		menuManager.add(new ActionContributionItem(new Action("Add column after") {
			@Override
			public void runWithEvent(Event event) {
				TablePart table = object.getTable();
				TableColumn column = table.getColumn(object);
				table.addColumnAfter(column, new TableColumn("Header"));
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Add column before") {
			@Override
			public void runWithEvent(Event event) {
				TablePart table = object.getTable();
				TableColumn column = table.getColumn(object);
				table.addColumnBefore(column, new TableColumn("Header"));
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Add row after") {
			@Override
			public void runWithEvent(Event event) {
				TablePart table = object.getTable();
				TableRow row = table.getRow(object);
				table.addRowAfter(row, new TableRow());
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Add row before") {
			@Override
			public void runWithEvent(Event event) {
				TablePart table = object.getTable();
				TableRow row = table.getRow(object);
				table.addRowBefore(row, new TableRow());
			}
		}));
		
		
	}

}
