package org.eclipse.iee.pad.text.ui;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.EventBusSupport;
import org.eclipse.iee.core.document.text.IDocumentContent;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.ISpanContent;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;

import com.google.common.base.Optional;
import com.google.common.eventbus.Subscribe;

public class DocumentEditor extends AbstractVisualTextEditor<Document, FlowPage> {

	private TextRenderCtx fRenderCtx;

	public DocumentEditor(TextRenderCtx renderCtx) {
		fRenderCtx = renderCtx;
		EventBusSupport.getDefault().register(this);
	}

	@Override
	protected void doBindValue(Document value) {
		if (value.getChildren().size() == 0) {
			value.addChild(createEmptySpan());
		}
		for (IDocumentContent documentContent : value.getChildren()) {
			if (documentContent instanceof Span) {
				insertEmptyTexts((Span) documentContent);
			}
		}
		updateSpans(value);
	}
	
	protected void insertEmptyTexts(Span span) {
		for (ISpanContent spanContent : span.getChildren()) {
			if (spanContent instanceof Span) {
				if (((Span) spanContent).getChildren().size() == 0) {
					((Span) spanContent).addChild(new Span());
				}
			} else if (spanContent instanceof Text) {
				Text text = (Text) spanContent;
				TextEditor e = new TextEditor(fRenderCtx);
				e.setValue(Optional.of(DefaultObservableValue.fromValue(text)));
				addEditor(e);
				getFigure().add(e.getView().getWrapped(IFigure.class));	
			}
		}
	}

	private Span createEmptySpan() {
		Span span = new Span();
		span.addChild(new Text());
		return span;
	}

	@Subscribe
	public void onPropertyChange(PropertyChangeEvent event) {
		if ((event.getSource() == getModel() || isChildren(event.getSource())) && "children".equals(event.getPropertyName())) {
			updateSpans(getModel());
		}
	}
	
	private boolean isChildren(Object source) {
		if (source instanceof INode) {
			INode node = (INode) source;
			while (node != null) {
				if (node == getModel()) {
					return true;
				}
				node = node.getParent();
			}
		}
		return false;
	}

	protected void updateSpans(Document paragraph) {
		for (ITextEditor<?> expressionEditor : new ArrayList<>(getChildren())) {
			removeEditor(expressionEditor);
			expressionEditor.dispose();
		}
		getFigure().removeAll();
		for (IDocumentContent iParagraphContent : paragraph.getChildren()) {
			if (iParagraphContent instanceof Span) {
				updateSubSpan((Span) iParagraphContent);
			}
		}
	}
	
	protected void updateSubSpan(Span span) {
		for (ISpanContent spanContent : span.getChildren()) {
			if (spanContent instanceof Span) {
				updateSubSpan((Span) spanContent);
			} else if (spanContent instanceof Text) {
				Text text = (Text) spanContent;
				TextEditor e = new TextEditor(fRenderCtx);
				e.setValue(Optional.of(DefaultObservableValue.fromValue(text)));
				addEditor(e);
				getFigure().add(e.getView().getWrapped(IFigure.class));	
			}
		}
	}

	@Override
	public boolean isSelectable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActive(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected FlowPage createFigure() {
		return new FlowPage();
	}
	
}
