grammar MyCalcAttr;

import CalcVocab;

@members{
    private void error(Type t1, Type t2, String operator){
        throw new ParseException("Operator " + operator + " is incompatible with types: " + t1.toString() + " and " + t2.toString() );
    }
}

t returns [Type type]
    :t0=t HAT t1=t
    {
        if($t0.type==Type.NUM&&$t1.type==Type.NUM){
            $type = Type.NUM;
        }
        else if($t0.type==Type.STR&&$t1.type==Type.NUM){
            $type = Type.STR;
        }else{
            error($t0.type, $t1.type, "^" );
            $type = Type.ERR;
        }
    }
    |t0=t PLUS t1=t
    {
        if($t0.type== Type.STR || $t1.type == Type.STR){
            $type = Type.STR;
        }
        else if($t0.type==$t1.type){
            $type = $t0.type;
        }else{
            error($t0.type, $t1.type, "+" );
            $type = Type.ERR;
        }
    }
    |t0=t EQUALS t1=t
    { $type = Type.BOOL;}
    |LPAR t0=t RPAR
    { $type = $t0.type;}
    |BOOL
    { $type = Type.BOOL;}
    |STRING
    { $type = Type.STR;}
    |NUMBER
    { $type = Type.NUM;}
    ;