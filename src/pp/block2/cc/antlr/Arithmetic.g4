grammar Arithmetic;

//Alleen bij de laatste hoeft maar '(' ')', want alles kan naar een power gaan.
//We hadden verschillende soorten tokens kunnen doen, zoals firstorder, second order, etc. We kunnen dit ook niet doen....

//expression : product | expression '+' expression | expression '-' expression ;
//product: power | product '*' product;
//power : NUMBER | NUMBER '^' power | '('expression')';

expression: expression '+' term | expression '-' term | term;
term: term '*' power | term '/' power | power;
power: factor| factor '^' power;
factor: NUMBER | '-' factor | '('expression')';

NUMBER: [1..9]+[0..9]* | '0';

//VARIABLE : [a-zA-Z];

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
//TYPO : [a-zA-Z]+;
