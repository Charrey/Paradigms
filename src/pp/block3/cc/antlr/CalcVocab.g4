lexer grammar CalcVocab;

@header{package pp.block3.cc.antlr;}

HAT  : '^';
TIMES : '*';
PLUS   : '+';
EQUALS : '==';
MINUS  : '-';
LPAR   : '(';
RPAR   : ')';

NUMBER : [0-9]+;
BOOL: 'True'|'False';
STRING: '"'.*?'"';

// ignore whitespace
WS : [ \t\n\r] -> skip;
