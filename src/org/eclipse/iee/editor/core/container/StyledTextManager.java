package org.eclipse.iee.editor.core.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.jface.text.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.GlyphMetrics;

class StyledTextManager {
	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	
	private Boolean fCaretMovesForward;
	
	public StyledTextManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fStyledText = containerManager.getStyledText();
		
		fCaretMovesForward = false;
		
		initListeners();
	}
	
	public void updateStyledText() {
		fStyledText.update();
	}
	
	protected void initListeners() {
		
		/* 1) Disallow modification within Container's text region */
		fStyledText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				Container atStart = fContainerManager.getContainerHavingOffset(e.start);
				Container atEnd = fContainerManager.getContainerHavingOffset(e.end);		
				
				System.out.println(e.start + " " + e.end);
								
				/* Text replaced */
				if ((atStart != null && e.start != atStart.getPosition().getOffset()) ||
						(atEnd != null && e.end != atEnd.getPosition().getOffset()))
				{
					e.doit = false;
					return;
				}

				fContainerManager.updateContainerVisibility(false);
			}
		});

		fStyledText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				switch (event.keyCode) {
				case SWT.ARROW_LEFT:
				case SWT.ARROW_UP:
					fCaretMovesForward = false;
					break;
				case SWT.ARROW_RIGHT:
				case SWT.ARROW_DOWN:
					fCaretMovesForward = true;
					break;
				}
			}
		});
		
		/*
		 * If caret is inside Container's text region, moving it to the
		 * beginning of line
		 */
		fStyledText.addCaretListener(new CaretListener() {
			@Override
			public void caretMoved(CaretEvent e) {
				Container c = fContainerManager.getContainerHavingOffset(e.caretOffset);
				if (c != null) {
					Position p = c.getPosition();
					
					if (e.caretOffset == p.getOffset() || e.caretOffset == p.getOffset() + p.getLength()) {
						return;
					}
					
					if (fCaretMovesForward) {
						fStyledText.setCaretOffset(p.getOffset() + p.getLength());
					} else {
						fStyledText.setCaretOffset(p.getOffset());
					}
				}
			}
		});

		fStyledText.addLineStyleListener(new LineStyleListener() {

			@Override
			public void lineGetStyle(LineStyleEvent event) {
				System.out.println("lineGetStyle");
				
				Vector<StyleRange> styles = new Vector<StyleRange>();
				
				Collection<Container> containersAtLine =
					fContainerManager.getContainersInLine(
						event.lineOffset,
						event.lineText.length());
				
				if (containersAtLine.isEmpty()) {
					return;
				}
				
				Iterator<Container> iterator = containersAtLine.iterator();

				/* Select max height in line */
				int maxHeight = 0;
				while (iterator.hasNext()) {
					Container c = iterator.next();
					int compositeHeigth = c.getComposite().getSize().y;
					if (maxHeight < compositeHeigth) {
						maxHeight = compositeHeigth;
					}	
				}
				
				iterator = containersAtLine.iterator();
				while (iterator.hasNext()) {
					Container c = iterator.next();
					Position p = c.getPosition();

					/* First symbol is shaped by container's geometry */
					StyleRange firstSymbol = new StyleRange();
					firstSymbol.start = p.getOffset();
					firstSymbol.length = 1;
					firstSymbol.metrics = new GlyphMetrics(
						0,
						c.getComposite().getSize().y,
						c.getComposite().getSize().x);
					
					/* XXX setting data */
					firstSymbol.data = c;
					
					styles.add(firstSymbol);

					/* Other symbols in container's text region becomes invisible */
					StyleRange hiddenText = new StyleRange();
					hiddenText.start = p.getOffset() + 1;
					hiddenText.length = p.getLength() - 1;
					hiddenText.metrics = new GlyphMetrics(0, 0, 0);
					
					styles.addElement(hiddenText);
				}

				event.styles = new StyleRange[styles.size()];
				styles.copyInto(event.styles);
			}
		});

		fStyledText.addPaintObjectListener(new PaintObjectListener() {
			public void paintObject(PaintObjectEvent e) {
				if (e.style.data instanceof Container) {
					Container c = (Container) e.style.data;
					c.updatePresentation();
				}
			}
		});
	}
}
