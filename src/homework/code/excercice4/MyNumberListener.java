package homework.code.excercice4;

import homework.pim.exercise4.NumberBaseListener;
import homework.pim.exercise4.NumberLexer;
import homework.pim.exercise4.NumberParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by Hans on 20/05/2016.
 */
public class MyNumberListener extends NumberBaseListener {

    private ParseTreeProperty<Integer> type;
    private ParseTreeProperty<Integer> val;

    public void init() {
        //this.type = new ParseTreeProperty<>();
        this.val = new ParseTreeProperty<>();
    }

    private void setVal(ParseTree node, int val) {
        this.val.put(node, val);
    }

    public int getValue(String string) {
        CharStream charStream = new ANTLRInputStream(string);
        Lexer lexer = new NumberLexer(charStream);
        NumberParser parser = new NumberParser(new CommonTokenStream(lexer));
        ParseTree tree;
        tree = parser.num();
        init();
        new ParseTreeWalker().walk(this, tree);
        return val.get(tree);
    }


    @Override
    public void exitNum(NumberParser.NumContext ctx) {
        setVal(ctx, ctx.val);
    }

}
