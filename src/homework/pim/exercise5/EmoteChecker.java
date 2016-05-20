package homework.pim.exercise5;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by poesd_000 on 20/05/2016.
 */
public class EmoteChecker extends EmoteBaseListener {


    EmoteSymbolTable table = new EmoteSymbolTable();
    private ArrayList<String> errorlist;
    private boolean unexpectedEOF;
    EmoteParser parser;

    /**
     * Returns a list of all errors in the given input.
     * @param string Input corresponding to a correct- or incorrect word in the grammar "Emote"
     * @return The list of errors
     */
    public List<String> getErrorList(String string) {
        this.errorlist = new ArrayList<>();
        unexpectedEOF = false;
        CharStream stream = new ANTLRInputStream(string);
        Lexer lexer = new EmoteLexer(stream);
        parser = new EmoteParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        ParseTree tree =  parser.text();
        new ParseTreeWalker().walk(this, tree);
        table = new EmoteSymbolTable();
        return errorlist;
    }


    @Override
    public void enterTextItem(EmoteParser.TextItemContext ctx) {
        table.openScope();
    }


    @Override
    public void exitTextItem(EmoteParser.TextItemContext ctx) {
        table.closeScope();
    }



    @Override
    public void enterRaiseItem(EmoteParser.RaiseItemContext ctx) {
        table.raiseIntensity(ctx.getChild(1).getText());
    }


    @Override
    public void enterWordItem(EmoteParser.WordItemContext ctx) {
        int foundintensity = table.getIntensity(ctx.getChild(0).getText());
        if (foundintensity==-1 && ctx.getChildCount()==1) {
            table.add(ctx.getText(), 0);
            return;
        } else if (foundintensity==-1) {
            String errormessage = "Incorrect intensity found at "+((TerminalNode) ctx.getChild(0)).getSymbol().getLine()+":"+((TerminalNode) ctx.getChild(0)).getSymbol().getCharPositionInLine()+" \"" +ctx.getChild(0) +"\"; Expected: 0; Found: " + ctx.getChild(1).toString().length();
            errorlist.add(errormessage);
            return;
        }
        if (ctx.getChildCount()!=2) {
            String errormessage = "Incorrect intensity found at "+((TerminalNode) ctx.getChild(0)).getSymbol().getLine()+":"+((TerminalNode) ctx.getChild(0)).getSymbol().getCharPositionInLine()+" \""+ctx.getChild(0)+"\"; Expected: "+foundintensity+"; Found: 0";
            errorlist.add(errormessage);
            return;
        }
        if (foundintensity!=ctx.getChild(1).toString().length()) {
            String errormessage = "Incorrect intensity found at "+((TerminalNode) ctx.getChild(0)).getSymbol().getLine()+":"+((TerminalNode) ctx.getChild(0)).getSymbol().getCharPositionInLine()+" \""+ctx.getChild(0)+"\"; Expected: "+foundintensity+"; Found: "+ctx.getChild(1).toString().length();
            errorlist.add(errormessage);
        }
    }


    public void visitErrorNode(ErrorNode node) {
        String errormessage;
        if (!unexpectedEOF && node.getText().equals("<EOF>")){
            errormessage = "Unexpected end of file at "+ node.getSymbol().getLine() + ":" + node.getSymbol().getCharPositionInLine();
            errorlist.add(errormessage);
            unexpectedEOF = true;
        } else if (!node.getText().startsWith("<")){
            errormessage = "Unexpected character '" + node.toString().charAt(0) + "' at "+ node.getSymbol().getLine() + ":" + node.getSymbol().getCharPositionInLine();
            errorlist.add(errormessage);
        } else if (node.getText().startsWith("<missing")){
            errormessage = "Missing character: " + node.getText().substring(9,12) + " at " + node.getSymbol().getLine() + ":" + node.getSymbol().getCharPositionInLine();
            errorlist.add(errormessage);
        } else {
            System.err.println("UNKNOWN ERROR: "+node+node.getText());
        }
    }
}
