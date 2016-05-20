package homework.pim.exercise4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block2.cc.ParseException;
import pp.block3.cc.antlr.MyCalcAttrLexer;
import pp.block3.cc.antlr.MyCalcAttrParser;
import pp.block3.cc.antlr.Type;

/**
 * Created by poesd_000 on 20/05/2016.
 */
public class MyListener extends NumberBaseListener {

    private ParseTreeProperty<Integer> val;

    private void setval(ParseTree node, int val) {
        this.val.put(node, val);
    }

    public int getvalue(String string) {
        CharStream stream = new ANTLRInputStream(string);
        Lexer lexer = new NumberLexer(stream);
        NumberParser parser = new NumberParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.num();
        val = new ParseTreeProperty<>();
        new ParseTreeWalker().walk(this, tree);
        return val.get(tree);
    }


    @Override
    public void exitNum(NumberParser.NumContext ctx) {
        setval(ctx, ctx.val);
    }

}
