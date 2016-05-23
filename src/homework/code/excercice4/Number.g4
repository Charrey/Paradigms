grammar Number;

@header{ package pp.homework.q1_4; }

/** Number: sequence of digits optionally preceded by a base prefix */
num returns [int val]
    : p=prf s=seq[$p.type] {
        $val = $s.val;
    }
    | s=seq[10] {
        $val = $s.val;
    };

/** Sequence of digits */
seq [int type] returns [int val, int length]
    : d=dig {
        $length = 1;
        $val = $d.val;
    }
    | d=dig s=seq[type] {
        $length = $s.length + 1;
        $val = ($d.val * (int) Math.pow(type, $s.length)) + $s.val;
    };


/** Prefix: x stands for hexadecimal, b for binary */
prf returns [int type]
    : 'x' {
        $type = 16;
    }
    | 'b' {
        $type = 2;
    };

/** Single digit (hexadecimal range) */
dig returns [int val] :
    DIGIT {
        char c = $DIGIT.getText().charAt(0);
        $val= c - (c < 'A' ? '0' : ('A'-10));
    };

/** Digit token */
DIGIT: [0-9A-F] ;
