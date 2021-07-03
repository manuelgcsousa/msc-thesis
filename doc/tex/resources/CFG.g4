grammar MetaGrammar;

processor : structure errors input
;


/* ************************************************************ */
/* ************************* STRUCTURE ************************ */
/* ************************************************************ */

structure : 'STRUCTURE:' ( part )+
;

part : 'part' '[' element ']'
;

element : '(' WORD ( '|' WORD )* ( ',' attributes )? ( ',' subparts )? ')' ( '?' )?
;

attributes : 'attributes' '{' WORD ( ',' a2=WORD )* '}'
;

subparts : 'subparts' '[' element ( ',' element )* ']'
;

/* ************************************************************ */
/* ************************** ERRORS ************************** */
/* ************************************************************ */

errors : ( ('RULES'|'ERRORS') ':' ( condition ';' )+ )?
;

condition : assignment ( ('AND'|'OR') assignment )*
;

assignment 
    : expression ('='|'!=') expression 
    | expression ('='|'!=') '"' val=WORD '"'
;

expression : WORD ( '.' WORD )* '->' WORD 
;


/* ************************************************************ */
/* ************************** INPUT *************************** */
/* ************************************************************ */

input : 'INPUT:' phrase
;

phrase : ( '-' parts )+
;

parts : '(' block ( ',' block )* ')' 
;

block : WORD content
;

content : ( slice )? ( attrs )? ( parts )?
;

slice : ':' '"' WORD ( WORD )* '"'
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

fragment CHAR : [a-zA-ZáéíóúÁÉÍÓÚâêîôûÂÊÎÔÛãõÃÕàèìòùÀÈÌÒÙçÇ_1234567890] 
;

fragment COMMENT
	: '/*'.*?'*/'               /* Multiple line comments. */
	| '//'~('\r'|'\n')*         /* Single line comment.    */
;