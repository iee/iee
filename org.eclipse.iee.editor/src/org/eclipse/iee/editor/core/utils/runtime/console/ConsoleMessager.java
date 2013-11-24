package org.eclipse.iee.editor.core.utils.runtime.console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleListener;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.MessageConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleMessager extends EventManager {

	private static final Logger logger = LoggerFactory.getLogger(ConsoleMessager.class);
	
	private static ConsoleMessager fConsoleMessager = new ConsoleMessager();
	public static ConsoleMessager getInstance() {
		return fConsoleMessager;
	}
	
	protected final IConsoleManager fConsoleManager;
	protected final IDocumentListener fDocumentListener;
	protected final IConsoleListener fConsoleListener;
	
	protected ConsoleMessager() {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		fConsoleManager = plugin.getConsoleManager();
		
		fDocumentListener = new IDocumentListener() {
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
				String[] lines = event.getText().split("\\r?\\n");
				for (String line : lines) {
					try {
						final int prefixLength = 36;
						String id = line.substring(0, prefixLength);
						
						Pattern p = Pattern.compile("\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}");
						Matcher m = p.matcher(id);
						if (m.matches()) {
							String message = line.substring(prefixLength);
							fireConsoleMessage(id, message);
						}
					} catch(IndexOutOfBoundsException e) {
						// Do nothing
					}
				}
			}
			
			@Override public void documentChanged(DocumentEvent arg0) {}
		};
	
		fConsoleListener = new IConsoleListener() {
			@Override
			public void consolesAdded(IConsole[] consoles) {
				for (IConsole c : consoles) {
					logger.debug("Listener added to [" + c.getName() + "] console");
					((IOConsole) c).getDocument().addDocumentListener(fDocumentListener);
				}
			}

			@Override
			public void consolesRemoved(IConsole[] consoles) {
				for (IConsole c : consoles) {
					logger.debug("Listener removed from [" + c.getName() + "] console");
					((IOConsole) c).getDocument().removeDocumentListener(fDocumentListener);
				}
			}
		};
				
		fConsoleManager.addConsoleListener(fConsoleListener);
		
		IConsole[] existing = fConsoleManager.getConsoles();
		for (IConsole c : existing) {
			if (c instanceof IOConsole) {
				logger.debug("Listener added to [" + c.getName() + "] console");
				((MessageConsole) c).getDocument().addDocumentListener(fDocumentListener);
			}
		}
	}
	
	public void clear() {
		fConsoleManager.removeConsoleListener(fConsoleListener);
		
		IConsole[] existing = fConsoleManager.getConsoles();
		for (IConsole c : existing) {
			if (c instanceof IOConsole) {
				((MessageConsole) c).getDocument().removeDocumentListener(fDocumentListener);
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
	
	protected void fireConsoleMessage(String to, String message) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			IConsoleMessageListener listener = (IConsoleMessageListener) listeners[i];			                                                                       
			if (listener.getRequesterID().equals(to)) {
				listener.messageReceived(new ConsoleMessageEvent(message));
			}
		}
	}
	
}
