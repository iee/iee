/**
 * 
 */
package org.eclipse.iee.editor.jdt.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.MultiPageEditorPart;

@SuppressWarnings("restriction")
public class TestJavaEditor extends MultiPageEditorPart {

	private CompilationUnitEditor editor;

	@Override
	protected void createPages() {
		
		try {
			int textIndex = addPage(new TextEditor(), getEditorInput());
			setPageText(textIndex, "Text");
			editor = new CompilationUnitEditor();
			int javaIndex = addPage(editor, getEditorInput());
			setPageText(javaIndex, "Java");
			int ieeIndex = addPage(new ExtendedJavaEditor(), getEditorInput());
			setPageText(ieeIndex, "IEE");
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		editor.doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		editor.doSaveAs();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return editor.isSaveAsAllowed();
	}

}
