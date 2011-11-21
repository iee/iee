package org.eclipse.iee.editor.core.container.event;



public interface IContainerManagerListener {
	public void containerCreated(ContainerManagerEvent event);
	public void containerRemoved(ContainerManagerEvent event);
	public void debugNotification(ContainerManagerEvent event);
}