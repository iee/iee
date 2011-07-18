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
	
	public void releaseContainerManager(ContainerManager containerManager) {
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
			String containerID = pad.getContainerID();
			containerManager.RequestContainerRelease(containerID);
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
				Assert.isLegal(pad.getContainerID().equals(containerID));
				Assert.isNotNull(pad); // stash save
				
				pad.attachContainer(container);
				fSuspendedPads.remove(containerID);
				fPads.put(containerID, pad);
			}

			@Override
			public void containerDuplicated(ContainerManagerEvent event) {
				Assert.isLegal(event.isContainerDuplicated());
				
				Container container = event.getContainer();
				String containerID = container.getContainerID();
				
				Pad original = fPads.get(event.getOriginalContainer().getContainerID());
				Assert.isNotNull(original);
				
				Pad pad = original.copy();
				pad.setContainerID(containerID);
				pad.attachContainer(container);
				fPads.put(containerID, pad);
			}

			@Override
			public void containerRemoved(ContainerManagerEvent event) {			
				String containerID = event.getContainer().getContainerID();
				Pad pad = fPads.get(containerID);
				Assert.isNotNull(pad);
				
				pad.detachContainer();
				fPads.remove(containerID);
				fSuspendedPads.put(containerID, pad);
			}
			
			@Override
			public void debugNotification(ContainerManagerEvent event) {
			}
		};
	}
}
