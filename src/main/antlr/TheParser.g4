parser grammar TheParser;

@header {
    package the.grammar;
}
options {
    tokenVocab = TheLexer;
}

hello_world : (HELLO | WORK) who;

who : (world | lizurt)*;

world : WORLD;

lizurt : LIZURT;
