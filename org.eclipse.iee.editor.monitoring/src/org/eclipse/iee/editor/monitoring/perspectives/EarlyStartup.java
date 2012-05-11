package org.eclipse.iee.editor.monitoring.perspectives;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Perspective;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;

@SuppressWarnings("restriction")
public class EarlyStartup implements IStartup {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	public void earlyStartup() {
		/*
		 * The registration of the listener should have been done in the UI
		 * thread since PlatformUI.getWorkbench().getActiveWorkbenchWindow()
		 * returns null if it is called outside of the UI thread.
		 */
		Display.getDefault().asyncExec(new Runnable() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				final IWorkbenchWindow workbenchWindow = PlatformUI
						.getWorkbench().getActiveWorkbenchWindow();
				if (workbenchWindow != null) {
					workbenchWindow
							.addPerspectiveListener(new PerspectiveAdapter() {
								/*
								 * (non-Javadoc)
								 * 
								 * @seeorg.eclipse.ui.PerspectiveAdapter#
								 * perspectiveActivated
								 * (org.eclipse.ui.IWorkbenchPage,
								 * org.eclipse.ui.IPerspectiveDescriptor)
								 */
								@Override
								public void perspectiveActivated(
										IWorkbenchPage page,
										IPerspectiveDescriptor perspectiveDescriptor) {
									super.perspectiveActivated(page,
											perspectiveDescriptor);
									System.err.println("--> "
											+ perspectiveDescriptor.getId());
									if (perspectiveDescriptor
											.getId()
											.indexOf(
													"org.eclipse.iee.editor.monitoring.perspectives.PadsMonitoringPerspective") > -1) {
										if (workbenchWindow.getActivePage() instanceof WorkbenchPage) {
											WorkbenchPage worbenchPage = (WorkbenchPage) workbenchWindow
													.getActivePage();
											// Get the perspective
											Perspective perspective = worbenchPage
													.findPerspective(perspectiveDescriptor);
											ArrayList<IActionSetDescriptor> toRemove = new ArrayList<IActionSetDescriptor>();
											if (perspective != null) {
												for (IActionSetDescriptor actionSetDescriptor : perspective
														.getAlwaysOnActionSets()) {
													if (actionSetDescriptor
															.getId()
															.indexOf(
																	"org.eclipse.search.searchActionSet") > -1) {
														// Add the action set
														// descriptor
														// to the list of the
														// action
														// sets to remove
														toRemove.add(actionSetDescriptor);
													}
												}
												perspective
														.turnOffActionSets((IActionSetDescriptor[]) toRemove
																.toArray(new IActionSetDescriptor[toRemove
																		.size()]));
											}
										}
									}
								}
							});
				}
			}
		});
	}

}
