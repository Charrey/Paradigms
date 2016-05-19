package homework.pim.exercise2.test;

import homework.pim.exercise2.JavaDecimal;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

/**
 * Created by poesd_000 on 18/05/2016.
 */
public class JavaDecTest {



    @Test
    public void testDouble() {
        assert (acceptsDouble("1.1"));
        assert (acceptsDouble("1d"));
        assert (!acceptsDouble("1d.0d"));
        assert (!acceptsDouble("1.."));

    }

    @Test
    public void testFloat() {
        assert (acceptsFloat("0.0f"));
        assert (acceptsFloat("1__3.23F"));
        assert (!acceptsFloat("1__f"));
    }



    public boolean acceptsDouble(String input) {
        List<? extends Token> tokens = new JavaDecimal(new ANTLRInputStream(input)).getAllTokens();
        return tokens.size()==1 && tokens.get(0).getText().equals(input) && tokens.get(0).getType()==JavaDecimal.DECIMALDOUBLE; //2
    }

    public boolean acceptsFloat(String input) {
        List<? extends Token> tokens = new JavaDecimal(new ANTLRInputStream(input)).getAllTokens();
        return tokens.size()==1 && tokens.get(0).getText().equals(input) && tokens.get(0).getType()==JavaDecimal.DECIMALFLOAT; //1
    }
}



