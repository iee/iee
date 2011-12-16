package org.eclipse.iee.editor.core.container.event;

import org.eclipse.iee.editor.core.container.Container;

public class ContainerEvent {

	private Container fContainer;
	private String fContainerManagerID;

	public ContainerEvent(Container container, String containerManagerID) {
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