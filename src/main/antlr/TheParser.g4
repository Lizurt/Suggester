parser grammar TheParser;

@header {
    package the.grammar;
}
options {
    tokenVocab = TheLexer;
}

hello_world : HELLO who;

who : (world | WORK | lizurt) | hello_world;

world : WORLD;

lizurt : LIZURT;
