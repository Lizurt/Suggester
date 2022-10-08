lexer grammar ArangoLexerRules;
@header {
    package com.example.arangui.antlr;
}
// ################################################################
INSERT :
    I N S E R T
;
IN :
    I N
;
FOR :
    F O R
;

INTO :
    I N T O
;
RETURN :
    R E T U R N
;
// ################################################################
DOT :
    [\\.]
;
MINUS :
    [-]
;
COLON :
    [:]
;
COMMA :
    [,]
;
L_CUR_BR :
    [{]
;
R_CUR_BR :
    [}]
;
QUOTE :
    ["]
;
// ################################################################
NUM_VAL :
    MINUS? NUMS (DOT NUMS)?
;
STR_VAL :
    QUOTE ANY_CHARS QUOTE
;
NUMS :
    NUM+
;
WS :
    [ \r\n\t] -> skip
;
AL_NUM :
    CHAR | NUM
;
fragment CHAR :
    [a-zA-Z]
;
fragment NUM :
    [0-9]
;
fragment ANY_CHARS :
    .*?
;
// ################################################################
fragment A : [Aa];
fragment B : [Bb];
fragment C : [Cc];
fragment D : [Dd];
fragment E : [Ee];
fragment F : [Ff];
fragment G : [Gg];
fragment H : [Hh];
fragment I : [Ii];
fragment J : [Jj];
fragment K : [Kk];
fragment L : [Ll];
fragment M : [Mm];
fragment N : [Nn];
fragment O : [Oo];
fragment P : [Pp];
fragment Q : [Qq];
fragment R : [Rr];
fragment S : [Ss];
fragment T : [Tt];
fragment U : [Uu];
fragment V : [Vv];
fragment W : [Ww];
fragment X : [Xx];
fragment Y : [Yy];
fragment Z : [Zz];
