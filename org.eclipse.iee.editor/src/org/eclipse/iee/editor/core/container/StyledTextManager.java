package org.eclipse.iee.editor.core.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.ITextViewerExtension4;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.AnnotationPainter.ITextStyleStrategy;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GlyphMetrics;


class StyledTextManager {
	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	private final ISourceViewer fSourceViewer;
	
	//private PaintObjectListener fPaintObjectListener;

	public StyledTextManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fSourceViewer = containerManager.getSourceViewer();
		fStyledText = fSourceViewer.getTextWidget();
		
		initListeners();
	}
		
	public void updateStyles(Container container) {
		List<StyleRange> containerStyles = getContainerStyles(container);
		for (StyleRange styleRange : containerStyles) {
			fStyledText.setStyleRange(styleRange);
		}
	}
	
	protected void initListeners() {
		
		((ITextViewerExtension4) fSourceViewer).addTextPresentationListener(new ITextPresentationListener() {			
			@Override
			public void applyTextPresentation(TextPresentation textPresentation) {

				// XXX
				//StopWatch stylesUpdateSW = new LoggingStopWatch("stylesUpdateSW");
					
					injectStylesToTextPresentation(textPresentation, getContainersStyleRanges(textPresentation.getExtent()));

				// XXX
				//stylesUpdateSW.stop();
			}
		});
		
		fStyledText.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				
				// XXX
				//StopWatch updatePresentationSW = new LoggingStopWatch("updatePresentationSW");
				
				/*
				if (!fAreStylesUpdated) {
					fSourceViewer.invalidateTextPresentation();
					return; // ???
				}*/
				updateContainerPresentations();
				
				// XXX
				//updatePresentationSW.stop();
			}
		});

	}
	
	protected void updateContainerPresentations() {
		int topLineIndex = fSourceViewer.getTopIndex();
		if (topLineIndex > 0) {
			topLineIndex--;
		}
		
		int bottomLineIndex = fSourceViewer.getBottomIndex();
		if (bottomLineIndex < fStyledText.getLineCount() - 1) {
			bottomLineIndex++;
		}
						
		int topVisibleOffset = fStyledText.getOffsetAtLine(topLineIndex);
		int bottomVisibleOffset =
			fStyledText.getOffsetAtLine(bottomLineIndex) +
			fStyledText.getLine(bottomLineIndex).length();
						
		for (Container c : fContainerManager.getContainers()) {
			boolean isVisible = false;
			if (c.getPosition().getOffset() >= topVisibleOffset) {
				isVisible = true;
			}
			if (c.getPosition().getOffset() + c.getPosition().getLength() > bottomVisibleOffset) {
				isVisible = false;
			}
			c.setVisible(isVisible);
			if (isVisible) {
				c.updatePresentation();
			}
		}
	}
	
	protected void injectStylesToTextPresentation(TextPresentation tp, StyleRange[] containersStyleRanges) {
		
		tp.mergeStyleRanges(containersStyleRanges);		
	}
	
	protected boolean doStyleRangesOverlap(StyleRange a, StyleRange b) {
		
		if (a.start <= b.start) {
			if (b.start < a.start + a.length) {
				return true;
			}			
		}
		else {
			if (a.start < b.start + b.length) {
				return true;
			}
		}
		
		return false;
	}
	
	protected void printTextPresentationStyleRanges(TextPresentation tp) {
		System.out.println("\n== TextPresentation== ");
		Iterator it = tp.getAllStyleRangeIterator();
		while (it.hasNext()) {
			StyleRange styleRange = (StyleRange) it.next();
			System.out.println(styleRange);
		}
		System.out.println("\n");
	}
		
	protected StyleRange[] getContainersStyleRanges(IRegion region) {	
		
		List<StyleRange> styleRanges = new ArrayList<StyleRange>();
		for (Container c : fContainerManager.getContainers()) {
			Position position = c.getPosition();
			int regionEnd= region.getOffset() + region.getLength();
			int pEnd= position.getOffset() + position.getLength();
			if (pEnd >= region.getOffset() && regionEnd > position.getOffset()) {
				styleRanges.addAll(getContainerStyles(c));
			}
		}

		StyleRange[] rangeArray = (StyleRange[]) styleRanges.toArray(new StyleRange[styleRanges.size()]);
				
		return rangeArray;
	}	
	
	protected List<StyleRange> getContainerStyles(Container c) {
		List<StyleRange> styles = new ArrayList<StyleRange>();
		
		Position p = c.getPosition();

		int descent = // TODO: Quickly fix it!!!
			(c.getComposite().getSize().y < 10)
				? 0
				: c.getComposite().getSize().y - 10;

		/* First symbol is shaped by container's geometry */
		StyleRange firstSymbol = new StyleRange();
		firstSymbol.start = p.getOffset();
		firstSymbol.length = 1;
		firstSymbol.metrics = new GlyphMetrics(0, descent, c.getComposite().getSize().x);

		/* Setting data */
		firstSymbol.data = c;

		styles.add(firstSymbol);

		/* Other symbols in container's text region becomes invisible */
		StyleRange hiddenText = new StyleRange();
		hiddenText.start = p.getOffset() + 1;
		hiddenText.length = p.getLength() - 1;
		hiddenText.metrics = new GlyphMetrics(0, 0, 0);

		styles.add(hiddenText);
		
		return styles;
	}
	
}
