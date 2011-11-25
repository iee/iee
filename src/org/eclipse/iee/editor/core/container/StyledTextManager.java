package org.eclipse.iee.editor.core.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.iee.editor.core.container.partitioning.PartitioningScanner;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ILineTracker;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
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
	
	protected void initListeners() {
		
		/* 1) Disallow modification within Container's text region */
		fStyledText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				if (fContainerManager.getContainerHavingOffset(e.start) != null ||
					fContainerManager.getContainerHavingOffset(e.end) != null)
				{
					e.doit = false;
				} else {
					fContainerManager.updateContainerVisibility(false);	
				}	
			}
		});

		fStyledText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				switch (event.keyCode) {
				case SWT.ARROW_LEFT:
					fCaretMovesForward = false;
					break;
				case SWT.ARROW_RIGHT:
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
					if (fCaretMovesForward) {
						fStyledText.setCaretOffset(p.getOffset() + p.getLength());
					} else {
						fStyledText.setCaretOffset(p.getOffset() - 1);
					}
				}
			}
		});

		fStyledText.addLineStyleListener(new LineStyleListener() {

			@Override
			public void lineGetStyle(LineStyleEvent event) {
				Collection<Container> containersAtLine =
					fContainerManager.getContainersInLine(
						event.lineOffset,
						event.lineText.length());
				
				if (containersAtLine.isEmpty()) {
					return;
				}
				
				Iterator<Container> iterator = containersAtLine.iterator();

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
				}
				

						if (containerIterator1.hasNext()) {
							Container c = (Container) containerIterator1.next();
							StyleRange compositeStyle = new StyleRange();
							compositeStyle.start = lineScanner.getTokenOffset();
							compositeStyle.length = 1;
							// to save constant line ascent (should be max from
							// all containers for a line)
							compositeStyle.metrics = new GlyphMetrics(
								c.getComposite().getSize().y,
								0,
								c.getComposite().getSize().x);
							styles.addElement(compositeStyle);

							StyleRange hiddenTextStyle = new StyleRange();
							hiddenTextStyle.start = lineScanner.getTokenOffset() + 1;
							hiddenTextStyle.length = lineScanner.getTokenLength();
							hiddenTextStyle.metrics = new GlyphMetrics(0, 0, 0);
							styles.addElement(hiddenTextStyle);


				Iterator<Container> containerIterator2 =
					fContainerManager.getContainersAtLine(lineNumber).iterator();
				
				fContainerManager.clearLineMaxAscents();
				while (containerIterator2.hasNext()) {
					Container c = (Container) containerIterator2.next();
					// System.out.println("PadSize:"
					// + c.getComposite().getSize().y);
					if (c.getComposite().getSize().y > fContainerManager.getMaxContainerAscentByLine(lineNumber)) {
						fContainerManager.putMaxContainerAscentToMap(lineNumber, c.getComposite().getSize().y);
					}
				}

				Iterator<StyleRange> stylesIterator = styles.iterator();
				// Second cycle - Setting max ascent for styles
				while (stylesIterator.hasNext()) {
					StyleRange style = (StyleRange) stylesIterator.next();
					// System.out.println("MaxPadSize:"
					// + getMaxContainerAscentByLine(lineNumber));
					if (style.metrics != null)
						style.metrics.ascent = fContainerManager.getMaxContainerAscentByLine(lineNumber);
					style.background = fStyledText.getBackground();
				}

				event.styles = new StyleRange[styles.size()];
				styles.copyInto(event.styles);
			}
		});
	}
}
