grammar Math;

statement:
	functionDefinition |
	variableAssignment |
	expression |
	logicalExpression
;

functionDefinition:
	name=standardFunction '=' value=expression
;

function:
        standardFunction |
        internalFunction
        ;

internalFunction:
        name=INTERNAL_FUNCTION_NAME '(' 
            func=expression (',' (params+=parameter (',' params+=parameter)*)?)?
        ')'
;

standardFunction:
        name=MATH_NAME '(' (params+=expression (',' params+=expression)*)? ')'            
                ;
	
variableAssignment:
	name=expression '=' value=expression
;

expression:
	left=expression '^'<assoc=right> right=expression #Power |
	sign=('+'|'-') unaryExpr=expression #Unary |
	left=expression sign=('*'|'/'|'%') right=expression #Mult |
	left=expression sign=('+'|'-') right=expression #Add |
	'(' bracketedExpr=expression ')' #ExprBrackets |
	primary	#PrimaryExpr
;

logicalExpression:
	left=logicalExpression sign='&&' right=logicalExpression #LogicMult |
	left=logicalExpression sign='||' right=logicalExpression #LogicAdd |
	'(' expr=logicalExpression ')' #LogicBrackets |
	left=expression 
            sign=('>'|'>='|'<'|'<='|'=='|'!=') 
        right=expression #LogicComparison
;

primary:
	MATH_NAME #Variable |
	FLOAT #FloatNumber |
	INT #IntNumber |
	matrix #MatrixDefinition |
	name=MATH_NAME '[' rowIdx=expression ']' '[' columnIdx=expression ']' #MatrixElement | 
	function #PrimaryFunction |
	objName=MATH_NAME '.' objFunction=function #MethodCall |
	objName=MATH_NAME '.' objProperty=MATH_NAME #Property 
;

parameter: 
    '{' variable=MATH_NAME '}' #ValueParameter |
    '{' variable=MATH_NAME ',' min=( INT | FLOAT ) ',' max=( INT | FLOAT ) '}' #IntervalParameter
;

matrix:
	'{' (rows+=matrixRow (',' rows+=matrixRow)* ','?)? '}';

matrixRow:
	'{' (elements+=expression (',' elements+=expression)* ','?)? '}';

INTERNAL_FUNCTION_NAME:
    'NIntegrate' | 'NSum' | 'D' | 'Product' | 'Sqrt'                      
;

MATH_NAME:
	LETTER (LETTER | INT |
                '_{' (MATH_NAME | INT) '}' |
                '_' (MATH_NAME | INT))*
;

LETTER:
        'a'..'z' | 'A'..'Z'
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
