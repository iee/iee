package org.eclipse.iee.editor.core.container;

import java.util.Iterator;
import java.util.Vector;

import org.eclipse.iee.editor.core.container.partitioning.PartitioningScanner;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ILineTracker;
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
	
	private Boolean fDirection; 
	
	public StyledTextManager(ContainerManager containerManager, StyledText styledText) {
		fContainerManager = containerManager;
		fStyledText = styledText;
		
		fDirection = false;
		
		initListeners();
	}
	
	protected void initListeners() {
		
		fStyledText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				/* Disallow modification within Container's text region */
				if (fContainerManager.getContainerHavingOffset(e.start) != null ||
					fContainerManager.getContainerHavingOffset(e.end) != null)
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
					fDirection = false;
					break;
					
				case SWT.ARROW_RIGHT:
					fDirection = true;
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
				Container c = fContainerManager.anotherGetContainerHavingOffset(e.caretOffset);
				if (c != null
					&& e.caretOffset > c.getPosition().getOffset()
					&& e.caretOffset < c.getPosition().getOffset()
						+ c.getPosition().getLength()
						+ c.getContainerHiddenContent().length()) {
					if (fDirection) {
						// int len = c.getContainerHiddenContent().length();
						fStyledText.setCaretOffset(e.caretOffset + 1);
					} else
						fStyledText.setCaretOffset(e.caretOffset - 1);
				}
			}
		});

		fStyledText.addLineStyleListener(new LineStyleListener() {

			@Override
			public void lineGetStyle(LineStyleEvent event) {
				Vector<StyleRange> styles = new Vector<StyleRange>();
				PartitioningScanner lineScanner = new PartitioningScanner();
				lineScanner.setRange(
					fContainerManager.getDocument(),
					event.lineOffset,
					event.lineText.length());
				
				int lineNumber = 0;
				try {
					ILineTracker lineTracker = fContainerManager.getLineTracker();
					lineTracker.set(fContainerManager.getDocument().get());
					lineNumber = lineTracker.getLineNumberOfOffset(event.lineOffset) + 1;
				} catch (BadLocationException e) {
					e.printStackTrace();
				}

				Iterator<Container> containerIterator1 =
					fContainerManager.getContainersAtLine(lineNumber).iterator();
				
				IToken token;
				while (!(token = lineScanner.nextToken()).isEOF()) {
					if (token == PartitioningScanner.EMBEDDED_TOKEN) {
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
							hiddenTextStyle.start = lineScanner
									.getTokenOffset() + 1;
							hiddenTextStyle.length = lineScanner
									.getTokenLength();
							hiddenTextStyle.metrics = new GlyphMetrics(0, 0, 0);
							styles.addElement(hiddenTextStyle);
						}
					}
					if (token == PartitioningScanner.PLAINTEXT_TOKEN) {
						Container c = fContainerManager.getPreviousContainerAtLine(lineScanner.getTokenOffset());
						
						if (c == null || lineScanner.getTokenOffset() >= 
							c.getPosition().getOffset() +
							c.getPosition().getLength() +
							c.getContainerHiddenContent().length())
						{
							StyleRange plainTextStyle = new StyleRange(
								lineScanner.getTokenOffset(),
								lineScanner.getTokenLength(),
								fStyledText.getForeground(),
								fStyledText.getBackground());

							styles.addElement(plainTextStyle);
							
						} else {
							StyleRange hiddenContentStyle = new StyleRange();
							hiddenContentStyle.start = lineScanner.getTokenOffset();
							hiddenContentStyle.length = c.getContainerHiddenContent().length();
							hiddenContentStyle.metrics = new GlyphMetrics(0, 0,	0);
							
							styles.addElement(hiddenContentStyle);

							/*
							 * StyleRange plainTextStyle = new StyleRange(
							 * lineScanner.getTokenOffset() +
							 * c.getContainerHiddenContent() .length(),
							 * lineScanner .getTokenLength() -
							 * c.getContainerHiddenContent() .length(),
							 * fStyledText .getForeground(), fStyledText
							 * .getBackground());
							 * 
							 * styles.addElement(plainTextStyle);
							 */
						}
					}
				}

				Iterator<Container> containerIterator2 =
					fContainerManager.getContainersAtLine(lineNumber).iterator();

				// First cycle - looking for max ascent in containers
				// System.out
				// .println("Line offset:"
				// + event.lineOffset
				// +
				// "########################################################################");
				// System.out
				// .println("Line number:"
				// + lineNumber
				// +
				// "************************************************************************");
				// clear, because container can be moved to another line or
				// deleted
				
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
