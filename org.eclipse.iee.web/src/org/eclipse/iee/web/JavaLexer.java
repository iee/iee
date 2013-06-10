package org.eclipse.iee.web;

// Generated from /home/aefimchuk/git/iee/org.eclipse.iee.web/src/org/eclipse/iee/web/JavaLexer.g4 by ANTLR 4.0
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
		Identifier=11, Ws=12, Pad=13, Javadoc=14, Comment=15, LineComment=16;

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"Keyword", "Braces", "Delimiters", "HexLiteral", "DecimalLiteral", "OctalLiteral", 
		"BinaryLiteral", "FloatingPointLiteral", "CharacterLiteral", "StringLiteral", 
		"Identifier", "Ws", "Pad", "Javadoc", "Comment", "LineComment"
	};
	public static final String[] ruleNames = {
		"Keyword", "Braces", "Delimiters", "HexLiteral", "DecimalLiteral", "OctalLiteral", 
		"BinaryLiteral", "BinaryDigit", "HexDigits", "HexDigit", "Digits", "Digit", 
		"IntegerTypeSuffix", "FloatingPointLiteral", "Exponent", "FloatTypeSuffix", 
		"CharacterLiteral", "StringLiteral", "EscapeSequence", "OctalEscape", 
		"UnicodeEscape", "Identifier", "Letter", "JavaIDDigit", "Ws", "Pad", "Javadoc", 
		"Comment", "LineComment"
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
		"\2\4\22\u0291\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
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
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2"+
		"\u0188\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u0192\n\5\3\6\3\6\3\6\7"+
		"\6\u0197\n\6\f\6\16\6\u019a\13\6\3\6\7\6\u019d\n\6\f\6\16\6\u01a0\13\6"+
		"\5\6\u01a2\n\6\3\6\5\6\u01a5\n\6\3\7\3\7\7\7\u01a9\n\7\f\7\16\7\u01ac"+
		"\13\7\3\7\6\7\u01af\n\7\r\7\16\7\u01b0\3\7\5\7\u01b4\n\7\3\b\3\b\3\b\3"+
		"\b\7\b\u01ba\n\b\f\b\16\b\u01bd\13\b\3\b\7\b\u01c0\n\b\f\b\16\b\u01c3"+
		"\13\b\3\b\5\b\u01c6\n\b\3\t\3\t\3\n\3\n\7\n\u01cc\n\n\f\n\16\n\u01cf\13"+
		"\n\3\n\7\n\u01d2\n\n\f\n\16\n\u01d5\13\n\3\13\3\13\5\13\u01d9\n\13\3\f"+
		"\3\f\7\f\u01dd\n\f\f\f\16\f\u01e0\13\f\3\f\7\f\u01e3\n\f\f\f\16\f\u01e6"+
		"\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\5\17\u01ef\n\17\3\17\5\17\u01f2"+
		"\n\17\3\17\5\17\u01f5\n\17\3\17\3\17\3\17\5\17\u01fa\n\17\3\17\5\17\u01fd"+
		"\n\17\3\17\3\17\3\17\5\17\u0202\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u020b\n\17\3\17\5\17\u020e\n\17\3\17\3\17\5\17\u0212\n\17\5\17\u0214"+
		"\n\17\3\17\3\17\5\17\u0218\n\17\3\17\3\17\5\17\u021c\n\17\5\17\u021e\n"+
		"\17\3\20\3\20\5\20\u0222\n\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\5\22"+
		"\u022b\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u0232\n\23\f\23\16\23\u0235"+
		"\13\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u023d\n\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\5\25\u0248\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\7\27\u0254\n\27\f\27\16\27\u0257\13\27\3\30"+
		"\3\30\3\31\3\31\3\32\6\32\u025e\n\32\r\32\16\32\u025f\3\33\3\33\3\33\3"+
		"\33\3\33\7\33\u0267\n\33\f\33\16\33\u026a\13\33\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\7\34\u0275\n\34\f\34\16\34\u0278\13\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\7\35\u0281\n\35\f\35\16\35\u0284\13\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u028d\n\36\f\36\16\36\u0290\13"+
		"\36\5\u0268\u0276\u0282\37\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1"+
		"\21\2\1\23\2\1\25\2\1\27\2\1\31\2\1\33\2\1\35\n\1\37\2\1!\2\1#\13\1%\f"+
		"\1\'\2\1)\2\1+\2\1-\r\1/\2\1\61\2\1\63\16\1\65\17\1\67\20\19\21\1;\22"+
		"\1\3\2\24\7*+]]__}}\177\177\n##%%\'(,\61<A^^``~~\4ZZzz\4DDdd\4CHch\4N"+
		"Nnn\4RRrr\4--//\4GGgg\4--//\6FFHHffhh\4))^^\4$$^^\n$$))^^ddhhppttvv\16"+
		"&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa\u2001\u3042\u3191\u3302\u3381"+
		"\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21\62;\u0662\u066b\u06f2\u06fb\u0968"+
		"\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68"+
		"\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u1042\u104b\5\13"+
		"\f\16\17\"\"\4\f\f\17\17\u02e9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\35\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\3\u0187\3\2\2\2\5\u0189\3\2\2\2\7\u018b\3\2\2\2\t\u018d"+
		"\3\2\2\2\13\u01a1\3\2\2\2\r\u01a6\3\2\2\2\17\u01b5\3\2\2\2\21\u01c7\3"+
		"\2\2\2\23\u01c9\3\2\2\2\25\u01d8\3\2\2\2\27\u01da\3\2\2\2\31\u01e7\3\2"+
		"\2\2\33\u01e9\3\2\2\2\35\u021d\3\2\2\2\37\u021f\3\2\2\2!\u0225\3\2\2\2"+
		"#\u0227\3\2\2\2%\u022e\3\2\2\2\'\u023c\3\2\2\2)\u0247\3\2\2\2+\u0249\3"+
		"\2\2\2-\u0250\3\2\2\2/\u0258\3\2\2\2\61\u025a\3\2\2\2\63\u025d\3\2\2\2"+
		"\65\u0261\3\2\2\2\67\u026f\3\2\2\29\u027c\3\2\2\2;\u0288\3\2\2\2=>\7d"+
		"\2\2>?\7q\2\2?@\7q\2\2@A\7n\2\2AB\7g\2\2BC\7c\2\2C\u0188\7p\2\2DE\7d\2"+
		"\2EF\7{\2\2FG\7v\2\2G\u0188\7g\2\2HI\7e\2\2IJ\7j\2\2JK\7c\2\2K\u0188\7"+
		"t\2\2LM\7f\2\2MN\7q\2\2NO\7w\2\2OP\7d\2\2PQ\7n\2\2Q\u0188\7g\2\2RS\7h"+
		"\2\2ST\7n\2\2TU\7q\2\2UV\7c\2\2V\u0188\7v\2\2WX\7k\2\2XY\7p\2\2Y\u0188"+
		"\7v\2\2Z[\7n\2\2[\\\7q\2\2\\]\7p\2\2]\u0188\7i\2\2^_\7u\2\2_`\7j\2\2`"+
		"a\7q\2\2ab\7t\2\2b\u0188\7v\2\2cd\7x\2\2de\7q\2\2ef\7k\2\2f\u0188\7f\2"+
		"\2gh\7c\2\2hi\7u\2\2ij\7u\2\2jk\7g\2\2kl\7t\2\2l\u0188\7v\2\2mn\7c\2\2"+
		"no\7d\2\2op\7u\2\2pq\7v\2\2qr\7t\2\2rs\7c\2\2st\7e\2\2t\u0188\7v\2\2u"+
		"v\7f\2\2vw\7g\2\2wx\7h\2\2xy\7c\2\2yz\7w\2\2z{\7n\2\2{\u0188\7v\2\2|}"+
		"\7k\2\2}\u0188\7h\2\2~\177\7r\2\2\177\u0080\7t\2\2\u0080\u0081\7k\2\2"+
		"\u0081\u0082\7x\2\2\u0082\u0083\7c\2\2\u0083\u0084\7v\2\2\u0084\u0188"+
		"\7g\2\2\u0085\u0086\7v\2\2\u0086\u0087\7j\2\2\u0087\u0088\7k\2\2\u0088"+
		"\u0188\7u\2\2\u0089\u008a\7f\2\2\u008a\u0188\7q\2\2\u008b\u008c\7k\2\2"+
		"\u008c\u008d\7o\2\2\u008d\u008e\7r\2\2\u008e\u008f\7n\2\2\u008f\u0090"+
		"\7g\2\2\u0090\u0091\7o\2\2\u0091\u0092\7g\2\2\u0092\u0093\7p\2\2\u0093"+
		"\u0094\7v\2\2\u0094\u0188\7u\2\2\u0095\u0096\7r\2\2\u0096\u0097\7t\2\2"+
		"\u0097\u0098\7q\2\2\u0098\u0099\7v\2\2\u0099\u009a\7g\2\2\u009a\u009b"+
		"\7e\2\2\u009b\u009c\7v\2\2\u009c\u009d\7g\2\2\u009d\u0188\7f\2\2\u009e"+
		"\u009f\7v\2\2\u009f\u00a0\7j\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7q\2\2"+
		"\u00a2\u0188\7y\2\2\u00a3\u00a4\7d\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6"+
		"\7g\2\2\u00a6\u00a7\7c\2\2\u00a7\u0188\7m\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7o\2\2\u00aa\u00ab\7r\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7t\2\2"+
		"\u00ad\u0188\7v\2\2\u00ae\u00af\7r\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1"+
		"\7d\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7k\2\2\u00b3\u0188\7e\2\2\u00b4"+
		"\u00b5\7v\2\2\u00b5\u00b6\7j\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7q\2\2"+
		"\u00b8\u00b9\7y\2\2\u00b9\u0188\7u\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc"+
		"\7n\2\2\u00bc\u00bd\7u\2\2\u00bd\u0188\7g\2\2\u00be\u00bf\7k\2\2\u00bf"+
		"\u00c0\7p\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7c\2\2"+
		"\u00c3\u00c4\7p\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7"+
		"\7q\2\2\u00c7\u0188\7h\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"\u00cb\7v\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd\7t\2\2\u00cd\u0188\7p\2\2"+
		"\u00ce\u00cf\7v\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2"+
		"\7p\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00d6\7p\2\2\u00d6\u0188\7v\2\2\u00d7\u00d8\7e\2\2\u00d8\u00d9\7c\2\2"+
		"\u00d9\u00da\7u\2\2\u00da\u0188\7g\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd"+
		"\7z\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7p\2\2\u00e0"+
		"\u00e1\7f\2\2\u00e1\u0188\7u\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7t\2\2"+
		"\u00e4\u0188\7{\2\2\u00e5\u00e6\7e\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8"+
		"\7v\2\2\u00e8\u00e9\7e\2\2\u00e9\u0188\7j\2\2\u00ea\u00eb\7h\2\2\u00eb"+
		"\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee\7c\2\2\u00ee\u0188\7n\2\2"+
		"\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3"+
		"\7g\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7h\2\2\u00f5\u00f6\7c\2\2\u00f6"+
		"\u00f7\7e\2\2\u00f7\u0188\7g\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa\7v\2\2"+
		"\u00fa\u00fb\7c\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7k\2\2\u00fd\u0188"+
		"\7e\2\2\u00fe\u00ff\7h\2\2\u00ff\u0100\7k\2\2\u0100\u0101\7p\2\2\u0101"+
		"\u0102\7c\2\2\u0102\u0103\7n\2\2\u0103\u0104\7n\2\2\u0104\u0188\7{\2\2"+
		"\u0105\u0106\7u\2\2\u0106\u0107\7v\2\2\u0107\u0108\7t\2\2\u0108\u0109"+
		"\7k\2\2\u0109\u010a\7e\2\2\u010a\u010b\7v\2\2\u010b\u010c\7h\2\2\u010c"+
		"\u0188\7r\2\2\u010d\u010e\7x\2\2\u010e\u010f\7q\2\2\u010f\u0110\7n\2\2"+
		"\u0110\u0111\7c\2\2\u0111\u0112\7v\2\2\u0112\u0113\7k\2\2\u0113\u0114"+
		"\7n\2\2\u0114\u0188\7g\2\2\u0115\u0116\7e\2\2\u0116\u0117\7n\2\2\u0117"+
		"\u0118\7c\2\2\u0118\u0119\7u\2\2\u0119\u0188\7u\2\2\u011a\u011b\7p\2\2"+
		"\u011b\u011c\7c\2\2\u011c\u011d\7v\2\2\u011d\u011e\7k\2\2\u011e\u011f"+
		"\7x\2\2\u011f\u0188\7g\2\2\u0120\u0121\7u\2\2\u0121\u0122\7w\2\2\u0122"+
		"\u0123\7r\2\2\u0123\u0124\7g\2\2\u0124\u0188\7t\2\2\u0125\u0126\7y\2\2"+
		"\u0126\u0127\7j\2\2\u0127\u0128\7k\2\2\u0128\u0129\7n\2\2\u0129\u0188"+
		"\7g\2\2\u012a\u012b\7e\2\2\u012b\u012c\7q\2\2\u012c\u012d\7p\2\2\u012d"+
		"\u012e\7u\2\2\u012e\u0188\7v\2\2\u012f\u0130\7h\2\2\u0130\u0131\7q\2\2"+
		"\u0131\u0188\7t\2\2\u0132\u0133\7p\2\2\u0133\u0134\7g\2\2\u0134\u0188"+
		"\7y\2\2\u0135\u0136\7u\2\2\u0136\u0137\7v\2\2\u0137\u0138\7t\2\2\u0138"+
		"\u0139\7k\2\2\u0139\u013a\7e\2\2\u013a\u013b\7v\2\2\u013b\u013c\7h\2\2"+
		"\u013c\u0188\7r\2\2\u013d\u013e\7u\2\2\u013e\u013f\7y\2\2\u013f\u0140"+
		"\7k\2\2\u0140\u0141\7v\2\2\u0141\u0142\7e\2\2\u0142\u0188\7j\2\2\u0143"+
		"\u0144\7e\2\2\u0144\u0145\7q\2\2\u0145\u0146\7p\2\2\u0146\u0147\7v\2\2"+
		"\u0147\u0148\7k\2\2\u0148\u0149\7p\2\2\u0149\u014a\7w\2\2\u014a\u0188"+
		"\7g\2\2\u014b\u014c\7i\2\2\u014c\u014d\7q\2\2\u014d\u014e\7v\2\2\u014e"+
		"\u0188\7q\2\2\u014f\u0150\7r\2\2\u0150\u0151\7c\2\2\u0151\u0152\7e\2\2"+
		"\u0152\u0153\7m\2\2\u0153\u0154\7c\2\2\u0154\u0155\7i\2\2\u0155\u0188"+
		"\7g\2\2\u0156\u0157\7u\2\2\u0157\u0158\7{\2\2\u0158\u0159\7p\2\2\u0159"+
		"\u015a\7e\2\2\u015a\u015b\7j\2\2\u015b\u015c\7t\2\2\u015c\u015d\7q\2\2"+
		"\u015d\u015e\7p\2\2\u015e\u015f\7k\2\2\u015f\u0160\7|\2\2\u0160\u0161"+
		"\7g\2\2\u0161\u0188\7f\2\2\u0162\u0163\7v\2\2\u0163\u0164\7j\2\2\u0164"+
		"\u0165\7t\2\2\u0165\u0166\7g\2\2\u0166\u0167\7c\2\2\u0167\u0168\7f\2\2"+
		"\u0168\u0169\7u\2\2\u0169\u016a\7c\2\2\u016a\u016b\7h\2\2\u016b\u0188"+
		"\7g\2\2\u016c\u016d\7p\2\2\u016d\u016e\7w\2\2\u016e\u016f\7n\2\2\u016f"+
		"\u0188\7n\2\2\u0170\u0171\7v\2\2\u0171\u0172\7t\2\2\u0172\u0173\7w\2\2"+
		"\u0173\u0188\7g\2\2\u0174\u0175\7h\2\2\u0175\u0176\7c\2\2\u0176\u0177"+
		"\7n\2\2\u0177\u0178\7u\2\2\u0178\u0188\7g\2\2\u0179\u017a\7g\2\2\u017a"+
		"\u017b\7p\2\2\u017b\u017c\7w\2\2\u017c\u0188\7o\2\2\u017d\u017e\7B\2\2"+
		"\u017e\u017f\7k\2\2\u017f\u0180\7p\2\2\u0180\u0181\7v\2\2\u0181\u0182"+
		"\7g\2\2\u0182\u0183\7t\2\2\u0183\u0184\7h\2\2\u0184\u0185\7c\2\2\u0185"+
		"\u0186\7e\2\2\u0186\u0188\7g\2\2\u0187=\3\2\2\2\u0187D\3\2\2\2\u0187H"+
		"\3\2\2\2\u0187L\3\2\2\2\u0187R\3\2\2\2\u0187W\3\2\2\2\u0187Z\3\2\2\2\u0187"+
		"^\3\2\2\2\u0187c\3\2\2\2\u0187g\3\2\2\2\u0187m\3\2\2\2\u0187u\3\2\2\2"+
		"\u0187|\3\2\2\2\u0187~\3\2\2\2\u0187\u0085\3\2\2\2\u0187\u0089\3\2\2\2"+
		"\u0187\u008b\3\2\2\2\u0187\u0095\3\2\2\2\u0187\u009e\3\2\2\2\u0187\u00a3"+
		"\3\2\2\2\u0187\u00a8\3\2\2\2\u0187\u00ae\3\2\2\2\u0187\u00b4\3\2\2\2\u0187"+
		"\u00ba\3\2\2\2\u0187\u00be\3\2\2\2\u0187\u00c8\3\2\2\2\u0187\u00ce\3\2"+
		"\2\2\u0187\u00d7\3\2\2\2\u0187\u00db\3\2\2\2\u0187\u00e2\3\2\2\2\u0187"+
		"\u00e5\3\2\2\2\u0187\u00ea\3\2\2\2\u0187\u00ef\3\2\2\2\u0187\u00f8\3\2"+
		"\2\2\u0187\u00fe\3\2\2\2\u0187\u0105\3\2\2\2\u0187\u010d\3\2\2\2\u0187"+
		"\u0115\3\2\2\2\u0187\u011a\3\2\2\2\u0187\u0120\3\2\2\2\u0187\u0125\3\2"+
		"\2\2\u0187\u012a\3\2\2\2\u0187\u012f\3\2\2\2\u0187\u0132\3\2\2\2\u0187"+
		"\u0135\3\2\2\2\u0187\u013d\3\2\2\2\u0187\u0143\3\2\2\2\u0187\u014b\3\2"+
		"\2\2\u0187\u014f\3\2\2\2\u0187\u0156\3\2\2\2\u0187\u0162\3\2\2\2\u0187"+
		"\u016c\3\2\2\2\u0187\u0170\3\2\2\2\u0187\u0174\3\2\2\2\u0187\u0179\3\2"+
		"\2\2\u0187\u017d\3\2\2\2\u0188\4\3\2\2\2\u0189\u018a\t\2\2\2\u018a\6\3"+
		"\2\2\2\u018b\u018c\t\3\2\2\u018c\b\3\2\2\2\u018d\u018e\7\62\2\2\u018e"+
		"\u018f\t\4\2\2\u018f\u0191\5\23\n\2\u0190\u0192\5\33\16\2\u0191\u0190"+
		"\3\2\2\2\u0191\u0192\3\2\2\2\u0192\n\3\2\2\2\u0193\u01a2\7\62\2\2\u0194"+
		"\u019e\4\63;\2\u0195\u0197\7a\2\2\u0196\u0195\3\2\2\2\u0197\u019a\3\2"+
		"\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019b\3\2\2\2\u019a"+
		"\u0198\3\2\2\2\u019b\u019d\5\31\r\2\u019c\u0198\3\2\2\2\u019d\u01a0\3"+
		"\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0"+
		"\u019e\3\2\2\2\u01a1\u0193\3\2\2\2\u01a1\u0194\3\2\2\2\u01a2\u01a4\3\2"+
		"\2\2\u01a3\u01a5\5\33\16\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"\f\3\2\2\2\u01a6\u01ae\7\62\2\2\u01a7\u01a9\7a\2\2\u01a8\u01a7\3\2\2\2"+
		"\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ad"+
		"\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01af\4\629\2\u01ae\u01aa\3\2\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2"+
		"\2\2\u01b2\u01b4\5\33\16\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\16\3\2\2\2\u01b5\u01b6\7\62\2\2\u01b6\u01b7\t\5\2\2\u01b7\u01c1\5\21"+
		"\t\2\u01b8\u01ba\7a\2\2\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bb\3\2"+
		"\2\2\u01be\u01c0\5\21\t\2\u01bf\u01bb\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1"+
		"\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2"+
		"\2\2\u01c4\u01c6\5\33\16\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\20\3\2\2\2\u01c7\u01c8\4\62\63\2\u01c8\22\3\2\2\2\u01c9\u01d3\5\25\13"+
		"\2\u01ca\u01cc\7a\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd\u01cb"+
		"\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01cd\3\2\2\2\u01d0"+
		"\u01d2\5\25\13\2\u01d1\u01cd\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3"+
		"\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\24\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6"+
		"\u01d9\5\31\r\2\u01d7\u01d9\t\6\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d7\3"+
		"\2\2\2\u01d9\26\3\2\2\2\u01da\u01e4\5\31\r\2\u01db\u01dd\7a\2\2\u01dc"+
		"\u01db\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2"+
		"\2\2\u01df\u01e1\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e3\5\31\r\2\u01e2"+
		"\u01de\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2"+
		"\2\2\u01e5\30\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e8\4\62;\2\u01e8\32"+
		"\3\2\2\2\u01e9\u01ea\t\7\2\2\u01ea\34\3\2\2\2\u01eb\u01ec\5\27\f\2\u01ec"+
		"\u01ee\7\60\2\2\u01ed\u01ef\5\27\f\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef\3"+
		"\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01f2\5\37\20\2\u01f1\u01f0\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f5\5!\21\2\u01f4\u01f3\3\2"+
		"\2\2\u01f4\u01f5\3\2\2\2\u01f5\u021e\3\2\2\2\u01f6\u01f7\7\60\2\2\u01f7"+
		"\u01f9\5\27\f\2\u01f8\u01fa\5\37\20\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa"+
		"\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01fd\5!\21\2\u01fc\u01fb\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u021e\3\2\2\2\u01fe\u01ff\5\27\f\2\u01ff\u0201\5"+
		"\37\20\2\u0200\u0202\5!\21\2\u0201\u0200\3\2\2\2\u0201\u0202\3\2\2\2\u0202"+
		"\u021e\3\2\2\2\u0203\u0204\5\27\f\2\u0204\u0205\5!\21\2\u0205\u021e\3"+
		"\2\2\2\u0206\u0207\7\62\2\2\u0207\u020b\7z\2\2\u0208\u0209\7\62\2\2\u0209"+
		"\u020b\7Z\2\2\u020a\u0206\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u020d\3\2"+
		"\2\2\u020c\u020e\5\23\n\2\u020d\u020c\3\2\2\2\u020d\u020e\3\2\2\2\u020e"+
		"\u0213\3\2\2\2\u020f\u0211\7\60\2\2\u0210\u0212\5\23\n\2\u0211\u0210\3"+
		"\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214\3\2\2\2\u0213\u020f\3\2\2\2\u0213"+
		"\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\t\b\2\2\u0216\u0218\t\t"+
		"\2\2\u0217\u0216\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\3\2\2\2\u0219"+
		"\u021b\5\27\f\2\u021a\u021c\5!\21\2\u021b\u021a\3\2\2\2\u021b\u021c\3"+
		"\2\2\2\u021c\u021e\3\2\2\2\u021d\u01eb\3\2\2\2\u021d\u01f6\3\2\2\2\u021d"+
		"\u01fe\3\2\2\2\u021d\u0203\3\2\2\2\u021d\u020a\3\2\2\2\u021e\36\3\2\2"+
		"\2\u021f\u0221\t\n\2\2\u0220\u0222\t\13\2\2\u0221\u0220\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224\5\27\f\2\u0224 \3\2\2\2"+
		"\u0225\u0226\t\f\2\2\u0226\"\3\2\2\2\u0227\u022a\7)\2\2\u0228\u022b\5"+
		"\'\24\2\u0229\u022b\n\r\2\2\u022a\u0228\3\2\2\2\u022a\u0229\3\2\2\2\u022b"+
		"\u022c\3\2\2\2\u022c\u022d\7)\2\2\u022d$\3\2\2\2\u022e\u0233\7$\2\2\u022f"+
		"\u0232\5\'\24\2\u0230\u0232\n\16\2\2\u0231\u022f\3\2\2\2\u0231\u0230\3"+
		"\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234"+
		"\u0236\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u0237\7$\2\2\u0237&\3\2\2\2\u0238"+
		"\u0239\7^\2\2\u0239\u023d\t\17\2\2\u023a\u023d\5+\26\2\u023b\u023d\5)"+
		"\25\2\u023c\u0238\3\2\2\2\u023c\u023a\3\2\2\2\u023c\u023b\3\2\2\2\u023d"+
		"(\3\2\2\2\u023e\u023f\7^\2\2\u023f\u0240\4\62\65\2\u0240\u0241\4\629\2"+
		"\u0241\u0248\4\629\2\u0242\u0243\7^\2\2\u0243\u0244\4\629\2\u0244\u0248"+
		"\4\629\2\u0245\u0246\7^\2\2\u0246\u0248\4\629\2\u0247\u023e\3\2\2\2\u0247"+
		"\u0242\3\2\2\2\u0247\u0245\3\2\2\2\u0248*\3\2\2\2\u0249\u024a\7^\2\2\u024a"+
		"\u024b\7w\2\2\u024b\u024c\5\25\13\2\u024c\u024d\5\25\13\2\u024d\u024e"+
		"\5\25\13\2\u024e\u024f\5\25\13\2\u024f,\3\2\2\2\u0250\u0255\5/\30\2\u0251"+
		"\u0254\5/\30\2\u0252\u0254\5\61\31\2\u0253\u0251\3\2\2\2\u0253\u0252\3"+
		"\2\2\2\u0254\u0257\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256"+
		".\3\2\2\2\u0257\u0255\3\2\2\2\u0258\u0259\t\20\2\2\u0259\60\3\2\2\2\u025a"+
		"\u025b\t\21\2\2\u025b\62\3\2\2\2\u025c\u025e\t\22\2\2\u025d\u025c\3\2"+
		"\2\2\u025e\u025f\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260"+
		"\64\3\2\2\2\u0261\u0262\7\61\2\2\u0262\u0263\7,\2\2\u0263\u0264\7>\2\2"+
		"\u0264\u0268\3\2\2\2\u0265\u0267\13\2\2\2\u0266\u0265\3\2\2\2\u0267\u026a"+
		"\3\2\2\2\u0268\u0269\3\2\2\2\u0268\u0266\3\2\2\2\u0269\u026b\3\2\2\2\u026a"+
		"\u0268\3\2\2\2\u026b\u026c\7@\2\2\u026c\u026d\7,\2\2\u026d\u026e\7\61"+
		"\2\2\u026e\66\3\2\2\2\u026f\u0270\7\61\2\2\u0270\u0271\7,\2\2\u0271\u0272"+
		"\7,\2\2\u0272\u0276\3\2\2\2\u0273\u0275\13\2\2\2\u0274\u0273\3\2\2\2\u0275"+
		"\u0278\3\2\2\2\u0276\u0277\3\2\2\2\u0276\u0274\3\2\2\2\u0277\u0279\3\2"+
		"\2\2\u0278\u0276\3\2\2\2\u0279\u027a\7,\2\2\u027a\u027b\7\61\2\2\u027b"+
		"8\3\2\2\2\u027c\u027d\7\61\2\2\u027d\u027e\7,\2\2\u027e\u0282\3\2\2\2"+
		"\u027f\u0281\13\2\2\2\u0280\u027f\3\2\2\2\u0281\u0284\3\2\2\2\u0282\u0283"+
		"\3\2\2\2\u0282\u0280\3\2\2\2\u0283\u0285\3\2\2\2\u0284\u0282\3\2\2\2\u0285"+
		"\u0286\7,\2\2\u0286\u0287\7\61\2\2\u0287:\3\2\2\2\u0288\u0289\7\61\2\2"+
		"\u0289\u028a\7\61\2\2\u028a\u028e\3\2\2\2\u028b\u028d\n\23\2\2\u028c\u028b"+
		"\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f"+
		"<\3\2\2\2\u0290\u028e\3\2\2\2.\2\u0187\u0191\u0198\u019e\u01a1\u01a4\u01aa"+
		"\u01b0\u01b3\u01bb\u01c1\u01c5\u01cd\u01d3\u01d8\u01de\u01e4\u01ee\u01f1"+
		"\u01f4\u01f9\u01fc\u0201\u020a\u020d\u0211\u0213\u0217\u021b\u021d\u0221"+
		"\u022a\u0231\u0233\u023c\u0247\u0253\u0255\u025f\u0268\u0276\u0282\u028e";

	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}