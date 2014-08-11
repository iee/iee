package org.eclipse.iee.pad.graph.ui;

import org.eclipse.draw2d.FocusBorder;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.BlockFlow;
import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Throwables;

public class TextFigure extends FlowPage {

	private FlowPage fFormulaText;
	private Document fFormula;
	private TextFlow fTextFlow;
	
	public TextFigure(final Caret caret) {
		fFormula = new Document();
		BlockFlow blockFlow = new BlockFlow();
		fTextFlow = new TextFlow(fFormula.get());
		fTextFlow.setLayoutManager(new ParagraphTextLayout(fTextFlow, ParagraphTextLayout.WORD_WRAP_SOFT));
		blockFlow.add(fTextFlow);
		add(blockFlow);
		
		addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent me) {
				int[] trailing = new int[1];
				Point location = me.getLocation();
				translateFromParent(location);
				int offset = fTextFlow.getOffset(location, trailing, null);
				updateCaret(fTextFlow, caret, offset, trailing[0] == 1);
				requestFocus();
			}

			public void mouseReleased(MouseEvent me) {
				// TODO Auto-generated method stub
				
			}

			public void mouseDoubleClicked(MouseEvent me) {
				// TODO Auto-generated method stub
				
			}});
		
		setRequestFocusEnabled(true);
	
		addKeyListener(new org.eclipse.draw2d.KeyListener () {

			public void keyPressed(org.eclipse.draw2d.KeyEvent ke) {
				final int offset = fFormula.getLength() - 1;
				try {
					fFormula.replace(offset, 0, String.valueOf(ke.character));
				} catch (BadLocationException e) {
					throw Throwables.propagate(e);
				}
				updateCaret(fTextFlow, caret, offset, true);
				
			}

			public void keyReleased(org.eclipse.draw2d.KeyEvent ke) {
			}});
		
		addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent fe) {
				IFigure gainer = fe.gainer;
				gainer.setBorder(new FocusBorder());
			}

			public void focusLost(FocusEvent fe) {
				IFigure loser = fe.loser;
				loser.setBorder(null);
			}});
		fFormula.addDocumentListener(new IDocumentListener() {
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
			}

			@Override
			public void documentChanged(DocumentEvent event) {
				String s = event.getDocument().get();
				fTextFlow.setText(s);
				revalidate();
			}
		});
	}


	public void addDocumentListener(IDocumentListener listener) {
		fFormula.addDocumentListener(listener);
	}


	public String getText() {
		return fFormula.get();
	}


	public void setText(String text) {
		fFormula.set(text);
	}
	
	private static void updateCaret(final TextFlow textFlow, final Caret caret,
			final int offset, final boolean b) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				CaretInfo caretPlacement = textFlow.getCaretPlacement(offset, b);
				caret.setVisible(true);
				caret.setSize(1, caretPlacement.getHeight());
				caret.setLocation(caretPlacement.getX(), caretPlacement.getY());					}
		});
	}
	
}
