grammar Math;

statement:
	functionDefinition |
	variableAssignment |
	formula |
	logicalFormula
;

functionDefinition:
	name=function '=' value=formula
;

function:
	name=MATH_NAME '(' (params+=formula (',' params+=formula)*)? ')'
;
	
variableAssignment:
	name=formula '=' value=formula
;

formula:
	expr	
;

logicalFormula:
	logicalExpr
;

expr:
	left=expr '^'<assoc=right> right=expr #Power |
	sign=('+'|'-') expression=expr #Unary |
	left=expr sign=('*'|'/'|'%') right=expr #Mult |
	left=expr sign=('+'|'-') right=expr #Add |
	'(' expression=expr ')' #ExprBrackets |
	primary	#PrimaryExpr
;

logicalExpr:
	left=logicalExpr sign='&&' right=logicalExpr #LogicMult |
	left=logicalExpr sign='||' right=logicalExpr #LogicAdd |
	'(' expression=logicalExpr ')' #LogicBrackets |
	left=expr sign=('>'|'>='|'<'|'<='|'=='|'!=') right=expr #LogicComparison
;

primary:
	MATH_NAME #Variable |
	FLOAT #FloatNumber |
	INT #IntNumber |
	matrix #MatrixDefinition |
	name=MATH_NAME '[' rowIdx=formula ']' '[' columnIdx=formula ']' #MatrixElement | 
	function #PrimaryFunction |
	objName=MATH_NAME '.' objFunction=function #MethodCall |
	objName=MATH_NAME '.' objProperty=MATH_NAME #Property |
	name=MATH_NAME '^T' #TransposeMatrix
;

matrix:
	'{' (rows+=matrixRow (',' rows+=matrixRow)* ','?)? '}';

matrixRow:
	'{' (elements+=formula (',' elements+=formula)* ','?)? '}';
	
MATH_NAME:
	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
;

INT :   DIGIT+ [Ll]? ;

WS:
	( ' ' | '\t' | '\r' | '\n' ) -> skip 
;

FLOAT:  DIGIT+ '.' DIGIT* EXP? [Ll]?
    |   DIGIT+ EXP? [Ll]?
    |   '.' DIGIT+ EXP? [Ll]?
;

fragment
DIGIT:  
	'0'..'9' 
;

fragment
EXP :   
	('E' | 'e') ('+' | '-')? INT 
;
