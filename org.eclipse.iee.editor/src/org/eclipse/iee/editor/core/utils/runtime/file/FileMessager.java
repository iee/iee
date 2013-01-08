package org.eclipse.iee.editor.core.utils.runtime.file;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
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
	
	public String getRuntimeFileName() {
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

			IOFileFilter filter = FileFilterUtils.and(
					FileFilterUtils.fileFileFilter(),
					FileFilterUtils.nameFileFilter(getRuntimeFileName()));

			FileAlterationObserver observer = new FileAlterationObserver(
					new File(path), filter);
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

					String[] lines = null;
					try {
						lines = FileUtils.readFileToString(arg0).split(
								"\\r?\\n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (String line : lines) {
						try {
							final int prefixLength = 36;
							String id = line.substring(0, prefixLength);

							Pattern p = Pattern
									.compile("\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}");
							Matcher m = p.matcher(id);
							if (m.matches()) {
								String message = line.substring(prefixLength);
								fireFileMessage(id, message);
							}
						} catch (IndexOutOfBoundsException e) {
							// Do nothing
						}
					}

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
