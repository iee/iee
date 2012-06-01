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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MATH_NAME", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'(-'", "')!'", "'^'", "'['", "']'", "'{'", "','", "'}'", "']^T'", "'.'", "'E'", "'e'"
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:197:1: ruleVariableAssignment returns [EObject current=null] : ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:200:28: ( ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:2: ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:201:2: ( (lv_variable_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:202:1: (lv_variable_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:202:1: (lv_variable_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:203:3: lv_variable_0_0= RULE_MATH_NAME
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:223:1: ( (lv_value_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:224:1: (lv_value_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:224:1: (lv_value_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:225:3: lv_value_2_0= ruleFormula
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
            pushFollow(FOLLOW_ruleAdditionInBrackets_in_entryRuleAdditionInBrackets497);
            iv_ruleAdditionInBrackets=ruleAdditionInBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditionInBrackets; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditionInBrackets507); if (state.failed) return current;

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
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAdditionInBrackets544); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleAddition_in_ruleAdditionInBrackets565);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleAdditionInBrackets577); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition613);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition623); if (state.failed) return current;

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
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition673);
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
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    int LA2_2 = input.LA(2);

                    if ( (synpred5_InternalMex()) ) {
                        alt2=1;
                    }


                }
                else if ( (LA2_0==16) ) {
                    int LA2_3 = input.LA(2);

                    if ( (synpred6_InternalMex()) ) {
                        alt2=2;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:360:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleAddition686); if (state.failed) return current;
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
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition719);
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
            	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleAddition739); if (state.failed) return current;
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
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition772);
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
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication811);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication821); if (state.failed) return current;

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
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication871);
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
            	    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleMultiplication884); if (state.failed) return current;
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
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication917);
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
            	    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleMultiplication937); if (state.failed) return current;
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
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication970);
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
            	    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleMultiplication990); if (state.failed) return current;
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
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication1023);
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
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1062);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1072); if (state.failed) return current;

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
            case RULE_MATH_NAME:
            case RULE_INT:
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
                    pushFollow(FOLLOW_ruleExponent_in_ruleUnaryExpression1122);
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
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleUnaryExpression1140); if (state.failed) return current;
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
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1173);
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

                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleUnaryExpression1185); if (state.failed) return current;
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
                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleUnaryExpression1205); if (state.failed) return current;
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
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1238);
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

                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleUnaryExpression1250); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleExponent_in_entryRuleExponent1287);
            iv_ruleExponent=ruleExponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExponent1297); if (state.failed) return current;

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
            pushFollow(FOLLOW_rulePrimary_in_ruleExponent1347);
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

                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleExponent1371); if (state.failed) return current;
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
                    pushFollow(FOLLOW_rulePrimary_in_ruleExponent1392);
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
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary1430);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary1440); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:737:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= RULE_MATH_NAME ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFloat ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFloat ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_element_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;

        EObject lv_function_5_0 = null;

        AntlrDatatypeRuleToken lv_row_9_0 = null;

        AntlrDatatypeRuleToken lv_column_12_0 = null;

        EObject lv_inBrackets_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:740:28: ( ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= RULE_MATH_NAME ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFloat ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFloat ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= RULE_MATH_NAME ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFloat ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFloat ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | ( () ( (lv_element_7_0= RULE_MATH_NAME ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFloat ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFloat ) ) otherlv_13= ']' ) | ( () ( (lv_inBrackets_15_0= ruleAdditionInBrackets ) ) ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case RULE_MATH_NAME:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                case 22:
                case 26:
                    {
                    alt6=1;
                    }
                    break;
                case 23:
                    {
                    alt6=4;
                    }
                    break;
                case 13:
                    {
                    alt6=3;
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
            case 13:
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:741:3: () ( (lv_name_1_0= RULE_MATH_NAME ) )
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:750:2: ( (lv_name_1_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:751:1: (lv_name_1_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:751:1: (lv_name_1_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:752:3: lv_name_1_0= RULE_MATH_NAME
                    {
                    lv_name_1_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimary1495); if (state.failed) return current;
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
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary1541);
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
                    pushFollow(FOLLOW_ruleFunction_in_rulePrimary1582);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:6: ( () ( (lv_element_7_0= RULE_MATH_NAME ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFloat ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFloat ) ) otherlv_13= ']' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:6: ( () ( (lv_element_7_0= RULE_MATH_NAME ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFloat ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFloat ) ) otherlv_13= ']' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:7: () ( (lv_element_7_0= RULE_MATH_NAME ) ) otherlv_8= '[' ( (lv_row_9_0= ruleFloat ) ) otherlv_10= ']' otherlv_11= '[' ( (lv_column_12_0= ruleFloat ) ) otherlv_13= ']'
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:834:2: ( (lv_element_7_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:835:1: (lv_element_7_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:835:1: (lv_element_7_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:836:3: lv_element_7_0= RULE_MATH_NAME
                    {
                    lv_element_7_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimary1619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_element_7_0, grammarAccess.getPrimaryAccess().getElementMATH_NAMETerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPrimaryRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"element",
                              		lv_element_7_0, 
                              		"MATH_NAME");
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,23,FOLLOW_23_in_rulePrimary1636); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryAccess().getLeftSquareBracketKeyword_3_2());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:856:1: ( (lv_row_9_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:857:1: (lv_row_9_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:857:1: (lv_row_9_0= ruleFloat )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:858:3: lv_row_9_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getRowFloatParserRuleCall_3_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary1657);
                    lv_row_9_0=ruleFloat();

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
                              		"Float");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,24,FOLLOW_24_in_rulePrimary1669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getPrimaryAccess().getRightSquareBracketKeyword_3_4());
                          
                    }
                    otherlv_11=(Token)match(input,23,FOLLOW_23_in_rulePrimary1681); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getPrimaryAccess().getLeftSquareBracketKeyword_3_5());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:882:1: ( (lv_column_12_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:883:1: (lv_column_12_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:883:1: (lv_column_12_0= ruleFloat )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:884:3: lv_column_12_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getColumnFloatParserRuleCall_3_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary1702);
                    lv_column_12_0=ruleFloat();

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
                              		"Float");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,24,FOLLOW_24_in_rulePrimary1714); if (state.failed) return current;
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
                    pushFollow(FOLLOW_ruleAdditionInBrackets_in_rulePrimary1755);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:940:1: entryRuleMatrix returns [EObject current=null] : iv_ruleMatrix= ruleMatrix EOF ;
    public final EObject entryRuleMatrix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrix = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:941:2: (iv_ruleMatrix= ruleMatrix EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:942:2: iv_ruleMatrix= ruleMatrix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRule()); 
            }
            pushFollow(FOLLOW_ruleMatrix_in_entryRuleMatrix1792);
            iv_ruleMatrix=ruleMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrix1802); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:949:1: ruleMatrix returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:952:28: ( (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:953:1: (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:953:1: (otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:953:3: otherlv_0= '{' ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleMatrix1839); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:957:1: ( ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )? )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:957:2: ( (lv_rows_1_0= ruleMatrixRow ) ) (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:957:2: ( (lv_rows_1_0= ruleMatrixRow ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:958:1: (lv_rows_1_0= ruleMatrixRow )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:958:1: (lv_rows_1_0= ruleMatrixRow )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:959:3: lv_rows_1_0= ruleMatrixRow
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixAccess().getRowsMatrixRowParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrix1861);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:975:2: (otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) ) )*
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
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:975:4: otherlv_2= ',' ( (lv_rows_3_0= ruleMatrixRow ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleMatrix1874); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:979:1: ( (lv_rows_3_0= ruleMatrixRow ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:980:1: (lv_rows_3_0= ruleMatrixRow )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:980:1: (lv_rows_3_0= ruleMatrixRow )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:981:3: lv_rows_3_0= ruleMatrixRow
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixAccess().getRowsMatrixRowParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrix1895);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:997:4: (otherlv_4= ',' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==26) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:997:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleMatrix1910); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleMatrix1926); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1013:1: entryRuleMatrixRow returns [EObject current=null] : iv_ruleMatrixRow= ruleMatrixRow EOF ;
    public final EObject entryRuleMatrixRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixRow = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1014:2: (iv_ruleMatrixRow= ruleMatrixRow EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1015:2: iv_ruleMatrixRow= ruleMatrixRow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRowRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow1962);
            iv_ruleMatrixRow=ruleMatrixRow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixRow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixRow1972); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1022:1: ruleMatrixRow returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1025:28: ( (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1026:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1026:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1026:3: otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleMatrixRow2009); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixRowAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1030:1: ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1030:2: ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1030:2: ( (lv_elements_1_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1031:1: (lv_elements_1_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1031:1: (lv_elements_1_0= ruleFloat )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1032:3: lv_elements_1_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow2031);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1048:2: (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )*
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
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1048:4: otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleMatrixRow2044); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1052:1: ( (lv_elements_3_0= ruleFloat ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1053:1: (lv_elements_3_0= ruleFloat )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1053:1: (lv_elements_3_0= ruleFloat )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1054:3: lv_elements_3_0= ruleFloat
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow2065);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1070:4: (otherlv_4= ',' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==26) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1070:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleMatrixRow2080); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleMatrixRow2096); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1086:1: entryRuleMatrixAssignment returns [EObject current=null] : iv_ruleMatrixAssignment= ruleMatrixAssignment EOF ;
    public final EObject entryRuleMatrixAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAssignment = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1087:2: (iv_ruleMatrixAssignment= ruleMatrixAssignment EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1088:2: iv_ruleMatrixAssignment= ruleMatrixAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAssignment_in_entryRuleMatrixAssignment2132);
            iv_ruleMatrixAssignment=ruleMatrixAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAssignment2142); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1095:1: ruleMatrixAssignment returns [EObject current=null] : (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) ) ;
    public final EObject ruleMatrixAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1098:28: ( (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1099:1: (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1099:1: (otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1099:3: otherlv_0= '[' ( (lv_variable_1_0= RULE_MATH_NAME ) ) otherlv_2= ']' otherlv_3= '=' ( (lv_value_4_0= ruleMatrixFormula ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleMatrixAssignment2179); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAssignmentAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1103:1: ( (lv_variable_1_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1104:1: (lv_variable_1_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1104:1: (lv_variable_1_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1105:3: lv_variable_1_0= RULE_MATH_NAME
            {
            lv_variable_1_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleMatrixAssignment2196); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleMatrixAssignment2213); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMatrixAssignmentAccess().getRightSquareBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleMatrixAssignment2225); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMatrixAssignmentAccess().getEqualsSignKeyword_3());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1129:1: ( (lv_value_4_0= ruleMatrixFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1130:1: (lv_value_4_0= ruleMatrixFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1130:1: (lv_value_4_0= ruleMatrixFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1131:3: lv_value_4_0= ruleMatrixFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixAssignmentAccess().getValueMatrixFormulaParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixFormula_in_ruleMatrixAssignment2246);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1155:1: entryRuleMatrixFormula returns [EObject current=null] : iv_ruleMatrixFormula= ruleMatrixFormula EOF ;
    public final EObject entryRuleMatrixFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixFormula = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1156:2: (iv_ruleMatrixFormula= ruleMatrixFormula EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1157:2: iv_ruleMatrixFormula= ruleMatrixFormula EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixFormulaRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixFormula_in_entryRuleMatrixFormula2282);
            iv_ruleMatrixFormula=ruleMatrixFormula();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixFormula; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixFormula2292); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1164:1: ruleMatrixFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleMatrixAddition ) ) ;
    public final EObject ruleMatrixFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1167:28: ( ( (lv_expression_0_0= ruleMatrixAddition ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1168:1: ( (lv_expression_0_0= ruleMatrixAddition ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1168:1: ( (lv_expression_0_0= ruleMatrixAddition ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1169:1: (lv_expression_0_0= ruleMatrixAddition )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1169:1: (lv_expression_0_0= ruleMatrixAddition )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1170:3: lv_expression_0_0= ruleMatrixAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixFormulaAccess().getExpressionMatrixAdditionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_ruleMatrixFormula2337);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1194:1: entryRuleMatrixAdditionInBrackets returns [EObject current=null] : iv_ruleMatrixAdditionInBrackets= ruleMatrixAdditionInBrackets EOF ;
    public final EObject entryRuleMatrixAdditionInBrackets() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAdditionInBrackets = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1195:2: (iv_ruleMatrixAdditionInBrackets= ruleMatrixAdditionInBrackets EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1196:2: iv_ruleMatrixAdditionInBrackets= ruleMatrixAdditionInBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAdditionInBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAdditionInBrackets_in_entryRuleMatrixAdditionInBrackets2372);
            iv_ruleMatrixAdditionInBrackets=ruleMatrixAdditionInBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAdditionInBrackets; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAdditionInBrackets2382); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1203:1: ruleMatrixAdditionInBrackets returns [EObject current=null] : (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' ) ;
    public final EObject ruleMatrixAdditionInBrackets() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_addition_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1206:28: ( (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1207:1: (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1207:1: (otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1207:3: otherlv_0= '(' ( (lv_addition_1_0= ruleMatrixAddition ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleMatrixAdditionInBrackets2419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixAdditionInBracketsAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1211:1: ( (lv_addition_1_0= ruleMatrixAddition ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1212:1: (lv_addition_1_0= ruleMatrixAddition )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1212:1: (lv_addition_1_0= ruleMatrixAddition )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1213:3: lv_addition_1_0= ruleMatrixAddition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMatrixAdditionInBracketsAccess().getAdditionMatrixAdditionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_ruleMatrixAdditionInBrackets2440);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleMatrixAdditionInBrackets2452); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1241:1: entryRuleMatrixAddition returns [EObject current=null] : iv_ruleMatrixAddition= ruleMatrixAddition EOF ;
    public final EObject entryRuleMatrixAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixAddition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1242:2: (iv_ruleMatrixAddition= ruleMatrixAddition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1243:2: iv_ruleMatrixAddition= ruleMatrixAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixAddition_in_entryRuleMatrixAddition2488);
            iv_ruleMatrixAddition=ruleMatrixAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixAddition2498); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1250:1: ruleMatrixAddition returns [EObject current=null] : (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* ) ;
    public final EObject ruleMatrixAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_MatrixMultiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1253:28: ( (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1254:1: (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1254:1: (this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1255:2: this_MatrixMultiplication_0= ruleMatrixMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMatrixAdditionAccess().getMatrixMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2548);
            this_MatrixMultiplication_0=ruleMatrixMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MatrixMultiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1266:1: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) ) )*
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1266:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1266:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1266:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMatrixMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMatrixAddition2561); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMatrixAdditionAccess().getPlusSignKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1270:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1271:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1279:2: ( (lv_right_3_0= ruleMatrixMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1280:1: (lv_right_3_0= ruleMatrixMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1280:1: (lv_right_3_0= ruleMatrixMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1281:3: lv_right_3_0= ruleMatrixMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2594);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1298:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1298:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1298:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMatrixMultiplication ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleMatrixAddition2614); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMatrixAdditionAccess().getHyphenMinusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1302:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1303:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1311:2: ( (lv_right_6_0= ruleMatrixMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1312:1: (lv_right_6_0= ruleMatrixMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1312:1: (lv_right_6_0= ruleMatrixMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1313:3: lv_right_6_0= ruleMatrixMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixAdditionAccess().getRightMatrixMultiplicationParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2647);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1337:1: entryRuleMatrixMultiplication returns [EObject current=null] : iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF ;
    public final EObject entryRuleMatrixMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1338:2: (iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1339:2: iv_ruleMatrixMultiplication= ruleMatrixMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixMultiplication_in_entryRuleMatrixMultiplication2686);
            iv_ruleMatrixMultiplication=ruleMatrixMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixMultiplication2696); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1346:1: ruleMatrixMultiplication returns [EObject current=null] : (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* ) ;
    public final EObject ruleMatrixMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PrimaryMatrix_0 = null;

        EObject lv_rightMatrix_3_0 = null;

        EObject lv_rightScalar_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1349:28: ( (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1350:1: (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1350:1: (this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1351:2: this_PrimaryMatrix_0= rulePrimaryMatrix ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getPrimaryMatrixParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2746);
            this_PrimaryMatrix_0=rulePrimaryMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrimaryMatrix_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:1: ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) | (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==17) ) {
                    int LA14_5 = input.LA(2);

                    if ( (synpred25_InternalMex()) ) {
                        alt14=1;
                    }
                    else if ( (synpred26_InternalMex()) ) {
                        alt14=2;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:4: otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleMatrixMultiplication2759); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMatrixMultiplicationAccess().getAsteriskKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1366:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1367:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1375:2: ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1376:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1376:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1377:3: lv_rightMatrix_3_0= rulePrimaryMatrix
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightMatrixPrimaryMatrixParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2792);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1394:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1394:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1394:8: otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) )
            	    {
            	    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleMatrixMultiplication2812); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMatrixMultiplicationAccess().getAsteriskKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1398:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1399:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1407:2: ( (lv_rightScalar_6_0= ruleFormula ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1408:1: (lv_rightScalar_6_0= ruleFormula )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1408:1: (lv_rightScalar_6_0= ruleFormula )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1409:3: lv_rightScalar_6_0= ruleFormula
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightScalarFormulaParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFormula_in_ruleMatrixMultiplication2845);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1433:1: entryRulePrimaryMatrix returns [EObject current=null] : iv_rulePrimaryMatrix= rulePrimaryMatrix EOF ;
    public final EObject entryRulePrimaryMatrix() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryMatrix = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1434:2: (iv_rulePrimaryMatrix= rulePrimaryMatrix EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1435:2: iv_rulePrimaryMatrix= rulePrimaryMatrix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryMatrixRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryMatrix_in_entryRulePrimaryMatrix2884);
            iv_rulePrimaryMatrix=rulePrimaryMatrix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryMatrix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryMatrix2894); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1442:1: rulePrimaryMatrix returns [EObject current=null] : ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) ) ;
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

        EObject lv_inBrackets_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1445:28: ( ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1446:1: ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1446:1: ( ( () ( (lv_matrix_1_0= ruleMatrix ) ) ) | ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) | ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) | (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) | ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) ) )
            int alt15=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt15=1;
                }
                break;
            case 23:
                {
                int LA15_2 = input.LA(2);

                if ( (synpred28_InternalMex()) ) {
                    alt15=2;
                }
                else if ( (synpred29_InternalMex()) ) {
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

                if ( (synpred30_InternalMex()) ) {
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1446:2: ( () ( (lv_matrix_1_0= ruleMatrix ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1446:2: ( () ( (lv_matrix_1_0= ruleMatrix ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1446:3: () ( (lv_matrix_1_0= ruleMatrix ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1446:3: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1447:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1455:2: ( (lv_matrix_1_0= ruleMatrix ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1456:1: (lv_matrix_1_0= ruleMatrix )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1456:1: (lv_matrix_1_0= ruleMatrix )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1457:3: lv_matrix_1_0= ruleMatrix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getMatrixMatrixParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrix_in_rulePrimaryMatrix2953);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:6: ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:6: ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:7: () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T'
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1475:2: 
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

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_rulePrimaryMatrix2985); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryMatrixAccess().getLeftSquareBracketKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1487:1: ( (lv_name_4_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1488:1: (lv_name_4_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1488:1: (lv_name_4_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1489:3: lv_name_4_0= RULE_MATH_NAME
                    {
                    lv_name_4_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix3002); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePrimaryMatrix3019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryMatrixAccess().getTKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:6: ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:6: ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:7: () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']'
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1511:2: 
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

                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_rulePrimaryMatrix3051); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPrimaryMatrixAccess().getLeftSquareBracketKeyword_2_1());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1523:1: ( (lv_name_8_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1524:1: (lv_name_8_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1524:1: (lv_name_8_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1525:3: lv_name_8_0= RULE_MATH_NAME
                    {
                    lv_name_8_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix3068); if (state.failed) return current;
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

                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_rulePrimaryMatrix3085); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getPrimaryMatrixAccess().getRightSquareBracketKeyword_2_3());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:8: otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')'
                    {
                    otherlv_10=(Token)match(input,13,FOLLOW_13_in_rulePrimaryMatrix3105); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getPrimaryMatrixAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getMatrixAdditionParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMatrixAddition_in_rulePrimaryMatrix3130);
                    this_MatrixAddition_11=ruleMatrixAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MatrixAddition_11; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_12=(Token)match(input,14,FOLLOW_14_in_rulePrimaryMatrix3141); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getPrimaryMatrixAccess().getRightParenthesisKeyword_3_2());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1567:6: ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1567:6: ( () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1567:7: () ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1567:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1568:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1576:2: ( (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1577:1: (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1577:1: (lv_inBrackets_14_0= ruleMatrixAdditionInBrackets )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1578:3: lv_inBrackets_14_0= ruleMatrixAdditionInBrackets
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryMatrixAccess().getInBracketsMatrixAdditionInBracketsParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixAdditionInBrackets_in_rulePrimaryMatrix3182);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1602:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1603:2: (iv_ruleFloat= ruleFloat EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1604:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_ruleFloat_in_entryRuleFloat3220);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFloat3231); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1611:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1614:28: ( ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1615:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1615:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1615:2: (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1615:2: (this_INT_0= RULE_INT )+
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1615:7: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3272); if (state.failed) return current;
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

            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1622:3: (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==29) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1623:2: kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleFloat3293); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1628:1: (this_INT_2= RULE_INT )+
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
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1628:6: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3309); if (state.failed) return current;
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1635:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=30 && LA21_0<=31)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1635:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+
                            {
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1635:4: (kw= 'E' | kw= 'e' )
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
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1636:2: kw= 'E'
                                    {
                                    kw=(Token)match(input,30,FOLLOW_30_in_ruleFloat3331); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1643:2: kw= 'e'
                                    {
                                    kw=(Token)match(input,31,FOLLOW_31_in_ruleFloat3350); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1648:2: (kw= '-' )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==16) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1649:2: kw= '-'
                                    {
                                    kw=(Token)match(input,16,FOLLOW_16_in_ruleFloat3365); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getHyphenMinusKeyword_1_2_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1654:3: (this_INT_6= RULE_INT )+
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
                            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1654:8: this_INT_6= RULE_INT
                            	    {
                            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat3383); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1669:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1670:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1671:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction3434);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction3444); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1678:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1681:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1682:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1682:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1682:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')'
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1682:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1683:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1683:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1684:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunction3486); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleFunction3503); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1704:1: ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_MATH_NAME && LA25_0<=RULE_INT)||LA25_0==13||LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1704:2: ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1704:2: ( (lv_parameters_2_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1705:1: (lv_parameters_2_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1705:1: (lv_parameters_2_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1706:3: lv_parameters_2_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleFunction3525);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1722:2: (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==26) ) {
                            int LA23_1 = input.LA(2);

                            if ( ((LA23_1>=RULE_MATH_NAME && LA23_1<=RULE_INT)||LA23_1==13||LA23_1==20) ) {
                                alt23=1;
                            }


                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1722:4: otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) )
                    	    {
                    	    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleFunction3538); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1726:1: ( (lv_parameters_4_0= ruleFormula ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1727:1: (lv_parameters_4_0= ruleFormula )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1727:1: (lv_parameters_4_0= ruleFormula )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1728:3: lv_parameters_4_0= ruleFormula
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFormula_in_ruleFunction3559);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1744:4: (otherlv_5= ',' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==26) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1744:6: otherlv_5= ','
                            {
                            otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleFunction3574); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleFunction3590); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1760:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1761:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1762:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition3626);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition3636); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1769:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_function_0_0 = null;

        EObject lv_formula_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1772:28: ( ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1773:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1773:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1773:2: ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1773:2: ( (lv_function_0_0= ruleFunction ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1774:1: (lv_function_0_0= ruleFunction )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1774:1: (lv_function_0_0= ruleFunction )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1775:3: lv_function_0_0= ruleFunction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctionFunctionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleFunctionDefinition3682);
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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleFunctionDefinition3694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1795:1: ( (lv_formula_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1796:1: (lv_formula_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1796:1: (lv_formula_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1797:3: lv_formula_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleFunctionDefinition3715);
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
        otherlv_1=(Token)match(input,15,FOLLOW_15_in_synpred5_InternalMex686); if (state.failed) return ;
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
        pushFollow(FOLLOW_ruleMultiplication_in_synpred5_InternalMex719);
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
        otherlv_4=(Token)match(input,16,FOLLOW_16_in_synpred6_InternalMex739); if (state.failed) return ;
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
        pushFollow(FOLLOW_ruleMultiplication_in_synpred6_InternalMex772);
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
        otherlv_1=(Token)match(input,17,FOLLOW_17_in_synpred7_InternalMex884); if (state.failed) return ;
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
        pushFollow(FOLLOW_ruleUnaryExpression_in_synpred7_InternalMex917);
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
        pushFollow(FOLLOW_ruleExponent_in_synpred10_InternalMex1122);
        this_Exponent_0=ruleExponent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalMex

    // $ANTLR start synpred25_InternalMex
    public final void synpred25_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject lv_rightMatrix_3_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:2: ( (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:2: (otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1362:4: otherlv_1= '*' () ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
        {
        otherlv_1=(Token)match(input,17,FOLLOW_17_in_synpred25_InternalMex2759); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1366:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1367:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1375:2: ( (lv_rightMatrix_3_0= rulePrimaryMatrix ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1376:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1376:1: (lv_rightMatrix_3_0= rulePrimaryMatrix )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1377:3: lv_rightMatrix_3_0= rulePrimaryMatrix
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightMatrixPrimaryMatrixParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_rulePrimaryMatrix_in_synpred25_InternalMex2792);
        lv_rightMatrix_3_0=rulePrimaryMatrix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalMex

    // $ANTLR start synpred26_InternalMex
    public final void synpred26_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_rightScalar_6_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1394:6: ( (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1394:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1394:6: (otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1394:8: otherlv_4= '*' () ( (lv_rightScalar_6_0= ruleFormula ) )
        {
        otherlv_4=(Token)match(input,17,FOLLOW_17_in_synpred26_InternalMex2812); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1398:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1399:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1407:2: ( (lv_rightScalar_6_0= ruleFormula ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1408:1: (lv_rightScalar_6_0= ruleFormula )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1408:1: (lv_rightScalar_6_0= ruleFormula )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1409:3: lv_rightScalar_6_0= ruleFormula
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMatrixMultiplicationAccess().getRightScalarFormulaParserRuleCall_1_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleFormula_in_synpred26_InternalMex2845);
        lv_rightScalar_6_0=ruleFormula();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred26_InternalMex

    // $ANTLR start synpred28_InternalMex
    public final void synpred28_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:6: ( ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:6: ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:6: ( () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T' )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:7: () otherlv_3= '[' ( (lv_name_4_0= RULE_MATH_NAME ) ) otherlv_5= ']^T'
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1474:7: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1475:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_3=(Token)match(input,23,FOLLOW_23_in_synpred28_InternalMex2985); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1487:1: ( (lv_name_4_0= RULE_MATH_NAME ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1488:1: (lv_name_4_0= RULE_MATH_NAME )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1488:1: (lv_name_4_0= RULE_MATH_NAME )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1489:3: lv_name_4_0= RULE_MATH_NAME
        {
        lv_name_4_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_synpred28_InternalMex3002); if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,28,FOLLOW_28_in_synpred28_InternalMex3019); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred28_InternalMex

    // $ANTLR start synpred29_InternalMex
    public final void synpred29_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:6: ( ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:6: ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:6: ( () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']' )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:7: () otherlv_7= '[' ( (lv_name_8_0= RULE_MATH_NAME ) ) otherlv_9= ']'
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1510:7: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1511:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_7=(Token)match(input,23,FOLLOW_23_in_synpred29_InternalMex3051); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1523:1: ( (lv_name_8_0= RULE_MATH_NAME ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1524:1: (lv_name_8_0= RULE_MATH_NAME )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1524:1: (lv_name_8_0= RULE_MATH_NAME )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1525:3: lv_name_8_0= RULE_MATH_NAME
        {
        lv_name_8_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_synpred29_InternalMex3068); if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,24,FOLLOW_24_in_synpred29_InternalMex3085); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred29_InternalMex

    // $ANTLR start synpred30_InternalMex
    public final void synpred30_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject this_MatrixAddition_11 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:6: ( (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:6: (otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')' )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1546:8: otherlv_10= '(' this_MatrixAddition_11= ruleMatrixAddition otherlv_12= ')'
        {
        otherlv_10=(Token)match(input,13,FOLLOW_13_in_synpred30_InternalMex3105); if (state.failed) return ;
        pushFollow(FOLLOW_ruleMatrixAddition_in_synpred30_InternalMex3130);
        this_MatrixAddition_11=ruleMatrixAddition();

        state._fsp--;
        if (state.failed) return ;
        otherlv_12=(Token)match(input,14,FOLLOW_14_in_synpred30_InternalMex3141); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_InternalMex

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
    public final boolean synpred26_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalMex_fragment(); // can never throw exception
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
            "\1\1\1\2\7\uffff\1\3\6\uffff\1\2\2\uffff\1\5\1\uffff\1\6",
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
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\1\1\11\uffff";
    static final String DFA3_minS =
        "\1\16\4\uffff\1\0\4\uffff";
    static final String DFA3_maxS =
        "\1\32\4\uffff\1\0\4\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\4\5\uffff\1\2\1\3\1\1";
    static final String DFA3_specialS =
        "\5\uffff\1\0\4\uffff}>";
    static final String[] DFA3_transitionS = {
            "\3\1\1\5\1\7\1\10\6\uffff\1\1",
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
            return "()* loopback of 456:1: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*";
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
                        if ( (synpred7_InternalMex()) ) {s = 9;}

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
    public static final BitSet FOLLOW_12_in_ruleVariableAssignment350 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleVariableAssignment371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleFormula462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditionInBrackets_in_entryRuleAdditionInBrackets497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditionInBrackets507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAdditionInBrackets544 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleAdditionInBrackets565 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdditionInBrackets577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition673 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_15_in_ruleAddition686 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition719 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_16_in_ruleAddition739 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition772 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication871 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_17_in_ruleMultiplication884 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication917 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_18_in_ruleMultiplication937 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication970 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_19_in_ruleMultiplication990 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication1023 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_ruleUnaryExpression1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleUnaryExpression1140 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1173 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleUnaryExpression1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleUnaryExpression1205 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1238 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnaryExpression1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_entryRuleExponent1287 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExponent1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1347 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleExponent1371 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary1430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimary1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rulePrimary1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimary1619 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePrimary1636 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary1657 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimary1669 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePrimary1681 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary1702 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimary1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditionInBrackets_in_rulePrimary1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrix_in_entryRuleMatrix1792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrix1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleMatrix1839 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrix1861 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrix1874 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrix1895 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrix1910 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrix1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow1962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixRow1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleMatrixRow2009 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow2031 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrixRow2044 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow2065 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleMatrixRow2080 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMatrixRow2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAssignment_in_entryRuleMatrixAssignment2132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAssignment2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleMatrixAssignment2179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleMatrixAssignment2196 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMatrixAssignment2213 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMatrixAssignment2225 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_ruleMatrixFormula_in_ruleMatrixAssignment2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixFormula_in_entryRuleMatrixFormula2282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixFormula2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_ruleMatrixFormula2337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAdditionInBrackets_in_entryRuleMatrixAdditionInBrackets2372 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAdditionInBrackets2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMatrixAdditionInBrackets2419 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_ruleMatrixAdditionInBrackets2440 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleMatrixAdditionInBrackets2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_entryRuleMatrixAddition2488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixAddition2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2548 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_15_in_ruleMatrixAddition2561 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2594 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_16_in_ruleMatrixAddition2614 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_ruleMatrixAddition2647 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleMatrixMultiplication_in_entryRuleMatrixMultiplication2686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixMultiplication2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2746 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleMatrixMultiplication2759 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_ruleMatrixMultiplication2792 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleMatrixMultiplication2812 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleMatrixMultiplication2845 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_entryRulePrimaryMatrix2884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryMatrix2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrix_in_rulePrimaryMatrix2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePrimaryMatrix2985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix3002 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePrimaryMatrix3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePrimaryMatrix3051 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimaryMatrix3068 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePrimaryMatrix3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePrimaryMatrix3105 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_rulePrimaryMatrix3130 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePrimaryMatrix3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAdditionInBrackets_in_rulePrimaryMatrix3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_entryRuleFloat3220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFloat3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3272 = new BitSet(new long[]{0x0000000020000022L});
    public static final BitSet FOLLOW_29_in_ruleFloat3293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3309 = new BitSet(new long[]{0x00000000C0000022L});
    public static final BitSet FOLLOW_30_in_ruleFloat3331 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_31_in_ruleFloat3350 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_16_in_ruleFloat3365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat3383 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction3434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunction3486 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFunction3503 = new BitSet(new long[]{0x0000000000106030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction3525 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleFunction3538 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction3559 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleFunction3574 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleFunction3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition3626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleFunctionDefinition3682 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFunctionDefinition3694 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunctionDefinition3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_synpred1_InternalMex137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_synpred2_InternalMex164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_synpred3_InternalMex191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixAssignment_in_synpred4_InternalMex218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_synpred5_InternalMex686 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_synpred5_InternalMex719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred6_InternalMex739 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_synpred6_InternalMex772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred7_InternalMex884 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_synpred7_InternalMex917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_synpred10_InternalMex1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred25_InternalMex2759 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_rulePrimaryMatrix_in_synpred25_InternalMex2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred26_InternalMex2812 = new BitSet(new long[]{0x0000000000102030L});
    public static final BitSet FOLLOW_ruleFormula_in_synpred26_InternalMex2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred28_InternalMex2985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_synpred28_InternalMex3002 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred28_InternalMex3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred29_InternalMex3051 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_synpred29_InternalMex3068 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_synpred29_InternalMex3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred30_InternalMex3105 = new BitSet(new long[]{0x0000000002802000L});
    public static final BitSet FOLLOW_ruleMatrixAddition_in_synpred30_InternalMex3130 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred30_InternalMex3141 = new BitSet(new long[]{0x0000000000000002L});

}