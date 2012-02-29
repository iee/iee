package org.eclipse.iee.editor.core.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.jface.text.Position;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.GlyphMetrics;

class StyledTextManager {
	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	
	public StyledTextManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fStyledText = containerManager.getStyledText();
		
		initListeners();
	}
	
	public void updateStyledText() {
		fStyledText.update();
	}
		
	protected void initListeners() {

		fStyledText.addLineStyleListener(new LineStyleListener() {

			@Override
			public void lineGetStyle(LineStyleEvent event) {				
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

					int descent = // TODO: Quickly fix it!!!
						(c.getComposite().getSize().y < 10)
						? 0
						: c.getComposite().getSize().y - 10;
					
					/* First symbol is shaped by container's geometry */
					StyleRange firstSymbol = new StyleRange();
					firstSymbol.start = p.getOffset();
					firstSymbol.length = 1;
					firstSymbol.metrics = new GlyphMetrics(
						0,
						descent,
						c.getComposite().getSize().x);

					/* Setting data */
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
