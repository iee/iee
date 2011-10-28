package org.eclipse.iee.translator.jmole.math.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.iee.translator.jmole.math.services.MathGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMathParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_MATH_NAME", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", "'.'", "'E'", "'e'", "','", "'='"
    };
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_MATH_NAME=6;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalMathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMathParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private MathGrammarAccess grammarAccess;
     	
        public InternalMathParser(TokenStream input, MathGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statement";	
       	}
       	
       	@Override
       	protected MathGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStatement"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:73:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:74:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:75:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement81);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:82:1: ruleStatement returns [EObject current=null] : ( ( (lv_functionDefenition_0_0= ruleFunctionDefinition ) ) | ( (lv_formula_1_0= ruleFormula ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_functionDefenition_0_0 = null;

        EObject lv_formula_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:85:28: ( ( ( (lv_functionDefenition_0_0= ruleFunctionDefinition ) ) | ( (lv_formula_1_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( ( (lv_functionDefenition_0_0= ruleFunctionDefinition ) ) | ( (lv_formula_1_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( ( (lv_functionDefenition_0_0= ruleFunctionDefinition ) ) | ( (lv_formula_1_0= ruleFormula ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_MATH_NAME) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==17) ) {
                    switch ( input.LA(3) ) {
                    case RULE_MATH_NAME:
                        {
                        int LA1_4 = input.LA(4);

                        if ( (LA1_4==17) ) {
                            alt1=2;
                        }
                        else if ( (LA1_4==18||LA1_4==22) ) {
                            alt1=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 18:
                        {
                        int LA1_5 = input.LA(4);

                        if ( (LA1_5==23) ) {
                            alt1=1;
                        }
                        else if ( (LA1_5==EOF||(LA1_5>=12 && LA1_5<=16)) ) {
                            alt1=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case RULE_INT:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 19:
                        {
                        alt1=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 3, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==EOF||(LA1_0>=RULE_ID && LA1_0<=RULE_INT)||(LA1_0>=12 && LA1_0<=17)||LA1_0==19) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:2: ( (lv_functionDefenition_0_0= ruleFunctionDefinition ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:2: ( (lv_functionDefenition_0_0= ruleFunctionDefinition ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_functionDefenition_0_0= ruleFunctionDefinition )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_functionDefenition_0_0= ruleFunctionDefinition )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:88:3: lv_functionDefenition_0_0= ruleFunctionDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getFunctionDefenitionFunctionDefinitionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunctionDefinition_in_ruleStatement137);
                    lv_functionDefenition_0_0=ruleFunctionDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"functionDefenition",
                              		lv_functionDefenition_0_0, 
                              		"FunctionDefinition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_formula_1_0= ruleFormula ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_formula_1_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_formula_1_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_formula_1_0= ruleFormula )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:107:3: lv_formula_1_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getFormulaFormulaParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleStatement164);
                    lv_formula_1_0=ruleFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"formula",
                              		lv_formula_1_0, 
                              		"Formula");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleFormula"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:131:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:132:2: (iv_ruleFormula= ruleFormula EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:133:2: iv_ruleFormula= ruleFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleFormula_in_entryRuleFormula200);
            iv_ruleFormula=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormula210); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormula"


    // $ANTLR start "ruleFormula"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:140:1: ruleFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleAddition ) ) ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:28: ( ( (lv_expression_0_0= ruleAddition ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: ( (lv_expression_0_0= ruleAddition ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: ( (lv_expression_0_0= ruleAddition ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:145:1: (lv_expression_0_0= ruleAddition )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:145:1: (lv_expression_0_0= ruleAddition )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:146:3: lv_expression_0_0= ruleAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormulaAccess().getExpressionAdditionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleFormula255);
            lv_expression_0_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFormulaRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_0_0, 
                      		"Addition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormula"


    // $ANTLR start "entryRuleAddition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:170:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:171:2: (iv_ruleAddition= ruleAddition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:172:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition290);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition300); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:179:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:182:28: ( (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:183:1: (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:183:1: (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:184:2: this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition350);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:1: ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }
                else if ( (LA2_0==13) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:2: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:2: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:3: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:3: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:196:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleAddition375); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:208:1: ( (lv_right_3_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:209:1: (lv_right_3_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:209:1: (lv_right_3_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:210:3: lv_right_3_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition396);
            	    lv_right_3_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"Multiplication");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:227:6: ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:227:6: ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:227:7: () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:227:7: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:228:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleAddition428); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_1_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:240:1: ( (lv_right_6_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:241:1: (lv_right_6_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:241:1: (lv_right_6_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:242:3: lv_right_6_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition449);
            	    lv_right_6_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_6_0, 
            	              		"Multiplication");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:266:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:267:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:268:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication488);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication498); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:275:1: ruleMultiplication returns [EObject current=null] : (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject this_Power_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:278:28: ( (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:279:1: (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:279:1: (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:280:2: this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getPowerParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePower_in_ruleMultiplication548);
            this_Power_0=rulePower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Power_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:291:1: ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }
                else if ( (LA3_0==15) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:291:2: ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:291:2: ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:291:3: () otherlv_2= '*' ( (lv_right_3_0= rulePower ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:291:3: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:292:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMultiplication573); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:304:1: ( (lv_right_3_0= rulePower ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:305:1: (lv_right_3_0= rulePower )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:305:1: (lv_right_3_0= rulePower )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:306:3: lv_right_3_0= rulePower
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPowerParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePower_in_ruleMultiplication594);
            	    lv_right_3_0=rulePower();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"Power");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:323:6: ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:323:6: ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:323:7: () otherlv_5= '/' ( (lv_right_6_0= rulePower ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:323:7: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:324:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleMultiplication626); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_1_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:336:1: ( (lv_right_6_0= rulePower ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:337:1: (lv_right_6_0= rulePower )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:337:1: (lv_right_6_0= rulePower )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:338:3: lv_right_6_0= rulePower
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPowerParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePower_in_ruleMultiplication647);
            	    lv_right_6_0=rulePower();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_6_0, 
            	              		"Power");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePower"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:362:1: entryRulePower returns [EObject current=null] : iv_rulePower= rulePower EOF ;
    public final EObject entryRulePower() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePower = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:363:2: (iv_rulePower= rulePower EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:364:2: iv_rulePower= rulePower EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPowerRule()); 
            }
            pushFollow(FOLLOW_rulePower_in_entryRulePower686);
            iv_rulePower=rulePower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePower; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePower696); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePower"


    // $ANTLR start "rulePower"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:371:1: rulePower returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) ;
    public final EObject rulePower() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:374:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:375:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:375:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:376:2: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPowerAccess().getPrimaryParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimary_in_rulePower746);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:387:1: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:387:2: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:387:2: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:388:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getPowerAccess().getPowerLeftAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,16,FOLLOW_16_in_rulePower770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPowerAccess().getCircumflexAccentKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:400:1: ( (lv_right_3_0= rulePrimary ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:401:1: (lv_right_3_0= rulePrimary )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:401:1: (lv_right_3_0= rulePrimary )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:402:3: lv_right_3_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPowerAccess().getRightPrimaryParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimary_in_rulePower791);
                    lv_right_3_0=rulePrimary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPowerRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"Primary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePower"


    // $ANTLR start "entryRulePrimary"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:426:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:427:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:428:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary829);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary839); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:435:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;

        EObject lv_function_5_0 = null;

        EObject this_Addition_7 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:438:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:439:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:439:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case EOF:
            case RULE_INT:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
                {
                alt5=2;
                }
                break;
            case RULE_MATH_NAME:
                {
                alt5=3;
                }
                break;
            case 17:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:439:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:439:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:439:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:439:3: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:440:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getVariableAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:448:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:449:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:449:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:450:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimary894); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getPrimaryAccess().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:467:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:467:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:467:7: () ( (lv_value_3_0= ruleFloat ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:467:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:468:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getFloatAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:476:2: ( (lv_value_3_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:477:1: (lv_value_3_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:477:1: (lv_value_3_0= ruleFloat )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:478:3: lv_value_3_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getValueFloatParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary940);
                    lv_value_3_0=ruleFloat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"Float");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:495:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:495:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:495:7: () ( (lv_function_5_0= ruleFunction ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:495:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:496:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getFunctionAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:504:2: ( (lv_function_5_0= ruleFunction ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:505:1: (lv_function_5_0= ruleFunction )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:505:1: (lv_function_5_0= ruleFunction )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:506:3: lv_function_5_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getFunctionFunctionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_rulePrimary981);
                    lv_function_5_0=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"function",
                              		lv_function_5_0, 
                              		"Function");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:523:6: (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:523:6: (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:523:8: otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_rulePrimary1001); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getAdditionParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAddition_in_rulePrimary1026);
                    this_Addition_7=ruleAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Addition_7; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_8=(Token)match(input,18,FOLLOW_18_in_rulePrimary1037); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_3_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleFloat"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:551:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:552:2: (iv_ruleFloat= ruleFloat EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:553:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_ruleFloat_in_entryRuleFloat1075);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFloat1086); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:560:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )* (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:563:28: ( ( (this_INT_0= RULE_INT )* (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:564:1: ( (this_INT_0= RULE_INT )* (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:564:1: ( (this_INT_0= RULE_INT )* (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:564:2: (this_INT_0= RULE_INT )* (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:564:2: (this_INT_0= RULE_INT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_INT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:564:7: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1127); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_0, grammarAccess.getFloatAccess().getINTTerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:571:3: (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:572:2: kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleFloat1148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:577:1: (this_INT_2= RULE_INT )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_INT) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:577:6: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1164); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_INT_2);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_INT_2, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:584:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=20 && LA11_0<=21)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:584:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+
                            {
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:584:4: (kw= 'E' | kw= 'e' )
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0==20) ) {
                                alt8=1;
                            }
                            else if ( (LA8_0==21) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 0, input);

                                throw nvae;
                            }
                            switch (alt8) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:585:2: kw= 'E'
                                    {
                                    kw=(Token)match(input,20,FOLLOW_20_in_ruleFloat1186); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:592:2: kw= 'e'
                                    {
                                    kw=(Token)match(input,21,FOLLOW_21_in_ruleFloat1205); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:597:2: (kw= '-' )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0==13) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:598:2: kw= '-'
                                    {
                                    kw=(Token)match(input,13,FOLLOW_13_in_ruleFloat1220); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getHyphenMinusKeyword_1_2_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:603:3: (this_INT_6= RULE_INT )+
                            int cnt10=0;
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==RULE_INT) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:603:8: this_INT_6= RULE_INT
                            	    {
                            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1238); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      		current.merge(this_INT_6);
                            	          
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_INT_6, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_2_2()); 
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt10 >= 1 ) break loop10;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(10, input);
                                        throw eee;
                                }
                                cnt10++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleFunction"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:618:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:619:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:620:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction1289);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction1299); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:627:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( (lv_formula_2_0= ruleFormula ) ) otherlv_3= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_formula_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:630:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( (lv_formula_2_0= ruleFormula ) ) otherlv_3= ')' ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:631:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( (lv_formula_2_0= ruleFormula ) ) otherlv_3= ')' )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:631:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( (lv_formula_2_0= ruleFormula ) ) otherlv_3= ')' )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:631:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( (lv_formula_2_0= ruleFormula ) ) otherlv_3= ')'
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:631:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:632:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:632:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:633:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunction1341); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFunctionAccess().getNameMATH_NAMETerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"MATH_NAME");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleFunction1358); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:653:1: ( (lv_formula_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:654:1: (lv_formula_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:654:1: (lv_formula_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:655:3: lv_formula_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionAccess().getFormulaFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleFunction1379);
            lv_formula_2_0=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"formula",
                      		lv_formula_2_0, 
                      		"Formula");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleFunction1391); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleFunctionDefinition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:683:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:684:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:685:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1427);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition1437); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefinition"


    // $ANTLR start "ruleFunctionDefinition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:692:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= RULE_MATH_NAME ) ) (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' otherlv_7= '=' ( (lv_formula_8_0= ruleFormula ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_parameters_2_0=null;
        Token otherlv_3=null;
        Token lv_parameters_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_formula_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:695:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= RULE_MATH_NAME ) ) (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' otherlv_7= '=' ( (lv_formula_8_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:696:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= RULE_MATH_NAME ) ) (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' otherlv_7= '=' ( (lv_formula_8_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:696:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= RULE_MATH_NAME ) ) (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' otherlv_7= '=' ( (lv_formula_8_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:696:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= RULE_MATH_NAME ) ) (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' otherlv_7= '=' ( (lv_formula_8_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:696:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:697:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:697:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:698:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunctionDefinition1479); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFunctionDefinitionAccess().getNameMATH_NAMETerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"MATH_NAME");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleFunctionDefinition1496); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:718:1: ( ( (lv_parameters_2_0= RULE_MATH_NAME ) ) (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )* (otherlv_5= ',' )? )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_MATH_NAME) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:718:2: ( (lv_parameters_2_0= RULE_MATH_NAME ) ) (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )* (otherlv_5= ',' )?
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:718:2: ( (lv_parameters_2_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:719:1: (lv_parameters_2_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:719:1: (lv_parameters_2_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:720:3: lv_parameters_2_0= RULE_MATH_NAME
                    {
                    lv_parameters_2_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunctionDefinition1514); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_parameters_2_0, grammarAccess.getFunctionDefinitionAccess().getParametersMATH_NAMETerminalRuleCall_2_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      	        }
                             		addWithLastConsumed(
                             			current, 
                             			"parameters",
                              		lv_parameters_2_0, 
                              		"MATH_NAME");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:736:2: (otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==22) ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==RULE_MATH_NAME) ) {
                                alt13=1;
                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:736:4: otherlv_3= ',' ( (lv_parameters_4_0= RULE_MATH_NAME ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleFunctionDefinition1532); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:740:1: ( (lv_parameters_4_0= RULE_MATH_NAME ) )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:741:1: (lv_parameters_4_0= RULE_MATH_NAME )
                    	    {
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:741:1: (lv_parameters_4_0= RULE_MATH_NAME )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:742:3: lv_parameters_4_0= RULE_MATH_NAME
                    	    {
                    	    lv_parameters_4_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunctionDefinition1549); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_parameters_4_0, grammarAccess.getFunctionDefinitionAccess().getParametersMATH_NAMETerminalRuleCall_2_1_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"parameters",
                    	              		lv_parameters_4_0, 
                    	              		"MATH_NAME");
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:758:4: (otherlv_5= ',' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==22) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:758:6: otherlv_5= ','
                            {
                            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleFunctionDefinition1569); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_2_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleFunctionDefinition1585); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleFunctionDefinition1597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionAccess().getEqualsSignKeyword_4());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:770:1: ( (lv_formula_8_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:771:1: (lv_formula_8_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:771:1: (lv_formula_8_0= ruleFormula )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:772:3: lv_formula_8_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleFunctionDefinition1618);
            lv_formula_8_0=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"formula",
                      		lv_formula_8_0, 
                      		"Formula");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefinition"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_ruleStatement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleStatement164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleFormula255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition350 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleAddition375 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition396 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_13_in_ruleAddition428 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition449 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePower_in_ruleMultiplication548 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_14_in_ruleMultiplication573 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_rulePower_in_ruleMultiplication594 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_15_in_ruleMultiplication626 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_rulePower_in_ruleMultiplication647 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_rulePower_in_entryRulePower686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePower696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_rulePower746 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_rulePower770 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_rulePrimary_in_rulePower791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimary894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rulePrimary981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rulePrimary1001 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_ruleAddition_in_rulePrimary1026 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePrimary1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_entryRuleFloat1075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFloat1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1127 = new BitSet(new long[]{0x0000000000080022L});
    public static final BitSet FOLLOW_19_in_ruleFloat1148 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1164 = new BitSet(new long[]{0x0000000000300022L});
    public static final BitSet FOLLOW_20_in_ruleFloat1186 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_21_in_ruleFloat1205 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_13_in_ruleFloat1220 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1238 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction1289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunction1341 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleFunction1358 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction1379 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFunction1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunctionDefinition1479 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionDefinition1496 = new BitSet(new long[]{0x0000000000040040L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunctionDefinition1514 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_22_in_ruleFunctionDefinition1532 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunctionDefinition1549 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_22_in_ruleFunctionDefinition1569 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFunctionDefinition1585 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleFunctionDefinition1597 = new BitSet(new long[]{0x00000000000A0070L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunctionDefinition1618 = new BitSet(new long[]{0x0000000000000002L});

}