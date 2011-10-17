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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:121:1: ruleExpression returns [EObject current=null] : ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) ) | (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) ) | (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) ) | this_PrimaryExpression_20= rulePrimaryExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        Token otherlv_14=null;
        Token otherlv_18=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;

        EObject this_PrimaryExpression_4 = null;

        EObject lv_right_7_0 = null;

        EObject this_PrimaryExpression_8 = null;

        EObject lv_right_11_0 = null;

        EObject this_PrimaryExpression_12 = null;

        EObject lv_right_15_0 = null;

        EObject this_PrimaryExpression_16 = null;

        EObject lv_power_19_0 = null;

        EObject this_PrimaryExpression_20 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:28: ( ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) ) | (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) ) | (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) ) | this_PrimaryExpression_20= rulePrimaryExpression ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) ) | (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) ) | (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) ) | this_PrimaryExpression_20= rulePrimaryExpression )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) ) | (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) ) | (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) ) | this_PrimaryExpression_20= rulePrimaryExpression )
            int alt1=6;
            alt1 = dfa1.predict(input);
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:170:2: this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) )
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
                                  grammarAccess.getExpressionAccess().getMinusLeftAction_1_1(),
                                  current);
                          
                    }

                    }

                    otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleExpression332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getExpressionAccess().getHyphenMinusKeyword_1_2());
                          
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:214:2: this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) )
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
                                  grammarAccess.getExpressionAccess().getMultLeftAction_2_1(),
                                  current);
                          
                    }

                    }

                    otherlv_10=(Token)match(input,13,FOLLOW_13_in_ruleExpression409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getExpressionAccess().getAsteriskKeyword_2_2());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:238:1: ( (lv_right_11_0= ruleExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_right_11_0= ruleExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_right_11_0= ruleExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:240:3: lv_right_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpression430);
                    lv_right_11_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_11_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:257:6: (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:257:6: (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:258:2: this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryExpressionParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleExpression463);
                    this_PrimaryExpression_12=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_12; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:269:1: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:270:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExpressionAccess().getDivLeftAction_3_1(),
                                  current);
                          
                    }

                    }

                    otherlv_14=(Token)match(input,14,FOLLOW_14_in_ruleExpression486); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getExpressionAccess().getSolidusKeyword_3_2());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:282:1: ( (lv_right_15_0= ruleExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:283:1: (lv_right_15_0= ruleExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:283:1: (lv_right_15_0= ruleExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:284:3: lv_right_15_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_3_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpression507);
                    lv_right_15_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_15_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:301:6: (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:301:6: (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:302:2: this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryExpressionParserRuleCall_4_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleExpression540);
                    this_PrimaryExpression_16=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_16; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:1: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:314:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExpressionAccess().getPowBaseAction_4_1(),
                                  current);
                          
                    }

                    }

                    otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleExpression563); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getExpressionAccess().getCircumflexAccentKeyword_4_2());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:1: ( (lv_power_19_0= ruleExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_power_19_0= ruleExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_power_19_0= ruleExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:328:3: lv_power_19_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getPowerExpressionParserRuleCall_4_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpression584);
                    lv_power_19_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"power",
                              		lv_power_19_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:346:2: this_PrimaryExpression_20= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleExpression616);
                    this_PrimaryExpression_20=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_20; 
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:365:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:366:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:367:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression651);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression661); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:374:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) | ( () ( (lv_value_6_0= RULE_INT ) ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token lv_value_6_0=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:377:28: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) | ( () ( (lv_value_6_0= RULE_INT ) ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:378:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) | ( () ( (lv_value_6_0= RULE_INT ) ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:378:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_name_4_0= RULE_ID ) ) ) | ( () ( (lv_value_6_0= RULE_INT ) ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case RULE_INT:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:378:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:378:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:378:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_16_in_rulePrimaryExpression699); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression724);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_rulePrimaryExpression735); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:399:6: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:399:6: ( () ( (lv_name_4_0= RULE_ID ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:399:7: () ( (lv_name_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:399:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:400:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryExpressionAccess().getVariableAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:408:2: ( (lv_name_4_0= RULE_ID ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:1: (lv_name_4_0= RULE_ID )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:1: (lv_name_4_0= RULE_ID )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:410:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryExpression772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getPrimaryExpressionAccess().getNameIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:427:6: ( () ( (lv_value_6_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:427:6: ( () ( (lv_value_6_0= RULE_INT ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:427:7: () ( (lv_value_6_0= RULE_INT ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:427:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:428:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryExpressionAccess().getNumberAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:436:2: ( (lv_value_6_0= RULE_INT ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:437:1: (lv_value_6_0= RULE_INT )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:437:1: (lv_value_6_0= RULE_INT )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:438:3: lv_value_6_0= RULE_INT
                    {
                    lv_value_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePrimaryExpression814); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_6_0, grammarAccess.getPrimaryExpressionAccess().getValueINTTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_6_0, 
                              		"INT");
                      	    
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


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: ( (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:6: (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:170:2: this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) )
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

        EObject lv_right_11_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: ( (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:213:6: (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:214:2: this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) )
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
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:238:1: ( (lv_right_11_0= ruleExpression ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_right_11_0= ruleExpression )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: (lv_right_11_0= ruleExpression )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:240:3: lv_right_11_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_2_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred3_InternalMath430);
        lv_right_11_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalMath

    // $ANTLR start synpred4_InternalMath
    public final void synpred4_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_14=null;
        EObject this_PrimaryExpression_12 = null;

        EObject lv_right_15_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:257:6: ( (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:257:6: (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:257:6: (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:258:2: this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) )
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_rulePrimaryExpression_in_synpred4_InternalMath463);
        this_PrimaryExpression_12=rulePrimaryExpression();

        state._fsp--;
        if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:269:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:270:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_14=(Token)match(input,14,FOLLOW_14_in_synpred4_InternalMath486); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:282:1: ( (lv_right_15_0= ruleExpression ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:283:1: (lv_right_15_0= ruleExpression )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:283:1: (lv_right_15_0= ruleExpression )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:284:3: lv_right_15_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionAccess().getRightExpressionParserRuleCall_3_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred4_InternalMath507);
        lv_right_15_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalMath

    // $ANTLR start synpred5_InternalMath
    public final void synpred5_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_18=null;
        EObject this_PrimaryExpression_16 = null;

        EObject lv_power_19_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:301:6: ( (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:301:6: (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:301:6: (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:302:2: this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) )
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_rulePrimaryExpression_in_synpred5_InternalMath540);
        this_PrimaryExpression_16=rulePrimaryExpression();

        state._fsp--;
        if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:314:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_18=(Token)match(input,15,FOLLOW_15_in_synpred5_InternalMath563); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:1: ( (lv_power_19_0= ruleExpression ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_power_19_0= ruleExpression )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_power_19_0= ruleExpression )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:328:3: lv_power_19_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionAccess().getPowerExpressionParserRuleCall_4_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred5_InternalMath584);
        lv_power_19_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalMath

    // Delegated rules

    public final boolean synpred5_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalMath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalMath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\12\uffff";
    static final String DFA1_eofS =
        "\12\uffff";
    static final String DFA1_minS =
        "\1\4\3\0\6\uffff";
    static final String DFA1_maxS =
        "\1\20\3\0\6\uffff";
    static final String DFA1_acceptS =
        "\4\uffff\1\1\1\2\1\3\1\4\1\5\1\6";
    static final String DFA1_specialS =
        "\1\uffff\1\0\1\1\1\2\6\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\3\12\uffff\1\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "125:1: ( (this_PrimaryExpression_0= rulePrimaryExpression () otherlv_2= '+' ( (lv_right_3_0= ruleExpression ) ) ) | (this_PrimaryExpression_4= rulePrimaryExpression () otherlv_6= '-' ( (lv_right_7_0= ruleExpression ) ) ) | (this_PrimaryExpression_8= rulePrimaryExpression () otherlv_10= '*' ( (lv_right_11_0= ruleExpression ) ) ) | (this_PrimaryExpression_12= rulePrimaryExpression () otherlv_14= '/' ( (lv_right_15_0= ruleExpression ) ) ) | (this_PrimaryExpression_16= rulePrimaryExpression () otherlv_18= '^' ( (lv_power_19_0= ruleExpression ) ) ) | this_PrimaryExpression_20= rulePrimaryExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalMath()) ) {s = 4;}

                        else if ( (synpred2_InternalMath()) ) {s = 5;}

                        else if ( (synpred3_InternalMath()) ) {s = 6;}

                        else if ( (synpred4_InternalMath()) ) {s = 7;}

                        else if ( (synpred5_InternalMath()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalMath()) ) {s = 4;}

                        else if ( (synpred2_InternalMath()) ) {s = 5;}

                        else if ( (synpred3_InternalMath()) ) {s = 6;}

                        else if ( (synpred4_InternalMath()) ) {s = 7;}

                        else if ( (synpred5_InternalMath()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalMath()) ) {s = 4;}

                        else if ( (synpred2_InternalMath()) ) {s = 5;}

                        else if ( (synpred3_InternalMath()) ) {s = 6;}

                        else if ( (synpred4_InternalMath()) ) {s = 7;}

                        else if ( (synpred5_InternalMath()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFormula136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression232 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleExpression255 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression309 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleExpression332 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression386 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleExpression409 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression463 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleExpression486 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression540 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExpression563 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleExpression616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression651 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePrimaryExpression699 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression724 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rulePrimaryExpression735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryExpression772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePrimaryExpression814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred1_InternalMath232 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_synpred1_InternalMath255 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred1_InternalMath276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred2_InternalMath309 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred2_InternalMath332 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred2_InternalMath353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred3_InternalMath386 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_synpred3_InternalMath409 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred3_InternalMath430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred4_InternalMath463 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred4_InternalMath486 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred4_InternalMath507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_synpred5_InternalMath540 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred5_InternalMath563 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred5_InternalMath584 = new BitSet(new long[]{0x0000000000000002L});

}