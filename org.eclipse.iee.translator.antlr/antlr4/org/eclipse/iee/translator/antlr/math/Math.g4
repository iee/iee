grammar Math;

statement:
	functionDefinition |
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
	
expression
	: primary #PrimaryExpr
	| function #PrimaryFunctions
	| container = expression '[' rowId = expression ']' '[' columnId = expression ']' #MatrixElement
	| container = expression '[' rowId = expression 'ˇ]' #MatrixRow
	| container = expression '.' func = standardFunction #MethodCall
	| container = expression '.' property = MATH_NAME #Property
	| matrix #MatrixDefinition
	| begin = expression '..' end = expression #RangeExpr
	| left=expression '^'<assoc=right> right=expression #Power 
	| sign=('+'|'-') unaryExpr=expression #Unary 
	| left=expression sign=('*'|'/'|'%') right=expression #Mult 
	| left=expression sign=('+'|'-') right=expression #Add 
	| left=expression sign=('<<'|'>>'|'>>>') right=expression #Shift 
	| left=expression '&' right=expression #BitwiseAdd 
	| left=expression XOR right=expression #Xor 
	| left=expression '|' right=expression #BitwiseOr 
	| '(' bracketedExpr=expression ')' #ExprBrackets
	| <assoc=right> name=expression '=' value=expression #VariableAssignment
;

logicalExpression:
	left=logicalExpression sign='&&' right=logicalExpression #LogicMult |
	left=logicalExpression sign='||' right=logicalExpression #LogicAdd |
	'(' expr=logicalExpression ')' #LogicBrackets |
	left=expression 
            sign=('>'|'>='|'<'|'<='|'=='|'!=') 
        right=expression #LogicComparison
;

primary
	: MATH_NAME #Variable 
	| FLOAT #FloatNumber 
	| INT #IntNumber
;

parameter: 
    variable=MATH_NAME #ValueParameter |
    variable=MATH_NAME '=' min=expression INTERVAL max=expression #IntervalParameter
;

matrix:
	'{' rows+=vector (',' rows+=vector)* ','? '}';

vector:
	'{' (elements+=expression (',' elements+=expression)* ','?)? '}';

INTERNAL_FUNCTION_NAME:
    'Integrate' | 'Sum' | 'Diff' | 'Product' | 'Sqrt'                      
;

INTERVAL:
    '..'        
;

XOR: 
    'XOR'
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

FLOAT:  DIGIT+ '.' DIGIT+ EXP? [Ll]?
    |   DIGIT+ EXP? [Ll]?
;

fragment
DIGIT:  
	'0'..'9' 
;

fragment
EXP :   
	('E' | 'e') ('+' | '-')? INT 
;
