package org.eclipse.iee.editor.core.pad;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.common.LoadingPad;
import org.eclipse.iee.editor.core.pad.event.IPadManagerListener;
import org.eclipse.iee.editor.core.pad.event.PadManagerEvent;

public class PadManager extends EventManager {

	/* ContainerManagers */

	private Map<String, ContainerManager> fContainerManagers;
	private IContainerManagerListener fContainerManagerListener;

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
		fContainerManagers.put(
			containerManager.getContainerManagerID(),
			containerManager);
	}

	/**
	 * Called by editor to disconnect it's ContainerManager
	 * 
	 * @param containerManager
	 */
	public void removeContainerManager(ContainerManager containerManager) {
		containerManager.removeContainerManagerListener(fContainerManagerListener);
		fContainerManagers.remove(containerManager.getContainerManagerID());
		for (String containerID : containerManager.getContainerIDs()) {
			onContainerRemoved(containerID);
		}
		firePadManagerEvent(new PadManagerEvent());
	}

	public void savePadsInEditor(String containerManagerID) {
		String[] containerIDs =
			fContainerManagers.get(containerManagerID).getContainerIDs();
		
		for (String containerID : containerIDs) {
			if (fActivePads.contains(containerID)) {
				fPads.get(containerID).save();
			}
		}
		
		/* Remove storages of all suspended pads */
		for (String containerID : fSuspendedPads) {
			fPads.get(containerID).unsave();
		}
	}

	public Collection<Pad> selectPadsOfCategory(String category) {
		return null;
	}

	public Collection<Pad> selectPadsInContainerManager(String containerManager) {
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

		Assert.isLegal(!fActivePads.contains(containerID));
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
		containerManager.RequestContainerAllocation(pad.getContainerID(), location);
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
		};
	}

	/* Internal functions */
	protected void onContainerRemoved(String containerID) {
		if (fActivePads.contains(containerID)) {
			Pad pad = fPads.get(containerID);
			pad.detachContainer();
			fActivePads.remove(containerID);
			fSuspendedPads.add(containerID);
			return;
		}
		if (fTemporaryPads.contains(containerID)) {
			Pad pad = fPads.get(containerID);
			pad.detachContainer();
			fTemporaryPads.remove(containerID);
			return;
		}
		Assert.isLegal(false);
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
}
