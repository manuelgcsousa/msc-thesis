grammar DSL_Meta_Grammar;


processor : structure errors input
;


/* *********************************************************** */
/* ************************ STRUCTURE ************************ */
/* *********************************************************** */

structure : 'STRUCTURE:' (part)+
;

part : 'part' element
;

element : '(' WORD ( ',' attributes )? ( ',' subparts )? ')' ('?')?
;

attributes : 'attributes' '{' WORD ( ',' WORD )* '}'
;

subparts : 'subparts' '[' element ( ',' element ) ']'
;


/* ******************************************************** */
/* ************************ ERRORS ************************ */
/* ******************************************************** */

errors : 'ERRORS:' ( expression ';' )+
;

expression : condition ( ('AND'|'OR') condition )*
;

condition : WORD ( '.' WORD )* '->' WORD ('='|'!=') '"' WORD '"'
;


/* ******************************************************* */
/* ************************ INPUT ************************ */
/* ******************************************************* */

input : 'INPUT:' phrase
;

phrase : ( '-' parts )+
;

parts : '(' block ( ',' block )* ')'
;

block : WORD content
;

content : (slice)? (attrs)? (parts)?
;

slice : ':' '"' WORD (WORD)* '"'
;

attrs : '[' evaluations ']'
;

evaluations : eval ( ',' eval )*
;

eval : WORD '=' '"' WORD '"'
;



/* LEXER */

WORD : (CHAR)+
;

WS : ([ \t\r\n]|COMMENT) -> skip
;

fragment CHAR : [a-zA-ZáéíóúÁÉÍÓÚâêîôûÂÊÎÔÛãõÃÕàèìòùÀÈÌÒÙçÇ_] 
;

fragment COMMENT
	: '/*'.*?'*/'               // Multiple line comments
	| '//'~('\r'|'\n')*         // Single line comment
;
