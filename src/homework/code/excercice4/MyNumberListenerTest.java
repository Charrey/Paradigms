package homework.code.excercice4;

import homework.pim.exercise4.MyListener;
import org.junit.Test;

/**
 * Created by Hans on 20/05/2016.
 */
public class MyNumberListenerTest {

    @Test
    public void testDec() {
        MyNumberListener listener = new MyNumberListener();
        assert (listener.getValue("0")==0);
        assert (listener.getValue("1")==1);
        assert (listener.getValue("10")==10);
        assert (listener.getValue("42")==42);
        assert (listener.getValue("100")==100);
        assert (listener.getValue("1000")==1000);
    }

    @Test
    public void testHex() {
        MyNumberListener listener = new MyNumberListener();
        assert (listener.getValue("x0")==0);
        assert (listener.getValue("x1")==1);
        assert (listener.getValue("xF")==15);
        assert (listener.getValue("x10")==16);
        assert (listener.getValue("x100")==256);
        assert (listener.getValue("x1000")==4096);
        assert (listener.getValue("x1CEB00DA")==485163226);

    }

    @Test
    public void testBin() {
        MyNumberListener listener = new MyNumberListener();
        assert (listener.getValue("b0")==0);
        assert (listener.getValue("b1")==1);
        assert (listener.getValue("b10")==2);
        assert (listener.getValue("b100")==4);
        assert (listener.getValue("b1000")==8);
        assert (listener.getValue("b11111111111")==2047);
        assert (listener.getValue("b11111111111")==2047);
        assert (listener.getValue("b011111111111")==2047);
    }

}
