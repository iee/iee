package org.eclipse.iee.pad.formula.ui;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.container.EditorManager;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.ui.SelectionModel;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.translator.FormulaModelCreator;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
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

	private static TextLocation fTextLocation;
	
	private static SelectionModel fSelectionModel = new SelectionModel();
	
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

	    String formula = "k_D=h_2^2 + (2*c*cos(phi)-2*sigma_0*sin(phi))/(sigma_1-sigma_3+(sigma_1+sigma_3-2*sigma_0)*sin(phi)) + Sum(f(x), x=13..44)+Product(B[0][i],i=0..1) + 1/x + 2/$^$%^&%$&";
//		String formula = "Sum(f(x), x=(13..44))";
	    
		ANTLRInputStream input = new ANTLRInputStream(formula);
		MathLexer lexer = new MathLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MathParser parser = new MathParser(tokens);
		parser.setBuildParseTree(true);
		ParserRuleContext tree = parser.expression();

		FormulaModelCreator mathVisitor = new FormulaModelCreator();
		Expression fExpression = mathVisitor.visit(tree);
		System.out.println(fExpression.getText());
		ExpressionEditor editor = new ExpressionEditor(new RenderCtx());
	    editor.setValue(Optional.of(DefaultObservableValue.fromValue(fExpression)));
		editorManager.addEditor(editor);
		editorManager.getMainFigure().add(editor.getFigure(), BorderLayout.CENTER);
		
		shell.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				org.eclipse.draw2d.geometry.Point p = new org.eclipse.draw2d.geometry.Point(e.x, e.y);
				Optional<ITextEditor<?, ?>> c = editorManager.getEditorAt(p);
				
				c = getSelectableEditor(c);
				
				if (c.isPresent()) {
					editorManager.selectEditor(c.get());
					editorManager.activateEditor(c.get());
				} else {
					editorManager.selectEditor(null);
					editorManager.activateEditor(null);
				}
				
				Optional<ITextEditor<?, ?>> editor = editorManager.getEditorAt(p);
				if (editor.isPresent()) {
					Optional<TextLocation> textLocation = editor.get().getTextLocation(e.x, e.y);
					if (textLocation.isPresent()) {
						setPosition(shell, textLocation);
					}
				} 
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			private Optional<ITextEditor<?, ?>> getSelectableEditor(
					Optional<ITextEditor<?, ?>> c) {
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
					Optional<TextLocation> previous = fTextLocation.getPrevious();
					if (previous.isPresent()) {
						if ((e.stateMask & SWT.SHIFT) != 0) {
							appendSelection(shell, previous.get());
						} else {
							setPosition(shell, previous);
						}
					}
				} else if (e.keyCode == SWT.ARROW_RIGHT) {
					Optional<TextLocation> next = fTextLocation.getNext();
					if (next.isPresent()) {
						if ((e.stateMask & SWT.SHIFT) != 0) {
							appendSelection(shell, next.get());
						} else {
							setPosition(shell, next);
						}
					}
				} else if (e.keyCode == SWT.ARROW_UP) {
					Optional<TextLocation> above = fTextLocation.getAbove();
					if (above.isPresent()) {
						setPosition(shell, above);
					}
				} else if (e.keyCode == SWT.ARROW_DOWN) {
					Optional<TextLocation> below = fTextLocation.getBelow();
					if (below.isPresent()) {
						setPosition(shell, below);
					}
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
	
	public static void setPosition(final Shell shell, Optional<TextLocation> previous) {
		(fTextLocation = previous.get()).putCaret(getCaret(shell));
		fSelectionModel.set(previous.get());
	}
	
	public static void appendSelection(final Shell shell, TextLocation to) {
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
