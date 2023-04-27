parser grammar TheParser;

@header {
    package the.grammar;
}
options {
    tokenVocab = TheLexer;
}

hello_world : HELLO (who (AND who)*)? MY_NAME_IS IDENTIFIER AND ITS VERY+ COOL;

who : WORLD | STRANGER;
