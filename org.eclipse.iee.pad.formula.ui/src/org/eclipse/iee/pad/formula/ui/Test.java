package org.eclipse.iee.pad.formula.ui;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.container.EditorManager;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.ui.SelectionModel;
import org.eclipse.iee.pad.text.ui.DocumentEditor;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.translator.FormulaModelCreator;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Optional;

public class Test {

	private static IEditorLocation fTextLocation;
	
	private static SelectionModel fSelectionModel;
	
	public static void main(String[] args) {

	    final Shell shell = new Shell();

	    LightweightSystem lws = new LightweightSystem(shell);
	    final EditorManager editorManager = new EditorManager() {
	    	@Override
	    	protected IFigure createMainFigure() {
	    		Figure result = new Figure();
	    		result.setLayoutManager(new BorderLayout());
	    		return result;
	    	}
	    };
		lws.setContents(editorManager.getRoot());
		fSelectionModel = new SelectionModel(editorManager);
//	    String formula = "k_D=h_2^2 + (2*c*cos(phi)-2*sigma_0*sin(phi))/(sigma_1-sigma_3+(sigma_1+sigma_3-2*sigma_0)*sin(phi)) + Sum(f(x), x=13..44)+Product(B[0][i],i=0..1) + 1/x + 2/$^$%^&%$&";
//		String formula = "Sum(f(x), x=(13..44))";
		String formula = "1 + 2 * 3";
	    
//		final ExpressionEditor editor = new ExpressionEditor(new RenderCtx());
//		updateExpression(formula);
		TextStyle textStyle = new TextStyle();
		textStyle.setFontSize(16);
		DocumentEditor documentEditor = new DocumentEditor(new TextRenderCtx(new TextStyle(), JFaceResources.getResources()));
		Document value = new Document();
		Span span = new Span();
		Text text = new Text();
		text.setText("T B D ! ! ! ");
		span.addChild(text);
		value.addChild(span);
		documentEditor.setValue(Optional.of(DefaultObservableValue.fromValue(value)));
		editorManager.addEditor(documentEditor);
		IFigure figure = documentEditor.getView().getWrapped(IFigure.class);
		editorManager.getMainFigure().add(figure, BorderLayout.CENTER);
		
		shell.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				org.eclipse.draw2d.geometry.Point p = new org.eclipse.draw2d.geometry.Point(e.x, e.y);
				Optional<ITextEditor<?>> c = editorManager.getEditorAt(p);
				
				c = getSelectableEditor(c);
				
				if (c.isPresent()) {
					editorManager.selectEditor(c.get());
					editorManager.activateEditor(c.get());
				} else {
					editorManager.selectEditor(null);
					editorManager.activateEditor(null);
				}
				
				Optional<ITextEditor<?>> editor = editorManager.getEditorAt(p);
				if (editor.isPresent()) {
					Optional<IEditorLocation> textLocation = editor.get().getTextLocation(e.x, e.y);
					if (textLocation.isPresent()) {
						setPosition(shell, textLocation);
					}
				} 
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			private Optional<ITextEditor<?>> getSelectableEditor(
					Optional<ITextEditor<?>> c) {
				while (c.isPresent() && !c.get().isSelectable()) {
					c = c.get().getParent();
				}
				return c;
			}
			
		});
		
		shell.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_LEFT) {
					Optional<IEditorLocation> previous = fTextLocation.getPrevious();
					if (previous.isPresent()) {
						if ((e.stateMask & SWT.SHIFT) != 0) {
							appendSelection(shell, previous.get());
						} else {
							setPosition(shell, previous);
						}
					}
				} else if (e.keyCode == SWT.ARROW_RIGHT) {
					Optional<IEditorLocation> next = fTextLocation.getNext();
					if (next.isPresent()) {
						if ((e.stateMask & SWT.SHIFT) != 0) {
							appendSelection(shell, next.get());
						} else {
							setPosition(shell, next);
						}
					}
				} else if (e.keyCode == SWT.ARROW_UP) {
					Optional<IEditorLocation> above = fTextLocation.getAbove();
					if (above.isPresent()) {
						if ((e.stateMask & SWT.SHIFT) != 0) {
							appendSelection(shell, above.get());
						} else {
							setPosition(shell, above);
						}
					}
				} else if (e.keyCode == SWT.ARROW_DOWN) {
					Optional<IEditorLocation> below = fTextLocation.getBelow();
					if (below.isPresent()) {
						if ((e.stateMask & SWT.SHIFT) != 0) {
							appendSelection(shell, below.get());
						} else {
							setPosition(shell, below);
						};
					}
				} else if (e.character != 0){
					System.out.println(e.character + " " + e.keyCode);
					setPosition(shell, Optional.of(fSelectionModel.replace(String.valueOf(e.character))));
//					TextGenerationContext textGenerationContext = new TextGenerationContext(fSelectionModel.normalize(), String.valueOf(e.character));
//					editor.generateText(textGenerationContext);
//					String formula = textGenerationContext.getResult();
//					System.out.println(formula);
//					updateExpression(formula);
				}
			}
			
		});
		
		
	    shell.setSize(330, 320);
	    shell.open();
	    shell.setText("Example");
	    Display display = Display.getDefault();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    
		
		
	    
	    
	}

	private static Expression updateExpression(String formula) {
		ANTLRInputStream input = new ANTLRInputStream(formula);
		MathLexer lexer = new MathLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MathParser parser = new MathParser(tokens);
		parser.setBuildParseTree(true);
		ParserRuleContext tree = parser.expression();

		FormulaModelCreator mathVisitor = new FormulaModelCreator();
		Expression fExpression = mathVisitor.visit(tree);
		System.out.println(fExpression.getText());
		return fExpression;
	}
	
	public static void setPosition(final Shell shell, Optional<IEditorLocation> previous) {
		(fTextLocation = previous.get()).putCaret(getCaret(shell));
		fSelectionModel.set(previous.get());
	}
	
	public static void appendSelection(final Shell shell, IEditorLocation to) {
		fSelectionModel.append(to);
		(fTextLocation = to).putCaret(getCaret(shell));
	}
	
	public static Caret getCaret(Shell shell) {
		Caret caret = shell.getCaret();
		if (caret == null) {
			caret = new Caret(shell, 0);
		}
		return caret;
	}
	
}
