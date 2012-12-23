// $ANTLR ANTLRVersion> MathLexer.java generatedTimestamp>
package org.eclipse.iee.translator.antlr.math;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__22=1, T__21=2, T__20=3, T__19=4, T__18=5, T__17=6, T__16=7, T__15=8, 
		T__14=9, T__13=10, T__12=11, T__11=12, T__10=13, T__9=14, T__8=15, T__7=16, 
		T__6=17, T__5=18, T__4=19, T__3=20, T__2=21, T__1=22, T__0=23, MATH_NAME=24, 
		INT=25, WS=26, FLOAT=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'%'", "']'", "'^'", "')'", "'.'", "','", "'+'", "'*'", "'-'", "'['", 
		"'('", "'<'", "'='", "'!='", "'<='", "'&&'", "'||'", "'>'", "'{'", "'/'", 
		"'=='", "'>='", "'}'", "MATH_NAME", "INT", "WS", "FLOAT"
	};
	public static final String[] ruleNames = {
		"T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", 
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "MATH_NAME", "INT", "WS", 
		"FLOAT", "DIGIT", "EXP"
	};


	public MathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Math.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 25: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\1\2\33\u00b5\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5"+
		"\2\6\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\2\16"+
		"\7\16\2\17\7\17\2\20\7\20\2\21\7\21\2\22\7\22\2\23\7\23\2\24\7\24\2\25"+
		"\7\25\2\26\7\26\2\27\7\27\2\30\7\30\2\31\7\31\2\32\7\32\2\33\7\33\2\34"+
		"\7\34\1\0\1\0\1\1\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1\5\1\5\1\6\1\6\1\7\1\7"+
		"\1\b\1\b\1\t\1\t\1\n\1\n\1\13\1\13\1\f\1\f\1\r\1\r\1\r\1\16\1\16\1\16"+
		"\1\17\1\17\1\17\1\20\1\20\1\20\1\21\1\21\1\22\1\22\1\23\1\23\1\24\1\24"+
		"\1\24\1\25\1\25\1\25\1\26\1\26\1\27\1\27\5\27r\b\27\n\27\f\27u\t\27\1"+
		"\30\4\30x\b\30\13\30\f\30y\1\30\3\30}\b\30\1\31\1\31\1\31\1\31\1\32\4"+
		"\32\u0084\b\32\13\32\f\32\u0085\1\32\1\32\5\32\u008a\b\32\n\32\f\32\u008d"+
		"\t\32\1\32\3\32\u0090\b\32\1\32\3\32\u0093\b\32\1\32\4\32\u0096\b\32\13"+
		"\32\f\32\u0097\1\32\3\32\u009b\b\32\1\32\3\32\u009e\b\32\1\32\1\32\4\32"+
		"\u00a2\b\32\13\32\f\32\u00a3\1\32\3\32\u00a7\b\32\1\32\3\32\u00aa\b\32"+
		"\3\32\u00ac\b\32\1\33\1\33\1\34\1\34\3\34\u00b2\b\34\1\34\1\34\0\35\1"+
		"\1\uffff\3\2\uffff\5\3\uffff\7\4\uffff\t\5\uffff\13\6\uffff\r\7\uffff"+
		"\17\b\uffff\21\t\uffff\23\n\uffff\25\13\uffff\27\f\uffff\31\r\uffff\33"+
		"\16\uffff\35\17\uffff\37\20\uffff!\21\uffff#\22\uffff%\23\uffff\'\24\uffff"+
		")\25\uffff+\26\uffff-\27\uffff/\30\uffff\61\31\uffff\63\32\0\65\33\uffff"+
		"\67\0\uffff9\0\uffff\1\0\t\3AZ__az\4\609AZ__az\2LLll\3\t\n\r\r  \2LLl"+
		"l\2LLll\2LLll\2EEee\2++--\u00c2\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0\0\0\0"+
		"\7\1\0\0\0\0\t\1\0\0\0\0\13\1\0\0\0\0\r\1\0\0\0\0\17\1\0\0\0\0\21\1\0"+
		"\0\0\0\23\1\0\0\0\0\25\1\0\0\0\0\27\1\0\0\0\0\31\1\0\0\0\0\33\1\0\0\0"+
		"\0\35\1\0\0\0\0\37\1\0\0\0\0!\1\0\0\0\0#\1\0\0\0\0%\1\0\0\0\0\'\1\0\0"+
		"\0\0)\1\0\0\0\0+\1\0\0\0\0-\1\0\0\0\0/\1\0\0\0\0\61\1\0\0\0\0\63\1\0\0"+
		"\0\0\65\1\0\0\0\1;\1\0\0\0\3=\1\0\0\0\5?\1\0\0\0\7A\1\0\0\0\tC\1\0\0\0"+
		"\13E\1\0\0\0\rG\1\0\0\0\17I\1\0\0\0\21K\1\0\0\0\23M\1\0\0\0\25O\1\0\0"+
		"\0\27Q\1\0\0\0\31S\1\0\0\0\33U\1\0\0\0\35X\1\0\0\0\37[\1\0\0\0!^\1\0\0"+
		"\0#a\1\0\0\0%c\1\0\0\0\'e\1\0\0\0)g\1\0\0\0+j\1\0\0\0-m\1\0\0\0/o\1\0"+
		"\0\0\61w\1\0\0\0\63~\1\0\0\0\65\u00ab\1\0\0\0\67\u00ad\1\0\0\09\u00af"+
		"\1\0\0\0;<\5%\0\0<\2\1\0\0\0=>\5]\0\0>\4\1\0\0\0?@\5^\0\0@\6\1\0\0\0A"+
		"B\5)\0\0B\b\1\0\0\0CD\5.\0\0D\n\1\0\0\0EF\5,\0\0F\f\1\0\0\0GH\5+\0\0H"+
		"\16\1\0\0\0IJ\5*\0\0J\20\1\0\0\0KL\5-\0\0L\22\1\0\0\0MN\5[\0\0N\24\1\0"+
		"\0\0OP\5(\0\0P\26\1\0\0\0QR\5<\0\0R\30\1\0\0\0ST\5=\0\0T\32\1\0\0\0UV"+
		"\5!\0\0VW\5=\0\0W\34\1\0\0\0XY\5<\0\0YZ\5=\0\0Z\36\1\0\0\0[\\\5&\0\0\\"+
		"]\5&\0\0] \1\0\0\0^_\5|\0\0_`\5|\0\0`\"\1\0\0\0ab\5>\0\0b$\1\0\0\0cd\5"+
		"{\0\0d&\1\0\0\0ef\5/\0\0f(\1\0\0\0gh\5=\0\0hi\5=\0\0i*\1\0\0\0jk\5>\0"+
		"\0kl\5=\0\0l,\1\0\0\0mn\5}\0\0n.\1\0\0\0os\7\0\0\0pr\7\1\0\0qp\1\0\0\0"+
		"ru\1\0\0\0sq\1\0\0\0st\1\0\0\0t\60\1\0\0\0us\1\0\0\0vx\3\67\33\0wv\1\0"+
		"\0\0xy\1\0\0\0yw\1\0\0\0yz\1\0\0\0z|\1\0\0\0{}\7\2\0\0|{\1\0\0\0|}\1\0"+
		"\0\0}\62\1\0\0\0~\177\7\3\0\0\177\u0080\1\0\0\0\u0080\u0081\6\31\0\0\u0081"+
		"\64\1\0\0\0\u0082\u0084\3\67\33\0\u0083\u0082\1\0\0\0\u0084\u0085\1\0"+
		"\0\0\u0085\u0083\1\0\0\0\u0085\u0086\1\0\0\0\u0086\u0087\1\0\0\0\u0087"+
		"\u008b\5.\0\0\u0088\u008a\3\67\33\0\u0089\u0088\1\0\0\0\u008a\u008d\1"+
		"\0\0\0\u008b\u0089\1\0\0\0\u008b\u008c\1\0\0\0\u008c\u008f\1\0\0\0\u008d"+
		"\u008b\1\0\0\0\u008e\u0090\39\34\0\u008f\u008e\1\0\0\0\u008f\u0090\1\0"+
		"\0\0\u0090\u0092\1\0\0\0\u0091\u0093\7\4\0\0\u0092\u0091\1\0\0\0\u0092"+
		"\u0093\1\0\0\0\u0093\u00ac\1\0\0\0\u0094\u0096\3\67\33\0\u0095\u0094\1"+
		"\0\0\0\u0096\u0097\1\0\0\0\u0097\u0095\1\0\0\0\u0097\u0098\1\0\0\0\u0098"+
		"\u009a\1\0\0\0\u0099\u009b\39\34\0\u009a\u0099\1\0\0\0\u009a\u009b\1\0"+
		"\0\0\u009b\u009d\1\0\0\0\u009c\u009e\7\5\0\0\u009d\u009c\1\0\0\0\u009d"+
		"\u009e\1\0\0\0\u009e\u00ac\1\0\0\0\u009f\u00a1\5.\0\0\u00a0\u00a2\3\67"+
		"\33\0\u00a1\u00a0\1\0\0\0\u00a2\u00a3\1\0\0\0\u00a3\u00a1\1\0\0\0\u00a3"+
		"\u00a4\1\0\0\0\u00a4\u00a6\1\0\0\0\u00a5\u00a7\39\34\0\u00a6\u00a5\1\0"+
		"\0\0\u00a6\u00a7\1\0\0\0\u00a7\u00a9\1\0\0\0\u00a8\u00aa\7\6\0\0\u00a9"+
		"\u00a8\1\0\0\0\u00a9\u00aa\1\0\0\0\u00aa\u00ac\1\0\0\0\u00ab\u0083\1\0"+
		"\0\0\u00ab\u0095\1\0\0\0\u00ab\u009f\1\0\0\0\u00ac\66\1\0\0\0\u00ad\u00ae"+
		"\2\609\0\u00ae8\1\0\0\0\u00af\u00b1\7\7\0\0\u00b0\u00b2\7\b\0\0\u00b1"+
		"\u00b0\1\0\0\0\u00b1\u00b2\1\0\0\0\u00b2\u00b3\1\0\0\0\u00b3\u00b4\3\61"+
		"\30\0\u00b4:\1\0\0\0\20\0sy|\u0085\u008b\u008f\u0092\u0097\u009a\u009d"+
		"\u00a3\u00a6\u00a9\u00ab\u00b1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}