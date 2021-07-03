grammar Grammar;

@members {
    final String Sujeito__TIPO = "animado";
    final String Predicado__Verbo__TIPO = "animado";
}


main : sujeito predicado
{
    if ( Sujeito__TIPO.equals("animado") &&
         Predicado__Verbo__TIPO.equals("inanimado") ) 
       { System.out.println("ERROR!"); }

    if ( Sujeito__TIPO.equals("inanimado") &&
         Predicado__Verbo__TIPO.equals("animado") ) 
       { System.out.println("ERROR!"); }
}
;

sujeito : (determinante)? nome
;

determinante : 'O' | 'a'
;

nome : 'Carlos' | 'sinceridade'
;

predicado : verbo complemento_direto
;

complemento_direto : (determinante)? nome
;

verbo : 'teme'
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