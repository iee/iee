package org.eclipse.iee.editor.core.pad;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.ContainerManagerEvent;
import org.eclipse.iee.editor.core.container.IContainerManagerListener;

public class PadManager {

	
	/* ContainerManagers */
	
	private Set<ContainerManager> fContainerManagers;
	
	private IContainerManagerListener fContainerManagerListener;
	
	
	/* Pads */
	
	private Map<String, Pad> fPads = new TreeMap<String, Pad>();
	private Map<String, Pad> fSuspendedPads = new TreeMap<String, Pad>();
	private Map<String, Pad> fLoadingPads = new TreeMap<String, Pad>();
	
		
	public PadManager() {
		fContainerManagers = new HashSet<ContainerManager>();
		
		InitListener();
	}
	
	/* Public interface */
	
	public void registerContainerManager(ContainerManager containerManager) {
		System.out.println("registerContainerManager");
		containerManager.addContainerManagerListener(fContainerManagerListener);
		fContainerManagers.add(containerManager);
	}
	
	public void removeContainerManager(ContainerManager containerManager) {
		containerManager.removeContainerManagerListener(fContainerManagerListener);
		fContainerManagers.remove(containerManager);
	}
    
	public Object[] getElements() {
		return fPads.values().toArray();
    }
	
	
	public void createPad(Pad pad, int location, ContainerManager containerManager) {
		Assert.isLegal(fContainerManagers.contains(containerManager));
		fSuspendedPads.put(pad.getContainerID(), pad);
		containerManager.RequestContainerAllocation(pad.getContainerID(), location);
	}
	
	public void destroyPad(Pad pad, ContainerManager containerManager) {
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
					fPads.put(containerID, pad);
					return;
				}
				
				pad = fPads.get(containerID);
				if (pad != null) {
					/*
					 * Case 2: container is copied from another place.
					 * Copying pad and attaching container.
					 */
					Pad clone = pad.copy();					
					clone.attachContainer(container);
					fPads.put(clone.getContainerID(), clone);
					return;
				}
				
				pad = fLoadingPads.get(containerID);
				if (pad != null) {
					/*
					 * Case 3: container with corresponding "loading" pad is copied from another place.
					 * Creating new loading pad (container id remains the same).
					 */
					Pad clone = pad.copy();
					clone.setContainerID(pad.getContainerID());
					clone.attachContainer(container);
					fPads.put(clone.getContainerID(), clone);
					return;
				}
				
				/*
				 * Case 4: no corresponding pad.
				 * Creating new "loading" pad.
				 */
				pad = new LoadingPad(containerID);
				pad.attachContainer(container);
				fLoadingPads.put(containerID, pad);
			}

			@Override
			public void containerRemoved(ContainerManagerEvent event) {
				String containerID = event.getContainer().getContainerID();
				
				Pad pad = fPads.get(containerID);
				if (pad != null) {
					pad.detachContainer();
					fPads.remove(containerID);
					fSuspendedPads.put(containerID, pad);
					return;
				}
				
				pad = fLoadingPads.get(containerID);
				if (pad != null) {
					pad.detachContainer();
					fLoadingPads.remove(containerID);
					return;
				}
				
				Assert.isNotNull(pad);
			}
			
			@Override
			public void debugNotification(ContainerManagerEvent event) {
			}
		};
	}
}
