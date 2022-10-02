parser grammar ArangoParserRules;
options {
    tokenVocab = ArangoLexerRules;
}
@header {
    package com.example.arangui.antlr;
}
// ################################################################
query :
    insertSt
    | forSt
;
// ################################################################
insertSt :
    INSERT L_CUR_BR keysAndVals R_CUR_BR into
;
forSt :
    FOR identifier IN identifier forStatements
;
// ################################################################
into :
    INTO identifier
;
forStatements :
    returnSt
;
keysAndVals :
    keyAndVal (COMMA keyAndVal)*
;
keyAndVal :
    identifier COLON value
;
value :
    STR_VAL | NUM_VAL
;
identifier :
    AL_NUM+
;
returnSt :
    RETURN identifier (DOT identifier)?
;
