package pp.block3.cc.tabular;

import javafx.beans.property.StringProperty;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.traversal.TreeWalker;

import java.io.*;

import static java.lang.Thread.sleep;

/**
 * Created by Hans on 17-5-2016.
 */
public class HTMLGenerator extends tabularGramBaseListener {

    String generatedContentString;

    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader(new File(args[0]));
        CharStream stream = new ANTLRInputStream(reader);
        Lexer lexer = new tabularGramLexer(stream);
        tabularGramParser parser = new tabularGramParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();

        MyErrorListener myErrorListener = new MyErrorListener();
        parser.addErrorListener(myErrorListener);
        ParseTree parseTree = parser.table();
        if(myErrorListener.errors.size() == 0) {
            HTMLGenerator htmlGenerator = new HTMLGenerator();
            PrintWriter out = new PrintWriter(args[0].split("\\.")[0] + ".html");
            out.println(htmlGenerator.generateHTML(parseTree));
            out.close();
        }
        else {
            myErrorListener.printErrors();
        }
    }

    public String generateHTML(ParseTree parseTree) throws IOException {
        generatedContentString = "<html>\n<body>\n";
        new ParseTreeWalker().walk(this,parseTree);
        generatedContentString += "</body>\n</html>";
        return generatedContentString;
    }

    @Override
    public void enterTable(tabularGramParser.TableContext ctx) {
        generatedContentString += "<table border=\"1\">\n";
    }

    @Override
    public void exitTable(tabularGramParser.TableContext ctx) {
        generatedContentString += "</table>\n";
    }

    @Override
    public void enterRow(tabularGramParser.RowContext ctx) {
        generatedContentString += "<tr>\n";
    }

    @Override
    public void exitRow(tabularGramParser.RowContext ctx) {
        generatedContentString += "</tr>\n";
    }

    @Override
    public void enterEntry(tabularGramParser.EntryContext ctx) {
        if(ctx.getChildCount() == 2) {
            generatedContentString += "\t<td>" + ctx.getChild(0).getText() + "</td>\n";
        } else {
            generatedContentString += "\t<td>" + "</td>\n";
        }
    }

    @Override
    public void enterLastentry(tabularGramParser.LastentryContext ctx) {
        if(ctx.getChildCount() == 3) {
            generatedContentString += "\t<td>" + ctx.getChild(0).getText() + "</td>\n";
        } else {
            generatedContentString += "\t<td>" + "</td>\n";
        }
    }
}
