package org.eclipse.iee.editor.sample;

import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.ContainerManagerEvent;
import org.eclipse.iee.editor.core.container.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.ui.editors.text.TextEditor;

public class SampleExtendedEditor extends TextEditor implements IPadEditor {
	
	private ContainerManager fContainerManager;
	private IContainerManagerListener fContainerManagerListener;
	
	private final PadManager fPadManager = IeeEditorPlugin.getDefault().getPadManager();
	
	public void createPartControl(org.eclipse.swt.widgets.Composite parent) {
		super.createPartControl(parent);
		
		initIeeEditorCore();
	};
	
	public void initIeeEditorCore() {
		StyledText styledText = getSourceViewer().getTextWidget();
		IDocument document = getSourceViewer().getDocument();

		fContainerManager = new ContainerManager(document, styledText);
		
		fContainerManagerListener = new IContainerManagerListener() {
			@Override
			public void debugNotification(ContainerManagerEvent event) {
				firePropertyChange(PROP_CONTAINER_SET);
			}
			@Override public void containerCreated(ContainerManagerEvent event) {}
			@Override public void containerRemoved(ContainerManagerEvent event) {}			
		};
		fContainerManager.addContainerManagerListener(fContainerManagerListener);
		
		fPadManager.registerContainerManager(fContainerManager);
	}
	
	public void dispose() {
		fPadManager.removeContainerManager(fContainerManager);
		
		fContainerManager.removeContainerManagerListener(fContainerManagerListener);
		fContainerManager = null;
		
		super.dispose();
	}
	
	public void createPad(Pad pad, int location) {
		fPadManager.createPad(pad, location, fContainerManager);	
	}
	
	public int getCaretOffset() {
		return getSourceViewer().getTextWidget().getCaretOffset();
	}
	
	public Object[] getElements() {
		return fContainerManager.getElements();
	}
	
	public Object getAdapter(Class adapter) {
		if (ContainerManager.class.equals(adapter))
			return fContainerManager;
		return super.getAdapter(adapter);
	}
}
