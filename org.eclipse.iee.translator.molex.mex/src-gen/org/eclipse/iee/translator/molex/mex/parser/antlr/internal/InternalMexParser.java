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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MATH_NAME", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')!'", "'['", "')'", "'..'", "']'", "'^'", "'.'", "'E'", "'e'", "','", "'{'", "'}'"
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:82:1: ruleStatement returns [EObject current=null] : ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_functionDefinition_0_0 = null;

        EObject lv_matrixDefinition_1_0 = null;

        EObject lv_assignment_2_0 = null;

        EObject lv_formula_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:85:28: ( ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:86:1: ( ( (lv_functionDefinition_0_0= ruleFunctionDefinition ) ) | ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_formula_3_0= ruleFormula ) ) )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_MATH_NAME) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1_InternalMex()) ) {
                    alt1=1;
                }
                else if ( (synpred2_InternalMex()) ) {
                    alt1=2;
                }
                else if ( (synpred3_InternalMex()) ) {
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
            else if ( (LA1_0==RULE_INT||LA1_0==14||LA1_0==18||LA1_0==20) ) {
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:107:3: lv_matrixDefinition_1_0= ruleMatrixDefinition
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_assignment_2_0= ruleAssignment )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_assignment_2_0= ruleAssignment )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:126:3: lv_assignment_2_0= ruleAssignment
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:143:6: ( (lv_formula_3_0= ruleFormula ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:143:6: ( (lv_formula_3_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:144:1: (lv_formula_3_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:144:1: (lv_formula_3_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:145:3: lv_formula_3_0= ruleFormula
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:169:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:170:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:171:2: iv_ruleAssignment= ruleAssignment EOF
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:178:1: ruleAssignment returns [EObject current=null] : ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:181:28: ( ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:182:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:182:1: ( ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:182:2: ( (lv_variable_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' ( (lv_value_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:182:2: ( (lv_variable_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:183:1: (lv_variable_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:183:1: (lv_variable_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:184:3: lv_variable_0_0= RULE_MATH_NAME
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:204:1: ( (lv_value_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:205:1: (lv_value_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:205:1: (lv_value_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:206:3: lv_value_2_0= ruleFormula
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:230:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:231:2: (iv_ruleFormula= ruleFormula EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:232:2: iv_ruleFormula= ruleFormula EOF
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:239:1: ruleFormula returns [EObject current=null] : ( (lv_expression_0_0= ruleAddition ) ) ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:242:28: ( ( (lv_expression_0_0= ruleAddition ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:243:1: ( (lv_expression_0_0= ruleAddition ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:243:1: ( (lv_expression_0_0= ruleAddition ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:244:1: (lv_expression_0_0= ruleAddition )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:244:1: (lv_expression_0_0= ruleAddition )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:245:3: lv_expression_0_0= ruleAddition
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:269:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:270:2: (iv_ruleAddition= ruleAddition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:271:2: iv_ruleAddition= ruleAddition EOF
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:278:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:281:28: ( (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:282:1: (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:282:1: (this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:283:2: this_Multiplication_0= ruleMultiplication ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )*
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:294:1: ( (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) ) | (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) ) )*
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:294:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:294:2: (otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:294:4: otherlv_1= '+' () ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleAddition543); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:298:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:299:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:307:2: ( (lv_right_3_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:308:1: (lv_right_3_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:308:1: (lv_right_3_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:309:3: lv_right_3_0= ruleMultiplication
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:326:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:326:6: (otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:326:8: otherlv_4= '-' () ( (lv_right_6_0= ruleMultiplication ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAddition596); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:330:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:331:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:339:2: ( (lv_right_6_0= ruleMultiplication ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:340:1: (lv_right_6_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:340:1: (lv_right_6_0= ruleMultiplication )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:341:3: lv_right_6_0= ruleMultiplication
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:365:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:366:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:367:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:374:1: ruleMultiplication returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:377:28: ( (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:378:1: (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:378:1: (this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )* )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:379:2: this_UnaryExpression_0= ruleUnaryExpression ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication728);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_UnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:390:1: ( (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) ) | (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) ) )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case 15:
                    {
                    alt3=1;
                    }
                    break;
                case 16:
                    {
                    alt3=2;
                    }
                    break;
                case 17:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:390:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:390:2: (otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:390:4: otherlv_1= '*' () ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleMultiplication741); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:394:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:395:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:403:2: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:404:1: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:404:1: (lv_right_3_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:405:3: lv_right_3_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication774);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:422:6: (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:422:6: (otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:422:8: otherlv_4= '/' () ( (lv_right_6_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleMultiplication794); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:426:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:427:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:435:2: ( (lv_right_6_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:436:1: (lv_right_6_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:436:1: (lv_right_6_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:437:3: lv_right_6_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication827);
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
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:454:6: (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:454:6: (otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:454:8: otherlv_7= '%' () ( (lv_right_9_0= ruleUnaryExpression ) )
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleMultiplication847); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_2_0());
            	          
            	    }
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:458:1: ()
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:459:2: 
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

            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:467:2: ( (lv_right_9_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:468:1: (lv_right_9_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:468:1: (lv_right_9_0= ruleUnaryExpression )
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:469:3: lv_right_9_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryExpressionParserRuleCall_1_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplication880);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:493:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:494:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:495:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression919);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression929); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:502:1: ruleUnaryExpression returns [EObject current=null] : (this_Exponent_0= ruleExponent | (otherlv_1= '-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' ) | ( () ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) ) otherlv_10= '(' ( (lv_ceil_11_0= ruleUnaryExpression ) ) otherlv_12= ')' otherlv_13= '..' otherlv_14= '(' ( (lv_floor_15_0= ruleUnaryExpression ) ) otherlv_16= ')' ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token lv_openingBracket_9_1=null;
        Token lv_openingBracket_9_2=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token lv_closingBracket_17_1=null;
        Token lv_closingBracket_17_2=null;
        EObject this_Exponent_0 = null;

        EObject lv_expression_3_0 = null;

        EObject lv_expression_6_0 = null;

        EObject lv_ceil_11_0 = null;

        EObject lv_floor_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:505:28: ( (this_Exponent_0= ruleExponent | (otherlv_1= '-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' ) | ( () ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) ) otherlv_10= '(' ( (lv_ceil_11_0= ruleUnaryExpression ) ) otherlv_12= ')' otherlv_13= '..' otherlv_14= '(' ( (lv_floor_15_0= ruleUnaryExpression ) ) otherlv_16= ')' ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:506:1: (this_Exponent_0= ruleExponent | (otherlv_1= '-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' ) | ( () ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) ) otherlv_10= '(' ( (lv_ceil_11_0= ruleUnaryExpression ) ) otherlv_12= ')' otherlv_13= '..' otherlv_14= '(' ( (lv_floor_15_0= ruleUnaryExpression ) ) otherlv_16= ')' ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:506:1: (this_Exponent_0= ruleExponent | (otherlv_1= '-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) ) | (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' ) | ( () ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) ) otherlv_10= '(' ( (lv_ceil_11_0= ruleUnaryExpression ) ) otherlv_12= ')' otherlv_13= '..' otherlv_14= '(' ( (lv_floor_15_0= ruleUnaryExpression ) ) otherlv_16= ')' ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case RULE_MATH_NAME:
            case RULE_INT:
                {
                alt6=1;
                }
                break;
            case 18:
                {
                int LA6_3 = input.LA(2);

                if ( (synpred9_InternalMex()) ) {
                    alt6=1;
                }
                else if ( (synpred11_InternalMex()) ) {
                    alt6=3;
                }
                else if ( (true) ) {
                    alt6=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=4;
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:507:2: this_Exponent_0= ruleExponent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExponentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExponent_in_ruleUnaryExpression979);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:519:6: (otherlv_1= '-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:519:6: (otherlv_1= '-' () ( (lv_expression_3_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:519:8: otherlv_1= '-' () ( (lv_expression_3_0= ruleUnaryExpression ) )
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleUnaryExpression997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getUnaryExpressionAccess().getHyphenMinusKeyword_1_0());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:523:1: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:524:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:532:2: ( (lv_expression_3_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:533:1: (lv_expression_3_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:533:1: (lv_expression_3_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:534:3: lv_expression_3_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1030);
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


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:551:6: (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:551:6: (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:551:8: otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!'
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleUnaryExpression1050); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:555:1: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:556:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:564:2: ( (lv_expression_6_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:565:1: (lv_expression_6_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:565:1: (lv_expression_6_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:566:3: lv_expression_6_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1083);
                    lv_expression_6_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_6_0, 
                              		"UnaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleUnaryExpression1095); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getUnaryExpressionAccess().getRightParenthesisExclamationMarkKeyword_2_3());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:587:6: ( () ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) ) otherlv_10= '(' ( (lv_ceil_11_0= ruleUnaryExpression ) ) otherlv_12= ')' otherlv_13= '..' otherlv_14= '(' ( (lv_floor_15_0= ruleUnaryExpression ) ) otherlv_16= ')' ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:587:6: ( () ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) ) otherlv_10= '(' ( (lv_ceil_11_0= ruleUnaryExpression ) ) otherlv_12= ')' otherlv_13= '..' otherlv_14= '(' ( (lv_floor_15_0= ruleUnaryExpression ) ) otherlv_16= ')' ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:587:7: () ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) ) otherlv_10= '(' ( (lv_ceil_11_0= ruleUnaryExpression ) ) otherlv_12= ')' otherlv_13= '..' otherlv_14= '(' ( (lv_floor_15_0= ruleUnaryExpression ) ) otherlv_16= ')' ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:587:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:588:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryExpressionAccess().getIntervalAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:596:2: ( ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:597:1: ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:597:1: ( (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:598:1: (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:598:1: (lv_openingBracket_9_1= '[' | lv_openingBracket_9_2= '(' )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==18) ) {
                        alt4=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:599:3: lv_openingBracket_9_1= '['
                            {
                            lv_openingBracket_9_1=(Token)match(input,20,FOLLOW_20_in_ruleUnaryExpression1135); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_openingBracket_9_1, grammarAccess.getUnaryExpressionAccess().getOpeningBracketLeftSquareBracketKeyword_3_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "openingBracket", lv_openingBracket_9_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:611:8: lv_openingBracket_9_2= '('
                            {
                            lv_openingBracket_9_2=(Token)match(input,18,FOLLOW_18_in_ruleUnaryExpression1164); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_openingBracket_9_2, grammarAccess.getUnaryExpressionAccess().getOpeningBracketLeftParenthesisKeyword_3_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "openingBracket", lv_openingBracket_9_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleUnaryExpression1192); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_3_2());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:630:1: ( (lv_ceil_11_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:631:1: (lv_ceil_11_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:631:1: (lv_ceil_11_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:632:3: lv_ceil_11_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getCeilUnaryExpressionParserRuleCall_3_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1213);
                    lv_ceil_11_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"ceil",
                              		lv_ceil_11_0, 
                              		"UnaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,21,FOLLOW_21_in_ruleUnaryExpression1225); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getUnaryExpressionAccess().getRightParenthesisKeyword_3_4());
                          
                    }
                    otherlv_13=(Token)match(input,22,FOLLOW_22_in_ruleUnaryExpression1237); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getUnaryExpressionAccess().getFullStopFullStopKeyword_3_5());
                          
                    }
                    otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleUnaryExpression1249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getUnaryExpressionAccess().getLeftParenthesisKeyword_3_6());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:660:1: ( (lv_floor_15_0= ruleUnaryExpression ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:661:1: (lv_floor_15_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:661:1: (lv_floor_15_0= ruleUnaryExpression )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:662:3: lv_floor_15_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getFloorUnaryExpressionParserRuleCall_3_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1270);
                    lv_floor_15_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"floor",
                              		lv_floor_15_0, 
                              		"UnaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_16=(Token)match(input,21,FOLLOW_21_in_ruleUnaryExpression1282); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getUnaryExpressionAccess().getRightParenthesisKeyword_3_8());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:682:1: ( ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:683:1: ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:683:1: ( (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:684:1: (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:684:1: (lv_closingBracket_17_1= ']' | lv_closingBracket_17_2= ')' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==23) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==21) ) {
                        alt5=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:685:3: lv_closingBracket_17_1= ']'
                            {
                            lv_closingBracket_17_1=(Token)match(input,23,FOLLOW_23_in_ruleUnaryExpression1302); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_closingBracket_17_1, grammarAccess.getUnaryExpressionAccess().getClosingBracketRightSquareBracketKeyword_3_9_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "closingBracket", lv_closingBracket_17_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:697:8: lv_closingBracket_17_2= ')'
                            {
                            lv_closingBracket_17_2=(Token)match(input,21,FOLLOW_21_in_ruleUnaryExpression1331); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_closingBracket_17_2, grammarAccess.getUnaryExpressionAccess().getClosingBracketRightParenthesisKeyword_3_9_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "closingBracket", lv_closingBracket_17_2, null);
                              	    
                            }

                            }
                            break;

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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleExponent"
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:720:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:721:2: (iv_ruleExponent= ruleExponent EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:722:2: iv_ruleExponent= ruleExponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExponentRule()); 
            }
            pushFollow(FOLLOW_ruleExponent_in_entryRuleExponent1384);
            iv_ruleExponent=ruleExponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExponent1394); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:729:1: ruleExponent returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:732:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:733:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:733:1: (this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )? )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:734:2: this_Primary_0= rulePrimary ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExponentAccess().getPrimaryParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimary_in_ruleExponent1444);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:745:1: ( () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:745:2: () otherlv_2= '^' ( (lv_right_3_0= rulePrimary ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:745:2: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:746:2: 
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

                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleExponent1468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:758:1: ( (lv_right_3_0= rulePrimary ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:759:1: (lv_right_3_0= rulePrimary )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:759:1: (lv_right_3_0= rulePrimary )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:760:3: lv_right_3_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExponentAccess().getRightPrimaryParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimary_in_ruleExponent1489);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:784:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:785:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:786:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary1527);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary1537); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:793:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:796:28: ( ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:1: ( ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) ) | ( () ( (lv_value_3_0= ruleFloat ) ) ) | ( () ( (lv_function_5_0= ruleFunction ) ) ) | (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_MATH_NAME:
                {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==EOF||(LA8_1>=13 && LA8_1<=17)||LA8_1==19||LA8_1==21||LA8_1==24||LA8_1==28) ) {
                    alt8=1;
                }
                else if ( (LA8_1==18) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt8=2;
                }
                break;
            case 18:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:2: ( () ( (lv_name_1_0= RULE_MATH_NAME ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:3: () ( (lv_name_1_0= RULE_MATH_NAME ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:797:3: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:798:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:806:2: ( (lv_name_1_0= RULE_MATH_NAME ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:807:1: (lv_name_1_0= RULE_MATH_NAME )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:807:1: (lv_name_1_0= RULE_MATH_NAME )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:808:3: lv_name_1_0= RULE_MATH_NAME
                    {
                    lv_name_1_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_rulePrimary1592); if (state.failed) return current;
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:6: ( () ( (lv_value_3_0= ruleFloat ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:7: () ( (lv_value_3_0= ruleFloat ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:825:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:826:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:834:2: ( (lv_value_3_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:835:1: (lv_value_3_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:835:1: (lv_value_3_0= ruleFloat )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:836:3: lv_value_3_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getValueFloatParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_rulePrimary1638);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:853:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:853:6: ( () ( (lv_function_5_0= ruleFunction ) ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:853:7: () ( (lv_function_5_0= ruleFunction ) )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:853:7: ()
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:854:2: 
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:862:2: ( (lv_function_5_0= ruleFunction ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:863:1: (lv_function_5_0= ruleFunction )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:863:1: (lv_function_5_0= ruleFunction )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:864:3: lv_function_5_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryAccess().getFunctionFunctionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_rulePrimary1679);
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
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:881:6: (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:881:6: (otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')' )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:881:8: otherlv_6= '(' this_Addition_7= ruleAddition otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_rulePrimary1699); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getAdditionParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAddition_in_rulePrimary1724);
                    this_Addition_7=ruleAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Addition_7; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_rulePrimary1735); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:909:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:910:2: (iv_ruleFloat= ruleFloat EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:911:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_ruleFloat_in_entryRuleFloat1773);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFloat1784); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:918:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:921:28: ( ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:922:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:922:1: ( (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )? )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:922:2: (this_INT_0= RULE_INT )+ (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:922:2: (this_INT_0= RULE_INT )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_INT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:922:7: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1825); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_0, grammarAccess.getFloatAccess().getINTTerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:929:3: (kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )? )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:930:2: kw= '.' (this_INT_2= RULE_INT )+ ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleFloat1846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:935:1: (this_INT_2= RULE_INT )+
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
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:935:6: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1862); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_INT_2);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_INT_2, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_1()); 
                    	          
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:942:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+ )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=26 && LA14_0<=27)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:942:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? (this_INT_6= RULE_INT )+
                            {
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:942:4: (kw= 'E' | kw= 'e' )
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==26) ) {
                                alt11=1;
                            }
                            else if ( (LA11_0==27) ) {
                                alt11=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 11, 0, input);

                                throw nvae;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:943:2: kw= 'E'
                                    {
                                    kw=(Token)match(input,26,FOLLOW_26_in_ruleFloat1884); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:950:2: kw= 'e'
                                    {
                                    kw=(Token)match(input,27,FOLLOW_27_in_ruleFloat1903); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getEKeyword_1_2_0_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:955:2: (kw= '-' )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0==14) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:956:2: kw= '-'
                                    {
                                    kw=(Token)match(input,14,FOLLOW_14_in_ruleFloat1918); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              current.merge(kw);
                                              newLeafNode(kw, grammarAccess.getFloatAccess().getHyphenMinusKeyword_1_2_1()); 
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:961:3: (this_INT_6= RULE_INT )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_INT) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:961:8: this_INT_6= RULE_INT
                            	    {
                            	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFloat1936); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      		current.merge(this_INT_6);
                            	          
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_INT_6, grammarAccess.getFloatAccess().getINTTerminalRuleCall_1_2_2()); 
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt13 >= 1 ) break loop13;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:976:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:977:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:978:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction1987);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction1997); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:985:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:988:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:989:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:989:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:989:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )? otherlv_6= ')'
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:989:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:990:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:990:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:991:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleFunction2039); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleFunction2056); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1011:1: ( ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )? )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_MATH_NAME && LA18_0<=RULE_INT)||LA18_0==14||LA18_0==18||LA18_0==20) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1011:2: ( (lv_parameters_2_0= ruleFormula ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )* (otherlv_5= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1011:2: ( (lv_parameters_2_0= ruleFormula ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1012:1: (lv_parameters_2_0= ruleFormula )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1012:1: (lv_parameters_2_0= ruleFormula )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1013:3: lv_parameters_2_0= ruleFormula
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFormula_in_ruleFunction2078);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1029:2: (otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==28) ) {
                            int LA16_1 = input.LA(2);

                            if ( ((LA16_1>=RULE_MATH_NAME && LA16_1<=RULE_INT)||LA16_1==14||LA16_1==18||LA16_1==20) ) {
                                alt16=1;
                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1029:4: otherlv_3= ',' ( (lv_parameters_4_0= ruleFormula ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleFunction2091); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1033:1: ( (lv_parameters_4_0= ruleFormula ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1034:1: (lv_parameters_4_0= ruleFormula )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1034:1: (lv_parameters_4_0= ruleFormula )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1035:3: lv_parameters_4_0= ruleFormula
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersFormulaParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFormula_in_ruleFunction2112);
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
                    	    break loop16;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1051:4: (otherlv_5= ',' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==28) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1051:6: otherlv_5= ','
                            {
                            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleFunction2127); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getCommaKeyword_2_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleFunction2143); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1067:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1068:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1069:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition2179);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition2189); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1076:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_function_0_0 = null;

        EObject lv_formula_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1079:28: ( ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1080:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1080:1: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1080:2: ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '=' ( (lv_formula_2_0= ruleFormula ) )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1080:2: ( (lv_function_0_0= ruleFunction ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1081:1: (lv_function_0_0= ruleFunction )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1081:1: (lv_function_0_0= ruleFunction )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1082:3: lv_function_0_0= ruleFunction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctionFunctionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleFunctionDefinition2235);
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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleFunctionDefinition2247); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1102:1: ( (lv_formula_2_0= ruleFormula ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1103:1: (lv_formula_2_0= ruleFormula )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1103:1: (lv_formula_2_0= ruleFormula )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1104:3: lv_formula_2_0= ruleFormula
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFormulaFormulaParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFormula_in_ruleFunctionDefinition2268);
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1128:1: entryRuleMatrixDefinition returns [EObject current=null] : iv_ruleMatrixDefinition= ruleMatrixDefinition EOF ;
    public final EObject entryRuleMatrixDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixDefinition = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1129:2: (iv_ruleMatrixDefinition= ruleMatrixDefinition EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1130:2: iv_ruleMatrixDefinition= ruleMatrixDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixDefinition_in_entryRuleMatrixDefinition2304);
            iv_ruleMatrixDefinition=ruleMatrixDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixDefinition2314); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1137:1: ruleMatrixDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1140:28: ( ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1141:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1141:1: ( ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1141:2: ( (lv_name_0_0= RULE_MATH_NAME ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )? otherlv_7= '}'
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1141:2: ( (lv_name_0_0= RULE_MATH_NAME ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1142:1: (lv_name_0_0= RULE_MATH_NAME )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1142:1: (lv_name_0_0= RULE_MATH_NAME )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1143:3: lv_name_0_0= RULE_MATH_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_MATH_NAME,FOLLOW_RULE_MATH_NAME_in_ruleMatrixDefinition2356); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleMatrixDefinition2373); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMatrixDefinitionAccess().getEqualsSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleMatrixDefinition2385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMatrixDefinitionAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1167:1: ( ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1167:2: ( (lv_rows_3_0= ruleMatrixRow ) ) (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )* (otherlv_6= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1167:2: ( (lv_rows_3_0= ruleMatrixRow ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1168:1: (lv_rows_3_0= ruleMatrixRow )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1168:1: (lv_rows_3_0= ruleMatrixRow )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1169:3: lv_rows_3_0= ruleMatrixRow
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixDefinitionAccess().getRowsMatrixRowParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition2407);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1185:2: (otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==28) ) {
                            int LA19_1 = input.LA(2);

                            if ( (LA19_1==29) ) {
                                alt19=1;
                            }


                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1185:4: otherlv_4= ',' ( (lv_rows_5_0= ruleMatrixRow ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleMatrixDefinition2420); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getMatrixDefinitionAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1189:1: ( (lv_rows_5_0= ruleMatrixRow ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1190:1: (lv_rows_5_0= ruleMatrixRow )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1190:1: (lv_rows_5_0= ruleMatrixRow )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1191:3: lv_rows_5_0= ruleMatrixRow
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixDefinitionAccess().getRowsMatrixRowParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition2441);
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
                    	    break loop19;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1207:4: (otherlv_6= ',' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==28) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1207:6: otherlv_6= ','
                            {
                            otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleMatrixDefinition2456); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getMatrixDefinitionAccess().getCommaKeyword_3_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleMatrixDefinition2472); if (state.failed) return current;
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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1223:1: entryRuleMatrixRow returns [EObject current=null] : iv_ruleMatrixRow= ruleMatrixRow EOF ;
    public final EObject entryRuleMatrixRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixRow = null;


        try {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1224:2: (iv_ruleMatrixRow= ruleMatrixRow EOF )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1225:2: iv_ruleMatrixRow= ruleMatrixRow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMatrixRowRule()); 
            }
            pushFollow(FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow2508);
            iv_ruleMatrixRow=ruleMatrixRow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMatrixRow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixRow2518); if (state.failed) return current;

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
    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1232:1: ruleMatrixRow returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) ;
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
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1235:28: ( (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' ) )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1236:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            {
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1236:1: (otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}' )
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1236:3: otherlv_0= '{' ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleMatrixRow2555); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMatrixRowAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1240:1: ( ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INT) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1240:2: ( (lv_elements_1_0= ruleFloat ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )* (otherlv_4= ',' )?
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1240:2: ( (lv_elements_1_0= ruleFloat ) )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1241:1: (lv_elements_1_0= ruleFloat )
                    {
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1241:1: (lv_elements_1_0= ruleFloat )
                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1242:3: lv_elements_1_0= ruleFloat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow2577);
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

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1258:2: (otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==28) ) {
                            int LA22_1 = input.LA(2);

                            if ( (LA22_1==RULE_INT) ) {
                                alt22=1;
                            }


                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1258:4: otherlv_2= ',' ( (lv_elements_3_0= ruleFloat ) )
                    	    {
                    	    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleMatrixRow2590); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1262:1: ( (lv_elements_3_0= ruleFloat ) )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1263:1: (lv_elements_3_0= ruleFloat )
                    	    {
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1263:1: (lv_elements_3_0= ruleFloat )
                    	    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1264:3: lv_elements_3_0= ruleFloat
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMatrixRowAccess().getElementsFloatParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFloat_in_ruleMatrixRow2611);
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
                    	    break loop22;
                        }
                    } while (true);

                    // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1280:4: (otherlv_4= ',' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==28) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:1280:6: otherlv_4= ','
                            {
                            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleMatrixRow2626); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getMatrixRowAccess().getCommaKeyword_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleMatrixRow2642); if (state.failed) return current;
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
        EObject lv_matrixDefinition_1_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:105:6: ( (lv_matrixDefinition_1_0= ruleMatrixDefinition ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:106:1: (lv_matrixDefinition_1_0= ruleMatrixDefinition )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:107:3: lv_matrixDefinition_1_0= ruleMatrixDefinition
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getMatrixDefinitionMatrixDefinitionParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMatrixDefinition_in_synpred2_InternalMex164);
        lv_matrixDefinition_1_0=ruleMatrixDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalMex

    // $ANTLR start synpred3_InternalMex
    public final void synpred3_InternalMex_fragment() throws RecognitionException {   
        EObject lv_assignment_2_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( ( (lv_assignment_2_0= ruleAssignment ) ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:124:6: ( (lv_assignment_2_0= ruleAssignment ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_assignment_2_0= ruleAssignment )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:125:1: (lv_assignment_2_0= ruleAssignment )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:126:3: lv_assignment_2_0= ruleAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getAssignmentAssignmentParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleAssignment_in_synpred3_InternalMex191);
        lv_assignment_2_0=ruleAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalMex

    // $ANTLR start synpred9_InternalMex
    public final void synpred9_InternalMex_fragment() throws RecognitionException {   
        EObject this_Exponent_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:507:2: (this_Exponent_0= ruleExponent )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:507:2: this_Exponent_0= ruleExponent
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleExponent_in_synpred9_InternalMex979);
        this_Exponent_0=ruleExponent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalMex

    // $ANTLR start synpred11_InternalMex
    public final void synpred11_InternalMex_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_expression_6_0 = null;


        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:551:6: ( (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:551:6: (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:551:6: (otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!' )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:551:8: otherlv_4= '(' () ( (lv_expression_6_0= ruleUnaryExpression ) ) otherlv_7= ')!'
        {
        otherlv_4=(Token)match(input,18,FOLLOW_18_in_synpred11_InternalMex1050); if (state.failed) return ;
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:555:1: ()
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:556:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:564:2: ( (lv_expression_6_0= ruleUnaryExpression ) )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:565:1: (lv_expression_6_0= ruleUnaryExpression )
        {
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:565:1: (lv_expression_6_0= ruleUnaryExpression )
        // ../org.eclipse.iee.translator.molex.mex/src-gen/org/eclipse/iee/translator/molex/mex/parser/antlr/internal/InternalMex.g:566:3: lv_expression_6_0= ruleUnaryExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpressionUnaryExpressionParserRuleCall_2_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleUnaryExpression_in_synpred11_InternalMex1083);
        lv_expression_6_0=ruleUnaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_7=(Token)match(input,19,FOLLOW_19_in_synpred11_InternalMex1095); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalMex

    // Delegated rules

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
    public final boolean synpred9_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalMex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalMex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalMex_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_12_in_ruleAssignment323 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleAssignment344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormula_in_entryRuleFormula380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormula390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleFormula435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition530 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_13_in_ruleAddition543 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition576 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_14_in_ruleAddition596 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition629 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication728 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_15_in_ruleMultiplication741 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication774 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplication794 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication827 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_17_in_ruleMultiplication847 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplication880 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_ruleUnaryExpression979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleUnaryExpression997 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleUnaryExpression1050 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1083 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleUnaryExpression1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleUnaryExpression1135 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUnaryExpression1164 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUnaryExpression1192 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1213 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnaryExpression1225 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUnaryExpression1237 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUnaryExpression1249 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1270 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnaryExpression1282 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_23_in_ruleUnaryExpression1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleUnaryExpression1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_entryRuleExponent1384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExponent1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1444 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleExponent1468 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleExponent1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary1527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_rulePrimary1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_rulePrimary1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rulePrimary1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulePrimary1699 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleAddition_in_rulePrimary1724 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rulePrimary1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFloat_in_entryRuleFloat1773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFloat1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1825 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_25_in_ruleFloat1846 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1862 = new BitSet(new long[]{0x000000000C000022L});
    public static final BitSet FOLLOW_26_in_ruleFloat1884 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_27_in_ruleFloat1903 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_14_in_ruleFloat1918 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFloat1936 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction1987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleFunction2039 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFunction2056 = new BitSet(new long[]{0x0000000000344030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction2078 = new BitSet(new long[]{0x0000000010200000L});
    public static final BitSet FOLLOW_28_in_ruleFunction2091 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunction2112 = new BitSet(new long[]{0x0000000010200000L});
    public static final BitSet FOLLOW_28_in_ruleFunction2127 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFunction2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition2179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleFunctionDefinition2235 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFunctionDefinition2247 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleFormula_in_ruleFunctionDefinition2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixDefinition_in_entryRuleMatrixDefinition2304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixDefinition2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MATH_NAME_in_ruleMatrixDefinition2356 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMatrixDefinition2373 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMatrixDefinition2385 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition2407 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleMatrixDefinition2420 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_ruleMatrixDefinition2441 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleMatrixDefinition2456 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleMatrixDefinition2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixRow_in_entryRuleMatrixRow2508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixRow2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleMatrixRow2555 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow2577 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleMatrixRow2590 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFloat_in_ruleMatrixRow2611 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_ruleMatrixRow2626 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleMatrixRow2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_synpred1_InternalMex137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixDefinition_in_synpred2_InternalMex164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_synpred3_InternalMex191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExponent_in_synpred9_InternalMex979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred11_InternalMex1050 = new BitSet(new long[]{0x0000000000144030L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_synpred11_InternalMex1083 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_synpred11_InternalMex1095 = new BitSet(new long[]{0x0000000000000002L});

}