package homework.code.excercice3;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hans on 18/05/2016.
 */
public class Ex3GrammarTest {

    @Test
    public void testOne() {
        Ex3GrammarLexer cthingsLexer = new Ex3GrammarLexer(new ANTLRInputStream("--c"));
        Ex3GrammarParser parser = new Ex3GrammarParser(new CommonTokenStream(cthingsLexer));
        ParseTree tree = parser.e();
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void testTwo() {
        Ex3GrammarLexer cthingsLexer = new Ex3GrammarLexer(new ANTLRInputStream("c++"));
        Ex3GrammarParser parser = new Ex3GrammarParser(new CommonTokenStream(cthingsLexer));
        ParseTree tree = parser.e();
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void testTree() {
        Ex3GrammarLexer cthingsLexer = new Ex3GrammarLexer(new ANTLRInputStream("--c++"));
        Ex3GrammarParser parser = new Ex3GrammarParser(new CommonTokenStream(cthingsLexer));
        ParseTree tree = parser.e();
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void testFour() {
        Ex3GrammarLexer cthingsLexer = new Ex3GrammarLexer(new ANTLRInputStream("--c++++++"));
        Ex3GrammarParser parser = new Ex3GrammarParser(new CommonTokenStream(cthingsLexer));
        ParseTree tree = parser.e();
        System.out.println(tree.toStringTree(parser));
    }
}



