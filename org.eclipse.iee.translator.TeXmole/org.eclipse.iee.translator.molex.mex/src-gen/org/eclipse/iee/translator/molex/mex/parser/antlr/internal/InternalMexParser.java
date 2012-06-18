package org.eclipse.iee.translator.molex.mex.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.iee.translator.molex.mex.services.MexGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMexParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_MATH_NAME", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'(-'", "')!'", "'^'", "'['", "']'", "'.'", "'{'", "','", "'}'", "']^T'", "'E'", "'e'"
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
    public static final int RULE_MATH_NAME=5;
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
    public static final int RULE_INT=4;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalMexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMexParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private MexGrammarAccess grammarAccess;
     	
        public InternalMexParser(TokenStream input, MexGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statement";	
       	}
       	
       	@Override
       	protected MexGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStatement"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:73:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:74:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:75:2: iv_ruleStatement= ruleStatement EOF
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:82:1: ruleStatement returns [EObject current=null] : ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_functionDefinition_0_0 = null;

        EObject lv_variableAssignment_1_0 = null;

        EObject lv_formula_2_0 = null;

        EObject lv_matrixAssignment_3_0 = null;

        EObject lv_matrixFormula_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:85:28: ( ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) | ( (lv_formula_2_0= ruleFormula ) ) | ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) | ( (lv_matrixFormula_4_0= ruleMatrixFormula ) ) )
            int alt1=5;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:88:3: lv_functionDefinition_0_0= ruleFunctionDefinition
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:107:3: lv_variableAssignment_1_0= ruleVariableAssignment
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_formula_2_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_formula_2_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:126:3: lv_formula_2_0= ruleFormula
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:145:3: lv_matrixAssignment_3_0= ruleMatrixAssignment
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:162:6: ( (lv_matrixFormula_4_0= ruleMatrixFormula ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:162:6: ( (lv_matrixFormula_4_0= ruleMatrixFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:163:1: (lv_matrixFormula_4_0= ruleMatrixFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:163:1: (lv_matrixFormula_4_0= ruleMatrixFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:164:3: lv_matrixFormula_4_0= ruleMatrixFormula
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:188:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:189:2: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:190:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:197:1: ruleVariableAssignment returns [EObject current=null] : ( ( (lv_variable_0_0= ruleMathName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_variable_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:200:28: ( ( ( (lv_variable_0_0= ruleMathName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:1: ( ( (lv_variable_0_0= ruleMathName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:1: ( ( (lv_variable_0_0= ruleMathName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:2: ( (lv_variable_0_0= ruleMathName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:2: ( (lv_variable_0_0= ruleMathName ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:202:1: (lv_variable_0_0= ruleMathName )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:202:1: (lv_variable_0_0= ruleMathName )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:203:3: lv_variable_0_0= ruleMathName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getVariableMathNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMathName_in_ruleVariableAssignment337);
            lv_variable_0_0=ruleMathName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"variable",
                      		lv_variable_0_0, 
                      		"MathName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleVariableAssignment349); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVariableAssignmentAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:223:1: ( (lv_value_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:224:1: (lv_value_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:224:1: (lv_value_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:225:3: lv_value_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleVariableAssignment370);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:249:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:250:2: (iv_ruleFormula= ruleFormula EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:251:2: iv_ruleFormula= ruleFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleFormula_in_entryRuleFormula406);
            iv_ruleFormula=ruleFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormula416); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:258:1: ruleFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleAddition ) ) ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:261:28: ( ( (lv_expression_0_0= ruleAddition ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:262:1: ( (lv_expression_0_0= ruleAddition ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:262:1: ( (lv_expression_0_0= ruleAddition ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:263:1: (lv_expression_0_0= ruleAddition )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:263:1: (lv_expression_0_0= ruleAddition )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:264:3: lv_expression_0_0= ruleAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormulaAccess().getExpressionAdditionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleFormula461);
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


    // $ANTLR start "entryRuleAdditionInBrackets"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:288:1: entryRuleAdditionInBrackets returns [EObject current=null] : iv_ruleAdditionInBrackets= ruleAdditionInBrackets EOF ;
    public final EObject entryRuleAdditionInBrackets() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionInBrackets = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:289:2: (iv_ruleAdditionInBrackets= ruleAdditionInBrackets EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:290:2: iv_ruleAdditionInBrackets= ruleAdditionInBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionInBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleAdditionInBrackets_in_entryRuleAdditionInBrackets496);
            iv_ruleAdditionInBrackets=ruleAdditionInBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditionInBrackets; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditionInBrackets506); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAdditionInBrackets"


    // $ANTLR start "ruleAdditionInBrackets"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:297:1: ruleAdditionInBrackets returns [EObject current=null] : (otherlv_0= '(' ( (lv_addition_1_0= ruleAddition ) ) otherlv_2= ')' ) ;
    public final EObject ruleAdditionInBrackets() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_addition_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:300:28: ( (otherlv_0= '(' ( (lv_addition_1_0= ruleAddition ) ) otherlv_2= ')' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:301:1: (otherlv_0= '(' ( (lv_addition_1_0= ruleAddition ) ) otherlv_2= ')' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:301:1: (otherlv_0= '(' ( (lv_addition_1_0= ruleAddition ) ) otherlv_2= ')' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:301:3: otherlv_0= '(' ( (lv_addition_1_0= ruleAddition ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAdditionInBrackets543); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdditionInBracketsAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:305:1: ( (lv_addition_1_0= ruleAddition ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:306:1: (lv_addition_1_0= ruleAddition )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:306:1: (lv_addition_1_0= ruleAddition )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:307:3: lv_addition_1_0= ruleAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditionInBracketsAccess().getAdditionAdditionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleAdditionInBrackets564);
            lv_addition_1_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAdditionInBracketsRule());
              	        }
                     		set(
                     			current, 
                     			"addition",
                      		lv_addition_1_0, 
                      		"Addition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleAdditionInBrackets576); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAdditionInBracketsAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleAdditionInBrackets"


    // $ANTLR start "entryRuleAddition"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:335:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:336:2: (iv_ruleAddition= ruleAddition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:337:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition612);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition622); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:344:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:347:28: ( (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:348:1: (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:348:1: (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:349:2: this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition672);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:1: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )*
            loop2:
            do {
                int alt2=3;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleAddition685); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:364:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:365:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:373:2: ( (lv_right_3_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:374:1: (lv_right_3_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:374:1: (lv_right_3_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:375:3: lv_right_3_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition718);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:392:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:392:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:392:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleAddition738); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:396:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:397:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:405:2: ( (lv_right_6_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:406:1: (lv_right_6_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:406:1: (lv_right_6_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:407:3: lv_right_6_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition771);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:431:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:432:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:433:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication810);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication820); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:440:1: ruleMultiplication returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:443:28: ( (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:444:1: (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:444:1: (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:445:2: this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication870);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_UnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:1: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*
            loop3:
            do {
                int alt3=4;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:4: otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleMultiplication883); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:460:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:461:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:469:2: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:470:1: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:470:1: (lv_right_3_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:471:3: lv_right_3_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication916);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:488:6: (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:488:6: (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:488:8: otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleMultiplication936); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:492:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:493:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:501:2: ( (lv_right_6_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:502:1: (lv_right_6_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:502:1: (lv_right_6_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:503:3: lv_right_6_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication969);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:520:6: (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:520:6: (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:520:8: otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleMultiplication989); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_2_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:524:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:525:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:533:2: ( (lv_right_9_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:534:1: (lv_right_9_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:534:1: (lv_right_9_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:535:3: lv_right_9_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication1022);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:559:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:560:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:561:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1061);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1071); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:568:1: ruleUnaryExpression returns [EObject current=null] : (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:571:28: ( (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:572:1: (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:572:1: (this_Exponent_0= ruleExponent | (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' ) | (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_MATH_NAME:
                {
                alt4=1;
                }
                break;
            case 13:
                {
                int LA4_3 = input.LA(2);

                if ( (synpred10_InternalMex()) ) {
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
            case 20:
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:573:2: this_Exponent_0= ruleExponent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExponentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExponent_in_ruleUnaryExpression1121);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:585:6: (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:585:6: (otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:585:8: otherlv_1= '(-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleUnaryExpression1139); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisHyphenMinusKeyword_1_0());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:589:1: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:590:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:598:2: ( (lv_expression_3_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:599:1: (lv_expression_3_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:599:1: (lv_expression_3_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:600:3: lv_expression_3_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1172);
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

                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleUnaryExpression1184); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getUnaryExpressionAccess().getRightParenthesisKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:621:6: (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:621:6: (otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:621:8: otherlv_5= '(' () ( (lv_expression_7_0= ruleUnaryExpression ) ) otherlv_8= ')!'
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleUnaryExpression1204); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:625:1: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:626:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:634:2: ( (lv_expression_7_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:635:1: (lv_expression_7_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:635:1: (lv_expression_7_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:636:3: lv_expression_7_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1237);
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

                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleUnaryExpression1249); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:664:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:665:2: (iv_ruleExponent= ruleExponent EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:666:2: iv_ruleExponent= ruleExponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExponentRule()); 
            }
            pushFollow(FOLLOW_ruleExponent_in_entryRuleExponent1286);
            iv_ruleExponent=ruleExponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExponent1296); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:673:1: ruleExponent returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:676:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:677:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:677:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:678:2: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExponentAccess().getPrimaryParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimary_in_ruleExponent1346);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:689:1: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:689:2: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:689:2: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:690:2: 
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

                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleExponent1370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:702:1: ( (lv_right_3_0= rulePrimary ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:703:1: (lv_right_3_0= rulePrimary )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:703:1: (lv_right_3_0= rulePrimary )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:704:3: lv_right_3_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExponentAccess().getRightPrimaryParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimary_in_ruleExponent1391);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:728:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:729:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:730:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary1429);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary1439); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:737:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleMathName ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) | ( () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) ) ) | ( () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) ) ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_18=null;
        Token otherlv_22=null;
        EObject lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;

        EObject lv_function_5_0 = null;

        EObject lv_element_7_0 = null;

        EObject lv_row_9_0 = null;

        EObject lv_column_12_0 = null;

        EObject lv_inBrackets_15_0 = null;

        EObject lv_class__17_0 = null;

        EObject lv_function_19_0 = null;

        EObject lv_class__21_0 = null;

        EObject lv_member_23_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:740:28: ( ( ( () ( (lv_name_1_0= ruleMathName ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) | ( () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) ) ) | ( () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:1: ( ( () ( (lv_name_1_0= ruleMathName ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) | ( () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) ) ) | ( () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:1: ( ( () ( (lv_name_1_0= ruleMathName ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) | ( () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) ) ) | ( () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) ) ) )
            int alt6=7;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:2: ( () ( (lv_name_1_0= ruleMathName ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:2: ( () ( (lv_name_1_0= ruleMathName ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:3: () ( (lv_name_1_0= ruleMathName ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:3: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:742:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:750:2: ( (lv_name_1_0= ruleMathName ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:751:1: (lv_name_1_0= ruleMathName )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:751:1: (lv_name_1_0= ruleMathName )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:752:3: lv_name_1_0= ruleMathName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getNameMathNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMathName_in_rulePrimary1498);
                    lv_name_1_0=ruleMathName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"MathName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:769:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:769:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:769:7: () ( (lv_value_3_0= ruleFloat ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:769:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:770:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:778:2: ( (lv_value_3_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:779:1: (lv_value_3_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:779:1: (lv_value_3_0= ruleFloat )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:780:3: lv_value_3_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getValueFloatParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary1539);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:7: () ( (lv_function_5_0= ruleFunction ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:798:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:806:2: ( (lv_function_5_0= ruleFunction ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:807:1: (lv_function_5_0= ruleFunction )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:807:1: (lv_function_5_0= ruleFunction )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:808:3: lv_function_5_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getFunctionFunctionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_rulePrimary1580);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:6: ( () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:6: ( () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:7: () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']'
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:826:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getMatrixElementAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:834:2: ( (lv_element_7_0= ruleMathName ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:835:1: (lv_element_7_0= ruleMathName )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:835:1: (lv_element_7_0= ruleMathName )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:836:3: lv_element_7_0= ruleMathName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getElementMathNameParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMathName_in_rulePrimary1621);
                    lv_element_7_0=ruleMathName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"element",
                              		lv_element_7_0, 
                              		"MathName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,23,FOLLOW_23_in_rulePrimary1633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryAccess().getLeftSquareBracketKeyword_3_2());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:856:1: ( (lv_row_9_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:857:1: (lv_row_9_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:857:1: (lv_row_9_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:858:3: lv_row_9_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getRowFormulaParserRuleCall_3_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_rulePrimary1654);
                    lv_row_9_0=ruleFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"row",
                              		lv_row_9_0, 
                              		"Formula");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,24,FOLLOW_24_in_rulePrimary1666); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getPrimaryAccess().getRightSquareBracketKeyword_3_4());
                          
                    }
                    otherlv_11=(Token)match(input,23,FOLLOW_23_in_rulePrimary1678); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getPrimaryAccess().getLeftSquareBracketKeyword_3_5());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:882:1: ( (lv_column_12_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:883:1: (lv_column_12_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:883:1: (lv_column_12_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:884:3: lv_column_12_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getColumnFormulaParserRuleCall_3_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_rulePrimary1699);
                    lv_column_12_0=ruleFormula();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"column",
                              		lv_column_12_0, 
                              		"Formula");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,24,FOLLOW_24_in_rulePrimary1711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getPrimaryAccess().getRightSquareBracketKeyword_3_7());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:905:6: ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:905:6: ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:905:7: () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:905:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:906:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getInBracketsAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:914:2: ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:915:1: (lv_inBrackets_15_0= ruleAdditionInBrackets )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:915:1: (lv_inBrackets_15_0= ruleAdditionInBrackets )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:916:3: lv_inBrackets_15_0= ruleAdditionInBrackets
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getInBracketsAdditionInBracketsParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAdditionInBrackets_in_rulePrimary1752);
                    lv_inBrackets_15_0=ruleAdditionInBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"inBrackets",
                              		lv_inBrackets_15_0, 
                              		"AdditionInBrackets");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:933:6: ( () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:933:6: ( () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:933:7: () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:933:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:934:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getClassFunctionAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:942:2: ( (lv_class__17_0= ruleMathName ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:943:1: (lv_class__17_0= ruleMathName )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:943:1: (lv_class__17_0= ruleMathName )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:944:3: lv_class__17_0= ruleMathName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getClass_MathNameParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMathName_in_rulePrimary1793);
                    lv_class__17_0=ruleMathName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"class_",
                              		lv_class__17_0, 
                              		"MathName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_18=(Token)match(input,25,FOLLOW_25_in_rulePrimary1805); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getPrimaryAccess().getFullStopKeyword_5_2());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:964:1: ( (lv_function_19_0= ruleFunction ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:965:1: (lv_function_19_0= ruleFunction )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:965:1: (lv_function_19_0= ruleFunction )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:966:3: lv_function_19_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getFunctionFunctionParserRuleCall_5_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_rulePrimary1826);
                    lv_function_19_0=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"function",
                              		lv_function_19_0, 
                              		"Function");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:983:6: ( () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:983:6: ( () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:983:7: () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:983:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:984:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryAccess().getClassMemberAction_6_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:992:2: ( (lv_class__21_0= ruleMathName ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:993:1: (lv_class__21_0= ruleMathName )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:993:1: (lv_class__21_0= ruleMathName )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:994:3: lv_class__21_0= ruleMathName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getClass_MathNameParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMathName_in_rulePrimary1867);
                    lv_class__21_0=ruleMathName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"class_",
                              		lv_class__21_0, 
                              		"MathName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_22=(Token)match(input,25,FOLLOW_25_in_rulePrimary1879); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getPrimaryAccess().getFullStopKeyword_6_2());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1014:1: ( (lv_member_23_0= ruleMathName ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1015:1: (lv_member_23_0= ruleMathName )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1015:1: (lv_member_23_0= ruleMathName )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1016:3: lv_member_23_0= ruleMathName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getMemberMathNameParserRuleCall_6_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMathName_in_rulePrimary1900);
                    lv_member_23_0=ruleMathName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      	        }
                             		set(
                             			current, 
                             			"member",
                              		lv_member_23_0, 
                              		"MathName");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleMatrix"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1040:1: entryRuleMatrix returns [EObject current=null] : iv_ruleMatrix= ruleMatrix EOF ;
    public final EObject entryRuleMatrix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrix = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1041:2: (iv_ruleMatrix= ruleMatrix EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1042:2: iv_ruleMatrix= ruleMatrix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRule()); 
            }
            pushFollow(FOLLOW_ruleMatrix_in_entryRuleMatrix1937);
            iv_ruleMatrix=ruleMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrix1947); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1049:1: ruleMatrix returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1052:28: ( (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1053:1: (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1053:1: (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1053:3: otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleMatrix1984); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1057:1: ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1057:2: ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1057:2: ( (lv_rows_1_0= ruleMatrixRow ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1058:1: (lv_rows_1_0= ruleMatrixRow )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1058:1: (lv_rows_1_0= ruleMatrixRow )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1059:3: lv_rows_1_0= ruleMatrixRow
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixAccess().getRowsMatrixRowParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrix2006);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1075:2: (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==27) ) {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1==26) ) {
                                alt7=1;
                            }


                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1075:4: otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) )
                    	    {
                    	    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleMatrix2019); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1079:1: ( (lv_rows_3_0= ruleMatrixRow ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1080:1: (lv_rows_3_0= ruleMatrixRow )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1080:1: (lv_rows_3_0= ruleMatrixRow )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1081:3: lv_rows_3_0= ruleMatrixRow
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixAccess().getRowsMatrixRowParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrix2040);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1097:4: (otherlv_4= ',' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==27) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1097:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleMatrix2055); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleMatrix2071); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1113:1: entryRuleMatrixRow returns [EObject current=null] : iv_ruleMatrixRow= ruleMatrixRow EOF ;
    public final EObject entryRuleMatrixRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixRow = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1114:2: (iv_ruleMatrixRow= ruleMatrixRow EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1115:2: iv_ruleMatrixRow= ruleMatrixRow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRowRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow2107);
            iv_ruleMatrixRow=ruleMatrixRow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixRow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixRow2117); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1122:1: ruleMatrixRow returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFormula ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
    public final EObject ruleMatrixRow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1125:28: ( (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFormula ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1126:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFormula ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1126:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFormula ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1126:3: otherlv_0= '{' ( ( (lv_elements_1_0= ruleFormula ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleMatrixRow2154); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixRowAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1130:1: ( ( (lv_elements_1_0= ruleFormula ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )* (otherlv_4= ',' )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_INT && LA12_0<=RULE_MATH_NAME)||LA12_0==13||LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1130:2: ( (lv_elements_1_0= ruleFormula ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1130:2: ( (lv_elements_1_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1131:1: (lv_elements_1_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1131:1: (lv_elements_1_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1132:3: lv_elements_1_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFormulaParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleMatrixRow2176);
                    lv_elements_1_0=ruleFormula();

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
                              		"Formula");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1148:2: (otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==27) ) {
                            int LA10_1 = input.LA(2);

                            if ( ((LA10_1>=RULE_INT && LA10_1<=RULE_MATH_NAME)||LA10_1==13||LA10_1==20) ) {
                                alt10=1;
                            }


                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1148:4: otherlv_2= ',' ( (lv_elements_3_0= ruleFormula ) )
                    	    {
                    	    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleMatrixRow2189); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1152:1: ( (lv_elements_3_0= ruleFormula ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1153:1: (lv_elements_3_0= ruleFormula )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1153:1: (lv_elements_3_0= ruleFormula )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1154:3: lv_elements_3_0= ruleFormula
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFormulaParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFormula_in_ruleMatrixRow2210);
                    	    lv_elements_3_0=ruleFormula();

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
                    	              		"Formula");
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1170:4: (otherlv_4= ',' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==27) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1170:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleMatrixRow2225); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleMatrixRow2241); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1186:1: entryRuleMatrixAssignment returns [EObject current=null] : iv_ruleMatrixAssignment= ruleMatrixAssignment EOF ;
    public final EObject entryRuleMatrixAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAssignment = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1187:2: (iv_ruleMatrixAssignment= ruleMatrixAssignment EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1188:2: iv_ruleMatrixAssignment= ruleMatrixAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAssignment_in_entryRuleMatrixAssignment2277);
            iv_ruleMatrixAssignment=ruleMatrixAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAssignment2287); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1195:1: ruleMatrixAssignment returns [EObject current=null] : (otherlv_0= '[' ( (lv_variable_1_0= ruleMathName ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) ) ;
    public final EObject ruleMatrixAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_variable_1_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1198:28: ( (otherlv_0= '[' ( (lv_variable_1_0= ruleMathName ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1199:1: (otherlv_0= '[' ( (lv_variable_1_0= ruleMathName ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1199:1: (otherlv_0= '[' ( (lv_variable_1_0= ruleMathName ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1199:3: otherlv_0= '[' ( (lv_variable_1_0= ruleMathName ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleMatrixAssignment2324); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAssignmentAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1203:1: ( (lv_variable_1_0= ruleMathName ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1204:1: (lv_variable_1_0= ruleMathName )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1204:1: (lv_variable_1_0= ruleMathName )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1205:3: lv_variable_1_0= ruleMathName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixAssignmentAccess().getVariableMathNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMathName_in_ruleMatrixAssignment2345);
            lv_variable_1_0=ruleMathName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMatrixAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"variable",
                      		lv_variable_1_0, 
                      		"MathName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleMatrixAssignment2357); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMatrixAssignmentAccess().getRightSquareBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleMatrixAssignment2369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMatrixAssignmentAccess().getEqualsSignKeyword_3());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1229:1: ( (lv_value_4_0= ruleMatrixFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1230:1: (lv_value_4_0= ruleMatrixFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1230:1: (lv_value_4_0= ruleMatrixFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1231:3: lv_value_4_0= ruleMatrixFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixAssignmentAccess().getValueMatrixFormulaParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixFormula_in_ruleMatrixAssignment2390);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1255:1: entryRuleMatrixFormula returns [EObject current=null] : iv_ruleMatrixFormula= ruleMatrixFormula EOF ;
    public final EObject entryRuleMatrixFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixFormula = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1256:2: (iv_ruleMatrixFormula= ruleMatrixFormula EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1257:2: iv_ruleMatrixFormula= ruleMatrixFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixFormula_in_entryRuleMatrixFormula2426);
            iv_ruleMatrixFormula=ruleMatrixFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixFormula2436); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1264:1: ruleMatrixFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleMatrixAddition ) ) ;
    public final EObject ruleMatrixFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1267:28: ( ( (lv_expression_0_0= ruleMatrixAddition ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1268:1: ( (lv_expression_0_0= ruleMatrixAddition ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1268:1: ( (lv_expression_0_0= ruleMatrixAddition ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1269:1: (lv_expression_0_0= ruleMatrixAddition )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1269:1: (lv_expression_0_0= ruleMatrixAddition )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1270:3: lv_expression_0_0= ruleMatrixAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixFormulaAccess().getExpressionMatrixAdditionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_ruleMatrixFormula2481);
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


    // $ANTLR start "entryRuleMatrixAdditionInBrackets"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1294:1: entryRuleMatrixAdditionInBrackets returns [EObject current=null] : iv_ruleMatrixAdditionInBrackets= ruleMatrixAdditionInBrackets EOF ;
    public final EObject entryRuleMatrixAdditionInBrackets() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAdditionInBrackets = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1295:2: (iv_ruleMatrixAdditionInBrackets= ruleMatrixAdditionInBrackets EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1296:2: iv_ruleMatrixAdditionInBrackets= ruleMatrixAdditionInBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAdditionInBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAdditionInBrackets_in_entryRuleMatrixAdditionInBrackets2516);
            iv_ruleMatrixAdditionInBrackets=ruleMatrixAdditionInBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAdditionInBrackets; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAdditionInBrackets2526); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMatrixAdditionInBrackets"


    // $ANTLR start "ruleMatrixAdditionInBrackets"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1303:1: ruleMatrixAdditionInBrackets returns [EObject current=null] : (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' ) ;
    public final EObject ruleMatrixAdditionInBrackets() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_addition_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1306:28: ( (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1307:1: (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1307:1: (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1307:3: otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleMatrixAdditionInBrackets2563); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAdditionInBracketsAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1311:1: ( (lv_addition_1_0= ruleMatrixAddition ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1312:1: (lv_addition_1_0= ruleMatrixAddition )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1312:1: (lv_addition_1_0= ruleMatrixAddition )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1313:3: lv_addition_1_0= ruleMatrixAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixAdditionInBracketsAccess().getAdditionMatrixAdditionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_ruleMatrixAdditionInBrackets2584);
            lv_addition_1_0=ruleMatrixAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMatrixAdditionInBracketsRule());
              	        }
                     		set(
                     			current, 
                     			"addition",
                      		lv_addition_1_0, 
                      		"MatrixAddition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMatrixAdditionInBrackets2596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMatrixAdditionInBracketsAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleMatrixAdditionInBrackets"


    // $ANTLR start "entryRuleMatrixAddition"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1341:1: entryRuleMatrixAddition returns [EObject current=null] : iv_ruleMatrixAddition= ruleMatrixAddition EOF ;
    public final EObject entryRuleMatrixAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAddition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1342:2: (iv_ruleMatrixAddition= ruleMatrixAddition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1343:2: iv_ruleMatrixAddition= ruleMatrixAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_entryRuleMatrixAddition2632);
            iv_ruleMatrixAddition=ruleMatrixAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAddition2642); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1350:1: ruleMatrixAddition returns [EObject current=null] : (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* ) ;
    public final EObject ruleMatrixAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_MatrixMultiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1353:28: ( (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1354:1: (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1354:1: (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1355:2: this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMatrixAdditionAccess().getMatrixMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2692);
            this_MatrixMultiplication_0=ruleMatrixMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MatrixMultiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1366:1: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==15) ) {
                    alt13=1;
                }
                else if ( (LA13_0==16) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1366:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1366:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1366:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMatrixAddition2705); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMatrixAdditionAccess().getPlusSignKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1370:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1371:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1379:2: ( (lv_right_3_0= ruleMatrixMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1380:1: (lv_right_3_0= ruleMatrixMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1380:1: (lv_right_3_0= ruleMatrixMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1381:3: lv_right_3_0= ruleMatrixMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2738);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1398:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1398:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1398:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleMatrixAddition2758); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMatrixAdditionAccess().getHyphenMinusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1402:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1403:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1411:2: ( (lv_right_6_0= ruleMatrixMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1412:1: (lv_right_6_0= ruleMatrixMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1412:1: (lv_right_6_0= ruleMatrixMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1413:3: lv_right_6_0= ruleMatrixMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2791);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1437:1: entryRuleMatrixMultiplication returns [EObject current=null] : iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF ;
    public final EObject entryRuleMatrixMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1438:2: (iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1439:2: iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixMultiplication_in_entryRuleMatrixMultiplication2830);
            iv_ruleMatrixMultiplication=ruleMatrixMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixMultiplication2840); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1446:1: ruleMatrixMultiplication returns [EObject current=null] : (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* ) ;
    public final EObject ruleMatrixMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PrimaryMatrix_0 = null;

        EObject lv_rightMatrix_3_0 = null;

        EObject lv_rightScalar_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1449:28: ( (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1450:1: (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1450:1: (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1451:2: this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getPrimaryMatrixParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2890);
            this_PrimaryMatrix_0=rulePrimaryMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrimaryMatrix_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:1: ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==17) ) {
                    int LA14_5 = input.LA(2);

                    if ( (synpred27_InternalMex()) ) {
                        alt14=1;
                    }
                    else if ( (synpred28_InternalMex()) ) {
                        alt14=2;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:4: otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleMatrixMultiplication2903); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMatrixMultiplicationAccess().getAsteriskKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1466:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1467:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1475:2: ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1476:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1476:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1477:3: lv_rightMatrix_3_0= rulePrimaryMatrix
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightMatrixPrimaryMatrixParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2936);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1494:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1494:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1494:8: otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) )
            	    {
            	    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleMatrixMultiplication2956); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMatrixMultiplicationAccess().getAsteriskKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1498:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1499:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1507:2: ( (lv_rightScalar_6_0= ruleFormula ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1508:1: (lv_rightScalar_6_0= ruleFormula )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1508:1: (lv_rightScalar_6_0= ruleFormula )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1509:3: lv_rightScalar_6_0= ruleFormula
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightScalarFormulaParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFormula_in_ruleMatrixMultiplication2989);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1533:1: entryRulePrimaryMatrix returns [EObject current=null] : iv_rulePrimaryMatrix= rulePrimaryMatrix EOF ;
    public final EObject entryRulePrimaryMatrix() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryMatrix = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1534:2: (iv_rulePrimaryMatrix= rulePrimaryMatrix EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1535:2: iv_rulePrimaryMatrix= rulePrimaryMatrix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryMatrixRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryMatrix_in_entryRulePrimaryMatrix3028);
            iv_rulePrimaryMatrix=rulePrimaryMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryMatrix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryMatrix3038); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1542:1: rulePrimaryMatrix returns [EObject current=null] : ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) ) ;
    public final EObject rulePrimaryMatrix() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_matrix_1_0 = null;

        EObject lv_name_4_0 = null;

        EObject lv_name_8_0 = null;

        EObject this_MatrixAddition_11 = null;

        EObject lv_inBrackets_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1545:28: ( ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:1: ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:1: ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) )
            int alt15=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt15=1;
                }
                break;
            case 23:
                {
                int LA15_2 = input.LA(2);

                if ( (synpred30_InternalMex()) ) {
                    alt15=2;
                }
                else if ( (synpred31_InternalMex()) ) {
                    alt15=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                int LA15_3 = input.LA(2);

                if ( (synpred32_InternalMex()) ) {
                    alt15=4;
                }
                else if ( (true) ) {
                    alt15=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 3, input);

                    throw nvae;
                }
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:2: ( () ( (lv_matrix_1_0= ruleMatrix ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:2: ( () ( (lv_matrix_1_0= ruleMatrix ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:3: () ( (lv_matrix_1_0= ruleMatrix ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:3: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1547:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1555:2: ( (lv_matrix_1_0= ruleMatrix ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1556:1: (lv_matrix_1_0= ruleMatrix )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1556:1: (lv_matrix_1_0= ruleMatrix )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1557:3: lv_matrix_1_0= ruleMatrix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getMatrixMatrixParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrix_in_rulePrimaryMatrix3097);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:6: ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:6: ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:7: () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T'
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1575:2: 
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

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_rulePrimaryMatrix3129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryMatrixAccess().getLeftSquareBracketKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1587:1: ( (lv_name_4_0= ruleMathName ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1588:1: (lv_name_4_0= ruleMathName )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1588:1: (lv_name_4_0= ruleMathName )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1589:3: lv_name_4_0= ruleMathName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getNameMathNameParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMathName_in_rulePrimaryMatrix3150);
                    lv_name_4_0=ruleMathName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryMatrixRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"MathName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_rulePrimaryMatrix3162); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryMatrixAccess().getTKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:6: ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:6: ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:7: () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']'
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1611:2: 
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

                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_rulePrimaryMatrix3194); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPrimaryMatrixAccess().getLeftSquareBracketKeyword_2_1());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1623:1: ( (lv_name_8_0= ruleMathName ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1624:1: (lv_name_8_0= ruleMathName )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1624:1: (lv_name_8_0= ruleMathName )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1625:3: lv_name_8_0= ruleMathName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getNameMathNameParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMathName_in_rulePrimaryMatrix3215);
                    lv_name_8_0=ruleMathName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryMatrixRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_8_0, 
                              		"MathName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_rulePrimaryMatrix3227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getPrimaryMatrixAccess().getRightSquareBracketKeyword_2_3());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1646:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1646:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1646:8: otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')'
                    {
                    otherlv_10=(Token)match(input,13,FOLLOW_13_in_rulePrimaryMatrix3247); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getPrimaryMatrixAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getMatrixAdditionParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMatrixAddition_in_rulePrimaryMatrix3272);
                    this_MatrixAddition_11=ruleMatrixAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MatrixAddition_11; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_12=(Token)match(input,14,FOLLOW_14_in_rulePrimaryMatrix3283); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getPrimaryMatrixAccess().getRightParenthesisKeyword_3_2());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1667:6: ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1667:6: ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1667:7: () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1667:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1668:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryMatrixAccess().getMatrixInBracketsAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1676:2: ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1677:1: (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1677:1: (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1678:3: lv_inBrackets_14_0= ruleMatrixAdditionInBrackets
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getInBracketsMatrixAdditionInBracketsParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixAdditionInBrackets_in_rulePrimaryMatrix3324);
                    lv_inBrackets_14_0=ruleMatrixAdditionInBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryMatrixRule());
                      	        }
                             		set(
                             			current, 
                             			"inBrackets",
                              		lv_inBrackets_14_0, 
                              		"MatrixAdditionInBrackets");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "rulePrimaryMatrix"


    // $ANTLR start "entryRuleFloat"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1702:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1703:2: (iv_ruleFloat= ruleFloat EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1704:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_ruleFloat_in_entryRuleFloat3362);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFloat3373); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1711:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1714:28: ( ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1715:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1715:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1715:2: (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1715:2: (this_INT_0= RULE_INT )+
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1715:7: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3414); if (state.failed) return current;
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

            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1722:3: (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1723:2: kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleFloat3435); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1728:1: (this_INT_2= RULE_INT )+
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
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1728:6: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3451); if (state.failed) return current;
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1735:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=30 && LA21_0<=31)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1735:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+
                            {
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1735:4: (kw= 'E' | kw= 'e' )
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
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1736:2: kw= 'E'
                                    {
                                    kw=(Token)match(input,30,FOLLOW_30_in_ruleFloat3473); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1743:2: kw= 'e'
                                    {
                                    kw=(Token)match(input,31,FOLLOW_31_in_ruleFloat3492); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1748:2: (kw= '-' )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==16) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1749:2: kw= '-'
                                    {
                                    kw=(Token)match(input,16,FOLLOW_16_in_ruleFloat3507); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getHyphenMinusKeyword_1_2_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1754:3: (this_INT_6= RULE_INT )+
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
                            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1754:8: this_INT_6= RULE_INT
                            	    {
                            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3525); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1769:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1770:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1771:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction3576);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction3586); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1778:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= ruleMathName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_name_0_0 = null;

        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1781:28: ( ( ( (lv_name_0_0= ruleMathName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1782:1: ( ( (lv_name_0_0= ruleMathName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1782:1: ( ( (lv_name_0_0= ruleMathName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1782:2: ( (lv_name_0_0= ruleMathName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')'
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1782:2: ( (lv_name_0_0= ruleMathName ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1783:1: (lv_name_0_0= ruleMathName )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1783:1: (lv_name_0_0= ruleMathName )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1784:3: lv_name_0_0= ruleMathName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionAccess().getNameMathNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMathName_in_ruleFunction3632);
            lv_name_0_0=ruleMathName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"MathName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleFunction3644); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1804:1: ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_INT && LA25_0<=RULE_MATH_NAME)||LA25_0==13||LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1804:2: ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1804:2: ( (lv_parameters_2_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1805:1: (lv_parameters_2_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1805:1: (lv_parameters_2_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1806:3: lv_parameters_2_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleFunction3666);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1822:2: (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==27) ) {
                            int LA23_1 = input.LA(2);

                            if ( ((LA23_1>=RULE_INT && LA23_1<=RULE_MATH_NAME)||LA23_1==13||LA23_1==20) ) {
                                alt23=1;
                            }


                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1822:4: otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) )
                    	    {
                    	    otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleFunction3679); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1826:1: ( (lv_parameters_4_0= ruleFormula ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1827:1: (lv_parameters_4_0= ruleFormula )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1827:1: (lv_parameters_4_0= ruleFormula )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1828:3: lv_parameters_4_0= ruleFormula
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFormula_in_ruleFunction3700);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1844:4: (otherlv_5= ',' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==27) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1844:6: otherlv_5= ','
                            {
                            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleFunction3715); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleFunction3731); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1860:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1861:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1862:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition3767);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition3777); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1869:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_function_0_0 = null;

        EObject lv_formula_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1872:28: ( ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1873:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1873:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1873:2: ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1873:2: ( (lv_function_0_0= ruleFunction ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1874:1: (lv_function_0_0= ruleFunction )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1874:1: (lv_function_0_0= ruleFunction )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1875:3: lv_function_0_0= ruleFunction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctionFunctionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleFunctionDefinition3823);
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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleFunctionDefinition3835); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1895:1: ( (lv_formula_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1896:1: (lv_formula_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1896:1: (lv_formula_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1897:3: lv_formula_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleFunctionDefinition3856);
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


    // $ANTLR start "entryRuleMathName"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1921:1: entryRuleMathName returns [EObject current=null] : iv_ruleMathName= ruleMathName EOF ;
    public final EObject entryRuleMathName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathName = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1922:2: (iv_ruleMathName= ruleMathName EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1923:2: iv_ruleMathName= ruleMathName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMathNameRule()); 
            }
            pushFollow(FOLLOW_ruleMathName_in_entryRuleMathName3892);
            iv_ruleMathName=ruleMathName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMathName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMathName3902); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMathName"


    // $ANTLR start "ruleMathName"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1930:1: ruleMathName returns [EObject current=null] : ( (lv_mathName_0_0= RULE_MATH_NAME ) ) ;
    public final EObject ruleMathName() throws RecognitionException {
        EObject current = null;

        Token lv_mathName_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1933:28: ( ( (lv_mathName_0_0= RULE_MATH_NAME ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1934:1: ( (lv_mathName_0_0= RULE_MATH_NAME ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1934:1: ( (lv_mathName_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1935:1: (lv_mathName_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1935:1: (lv_mathName_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1936:3: lv_mathName_0_0= RULE_MATH_NAME
            {
            lv_mathName_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleMathName3943); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_mathName_0_0, grammarAccess.getMathNameAccess().getMathNameMATH_NAMETerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMathNameRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"mathName",
                      		lv_mathName_0_0, 
                      		"MATH_NAME");
              	    
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
    // $ANTLR end "ruleMathName"

    // $ANTLR start synpred1_InternalMex
    public final void synpred1_InternalMex_fragment() throws RecognitionException {   
        EObject lv_functionDefinition_0_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:2: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:2: ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:87:1: (lv_functionDefinition_0_0= ruleFunctionDefinition )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:88:3: lv_functionDefinition_0_0= ruleFunctionDefinition
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getFunctionDefinitionFunctionDefinitionParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleFunctionDefinition_in_synpred1_InternalMex137);
        lv_functionDefinition_0_0=ruleFunctionDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred1_InternalMex

    // $ANTLR start synpred2_InternalMex
    public final void synpred2_InternalMex_fragment() throws RecognitionException {   
        EObject lv_variableAssignment_1_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( ( (lv_variableAssignment_1_0= ruleVariableAssignment ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_variableAssignment_1_0= ruleVariableAssignment ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_variableAssignment_1_0= ruleVariableAssignment )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:107:3: lv_variableAssignment_1_0= ruleVariableAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getVariableAssignmentVariableAssignmentParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVariableAssignment_in_synpred2_InternalMex164);
        lv_variableAssignment_1_0=ruleVariableAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalMex

    // $ANTLR start synpred3_InternalMex
    public final void synpred3_InternalMex_fragment() throws RecognitionException {   
        EObject lv_formula_2_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( ( (lv_formula_2_0= ruleFormula ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_formula_2_0= ruleFormula ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_formula_2_0= ruleFormula )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_formula_2_0= ruleFormula )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:126:3: lv_formula_2_0= ruleFormula
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getFormulaFormulaParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleFormula_in_synpred3_InternalMex191);
        lv_formula_2_0=ruleFormula();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalMex

    // $ANTLR start synpred4_InternalMex
    public final void synpred4_InternalMex_fragment() throws RecognitionException {   
        EObject lv_matrixAssignment_3_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:143:6: ( ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:143:6: ( (lv_matrixAssignment_3_0= ruleMatrixAssignment ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:144:1: (lv_matrixAssignment_3_0= ruleMatrixAssignment )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:145:3: lv_matrixAssignment_3_0= ruleMatrixAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixAssignmentMatrixAssignmentParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMatrixAssignment_in_synpred4_InternalMex218);
        lv_matrixAssignment_3_0=ruleMatrixAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred4_InternalMex

    // $ANTLR start synpred5_InternalMex
    public final void synpred5_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject lv_right_3_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:2: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) )
        {
        otherlv_1=(Token)match(input,15,FOLLOW_15_in_synpred5_InternalMex685); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:364:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:365:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:373:2: ( (lv_right_3_0= ruleMultiplication ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:374:1: (lv_right_3_0= ruleMultiplication )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:374:1: (lv_right_3_0= ruleMultiplication )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:375:3: lv_right_3_0= ruleMultiplication
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplication_in_synpred5_InternalMex718);
        lv_right_3_0=ruleMultiplication();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalMex

    // $ANTLR start synpred6_InternalMex
    public final void synpred6_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_right_6_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:392:6: ( (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:392:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:392:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:392:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) )
        {
        otherlv_4=(Token)match(input,16,FOLLOW_16_in_synpred6_InternalMex738); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:396:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:397:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:405:2: ( (lv_right_6_0= ruleMultiplication ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:406:1: (lv_right_6_0= ruleMultiplication )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:406:1: (lv_right_6_0= ruleMultiplication )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:407:3: lv_right_6_0= ruleMultiplication
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplication_in_synpred6_InternalMex771);
        lv_right_6_0=ruleMultiplication();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalMex

    // $ANTLR start synpred7_InternalMex
    public final void synpred7_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject lv_right_3_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:2: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:456:4: otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) )
        {
        otherlv_1=(Token)match(input,17,FOLLOW_17_in_synpred7_InternalMex883); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:460:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:461:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:469:2: ( (lv_right_3_0= ruleUnaryExpression ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:470:1: (lv_right_3_0= ruleUnaryExpression )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:470:1: (lv_right_3_0= ruleUnaryExpression )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:471:3: lv_right_3_0= ruleUnaryExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleUnaryExpression_in_synpred7_InternalMex916);
        lv_right_3_0=ruleUnaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalMex

    // $ANTLR start synpred10_InternalMex
    public final void synpred10_InternalMex_fragment() throws RecognitionException {   
        EObject this_Exponent_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:573:2: (this_Exponent_0= ruleExponent )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:573:2: this_Exponent_0= ruleExponent
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleExponent_in_synpred10_InternalMex1121);
        this_Exponent_0=ruleExponent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalMex

    // $ANTLR start synpred27_InternalMex
    public final void synpred27_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject lv_rightMatrix_3_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:2: ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1462:4: otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
        {
        otherlv_1=(Token)match(input,17,FOLLOW_17_in_synpred27_InternalMex2903); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1466:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1467:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1475:2: ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1476:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1476:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1477:3: lv_rightMatrix_3_0= rulePrimaryMatrix
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightMatrixPrimaryMatrixParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_rulePrimaryMatrix_in_synpred27_InternalMex2936);
        lv_rightMatrix_3_0=rulePrimaryMatrix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalMex

    // $ANTLR start synpred28_InternalMex
    public final void synpred28_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_rightScalar_6_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1494:6: ( (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1494:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1494:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1494:8: otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) )
        {
        otherlv_4=(Token)match(input,17,FOLLOW_17_in_synpred28_InternalMex2956); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1498:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1499:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1507:2: ( (lv_rightScalar_6_0= ruleFormula ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1508:1: (lv_rightScalar_6_0= ruleFormula )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1508:1: (lv_rightScalar_6_0= ruleFormula )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1509:3: lv_rightScalar_6_0= ruleFormula
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightScalarFormulaParserRuleCall_1_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleFormula_in_synpred28_InternalMex2989);
        lv_rightScalar_6_0=ruleFormula();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred28_InternalMex

    // $ANTLR start synpred30_InternalMex
    public final void synpred30_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_name_4_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:6: ( ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:6: ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:6: ( () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T' )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:7: () otherlv_3= '[' ( (lv_name_4_0= ruleMathName ) ) otherlv_5= ']^T'
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1574:7: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1575:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_3=(Token)match(input,23,FOLLOW_23_in_synpred30_InternalMex3129); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1587:1: ( (lv_name_4_0= ruleMathName ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1588:1: (lv_name_4_0= ruleMathName )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1588:1: (lv_name_4_0= ruleMathName )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1589:3: lv_name_4_0= ruleMathName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getNameMathNameParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMathName_in_synpred30_InternalMex3150);
        lv_name_4_0=ruleMathName();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,29,FOLLOW_29_in_synpred30_InternalMex3162); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_InternalMex

    // $ANTLR start synpred31_InternalMex
    public final void synpred31_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_name_8_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:6: ( ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:6: ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:6: ( () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']' )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:7: () otherlv_7= '[' ( (lv_name_8_0= ruleMathName ) ) otherlv_9= ']'
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1610:7: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1611:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_7=(Token)match(input,23,FOLLOW_23_in_synpred31_InternalMex3194); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1623:1: ( (lv_name_8_0= ruleMathName ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1624:1: (lv_name_8_0= ruleMathName )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1624:1: (lv_name_8_0= ruleMathName )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1625:3: lv_name_8_0= ruleMathName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getNameMathNameParserRuleCall_2_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMathName_in_synpred31_InternalMex3215);
        lv_name_8_0=ruleMathName();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,24,FOLLOW_24_in_synpred31_InternalMex3227); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalMex

    // $ANTLR start synpred32_InternalMex
    public final void synpred32_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject this_MatrixAddition_11 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1646:6: ( (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1646:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1646:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1646:8: otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')'
        {
        otherlv_10=(Token)match(input,13,FOLLOW_13_in_synpred32_InternalMex3247); if (state.failed) return ;
        pushFollow(FOLLOW_ruleMatrixAddition_in_synpred32_InternalMex3272);
        this_MatrixAddition_11=ruleMatrixAddition();

        state._fsp--;
        if (state.failed) return ;
        otherlv_12=(Token)match(input,14,FOLLOW_14_in_synpred32_InternalMex3283); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_InternalMex

    // Delegated rules

    public final boolean synpred28_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalMex_fragment(); // can never throw exception
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
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA1_eotS =
        "\12\uffff";
    static final String DFA1_eofS =
        "\12\uffff";
    static final String DFA1_minS =
        "\1\4\1\0\1\uffff\1\0\1\uffff\1\0\4\uffff";
    static final String DFA1_maxS =
        "\1\32\1\0\1\uffff\1\0\1\uffff\1\0\4\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\3\3\uffff\1\5\1\1\1\2\1\4";
    static final String DFA1_specialS =
        "\1\uffff\1\0\1\uffff\1\1\1\uffff\1\2\4\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\1\7\uffff\1\3\6\uffff\1\2\2\uffff\1\5\2\uffff\1\6",
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
                        if ( (synpred1_InternalMex()) ) {s = 7;}

                        else if ( (synpred2_InternalMex()) ) {s = 8;}

                        else if ( (synpred3_InternalMex()) ) {s = 2;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalMex()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalMex()) ) {s = 9;}

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
    static final String DFA2_eotS =
        "\13\uffff";
    static final String DFA2_eofS =
        "\1\1\12\uffff";
    static final String DFA2_minS =
        "\1\16\4\uffff\2\0\4\uffff";
    static final String DFA2_maxS =
        "\1\34\4\uffff\2\0\4\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\3\7\uffff\1\1\1\2";
    static final String DFA2_specialS =
        "\5\uffff\1\0\1\1\4\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\5\1\6\1\1\6\uffff\1\1\2\uffff\2\1",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 360:1: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalMex()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalMex()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA3_eotS =
        "\14\uffff";
    static final String DFA3_eofS =
        "\1\1\13\uffff";
    static final String DFA3_minS =
        "\1\16\7\uffff\1\0\3\uffff";
    static final String DFA3_maxS =
        "\1\34\7\uffff\1\0\3\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\4\7\uffff\1\2\1\3\1\1";
    static final String DFA3_specialS =
        "\10\uffff\1\0\3\uffff}>";
    static final String[] DFA3_transitionS = {
            "\3\1\1\10\1\11\1\12\4\uffff\1\1\2\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
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
            return "()* loopback of 456:1: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalMex()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_8);
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
    static final String DFA6_eotS =
        "\13\uffff";
    static final String DFA6_eofS =
        "\1\uffff\1\4\6\uffff\1\12\2\uffff";
    static final String DFA6_minS =
        "\1\4\1\15\5\uffff\1\5\1\15\2\uffff";
    static final String DFA6_maxS =
        "\1\15\1\34\5\uffff\1\5\1\34\2\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\1\5\1\1\1\3\1\4\2\uffff\1\6\1\7";
    static final String DFA6_specialS =
        "\13\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\2\1\1\7\uffff\1\3",
            "\1\5\6\4\1\uffff\2\4\1\6\1\4\1\7\1\uffff\2\4",
            "",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11\6\12\1\uffff\2\12\1\uffff\1\12\2\uffff\2\12",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "741:1: ( ( () ( (lv_name_1_0= ruleMathName ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= ruleMathName ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFormula ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFormula ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) | ( () ( (lv_class__17_0= ruleMathName ) ) otherlv_18= '.' ( (lv_function_19_0= ruleFunction ) ) ) | ( () ( (lv_class__21_0= ruleMathName ) ) otherlv_22= '.' ( (lv_member_23_0= ruleMathName ) ) ) )";
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
    public static final BitSet FOLLOW_ruleMathName_in_ruleVariableAssignment337 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVariableAssignment349 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleVariableAssignment370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleFormula461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditionInBrackets_in_entryRuleAdditionInBrackets496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditionInBrackets506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAdditionInBrackets543 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleAdditionInBrackets564 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdditionInBrackets576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition612 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition672 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_15_in_ruleAddition685 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition718 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_16_in_ruleAddition738 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition771 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication870 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_17_in_ruleMultiplication883 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication916 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_18_in_ruleMultiplication936 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication969 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_19_in_ruleMultiplication989 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication1022 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_ruleUnaryExpression1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleUnaryExpression1139 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1172 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleUnaryExpression1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleUnaryExpression1204 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1237 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnaryExpression1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_entryRuleExponent1286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExponent1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1346 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleExponent1370 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary1429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMathName_in_rulePrimary1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rulePrimary1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMathName_in_rulePrimary1621 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePrimary1633 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_rulePrimary1654 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimary1666 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePrimary1678 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_rulePrimary1699 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimary1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditionInBrackets_in_rulePrimary1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMathName_in_rulePrimary1793 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimary1805 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFunction_in_rulePrimary1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMathName_in_rulePrimary1867 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePrimary1879 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMathName_in_rulePrimary1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrix_in_entryRuleMatrix1937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrix1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleMatrix1984 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrix2006 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrix2019 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrix2040 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrix2055 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleMatrix2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow2107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixRow2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleMatrixRow2154 = new BitSet(new long[]{0x0000000010102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleMatrixRow2176 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrixRow2189 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleMatrixRow2210 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrixRow2225 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleMatrixRow2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAssignment_in_entryRuleMatrixAssignment2277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAssignment2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleMatrixAssignment2324 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMathName_in_ruleMatrixAssignment2345 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMatrixAssignment2357 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMatrixAssignment2369 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_ruleMatrixFormula_in_ruleMatrixAssignment2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixFormula_in_entryRuleMatrixFormula2426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixFormula2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_ruleMatrixFormula2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAdditionInBrackets_in_entryRuleMatrixAdditionInBrackets2516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAdditionInBrackets2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMatrixAdditionInBrackets2563 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_ruleMatrixAdditionInBrackets2584 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMatrixAdditionInBrackets2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_entryRuleMatrixAddition2632 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAddition2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2692 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_15_in_ruleMatrixAddition2705 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2738 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_16_in_ruleMatrixAddition2758 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2791 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_entryRuleMatrixMultiplication2830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixMultiplication2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2890 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleMatrixMultiplication2903 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2936 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleMatrixMultiplication2956 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleMatrixMultiplication2989 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_entryRulePrimaryMatrix3028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryMatrix3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrix_in_rulePrimaryMatrix3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePrimaryMatrix3129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMathName_in_rulePrimaryMatrix3150 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePrimaryMatrix3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePrimaryMatrix3194 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMathName_in_rulePrimaryMatrix3215 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimaryMatrix3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePrimaryMatrix3247 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_rulePrimaryMatrix3272 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePrimaryMatrix3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAdditionInBrackets_in_rulePrimaryMatrix3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_entryRuleFloat3362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFloat3373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3414 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_25_in_ruleFloat3435 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3451 = new BitSet(new long[]{0x00000000C0000012L});
    public static final BitSet FOLLOW_30_in_ruleFloat3473 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_31_in_ruleFloat3492 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleFloat3507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3525 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction3576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMathName_in_ruleFunction3632 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFunction3644 = new BitSet(new long[]{0x0000000000106030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction3666 = new BitSet(new long[]{0x0000000008004000L});
    public static final BitSet FOLLOW_27_in_ruleFunction3679 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction3700 = new BitSet(new long[]{0x0000000008004000L});
    public static final BitSet FOLLOW_27_in_ruleFunction3715 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleFunction3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition3767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleFunctionDefinition3823 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFunctionDefinition3835 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunctionDefinition3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMathName_in_entryRuleMathName3892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMathName3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleMathName3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_synpred1_InternalMex137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_synpred2_InternalMex164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_synpred3_InternalMex191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAssignment_in_synpred4_InternalMex218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_synpred5_InternalMex685 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_synpred5_InternalMex718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred6_InternalMex738 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_synpred6_InternalMex771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred7_InternalMex883 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_synpred7_InternalMex916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_synpred10_InternalMex1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred27_InternalMex2903 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_synpred27_InternalMex2936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred28_InternalMex2956 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_synpred28_InternalMex2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred30_InternalMex3129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMathName_in_synpred30_InternalMex3150 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_synpred30_InternalMex3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred31_InternalMex3194 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMathName_in_synpred31_InternalMex3215 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_synpred31_InternalMex3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred32_InternalMex3247 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_synpred32_InternalMex3272 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred32_InternalMex3283 = new BitSet(new long[]{0x0000000000000002L});

}