package homework.pim.exercise3.test;

import homework.pim.exercise3.Exercise3G0Lexer;
import homework.pim.exercise3.Exercise3G0Parser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by poesd_000 on 19/05/2016.
 */
public class Exercise3G0Test {

    boolean accepts = true;

    @Test
    public void testSuccess() {
        assert (accepts("--a"));
    }


    public boolean accepts(String input) {
        accepts = true;
        Exercise3G0Lexer lexer = new Exercise3G0Lexer(new ANTLRInputStream(input));
        Exercise3G0Parser parser = new Exercise3G0Parser(new CommonTokenStream(lexer));

        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                e.printStackTrace();
                accepts = false;
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                System.out.println(3);
                accepts = false;
            }
        });
        ParseTree tree = parser.e();
        System.out.println(tree.toStringTree(parser));
        return accepts;
    }

}
