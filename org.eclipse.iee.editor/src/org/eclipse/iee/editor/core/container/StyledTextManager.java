package org.eclipse.iee.editor.core.container;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.ITextViewerExtension4;
import org.eclipse.jface.text.JFaceTextUtil;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;

public class StyledTextManager {

	private static final Logger logger = LoggerFactory
			.getLogger(StyledTextManager.class);

	/** left pad margin is necessary to show carret */
	public static final int PAD_LEFT_MARGIN = 2;

	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	private final ISourceViewer fSourceViewer;

	// private PaintObjectListener fPaintObjectListener;

	public StyledTextManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fSourceViewer = containerManager.getSourceViewer();
		fStyledText = fSourceViewer.getTextWidget();

		initListeners();
	}

	protected void initListeners() {

		((ITextViewerExtension4) fSourceViewer)
				.addTextPresentationListener(new ITextPresentationListener() {
					@Override
					public void applyTextPresentation(
							TextPresentation textPresentation) {

						IRegion changedRegion = textPresentation.getExtent();

						logger.debug("applyTextPresentation start "
								+ changedRegion);

						injectStylesToTextPresentation(textPresentation,
								getContainersStyleRanges(changedRegion));

					}
				});
		fStyledText.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				logger.debug("paintControl start " + e);
				updateContainerPresentations();
			}
		});

	}

	public void updateContainerPresentations() {
		int topLineIndex = JFaceTextUtil.getPartialTopIndex(fStyledText);

		int bottomLineIndex = JFaceTextUtil.getPartialBottomIndex(fStyledText);
		
		for (Container c : fContainerManager.getContainers()) {
			int offset = c.getPosition().getOffset();
			int line;
			try {
				line = fSourceViewer.getDocument().getLineOfOffset(offset);
			} catch (BadLocationException e) {
				throw Throwables.propagate(e);
			}
			int widgetLine = JFaceTextUtil.modelLineToWidgetLine(fSourceViewer, line);
			boolean isVisible = widgetLine != -1 && widgetLine >= topLineIndex && widgetLine <= bottomLineIndex;
			c.setVisible(isVisible);
			if (isVisible) {
				c.updatePresentation();
			}
		}
	}

	protected void injectStylesToTextPresentation(TextPresentation tp,
			StyleRange[] containersStyleRanges) {
		tp.mergeStyleRanges(containersStyleRanges);
	}

	protected StyleRange[] getContainersStyleRanges(IRegion region) {

		List<StyleRange> styleRanges = new ArrayList<StyleRange>();
		for (Container c : fContainerManager.getContainers()) {
			Position position = c.getPosition();
			int regionEnd = region.getOffset() + region.getLength();
			int pEnd = position.getOffset() + position.getLength();
			if (pEnd >= region.getOffset() && regionEnd > position.getOffset()) {
				styleRanges.addAll(getContainerStyles(c));
			}
		}

		StyleRange[] rangeArray = (StyleRange[]) styleRanges
				.toArray(new StyleRange[styleRanges.size()]);

		return rangeArray;
	}

	protected List<StyleRange> getContainerStyles(Container c) {
		List<StyleRange> styles = new ArrayList<StyleRange>();

		Position p = c.getPosition();

		int descent = // TODO: Quickly fix it!!!
		(c.getBounds().height < 10) ? 0
				: c.getBounds().height - 10;

		/* First symbol is shaped by container's geometry */
		StyleRange firstSymbol = new StyleRange();
		firstSymbol.start = p.getOffset();
		firstSymbol.length = 1;
		firstSymbol.metrics = new GlyphMetrics(0, descent, c.getBounds().width + PAD_LEFT_MARGIN);

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
