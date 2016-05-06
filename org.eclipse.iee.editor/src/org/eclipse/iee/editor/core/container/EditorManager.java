package org.eclipse.iee.editor.core.container;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.iee.core.document.text.INode;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class EditorManager {

	private IFigure fMainFigure;

	private IFigure fFeedbackFigure;
	
	private Figure fRoot;
	
	private Pane fFxMainFigure;

	private Pane fFxFeedbackFigure;
	
	private Parent fFxRoot;
	
	private ITextEditor<?> fSelectedEditor;

	private ITextEditor<?> fActiveEditor;
	
	private Map<IView, ITextEditor<?>> fFigureToEditor = Maps.newHashMap();
	
	private Map<Object, ITextEditor<?>> fModelToEditor = Maps.newHashMap();
	
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
	
	public Parent getFxRoot() {
		if (fFxRoot == null) {
			StackPane stackPane = new StackPane();
			stackPane.setStyle("-fx-background-color: transparent;");
			
			fFxMainFigure = createFxMainFigure();
			fFxMainFigure.setStyle("-fx-background-color: transparent;");
			stackPane.getChildren().add(fFxMainFigure);
			
			fFxFeedbackFigure = createFxFeedbackFigure();
			fFxFeedbackFigure.setStyle("-fx-background-color: transparent;");
			stackPane.getChildren().add(fFxFeedbackFigure);
			
			fFxRoot = stackPane;
		}
		return fFxRoot;
	}
	
	protected Pane createFxMainFigure() {
		Pane result = new Pane();
		result.setStyle("-fx-background-color: transparent;");
		return result;
	}

	protected Pane createFxFeedbackFigure() {
		Pane result = new Pane();
		result.setStyle("-fx-background-color: transparent;");
		return result;
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
	
	public Optional<ITextEditor<?>> getEditorAt(org.eclipse.draw2d.geometry.Point p) {
		
		for (Entry<IView, ITextEditor<?>> entry : fFigureToEditor.entrySet()) {
			if (entry.getKey().getBounds().contains(p.x, p.y)) {
				return Optional.<ITextEditor<?>> fromNullable(entry.getValue());
			}
		}
		return Optional.absent();
	}

	public void selectEditor(ITextEditor<?> editor) {
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

	public void activateEditor(ITextEditor<?> editor) {
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
	
	public void registerVisual(ITextEditor<?> textPartEditor, IView view) {
		fFigureToEditor.put(view, textPartEditor);
	}
	
	public void unregisterVisual(IView view) {
		fFigureToEditor.remove(view.getWrapped(IFigure.class));
	}

	public ITextEditor<?> getSelectedEditor() {
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
	
	public Pane getFxMainFigure() {
		return fFxMainFigure;
	}
	
	public void addEditor(ITextEditor<?> editor) {
		editor.attach(this);
	}

	public void removeEditor(ITextEditor<?> editor) {
		editor.detach(this);
	}

	public ITextEditor<?> getEditorByModel(INode model) {
		return fModelToEditor.get(model);
	}
	
	public void registerModel(Object model, ITextEditor<?> editor) {
		fModelToEditor.put(model, editor);
	}
	
	public void unregisterModel(Object model) {
		fModelToEditor.remove(model);
	}	

}
