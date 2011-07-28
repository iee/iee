package org.eclipse.iee.sample.math.pad;

import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import java.awt.Color;

import javax.swing.text.BadLocationException;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.iee.editor.core.pad.Pad;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.eval.TeXUtilities;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.form.output.StringBufferWriter;
import org.matheclipse.core.interfaces.IExpr;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class MathPad extends Pad {
	
	public MathPad() {
		super();
	}
	
	@Override
	public void createPartControl(final Composite parent)
	{

		parent.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		final Text text = new Text (parent, SWT.BORDER);
		text.setBounds(this.getContainer().getComposite().getLocation().x, this.getContainer().getComposite().getLocation().y, 20, 10);
		text.setText("Test");
		
		final Button calculate = new Button(parent, SWT.BUTTON1);
		final Label label = new Label(parent, SWT.NONE);
		final String imagePath = this.getContainerID() + ".jpg"; 
		calculate.setText("Calculate");
		calculate.setToolTipText("Calculate textbox expression");
		calculate.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {

				String output = "";				
				String expression = text.getText();
				
				try {
					F.initSymbols(null);
					EvalUtilities util = new EvalUtilities();
					IExpr result = null;
					StringBufferWriter buf = new StringBufferWriter();

					result = util.evaluate(expression);
					OutputFormFactory.get().convert(buf, result);

					output = buf.toString();

					/* Convert to TeX and image */
					EvalEngine engine = new EvalEngine();
					TeXUtilities texUtil = new TeXUtilities(engine);

					StringWriter stw = new StringWriter();
					texUtil.toTeX(result, stw);
					output = stw.toString();

					TeXFormula formula = new TeXFormula(stw.toString());
					/* */
					formula.createJPEG(TeXConstants.STYLE_DISPLAY, 20,
							imagePath, Color.white, Color.black);

				} catch (BadLocationException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				Image image = null;
				try {
					image = new Image(parent.getDisplay(), imagePath);
				} catch (Exception exception) {

					exception.printStackTrace();
					
				}
								
				label.setImage(image);
				parent.pack();
			}
			
			@Override
			public void mouseDown(MouseEvent e) { }
			
			@Override
			public void mouseDoubleClick(MouseEvent e) { }
		});
		
	}

	
	protected MathPad(String containerID) {
		super(containerID);
	}
	
	
	@Override
	public Pad copy() {
		// TODO Auto-generated method stub
		return new MathPad();
	}

	@Override
	public String getType() {
		return "Math";
	}

}

