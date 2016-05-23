grammar Ex3Grammar;

e   : e PLUS f
    | f;

f   :  MINUS MINUS f
    | MINUS f
    | t;

t   : t PLUS PLUS
    | ID;

MINUS : '-';
PLUS : '+';
ID: [a-z]+;
