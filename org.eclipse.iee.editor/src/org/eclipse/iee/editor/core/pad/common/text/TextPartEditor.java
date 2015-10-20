package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;

public class TextPartEditor extends AbstractTextEditor<String, FlowPage> {

	private TextFlow fTextFlow;

	private Document fText;

	private FlowPage fFlowPage;

	private RenderCtx fRenderCtx;
	
	public TextPartEditor() {
		fText = new Document();
	}
	
	public TextPartEditor(RenderCtx renderCtx) {
		fText = new Document();
		this.fRenderCtx = renderCtx;
	}

	protected FlowPage createFigure() {
		fFlowPage = new FlowPage() {
			@Override
			public Dimension getPreferredSize(int width, int h) {
				super.getPreferredSize(width, h);
				TextFlow object = (TextFlow) getChildren().get(0);
				return object.getPreferredSize(width, h);
			}
		};
		fTextFlow = new TextFlow(fText.get());
		fTextFlow.setFont(fRenderCtx.getFont());
		fTextFlow.setLayoutManager(new ParagraphTextLayout(fTextFlow, ParagraphTextLayout.WORD_WRAP_SOFT));
		fFlowPage.add(fTextFlow);
		
		fFlowPage.setRequestFocusEnabled(true);
	
		fFlowPage.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent fe) {
				fTextFlow.setText(fText.get());
			}

			public void focusLost(FocusEvent fe) {
				fText.set(fTextFlow.getText());
			}});
		fText.addDocumentListener(new IDocumentListener() {
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
			}

			@Override
			public void documentChanged(DocumentEvent event) {
				String s = event.getDocument().get();
				fTextFlow.setText(getVisibleText(s));
				if (getValue().isPresent() && !s.equals(getValue().get().getValue())) {
					getValue().get().setValue(s);
				}
//				fFlowPage.revalidate();
			}

		});
		fTextFlow.setText(getVisibleText(getModel()));
		
		return fFlowPage;
	}
	
	private String getVisibleText(String s) {
		if (!Strings.isNullOrEmpty(s)) {
			return s;
		} else {
			return "\u25a1";
		}
	}
	
	public void setText(String text) {
		fText.set(text);
	}
	
	public String getText(String text) {
		return fText.get();
	}
	
	public void addDocumentListener(IDocumentListener listener) {
		fText.addDocumentListener(listener);
	}
	
	public void updateCaret(final Caret caret,
			final int offset, final boolean b) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				CaretInfo caretPlacement = fTextFlow.getCaretPlacement(offset, b);
				caret.setVisible(true);
				caret.setSize(1, caretPlacement.getHeight());
				caret.setLocation(caretPlacement.getX(), caretPlacement.getY());					}
		});
	}
	
	public CaretInfo getCaretInfo(final int offset, final boolean b) {
		return fTextFlow.getCaretPlacement(offset, b);
	}

	public Optional<TextLocation> getTextLocation(int x, int y) {
		int[] trailing = new int[1];
		Point location = new Point(x, y);
		fFlowPage.translateFromParent(location);
		final int offset = fTextFlow.getOffset(location, trailing, null);
		return Optional.<TextLocation> of(new OffsetTextLocation(this, offset));
	}

	public int getLength() {
		return fText.getLength();
	}

	public Optional<TextLocation> getStart() {
		return Optional.<TextLocation> of(new OffsetTextLocation(this, 0));
	}

	@Override
	public Optional<TextLocation> getEnd() {
		return Optional.<TextLocation> of(new OffsetTextLocation(this, getLength() - 1));
	}

	public void replace(int start, int end, String text) {
		try {
			fText.replace(start, end - start, text);
		} catch (BadLocationException e) {
			throw Throwables.propagate(e);
		}
	}

	@Override
	public void setSelected(boolean b) {
	}

	@Override
	public void setActive(boolean b) {
	}

	@Override
	public boolean isSelectable() {
		return false;
	}
	
	public void bindValue(IObservableValue<String> value) {
		setValue(Optional.of(value));
	}
	
	@Override
	protected void onValueChanged(String oldValue, String newValue) {
		fText.set(newValue);
	}
	
	@Override
	public void selectBetween(TextLocation start, TextLocation end) {
		if (start.getEditor() == this  && end.getEditor() == this) {
			fTextFlow.setSelection(start.getOffset(), end.getOffset());
		} else if (start.getEditor() == this) {
			fTextFlow.setSelection(start.getOffset(), fTextFlow.getText().length());
		} else if (end.getEditor() == this) {
			fTextFlow.setSelection(0, end.getOffset());
		} else {
			fTextFlow.setSelection(0, fTextFlow.getText().length());
		}
	}
	
	@Override
	public void unselectBetween(TextLocation start, TextLocation end) {
		fTextFlow.setSelection(-1, -1);
	}
	
}
