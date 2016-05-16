package pp.block3.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block2.cc.ParseException;

public class TypeEvalListenerBased extends MyCalcBaseListener {
    private ParseTreeProperty<Type> type;
    private ParseException tothrow;


    public void init() {
        this.type = new ParseTreeProperty<>();
    }

    public Type getType(String typeString) {
        CharStream stream = new ANTLRInputStream(typeString);
        Lexer lexer = new MyCalcAttrLexer(stream);
        MyCalcParser parser = new MyCalcParser(new CommonTokenStream(lexer));
        ParseTree tree = null;
        tree = parser.t();
        init();
        tothrow=null;
        new ParseTreeWalker().walk(this, tree);
        if(tothrow!=null){
            tothrow.printStackTrace();
        }
        return type.get(tree);
    }

    @Override
    public void exitEquals(MyCalcParser.EqualsContext ctx) {
        set(ctx, Type.BOOL);
    }

    @Override
    public void exitHat(MyCalcParser.HatContext ctx)  {
        if(type(ctx.getChild(0))==Type.NUM &&type(ctx.getChild(2))==Type.NUM){
            set(ctx, Type.NUM);
        }else if(type(ctx.getChild(0))==Type.STR &&type(ctx.getChild(2))==Type.NUM){
            set(ctx, Type.STR);
        }else{
            set(ctx, Type.ERR);
           tothrow = new ParseException("Operator ^ is incompatible with types: " + type(ctx.getChild(0)) + " and " + type(ctx.getChild(2)));
        }
    }

    @Override
    public void exitPlus(MyCalcParser.PlusContext ctx){
        if(type(ctx.getChild(0))==type(ctx.getChild(2))){
            set(ctx, type(ctx.getChild(0)));
        }else {
            set(ctx, Type.ERR);
            tothrow =  new ParseException("Operator + is incompatible with types: " + type(ctx.getChild(0)) + " and " + type(ctx.getChild(1)));
        }
    }

    @Override
    public void exitBrackets(MyCalcParser.BracketsContext ctx) {
        set(ctx, type(ctx.t()));
    }

    @Override
    public void exitBool(MyCalcParser.BoolContext ctx) {
        set(ctx, Type.BOOL);
    }

    @Override
    public void exitNumber(MyCalcParser.NumberContext ctx) {
        set(ctx, Type.NUM);
    }

    @Override
    public void exitString(MyCalcParser.StringContext ctx) {
        set(ctx, Type.STR);
    }

    /** Sets the val attribute of a given node. */
    private void set(ParseTree node, Type val) {
        this.type.put(node, val);
    }

    /** Retrieves the val attribute of a given node. */
    public Type type(ParseTree node) {
        return this.type.get(node);
    }
}