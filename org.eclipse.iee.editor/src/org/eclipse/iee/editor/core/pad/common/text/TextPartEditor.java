package org.eclipse.iee.editor.core.pad.common.text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.FocusBorder;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.BlockFlow;
import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;

public class TextPartEditor<T extends DocumentPart> extends AbstractTextEditor<T> implements IContentTextPart {

	private TextFlow fTextFlow;

	private Document fText;

	private FlowPage fFlowPage;
	
	private ITextAdapter<T> fAdapter;

	private PropertyChangeListener fListener;
	
	public TextPartEditor(T model, ITextAdapter<T> adapter) {
		super(model);
		fAdapter = adapter;
		fText = new Document(fAdapter.getText(model));
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("value".equals(evt.getPropertyName())) {
					fText.set((String) evt.getNewValue());
				}
			}
		};
		model.addPropertyChangeListener(fListener);
	}
	
	public IFigure createFigure() {
		fFlowPage = new FlowPage();
		BlockFlow blockFlow = new BlockFlow();
		fTextFlow = new TextFlow(fText.get());
		fTextFlow.setLayoutManager(new ParagraphTextLayout(fTextFlow, ParagraphTextLayout.WORD_WRAP_SOFT));
		blockFlow.add(fTextFlow);
		fFlowPage.add(blockFlow);
		
		fFlowPage.setRequestFocusEnabled(true);
	
		fFlowPage.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent fe) {
				IFigure gainer = fe.gainer;
				gainer.setBorder(new FocusBorder());
			}

			public void focusLost(FocusEvent fe) {
				IFigure loser = fe.loser;
				loser.setBorder(null);
				fAdapter.setText(getModel(), fText.get());
			}});
		fText.addDocumentListener(new IDocumentListener() {
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
			}

			@Override
			public void documentChanged(DocumentEvent event) {
				String s = event.getDocument().get();
				if (!Strings.isNullOrEmpty(s)) {
					fTextFlow.setText(s);
				} else {
					fTextFlow.setText("\u25a1");
				}
//				fFlowPage.revalidate();
			}
		});
		
		return fFlowPage;
	}
	
	public void setText(String text) {
		fText.set(text);
	}
	
	public String getText(String text) {
		return fText.get();
	}
	
	public void acceptCaret(Caret caret, TextLocation textLocation) {
		int position = textLocation.getPosition();
		updateCaret(caret, position, position == fText.getLength());
		fFlowPage.requestFocus();
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

	public TextLocation getTextLocation(int x, int y) {
		int[] trailing = new int[1];
		Point location = new Point(x, y);
		fFlowPage.translateFromParent(location);
		final int offset = fTextFlow.getOffset(location, trailing, null);
		return new OffsetTextLocation(this, offset);
	}

	@Override
	public int getLength() {
		return fText.getLength();
	}

	@Override
	public TextLocation getStart() {
		return new OffsetTextLocation(this, 0);
	}

	@Override
	public TextLocation getEnd() {
		return new OffsetTextLocation(this, getLength() - 1);
	}

	@Override
	public Optional<ICompositeTextPart> getParentTextPart() {
		return Optional.absent() ;
	}

	@Override
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
		return true;
	}

}