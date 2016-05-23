package homework.code.excercice5;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hans on 20-5-2016.
 */
public class EmoteChecker extends EmoteBaseListener {

    EmoteSymbolTable emoteSymbolTable = new EmoteSymbolTable();
    List<String> errorlist;

    //TODO: Alle supers weghalen

    public List<String> check(ParseTree parseTree) throws IOException {
        errorlist = new ArrayList<>();
        new ParseTreeWalker().walk(this,parseTree);
        return errorlist;
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void enterWordItem(EmoteParser.WordItemContext ctx) {
        super.enterWordItem(ctx);
        if(emoteSymbolTable.contains(ctx.getChild(0).getText())) {
            int intensity = emoteSymbolTable.getInsensity(ctx.getChild(0).getText());
            if (ctx.getChildCount() == 2) {
                //If the actual intensity is different from the intensity the word indicates.
                if (!(intensity == ctx.getChild(1).getText().length())) {
                    String message = "Word: "+ ctx.getChild(0).getText() + " at " + ctx.getStart().getLine() + ctx.getStart().getCharPositionInLine() +" has the wrong intensity" + " Expected: " + intensity + " Actual: " + ctx.getChild(1).getText().length();
                    errorlist.add(message);
                    }
            } else {
                //If the word hasn't got any intensity and it shouldn't have
                if (intensity == 0) {
                    emoteSymbolTable.add(ctx.getChild(0).getText());
                }
                //If the word hasn't got any intensity and it should have
                else {
                    String message = "Word: "+ ctx.getChild(0).getText() + " at " + ctx.getStart().getLine() + ctx.getStart().getCharPositionInLine() +" has the wrong intensity" + " Expected: " + intensity + " Actual: 0";
                    errorlist.add(message);
                }
            }

        } else {
            //If the word wasn't declared before and has an intensity.
            if(ctx.getChildCount() == 2) {
                String message = "Word: "+ ctx.getChild(0).getText() + " at " + ctx.getStart().getLine() + ctx.getStart().getCharPositionInLine() +" has the wrong intensity" + " Expected: 0" + " Actual: " + ctx.getChild(1).getText().length();
                errorlist.add(message);
            }
            //If the word wasn't declared before and doesn't have an intensity.
            else {
                emoteSymbolTable.add(ctx.getChild(0).getText());
            }
        }
    }

    @Override
    public void enterTextItem(EmoteParser.TextItemContext ctx) {
        super.enterTextItem(ctx);
        emoteSymbolTable.openScope();
    }

    @Override
    public void exitTextItem(EmoteParser.TextItemContext ctx) {
        super.exitTextItem(ctx);
        emoteSymbolTable.closeScope();
    }

    @Override
    public void exitRaiseItem(EmoteParser.RaiseItemContext ctx) {
        super.exitRaiseItem(ctx);
    }

    @Override
    public void enterRaiseItem(EmoteParser.RaiseItemContext ctx) {
        super.enterRaiseItem(ctx);
        if(emoteSymbolTable.contains(ctx.getChild(1).getText())){
            emoteSymbolTable.incrementIntensity(ctx.getChild(1).getText());
        } else {
            emoteSymbolTable.add(ctx.getChild(1).getText());
            emoteSymbolTable.incrementIntensity(ctx.getChild(1).getText());
        }
    }
}
