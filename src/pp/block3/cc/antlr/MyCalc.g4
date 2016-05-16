grammar MyCalc;

import CalcVocab;

t returns [Type type]
    :t HAT t      # hat
    |t PLUS t     # plus
    |t EQUALS t   # equals
    |LPAR t RPAR     # brackets
    |BOOL               # bool
    |STRING             # string
    |NUMBER             # number
    ;