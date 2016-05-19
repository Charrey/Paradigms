lexer grammar decimal;

@header{package pp.block3.cc.antlr;}

DECIMALFLOAT: DECIMALINT? '.' DECIMALINT

fragment DECIMALINT: [0] | [1-9] ('_'*[0-9])*;
fragment DECIMALTAIL: [0-9] ('_'*[0-9])*;
