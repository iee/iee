package org.eclipse.iee.sample.formula.pad;

public class SymbolicPad  extends FormulaPad{

	public SymbolicPad() {
		super();
	}
	
}


//fExpression = text.getText();
//String output = "";
//try {
//	F.initSymbols(null);
//	EvalUtilities util = new EvalUtilities();
//	IExpr result = null;
//	StringBufferWriter buf = new StringBufferWriter();
//
//	if (fExpression.isEmpty())
//		result = util.evaluate("Empty string");
//	else
//		result = util.evaluate(fExpression);
//	OutputFormFactory.get().convert(buf, result);
//
//	output = buf.toString();
//
//	/* Convert to TeX and image */
//	EvalEngine engine = new EvalEngine();
//	TeXUtilities texUtil = new TeXUtilities(engine);
//
//	StringWriter stw = new StringWriter();
//	texUtil.toTeX(result, stw);
//	output = stw.toString();
//	fExpression = output;
//
//	TeXFormula formula = new TeXFormula(stw.toString());
//	
//	/* */
//	formula.createJPEG(TeXConstants.STYLE_DISPLAY, 20,
//			fImagePath, Color.white, Color.black);