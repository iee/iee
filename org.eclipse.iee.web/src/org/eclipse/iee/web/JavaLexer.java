// Generated from C:\Users\Efimchuk.A\git\iee\org.eclipse.iee.web\src\org\eclipse\iee\web\JavaLexer.g4 by ANTLR 4.0
package org.eclipse.iee.web;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Keyword=1, Braces=2, Delimiters=3, HexLiteral=4, DecimalLiteral=5, OctalLiteral=6, 
		BinaryLiteral=7, FloatingPointLiteral=8, CharacterLiteral=9, StringLiteral=10, 
		Identifier=11, Ws=12, Pad=13, DirectiveStart=14, DirectiveEnd=15, Javadoc=16, 
		Comment=17, LineComment=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"Keyword", "Braces", "Delimiters", "HexLiteral", "DecimalLiteral", "OctalLiteral", 
		"BinaryLiteral", "FloatingPointLiteral", "CharacterLiteral", "StringLiteral", 
		"Identifier", "Ws", "Pad", "DirectiveStart", "DirectiveEnd", "Javadoc", 
		"Comment", "LineComment"
	};
	public static final String[] ruleNames = {
		"Keyword", "Braces", "Delimiters", "HexLiteral", "DecimalLiteral", "OctalLiteral", 
		"BinaryLiteral", "BinaryDigit", "HexDigits", "HexDigit", "Digits", "Digit", 
		"IntegerTypeSuffix", "FloatingPointLiteral", "Exponent", "FloatTypeSuffix", 
		"CharacterLiteral", "StringLiteral", "EscapeSequence", "OctalEscape", 
		"UnicodeEscape", "Identifier", "Letter", "JavaIDDigit", "Ws", "Pad", "DirectiveStart", 
		"DirectiveEnd", "Javadoc", "Comment", "LineComment"
	};


	public JavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JavaLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\2\4\24\u02b0\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\5\2\u018c\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u0196\n"+
		"\5\3\6\3\6\3\6\7\6\u019b\n\6\f\6\16\6\u019e\13\6\3\6\7\6\u01a1\n\6\f\6"+
		"\16\6\u01a4\13\6\5\6\u01a6\n\6\3\6\5\6\u01a9\n\6\3\7\3\7\7\7\u01ad\n\7"+
		"\f\7\16\7\u01b0\13\7\3\7\6\7\u01b3\n\7\r\7\16\7\u01b4\3\7\5\7\u01b8\n"+
		"\7\3\b\3\b\3\b\3\b\7\b\u01be\n\b\f\b\16\b\u01c1\13\b\3\b\7\b\u01c4\n\b"+
		"\f\b\16\b\u01c7\13\b\3\b\5\b\u01ca\n\b\3\t\3\t\3\n\3\n\7\n\u01d0\n\n\f"+
		"\n\16\n\u01d3\13\n\3\n\7\n\u01d6\n\n\f\n\16\n\u01d9\13\n\3\13\3\13\5\13"+
		"\u01dd\n\13\3\f\3\f\7\f\u01e1\n\f\f\f\16\f\u01e4\13\f\3\f\7\f\u01e7\n"+
		"\f\f\f\16\f\u01ea\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\5\17\u01f3\n\17"+
		"\3\17\5\17\u01f6\n\17\3\17\5\17\u01f9\n\17\3\17\3\17\3\17\5\17\u01fe\n"+
		"\17\3\17\5\17\u0201\n\17\3\17\3\17\3\17\5\17\u0206\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u020f\n\17\3\17\5\17\u0212\n\17\3\17\3\17\5"+
		"\17\u0216\n\17\5\17\u0218\n\17\3\17\3\17\5\17\u021c\n\17\3\17\3\17\5\17"+
		"\u0220\n\17\5\17\u0222\n\17\3\20\3\20\5\20\u0226\n\20\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\22\5\22\u022f\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u0236"+
		"\n\23\f\23\16\23\u0239\13\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u0241"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u024c\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u0258\n\27\f\27\16"+
		"\27\u025b\13\27\3\30\3\30\3\31\3\31\3\32\6\32\u0262\n\32\r\32\16\32\u0263"+
		"\3\33\3\33\3\33\3\33\3\33\7\33\u026b\n\33\f\33\16\33\u026e\13\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u027a\n\34\f\34\16"+
		"\34\u027d\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0288"+
		"\n\35\f\35\16\35\u028b\13\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\7\36\u0294"+
		"\n\36\f\36\16\36\u0297\13\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u02a0"+
		"\n\37\f\37\16\37\u02a3\13\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u02ac\n \f"+
		" \16 \u02af\13 \5\u026c\u0295\u02a1!\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\2\1\23\2\1\25\2\1\27\2\1\31\2\1\33\2\1\35\n\1\37\2\1!\2"+
		"\1#\13\1%\f\1\'\2\1)\2\1+\2\1-\r\1/\2\1\61\2\1\63\16\1\65\17\1\67\20\1"+
		"9\21\1;\22\1=\23\1?\24\1\3\2\26\7*+]]__}}\177\177\n##%%\'(,\61<A^^``~"+
		"~\4ZZzz\4DDdd\4CHch\4NNnn\4RRrr\4--//\4GGgg\4--//\6FFHHffhh\4))^^\4$$"+
		"^^\n$$))^^ddhhppttvv\16&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa\u2001\u3042"+
		"\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21\62;\u0662\u066b"+
		"\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71"+
		"\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb"+
		"\u1042\u104b\5\13\f\16\17\"\"\3^_\3^_\4\f\f\17\17\u030a\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\35\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3\u018b"+
		"\3\2\2\2\5\u018d\3\2\2\2\7\u018f\3\2\2\2\t\u0191\3\2\2\2\13\u01a5\3\2"+
		"\2\2\r\u01aa\3\2\2\2\17\u01b9\3\2\2\2\21\u01cb\3\2\2\2\23\u01cd\3\2\2"+
		"\2\25\u01dc\3\2\2\2\27\u01de\3\2\2\2\31\u01eb\3\2\2\2\33\u01ed\3\2\2\2"+
		"\35\u0221\3\2\2\2\37\u0223\3\2\2\2!\u0229\3\2\2\2#\u022b\3\2\2\2%\u0232"+
		"\3\2\2\2\'\u0240\3\2\2\2)\u024b\3\2\2\2+\u024d\3\2\2\2-\u0254\3\2\2\2"+
		"/\u025c\3\2\2\2\61\u025e\3\2\2\2\63\u0261\3\2\2\2\65\u0265\3\2\2\2\67"+
		"\u0273\3\2\2\29\u0280\3\2\2\2;\u028e\3\2\2\2=\u029b\3\2\2\2?\u02a7\3\2"+
		"\2\2AB\7d\2\2BC\7q\2\2CD\7q\2\2DE\7n\2\2EF\7g\2\2FG\7c\2\2G\u018c\7p\2"+
		"\2HI\7d\2\2IJ\7{\2\2JK\7v\2\2K\u018c\7g\2\2LM\7e\2\2MN\7j\2\2NO\7c\2\2"+
		"O\u018c\7t\2\2PQ\7f\2\2QR\7q\2\2RS\7w\2\2ST\7d\2\2TU\7n\2\2U\u018c\7g"+
		"\2\2VW\7h\2\2WX\7n\2\2XY\7q\2\2YZ\7c\2\2Z\u018c\7v\2\2[\\\7k\2\2\\]\7"+
		"p\2\2]\u018c\7v\2\2^_\7n\2\2_`\7q\2\2`a\7p\2\2a\u018c\7i\2\2bc\7u\2\2"+
		"cd\7j\2\2de\7q\2\2ef\7t\2\2f\u018c\7v\2\2gh\7x\2\2hi\7q\2\2ij\7k\2\2j"+
		"\u018c\7f\2\2kl\7c\2\2lm\7u\2\2mn\7u\2\2no\7g\2\2op\7t\2\2p\u018c\7v\2"+
		"\2qr\7c\2\2rs\7d\2\2st\7u\2\2tu\7v\2\2uv\7t\2\2vw\7c\2\2wx\7e\2\2x\u018c"+
		"\7v\2\2yz\7f\2\2z{\7g\2\2{|\7h\2\2|}\7c\2\2}~\7w\2\2~\177\7n\2\2\177\u018c"+
		"\7v\2\2\u0080\u0081\7k\2\2\u0081\u018c\7h\2\2\u0082\u0083\7r\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u0085\7k\2\2\u0085\u0086\7x\2\2\u0086\u0087\7c\2\2"+
		"\u0087\u0088\7v\2\2\u0088\u018c\7g\2\2\u0089\u008a\7v\2\2\u008a\u008b"+
		"\7j\2\2\u008b\u008c\7k\2\2\u008c\u018c\7u\2\2\u008d\u008e\7f\2\2\u008e"+
		"\u018c\7q\2\2\u008f\u0090\7k\2\2\u0090\u0091\7o\2\2\u0091\u0092\7r\2\2"+
		"\u0092\u0093\7n\2\2\u0093\u0094\7g\2\2\u0094\u0095\7o\2\2\u0095\u0096"+
		"\7g\2\2\u0096\u0097\7p\2\2\u0097\u0098\7v\2\2\u0098\u018c\7u\2\2\u0099"+
		"\u009a\7r\2\2\u009a\u009b\7t\2\2\u009b\u009c\7q\2\2\u009c\u009d\7v\2\2"+
		"\u009d\u009e\7g\2\2\u009e\u009f\7e\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1"+
		"\7g\2\2\u00a1\u018c\7f\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4\7j\2\2\u00a4"+
		"\u00a5\7t\2\2\u00a5\u00a6\7q\2\2\u00a6\u018c\7y\2\2\u00a7\u00a8\7d\2\2"+
		"\u00a8\u00a9\7t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7c\2\2\u00ab\u018c"+
		"\7m\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7o\2\2\u00ae\u00af\7r\2\2\u00af"+
		"\u00b0\7q\2\2\u00b0\u00b1\7t\2\2\u00b1\u018c\7v\2\2\u00b2\u00b3\7r\2\2"+
		"\u00b3\u00b4\7w\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7"+
		"\7k\2\2\u00b7\u018c\7e\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7j\2\2\u00ba"+
		"\u00bb\7t\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7y\2\2\u00bd\u018c\7u\2\2"+
		"\u00be\u00bf\7g\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7u\2\2\u00c1\u018c"+
		"\7g\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7u\2\2\u00c5"+
		"\u00c6\7v\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7e\2\2"+
		"\u00c9\u00ca\7g\2\2\u00ca\u00cb\7q\2\2\u00cb\u018c\7h\2\2\u00cc\u00cd"+
		"\7t\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7w\2\2\u00d0"+
		"\u00d1\7t\2\2\u00d1\u018c\7p\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7t\2\2"+
		"\u00d4\u00d5\7c\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8"+
		"\7k\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7p\2\2\u00da\u018c\7v\2\2\u00db"+
		"\u00dc\7e\2\2\u00dc\u00dd\7c\2\2\u00dd\u00de\7u\2\2\u00de\u018c\7g\2\2"+
		"\u00df\u00e0\7g\2\2\u00e0\u00e1\7z\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3"+
		"\7g\2\2\u00e3\u00e4\7p\2\2\u00e4\u00e5\7f\2\2\u00e5\u018c\7u\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7\u00e8\7t\2\2\u00e8\u018c\7{\2\2\u00e9\u00ea\7e\2\2"+
		"\u00ea\u00eb\7c\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7e\2\2\u00ed\u018c"+
		"\7j\2\2\u00ee\u00ef\7h\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1"+
		"\u00f2\7c\2\2\u00f2\u018c\7n\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7p\2\2"+
		"\u00f5\u00f6\7v\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9"+
		"\7h\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7e\2\2\u00fb\u018c\7g\2\2\u00fc"+
		"\u00fd\7u\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7v\2\2"+
		"\u0100\u0101\7k\2\2\u0101\u018c\7e\2\2\u0102\u0103\7h\2\2\u0103\u0104"+
		"\7k\2\2\u0104\u0105\7p\2\2\u0105\u0106\7c\2\2\u0106\u0107\7n\2\2\u0107"+
		"\u0108\7n\2\2\u0108\u018c\7{\2\2\u0109\u010a\7u\2\2\u010a\u010b\7v\2\2"+
		"\u010b\u010c\7t\2\2\u010c\u010d\7k\2\2\u010d\u010e\7e\2\2\u010e\u010f"+
		"\7v\2\2\u010f\u0110\7h\2\2\u0110\u018c\7r\2\2\u0111\u0112\7x\2\2\u0112"+
		"\u0113\7q\2\2\u0113\u0114\7n\2\2\u0114\u0115\7c\2\2\u0115\u0116\7v\2\2"+
		"\u0116\u0117\7k\2\2\u0117\u0118\7n\2\2\u0118\u018c\7g\2\2\u0119\u011a"+
		"\7e\2\2\u011a\u011b\7n\2\2\u011b\u011c\7c\2\2\u011c\u011d\7u\2\2\u011d"+
		"\u018c\7u\2\2\u011e\u011f\7p\2\2\u011f\u0120\7c\2\2\u0120\u0121\7v\2\2"+
		"\u0121\u0122\7k\2\2\u0122\u0123\7x\2\2\u0123\u018c\7g\2\2\u0124\u0125"+
		"\7u\2\2\u0125\u0126\7w\2\2\u0126\u0127\7r\2\2\u0127\u0128\7g\2\2\u0128"+
		"\u018c\7t\2\2\u0129\u012a\7y\2\2\u012a\u012b\7j\2\2\u012b\u012c\7k\2\2"+
		"\u012c\u012d\7n\2\2\u012d\u018c\7g\2\2\u012e\u012f\7e\2\2\u012f\u0130"+
		"\7q\2\2\u0130\u0131\7p\2\2\u0131\u0132\7u\2\2\u0132\u018c\7v\2\2\u0133"+
		"\u0134\7h\2\2\u0134\u0135\7q\2\2\u0135\u018c\7t\2\2\u0136\u0137\7p\2\2"+
		"\u0137\u0138\7g\2\2\u0138\u018c\7y\2\2\u0139\u013a\7u\2\2\u013a\u013b"+
		"\7v\2\2\u013b\u013c\7t\2\2\u013c\u013d\7k\2\2\u013d\u013e\7e\2\2\u013e"+
		"\u013f\7v\2\2\u013f\u0140\7h\2\2\u0140\u018c\7r\2\2\u0141\u0142\7u\2\2"+
		"\u0142\u0143\7y\2\2\u0143\u0144\7k\2\2\u0144\u0145\7v\2\2\u0145\u0146"+
		"\7e\2\2\u0146\u018c\7j\2\2\u0147\u0148\7e\2\2\u0148\u0149\7q\2\2\u0149"+
		"\u014a\7p\2\2\u014a\u014b\7v\2\2\u014b\u014c\7k\2\2\u014c\u014d\7p\2\2"+
		"\u014d\u014e\7w\2\2\u014e\u018c\7g\2\2\u014f\u0150\7i\2\2\u0150\u0151"+
		"\7q\2\2\u0151\u0152\7v\2\2\u0152\u018c\7q\2\2\u0153\u0154\7r\2\2\u0154"+
		"\u0155\7c\2\2\u0155\u0156\7e\2\2\u0156\u0157\7m\2\2\u0157\u0158\7c\2\2"+
		"\u0158\u0159\7i\2\2\u0159\u018c\7g\2\2\u015a\u015b\7u\2\2\u015b\u015c"+
		"\7{\2\2\u015c\u015d\7p\2\2\u015d\u015e\7e\2\2\u015e\u015f\7j\2\2\u015f"+
		"\u0160\7t\2\2\u0160\u0161\7q\2\2\u0161\u0162\7p\2\2\u0162\u0163\7k\2\2"+
		"\u0163\u0164\7|\2\2\u0164\u0165\7g\2\2\u0165\u018c\7f\2\2\u0166\u0167"+
		"\7v\2\2\u0167\u0168\7j\2\2\u0168\u0169\7t\2\2\u0169\u016a\7g\2\2\u016a"+
		"\u016b\7c\2\2\u016b\u016c\7f\2\2\u016c\u016d\7u\2\2\u016d\u016e\7c\2\2"+
		"\u016e\u016f\7h\2\2\u016f\u018c\7g\2\2\u0170\u0171\7p\2\2\u0171\u0172"+
		"\7w\2\2\u0172\u0173\7n\2\2\u0173\u018c\7n\2\2\u0174\u0175\7v\2\2\u0175"+
		"\u0176\7t\2\2\u0176\u0177\7w\2\2\u0177\u018c\7g\2\2\u0178\u0179\7h\2\2"+
		"\u0179\u017a\7c\2\2\u017a\u017b\7n\2\2\u017b\u017c\7u\2\2\u017c\u018c"+
		"\7g\2\2\u017d\u017e\7g\2\2\u017e\u017f\7p\2\2\u017f\u0180\7w\2\2\u0180"+
		"\u018c\7o\2\2\u0181\u0182\7B\2\2\u0182\u0183\7k\2\2\u0183\u0184\7p\2\2"+
		"\u0184\u0185\7v\2\2\u0185\u0186\7g\2\2\u0186\u0187\7t\2\2\u0187\u0188"+
		"\7h\2\2\u0188\u0189\7c\2\2\u0189\u018a\7e\2\2\u018a\u018c\7g\2\2\u018b"+
		"A\3\2\2\2\u018bH\3\2\2\2\u018bL\3\2\2\2\u018bP\3\2\2\2\u018bV\3\2\2\2"+
		"\u018b[\3\2\2\2\u018b^\3\2\2\2\u018bb\3\2\2\2\u018bg\3\2\2\2\u018bk\3"+
		"\2\2\2\u018bq\3\2\2\2\u018by\3\2\2\2\u018b\u0080\3\2\2\2\u018b\u0082\3"+
		"\2\2\2\u018b\u0089\3\2\2\2\u018b\u008d\3\2\2\2\u018b\u008f\3\2\2\2\u018b"+
		"\u0099\3\2\2\2\u018b\u00a2\3\2\2\2\u018b\u00a7\3\2\2\2\u018b\u00ac\3\2"+
		"\2\2\u018b\u00b2\3\2\2\2\u018b\u00b8\3\2\2\2\u018b\u00be\3\2\2\2\u018b"+
		"\u00c2\3\2\2\2\u018b\u00cc\3\2\2\2\u018b\u00d2\3\2\2\2\u018b\u00db\3\2"+
		"\2\2\u018b\u00df\3\2\2\2\u018b\u00e6\3\2\2\2\u018b\u00e9\3\2\2\2\u018b"+
		"\u00ee\3\2\2\2\u018b\u00f3\3\2\2\2\u018b\u00fc\3\2\2\2\u018b\u0102\3\2"+
		"\2\2\u018b\u0109\3\2\2\2\u018b\u0111\3\2\2\2\u018b\u0119\3\2\2\2\u018b"+
		"\u011e\3\2\2\2\u018b\u0124\3\2\2\2\u018b\u0129\3\2\2\2\u018b\u012e\3\2"+
		"\2\2\u018b\u0133\3\2\2\2\u018b\u0136\3\2\2\2\u018b\u0139\3\2\2\2\u018b"+
		"\u0141\3\2\2\2\u018b\u0147\3\2\2\2\u018b\u014f\3\2\2\2\u018b\u0153\3\2"+
		"\2\2\u018b\u015a\3\2\2\2\u018b\u0166\3\2\2\2\u018b\u0170\3\2\2\2\u018b"+
		"\u0174\3\2\2\2\u018b\u0178\3\2\2\2\u018b\u017d\3\2\2\2\u018b\u0181\3\2"+
		"\2\2\u018c\4\3\2\2\2\u018d\u018e\t\2\2\2\u018e\6\3\2\2\2\u018f\u0190\t"+
		"\3\2\2\u0190\b\3\2\2\2\u0191\u0192\7\62\2\2\u0192\u0193\t\4\2\2\u0193"+
		"\u0195\5\23\n\2\u0194\u0196\5\33\16\2\u0195\u0194\3\2\2\2\u0195\u0196"+
		"\3\2\2\2\u0196\n\3\2\2\2\u0197\u01a6\7\62\2\2\u0198\u01a2\4\63;\2\u0199"+
		"\u019b\7a\2\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2"+
		"\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f"+
		"\u01a1\5\31\r\2\u01a0\u019c\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3"+
		"\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5"+
		"\u0197\3\2\2\2\u01a5\u0198\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a9\5\33"+
		"\16\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\f\3\2\2\2\u01aa\u01b2"+
		"\7\62\2\2\u01ab\u01ad\7a\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae"+
		"\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b1\u01b3\4\629\2\u01b2\u01ae\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b8\5\33"+
		"\16\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\16\3\2\2\2\u01b9\u01ba"+
		"\7\62\2\2\u01ba\u01bb\t\5\2\2\u01bb\u01c5\5\21\t\2\u01bc\u01be\7a\2\2"+
		"\u01bd\u01bc\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0"+
		"\3\2\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c4\5\21\t\2"+
		"\u01c3\u01bf\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6"+
		"\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01ca\5\33\16\2"+
		"\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\20\3\2\2\2\u01cb\u01cc"+
		"\4\62\63\2\u01cc\22\3\2\2\2\u01cd\u01d7\5\25\13\2\u01ce\u01d0\7a\2\2\u01cf"+
		"\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2"+
		"\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d6\5\25\13\2\u01d5"+
		"\u01d1\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2"+
		"\2\2\u01d8\24\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01dd\5\31\r\2\u01db\u01dd"+
		"\t\6\2\2\u01dc\u01da\3\2\2\2\u01dc\u01db\3\2\2\2\u01dd\26\3\2\2\2\u01de"+
		"\u01e8\5\31\r\2\u01df\u01e1\7a\2\2\u01e0\u01df\3\2\2\2\u01e1\u01e4\3\2"+
		"\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e5\u01e7\5\31\r\2\u01e6\u01e2\3\2\2\2\u01e7\u01ea\3"+
		"\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\30\3\2\2\2\u01ea"+
		"\u01e8\3\2\2\2\u01eb\u01ec\4\62;\2\u01ec\32\3\2\2\2\u01ed\u01ee\t\7\2"+
		"\2\u01ee\34\3\2\2\2\u01ef\u01f0\5\27\f\2\u01f0\u01f2\7\60\2\2\u01f1\u01f3"+
		"\5\27\f\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f5\3\2\2\2"+
		"\u01f4\u01f6\5\37\20\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8"+
		"\3\2\2\2\u01f7\u01f9\5!\21\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"\u0222\3\2\2\2\u01fa\u01fb\7\60\2\2\u01fb\u01fd\5\27\f\2\u01fc\u01fe\5"+
		"\37\20\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200\3\2\2\2\u01ff"+
		"\u0201\5!\21\2\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0222\3\2"+
		"\2\2\u0202\u0203\5\27\f\2\u0203\u0205\5\37\20\2\u0204\u0206\5!\21\2\u0205"+
		"\u0204\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0222\3\2\2\2\u0207\u0208\5\27"+
		"\f\2\u0208\u0209\5!\21\2\u0209\u0222\3\2\2\2\u020a\u020b\7\62\2\2\u020b"+
		"\u020f\7z\2\2\u020c\u020d\7\62\2\2\u020d\u020f\7Z\2\2\u020e\u020a\3\2"+
		"\2\2\u020e\u020c\3\2\2\2\u020f\u0211\3\2\2\2\u0210\u0212\5\23\n\2\u0211"+
		"\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0217\3\2\2\2\u0213\u0215\7\60"+
		"\2\2\u0214\u0216\5\23\n\2\u0215\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"\u0218\3\2\2\2\u0217\u0213\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\3\2"+
		"\2\2\u0219\u021b\t\b\2\2\u021a\u021c\t\t\2\2\u021b\u021a\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021f\5\27\f\2\u021e\u0220\5"+
		"!\21\2\u021f\u021e\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0222\3\2\2\2\u0221"+
		"\u01ef\3\2\2\2\u0221\u01fa\3\2\2\2\u0221\u0202\3\2\2\2\u0221\u0207\3\2"+
		"\2\2\u0221\u020e\3\2\2\2\u0222\36\3\2\2\2\u0223\u0225\t\n\2\2\u0224\u0226"+
		"\t\13\2\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2"+
		"\u0227\u0228\5\27\f\2\u0228 \3\2\2\2\u0229\u022a\t\f\2\2\u022a\"\3\2\2"+
		"\2\u022b\u022e\7)\2\2\u022c\u022f\5\'\24\2\u022d\u022f\n\r\2\2\u022e\u022c"+
		"\3\2\2\2\u022e\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\7)\2\2\u0231"+
		"$\3\2\2\2\u0232\u0237\7$\2\2\u0233\u0236\5\'\24\2\u0234\u0236\n\16\2\2"+
		"\u0235\u0233\3\2\2\2\u0235\u0234\3\2\2\2\u0236\u0239\3\2\2\2\u0237\u0235"+
		"\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u023a\3\2\2\2\u0239\u0237\3\2\2\2\u023a"+
		"\u023b\7$\2\2\u023b&\3\2\2\2\u023c\u023d\7^\2\2\u023d\u0241\t\17\2\2\u023e"+
		"\u0241\5+\26\2\u023f\u0241\5)\25\2\u0240\u023c\3\2\2\2\u0240\u023e\3\2"+
		"\2\2\u0240\u023f\3\2\2\2\u0241(\3\2\2\2\u0242\u0243\7^\2\2\u0243\u0244"+
		"\4\62\65\2\u0244\u0245\4\629\2\u0245\u024c\4\629\2\u0246\u0247\7^\2\2"+
		"\u0247\u0248\4\629\2\u0248\u024c\4\629\2\u0249\u024a\7^\2\2\u024a\u024c"+
		"\4\629\2\u024b\u0242\3\2\2\2\u024b\u0246\3\2\2\2\u024b\u0249\3\2\2\2\u024c"+
		"*\3\2\2\2\u024d\u024e\7^\2\2\u024e\u024f\7w\2\2\u024f\u0250\5\25\13\2"+
		"\u0250\u0251\5\25\13\2\u0251\u0252\5\25\13\2\u0252\u0253\5\25\13\2\u0253"+
		",\3\2\2\2\u0254\u0259\5/\30\2\u0255\u0258\5/\30\2\u0256\u0258\5\61\31"+
		"\2\u0257\u0255\3\2\2\2\u0257\u0256\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u0257"+
		"\3\2\2\2\u0259\u025a\3\2\2\2\u025a.\3\2\2\2\u025b\u0259\3\2\2\2\u025c"+
		"\u025d\t\20\2\2\u025d\60\3\2\2\2\u025e\u025f\t\21\2\2\u025f\62\3\2\2\2"+
		"\u0260\u0262\t\22\2\2\u0261\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0261"+
		"\3\2\2\2\u0263\u0264\3\2\2\2\u0264\64\3\2\2\2\u0265\u0266\7\61\2\2\u0266"+
		"\u0267\7,\2\2\u0267\u0268\7>\2\2\u0268\u026c\3\2\2\2\u0269\u026b\13\2"+
		"\2\2\u026a\u0269\3\2\2\2\u026b\u026e\3\2\2\2\u026c\u026d\3\2\2\2\u026c"+
		"\u026a\3\2\2\2\u026d\u026f\3\2\2\2\u026e\u026c\3\2\2\2\u026f\u0270\7@"+
		"\2\2\u0270\u0271\7,\2\2\u0271\u0272\7\61\2\2\u0272\66\3\2\2\2\u0273\u0274"+
		"\7\61\2\2\u0274\u0275\7\61\2\2\u0275\u0276\7]\2\2\u0276\u0277\7%\2\2\u0277"+
		"\u027b\3\2\2\2\u0278\u027a\n\23\2\2\u0279\u0278\3\2\2\2\u027a\u027d\3"+
		"\2\2\2\u027b\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027e\3\2\2\2\u027d"+
		"\u027b\3\2\2\2\u027e\u027f\7_\2\2\u027f8\3\2\2\2\u0280\u0281\7\61\2\2"+
		"\u0281\u0282\7\61\2\2\u0282\u0283\7]\2\2\u0283\u0284\7\61\2\2\u0284\u0285"+
		"\7%\2\2\u0285\u0289\3\2\2\2\u0286\u0288\n\24\2\2\u0287\u0286\3\2\2\2\u0288"+
		"\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c\3\2"+
		"\2\2\u028b\u0289\3\2\2\2\u028c\u028d\7_\2\2\u028d:\3\2\2\2\u028e\u028f"+
		"\7\61\2\2\u028f\u0290\7,\2\2\u0290\u0291\7,\2\2\u0291\u0295\3\2\2\2\u0292"+
		"\u0294\13\2\2\2\u0293\u0292\3\2\2\2\u0294\u0297\3\2\2\2\u0295\u0296\3"+
		"\2\2\2\u0295\u0293\3\2\2\2\u0296\u0298\3\2\2\2\u0297\u0295\3\2\2\2\u0298"+
		"\u0299\7,\2\2\u0299\u029a\7\61\2\2\u029a<\3\2\2\2\u029b\u029c\7\61\2\2"+
		"\u029c\u029d\7,\2\2\u029d\u02a1\3\2\2\2\u029e\u02a0\13\2\2\2\u029f\u029e"+
		"\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a1\u029f\3\2\2\2\u02a2"+
		"\u02a4\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a5\7,\2\2\u02a5\u02a6\7\61"+
		"\2\2\u02a6>\3\2\2\2\u02a7\u02a8\7\61\2\2\u02a8\u02a9\7\61\2\2\u02a9\u02ad"+
		"\3\2\2\2\u02aa\u02ac\n\25\2\2\u02ab\u02aa\3\2\2\2\u02ac\u02af\3\2\2\2"+
		"\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae@\3\2\2\2\u02af\u02ad\3"+
		"\2\2\2\60\2\u018b\u0195\u019c\u01a2\u01a5\u01a8\u01ae\u01b4\u01b7\u01bf"+
		"\u01c5\u01c9\u01d1\u01d7\u01dc\u01e2\u01e8\u01f2\u01f5\u01f8\u01fd\u0200"+
		"\u0205\u020e\u0211\u0215\u0217\u021b\u021f\u0221\u0225\u022e\u0235\u0237"+
		"\u0240\u024b\u0257\u0259\u0263\u026c\u027b\u0289\u0295\u02a1\u02ad";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}