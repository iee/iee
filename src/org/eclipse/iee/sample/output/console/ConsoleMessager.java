package org.eclipse.iee.sample.output.console;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleListener;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.MessageConsole;

public class ConsoleMessager extends EventManager {
	
	public ConsoleMessager() {
		
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager consoleManager = plugin.getConsoleManager();
				
		final IDocumentListener documentListener = new IDocumentListener() {
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
				String text = event.getText();
				System.out.println("Console document modified: " + text);
				fireConsoleMessage(text);
			}
			@Override
			public void documentChanged(DocumentEvent arg0) {
			}
		};
		
		consoleManager.addConsoleListener(new IConsoleListener() {
			@Override
			public void consolesAdded(IConsole[] consoles) {
				for (IConsole c : consoles) {
					System.out.println("Listener added to [" + c.getName() + "] console");
					((IOConsole) c).getDocument().addDocumentListener(documentListener);
				}				
			}

			@Override
			public void consolesRemoved(IConsole[] consoles) {
				for (IConsole c : consoles) {
					System.out.println("Listener removed from [" + c.getName() + "] console");
					((IOConsole) c).getDocument().removeDocumentListener(documentListener);
				}
			}
		});
		
		IConsole[] existing = consoleManager.getConsoles();
		for (IConsole c : existing) {
			if (c instanceof IOConsole) {
				System.out.println("Listener added to [" + c.getName() + "] console");
				((MessageConsole) c).getDocument().addDocumentListener(documentListener);
			}
		}
	}
	
	public void addConsoleMessageListener(IConsoleMessageListener listener) {
		Assert.isNotNull(listener);
		addListenerObject(listener);
	}

	public void removeConsoleMessageListener(IConsoleMessageListener listener) {
		Assert.isNotNull(listener);
		removeListenerObject(listener);
	}
	
	protected void fireConsoleMessage(String message) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IConsoleMessageListener) listeners[i])
				.messageReceived(new ConsoleMessageEvent(message));
		}
	}
	
}
