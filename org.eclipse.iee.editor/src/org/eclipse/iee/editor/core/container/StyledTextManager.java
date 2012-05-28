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

class StyledTextManager {
	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	private final ISourceViewer fSourceViewer;
	
	public StyledTextManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fSourceViewer = containerManager.getSourceViewer();
		fStyledText = fSourceViewer.getTextWidget();
		
		initListeners();
	}
	
	public void updatePresentation() {
		//fSourceViewer.invalidateTextPresentation();
	}
	
	protected void initListeners() {
		/* Moving StyledText's controls */		
		fStyledText.addPaintObjectListener(new PaintObjectListener() {
			public void paintObject(PaintObjectEvent e) {
				if (e.style.data instanceof Container) {
					System.out.println("paintObject()");
					Container c = (Container) e.style.data;
					c.updatePresentation();
				}
			}
		});
		
		/* Setting style ranges */
		((ITextViewerExtension4) fSourceViewer).addTextPresentationListener(new ITextPresentationListener() {			
			@Override
			public void applyTextPresentation(TextPresentation textPresentation) {
				
				System.out.println("applyTextPresentation()");
				
				//textPresentation.replaceStyleRanges(getContainersStyleRanges());
				textPresentation.mergeStyleRanges(getContainersStyleRanges());
			}
		});
	}
		
	
	/**
	 * Gets style ranges 
	 */
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
	


	
	/**
	 * Not used now
	 */
	protected int getMaxContainerHeightInLine(List<Container> containersInLine) {
		Iterator<Container> iterator = containersInLine.iterator();
		int maxHeight = 0;
		while (iterator.hasNext()) {
			Container c = iterator.next();
			int compositeHeigth = c.getComposite().getSize().y;
			if (maxHeight < compositeHeigth) {
				maxHeight = compositeHeigth;
			}
		}
		return maxHeight;
	}
	
	/**
	 * Not used now, may work with bugs 
	 */
	protected List<List<Container>> splitContainersByLines(List<Container> containers) {
		List<List<Container>> containersByLines =
			new ArrayList<List<Container>>();
		
		List<Container> currentLineContainers = new ArrayList<Container>();
		int currentLineNumber = 0; 
		
		for (Container c : containers) {
			if (currentLineNumber < c.getLineNumber()) {
				/* Moving to the next line */
				currentLineNumber = c.getLineNumber();
				
				if (!currentLineContainers.isEmpty()) {
					containersByLines.add(currentLineContainers);
					currentLineContainers.clear();
				}
			}
			currentLineContainers.add(c);
		}
		containersByLines.add(currentLineContainers);		
		return containersByLines;
	}
}
