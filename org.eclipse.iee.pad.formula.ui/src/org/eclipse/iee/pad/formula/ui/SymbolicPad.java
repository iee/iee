package org.eclipse.iee.pad.formula.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;

import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.FormulaPart;
import org.eclipse.iee.pad.formula.SymbolicEngine;
import org.eclipse.iee.pad.formula.SymbolicPart;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.formula.ui.utils.Function;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolicPad extends AbstractFormulaPad<SymbolicPart> {

	private static final Logger logger = LoggerFactory.getLogger(SymbolicPad.class);

	private SymbolicEngine fSymbolicEngine;

	private PropertyChangeListener fListener;
	
	public SymbolicPad(UIFormulaRenderer formulaRenderer, TextRenderCtx renderCtx) {
		super(formulaRenderer, renderCtx);
		fSymbolicEngine = new SymbolicEngine();
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("formula".equals(evt.getPropertyName())) {
					updateFormula((String) evt.getNewValue());
				}
			}
		};
	}

	@Override
	public String getType() {
		return "Symbolic";
	}

	public void validateInput() {
		String text = getText();
		fOriginalExpression = text;

		if (SymbolicEngine.validate(text)) {
			setInputIsValid();
			fLastValidText = text;
		} else {

			setInputIsInvalid();
		}
	}

	public void processInput() {
		if (fIsInputValid) {
			if (!getText().equals(fTranslatingExpression)) {
				/* Remove result images from following pads */
				Collection<Pad<?, ?>> following = FormulaPadManager
						.getFollowingPads(this);

				for (Pad<?, ?> pad : following) {
					((SymbolicPad) pad).updateLastResult("");
				}
			}
		}

		fTranslatingExpression = fLastValidText;

		/* Set formula image */
		fTexExpression = translateToLatex(fTranslatingExpression);
		Image image = getFormulaRenderer().getSymbolicImage(fTexExpression);
		
		updateFormulaImage(image);

		/* Generate code */

		String output = generateSymjaOutputCode(fTranslatingExpression);
		updateLastResult(output);
		getDocumentPart().setFormula(fOriginalExpression);
		getContainer().updateDocument();
	}

	public String generateSymjaOutputCode(String expression) {
		String variable = expression;
		char lastVariable = variable.charAt(expression.trim().length() - 1);
		if (lastVariable == '=')
			variable = expression.substring(0, expression.lastIndexOf('='));
		String output = "";

		output = fSymbolicEngine.getOutput(variable);

		if (lastVariable != '=')
			output = "";

		return output;
	}

	public void updateLastResult(String result) {
		final Image image;
		fResult = result;
		if (result == "")
			image = null;
		else {
			String latex = translateToLatex(result);
			fTexExpression += latex;
			image = getFormulaRenderer().getSymbolicImage(latex);
		}
		Function updateImage = new Function() {
			@Override
			public void f() {
				updateLastResult(image);
			}
		};

		asyncUIUpdate(updateImage);

	}

	public static String translateToLatex(String text) {
		String latex = "";

		if (text.length() > 0 && text.charAt(text.length() - 1) == '=') {
			latex = SymbolicEngine.getTeX(text.substring(0,
					text.lastIndexOf('=')));
			latex = latex + "=";
		} else {
			latex = SymbolicEngine.getTeX(text);
		}
		logger.debug("tex: " + latex);

		return latex;

	}

	@Override
	protected Image createImage(String formula) {
		return getFormulaRenderer().getSymbolicImage(formula);
	}
	
	@Override
	protected void doBindValue(SymbolicPart value) {
		value.addPropertyChangeListener(fListener);
		updateFormula(value.getFormula());
	}
	
	@Override
	protected void doUnbindValue(SymbolicPart oldValue) {
		oldValue.removePropertyChangeListener(fListener);
	}
	
	private void updateFormula(String formula) {
		setTranslatingExpression(formula);
		setOriginalExpression(formula);
	}

}