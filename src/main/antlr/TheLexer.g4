lexer grammar TheLexer;

@header {
    package the.grammar;
}

HELLO : H E L L O;

WORLD : W O R L D;

STRANGER : S T R A N G E R;

AND : A N D;

MY_NAME_IS : M Y CH_UNDERSCORE N A M E CH_UNDERSCORE I S;

ITS : I T S;

VERY : V E R Y;

COOL : C O O L;

IDENTIFIER : IDENTIFIER_START IDENTIFIER_PART*;

IDENTIFIER_START : [A-Z];

IDENTIFIER_PART : IDENTIFIER_START | [a-z];

WS : [ \t\r\n] -> skip;

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
fragment CH_UNDERSCORE : '_';
