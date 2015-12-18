package org.eclipse.iee.pad.text.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.iee.core.document.text.EventBusSupport;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.text.ITextContainer;
import org.eclipse.iee.editor.core.pad.common.text.OffsetEditorLocation;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;

public class TextEditor extends AbstractVisualTextEditor<Text, TextFlow> implements ITextContainer<Text> {

	private TextRenderCtx fRenderCtx;

	private PropertyChangeListener fStyleListener;

	private TextStyle fStyle;
	
	public TextEditor(TextRenderCtx renderCtx) {
		fRenderCtx = renderCtx;
		EventBusSupport.getDefault().register(this);
	}

	protected TextFlow createFigure() {
		TextFlow textFlow = new TextFlow();
		updateFont(textFlow, getStyle());
		updateBgColor(textFlow);
		updateFgColor(textFlow);
		textFlow.setLayoutManager(new ParagraphTextLayout(textFlow, ParagraphTextLayout.WORD_WRAP_SOFT));
		return textFlow;
	}

	private Optional<TextStyle> getStyle() {
		if (getModel() != null) {
			return Optional.<TextStyle> of(getModel().getStyle());
		} else {
			return Optional.<TextStyle> absent();
		}
	}
	
	private void updateFont(TextFlow textFlow, Optional<TextStyle> textStyle) {
		textFlow.setFont(fRenderCtx.getFont(textStyle));
	}
	
	private void updateFgColor(TextFlow textFlow) {
		Optional<org.eclipse.swt.graphics.Color> foreground = fRenderCtx.getForeground(getStyle());
		if (foreground.isPresent()) {
			textFlow.setForegroundColor(foreground.get());
		} 
	}

	private void updateBgColor(TextFlow textFlow) {
		Optional<org.eclipse.swt.graphics.Color> background = fRenderCtx.getBackground(getStyle());
		if (background.isPresent()) {
			textFlow.setForegroundColor(background.get());
		} 
	}
	
	private String getVisibleText(String s) {
		if (!Strings.isNullOrEmpty(s)) {
			return s;
		} else {
			return "\u25a1";
		}
	}
	
	public void updateCaret(final Caret caret, final int offset) {
		CaretInfo caretPlacement = getFigure().getCaretPlacement(offset, offset == getLength());
		caret.setVisible(true);
		caret.setSize(1, caretPlacement.getHeight());
		caret.setLocation(caretPlacement.getX(), caretPlacement.getY());
	}
	
	public CaretInfo getCaretInfo(final int offset, final boolean b) {
		return getFigure().getCaretPlacement(offset, b);
	}

	public Optional<IEditorLocation> getTextLocation(int x, int y) {
		int[] trailing = new int[1];
		Point location = new Point(x, y);
		final int offset = getFigure().getOffset(location, trailing, null);
		return Optional.<IEditorLocation> of(new OffsetEditorLocation(this, offset));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.editor.core.pad.common.text.ITextContainer#getLength()
	 */
	@Override
	public int getLength() {
		return getFigure().getText().length();
	}

	public Optional<IEditorLocation> getStart() {
		return Optional.<IEditorLocation> of(createLocation(0));
	}

	private OffsetEditorLocation createLocation(int offset) {
		return new OffsetEditorLocation(this, offset);
	}

	@Override
	public Optional<IEditorLocation> getEnd() {
		return Optional.<IEditorLocation> of(new OffsetEditorLocation(this, getLength() - 1));
	}
	
	@Override
	protected void doBindValue(Text value) {
		fStyleListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("bold".equals(evt.getPropertyName())
						|| "italic".equals(evt.getPropertyName())
						|| "font".equals(evt.getPropertyName())
						|| "fontSize".equals(evt.getPropertyName())) {
					updateFont(getFigure(), getStyle());
				}
				if ("fgColor".equals(evt.getPropertyName())) {
					updateFgColor(getFigure());
				}
				if ("bgColor".equals(evt.getPropertyName())) {
					updateBgColor(getFigure());
				}
			}

		};
		fStyle = value.getStyle();
		fStyle.addPropertyChangeListener(fStyleListener);
		updateValue(value.getText());
	}
	
	@Override
	protected void doUnbindValue(Text oldValue) {
		if (fStyle != null) {
			fStyle.removePropertyChangeListener(fStyleListener);
			fStyle = null;
		}
		updateValue("");
	}
	
	@Subscribe
	public void onPropertyChange(PropertyChangeEvent event) {
		if (event.getSource() == getModel() && "text".equals(event.getPropertyName())) {
			String value = (String) event.getNewValue();
			updateValue(value);
		}
	}

	private void updateValue(String value) {
		getFigure().setText(getVisibleText(value));
	}

	@Override
	public void selectBetween(IEditorLocation start, IEditorLocation end) {
		int startOffset = getStartOffset(start);
		int endOffset = getEndOffset(end);
		getFigure().setSelection(startOffset, endOffset);
	}
	
	private int getStartOffset(IEditorLocation start) {
		if (start.getEditor() == this) {
			return start.getOffset();
		}
		return 0;
	}
	
	private int getEndOffset(IEditorLocation end) {
		if (end.getEditor() == this) {
			return end.getOffset();
		}
		return getFigure().getText().length();
	}
	
	@Override
	public void unselectBetween(IEditorLocation start, IEditorLocation end) {
		getFigure().setSelection(-1, -1);
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
	
}
