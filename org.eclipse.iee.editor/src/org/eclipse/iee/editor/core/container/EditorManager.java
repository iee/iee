package org.eclipse.iee.editor.core.container;

import java.util.Map;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.iee.editor.core.container.ITextEditor;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;

public class EditorManager {

	private IFigure fMainFigure;

	private IFigure fFeedbackFigure;
	
	private Figure fRoot;
	
	private ITextEditor<?, ?> fSelectedEditor;

	private ITextEditor<?, ?> fActiveEditor;
	
	private Map<IFigure, ITextEditor<?, ?>> fFigureToEditor = Maps.newHashMap();
	
	public EditorManager() {

	}
	
	public Figure getRoot() {
		if (fRoot == null) {
			fRoot = new Figure();
			fRoot.setLayoutManager(new StackLayout());
			
			fMainFigure = createMainFigure();
			fRoot.add(fMainFigure);
			
			fFeedbackFigure = createFeedbackFigure();
			fRoot.add(fFeedbackFigure);	
		}
		return fRoot;
	}
	
	protected IFigure createMainFigure() {
		Figure result = new Figure();
		result.setLayoutManager(new XYLayout());
		result.setOpaque(false);
		return result;
	}

	protected IFigure createFeedbackFigure() {
		Figure result = new Figure();
		result.setLayoutManager(new XYLayout());
		result.setOpaque(false);
		result.setEnabled(false);
		return result;
	}
	
	public Optional<ITextEditor<?, ?>> getEditorAt(org.eclipse.draw2d.geometry.Point p) {
		IFigure findFigureAt = fMainFigure.findFigureAt(p);
		ITextEditor<?, ?> editor = null;
		while (findFigureAt != null) {
			editor = fFigureToEditor.get(findFigureAt);
			if (editor != null) {
				break;
			}
			findFigureAt = findFigureAt.getParent();
		}
		
		return Optional.<ITextEditor<?, ?>> fromNullable(editor);
	}

	public void selectEditor(ITextEditor<?, ?> editor) {
		if (editor != null && editor.equals(fSelectedEditor)) {
			return;
		}
		
		if (fSelectedEditor != null) {
			fSelectedEditor.setSelected(false);
		}
		fSelectedEditor = editor;
		if (fSelectedEditor != null) {
			fSelectedEditor.setSelected(true);
		}
	}

	public void activateEditor(ITextEditor<?, ?> editor) {
		if (editor != null && editor.equals(fActiveEditor)) {
			return;
		}
		if (fActiveEditor != null) {
			fActiveEditor.setActive(false);
		}
		fActiveEditor = editor;
		if (fActiveEditor != null) {
			fActiveEditor.setActive(true);
		}
		selectEditor(editor);	
	}
	
	public void registerVisual(ITextEditor<?, ?> textPartEditor, IFigure figure) {
		fFigureToEditor.put(figure, textPartEditor);
	}
	
	public void unregisterVisual(IFigure figure) {
		fFigureToEditor.remove(figure);
	}

	public ITextEditor<?, ?> getSelectedEditor() {
		return fSelectedEditor;
	}

	public boolean isEditorSelected() {
		return fSelectedEditor != null;
	}
	
	public IFigure getMainFigure() {
		return fMainFigure;
	}

	public IFigure getFeedbackFigure() {
		return fFeedbackFigure;
	}
	
	public void addEditor(ITextEditor<?, ?> editor) {
		editor.attach(this);
	}

	public void removeEditor(ITextEditor<?, ?> editor) {
		editor.detach(this);
	}
	
}
