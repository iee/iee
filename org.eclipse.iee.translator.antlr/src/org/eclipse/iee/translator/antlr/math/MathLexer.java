// Generated from D:\sergey\antlr\math\Math.g4 by ANTLR 4.0
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
		"\2\4\35\u00b7\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\7\31t\n\31\f\31\16\31w\13"+
		"\31\3\32\6\32z\n\32\r\32\16\32{\3\32\5\32\177\n\32\3\33\3\33\3\33\3\33"+
		"\3\34\6\34\u0086\n\34\r\34\16\34\u0087\3\34\3\34\7\34\u008c\n\34\f\34"+
		"\16\34\u008f\13\34\3\34\5\34\u0092\n\34\3\34\5\34\u0095\n\34\3\34\6\34"+
		"\u0098\n\34\r\34\16\34\u0099\3\34\5\34\u009d\n\34\3\34\5\34\u00a0\n\34"+
		"\3\34\3\34\6\34\u00a4\n\34\r\34\16\34\u00a5\3\34\5\34\u00a9\n\34\3\34"+
		"\5\34\u00ac\n\34\5\34\u00ae\n\34\3\35\3\35\3\36\3\36\5\36\u00b4\n\36\3"+
		"\36\3\36\2\37\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13"+
		"\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25"+
		"\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\2\67\35\19\2\1;\2\1\3"+
		"\2\13\5C\\aac|\7\62;C\\aac}\177\177\4NNnn\5\13\f\17\17\"\"\4NNnn\4NNn"+
		"n\4NNnn\4GGgg\4--//\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\rG\3"+
		"\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31"+
		"S\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37Z\3\2\2\2!]\3\2\2\2#`\3\2\2\2%c\3"+
		"\2\2\2\'e\3\2\2\2)g\3\2\2\2+i\3\2\2\2-l\3\2\2\2/o\3\2\2\2\61q\3\2\2\2"+
		"\63y\3\2\2\2\65\u0080\3\2\2\2\67\u00ad\3\2\2\29\u00af\3\2\2\2;\u00b1\3"+
		"\2\2\2=>\7\'\2\2>\4\3\2\2\2?@\7_\2\2@\6\3\2\2\2AB\7`\2\2B\b\3\2\2\2CD"+
		"\7+\2\2D\n\3\2\2\2EF\7\60\2\2F\f\3\2\2\2GH\7.\2\2H\16\3\2\2\2IJ\7-\2\2"+
		"J\20\3\2\2\2KL\7,\2\2L\22\3\2\2\2MN\7/\2\2N\24\3\2\2\2OP\7]\2\2P\26\3"+
		"\2\2\2QR\7*\2\2R\30\3\2\2\2ST\7>\2\2T\32\3\2\2\2UV\7?\2\2V\34\3\2\2\2"+
		"WX\7#\2\2XY\7?\2\2Y\36\3\2\2\2Z[\7>\2\2[\\\7?\2\2\\ \3\2\2\2]^\7(\2\2"+
		"^_\7(\2\2_\"\3\2\2\2`a\7~\2\2ab\7~\2\2b$\3\2\2\2cd\7@\2\2d&\3\2\2\2ef"+
		"\7}\2\2f(\3\2\2\2gh\7\61\2\2h*\3\2\2\2ij\7?\2\2jk\7?\2\2k,\3\2\2\2lm\7"+
		"@\2\2mn\7?\2\2n.\3\2\2\2op\7\177\2\2p\60\3\2\2\2qu\t\2\2\2rt\t\3\2\2s"+
		"r\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\62\3\2\2\2wu\3\2\2\2xz\59\35"+
		"\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}\177\t\4\2\2~}\3"+
		"\2\2\2~\177\3\2\2\2\177\64\3\2\2\2\u0080\u0081\t\5\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0083\b\33\2\2\u0083\66\3\2\2\2\u0084\u0086\59\35\2\u0085\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008d\7\60\2\2\u008a\u008c\59\35\2\u008b\u008a\3"+
		"\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\5;\36\2\u0091\u0090\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0095\t\6\2\2\u0094"+
		"\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u00ae\3\2\2\2\u0096\u0098\59"+
		"\35\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u009d\5;\36\2\u009c\u009b\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u00a0\t\7\2\2\u009f"+
		"\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00ae\3\2\2\2\u00a1\u00a3\7\60"+
		"\2\2\u00a2\u00a4\59\35\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a9\5;"+
		"\36\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00ac\t\b\2\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2"+
		"\2\2\u00ad\u0085\3\2\2\2\u00ad\u0097\3\2\2\2\u00ad\u00a1\3\2\2\2\u00ae"+
		"8\3\2\2\2\u00af\u00b0\4\62;\2\u00b0:\3\2\2\2\u00b1\u00b3\t\t\2\2\u00b2"+
		"\u00b4\t\n\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\5\63\32\2\u00b6<\3\2\2\2\22\2u{~\u0087\u008d\u0091\u0094"+
		"\u0099\u009c\u009f\u00a5\u00a8\u00ab\u00ad\u00b3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}