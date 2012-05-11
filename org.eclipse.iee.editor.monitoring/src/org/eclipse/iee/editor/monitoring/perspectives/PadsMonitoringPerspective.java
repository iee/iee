/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.iee.editor.monitoring.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


public class PadsMonitoringPerspective implements IPerspectiveFactory {

	private IPageLayout factory;

	public PadsMonitoringPerspective() {
		super();
	}

	public void createInitialLayout(IPageLayout factory) {
		this.factory = factory;
		addViews();
		addActionSets();
		addNewWizardShortcuts();
		addPerspectiveShortcuts();
		addViewShortcuts();
	}

	private void addViews() {

		IFolderLayout first =
			factory.createFolder(
				"right", //NON-NLS-1
				IPageLayout.RIGHT,
				0.5f,
				factory.getEditorArea());
		
		first.addView("org.eclipse.iee.editor.monitoring.views.EditorContainersMonitoringView"); //NON-NLS-1
		first.addView("org.eclipse.iee.editor.monitoring.views.PadsMonitoringView"); //NON-NLS-1
		
		//factory.addFastView("org.eclipse.team.ccvs.ui.RepositoriesView",0.50f); //NON-NLS-1
	}

	private void addActionSets() {
		//factory.addActionSet("org.eclipse.debug.ui.launchActionSet"); //NON-NLS-1
	}

	private void addPerspectiveShortcuts() {
		//factory.addPerspectiveShortcut("org.eclipse.team.ui.TeamSynchronizingPerspective"); //NON-NLS-1
	}

	private void addNewWizardShortcuts() {
		//factory.addNewWizardShortcut("org.eclipse.team.cvs.ui.newProjectCheckout");//NON-NLS-1		
	}

	private void addViewShortcuts() {
		factory.addShowViewShortcut("org.eclipse.iee.editor.monitoring.views.EditorContainersMonitoringView"); //NON-NLS-1
		factory.addShowViewShortcut("org.eclipse.iee.editor.monitoring.views.PadsMonitoringView"); //NON-NLS-1
	}
}
