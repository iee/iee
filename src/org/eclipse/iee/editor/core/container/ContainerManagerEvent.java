package org.eclipse.iee.editor.core.container;

public class ContainerManagerEvent {

	private Container fContainer;
	private String fContainerManagerID;

	ContainerManagerEvent(Container container, String containerManagerID) {
		fContainer = container;
		fContainerManagerID = containerManagerID;
	}

	public Container getContainer() {
		return fContainer;
	}

	public String getContainerManagerID() {
		return fContainerManagerID;
	}
}