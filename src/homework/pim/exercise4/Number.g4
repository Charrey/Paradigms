grammar Number;

@header{ package pp.homework.q1_4; }

/** Number: sequence of digits optionally preceded by a base prefix */
num returns [int val]
    : a1=prf a2=seq[$a1.base] {
        $val = $a2.val;
    }
    | a3=seq[10] {
        $val = $a3.val;
    };
/** Sequence of digits */
seq [int base] returns [int val, int length]
    : a1=dig {
        $length = 1;
        $val = $a1.val;
    }
    | a2=dig a3=seq[base] {
        $length = $a3.length + 1;
        $val = ($a2.val * (int) Math.pow(base, $a3.length)) + $a3.val;
    };
/** Prefix: x stands for hexadecimal, b for binary */
prf returns [int base]
    : 'x' {
        $base = 16;
    }
    | 'b' {
        $base = 2;
    };
/** Single digit (hexadecimal range) */
dig returns [int val] :
    DIGIT {
        char c = $DIGIT.getText().charAt(0);
        $val= c - (c < 'A' ? '0' : ('A'-10));
    };

/** Digit token */
DIGIT: [0-9A-F] ;
