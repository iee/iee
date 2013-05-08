lexer grammar JavaLexer;

Keyword
  :'boolean'
  |'byte'
  |'char'
  |'double'
  |'float'
  |'int'
  |'long'
  |'short'
  |'void'
  |'assert'
  |'abstract'
  |'default'
  |'if'
  |'private'
  |'this'
  |'do'
  |'implements'
  |'protected'
  |'throw'
  |'break'
  |'import'
  |'public'
  |'throws'
  |'else'
  |'instanceof'
  |'return'
  |'transient'
  |'case'
  |'extends'
  |'try'
  |'catch'
  |'final'
  |'interface'
  |'static'
  |'finally'
  |'strictfp'
  |'volatile'
  |'class'
  |'native'
  |'super'
  |'while'
  |'const'
  |'for'
  |'new'
  |'strictfp'
  |'switch'
  |'continue'
  |'goto'
  |'package'
  |'synchronized'
  |'threadsafe'
  |'null'
  |'true'
  |'false'
  |'enum'
  |'@interface'
  ;

Braces
  : '('
  | ')'
  | '{'
  | '}'
  | '['
  | ']'
  ;

Delimiters
  : ';'
  | ':'
  | '.'
  | ','  
  | '+'
  | '-'
  | '/'
  | '\\'
  | '*'
  | '!'
  | '?'
  | '#'
  | '%'
  | '&'
  | '|'
  | '<'
  | '>'
  | '='
  | '^'
  ;

HexLiteral
  // underscores may be freely inserted after first hex digit and before last
  : '0' ('x'|'X')
    HexDigits
    IntegerTypeSuffix?
  ;

DecimalLiteral
  // Only a single zero digit may begin with a zero
  // Underscores may be freely inserted after first digit and before last
  : ( '0' | '1'..'9' ('_'* Digit)* ) IntegerTypeSuffix?
  ;

OctalLiteral
  // Underscores may be freely inserted before the last digit.
  // Don't know why underscores here are different from others -
  // Maybe the leading 0 is considered a digit as well as a marker
  // indicating that the following is a base 8 number
  : '0' ('_'* '0'..'7')+ IntegerTypeSuffix?
  ;

BinaryLiteral
  // underscores may be freely inserted after first digit and before last
  : '0' ('b'|'B')
    BinaryDigit ('_'* BinaryDigit)*
    IntegerTypeSuffix?
  ;

fragment
BinaryDigit : ('0'|'1') ;

fragment
HexDigits : HexDigit ('_'* HexDigit)* ;

fragment
HexDigit : (Digit|'a'..'f'|'A'..'F') ;

fragment
Digits : Digit ('_'* Digit)* ;

fragment
Digit : '0'..'9' ;

fragment
IntegerTypeSuffix : ('l'|'L') ;

FloatingPointLiteral
  : Digits '.' Digits? Exponent? FloatTypeSuffix?
  | '.' Digits Exponent? FloatTypeSuffix?
  | Digits Exponent FloatTypeSuffix?
  | Digits FloatTypeSuffix

    // Hex float literal
  | ('0x' | '0X')
    HexDigits? ('.' HexDigits?)?
    ( 'p' | 'P' ) ( '+' | '-' )? Digits // note decimal exponent
    FloatTypeSuffix?
  ;

fragment
Exponent : ('e'|'E') ('+'|'-')? Digits ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

CharacterLiteral
  : '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
  ;

StringLiteral
  :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
  ;

fragment
EscapeSequence
  : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
  | UnicodeEscape
  | OctalEscape
  ;

fragment
OctalEscape
  : '\\' ('0'..'3') ('0'..'7') ('0'..'7')
  | '\\' ('0'..'7') ('0'..'7')
  | '\\' ('0'..'7')
  ;

fragment
UnicodeEscape
  : '\\' 'u' HexDigit HexDigit HexDigit HexDigit
  ;

Identifier
  : Letter (Letter|JavaIDDigit)*
  ;

/**I found this char range in JavaCC's grammar, but Letter and Digit overlap.
   Still works, but...
 */
fragment
Letter
  : '\u0024'                 // $
  | '\u0041'..'\u005a'       // A-Z
  | '\u005f'                 // _
  | '\u0061'..'\u007a'       // a-z
  | '\u00c0'..'\u00d6'       // Latin Capital Letter A with grave - Latin Capital letter O with diaeresis
  | '\u00d8'..'\u00f6'       // Latin Capital letter O with stroke - Latin Small Letter O with diaeresis
  | '\u00f8'..'\u00ff'       // Latin Small Letter O with stroke - Latin Small Letter Y with diaeresis
  | '\u0100'..'\u1fff'       // Latin Capital Letter A with macron - Latin Small Letter O with stroke and acute
  | '\u3040'..'\u318f'       // Hiragana
  | '\u3300'..'\u337f'       // CJK compatibility
  | '\u3400'..'\u3d2d'       // CJK compatibility
  | '\u4e00'..'\u9fff'       // CJK compatibility
  | '\uf900'..'\ufaff'       // CJK compatibility
  ;

fragment
JavaIDDigit
  : '\u0030'..'\u0039'       // 0-9
  | '\u0660'..'\u0669'       // Arabic-Indic Digit 0-9
  | '\u06f0'..'\u06f9'       // Extended Arabic-Indic Digit 0-9
  | '\u0966'..'\u096f'       // Devanagari 0-9
  | '\u09e6'..'\u09ef'       // Bengali 0-9
  | '\u0a66'..'\u0a6f'       // Gurmukhi 0-9
  | '\u0ae6'..'\u0aef'       // Gujarati 0-9
  | '\u0b66'..'\u0b6f'       // Oriya 0-9
  | '\u0be7'..'\u0bef'       // Tami 0-9
  | '\u0c66'..'\u0c6f'       // Telugu 0-9
  | '\u0ce6'..'\u0cef'       // Kannada 0-9
  | '\u0d66'..'\u0d6f'       // Malayala 0-9
  | '\u0e50'..'\u0e59'       // Thai 0-9
  | '\u0ed0'..'\u0ed9'       // Lao 0-9
  | '\u1040'..'\u1049'       // Myanmar 0-9?
  ;

Ws
  : [ \r\t\u000C\n]+
  ;

Pad
  : '/*<' .*? '>*/'
  ;

Javadoc
  : '/**' .*? '*/'
  ;

Comment
  : '/*' .*? '*/'
  ;

LineComment
  : '//' ~[\r\n]*
  ;
