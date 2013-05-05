package org.eclipse.iee.editor.core.pad;

import java.io.File;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.common.LoadingPad;
import org.eclipse.iee.editor.core.pad.event.IPadManagerListener;
import org.eclipse.iee.editor.core.pad.event.PadManagerEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.jface.text.Position;

public class PadManager extends EventManager {

	private static final Logger logger = Logger.getLogger(PadManager.class);

	/* ContainerManagers */

	private Map<String, ContainerManager> fContainerManagers;
	private IContainerManagerListener fContainerManagerListener;
	private IDebugEventSetListener fDebugListener;

	/** Registered pad factories. */
	private Map<String, IPadFactory> fPadFactories = new HashMap<String, IPadFactory>();

	/* Pads */

	private Map<String, Pad> fPads = new TreeMap<String, Pad>();

	/** Pads which are visible by user (have attached container) */
	private Set<String> fActivePads = new TreeSet<String>();

	/**
	 * Pads which are stored in memory and temporarily not visible by user
	 * (don't have attached container)
	 */
	private Set<String> fSuspendedPads = new TreeSet<String>();

	/**
	 * Temporary pads which are attached to existent container until
	 * corresponding pad is loaded. This pads are intended to show some loading
	 * animation or error message to user.
	 */
	private Set<String> fTemporaryPads = new TreeSet<String>();

	/* Constructor */

	public PadManager() {
		fContainerManagers = new TreeMap<String, ContainerManager>();
		InitListener();
	}

	/* Public interface */

	/**
	 * Called by editor to make connection with it's ContainerManager
	 * 
	 * @param containerManager
	 */
	public void registerContainerManager(ContainerManager containerManager) {
		containerManager.addContainerManagerListener(fContainerManagerListener);
		fContainerManagers.put(containerManager.getContainerManagerID(),
				containerManager);
	}

	/**
	 * Called by editor to disconnect it's ContainerManager
	 * 
	 * @param containerManager
	 */
	public void removeContainerManager(ContainerManager containerManager) {
		containerManager
				.removeContainerManagerListener(fContainerManagerListener);
		fContainerManagers.remove(containerManager.getContainerManagerID());
		for (String containerID : containerManager.getContainerIDs()) {
			onEditorClosed(containerID);
		}
		firePadManagerEvent(new PadManagerEvent());
	}

	public void savePadsInEditor(String containerManagerID) {
		String[] containerIDs = fContainerManagers.get(containerManagerID)
				.getContainerIDs();

		for (String containerID : containerIDs) {
			if (fActivePads.contains(containerID)) {
				fPads.get(containerID).save();
			}
		}

	}

	public List<Pad> selectPadsByType(String type) {
		List<Pad> result = new ArrayList<Pad>();
		for (String id : fActivePads) {
			Pad pad = fPads.get(id);
			if (pad.getType().equals(type)) {
				result.add(pad);
			}
		}
		return result;
	}

	public Collection<Pad> selectPadsOfCategory(String category) {

		return null;
	}

	public Collection<Pad> selectPadsInContainerManager(
			String containerManagerID) {

		return null;
	}

	public Collection<Pad> selectPads(String containerManager, String category) {

		return null;
	}

	/* Functions used by monitoring plug-in */

	public Object[] getActivePads() {
		return fActivePads.toArray();
	}

	public Object[] getSuspendedPads() {
		return fSuspendedPads.toArray();
	}

	public Object[] getTemporaryPads() {
		return fTemporaryPads.toArray();
	}

	/*
	 * Gets pad using its id
	 */
	public Pad getPadById(String id) {
		return fPads.get(id);
	}

	/**
	 * Called when external plug-in needs to load pad that was created before.
	 * 
	 * @param pad
	 */
	public void loadPad(Pad pad) {
		String containerID = pad.getContainerID();

		if (fActivePads.contains(containerID))
			return;

		Assert.isLegal(!fSuspendedPads.contains(containerID));

		if (fTemporaryPads.contains(containerID)) {
			/*
			 * Case 1: container with corresponding id already exists
			 */
			Pad temporary = fPads.get(containerID);
			Container container = temporary.getContainer();

			/* Remove 'loading' pad */
			temporary.detachContainer();
			fTemporaryPads.remove(containerID);
			fPads.remove(containerID);

			container.reset();

			/* Adding pad */
			pad.attachContainer(container);
			fActivePads.add(containerID);
			fPads.put(containerID, pad);
			return;
		}

		/*
		 * Case 2: no corresponding container, make pad suspended
		 */
		fSuspendedPads.add(containerID);
		fPads.put(containerID, pad);
	}

