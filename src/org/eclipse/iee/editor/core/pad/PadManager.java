package org.eclipse.iee.editor.core.pad;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.ContainerManagerEvent;
import org.eclipse.iee.editor.core.container.IContainerManagerListener;

public class PadManager extends EventManager {

	
	/* ContainerManagers */
	
	private Set<ContainerManager> fContainerManagers;
	private IContainerManagerListener fContainerManagerListener;
	
	
	/* Pads */
	
	/** Pads which are visible by user (have attached container) */
	private Map<String, Pad> fActivePads = new TreeMap<String, Pad>();
	
	/** Pads which are stored in memory and temporarily not visible by user (don't have attached container) */
	private Map<String, Pad> fSuspendedPads = new TreeMap<String, Pad>();
	
	/** Temporary pads which are attached to existent container until corresponding pad is loaded.
	 *  This pads are intended to show some loading animation or error message to user. 
	 */
	private Map<String, Pad> fTemporaryPads = new TreeMap<String, Pad>();

	
	public PadManager() {
		fContainerManagers = new HashSet<ContainerManager>();		
		InitListener();
	}

	
	/* Public interface */
	
	/**
	 * Called by editor to make connection with it's ContainerManager
	 * @param containerManager
	 */
	public void registerContainerManager(ContainerManager containerManager) {
		System.out.println("registerContainerManager");
		containerManager.addContainerManagerListener(fContainerManagerListener);
		fContainerManagers.add(containerManager);
	}
	
	/**
	 * Called by editor to disconnect it's ContainerManager
	 * @param containerManager
	 */
	public void removeContainerManager(ContainerManager containerManager) {
		containerManager.removeContainerManagerListener(fContainerManagerListener);
		fContainerManagers.remove(containerManager);
	}
    
	
	/* Functions used by monitoring plug-in */
	
	public Object[] getActivePads() {
		return fActivePads.values().toArray();
    }
	
	public Object[] getSuspendedPads() {
		return fSuspendedPads.values().toArray();
    }
	
	public Object[] getTemporaryPads() {
		return fTemporaryPads.values().toArray();
    }
    
	
	/**
	 * Called when external plug-in needs to load pad that was created before.
	 * @param pad
	 */	
	public void loadPad(Pad pad) {
		String containerID = pad.getContainerID();
		
		Assert.isLegal(!fActivePads.containsKey(containerID));
		Assert.isLegal(!fSuspendedPads.containsKey(containerID));
		
		Pad loading = fTemporaryPads.get(containerID);
		if (loading != null) {
			/*
			 * Case 1: container with corresponding id already exists
			 */
			Container container = loading.getContainer();
			
			/* Remove 'loading' pad */
			loading.detachContainer();
			fTemporaryPads.remove(containerID);
			
			/* Adding pad */
			pad.attachContainer(container);
			fActivePads.put(containerID, pad);
			return;
		}

		/*
		 * Case 2: no corresponding container, make pad suspended
		 */
		fSuspendedPads.put(containerID, pad);		
	}

	
	/**
	 * Used by external plug-in to insert new pad.
	 * @param pad
	 * @param location
	 * @param containerManager
	 */
	public void insertPad(Pad pad, int location, ContainerManager containerManager) {
		Assert.isLegal(fContainerManagers.contains(containerManager));
		fSuspendedPads.put(pad.getContainerID(), pad);
		containerManager.RequestContainerAllocation(pad.getContainerID(), location);
	}
	
	
	/**
	 * Request pad removal.
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
				
				Pad pad = fSuspendedPads.get(containerID);
				if (pad != null) {
					/* 
					 * Case 1: container corresponds to suspended pad.
					 * Attaching container to pad.
					 */
					Assert.isLegal(pad.getContainerID().equals(containerID));
					pad.attachContainer(container);
					fSuspendedPads.remove(containerID);
					fActivePads.put(containerID, pad);
					return;
				}
				
				pad = fActivePads.get(containerID);
				if (pad != null) {
					/*
					 * Case 2: container is copied from another place.
					 * Copying pad and attaching container.
					 */
					Pad clone = pad.copy();
					clone.attachContainer(container);
					fActivePads.put(clone.getContainerID(), clone);
					return;
				}
				
				pad = fTemporaryPads.get(containerID);
				if (pad != null) {
					/*
					 * Case 3: container with corresponding "Temporary" pad is copied from another place.
					 * Creating loading pad.
					 */
					pad = new LoadingPad();
					((LoadingPad)pad).setOriginalContainerID(containerID);
					pad.attachContainer(container);
					fTemporaryPads.put(pad.getContainerID(), pad);
					return;
				}
				
				/*
				 * Case 4: no corresponding pad.
				 * Creating new "loading" pad.
				 */
				pad = new LoadingPad(containerID);
				pad.attachContainer(container);
				fTemporaryPads.put(containerID, pad);
			}

			@Override
			public void containerRemoved(ContainerManagerEvent event) {
				String containerID = event.getContainer().getContainerID();
				
				Pad pad = fActivePads.get(containerID);
				if (pad != null) {
					pad.detachContainer();
					fActivePads.remove(containerID);
					fSuspendedPads.put(containerID, pad);
					return;
				}
				
				pad = fTemporaryPads.get(containerID);
				if (pad != null) {
					pad.detachContainer();
					fTemporaryPads.remove(containerID);
					return;
				}
				
				Assert.isNotNull(pad);
			}
			
			@Override public void debugNotification(ContainerManagerEvent event) {
				firePadManagerEvent(new PadManagerEvent());
			}
		};
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
