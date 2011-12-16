package org.eclipse.iee.editor.core.container.event;

public interface IContainerManagerListener {
	public void containerCreated(ContainerEvent event);
	public void containerRemoved(ContainerEvent event);
	public void containerSelected(ContainerEvent event);
	public void containerLostSelection(ContainerEvent event);
	public void debugNotification(ContainerEvent event);
}