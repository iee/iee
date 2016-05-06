package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.core.IHasPropertyChangeListener;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.IView;
import org.eclipse.iee.editor.core.container.TextRenderCtx;

import com.google.common.base.Preconditions;

public class WrapperEditor<T extends IHasPropertyChangeListener> extends AbstractVisualTextEditor<T> {

	protected TextPartEditor fTextPartEditor;
	
	private ObservableProperty<String> fValue;

	private String fProperty;

	private IFigure fFigure;

	public WrapperEditor(String property, TextRenderCtx renderCtx) {
		this.fProperty = Preconditions.checkNotNull(property);
		fTextPartEditor = new TextPartEditor(renderCtx);
		addEditor(fTextPartEditor);
	}
	
	@Override
	public boolean isSelectable() {
		return true;
	}

	@Override
	public void setSelected(boolean selected) {
	}

	@Override
	public void setActive(boolean b) {
	}

	protected IFigure createFigure() {
		Figure figure = new Figure();
		figure.setLayoutManager(new FlowLayout(true));
		figure.add(fTextPartEditor.getFigure());
		return figure;
	}
	
	@Override
	protected void doBindValue(T value) {
		fValue = new ObservableProperty<String>(value, fProperty, String.class);
		fTextPartEditor.bindValue(fValue);
	}
	
	@Override
	protected void doUnbindValue(T oldValue) {
		fValue.dispose();
	}

	@Override
	protected IView createView() {
		return new FigureView(getFigure());
	}

	public IFigure getFigure() {
		if (fFigure == null) {
			fFigure = createFigure();
		}
		return fFigure;
	}

}
