package org.eclipse.iee.editor.sample;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.ui.editors.text.TextEditor;

public class SampleExtendedEditor extends TextEditor {
	
	public void createPartControl(org.eclipse.swt.widgets.Composite parent) {
		super.createPartControl(parent);
		
		initIeeEditorCore();
	};
	
	protected void initIeeEditorCore() {
		StyledText styledText = getSourceViewer().getTextWidget();
		IDocument document = getSourceViewer().getDocument();
		
		ContainerManager containerManager = new ContainerManager(document, styledText);
		
		PadManager padManager = IeeEditorPlugin.getDefault().getPadManager();
		padManager.registerContainerManager(containerManager);
	}
}
