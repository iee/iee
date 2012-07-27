package org.eclipse.iee.editor.core.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.ITextViewerExtension4;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;


class StyledTextManager {
	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	private final ISourceViewer fSourceViewer;
	
	private PaintObjectListener fPaintObjectListener;
	
	private boolean fAreStylesUpdated = true;
	private boolean fArePresentationsUpdated = true;
		
	public StyledTextManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fSourceViewer = containerManager.getSourceViewer();
		fStyledText = fSourceViewer.getTextWidget();
		
		initListeners();
	}
		
	public void updateStyles(boolean doInitiateTextPresentationUpdate) {

		System.out.println("updateStyles()");
		
//		if (fAreStylesUpdated == false || fArePresentationsUpdated == false) {
//			return;
//		}
		
		fAreStylesUpdated = false;
		fArePresentationsUpdated = false;
		
		//fStyledText.addPaintObjectListener(fPaintObjectListener);
		
		if (doInitiateTextPresentationUpdate) { // Now used when container is resized
			fSourceViewer.invalidateTextPresentation();
		}
	}
	
	protected void initListeners() {
		
		((ITextViewerExtension4) fSourceViewer).addTextPresentationListener(new ITextPresentationListener() {			
			@Override
			public void applyTextPresentation(TextPresentation textPresentation) {

				StopWatch stylesUpdateSW = new LoggingStopWatch("stylesUpdateSW");
				
				System.out.println("Applying styles");
								
				if (!fAreStylesUpdated) {
					/* Исправление непонятного бага.
					 * При первом вызове applyTextPresentation() почему-то не передаются стили jdt,
					 * поэтому выставляем те стили, которые уже имеются (может вызывать другие косяки на ~ 1 секунду) */
					textPresentation.mergeStyleRanges(fStyledText.getStyleRanges());
				}
								
				//printTextPresentationStyleRanges(textPresentation);
				
				injectStylesToTextPresentation(textPresentation, getContainersStyleRanges());
				fAreStylesUpdated = true;
												
				stylesUpdateSW.stop();

			}
		});
		
		fPaintObjectListener = new PaintObjectListener() {
			public void paintObject(PaintObjectEvent e) {
				
				System.out.print("| ");
				
				
				if (!fAreStylesUpdated) {
					fSourceViewer.invalidateTextPresentation();
				}
				
				if (!fArePresentationsUpdated) { 
					
					StopWatch updatePresentationSW = new LoggingStopWatch("updatePresentationSW");	
					
					System.out.println("Updating presentations");
					for (Container c : fContainerManager.getContainers()) {
						c.updatePresentation();
					}
					
					if (fAreStylesUpdated) {
						fArePresentationsUpdated = true;
						
						//fStyledText.removePaintObjectListener(fPaintObjectListener);
					}
					
					updatePresentationSW.stop();	
				}
			}
		};
		
		fStyledText.addPaintObjectListener(fPaintObjectListener);
	}
	
	protected void injectStylesToTextPresentation(TextPresentation tp, StyleRange[] containersStyleRanges) {
		
		List<StyleRange> allowedStyleRanges = new ArrayList<StyleRange>();
		
		Iterator it = tp.getAllStyleRangeIterator();
		while (it.hasNext()) {
			StyleRange styleRange = (StyleRange) it.next();
			
			boolean overlap = false;
			for (StyleRange containersStyleRange : containersStyleRanges) {
				if (doStyleRangesOverlap(styleRange, containersStyleRange)) {
					overlap = true;
					break;
				}
			}
			
			if (!overlap) {		
				allowedStyleRanges.add(styleRange);
			}
		}
		
		/* Convert to array */
		StyleRange[] allowedStyleRangesArray = new StyleRange[allowedStyleRanges.size()];
		for (int i = 0; i < allowedStyleRanges.size(); i++) {
			allowedStyleRangesArray[i] = allowedStyleRanges.get(i);
		}
		
		StyleRange defaultStyleRange = tp.getDefaultStyleRange();
		
		tp.clear();
		tp.setDefaultStyleRange(defaultStyleRange);		
		tp.mergeStyleRanges(allowedStyleRangesArray);
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
		
	protected StyleRange[] getContainersStyleRanges() {	
		
		List<StyleRange> styleRanges = new ArrayList<StyleRange>();
		for (Container c : fContainerManager.getContainers()) {
			styleRanges.addAll(getContainerStyles(c));
		}

		StyleRange[] rangeArray = new StyleRange[styleRanges.size()];
		for (int i = 0; i < styleRanges.size(); i++) {
			rangeArray[i] = styleRanges.get(i);
		}
				
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
