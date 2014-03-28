package org.eclipse.iee.editor.core.pad;

import java.util.Collection;
import java.util.List;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.event.IPadManagerListener;

public interface IPadManager {

	/**
	 * Called by editor to make connection with it's ContainerManager
	 * 
	 * @param containerManager
	 */
	public abstract void registerContainerManager(
			ContainerManager containerManager);

	/**
	 * Called by editor to disconnect it's ContainerManager
	 * 
	 * @param containerManager
	 */
	public abstract void removeContainerManager(
			ContainerManager containerManager);

	public abstract void savePadsInEditor(String containerManagerID);

	public abstract List<Pad> selectPadsByType(String type);

	public abstract Collection<Pad> selectPadsOfCategory(String category);

	public abstract Collection<Pad> selectPadsInContainerManager(
			String containerManagerID);

	public abstract Collection<Pad> selectPads(String containerManager,
			String category);

	public abstract Object[] getActivePads();

	public abstract Object[] getSuspendedPads();

	public abstract Object[] getTemporaryPads();

	/*
	 * Gets pad using its id
	 */
	public abstract Pad getPadById(String id);

	/**
	 * Called when external plug-in needs to load pad that was created before.
	 * 
	 * @param pad
	 */
	public abstract void loadPad(Pad pad);

	/**
	 * Request pad removal.
	 * 
	 * @param pad
	 * @param containerManager
	 */
	public abstract void deletePad(Pad pad, ContainerManager containerManager);

	public abstract void addPadManagerListener(IPadManagerListener listener);

	public abstract void removePadManagerListener(IPadManagerListener listener);

	public abstract <T extends PadDocumentPart> void loadPads(Class<T> class1,
			IPadFactory<T> factory);

}