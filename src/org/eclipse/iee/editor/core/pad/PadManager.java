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
import org.eclipse.iee.editor.core.container.ContainerManagerEvent;
import org.eclipse.iee.editor.core.container.IContainerManagerListener;

public class PadManager extends EventManager {

	/* ContainerManagers */

	// private Set<ContainerManager> fContainerManagers;
	private Map<String, ContainerManager> fContainerManagers;
	private IContainerManagerListener fContainerManagerListener;

	/* Pads */

	/** Pads which are visible by user (have attached container) */
	// private Map<String, Pad> fActivePads = new TreeMap<String, Pad>();

	/**
	 * Pads which are stored in memory and temporarily not visible by user
	 * (don't have attached container)
	 */
	// private Map<String, Pad> fSuspendedPads = new TreeMap<String, Pad>();

	/**
	 * Temporary pads which are attached to existent container until
	 * corresponding pad is loaded. This pads are intended to show some loading
	 * animation or error message to user.
	 */
	// private Map<String, Pad> fTemporaryPads = new TreeMap<String, Pad>();

	private Map<String, Pad> fPads = new TreeMap<String, Pad>();
	private Set<String> fActivePads = new TreeSet<String>();
	private Set<String> fSuspendedPads = new TreeSet<String>();
	private Set<String> fTemporaryPads = new TreeSet<String>();

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
		System.out.println("registerContainerManager");
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
			onContainerRemoved(containerID);
		}
		firePadManagerEvent(new PadManagerEvent());
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
		containerManager.RequestContainerAllocation(pad.getContainerID(),
				location);
	}

	/**
	 * Request pad removal.
	 * 
	 * @param pad
	 * @param containerManager
	 */
	public void deletePad(Pad pad, ContainerManager containerManager) {
		if (pad.isContainerAttached()) {
			pad.getContainer().requestDispose();
		}
	}

	/* Internal functions */

	protected void InitListener() {
		fContainerManagerListener = new IContainerManagerListener() {

			@Override
			public void containerCreated(ContainerManagerEvent event) {
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
			public void containerRemoved(ContainerManagerEvent event) {
				onContainerRemoved(event.getContainer().getContainerID());
			}

			@Override
			public void debugNotification(ContainerManagerEvent event) {
				firePadManagerEvent(new PadManagerEvent());
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
