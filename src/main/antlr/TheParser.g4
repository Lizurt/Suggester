parser grammar TheParser;

@header {
    package the.grammar;
}
options {
    tokenVocab = TheLexer;
}

hello_world : HELLO who;

who : (world | lizurt)*;

world : WORLD;

lizurt : LIZURT;
