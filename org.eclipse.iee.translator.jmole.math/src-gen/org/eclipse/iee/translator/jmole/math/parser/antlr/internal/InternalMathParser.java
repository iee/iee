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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MATH_NAME", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", "'.'", "'E'", "'e'", "','", "'{'", "'}'"
    };
    public static final int RULE_ID=6;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_MATH_NAME=4;
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:82:1: ruleStatement returns [EObject current=null] : ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_functionDefinition_0_0 = null;

        EObject lv_matrixDefinition_1_0 = null;

        EObject lv_assignment_2_0 = null;

        EObject lv_formula_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:85:28: ( ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_MATH_NAME) ) {
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
            else if ( (LA1_0==RULE_INT||LA1_0==18) ) {
                alt1=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:88:3: lv_functionDefinition_0_0= ruleFunctionDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getFunctionDefinitionFunctionDefinitionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunctionDefinition_in_ruleStatement137);
                    lv_functionDefinition_0_0=ruleFunctionDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"functionDefinition",
                              		lv_functionDefinition_0_0, 
                              		"FunctionDefinition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:107:3: lv_matrixDefinition_1_0= ruleMatrixDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixDefinitionMatrixDefinitionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixDefinition_in_ruleStatement164);
                    lv_matrixDefinition_1_0=ruleMatrixDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"matrixDefinition",
                              		lv_matrixDefinition_1_0, 
                              		"MatrixDefinition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_assignment_2_0= ruleAssignment )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_assignment_2_0= ruleAssignment )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:126:3: lv_assignment_2_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getAssignmentAssignmentParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleStatement191);
                    lv_assignment_2_0=ruleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"assignment",
                              		lv_assignment_2_0, 
                              		"Assignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:6: ( (lv_formula_3_0= ruleFormula ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:6: ( (lv_formula_3_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: (lv_formula_3_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: (lv_formula_3_0= ruleFormula )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:145:3: lv_formula_3_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getFormulaFormulaParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleStatement218);
                    lv_formula_3_0=ruleFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"formula",
                              		lv_formula_3_0, 
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


    // $ANTLR start "entryRuleAssignment"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:169:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:170:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:171:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment254);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment264); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:178:1: ruleAssignment returns [EObject current=null] : ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:181:28: ( ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:182:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:182:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:182:2: ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:182:2: ( (lv_variable_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:183:1: (lv_variable_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:183:1: (lv_variable_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:184:3: lv_variable_0_0= RULE_MATH_NAME
            {
            lv_variable_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleAssignment306); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_variable_0_0, grammarAccess.getAssignmentAccess().getVariableMATH_NAMETerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAssignmentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"variable",
                      		lv_variable_0_0, 
                      		"MATH_NAME");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleAssignment323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:204:1: ( (lv_value_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:205:1: (lv_value_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:205:1: (lv_value_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:206:3: lv_value_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getValueFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleAssignment344);
            lv_value_2_0=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleFormula"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:230:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:231:2: (iv_ruleFormula= ruleFormula EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:232:2: iv_ruleFormula= ruleFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleFormula_in_entryRuleFormula380);
            iv_ruleFormula=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormula390); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:239:1: ruleFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleAddition ) ) ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:242:28: ( ( (lv_expression_0_0= ruleAddition ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:243:1: ( (lv_expression_0_0= ruleAddition ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:243:1: ( (lv_expression_0_0= ruleAddition ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:244:1: (lv_expression_0_0= ruleAddition )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:244:1: (lv_expression_0_0= ruleAddition )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:245:3: lv_expression_0_0= ruleAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormulaAccess().getExpressionAdditionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleFormula435);
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:269:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:270:2: (iv_ruleAddition= ruleAddition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:271:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition470);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition480); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:278:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:281:28: ( (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:282:1: (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:282:1: (this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:283:2: this_Multiplication_0= ruleMultiplication ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition530);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:294:1: ( ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) ) | ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }
                else if ( (LA2_0==14) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:294:2: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:294:2: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:294:3: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:294:3: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:295:2: 
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

            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleAddition555); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:307:1: ( (lv_right_3_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:308:1: (lv_right_3_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:308:1: (lv_right_3_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:309:3: lv_right_3_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition576);
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
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:6: ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:6: ( () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:7: () otherlv_5= '-' ( (lv_right_6_0= ruleMultiplication ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:7: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:2: 
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

            	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAddition608); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_1_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:339:1: ( (lv_right_6_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:340:1: (lv_right_6_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:340:1: (lv_right_6_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:341:3: lv_right_6_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition629);
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:365:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:366:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:367:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication668);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication678); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:374:1: ruleMultiplication returns [EObject current=null] : (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject this_Power_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:377:28: ( (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:378:1: (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:378:1: (this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:379:2: this_Power_0= rulePower ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getPowerParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePower_in_ruleMultiplication728);
            this_Power_0=rulePower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Power_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:390:1: ( ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) ) | ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }
                else if ( (LA3_0==16) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:390:2: ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:390:2: ( () otherlv_2= '*' ( (lv_right_3_0= rulePower ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:390:3: () otherlv_2= '*' ( (lv_right_3_0= rulePower ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:390:3: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:391:2: 
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

            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleMultiplication753); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:403:1: ( (lv_right_3_0= rulePower ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:404:1: (lv_right_3_0= rulePower )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:404:1: (lv_right_3_0= rulePower )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:405:3: lv_right_3_0= rulePower
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPowerParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePower_in_ruleMultiplication774);
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
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:422:6: ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:422:6: ( () otherlv_5= '/' ( (lv_right_6_0= rulePower ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:422:7: () otherlv_5= '/' ( (lv_right_6_0= rulePower ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:422:7: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:423:2: 
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

            	    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleMultiplication806); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_1_1());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:435:1: ( (lv_right_6_0= rulePower ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:436:1: (lv_right_6_0= rulePower )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:436:1: (lv_right_6_0= rulePower )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:437:3: lv_right_6_0= rulePower
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPowerParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePower_in_ruleMultiplication827);
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:461:1: entryRulePower returns [EObject current=null] : iv_rulePower= rulePower EOF ;
    public final EObject entryRulePower() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePower = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:462:2: (iv_rulePower= rulePower EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:463:2: iv_rulePower= rulePower EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPowerRule()); 
            }
            pushFollow(FOLLOW_rulePower_in_entryRulePower866);
            iv_rulePower=rulePower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePower; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePower876); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:470:1: rulePower returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) ;
    public final EObject rulePower() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:473:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:474:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:474:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:475:2: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPowerAccess().getPrimaryParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimary_in_rulePower926);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:486:1: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:486:2: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:486:2: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:487:2: 
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

                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_rulePower950); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPowerAccess().getCircumflexAccentKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:499:1: ( (lv_right_3_0= rulePrimary ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:500:1: (lv_right_3_0= rulePrimary )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:500:1: (lv_right_3_0= rulePrimary )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:501:3: lv_right_3_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPowerAccess().getRightPrimaryParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimary_in_rulePower971);
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:525:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:526:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:527:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary1009);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary1019); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:534:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) ) ;
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
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:537:28: ( ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_MATH_NAME:
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==18) ) {
                    alt5=3;
                }
                else if ( (LA5_1==EOF||(LA5_1>=13 && LA5_1<=17)||LA5_1==19||LA5_1==23) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt5=2;
                }
                break;
            case 18:
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:3: () ( (lv_name_1_0= RULE_MATH_NAME ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:3: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:539:2: 
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:547:2: ( (lv_name_1_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:548:1: (lv_name_1_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:548:1: (lv_name_1_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:549:3: lv_name_1_0= RULE_MATH_NAME
                    {
                    lv_name_1_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimary1074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getPrimaryAccess().getNameMATH_NAMETerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"MATH_NAME");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:566:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:566:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:566:7: () ( (lv_value_3_0= ruleFloat ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:566:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:567:2: 
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:575:2: ( (lv_value_3_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:576:1: (lv_value_3_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:576:1: (lv_value_3_0= ruleFloat )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:577:3: lv_value_3_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getValueFloatParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary1120);
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:594:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:594:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:594:7: () ( (lv_function_5_0= ruleFunction ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:594:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:595:2: 
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:603:2: ( (lv_function_5_0= ruleFunction ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:604:1: (lv_function_5_0= ruleFunction )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:604:1: (lv_function_5_0= ruleFunction )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:605:3: lv_function_5_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getFunctionFunctionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_rulePrimary1161);
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:622:6: (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:622:6: (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:622:8: otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_rulePrimary1181); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getAdditionParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAddition_in_rulePrimary1206);
                    this_Addition_7=ruleAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Addition_7; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_8=(Token)match(input,19,FOLLOW_19_in_rulePrimary1217); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:650:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:651:2: (iv_ruleFloat= ruleFloat EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:652:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_ruleFloat_in_entryRuleFloat1255);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFloat1266); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:659:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:662:28: ( ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:663:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:663:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:663:2: (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:663:2: (this_INT_0= RULE_INT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_INT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:663:7: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1307); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_0, grammarAccess.getFloatAccess().getINTTerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:670:3: (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:671:2: kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleFloat1328); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:676:1: (this_INT_2= RULE_INT )+
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
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:676:6: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1344); if (state.failed) return current;
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:683:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=21 && LA11_0<=22)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:683:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+
                            {
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:683:4: (kw= 'E' | kw= 'e' )
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0==21) ) {
                                alt8=1;
                            }
                            else if ( (LA8_0==22) ) {
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
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:684:2: kw= 'E'
                                    {
                                    kw=(Token)match(input,21,FOLLOW_21_in_ruleFloat1366); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:691:2: kw= 'e'
                                    {
                                    kw=(Token)match(input,22,FOLLOW_22_in_ruleFloat1385); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:696:2: (kw= '-' )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0==14) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:697:2: kw= '-'
                                    {
                                    kw=(Token)match(input,14,FOLLOW_14_in_ruleFloat1400); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getHyphenMinusKeyword_1_2_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:702:3: (this_INT_6= RULE_INT )+
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
                            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:702:8: this_INT_6= RULE_INT
                            	    {
                            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1418); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:717:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:718:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:719:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction1469);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction1479); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:726:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:729:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:730:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:730:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:730:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')'
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:730:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:731:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:731:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:732:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunction1521); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleFunction1538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:752:1: ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_MATH_NAME && LA15_0<=RULE_INT)||LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:752:2: ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )?
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:752:2: ( (lv_parameters_2_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:753:1: (lv_parameters_2_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:753:1: (lv_parameters_2_0= ruleFormula )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:754:3: lv_parameters_2_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleFunction1560);
                    lv_parameters_2_0=ruleFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                      	        }
                             		add(
                             			current, 
                             			"parameters",
                              		lv_parameters_2_0, 
                              		"Formula");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:770:2: (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==23) ) {
                            int LA13_1 = input.LA(2);

                            if ( ((LA13_1>=RULE_MATH_NAME && LA13_1<=RULE_INT)||LA13_1==18) ) {
                                alt13=1;
                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:770:4: otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleFunction1573); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:774:1: ( (lv_parameters_4_0= ruleFormula ) )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:775:1: (lv_parameters_4_0= ruleFormula )
                    	    {
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:775:1: (lv_parameters_4_0= ruleFormula )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:776:3: lv_parameters_4_0= ruleFormula
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFormula_in_ruleFunction1594);
                    	    lv_parameters_4_0=ruleFormula();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"parameters",
                    	              		lv_parameters_4_0, 
                    	              		"Formula");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:792:4: (otherlv_5= ',' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==23) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:792:6: otherlv_5= ','
                            {
                            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleFunction1609); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleFunction1625); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_3());
                  
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:808:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:809:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:810:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1661);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition1671); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:817:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_function_0_0 = null;

        EObject lv_formula_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:820:28: ( ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:821:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:821:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:821:2: ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:821:2: ( (lv_function_0_0= ruleFunction ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:822:1: (lv_function_0_0= ruleFunction )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:822:1: (lv_function_0_0= ruleFunction )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:823:3: lv_function_0_0= ruleFunction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctionFunctionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleFunctionDefinition1717);
            lv_function_0_0=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"function",
                      		lv_function_0_0, 
                      		"Function");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleFunctionDefinition1729); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:843:1: ( (lv_formula_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:844:1: (lv_formula_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:844:1: (lv_formula_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:845:3: lv_formula_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleFunctionDefinition1750);
            lv_formula_2_0=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
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


    // $ANTLR start "entryRuleMatrixDefinition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:869:1: entryRuleMatrixDefinition returns [EObject current=null] : iv_ruleMatrixDefinition= ruleMatrixDefinition EOF ;
    public final EObject entryRuleMatrixDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixDefinition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:870:2: (iv_ruleMatrixDefinition= ruleMatrixDefinition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:871:2: iv_ruleMatrixDefinition= ruleMatrixDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixDefinition_in_entryRuleMatrixDefinition1786);
            iv_ruleMatrixDefinition=ruleMatrixDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixDefinition1796); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrixDefinition"


    // $ANTLR start "ruleMatrixDefinition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:878:1: ruleMatrixDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' ) ;
    public final EObject ruleMatrixDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_rows_3_0 = null;

        EObject lv_rows_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:881:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:882:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:882:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:882:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}'
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:882:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:883:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:883:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:884:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleMatrixDefinition1838); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getMatrixDefinitionAccess().getNameMATH_NAMETerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMatrixDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"MATH_NAME");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleMatrixDefinition1855); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMatrixDefinitionAccess().getEqualsSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleMatrixDefinition1867); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMatrixDefinitionAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:908:1: ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:908:2: ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )?
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:908:2: ( (lv_rows_3_0= ruleMatrixRow ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:909:1: (lv_rows_3_0= ruleMatrixRow )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:909:1: (lv_rows_3_0= ruleMatrixRow )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:910:3: lv_rows_3_0= ruleMatrixRow
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixDefinitionAccess().getRowsMatrixRowParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition1889);
                    lv_rows_3_0=ruleMatrixRow();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMatrixDefinitionRule());
                      	        }
                             		add(
                             			current, 
                             			"rows",
                              		lv_rows_3_0, 
                              		"MatrixRow");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:926:2: (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==23) ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1==24) ) {
                                alt16=1;
                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:926:4: otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleMatrixDefinition1902); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getMatrixDefinitionAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:930:1: ( (lv_rows_5_0= ruleMatrixRow ) )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:931:1: (lv_rows_5_0= ruleMatrixRow )
                    	    {
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:931:1: (lv_rows_5_0= ruleMatrixRow )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:932:3: lv_rows_5_0= ruleMatrixRow
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixDefinitionAccess().getRowsMatrixRowParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition1923);
                    	    lv_rows_5_0=ruleMatrixRow();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMatrixDefinitionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"rows",
                    	              		lv_rows_5_0, 
                    	              		"MatrixRow");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:948:4: (otherlv_6= ',' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==23) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:948:6: otherlv_6= ','
                            {
                            otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleMatrixDefinition1938); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getMatrixDefinitionAccess().getCommaKeyword_3_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleMatrixDefinition1954); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMatrixDefinitionAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "ruleMatrixDefinition"


    // $ANTLR start "entryRuleMatrixRow"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:964:1: entryRuleMatrixRow returns [EObject current=null] : iv_ruleMatrixRow= ruleMatrixRow EOF ;
    public final EObject entryRuleMatrixRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixRow = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:965:2: (iv_ruleMatrixRow= ruleMatrixRow EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:966:2: iv_ruleMatrixRow= ruleMatrixRow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRowRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow1990);
            iv_ruleMatrixRow=ruleMatrixRow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixRow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixRow2000); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrixRow"


    // $ANTLR start "ruleMatrixRow"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:973:1: ruleMatrixRow returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
    public final EObject ruleMatrixRow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_elements_1_0 = null;

        AntlrDatatypeRuleToken lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:976:28: ( (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:977:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:977:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:977:3: otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleMatrixRow2037); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixRowAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:981:1: ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:981:2: ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:981:2: ( (lv_elements_1_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:982:1: (lv_elements_1_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:982:1: (lv_elements_1_0= ruleFloat )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:983:3: lv_elements_1_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow2059);
                    lv_elements_1_0=ruleFloat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMatrixRowRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_1_0, 
                              		"Float");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:999:2: (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==23) ) {
                            int LA19_1 = input.LA(2);

                            if ( (LA19_1==RULE_INT) ) {
                                alt19=1;
                            }


                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:999:4: otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) )
                    	    {
                    	    otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleMatrixRow2072); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1003:1: ( (lv_elements_3_0= ruleFloat ) )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1004:1: (lv_elements_3_0= ruleFloat )
                    	    {
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1004:1: (lv_elements_3_0= ruleFloat )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1005:3: lv_elements_3_0= ruleFloat
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow2093);
                    	    lv_elements_3_0=ruleFloat();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMatrixRowRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_3_0, 
                    	              		"Float");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1021:4: (otherlv_4= ',' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==23) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1021:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleMatrixRow2108); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleMatrixRow2124); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMatrixRowAccess().getRightCurlyBracketKeyword_2());
                  
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
    // $ANTLR end "ruleMatrixRow"

    // $ANTLR start synpred1_InternalMath
    public final void synpred1_InternalMath_fragment() throws RecognitionException {   
        EObject lv_functionDefinition_0_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:2: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:88:3: lv_functionDefinition_0_0= ruleFunctionDefinition
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getFunctionDefinitionFunctionDefinitionParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleFunctionDefinition_in_synpred1_InternalMath137);
        lv_functionDefinition_0_0=ruleFunctionDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred1_InternalMath

    // $ANTLR start synpred2_InternalMath
    public final void synpred2_InternalMath_fragment() throws RecognitionException {   
        EObject lv_matrixDefinition_1_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:107:3: lv_matrixDefinition_1_0= ruleMatrixDefinition
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixDefinitionMatrixDefinitionParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMatrixDefinition_in_synpred2_InternalMath164);
        lv_matrixDefinition_1_0=ruleMatrixDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalMath

    // $ANTLR start synpred3_InternalMath
    public final void synpred3_InternalMath_fragment() throws RecognitionException {   
        EObject lv_assignment_2_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( ( (lv_assignment_2_0= ruleAssignment ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_assignment_2_0= ruleAssignment )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_assignment_2_0= ruleAssignment )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:126:3: lv_assignment_2_0= ruleAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getAssignmentAssignmentParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleAssignment_in_synpred3_InternalMath191);
        lv_assignment_2_0=ruleAssignment();

        state._fsp--;
        if (state.failed) return ;

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


 

    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_ruleStatement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixDefinition_in_ruleStatement164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleStatement191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleStatement218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleAssignment306 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAssignment323 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleAssignment344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleFormula435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition530 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_13_in_ruleAddition555 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition576 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_14_in_ruleAddition608 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition629 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePower_in_ruleMultiplication728 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_15_in_ruleMultiplication753 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_rulePower_in_ruleMultiplication774 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplication806 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_rulePower_in_ruleMultiplication827 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rulePower_in_entryRulePower866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePower876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_rulePower926 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_rulePower950 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_rulePrimary_in_rulePower971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary1009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimary1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rulePrimary1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulePrimary1181 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleAddition_in_rulePrimary1206 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePrimary1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_entryRuleFloat1255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFloat1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1307 = new BitSet(new long[]{0x0000000000100022L});
    public static final BitSet FOLLOW_20_in_ruleFloat1328 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1344 = new BitSet(new long[]{0x0000000000600022L});
    public static final BitSet FOLLOW_21_in_ruleFloat1366 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_22_in_ruleFloat1385 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_14_in_ruleFloat1400 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1418 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction1469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunction1521 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFunction1538 = new BitSet(new long[]{0x00000000000C0030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction1560 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_23_in_ruleFunction1573 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction1594 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_23_in_ruleFunction1609 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFunction1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleFunctionDefinition1717 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFunctionDefinition1729 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunctionDefinition1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixDefinition_in_entryRuleMatrixDefinition1786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixDefinition1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleMatrixDefinition1838 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMatrixDefinition1855 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMatrixDefinition1867 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition1889 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleMatrixDefinition1902 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition1923 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleMatrixDefinition1938 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleMatrixDefinition1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow1990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixRow2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleMatrixRow2037 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow2059 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleMatrixRow2072 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow2093 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleMatrixRow2108 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleMatrixRow2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_synpred1_InternalMath137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixDefinition_in_synpred2_InternalMath164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_synpred3_InternalMath191 = new BitSet(new long[]{0x0000000000000002L});

}