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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'*'", "'^'", "'('", "')'", "'1'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

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
        	return "Formula";	
       	}
       	
       	@Override
       	protected MathGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFormula"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:73:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:74:2: (iv_ruleFormula= ruleFormula EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:75:2: iv_ruleFormula= ruleFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleFormula_in_entryRuleFormula81);
            iv_ruleFormula=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormula91); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:82:1: ruleFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:85:28: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:88:3: lv_expression_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormulaAccess().getExpressionExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleFormula136);
            lv_expression_0_0=ruleExpression();

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
                      		"Expression");
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


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:112:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:113:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:114:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression171);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression181); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:121:1: ruleExpression returns [EObject current=null] : ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) ) | this_PrimaryExpression_12= rulePrimaryExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;

        EObject this_PrimaryExpression_4 = null;

        EObject lv_right_7_0 = null;

        EObject this_PrimaryExpression_8 = null;

        EObject lv_power_11_0 = null;

        EObject this_PrimaryExpression_12 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:28: ( ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) ) | this_PrimaryExpression_12= rulePrimaryExpression ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) ) | this_PrimaryExpression_12= rulePrimaryExpression )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) ) | this_PrimaryExpression_12= rulePrimaryExpression )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1_InternalMath()) ) {
                    alt1=1;
                }
                else if ( (synpred2_InternalMath()) ) {
                    alt1=2;
                }
                else if ( (synpred3_InternalMath()) ) {
                    alt1=3;
                }
                else if ( (true) ) {
                    alt1=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==16) ) {
                int LA1_2 = input.LA(2);

                if ( (synpred1_InternalMath()) ) {
                    alt1=1;
                }
                else if ( (synpred2_InternalMath()) ) {
                    alt1=2;
                }
                else if ( (synpred3_InternalMath()) ) {
                    alt1=3;
                }
                else if ( (true) ) {
                    alt1=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:2: (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:2: (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:126:2: this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryExpressionParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleExpression232);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:137:1: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:138:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExpressionAccess().getPlusLeftAction_0_1(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleExpression255); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getPlusSignKeyword_0_2());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:150:1: ( (lv_right_3_0= ruleExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:151:1: (lv_right_3_0= ruleExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:151:1: (lv_right_3_0= ruleExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:152:3: lv_right_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpression276);
                    lv_right_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:170:2: this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleExpression309);
                    this_PrimaryExpression_4=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:181:1: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:182:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExpressionAccess().getMultLeftAction_1_1(),
                                  current);
                          
                    }

                    }

                    otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleExpression332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getExpressionAccess().getAsteriskKeyword_1_2());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:194:1: ( (lv_right_7_0= ruleExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:1: (lv_right_7_0= ruleExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:1: (lv_right_7_0= ruleExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:196:3: lv_right_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpression353);
                    lv_right_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_7_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:214:2: this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryExpressionParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleExpression386);
                    this_PrimaryExpression_8=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:225:1: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:226:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExpressionAccess().getPowBaseAction_2_1(),
                                  current);
                          
                    }

                    }

                    otherlv_10=(Token)match(input,13,FOLLOW_13_in_ruleExpression409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getExpressionAccess().getCircumflexAccentKeyword_2_2());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:238:1: ( (lv_power_11_0= ruleExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_power_11_0= ruleExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_power_11_0= ruleExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:240:3: lv_power_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getPowerExpressionParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpression430);
                    lv_power_11_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"power",
                              		lv_power_11_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:258:2: this_PrimaryExpression_12= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleExpression462);
                    this_PrimaryExpression_12=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_12; 
                              afterParserOrEnumRuleCall();
                          
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:277:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:278:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:279:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression497);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression507); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:286:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= '1' ) ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:289:28: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= '1' ) ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:290:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= '1' ) ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:290:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= '1' ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            else if ( (LA2_0==16) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:290:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:290:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:290:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,14,FOLLOW_14_in_rulePrimaryExpression545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression570);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_rulePrimaryExpression581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:311:6: ( () ( (lv_value_4_0= '1' ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:311:6: ( () ( (lv_value_4_0= '1' ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:311:7: () ( (lv_value_4_0= '1' ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:311:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:312:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:320:2: ( (lv_value_4_0= '1' ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:321:1: (lv_value_4_0= '1' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:321:1: (lv_value_4_0= '1' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:322:3: lv_value_4_0= '1'
                    {
                    lv_value_4_0=(Token)match(input,16,FOLLOW_16_in_rulePrimaryExpression619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_4_0, grammarAccess.getPrimaryExpressionAccess().getValue1Keyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(current, "value", lv_value_4_0, "1");
                      	    
                    }

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
    // $ANTLR end "rulePrimaryExpression"

    // $ANTLR start synpred1_InternalMath
    public final void synpred1_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:2: ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:2: (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:2: (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:126:2: this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) )
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_rulePrimaryExpression_in_synpred1_InternalMath232);
        this_PrimaryExpression_0=rulePrimaryExpression();

        state._fsp--;
        if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:137:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:138:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,11,FOLLOW_11_in_synpred1_InternalMath255); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:150:1: ( (lv_right_3_0= ruleExpression ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:151:1: (lv_right_3_0= ruleExpression )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:151:1: (lv_right_3_0= ruleExpression )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:152:3: lv_right_3_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_0_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred1_InternalMath276);
        lv_right_3_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalMath

    // $ANTLR start synpred2_InternalMath
    public final void synpred2_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        EObject this_PrimaryExpression_4 = null;

        EObject lv_right_7_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: ( (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:170:2: this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '*' ( (lv_right_7_0= ruleExpression ) )
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_rulePrimaryExpression_in_synpred2_InternalMath309);
        this_PrimaryExpression_4=rulePrimaryExpression();

        state._fsp--;
        if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:181:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:182:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_6=(Token)match(input,12,FOLLOW_12_in_synpred2_InternalMath332); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:194:1: ( (lv_right_7_0= ruleExpression ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:1: (lv_right_7_0= ruleExpression )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:195:1: (lv_right_7_0= ruleExpression )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:196:3: lv_right_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_1_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred2_InternalMath353);
        lv_right_7_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalMath

    // $ANTLR start synpred3_InternalMath
    public final void synpred3_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_10=null;
        EObject this_PrimaryExpression_8 = null;

        EObject lv_power_11_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: ( (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:214:2: this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '^' ( (lv_power_11_0= ruleExpression ) )
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_rulePrimaryExpression_in_synpred3_InternalMath386);
        this_PrimaryExpression_8=rulePrimaryExpression();

        state._fsp--;
        if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:225:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:226:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_10=(Token)match(input,13,FOLLOW_13_in_synpred3_InternalMath409); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:238:1: ( (lv_power_11_0= ruleExpression ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_power_11_0= ruleExpression )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_power_11_0= ruleExpression )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:240:3: lv_power_11_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionAccess().getPowerExpressionParserRuleCall_2_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred3_InternalMath430);
        lv_power_11_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalMath

    // Delegated rules

    public final boolean synpred2_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalMath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalMath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalMath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFormula136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression232 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleExpression255 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression309 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleExpression332 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression386 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleExpression409 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rulePrimaryExpression545 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression570 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePrimaryExpression581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePrimaryExpression619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred1_InternalMath232 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_synpred1_InternalMath255 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred1_InternalMath276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred2_InternalMath309 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred2_InternalMath332 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred2_InternalMath353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred3_InternalMath386 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_synpred3_InternalMath409 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred3_InternalMath430 = new BitSet(new long[]{0x0000000000000002L});

}