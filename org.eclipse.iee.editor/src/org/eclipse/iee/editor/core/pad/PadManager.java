package org.eclipse.iee.editor.core.pad;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.core.HandlerManager;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.utils.ReflectionUtils;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.common.LoadingPad;
import org.eclipse.iee.editor.core.pad.event.IPadManagerListener;
import org.eclipse.iee.editor.core.pad.event.PadManagerEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PadManager extends EventManager implements IPadManager {

	private static final Logger logger = LoggerFactory.getLogger(PadManager.class);

	/* ContainerManagers */

	private final Map<String, ContainerManager> fContainerManagers;
	private IContainerManagerListener fContainerManagerListener;
	
	/** Registered pad factories. */
	private final HandlerManager<IPadFactory> fPadFactories = new HandlerManager<IPadFactory>(IPadFactory.class);

	/* Pads */

	private final Map<String, Pad> fPads = new TreeMap<String, Pad>();

	/** Pads which are visible by user (have attached container) */
	private final Set<String> fActivePads = new TreeSet<String>();

	/**
	 * Pads which are stored in memory and temporarily not visible by user
	 * (don't have attached container)
	 */
	private final Set<String> fSuspendedPads = new TreeSet<String>();

	/**
	 * Temporary pads which are attached to existent container until
	 * corresponding pad is loaded. This pads are intended to show some loading
	 * animation or error message to user.
	 */
	private final Set<String> fTemporaryPads = new TreeSet<String>();

	/* Constructor */

	public PadManager() {
		fContainerManagers = new TreeMap<String, ContainerManager>();
		InitListener();
	}

	/* Public interface */

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#registerContainerManager(org.eclipse.iee.editor.core.container.ContainerManager)
	 */
	@Override
	public void registerContainerManager(ContainerManager containerManager) {
		List<Container> containers = containerManager.getContainers();
		for (Container container : containers) {
			onContainerCreated(container);
		}
		containerManager.addContainerManagerListener(fContainerManagerListener);
		fContainerManagers.put(containerManager.getContainerManagerID(),
				containerManager);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#removeContainerManager(org.eclipse.iee.editor.core.container.ContainerManager)
	 */
	@Override
	public void removeContainerManager(ContainerManager containerManager) {
		containerManager
				.removeContainerManagerListener(fContainerManagerListener);
		fContainerManagers.remove(containerManager.getContainerManagerID());
		for (String containerID : containerManager.getContainerIDs()) {
			onEditorClosed(containerID);
		}
		firePadManagerEvent(new PadManagerEvent());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#savePadsInEditor(java.lang.String)
	 */
	@Override
	public void savePadsInEditor(String containerManagerID) {
		String[] containerIDs = fContainerManagers.get(containerManagerID)
				.getContainerIDs();

		for (String containerID : containerIDs) {
			if (fActivePads.contains(containerID)) {
				fPads.get(containerID).save();
			}
		}

	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#selectPadsByType(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#selectPadsOfCategory(java.lang.String)
	 */
	@Override
	public Collection<Pad> selectPadsOfCategory(String category) {

		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#selectPadsInContainerManager(java.lang.String)
	 */
	@Override
	public Collection<Pad> selectPadsInContainerManager(
			String containerManagerID) {

		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#selectPads(java.lang.String, java.lang.String)
	 */
	@Override
	public Collection<Pad> selectPads(String containerManager, String category) {

		return null;
	}

	/* Functions used by monitoring plug-in */

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#getActivePads()
	 */
	@Override
	public Object[] getActivePads() {
		return fActivePads.toArray();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#getSuspendedPads()
	 */
	@Override
	public Object[] getSuspendedPads() {
		return fSuspendedPads.toArray();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#getTemporaryPads()
	 */
	@Override
	public Object[] getTemporaryPads() {
		return fTemporaryPads.toArray();
	}

	/*
	 * Gets pad using its id
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#getPadById(java.lang.String)
	 */
	@Override
	public Pad getPadById(String id) {
		return fPads.get(id);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#loadPad(org.eclipse.iee.editor.core.pad.Pad)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#deletePad(org.eclipse.iee.editor.core.pad.Pad, org.eclipse.iee.editor.core.container.ContainerManager)
	 */
	@Override
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
				onContainerCreated(container);
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
					//XXX
//					pad.updateData(container.getPadParams(),
//							container.getValue());
				}
			}

			@Override
			public void containerDeactivated(ContainerEvent event) {
				Pad pad = fPads.get(event.getContainer().getContainerID());
				pad.deactivate();
			}
		};

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
		if (runtimeFile.exists()) {
			runtimeFile.delete();
		}

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

	private void onContainerCreated(Container container) {
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
			clone.getDocumentPart().setId(UUID.randomUUID().toString());
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
			Pad pad = new LoadingPad(container.getPadPart());
			((LoadingPad) pad).setOriginalContainerID(containerID);
			pad.attachContainer(container);
			fTemporaryPads.add(pad.getContainerID());
			fPads.put(pad.getContainerID(), pad);
			return;
		}
		IPadFactory iPadFactory = fPadFactories.getHandler(container.getPadPart().getClass());
		if (iPadFactory != null) {
			Pad pad = iPadFactory.create(container.getPadPart());
			pad.attachContainer(container);
			fActivePads.add(containerID);
			fPads.put(containerID, pad);
		} else {
			/*
			 * Case 4: no corresponding pad. Creating new "loading" pad.
			 */
			Pad pad = new LoadingPad(container.getPadPart());
			pad.attachContainer(container);
			fTemporaryPads.add(containerID);
			fPads.put(containerID, pad);
		}
	}
	
	protected void onContainerRemoved(String containerID) {
		clearPadSetsAndRuntime(containerID, true);
	}

	protected void onEditorClosed(String containerID) {
		clearPadSetsAndRuntime(containerID, false);
	}

	/* For observers */

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#addPadManagerListener(org.eclipse.iee.editor.core.pad.event.IPadManagerListener)
	 */
	@Override
	public void addPadManagerListener(IPadManagerListener listener) {
		Assert.isNotNull(listener);
		addListenerObject(listener);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#removePadManagerListener(org.eclipse.iee.editor.core.pad.event.IPadManagerListener)
	 */
	@Override
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

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, unbind = "unregisterPadFactory", policy = ReferencePolicy.DYNAMIC)
	public void registerPadFactory(IPadFactory factory) {
		fPadFactories.registerHandler(factory);
		loadPads(ReflectionUtils.getGenericParameterClass(factory.getClass(), IPadFactory.class, 0), factory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.IPadManager#loadPads(java.lang.Class, org.eclipse.iee.editor.core.pad.IPadFactory)
	 */
	@Override
	public <T extends PadDocumentPart> void loadPads(Class<T> class1, IPadFactory<T> factory) {
		Map<Integer, Pad> loadPads = new HashMap<Integer, Pad>();
		for (String temp : fTemporaryPads) {
			Pad pad = fPads.get(temp);
			Container container = pad.getContainer();
			if (class1.equals(container.getPadPart().getClass())) {
				Pad create = factory.create((T) container.getPadPart());
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
		fPadFactories.unregisterHandler(factory);
	}

}
