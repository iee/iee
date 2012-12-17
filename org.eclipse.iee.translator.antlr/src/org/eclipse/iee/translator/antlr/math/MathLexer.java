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
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		MATH_NAME=25, INT=26, WS=27, FLOAT=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'%'", "']'", "'^'", "')'", "'.'", "','", "'+'", "'^T'", "'*'", "'-'", 
		"'['", "'('", "'<'", "'='", "'!='", "'<='", "'&&'", "'||'", "'>'", "'{'", 
		"'/'", "'=='", "'>='", "'}'", "MATH_NAME", "INT", "WS", "FLOAT"
	};
	public static final String[] ruleNames = {
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "MATH_NAME", 
		"INT", "WS", "FLOAT", "DIGIT", "EXP"
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
		case 0: T__23_action((RuleContext)_localctx, actionIndex); break;
		case 1: T__22_action((RuleContext)_localctx, actionIndex); break;
		case 2: T__21_action((RuleContext)_localctx, actionIndex); break;
		case 3: T__20_action((RuleContext)_localctx, actionIndex); break;
		case 4: T__19_action((RuleContext)_localctx, actionIndex); break;
		case 5: T__18_action((RuleContext)_localctx, actionIndex); break;
		case 6: T__17_action((RuleContext)_localctx, actionIndex); break;
		case 7: T__16_action((RuleContext)_localctx, actionIndex); break;
		case 8: T__15_action((RuleContext)_localctx, actionIndex); break;
		case 9: T__14_action((RuleContext)_localctx, actionIndex); break;
		case 10: T__13_action((RuleContext)_localctx, actionIndex); break;
		case 11: T__12_action((RuleContext)_localctx, actionIndex); break;
		case 12: T__11_action((RuleContext)_localctx, actionIndex); break;
		case 13: T__10_action((RuleContext)_localctx, actionIndex); break;
		case 14: T__9_action((RuleContext)_localctx, actionIndex); break;
		case 15: T__8_action((RuleContext)_localctx, actionIndex); break;
		case 16: T__7_action((RuleContext)_localctx, actionIndex); break;
		case 17: T__6_action((RuleContext)_localctx, actionIndex); break;
		case 18: T__5_action((RuleContext)_localctx, actionIndex); break;
		case 19: T__4_action((RuleContext)_localctx, actionIndex); break;
		case 20: T__3_action((RuleContext)_localctx, actionIndex); break;
		case 21: T__2_action((RuleContext)_localctx, actionIndex); break;
		case 22: T__1_action((RuleContext)_localctx, actionIndex); break;
		case 23: T__0_action((RuleContext)_localctx, actionIndex); break;
		case 24: MATH_NAME_action((RuleContext)_localctx, actionIndex); break;
		case 25: INT_action((RuleContext)_localctx, actionIndex); break;
		case 26: WS_action((RuleContext)_localctx, actionIndex); break;
		case 27: FLOAT_action((RuleContext)_localctx, actionIndex); break;
		case 28: DIGIT_action((RuleContext)_localctx, actionIndex); break;
		case 29: EXP_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	public void T__23_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__22_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__21_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__20_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void FLOAT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void INT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__9_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__8_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__7_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void MATH_NAME_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__6_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__5_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__4_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__19_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	public void T__16_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__15_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__18_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__17_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void EXP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__12_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__11_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__14_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__13_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__0_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__10_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void T__2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	public void DIGIT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}

	public static final String _serializedATN =
		"\2\34\u00ba\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2"+
		"\6\7\6\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\2\f\7\f\2\r\7\r\2\16"+
		"\7\16\2\17\7\17\2\20\7\20\2\21\7\21\2\22\7\22\2\23\7\23\2\24\7\24\2\25"+
		"\7\25\2\26\7\26\2\27\7\27\2\30\7\30\2\31\7\31\2\32\7\32\2\33\7\33\2\34"+
		"\7\34\2\35\7\35\1\0\1\0\1\1\1\1\1\2\1\2\1\3\1\3\1\4\1\4\1\5\1\5\1\6\1"+
		"\6\1\7\1\7\1\7\1\b\1\b\1\t\1\t\1\n\1\n\1\13\1\13\1\f\1\f\1\r\1\r\1\16"+
		"\1\16\1\16\1\17\1\17\1\17\1\20\1\20\1\20\1\21\1\21\1\21\1\22\1\22\1\23"+
		"\1\23\1\24\1\24\1\25\1\25\1\25\1\26\1\26\1\26\1\27\1\27\1\30\1\30\5\30"+
		"w\b\30\n\30\f\30z\t\30\1\31\4\31}\b\31\13\31\f\31~\1\31\3\31\u0082\b\31"+
		"\1\32\1\32\1\32\1\32\1\33\4\33\u0089\b\33\13\33\f\33\u008a\1\33\1\33\5"+
		"\33\u008f\b\33\n\33\f\33\u0092\t\33\1\33\3\33\u0095\b\33\1\33\3\33\u0098"+
		"\b\33\1\33\4\33\u009b\b\33\13\33\f\33\u009c\1\33\3\33\u00a0\b\33\1\33"+
		"\3\33\u00a3\b\33\1\33\1\33\4\33\u00a7\b\33\13\33\f\33\u00a8\1\33\3\33"+
		"\u00ac\b\33\1\33\3\33\u00af\b\33\3\33\u00b1\b\33\1\34\1\34\1\35\1\35\3"+
		"\35\u00b7\b\35\1\35\1\35\36\1\1\uffff\3\2\uffff\5\3\uffff\7\4\uffff\t"+
		"\5\uffff\13\6\uffff\r\7\uffff\17\b\uffff\21\t\uffff\23\n\uffff\25\13\uffff"+
		"\27\f\uffff\31\r\uffff\33\16\uffff\35\17\uffff\37\20\uffff!\21\uffff#"+
		"\22\uffff%\23\uffff\'\24\uffff)\25\uffff+\26\uffff-\27\uffff/\30\uffff"+
		"\61\31\uffff\63\32\uffff\65\33\0\67\34\uffff9\0\uffff;\0\uffff\1\0\t\3"+
		"AZ__az\4\609AZ__az\2LLll\3\t\n\r\r  \2LLll\2LLll\2LLll\2EEee\2++--\u00c7"+
		"\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0\0\0\0\7\1\0\0\0\0\t\1\0\0\0\0\13\1\0"+
		"\0\0\0\r\1\0\0\0\0\17\1\0\0\0\0\21\1\0\0\0\0\23\1\0\0\0\0\25\1\0\0\0\0"+
		"\27\1\0\0\0\0\31\1\0\0\0\0\33\1\0\0\0\0\35\1\0\0\0\0\37\1\0\0\0\0!\1\0"+
		"\0\0\0#\1\0\0\0\0%\1\0\0\0\0\'\1\0\0\0\0)\1\0\0\0\0+\1\0\0\0\0-\1\0\0"+
		"\0\0/\1\0\0\0\0\61\1\0\0\0\0\63\1\0\0\0\0\65\1\0\0\0\0\67\1\0\0\0\1=\1"+
		"\0\0\0\3?\1\0\0\0\5A\1\0\0\0\7C\1\0\0\0\tE\1\0\0\0\13G\1\0\0\0\rI\1\0"+
		"\0\0\17K\1\0\0\0\21N\1\0\0\0\23P\1\0\0\0\25R\1\0\0\0\27T\1\0\0\0\31V\1"+
		"\0\0\0\33X\1\0\0\0\35Z\1\0\0\0\37]\1\0\0\0!`\1\0\0\0#c\1\0\0\0%f\1\0\0"+
		"\0\'h\1\0\0\0)j\1\0\0\0+l\1\0\0\0-o\1\0\0\0/r\1\0\0\0\61t\1\0\0\0\63|"+
		"\1\0\0\0\65\u0083\1\0\0\0\67\u00b0\1\0\0\09\u00b2\1\0\0\0;\u00b4\1\0\0"+
		"\0=>\5%\0\0>\2\1\0\0\0?@\5]\0\0@\4\1\0\0\0AB\5^\0\0B\6\1\0\0\0CD\5)\0"+
		"\0D\b\1\0\0\0EF\5.\0\0F\n\1\0\0\0GH\5,\0\0H\f\1\0\0\0IJ\5+\0\0J\16\1\0"+
		"\0\0KL\5^\0\0LM\5T\0\0M\20\1\0\0\0NO\5*\0\0O\22\1\0\0\0PQ\5-\0\0Q\24\1"+
		"\0\0\0RS\5[\0\0S\26\1\0\0\0TU\5(\0\0U\30\1\0\0\0VW\5<\0\0W\32\1\0\0\0"+
		"XY\5=\0\0Y\34\1\0\0\0Z[\5!\0\0[\\\5=\0\0\\\36\1\0\0\0]^\5<\0\0^_\5=\0"+
		"\0_ \1\0\0\0`a\5&\0\0ab\5&\0\0b\"\1\0\0\0cd\5|\0\0de\5|\0\0e$\1\0\0\0"+
		"fg\5>\0\0g&\1\0\0\0hi\5{\0\0i(\1\0\0\0jk\5/\0\0k*\1\0\0\0lm\5=\0\0mn\5"+
		"=\0\0n,\1\0\0\0op\5>\0\0pq\5=\0\0q.\1\0\0\0rs\5}\0\0s\60\1\0\0\0tx\7\0"+
		"\0\0uw\7\1\0\0vu\1\0\0\0wz\1\0\0\0xv\1\0\0\0xy\1\0\0\0y\62\1\0\0\0zx\1"+
		"\0\0\0{}\39\34\0|{\1\0\0\0}~\1\0\0\0~|\1\0\0\0~\177\1\0\0\0\177\u0081"+
		"\1\0\0\0\u0080\u0082\7\2\0\0\u0081\u0080\1\0\0\0\u0081\u0082\1\0\0\0\u0082"+
		"\64\1\0\0\0\u0083\u0084\7\3\0\0\u0084\u0085\1\0\0\0\u0085\u0086\6\32\0"+
		"\0\u0086\66\1\0\0\0\u0087\u0089\39\34\0\u0088\u0087\1\0\0\0\u0089\u008a"+
		"\1\0\0\0\u008a\u0088\1\0\0\0\u008a\u008b\1\0\0\0\u008b\u008c\1\0\0\0\u008c"+
		"\u0090\5.\0\0\u008d\u008f\39\34\0\u008e\u008d\1\0\0\0\u008f\u0092\1\0"+
		"\0\0\u0090\u008e\1\0\0\0\u0090\u0091\1\0\0\0\u0091\u0094\1\0\0\0\u0092"+
		"\u0090\1\0\0\0\u0093\u0095\3;\35\0\u0094\u0093\1\0\0\0\u0094\u0095\1\0"+
		"\0\0\u0095\u0097\1\0\0\0\u0096\u0098\7\4\0\0\u0097\u0096\1\0\0\0\u0097"+
		"\u0098\1\0\0\0\u0098\u00b1\1\0\0\0\u0099\u009b\39\34\0\u009a\u0099\1\0"+
		"\0\0\u009b\u009c\1\0\0\0\u009c\u009a\1\0\0\0\u009c\u009d\1\0\0\0\u009d"+
		"\u009f\1\0\0\0\u009e\u00a0\3;\35\0\u009f\u009e\1\0\0\0\u009f\u00a0\1\0"+
		"\0\0\u00a0\u00a2\1\0\0\0\u00a1\u00a3\7\5\0\0\u00a2\u00a1\1\0\0\0\u00a2"+
		"\u00a3\1\0\0\0\u00a3\u00b1\1\0\0\0\u00a4\u00a6\5.\0\0\u00a5\u00a7\39\34"+
		"\0\u00a6\u00a5\1\0\0\0\u00a7\u00a8\1\0\0\0\u00a8\u00a6\1\0\0\0\u00a8\u00a9"+
		"\1\0\0\0\u00a9\u00ab\1\0\0\0\u00aa\u00ac\3;\35\0\u00ab\u00aa\1\0\0\0\u00ab"+
		"\u00ac\1\0\0\0\u00ac\u00ae\1\0\0\0\u00ad\u00af\7\6\0\0\u00ae\u00ad\1\0"+
		"\0\0\u00ae\u00af\1\0\0\0\u00af\u00b1\1\0\0\0\u00b0\u0088\1\0\0\0\u00b0"+
		"\u009a\1\0\0\0\u00b0\u00a4\1\0\0\0\u00b18\1\0\0\0\u00b2\u00b3\2\609\0"+
		"\u00b3:\1\0\0\0\u00b4\u00b6\7\7\0\0\u00b5\u00b7\7\b\0\0\u00b6\u00b5\1"+
		"\0\0\0\u00b6\u00b7\1\0\0\0\u00b7\u00b8\1\0\0\0\u00b8\u00b9\3\63\31\0\u00b9"+
		"<\1\0\0\0\20\0x~\u0081\u008a\u0090\u0094\u0097\u009c\u009f\u00a2\u00a8"+
		"\u00ab\u00ae\u00b0\u00b6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
	    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}