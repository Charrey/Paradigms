package homework.code.excercice2;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.util.List;

/**
 * Created by Hans on 19/05/2016.
 */
public class DecimalTest {



    @Test
    public void testDoubles() {
        assert (isDouble("3.1415926"));
        assert (isDouble("1d"));
        assert (isDouble("1__0d"));
        assert (isDouble("1__0.12345d"));
        assert (isDouble("1__0.1__0d"));
        assert (!isDouble("1d.1d"));
        assert (!isDouble("1d.1f"));
        assert (!isDouble("1.."));
        assert (!isDouble("1.d"));
        assert (!isDouble("1.____d"));
    }

    @Test
    public void testFloat() {
        assert (isFloat("3.1415926f"));
        assert (isFloat("1f"));
        assert (isFloat("1__0f"));
        assert (isFloat("1__0.12345f"));
        assert (isFloat("1__0.1__0f"));
        assert (!isFloat("1d.1f"));
        assert (!isFloat("1d.1f"));
        assert (!isFloat("1..f"));
        assert (!isFloat("1.____f"));
    }



    public boolean isDouble(String input) {
        List<? extends Token> tokens = new Decimal(new ANTLRInputStream(input)).getAllTokens();
        return tokens.size()==1 && tokens.get(0).getText().equals(input) && tokens.get(0).getType()==Decimal.DECIMALDOUBLE;
    }

    public boolean isFloat(String input) {
        List<? extends Token> tokens = new Decimal(new ANTLRInputStream(input)).getAllTokens();
        return tokens.size()==1 && tokens.get(0).getText().equals(input) && tokens.get(0).getType()==Decimal.DECIMALFLOAT;
    }
}



