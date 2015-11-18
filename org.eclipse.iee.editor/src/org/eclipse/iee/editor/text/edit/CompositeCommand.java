package org.eclipse.iee.editor.text.edit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.iee.core.document.text.ITextLocation;

public class CompositeCommand implements IEditCommand {

	private List<IEditCommand> fCommands = new ArrayList<>();

	public void perform() {
		for (IEditCommand iEditCommand : fCommands) {
			iEditCommand.perform();
		}
	}
	
	public void undo() {
		
	}

	public void append(IEditCommand editCommand) {
		fCommands.add(editCommand);
	}

	public ITextLocation adjust(ITextLocation location) {
		for (IEditCommand iEditCommand : fCommands) {
			location = iEditCommand.adjust(location);
		}
		return location;
	}
	
}
