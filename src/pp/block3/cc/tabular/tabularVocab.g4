lexer grammar tabularVocab;


STARTTABLE          : BEGIN ARGUMENT NEWLINE;
ENDTABLE            : END NEWLINE+;
ARGUMENT            : '{' ('l'|'r'|'c')+ '}';

BEGIN               : '\\begin{tabular}';
END                 : '\\end{tabular}';



ROWSEP              : WS? '\\\\' WS?;
COLSEP              : WS? '&' WS?;
fragment LETTER     : [a-zA-Z];
fragment NUMBER     : [0-9]+;
fragment CHAR       : LETTER|NUMBER;
STRING              : CHAR+;
WS                  : ' '+;
NEWLINE             : '\r'? '\n' ;

COMMENT : '%' ~('\\')*? NEWLINE -> skip;

//|CHAR (WS|CHAR)+? CHAR