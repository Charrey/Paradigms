package homework.pim.exercise4.test;

import homework.pim.exercise4.MyListener;
import org.junit.Test;

/**
 * Created by poesd_000 on 20/05/2016.
 */
public class MyListenerTest {


    @Test
    public void testHex() {
        MyListener listener = new MyListener();
        assert (listener.getvalue("x10")==16);
        assert (listener.getvalue("x100")==256);
        assert (listener.getvalue("x1000")==4096);
        assert (listener.getvalue("xAA")==170);
    }


    @Test
    public void testDec() {
        MyListener listener = new MyListener();
        assert (listener.getvalue("10")==10);
        assert (listener.getvalue("100")==100);
        assert (listener.getvalue("1000")==1000);
        assert (listener.getvalue("102")==102);
    }

    @Test
    public void testBin() {
        MyListener listener = new MyListener();
        assert (listener.getvalue("b10")==2);
        assert (listener.getvalue("b100")==4);
        assert (listener.getvalue("b1000")==8);
        assert (listener.getvalue("b1001")==9);
    }
}
