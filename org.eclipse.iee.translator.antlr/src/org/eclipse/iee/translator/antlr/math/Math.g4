grammar Math;

statement:
	functionDefinition |
	variableAssignment |
	formula |
	logicalFormula
;

functionDefinition:
	function '=' formula
;

function:
	MATH_NAME '(' (params+=formula (',' params+=formula)*)? ')'
;
	
variableAssignment:
	formula '=' formula
;

formula:
	expr	
;

logicalFormula:
	logicalExpr
;

expr:
	expr '^'<assoc=right> expr #Power |
	('+'|'-') expr #Unary |
	expr ('*'|'/'|'%') expr #Mult |
	expr ('+'|'-') expr #Add |
	'(' expr ')' #ExprBrackets |
	primary	#PrimaryExpr
;

logicalExpr:
	logicalExpr '&&' logicalExpr #LogicMult |
	logicalExpr '||' logicalExpr #LogicAdd |
	'(' logicalExpr ')' #LogicBrackets |
	expr ('>'|'>='|'<'|'<='|'=='|'!=') expr #LogicComparison
;

primary:
	MATH_NAME #Variable |
	FLOAT #FloatNumber |
	INT #IntNumber |
	matrix #MatrixDefinition |
	MATH_NAME '[' formula ']' '[' formula ']' #MatrixElement | 
	function #PrimaryFunction |
	MATH_NAME '.' function #MethodCall |
	MATH_NAME '.' MATH_NAME #Property |
	MATH_NAME '^T' #TransposeMatrix
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
