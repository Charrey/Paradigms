package homework.pim.exercise5.test;

import homework.pim.exercise5.EmoteChecker;
import org.junit.Test;

import java.util.List;

/**
 * Created by poesd_000 on 20/05/2016.
 */
public class EmoteCheckerTest {

    @Test
    public void testChecker() {
        EmoteChecker checker = new EmoteChecker();
        assert checker.getErrorList("^geek (^geek geek!!) geek!").size()==0;
        assert checker.getErrorList("^geek (^geek geek!!) geek!!").size()!=0;
        assert checker.getErrorList("^geek (^geek geek!) geek!").size()!=0;
        assert checker.getErrorList("^geek (^geek geek!!) (^geek geek!!) geek!").size()==0;
        assert checker.getErrorList("a bunch of ordinary words!").size()!=0;
        assert checker.getErrorList("(((").size()!=0;
        assert checker.getErrorList("( geek ^geek ^prick geek! ( ^prick prick!? ) ( ^slag ^geek slag? (^slag slag!?) geek!! (slag!) ) prick! ) prick").size()==0;
    }
}
