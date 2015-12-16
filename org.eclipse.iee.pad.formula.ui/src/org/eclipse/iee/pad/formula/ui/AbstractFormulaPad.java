package org.eclipse.iee.pad.formula.ui;

import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.util.Collection;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.EventBusSupport;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.INodeVisitor;
import org.eclipse.iee.core.document.text.ISpanContent;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.FigurePad;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.editor.core.utils.runtime.file.IFileMessageListener;
import org.eclipse.iee.pad.formula.ui.utils.Function;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.text.ui.DocumentEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;
import com.google.common.eventbus.Subscribe;

public abstract class AbstractFormulaPad<T extends PadDocumentPart> extends FigurePad<T, Figure> implements IMenuContributor {

	private UIFormulaRenderer fFormulaRenderer;
	
	protected String fResult;

	private ImageFigure fHoverShell;

	protected boolean fIsInputValid;

	protected String fOriginalExpression = "";
	protected String fTranslatingExpression = "";
	protected String fLastValidText = "";
	protected String fTexExpression = "";

	private final Color INPUT_VALID_COLOR = new Color(null, 255, 255, 255);
	private final Color INPUT_INVALID_COLOR = new Color(null, 255, 0, 0);

	private IFileMessageListener fFileMessageListener = new IFileMessageListener() {

		@Override
		public void messageReceived(FileMessageEvent e) {
			updateLastResult(e.getMessage());
		}

		@Override
		public String getRequesterID() {
			return getContainerID();
		}

	};

	private TextRenderCtx fRenderCtx;
	private DocumentEditor fDocumentEditor;
	private ImageFigure fFormulaFigure = new ImageFigure();
	private ImageFigure fResultFigure = new ImageFigure();

	public AbstractFormulaPad(UIFormulaRenderer formulaRenderer, TextRenderCtx renderCtx) {
		fFormulaRenderer = formulaRenderer;
		fRenderCtx = renderCtx;
		fDocumentEditor = new DocumentEditor(renderCtx);
		addEditor(fDocumentEditor);
		EventBusSupport.getDefault().register(this);
	}
	
