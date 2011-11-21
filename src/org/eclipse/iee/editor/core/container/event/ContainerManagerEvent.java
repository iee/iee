package org.eclipse.iee.editor.core.container.event;

import org.eclipse.iee.editor.core.container.Container;

public class ContainerManagerEvent {

	private Container fContainer;
	private String fContainerManagerID;

	public ContainerManagerEvent(Container container, String containerManagerID) {
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