	/**
	 * Used by external plug-in to insert new pad.
	 * 
	 * @param pad
	 * @param location
	 * @param containerManager
	 */
	public void insertPad(Pad pad, int location,
			ContainerManager containerManager) {
		Assert.isLegal(fContainerManagers.containsKey(containerManager
				.getContainerManagerID()));
		fSuspendedPads.add(pad.getContainerID());
		fPads.put(pad.getContainerID(), pad);
		containerManager.RequestContainerAllocation(pad.getType(),
				pad.getContainerID(), location);
	}

	/**
	 * Request pad removal.
	 * 
	 * @param pad
	 * @param containerManager
	 */
	public void deletePad(Pad pad, ContainerManager containerManager) {
		if (pad.isContainerAttached()) {
			pad.getContainer().destroy();
		}
	}

	/* Internal functions */

	protected void InitListener() {
		fContainerManagerListener = new IContainerManagerListener() {

			@Override
			public void containerCreated(ContainerEvent event) {
				Container container = event.getContainer();
				String containerID = container.getContainerID();

				if (fSuspendedPads.contains(containerID)) {
					/*
					 * Case 1: container corresponds to suspended pad. Attaching
					 * container to pad.
					 */
					Pad pad = fPads.get(containerID);

					Assert.isLegal(pad.getContainerID().equals(containerID));
					pad.attachContainer(container);
					fSuspendedPads.remove(containerID);
					fActivePads.add(containerID);
					fPads.put(containerID, pad);
					return;
				}

				if (fActivePads.contains(containerID)) {
					/*
					 * Case 2: container is copied from another place. Copying
					 * pad and attaching container.
					 */
					Pad pad = fPads.get(containerID);
					Pad clone = pad.copy();
					clone.attachContainer(container);
					fActivePads.add(clone.getContainerID());
					fPads.put(clone.getContainerID(), clone);
					return;
				}

				if (fTemporaryPads.contains(containerID)) {
					/*
					 * Case 3: container with corresponding "Temporary" pad is
					 * copied from another place. Creating loading pad.
					 */
					Pad pad = new LoadingPad();
					((LoadingPad) pad).setOriginalContainerID(containerID);
					pad.attachContainer(container);
					fTemporaryPads.add(pad.getContainerID());
					fPads.put(pad.getContainerID(), pad);
					return;
				}

				/*
				 * Case 4: no corresponding pad. Creating new "loading" pad.
				 */
				Pad pad = new LoadingPad(containerID);
				pad.attachContainer(container);
				fTemporaryPads.add(containerID);
				fPads.put(containerID, pad);
			}

			@Override
			public void containerRemoved(ContainerEvent event) {
				onContainerRemoved(event.getContainer().getContainerID());
			}

			@Override
			public void debugNotification(ContainerEvent event) {
				firePadManagerEvent(new PadManagerEvent());
			}

			@Override
			public void containerSelected(ContainerEvent event) {
				Pad selected = fPads.get(event.getContainer().getContainerID());
				selected.setSelected(true);
			}

			@Override
			public void containerLostSelection(ContainerEvent event) {
				Pad selected = fPads.get(event.getContainer().getContainerID());
				selected.setSelected(false);
			}

			@Override
			public void containerActivated(ContainerEvent event) {
				Pad pad = fPads.get(event.getContainer().getContainerID());
				pad.activate();
			}

			@Override
			public void containerUpdated(ContainerEvent containerEvent) {
				Container container = containerEvent.getContainer();
				Pad pad = fPads.get(container.getContainerID());
				if (pad != null) {
					pad.updateData(container.getPadParams(),
							container.getValue());
				}
			}

			@Override
			public void containerDeactivated(ContainerEvent event) {
				Pad pad = fPads.get(event.getContainer().getContainerID());
				pad.deactivate();
			}
		};

		DebugPlugin.getDefault().addDebugEventListener(
				new IDebugEventSetListener() {

					@Override
					public void handleDebugEvents(DebugEvent[] events) {
						for (DebugEvent e : events) {
							if (e.getKind() == DebugEvent.TERMINATE)
								FileMessager.getInstance().checkRuntimeValues();
						}
					}
				});

	}

	/* Internal functions */
	private void clearPadSetsAndRuntime(String containerID,
			boolean addToSuspended) {
		Pad pad = fPads.get(containerID);

		String runtimePath = pad.getContainer().getContainerManager()
				.getStoragePath()
				+ FileMessager.getInstance().getRuntimeDirectoryName()
				+ "/"
				+ containerID;

		File runtimeFile = new File(runtimePath);
		if (runtimeFile.exists())
			FileUtils.deleteQuietly(runtimeFile);

		if (fActivePads.contains(containerID)) {
			pad.detachContainer();
			fActivePads.remove(containerID);

			if (addToSuspended)
				fSuspendedPads.add(containerID);

			return;
		}
		if (fTemporaryPads.contains(containerID)) {
			pad.detachContainer();
			fTemporaryPads.remove(containerID);
			return;
		}
		Assert.isLegal(false);
	}

