lexer grammar ArangoLexerRules;
@header {
    package com.example.arangui.antlr;
}
// https://www.arangodb.com/docs/stable/aql/fundamentals-syntax.html
// KEYWORDS ################################################################
AGGREGATE :
    A G G R E G A T E
;
ALL :
    A L L
;
AND :
    A N D
;
ANY :
    A N Y
;
ASC :
    A S C
;
COLLECT :
    C O L L E C T
;
DESC :
    D E S C
;
DISTINCT :
    D I S T I N C T
;
FALSE :
    F A L S E
;
FOR :
    F O R
;
GRAPH :
    G R A P H
;
IN :
    I N
;
INBOUND :
    I N B O U N D
;
INSERT :
    I N S E R T
;
INTO :
    I N T O
;
K_PATHS :
    K CHAR_UNDERSCORE P A T H S
;
K_SHORTEST_PATHS :
    K CHAR_UNDERSCORE S H O R T E S T CHAR_UNDERSCORE P A T H S
;
LET :
    L E T
;
LIMIT :
    L I M I T
;
NONE :
    N O N E
;
NOT :
    N O T
;
NULL :
    N U L L
;
OR :
    O R
;
OUTBOUND :
    O U T B O U N D
;
REMOVE :
    R E M O V E
;
REPLACE :
    R E P L A C E
;
RETURN :
    R E T U R N
;
SHORTEST_PATH :
    S H O R T E S T CHAR_UNDERSCORE P A T H
;
SORT :
    S O R T
;
TRUE :
    T R U E
;
UPDATE :
    U P D A T E
;
UPSERT :
    U P S E R T
;
WITH :
    W I T H
;
WINDOW :
    W I N D O W
;
// Other chars ################################################################
CHAR_BACKTICK :
    [`]
;
CHAR_TILDA :
    [~]
;
CHAR_EXCL_MARK :
    [!]
;
CHAR_AT_SIGN :
    [@]
;
CHAR_NUMBER_SIGN :
    [#]
;
CHAR_DOLLAR :
    [$]
;
CHAR_PERCENT :
    [%]
;
CHAR_CIRCUMFLEX :
    [^]
;
CHAR_AMPERSAND :
    [&]
;
CHAR_ASTERISK :
    [*]
;
CHAR_L_ROUND_BR :
    [(]
;
CHAR_R_ROUND_BR :
    [)]
;
// the more i google these words the worse it gets for me
CHAR_MINUS :
    [-]
;
CHAR_UNDERSCORE :
    [_]
;
CHAR_EQUALS :
    [=]
;
CHAR_PLUS :
    [+]
;
CHAR_L_BR :
    [[]
;
CHAR_L_CUR_BR :
    [{]
;
CHAR_R_BR :
    [\]]
;
CHAR_R_CUR_BR :
    [}]
;
CHAR_SEMICON :
    [;]
;
CHAR_COLON :
    [:]
;
CHAR_APOSTROPHE :
    [']
;
CHAR_QUOTE :
    ["]
;
CHAR_BACKSLASH :
    [\\]
;
CHAR_VERT_LINE :
    [|]
;
CHAR_COMMA :
    [,]
;
CHAR_L_TRIANG_BR :
    [<]
;
CHAR_DOT :
    [.]
;
CHAR_R_TRIANG_BR :
    [>]
;
CHAR_SLASH :
    [/]
;
CHAR_QUESTION_MARK :
    [?]
;
// Misc ################################################################
VAL_UINT :
    VAL_DIGIT+
;
VAL_INT :
    CHAR_MINUS? VAL_UINT
;
VAL_FLOAT :
    VAL_INT (CHAR_DOT VAL_UINT)?
;
VAL_STRING :
    CHAR_QUOTE VAL_ANY_CHAR CHAR_QUOTE
;
VAL_IDENTIFIER :
    VAL_CHAR (VAL_CHAR | VAL_DIGIT)*
;
fragment VAL_CHAR :
    [a-zA-Z]
;
fragment VAL_DIGIT :
    [0-9]
;
fragment VAL_ANY_CHAR :
    .*?
;
IGNORED_COMMENT :
    (CHAR_SLASH CHAR_SLASH VAL_ANY_CHAR IGNORED_NL) -> skip
;
IGNORED_MULTILINE_COMMENT :
    (CHAR_SLASH CHAR_ASTERISK VAL_ANY_CHAR CHAR_ASTERISK CHAR_SLASH) -> skip
;
IGNORED_NL :
    (([\n]) | ([\r]? [\n]) | ([\n] [\r]?)) -> skip
;
IGNORED_TAB :
    [\t] -> skip
;
IGNORED_SPACE :
    [ ] -> skip
;
IGNORED_WS :
    (IGNORED_NL | IGNORED_TAB | IGNORED_SPACE)+ -> skip
;
// Letters ################################################################
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
