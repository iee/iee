package org.eclipse.iee.editor.core.utils.runtime.file;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;

public class FileMessager extends EventManager {

	private static final Logger logger = Logger.getLogger(FileMessager.class);

	private Map<String, FileAlterationObserver> fObservers;

	private static FileMessager fFileMessager = new FileMessager();

	public static FileMessager getInstance() {
		return fFileMessager;
	}

	public String getRuntimeDirectoryName() {
		return "runtime";
	}

	protected FileMessager() {
		fObservers = new HashMap<String, FileAlterationObserver>();
	}

	public void clear() {

	}

	public void addFileMessageListener(IFileMessageListener listener,
			String path) {
		Assert.isNotNull(listener);
		addListenerObject(listener);

		if (!fObservers.containsKey(path)) {

			FileAlterationObserver observer = new FileAlterationObserver(
					new File(path + getRuntimeDirectoryName()));

			observer.addListener(new FileAlterationListener() {

				@Override
				public void onStop(FileAlterationObserver arg0) {
				}

				@Override
				public void onStart(FileAlterationObserver arg0) {
				}

				@Override
				public void onFileDelete(File arg0) {
				}

				@Override
				public void onFileCreate(File arg0) {
				}

				@Override
				public void onFileChange(File arg0) {

					String line = null;
					try {
						line = FileUtils.readFileToString(arg0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					String id = arg0.getName();
					fireFileMessage(id, line);

				}

				@Override
				public void onDirectoryDelete(File arg0) {
				}

				@Override
				public void onDirectoryCreate(File arg0) {
				}

				@Override
				public void onDirectoryChange(File arg0) {
				}
			});

			fObservers.put(path, observer);
		}
	}

	public void checkRuntimeValues() {
		Set<Entry<String, FileAlterationObserver>> set = fObservers.entrySet();
		for (Iterator<Entry<String, FileAlterationObserver>> iterator = set
				.iterator(); iterator.hasNext();) {
			FileAlterationObserver observer = iterator.next().getValue();
			observer.checkAndNotify();
		}
	}

	public void removeFileMessageListener(IFileMessageListener listener,
			String path) {
		Assert.isNotNull(listener);
		removeListenerObject(listener);

		if (fObservers.containsKey(path)) {
			FileAlterationObserver observer = fObservers.get(path);
			for (Iterator<FileAlterationListener> iterator = observer
					.getListeners().iterator(); iterator.hasNext();) {
				iterator.remove();
			}
		}
	}

	protected void fireFileMessage(String to, String message) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			IFileMessageListener listener = (IFileMessageListener) listeners[i];
			if (listener.getRequesterID().equals(to)) {
				listener.messageReceived(new FileMessageEvent(message));
			}
		}
	}

}
