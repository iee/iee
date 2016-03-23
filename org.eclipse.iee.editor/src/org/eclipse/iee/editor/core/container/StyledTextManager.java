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

						System.out.println("applyTextPresentation start " + changedRegion);

						injectStylesToTextPresentation(textPresentation, getContainersStyleRanges(changedRegion));

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
				c.updatePosition();
			}
		}
	}

	protected void injectStylesToTextPresentation(TextPresentation tp,
			StyleRange[] containersStyleRanges) {
		tp.replaceStyleRanges(containersStyleRanges);
	}

	protected StyleRange[] getContainersStyleRanges(IRegion region) {

		List<StyleRange> styleRanges = new ArrayList<StyleRange>();
		for (Container c : fContainerManager.getContainers()) {
			Position position = c.getPosition();
			int regionEnd = region.getOffset() + region.getLength();
			int pEnd = position.getOffset() + position.getLength();
			if (pEnd >= region.getOffset() && regionEnd > position.getOffset()) {
				styleRanges.addAll(c.getContainerStyles());
			}
		}

		StyleRange[] rangeArray = (StyleRange[]) styleRanges
				.toArray(new StyleRange[styleRanges.size()]);

		return rangeArray;
	}



}
