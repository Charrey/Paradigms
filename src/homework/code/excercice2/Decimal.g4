lexer grammar Decimal;

DECIMALFLOAT: DECIMALINT '.' DECIMALANYTHING FSUFFIX
            | DECIMALINT ('e'|'E') DECIMALINT FSUFFIX
            | DECIMALINT FSUFFIX;

DECIMALDOUBLE : DECIMALINT '.' DECIMALANYTHING DSUFFIX?
              | DECIMALINT ('e'|'E') DECIMALINT DSUFFIX?
              | DECIMALINT DSUFFIX;

fragment DECIMALANYTHING : [0-9] ('_'* [0-9])*;
fragment DECIMALINT : '0' | [1-9] ('_'* [0-9])*;
fragment FSUFFIX : ('f'|'F');
fragment DSUFFIX: ('d'|'D');

