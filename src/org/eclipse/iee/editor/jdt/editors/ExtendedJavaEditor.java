package org.eclipse.iee.editor.jdt.editors;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.custom.StyledText;

@SuppressWarnings("restriction")
public class ExtendedJavaEditor extends CompilationUnitEditor {
	
	ContainerManager fContainerManager;
	
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
	
	public void addPad(Pad pad) {
		
	}
	
	public void removePad(Pad pad) {
		
	}
}