	@Subscribe
	public void onPropertyChange(PropertyChangeEvent event) {
		Object source = event.getSource();
		Document document = fDocumentEditor.getModel();
		if (document != null && (source instanceof INode) && ((INode)source).hasParent(document)) {
			fTexExpression = getText();
			
			validateInput();
			
			removeFormulaHover();
			
			Image image = createImage(fTexExpression);
			if (image == null) {
				fTexExpression = fLastValidText;
				image = createImage(fTexExpression);
			}
			
			fHoverShell = new ImageFigure(image);
			fHoverShell.setBorder(new LineBorder(1));
			// hack to paint hover image after widgets size
			// recalculation.
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					if (fHoverShell != null) {
						Rectangle bounds = getBounds();
						getContainer().getFeedbackFigure().add(
								fHoverShell,
								new org.eclipse.draw2d.geometry.Rectangle(bounds.x + 5, bounds.y + bounds.height + 5, -1, -1)
								);
					}
				}
			});
			
		}
			
	}

	protected String getText() {
		Document document = fDocumentEditor.getModel();
		String text = document.accept(new INodeVisitor<TextCtx, CharSequence>() {

			@Override
			public CharSequence visitText(Text text, TextCtx ctx) {
				return text.getText();
			}

			@Override
			public CharSequence visitDocument(Document document, TextCtx ctx) {
				StringBuilder sb = new StringBuilder();
				for (INode content : document.getChildren()) {
					sb.append(content.accept(this, ctx));
				}
				return sb;
			}

			@Override
			public CharSequence visitSpan(Span span, TextCtx ctx) {
				StringBuilder sb = new StringBuilder();
				for (ISpanContent content : span.getChildren()) {
					sb.append(content.accept(this, ctx));
				}
				return sb;
			}}, new TextCtx()).toString();
		return text;
	}

	public String getOriginalExpression() {
		return fOriginalExpression;
	}

	public void setOriginalExpression(String expression) {
		fOriginalExpression = expression;
	}

	public String getTranslatingExpression() {
		return fTranslatingExpression;
	}

	public void setTranslatingExpression(String expression) {
		fTranslatingExpression = expression;
		Document document = new Document();
		Span child = new Span();
		Text text = new Text();
		text.setText(expression);
		child.addChild(text);
		document.addChild(child);
		Optional<? extends IObservableValue<Document>> of = Optional.of(DefaultObservableValue.fromValue(document));
		fDocumentEditor.setValue(of);
		updateFormulaImage();
	}

	public UIFormulaRenderer getFormulaRenderer() {
		return fFormulaRenderer;
	}
	
	public void asyncUIUpdate(final Function function) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				function.f();
			}
		});
	}

	public void toggleInputText() {
		Figure figure = getFigure();
		figure.removeAll();
		figure.add(fDocumentEditor.getFigure());
	}

	public void toggleFormulaImage() {
		Figure figure = getFigure();
		toggleFormulaFigure(figure);
	}

	private void toggleFormulaFigure(Figure figure) {
		figure.removeAll();
		figure.setLayoutManager(new ToolbarLayout(true));
		figure.add(fFormulaFigure);
		figure.add(fResultFigure);
	}

	public void setInputIsValid() {
		fIsInputValid = true;
//		fViewer.getControl().setBackground(INPUT_VALID_COLOR);
	}

	public void setInputIsInvalid() {
		fIsInputValid = false;
//		fViewer.getControl().setBackground(INPUT_INVALID_COLOR);
	}

	public void validateInput() {
		// TODO: add validation
		String text = getText();
		fOriginalExpression = text;
		setInputIsValid();
		fLastValidText = text;
	}

	public void processInput() {
		if (fIsInputValid) {
			if (!getText().equals(fTranslatingExpression)) {
				/* Remove result images from following pads */
				Collection<Pad<?, ?>> following = FormulaPadManager
						.getFollowingPads(this);

				for (Pad<?, ?> pad : following) {
					((AbstractFormulaPad<?>) pad).updateLastResult("");
				}
			}
		}

		fTranslatingExpression = fLastValidText;

		updateFormulaImage();

	}

	private void updateFormulaImage() {
		fTexExpression = fTranslatingExpression;
		Image image = fFormulaRenderer.getFormulaImage(fTexExpression);
		updateFormulaImage(image);
	}

	protected void updateFormulaImage(Image image) {
		fFormulaFigure.setImage(image);
	}

	public void updateLastResult(String result) {
		final Image image;
		fResult = result;
		if (result == "")
			image = null;
		else {
			String latex = result;
			fTexExpression += latex;
			image = fFormulaRenderer.getFormulaImage(latex);
		}

		Function updateImage = new Function() {
			@Override
			public void f() {
				updateLastResult(image);
			}

		};

		asyncUIUpdate(updateImage);

	}
	
	protected void updateLastResult(Image image) {
		fResultFigure.setImage(image);
	}

	private void switchToResultView() {
		processInput();
		focusOnMainEditor();

		toggleFormulaImage();

		removeFormulaHover();
	}

	private void removeFormulaHover() {
		if (fHoverShell != null) {
			if (fHoverShell.getParent() != null) {
				fHoverShell.getParent().remove(fHoverShell);
			}
			fHoverShell = null;
		}
	}

	public void setListeners() {

		FileMessager.getInstance().addFileMessageListener(fFileMessageListener,
				getContainer().getContainerManager().getStoragePath());

//		fViewer.getTextWidget().addMouseWheelListener(new MouseWheelListener() {
//
//			@Override
//			public void mouseScrolled(MouseEvent e) {
//				removeFormulaHover();
//			}
//		});

	}

	protected Image createImage(String formula) {
		return fFormulaRenderer.getFormulaImage(fTexExpression);
	}
	
	@Override
	protected Figure createFigure() {
		Figure figure = new Figure();
		figure.setLayoutManager(new ToolbarLayout());
		validateInput();
		updateFormulaImage();
		toggleFormulaFigure(figure);
		return figure;
	}
	
	@Override
	public void contribute(MenuManager menuManager) {
		Action action = new Action("Copy result", SWT.PUSH) {
			@Override
			public void run() {
				Clipboard clipboard = new Clipboard(Display.getCurrent());
				try {
					TextTransfer transfer = TextTransfer.getInstance();
					clipboard.setContents(new Object[] { fResult },
							new Transfer[] { transfer });
				} finally {
					clipboard.dispose();
				}
			}
		};
		menuManager.add(action);
	}
	
	@Override
	public void activate() {
		toggleInputText();
	}

	@Override
	public void deactivate() {
		switchToResultView();
	}

	public void save() {
		processInput();
	}

	@Override
	public String getType() {
		return "Formula";
	}

	@Override
	public String getTex() {
		return fTexExpression;
	}

	@Override
	public boolean handleKey(VerifyEvent e) {
		switch (e.keyCode) {
		case SWT.CR:
			switchToResultView();
			moveCaretToContainerTail();
			return true;
		case SWT.ESC:
			switchToResultView();
			moveCaretToContainerTail();
			return true;
		}
		return super.handleKey(e);
	}
	

	@Override
	public Optional<IEditorLocation> getTextLocation(int x, int y) {
		return fDocumentEditor.getStart();
	}
	
}
