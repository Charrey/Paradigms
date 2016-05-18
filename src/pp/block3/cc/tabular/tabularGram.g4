grammar tabularGram;

import tabularVocab;

table               : NEWLINE* STARTTABLE row+ ENDTABLE;
row                 : WS? entry* lastentry;
entry               : STRING? COLSEP NEWLINE*;
lastentry           : STRING? ROWSEP NEWLINE+;