	protected void onContainerRemoved(String containerID) {
		clearPadSetsAndRuntime(containerID, true);
	}

	protected void onEditorClosed(String containerID) {
		clearPadSetsAndRuntime(containerID, false);
	}

	/* For observers */

	public void addPadManagerListener(IPadManagerListener listener) {
		Assert.isNotNull(listener);
		addListenerObject(listener);
	}

	public void removePadManagerListener(IPadManagerListener listener) {
		Assert.isNotNull(listener);
		removeListenerObject(listener);
	}

	protected void firePadManagerEvent(PadManagerEvent event) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IPadManagerListener) listeners[i]).padManagerUpdate(event);
		}
	}

	public void registerPadFactory(String containerManagerId, String type,
			IPadFactory factory) {
		fPadFactories.put(type, factory);
		loadPads(containerManagerId, type, factory);
	}

	public void loadPads(String containerManagerId, String type,
			IPadFactory factory) {
		Map<Integer, Pad> loadPads = new HashMap<Integer, Pad>();
		for (String temp : fTemporaryPads) {
			Pad pad = fPads.get(temp);
			Container container = pad.getContainer();
			if (container.getContainerManagerID().equals(containerManagerId)
					&& type.equals(container.getPadType())) {
				Pad create = factory.create(container.getPadParams(),
						container.getValue());
				create.setContainerID(container.getContainerID());
				loadPads.put(container.getPosition().offset, create);

			}
		}

		List<Integer> padsOffsets = new ArrayList<Integer>();
		padsOffsets.addAll(loadPads.keySet());
		Collections.sort(padsOffsets);

		for (int offset : padsOffsets) {
			loadPad(loadPads.get(offset));
		}

	}

	public void unregisterPadFactory(IPadFactory factory) {
		Set<Entry<String, IPadFactory>> entrySet = fPadFactories.entrySet();
		for (Iterator<Entry<String, IPadFactory>> iterator = entrySet
				.iterator(); iterator.hasNext();) {
			Entry<String, IPadFactory> entry = iterator.next();
			if (entry.getValue() == factory) {
				iterator.remove();
			}
		}
	}

	public Pad parsePad(String text) {
		try {
		    StringReader r = new StringReader(text);
			StreamTokenizer st = new StreamTokenizer(r);
		    String type = readString(st);
		    if("----".equals(type)) {
		    	type = null;
		    }
		    Map<String, String> params = readParams(st);
		    int nextToken = st.nextToken();
		    String value;
		    if (nextToken == ':') {
		        StringBuilder sb = new StringBuilder();
		        int c;
		        while ((c = r.read()) != -1) {
		            sb.append((char)c);
		        }
		        value = sb.toString();
		    } else {
		        value = "";
		    }
		    Pad pad = fPadFactories.get(type).create(params, value);
		    pad.setContainerID(params.get("id"));
			return pad;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param st
	 * @return
	 * @throws IOException 
	 */
	private static Map<String, String> readParams(StreamTokenizer st) throws IOException {
	    Map<String, String> params = new HashMap<String, String>();
	    int nextToken = st.nextToken();
	    if ((char) nextToken == '(') {
	        while (true) {
	            parseParam(st, params);
	            nextToken = st.nextToken();
	            if ((char) nextToken == ')') {
	               break;
	            } else if ((char) nextToken == ',') {
	                
	            } else {
	                throw new IllegalArgumentException("failed to parse: " + st);
	            }
	        }
	    } else {
	        st.pushBack();
	    }
	    return params;
	}
	
	/**
	 * @param st
	 * @param params
	 * @throws IOException
	 */
	private static void parseParam(StreamTokenizer st, Map<String, String> params) throws IOException {
	    int nextToken;
	    String param = readString(st);
	    nextToken = st.nextToken();
	    if ((char) nextToken != '=') {
	        throw new IllegalArgumentException("failed to parse: " + st);
	    }
	    String value = readString(st);
	    params.put(param, value);
	}
	
	
	/**
	 * @param st
	 * @return
	 * @throws IOException 
	 */
	private static String readString(StreamTokenizer st) throws IOException {
	    int nextToken = st.nextToken();
	    if (nextToken == StreamTokenizer.TT_WORD || nextToken == 34) {
	        return st.sval;
	    } else if (nextToken == StreamTokenizer.TT_NUMBER) {
	        return String.valueOf(st.nval);
	    }
	    throw new IllegalArgumentException("failed to parse: " + st);
	}

}
