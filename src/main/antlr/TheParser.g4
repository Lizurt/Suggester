parser grammar TheParser;

@header {
    package the.grammar;
}
options {
    tokenVocab = TheLexer;
}

hello_world : HELLO who*;

who : WORLD;
