grammar Exercise3G0;

e : e PLUS f
  | f;
f : MINUS f
  | MINUS MINUS f
  | t;
t : t PLUS PLUS
  | ID;


ID : [a-zA-Z] [a-zA-Z0-9]*;
PLUST : '+';
