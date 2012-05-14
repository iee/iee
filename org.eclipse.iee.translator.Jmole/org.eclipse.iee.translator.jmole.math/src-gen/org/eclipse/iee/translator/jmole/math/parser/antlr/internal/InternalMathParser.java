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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MATH_NAME", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'(-'", "')'", "'('", "')!'", "'^'", "'['", "']'", "'{'", "','", "'}'", "']^T'", "'.'", "'E'", "'e'"
    };
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
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
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:82:1: ruleStatement returns [EObject current=null] : ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_functionDefinition_0_0 = null;

        EObject lv_variableAssignment_1_0 = null;

        EObject lv_formula_2_0 = null;

        EObject lv_matrixAssignment_3_0 = null;

        EObject lv_matrixFormula_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:85:28: ( ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) )
            int alt1=5;
            alt1 = dfa1.predict(input);
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:107:3: lv_variableAssignment_1_0= ruleVariableAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getVariableAssignmentVariableAssignmentParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVariableAssignment_in_ruleStatement164);
                    lv_variableAssignment_1_0=ruleVariableAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"variableAssignment",
                              		lv_variableAssignment_1_0, 
                              		"VariableAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_formula_2_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_formula_2_0= ruleFormula )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:126:3: lv_formula_2_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getFormulaFormulaParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleStatement191);
                    lv_formula_2_0=ruleFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
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
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:145:3: lv_matrixAssignment_3_0= ruleMatrixAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixAssignmentMatrixAssignmentParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixAssignment_in_ruleStatement218);
                    lv_matrixAssignment_3_0=ruleMatrixAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"matrixAssignment",
                              		lv_matrixAssignment_3_0, 
                              		"MatrixAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:162:6: ( (lv_matrixFormula_4_0= ruleMatrixFormula ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:162:6: ( (lv_matrixFormula_4_0= ruleMatrixFormula ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:163:1: (lv_matrixFormula_4_0= ruleMatrixFormula )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:163:1: (lv_matrixFormula_4_0= ruleMatrixFormula )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:164:3: lv_matrixFormula_4_0= ruleMatrixFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixFormulaMatrixFormulaParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixFormula_in_ruleStatement245);
                    lv_matrixFormula_4_0=ruleMatrixFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"matrixFormula",
                              		lv_matrixFormula_4_0, 
                              		"MatrixFormula");
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


    // $ANTLR start "entryRuleVariableAssignment"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:188:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:189:2: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:190:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleVariableAssignment_in_entryRuleVariableAssignment281);
            iv_ruleVariableAssignment=ruleVariableAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableAssignment291); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVariableAssignment"


    // $ANTLR start "ruleVariableAssignment"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:197:1: ruleVariableAssignment returns [EObject current=null] : ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:200:28: ( ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:201:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:201:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:201:2: ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:201:2: ( (lv_variable_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:202:1: (lv_variable_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:202:1: (lv_variable_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:203:3: lv_variable_0_0= RULE_MATH_NAME
            {
            lv_variable_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleVariableAssignment333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_variable_0_0, grammarAccess.getVariableAssignmentAccess().getVariableMATH_NAMETerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableAssignmentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"variable",
                      		lv_variable_0_0, 
                      		"MATH_NAME");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleVariableAssignment350); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVariableAssignmentAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:223:1: ( (lv_value_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:224:1: (lv_value_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:224:1: (lv_value_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:225:3: lv_value_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleVariableAssignment371);
            lv_value_2_0=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableAssignmentRule());
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
    // $ANTLR end "ruleVariableAssignment"


    // $ANTLR start "entryRuleFormula"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:249:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:250:2: (iv_ruleFormula= ruleFormula EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:251:2: iv_ruleFormula= ruleFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleFormula_in_entryRuleFormula407);
            iv_ruleFormula=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormula417); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:258:1: ruleFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleAddition ) ) ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:261:28: ( ( (lv_expression_0_0= ruleAddition ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:262:1: ( (lv_expression_0_0= ruleAddition ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:262:1: ( (lv_expression_0_0= ruleAddition ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:263:1: (lv_expression_0_0= ruleAddition )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:263:1: (lv_expression_0_0= ruleAddition )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:264:3: lv_expression_0_0= ruleAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormulaAccess().getExpressionAdditionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleFormula462);
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:288:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:289:2: (iv_ruleAddition= ruleAddition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:290:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition497);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition507); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:297:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:300:28: ( (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:301:1: (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:301:1: (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:302:2: this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition557);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:1: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    int LA2_2 = input.LA(2);

                    if ( (synpred5_InternalMath()) ) {
                        alt2=1;
                    }


                }
                else if ( (LA2_0==14) ) {
                    int LA2_3 = input.LA(2);

                    if ( (synpred6_InternalMath()) ) {
                        alt2=2;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleAddition570); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:317:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:318:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:2: ( (lv_right_3_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_right_3_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_right_3_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:328:3: lv_right_3_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition603);
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
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:345:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:345:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:345:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAddition623); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:349:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:350:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_1_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:358:2: ( (lv_right_6_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:359:1: (lv_right_6_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:359:1: (lv_right_6_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:360:3: lv_right_6_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition656);
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:384:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:385:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:386:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication695);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication705); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:393:1: ruleMultiplication returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:396:28: ( (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:397:1: (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:397:1: (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:398:2: this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication755);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_UnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:1: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*
            loop3:
            do {
                int alt3=4;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:4: otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMultiplication768); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:413:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:414:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:422:2: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:423:1: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:423:1: (lv_right_3_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:424:3: lv_right_3_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication801);
            	    lv_right_3_0=ruleUnaryExpression();

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
            	              		"UnaryExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:441:6: (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:441:6: (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:441:8: otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleMultiplication821); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:445:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:446:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_1_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:454:2: ( (lv_right_6_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:455:1: (lv_right_6_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:455:1: (lv_right_6_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:456:3: lv_right_6_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication854);
            	    lv_right_6_0=ruleUnaryExpression();

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
            	              		"UnaryExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:473:6: (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:473:6: (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:473:8: otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleMultiplication874); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_2_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:477:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:478:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_2_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:486:2: ( (lv_right_9_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:487:1: (lv_right_9_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:487:1: (lv_right_9_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:488:3: lv_right_9_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication907);
            	    lv_right_9_0=ruleUnaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_9_0, 
            	              		"UnaryExpression");
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


    // $ANTLR start "entryRuleUnaryExpression"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:512:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:513:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:514:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression946);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression956); if (state.failed) return current;

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:521:1: ruleUnaryExpression returns [EObject current=null] : (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject this_Exponent_0 = null;

        EObject lv_expression_3_0 = null;

        EObject lv_expression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:524:28: ( (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:525:1: (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:525:1: (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_MATH_NAME:
            case RULE_INT:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                int LA4_3 = input.LA(2);

                if ( (synpred10_InternalMath()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:526:2: this_Exponent_0= ruleExponent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExponentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExponent_in_ruleUnaryExpression1006);
                    this_Exponent_0=ruleExponent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Exponent_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:6: (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:6: (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:538:8: otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleUnaryExpression1024); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisHyphenMinusKeyword_1_0());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:542:1: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:543:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryExpressionAccess().getInvertAction_1_1(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:551:2: ( (lv_expression_3_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:552:1: (lv_expression_3_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:552:1: (lv_expression_3_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:553:3: lv_expression_3_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1057);
                    lv_expression_3_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_3_0, 
                              		"UnaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleUnaryExpression1069); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getUnaryExpressionAccess().getRightParenthesisKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:574:6: (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:574:6: (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:574:8: otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!'
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleUnaryExpression1089); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:578:1: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:579:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryExpressionAccess().getFactorialAction_2_1(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:587:2: ( (lv_expression_7_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:588:1: (lv_expression_7_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:588:1: (lv_expression_7_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:589:3: lv_expression_7_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1122);
                    lv_expression_7_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_7_0, 
                              		"UnaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleUnaryExpression1134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getUnaryExpressionAccess().getRightParenthesisExclamationMarkKeyword_2_3());
                          
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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleExponent"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:617:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:618:2: (iv_ruleExponent= ruleExponent EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:619:2: iv_ruleExponent= ruleExponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExponentRule()); 
            }
            pushFollow(FOLLOW_ruleExponent_in_entryRuleExponent1171);
            iv_ruleExponent=ruleExponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExponent1181); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExponent"


    // $ANTLR start "ruleExponent"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:626:1: ruleExponent returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:629:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:630:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:630:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:631:2: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExponentAccess().getPrimaryParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimary_in_ruleExponent1231);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:642:1: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:642:2: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:642:2: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:643:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExponentAccess().getExponentLeftAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleExponent1255); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:655:1: ( (lv_right_3_0= rulePrimary ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:656:1: (lv_right_3_0= rulePrimary )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:656:1: (lv_right_3_0= rulePrimary )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:657:3: lv_right_3_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExponentAccess().getRightPrimaryParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimary_in_ruleExponent1276);
                    lv_right_3_0=rulePrimary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExponentRule());
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
    // $ANTLR end "ruleExponent"


    // $ANTLR start "entryRulePrimary"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:681:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:682:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:683:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary1314);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary1324); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:690:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_element_5_0= RULE_MATH_NAME ) ) otherlv_6= '[' ( (lv_row_7_0= RULE_INT ) ) otherlv_8= ']' otherlv_9= '[' ( (lv_column_10_0= RULE_INT ) ) otherlv_11= ']' ) | ( () ( (lv_function_13_0= ruleFunction ) ) ) | (otherlv_14= '(' this_Addition_15= ruleAddition otherlv_16= ')' ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_element_5_0=null;
        Token otherlv_6=null;
        Token lv_row_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_column_10_0=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;

        EObject lv_function_13_0 = null;

        EObject this_Addition_15 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:693:28: ( ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_element_5_0= RULE_MATH_NAME ) ) otherlv_6= '[' ( (lv_row_7_0= RULE_INT ) ) otherlv_8= ']' otherlv_9= '[' ( (lv_column_10_0= RULE_INT ) ) otherlv_11= ']' ) | ( () ( (lv_function_13_0= ruleFunction ) ) ) | (otherlv_14= '(' this_Addition_15= ruleAddition otherlv_16= ')' ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:694:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_element_5_0= RULE_MATH_NAME ) ) otherlv_6= '[' ( (lv_row_7_0= RULE_INT ) ) otherlv_8= ']' otherlv_9= '[' ( (lv_column_10_0= RULE_INT ) ) otherlv_11= ']' ) | ( () ( (lv_function_13_0= ruleFunction ) ) ) | (otherlv_14= '(' this_Addition_15= ruleAddition otherlv_16= ')' ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:694:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_element_5_0= RULE_MATH_NAME ) ) otherlv_6= '[' ( (lv_row_7_0= RULE_INT ) ) otherlv_8= ']' otherlv_9= '[' ( (lv_column_10_0= RULE_INT ) ) otherlv_11= ']' ) | ( () ( (lv_function_13_0= ruleFunction ) ) ) | (otherlv_14= '(' this_Addition_15= ruleAddition otherlv_16= ')' ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case RULE_MATH_NAME:
                {
                switch ( input.LA(2) ) {
                case 23:
                    {
                    alt6=3;
                    }
                    break;
                case 20:
                    {
                    alt6=4;
                    }
                    break;
                case EOF:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 19:
                case 21:
                case 22:
                case 26:
                    {
                    alt6=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_INT:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:694:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:694:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:694:3: () ( (lv_name_1_0= RULE_MATH_NAME ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:694:3: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:695:2: 
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:703:2: ( (lv_name_1_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:704:1: (lv_name_1_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:704:1: (lv_name_1_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:705:3: lv_name_1_0= RULE_MATH_NAME
                    {
                    lv_name_1_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimary1379); if (state.failed) return current;
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:722:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:722:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:722:7: () ( (lv_value_3_0= ruleFloat ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:722:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:723:2: 
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:731:2: ( (lv_value_3_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:732:1: (lv_value_3_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:732:1: (lv_value_3_0= ruleFloat )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:733:3: lv_value_3_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getValueFloatParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary1425);
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
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:750:6: ( () ( (lv_element_5_0= RULE_MATH_NAME ) ) otherlv_6= '[' ( (lv_row_7_0= RULE_INT ) ) otherlv_8= ']' otherlv_9= '[' ( (lv_column_10_0= RULE_INT ) ) otherlv_11= ']' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:750:6: ( () ( (lv_element_5_0= RULE_MATH_NAME ) ) otherlv_6= '[' ( (lv_row_7_0= RULE_INT ) ) otherlv_8= ']' otherlv_9= '[' ( (lv_column_10_0= RULE_INT ) ) otherlv_11= ']' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:750:7: () ( (lv_element_5_0= RULE_MATH_NAME ) ) otherlv_6= '[' ( (lv_row_7_0= RULE_INT ) ) otherlv_8= ']' otherlv_9= '[' ( (lv_column_10_0= RULE_INT ) ) otherlv_11= ']'
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:750:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:751:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getMatrixElementAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:759:2: ( (lv_element_5_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:760:1: (lv_element_5_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:760:1: (lv_element_5_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:761:3: lv_element_5_0= RULE_MATH_NAME
                    {
                    lv_element_5_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimary1462); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_element_5_0, grammarAccess.getPrimaryAccess().getElementMATH_NAMETerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"element",
                              		lv_element_5_0, 
                              		"MATH_NAME");
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_rulePrimary1479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryAccess().getLeftSquareBracketKeyword_2_2());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:781:1: ( (lv_row_7_0= RULE_INT ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:782:1: (lv_row_7_0= RULE_INT )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:782:1: (lv_row_7_0= RULE_INT )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:783:3: lv_row_7_0= RULE_INT
                    {
                    lv_row_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePrimary1496); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_row_7_0, grammarAccess.getPrimaryAccess().getRowINTTerminalRuleCall_2_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"row",
                              		lv_row_7_0, 
                              		"INT");
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,24,FOLLOW_24_in_rulePrimary1513); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryAccess().getRightSquareBracketKeyword_2_4());
                          
                    }
                    otherlv_9=(Token)match(input,23,FOLLOW_23_in_rulePrimary1525); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftSquareBracketKeyword_2_5());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:807:1: ( (lv_column_10_0= RULE_INT ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:808:1: (lv_column_10_0= RULE_INT )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:808:1: (lv_column_10_0= RULE_INT )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:809:3: lv_column_10_0= RULE_INT
                    {
                    lv_column_10_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePrimary1542); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_column_10_0, grammarAccess.getPrimaryAccess().getColumnINTTerminalRuleCall_2_6_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"column",
                              		lv_column_10_0, 
                              		"INT");
                      	    
                    }

                    }


                    }

                    otherlv_11=(Token)match(input,24,FOLLOW_24_in_rulePrimary1559); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getPrimaryAccess().getRightSquareBracketKeyword_2_7());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:830:6: ( () ( (lv_function_13_0= ruleFunction ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:830:6: ( () ( (lv_function_13_0= ruleFunction ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:830:7: () ( (lv_function_13_0= ruleFunction ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:830:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:831:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getFunctionAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:839:2: ( (lv_function_13_0= ruleFunction ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:840:1: (lv_function_13_0= ruleFunction )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:840:1: (lv_function_13_0= ruleFunction )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:841:3: lv_function_13_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getFunctionFunctionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_rulePrimary1600);
                    lv_function_13_0=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"function",
                              		lv_function_13_0, 
                              		"Function");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:858:6: (otherlv_14= '(' this_Addition_15= ruleAddition otherlv_16= ')' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:858:6: (otherlv_14= '(' this_Addition_15= ruleAddition otherlv_16= ')' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:858:8: otherlv_14= '(' this_Addition_15= ruleAddition otherlv_16= ')'
                    {
                    otherlv_14=(Token)match(input,20,FOLLOW_20_in_rulePrimary1620); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getAdditionParserRuleCall_4_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAddition_in_rulePrimary1645);
                    this_Addition_15=ruleAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Addition_15; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_16=(Token)match(input,19,FOLLOW_19_in_rulePrimary1656); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_4_2());
                          
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


    // $ANTLR start "entryRuleMatrix"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:886:1: entryRuleMatrix returns [EObject current=null] : iv_ruleMatrix= ruleMatrix EOF ;
    public final EObject entryRuleMatrix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrix = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:887:2: (iv_ruleMatrix= ruleMatrix EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:888:2: iv_ruleMatrix= ruleMatrix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRule()); 
            }
            pushFollow(FOLLOW_ruleMatrix_in_entryRuleMatrix1693);
            iv_ruleMatrix=ruleMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrix1703); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrix"


    // $ANTLR start "ruleMatrix"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:895:1: ruleMatrix returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
    public final EObject ruleMatrix() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_rows_1_0 = null;

        EObject lv_rows_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:898:28: ( (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:899:1: (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:899:1: (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:899:3: otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleMatrix1740); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:903:1: ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:903:2: ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:903:2: ( (lv_rows_1_0= ruleMatrixRow ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:904:1: (lv_rows_1_0= ruleMatrixRow )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:904:1: (lv_rows_1_0= ruleMatrixRow )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:905:3: lv_rows_1_0= ruleMatrixRow
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixAccess().getRowsMatrixRowParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrix1762);
                    lv_rows_1_0=ruleMatrixRow();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMatrixRule());
                      	        }
                             		add(
                             			current, 
                             			"rows",
                              		lv_rows_1_0, 
                              		"MatrixRow");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:921:2: (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==26) ) {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1==25) ) {
                                alt7=1;
                            }


                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:921:4: otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleMatrix1775); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:925:1: ( (lv_rows_3_0= ruleMatrixRow ) )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:926:1: (lv_rows_3_0= ruleMatrixRow )
                    	    {
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:926:1: (lv_rows_3_0= ruleMatrixRow )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:927:3: lv_rows_3_0= ruleMatrixRow
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixAccess().getRowsMatrixRowParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrix1796);
                    	    lv_rows_3_0=ruleMatrixRow();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMatrixRule());
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


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:943:4: (otherlv_4= ',' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==26) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:943:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleMatrix1811); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleMatrix1827); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMatrixAccess().getRightCurlyBracketKeyword_2());
                  
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
    // $ANTLR end "ruleMatrix"


    // $ANTLR start "entryRuleMatrixRow"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:959:1: entryRuleMatrixRow returns [EObject current=null] : iv_ruleMatrixRow= ruleMatrixRow EOF ;
    public final EObject entryRuleMatrixRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixRow = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:960:2: (iv_ruleMatrixRow= ruleMatrixRow EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:961:2: iv_ruleMatrixRow= ruleMatrixRow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRowRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow1863);
            iv_ruleMatrixRow=ruleMatrixRow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixRow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixRow1873); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:968:1: ruleMatrixRow returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
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
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:971:28: ( (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:972:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:972:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:972:3: otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleMatrixRow1910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixRowAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:976:1: ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:976:2: ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:976:2: ( (lv_elements_1_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:977:1: (lv_elements_1_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:977:1: (lv_elements_1_0= ruleFloat )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:978:3: lv_elements_1_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow1932);
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:994:2: (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==26) ) {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1==RULE_INT) ) {
                                alt10=1;
                            }


                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:994:4: otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleMatrixRow1945); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:998:1: ( (lv_elements_3_0= ruleFloat ) )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:999:1: (lv_elements_3_0= ruleFloat )
                    	    {
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:999:1: (lv_elements_3_0= ruleFloat )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1000:3: lv_elements_3_0= ruleFloat
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow1966);
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
                    	    break loop10;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1016:4: (otherlv_4= ',' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==26) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1016:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleMatrixRow1981); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleMatrixRow1997); if (state.failed) return current;
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


    // $ANTLR start "entryRuleMatrixAssignment"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1032:1: entryRuleMatrixAssignment returns [EObject current=null] : iv_ruleMatrixAssignment= ruleMatrixAssignment EOF ;
    public final EObject entryRuleMatrixAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAssignment = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1033:2: (iv_ruleMatrixAssignment= ruleMatrixAssignment EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1034:2: iv_ruleMatrixAssignment= ruleMatrixAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAssignment_in_entryRuleMatrixAssignment2033);
            iv_ruleMatrixAssignment=ruleMatrixAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAssignment2043); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrixAssignment"


    // $ANTLR start "ruleMatrixAssignment"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1041:1: ruleMatrixAssignment returns [EObject current=null] : (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) ) ;
    public final EObject ruleMatrixAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1044:28: ( (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1045:1: (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1045:1: (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1045:3: otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleMatrixAssignment2080); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAssignmentAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1049:1: ( (lv_variable_1_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1050:1: (lv_variable_1_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1050:1: (lv_variable_1_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1051:3: lv_variable_1_0= RULE_MATH_NAME
            {
            lv_variable_1_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleMatrixAssignment2097); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_variable_1_0, grammarAccess.getMatrixAssignmentAccess().getVariableMATH_NAMETerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMatrixAssignmentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"variable",
                      		lv_variable_1_0, 
                      		"MATH_NAME");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleMatrixAssignment2114); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMatrixAssignmentAccess().getRightSquareBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleMatrixAssignment2126); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMatrixAssignmentAccess().getEqualsSignKeyword_3());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1075:1: ( (lv_value_4_0= ruleMatrixFormula ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1076:1: (lv_value_4_0= ruleMatrixFormula )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1076:1: (lv_value_4_0= ruleMatrixFormula )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1077:3: lv_value_4_0= ruleMatrixFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixAssignmentAccess().getValueMatrixFormulaParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixFormula_in_ruleMatrixAssignment2147);
            lv_value_4_0=ruleMatrixFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMatrixAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_4_0, 
                      		"MatrixFormula");
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
    // $ANTLR end "ruleMatrixAssignment"


    // $ANTLR start "entryRuleMatrixFormula"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1101:1: entryRuleMatrixFormula returns [EObject current=null] : iv_ruleMatrixFormula= ruleMatrixFormula EOF ;
    public final EObject entryRuleMatrixFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixFormula = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1102:2: (iv_ruleMatrixFormula= ruleMatrixFormula EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1103:2: iv_ruleMatrixFormula= ruleMatrixFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixFormula_in_entryRuleMatrixFormula2183);
            iv_ruleMatrixFormula=ruleMatrixFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixFormula2193); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrixFormula"


    // $ANTLR start "ruleMatrixFormula"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1110:1: ruleMatrixFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleMatrixAddition ) ) ;
    public final EObject ruleMatrixFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1113:28: ( ( (lv_expression_0_0= ruleMatrixAddition ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1114:1: ( (lv_expression_0_0= ruleMatrixAddition ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1114:1: ( (lv_expression_0_0= ruleMatrixAddition ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1115:1: (lv_expression_0_0= ruleMatrixAddition )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1115:1: (lv_expression_0_0= ruleMatrixAddition )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1116:3: lv_expression_0_0= ruleMatrixAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixFormulaAccess().getExpressionMatrixAdditionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_ruleMatrixFormula2238);
            lv_expression_0_0=ruleMatrixAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMatrixFormulaRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_0_0, 
                      		"MatrixAddition");
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
    // $ANTLR end "ruleMatrixFormula"


    // $ANTLR start "entryRuleMatrixAddition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1140:1: entryRuleMatrixAddition returns [EObject current=null] : iv_ruleMatrixAddition= ruleMatrixAddition EOF ;
    public final EObject entryRuleMatrixAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAddition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1141:2: (iv_ruleMatrixAddition= ruleMatrixAddition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1142:2: iv_ruleMatrixAddition= ruleMatrixAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_entryRuleMatrixAddition2273);
            iv_ruleMatrixAddition=ruleMatrixAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAddition2283); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrixAddition"


    // $ANTLR start "ruleMatrixAddition"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1149:1: ruleMatrixAddition returns [EObject current=null] : (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* ) ;
    public final EObject ruleMatrixAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_MatrixMultiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1152:28: ( (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1153:1: (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1153:1: (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1154:2: this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMatrixAdditionAccess().getMatrixMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2333);
            this_MatrixMultiplication_0=ruleMatrixMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MatrixMultiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1165:1: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==13) ) {
                    alt13=1;
                }
                else if ( (LA13_0==14) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1165:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1165:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1165:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleMatrixAddition2346); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMatrixAdditionAccess().getPlusSignKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1169:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1170:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMatrixAdditionAccess().getMatrixAdditionLeftAction_1_0_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1178:2: ( (lv_right_3_0= ruleMatrixMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1179:1: (lv_right_3_0= ruleMatrixMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1179:1: (lv_right_3_0= ruleMatrixMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1180:3: lv_right_3_0= ruleMatrixMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2379);
            	    lv_right_3_0=ruleMatrixMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMatrixAdditionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"MatrixMultiplication");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1197:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1197:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1197:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleMatrixAddition2399); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMatrixAdditionAccess().getHyphenMinusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1201:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1202:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMatrixAdditionAccess().getMatrixSubtractionLeftAction_1_1_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1210:2: ( (lv_right_6_0= ruleMatrixMultiplication ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1211:1: (lv_right_6_0= ruleMatrixMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1211:1: (lv_right_6_0= ruleMatrixMultiplication )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1212:3: lv_right_6_0= ruleMatrixMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2432);
            	    lv_right_6_0=ruleMatrixMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMatrixAdditionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_6_0, 
            	              		"MatrixMultiplication");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // $ANTLR end "ruleMatrixAddition"


    // $ANTLR start "entryRuleMatrixMultiplication"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1236:1: entryRuleMatrixMultiplication returns [EObject current=null] : iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF ;
    public final EObject entryRuleMatrixMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1237:2: (iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1238:2: iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixMultiplication_in_entryRuleMatrixMultiplication2471);
            iv_ruleMatrixMultiplication=ruleMatrixMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixMultiplication2481); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrixMultiplication"


    // $ANTLR start "ruleMatrixMultiplication"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1245:1: ruleMatrixMultiplication returns [EObject current=null] : (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* ) ;
    public final EObject ruleMatrixMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PrimaryMatrix_0 = null;

        EObject lv_rightMatrix_3_0 = null;

        EObject lv_rightScalar_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1248:28: ( (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1249:1: (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1249:1: (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1250:2: this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getPrimaryMatrixParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2531);
            this_PrimaryMatrix_0=rulePrimaryMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrimaryMatrix_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:1: ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==15) ) {
                    int LA14_5 = input.LA(2);

                    if ( (synpred25_InternalMath()) ) {
                        alt14=1;
                    }
                    else if ( (synpred26_InternalMath()) ) {
                        alt14=2;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:4: otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMatrixMultiplication2544); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMatrixMultiplicationAccess().getAsteriskKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1265:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1266:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_0_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1274:2: ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1275:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1275:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1276:3: lv_rightMatrix_3_0= rulePrimaryMatrix
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightMatrixPrimaryMatrixParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2577);
            	    lv_rightMatrix_3_0=rulePrimaryMatrix();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMatrixMultiplicationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightMatrix",
            	              		lv_rightMatrix_3_0, 
            	              		"PrimaryMatrix");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1293:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1293:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1293:8: otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) )
            	    {
            	    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleMatrixMultiplication2597); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMatrixMultiplicationAccess().getAsteriskKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1297:1: ()
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1298:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMatrixMultiplicationAccess().getMatrixMultiplicationLeftAction_1_1_1(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1306:2: ( (lv_rightScalar_6_0= ruleFormula ) )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1307:1: (lv_rightScalar_6_0= ruleFormula )
            	    {
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1307:1: (lv_rightScalar_6_0= ruleFormula )
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1308:3: lv_rightScalar_6_0= ruleFormula
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightScalarFormulaParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFormula_in_ruleMatrixMultiplication2630);
            	    lv_rightScalar_6_0=ruleFormula();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMatrixMultiplicationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightScalar",
            	              		lv_rightScalar_6_0, 
            	              		"Formula");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleMatrixMultiplication"


    // $ANTLR start "entryRulePrimaryMatrix"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1332:1: entryRulePrimaryMatrix returns [EObject current=null] : iv_rulePrimaryMatrix= rulePrimaryMatrix EOF ;
    public final EObject entryRulePrimaryMatrix() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryMatrix = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1333:2: (iv_rulePrimaryMatrix= rulePrimaryMatrix EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1334:2: iv_rulePrimaryMatrix= rulePrimaryMatrix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryMatrixRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryMatrix_in_entryRulePrimaryMatrix2669);
            iv_rulePrimaryMatrix=rulePrimaryMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryMatrix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryMatrix2679); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimaryMatrix"


    // $ANTLR start "rulePrimaryMatrix"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1341:1: rulePrimaryMatrix returns [EObject current=null] : ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) ) ;
    public final EObject rulePrimaryMatrix() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_matrix_1_0 = null;

        EObject this_MatrixAddition_11 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1344:28: ( ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1345:1: ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1345:1: ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt15=1;
                }
                break;
            case 23:
                {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==RULE_MATH_NAME) ) {
                    int LA15_4 = input.LA(3);

                    if ( (LA15_4==24) ) {
                        alt15=3;
                    }
                    else if ( (LA15_4==28) ) {
                        alt15=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                alt15=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1345:2: ( () ( (lv_matrix_1_0= ruleMatrix ) ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1345:2: ( () ( (lv_matrix_1_0= ruleMatrix ) ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1345:3: () ( (lv_matrix_1_0= ruleMatrix ) )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1345:3: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1346:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryMatrixAccess().getNewMatrixAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1354:2: ( (lv_matrix_1_0= ruleMatrix ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1355:1: (lv_matrix_1_0= ruleMatrix )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1355:1: (lv_matrix_1_0= ruleMatrix )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1356:3: lv_matrix_1_0= ruleMatrix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getMatrixMatrixParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrix_in_rulePrimaryMatrix2738);
                    lv_matrix_1_0=ruleMatrix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryMatrixRule());
                      	        }
                             		set(
                             			current, 
                             			"matrix",
                              		lv_matrix_1_0, 
                              		"Matrix");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1373:6: ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1373:6: ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1373:7: () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T'
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1373:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1374:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryMatrixAccess().getTransposeMatrixAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_rulePrimaryMatrix2770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryMatrixAccess().getLeftSquareBracketKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1386:1: ( (lv_name_4_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1387:1: (lv_name_4_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1387:1: (lv_name_4_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1388:3: lv_name_4_0= RULE_MATH_NAME
                    {
                    lv_name_4_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix2787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getPrimaryMatrixAccess().getNameMATH_NAMETerminalRuleCall_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryMatrixRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"MATH_NAME");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePrimaryMatrix2804); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryMatrixAccess().getTKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1409:6: ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1409:6: ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1409:7: () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']'
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1409:7: ()
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1410:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryMatrixAccess().getMatrixVariableAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_rulePrimaryMatrix2836); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPrimaryMatrixAccess().getLeftSquareBracketKeyword_2_1());
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1422:1: ( (lv_name_8_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1423:1: (lv_name_8_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1423:1: (lv_name_8_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1424:3: lv_name_8_0= RULE_MATH_NAME
                    {
                    lv_name_8_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix2853); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_8_0, grammarAccess.getPrimaryMatrixAccess().getNameMATH_NAMETerminalRuleCall_2_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryMatrixRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_8_0, 
                              		"MATH_NAME");
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_rulePrimaryMatrix2870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getPrimaryMatrixAccess().getRightSquareBracketKeyword_2_3());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1445:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1445:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1445:8: otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')'
                    {
                    otherlv_10=(Token)match(input,20,FOLLOW_20_in_rulePrimaryMatrix2890); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getPrimaryMatrixAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getMatrixAdditionParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMatrixAddition_in_rulePrimaryMatrix2915);
                    this_MatrixAddition_11=ruleMatrixAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MatrixAddition_11; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_12=(Token)match(input,19,FOLLOW_19_in_rulePrimaryMatrix2926); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getPrimaryMatrixAccess().getRightParenthesisKeyword_3_2());
                          
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
    // $ANTLR end "rulePrimaryMatrix"


    // $ANTLR start "entryRuleFloat"
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1473:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1474:2: (iv_ruleFloat= ruleFloat EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1475:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_ruleFloat_in_entryRuleFloat2964);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFloat2975); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1482:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1485:28: ( ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1486:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1486:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1486:2: (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1486:2: (this_INT_0= RULE_INT )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_INT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1486:7: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3016); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_0, grammarAccess.getFloatAccess().getINTTerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1493:3: (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==29) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1494:2: kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleFloat3037); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1499:1: (this_INT_2= RULE_INT )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_INT) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1499:6: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3053); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_INT_2);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_INT_2, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1506:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=30 && LA21_0<=31)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1506:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+
                            {
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1506:4: (kw= 'E' | kw= 'e' )
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==30) ) {
                                alt18=1;
                            }
                            else if ( (LA18_0==31) ) {
                                alt18=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 0, input);

                                throw nvae;
                            }
                            switch (alt18) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1507:2: kw= 'E'
                                    {
                                    kw=(Token)match(input,30,FOLLOW_30_in_ruleFloat3075); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1514:2: kw= 'e'
                                    {
                                    kw=(Token)match(input,31,FOLLOW_31_in_ruleFloat3094); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1519:2: (kw= '-' )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==14) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1520:2: kw= '-'
                                    {
                                    kw=(Token)match(input,14,FOLLOW_14_in_ruleFloat3109); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getHyphenMinusKeyword_1_2_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1525:3: (this_INT_6= RULE_INT )+
                            int cnt20=0;
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==RULE_INT) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1525:8: this_INT_6= RULE_INT
                            	    {
                            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3127); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      		current.merge(this_INT_6);
                            	          
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_INT_6, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_2_2()); 
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt20 >= 1 ) break loop20;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(20, input);
                                        throw eee;
                                }
                                cnt20++;
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1540:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1541:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1542:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction3178);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction3188); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1549:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) ;
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
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1552:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1553:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1553:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1553:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')'
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1553:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1554:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1554:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1555:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunction3230); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleFunction3247); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1575:1: ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_MATH_NAME && LA25_0<=RULE_INT)||LA25_0==18||LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1575:2: ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )?
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1575:2: ( (lv_parameters_2_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1576:1: (lv_parameters_2_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1576:1: (lv_parameters_2_0= ruleFormula )
                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1577:3: lv_parameters_2_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleFunction3269);
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

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1593:2: (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==26) ) {
                            int LA23_1 = input.LA(2);

                            if ( ((LA23_1>=RULE_MATH_NAME && LA23_1<=RULE_INT)||LA23_1==18||LA23_1==20) ) {
                                alt23=1;
                            }


                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1593:4: otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) )
                    	    {
                    	    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleFunction3282); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1597:1: ( (lv_parameters_4_0= ruleFormula ) )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1598:1: (lv_parameters_4_0= ruleFormula )
                    	    {
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1598:1: (lv_parameters_4_0= ruleFormula )
                    	    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1599:3: lv_parameters_4_0= ruleFormula
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFormula_in_ruleFunction3303);
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
                    	    break loop23;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1615:4: (otherlv_5= ',' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==26) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1615:6: otherlv_5= ','
                            {
                            otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleFunction3318); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleFunction3334); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1631:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1632:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1633:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition3370);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition3380); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1640:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_function_0_0 = null;

        EObject lv_formula_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1643:28: ( ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1644:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1644:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1644:2: ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1644:2: ( (lv_function_0_0= ruleFunction ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1645:1: (lv_function_0_0= ruleFunction )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1645:1: (lv_function_0_0= ruleFunction )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1646:3: lv_function_0_0= ruleFunction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctionFunctionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleFunctionDefinition3426);
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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleFunctionDefinition3438); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1666:1: ( (lv_formula_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1667:1: (lv_formula_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1667:1: (lv_formula_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1668:3: lv_formula_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleFunctionDefinition3459);
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
        EObject lv_variableAssignment_1_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:107:3: lv_variableAssignment_1_0= ruleVariableAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getVariableAssignmentVariableAssignmentParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVariableAssignment_in_synpred2_InternalMath164);
        lv_variableAssignment_1_0=ruleVariableAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalMath

    // $ANTLR start synpred3_InternalMath
    public final void synpred3_InternalMath_fragment() throws RecognitionException {   
        EObject lv_formula_2_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( ( (lv_formula_2_0= ruleFormula ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_formula_2_0= ruleFormula )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:125:1: (lv_formula_2_0= ruleFormula )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:126:3: lv_formula_2_0= ruleFormula
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getFormulaFormulaParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleFormula_in_synpred3_InternalMath191);
        lv_formula_2_0=ruleFormula();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalMath

    // $ANTLR start synpred4_InternalMath
    public final void synpred4_InternalMath_fragment() throws RecognitionException {   
        EObject lv_matrixAssignment_3_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:6: ( ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:145:3: lv_matrixAssignment_3_0= ruleMatrixAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixAssignmentMatrixAssignmentParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMatrixAssignment_in_synpred4_InternalMath218);
        lv_matrixAssignment_3_0=ruleMatrixAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred4_InternalMath

    // $ANTLR start synpred5_InternalMath
    public final void synpred5_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject lv_right_3_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:2: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:313:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) )
        {
        otherlv_1=(Token)match(input,13,FOLLOW_13_in_synpred5_InternalMath570); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:317:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:318:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:326:2: ( (lv_right_3_0= ruleMultiplication ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_right_3_0= ruleMultiplication )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:327:1: (lv_right_3_0= ruleMultiplication )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:328:3: lv_right_3_0= ruleMultiplication
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplication_in_synpred5_InternalMath603);
        lv_right_3_0=ruleMultiplication();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalMath

    // $ANTLR start synpred6_InternalMath
    public final void synpred6_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_right_6_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:345:6: ( (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:345:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:345:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:345:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) )
        {
        otherlv_4=(Token)match(input,14,FOLLOW_14_in_synpred6_InternalMath623); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:349:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:350:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:358:2: ( (lv_right_6_0= ruleMultiplication ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:359:1: (lv_right_6_0= ruleMultiplication )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:359:1: (lv_right_6_0= ruleMultiplication )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:360:3: lv_right_6_0= ruleMultiplication
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplication_in_synpred6_InternalMath656);
        lv_right_6_0=ruleMultiplication();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalMath

    // $ANTLR start synpred7_InternalMath
    public final void synpred7_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject lv_right_3_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:2: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:409:4: otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) )
        {
        otherlv_1=(Token)match(input,15,FOLLOW_15_in_synpred7_InternalMath768); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:413:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:414:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:422:2: ( (lv_right_3_0= ruleUnaryExpression ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:423:1: (lv_right_3_0= ruleUnaryExpression )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:423:1: (lv_right_3_0= ruleUnaryExpression )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:424:3: lv_right_3_0= ruleUnaryExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleUnaryExpression_in_synpred7_InternalMath801);
        lv_right_3_0=ruleUnaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalMath

    // $ANTLR start synpred10_InternalMath
    public final void synpred10_InternalMath_fragment() throws RecognitionException {   
        EObject this_Exponent_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:526:2: (this_Exponent_0= ruleExponent )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:526:2: this_Exponent_0= ruleExponent
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleExponent_in_synpred10_InternalMath1006);
        this_Exponent_0=ruleExponent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalMath

    // $ANTLR start synpred25_InternalMath
    public final void synpred25_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject lv_rightMatrix_3_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:2: ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1261:4: otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
        {
        otherlv_1=(Token)match(input,15,FOLLOW_15_in_synpred25_InternalMath2544); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1265:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1266:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1274:2: ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1275:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1275:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1276:3: lv_rightMatrix_3_0= rulePrimaryMatrix
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightMatrixPrimaryMatrixParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_rulePrimaryMatrix_in_synpred25_InternalMath2577);
        lv_rightMatrix_3_0=rulePrimaryMatrix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalMath

    // $ANTLR start synpred26_InternalMath
    public final void synpred26_InternalMath_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_rightScalar_6_0 = null;


        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1293:6: ( (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1293:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1293:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1293:8: otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) )
        {
        otherlv_4=(Token)match(input,15,FOLLOW_15_in_synpred26_InternalMath2597); if (state.failed) return ;
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1297:1: ()
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1298:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1306:2: ( (lv_rightScalar_6_0= ruleFormula ) )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1307:1: (lv_rightScalar_6_0= ruleFormula )
        {
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1307:1: (lv_rightScalar_6_0= ruleFormula )
        // ../org.eclipse.iee.translator.jmole.math/src-gen/org/eclipse/iee/translator/jmole/math/parser/antlr/internal/InternalMath.g:1308:3: lv_rightScalar_6_0= ruleFormula
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightScalarFormulaParserRuleCall_1_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleFormula_in_synpred26_InternalMath2630);
        lv_rightScalar_6_0=ruleFormula();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred26_InternalMath

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
    public final boolean synpred10_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalMath_fragment(); // can never throw exception
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
    public final boolean synpred26_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalMath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalMath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalMath_fragment(); // can never throw exception
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
    public final boolean synpred25_InternalMath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalMath_fragment(); // can never throw exception
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
    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA1_eotS =
        "\12\uffff";
    static final String DFA1_eofS =
        "\12\uffff";
    static final String DFA1_minS =
        "\1\4\1\0\1\uffff\1\0\1\uffff\1\0\4\uffff";
    static final String DFA1_maxS =
        "\1\31\1\0\1\uffff\1\0\1\uffff\1\0\4\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\3\3\uffff\1\5\1\1\1\2\1\4";
    static final String DFA1_specialS =
        "\1\uffff\1\0\1\uffff\1\1\1\uffff\1\2\4\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\1\2\14\uffff\1\2\1\uffff\1\3\2\uffff\1\5\1\uffff\1\6",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
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
            return "86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) )";
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
                        if ( (synpred1_InternalMath()) ) {s = 7;}

                        else if ( (synpred2_InternalMath()) ) {s = 8;}

                        else if ( (synpred3_InternalMath()) ) {s = 2;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalMath()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMath()) ) {s = 9;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index1_5);
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
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\1\1\11\uffff";
    static final String DFA3_minS =
        "\1\15\4\uffff\1\0\4\uffff";
    static final String DFA3_maxS =
        "\1\32\4\uffff\1\0\4\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\4\5\uffff\1\2\1\3\1\1";
    static final String DFA3_specialS =
        "\5\uffff\1\0\4\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\1\1\5\1\7\1\10\1\uffff\1\1\6\uffff\1\1",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 409:1: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalMath()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_ruleStatement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_ruleStatement164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleStatement191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAssignment_in_ruleStatement218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixFormula_in_ruleStatement245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_entryRuleVariableAssignment281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableAssignment291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleVariableAssignment333 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVariableAssignment350 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleVariableAssignment371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleFormula462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition557 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_13_in_ruleAddition570 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition603 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_14_in_ruleAddition623 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition656 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication755 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_15_in_ruleMultiplication768 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication801 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplication821 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication854 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_17_in_ruleMultiplication874 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication907 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_ruleUnaryExpression1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleUnaryExpression1024 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1057 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleUnaryExpression1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleUnaryExpression1089 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1122 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnaryExpression1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_entryRuleExponent1171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExponent1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1231 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleExponent1255 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary1314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimary1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimary1462 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePrimary1479 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePrimary1496 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimary1513 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePrimary1525 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePrimary1542 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimary1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rulePrimary1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rulePrimary1620 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleAddition_in_rulePrimary1645 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePrimary1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrix_in_entryRuleMatrix1693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrix1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleMatrix1740 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrix1762 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrix1775 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrix1796 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrix1811 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrix1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow1863 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixRow1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleMatrixRow1910 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow1932 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrixRow1945 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow1966 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrixRow1981 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrixRow1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAssignment_in_entryRuleMatrixAssignment2033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAssignment2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleMatrixAssignment2080 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleMatrixAssignment2097 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMatrixAssignment2114 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMatrixAssignment2126 = new BitSet(new long[]{0x0000000002900000L});
    public static final BitSet FOLLOW_ruleMatrixFormula_in_ruleMatrixAssignment2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixFormula_in_entryRuleMatrixFormula2183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixFormula2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_ruleMatrixFormula2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_entryRuleMatrixAddition2273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAddition2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2333 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_13_in_ruleMatrixAddition2346 = new BitSet(new long[]{0x0000000002900000L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2379 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_14_in_ruleMatrixAddition2399 = new BitSet(new long[]{0x0000000002900000L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2432 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_entryRuleMatrixMultiplication2471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixMultiplication2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2531 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleMatrixMultiplication2544 = new BitSet(new long[]{0x0000000002900000L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2577 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleMatrixMultiplication2597 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleMatrixMultiplication2630 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_entryRulePrimaryMatrix2669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryMatrix2679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrix_in_rulePrimaryMatrix2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePrimaryMatrix2770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix2787 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePrimaryMatrix2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePrimaryMatrix2836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix2853 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimaryMatrix2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rulePrimaryMatrix2890 = new BitSet(new long[]{0x0000000002900000L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_rulePrimaryMatrix2915 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePrimaryMatrix2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_entryRuleFloat2964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFloat2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3016 = new BitSet(new long[]{0x0000000020000022L});
    public static final BitSet FOLLOW_29_in_ruleFloat3037 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3053 = new BitSet(new long[]{0x00000000C0000022L});
    public static final BitSet FOLLOW_30_in_ruleFloat3075 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_31_in_ruleFloat3094 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_14_in_ruleFloat3109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3127 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction3178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunction3230 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFunction3247 = new BitSet(new long[]{0x00000000001C0030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction3269 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_26_in_ruleFunction3282 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction3303 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_26_in_ruleFunction3318 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFunction3334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition3370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleFunctionDefinition3426 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFunctionDefinition3438 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunctionDefinition3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_synpred1_InternalMath137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_synpred2_InternalMath164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_synpred3_InternalMath191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAssignment_in_synpred4_InternalMath218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred5_InternalMath570 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_synpred5_InternalMath603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_synpred6_InternalMath623 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_synpred6_InternalMath656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_synpred7_InternalMath768 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_synpred7_InternalMath801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_synpred10_InternalMath1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_synpred25_InternalMath2544 = new BitSet(new long[]{0x0000000002900000L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_synpred25_InternalMath2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_synpred26_InternalMath2597 = new BitSet(new long[]{0x0000000000140030L});
    public static final BitSet FOLLOW_ruleFormula_in_synpred26_InternalMath2630 = new BitSet(new long[]{0x0000000000000002L});

}