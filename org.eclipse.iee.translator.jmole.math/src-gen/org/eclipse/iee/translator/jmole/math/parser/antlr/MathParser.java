/*
* generated by Xtext
*/
package org.eclipse.iee.translator.jmole.math.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.iee.translator.jmole.math.services.MathGrammarAccess;

public class MathParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private MathGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.iee.translator.jmole.math.parser.antlr.internal.InternalMathParser createParser(XtextTokenStream stream) {
		return new org.eclipse.iee.translator.jmole.math.parser.antlr.internal.InternalMathParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Expression";
	}
	
	public MathGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MathGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
