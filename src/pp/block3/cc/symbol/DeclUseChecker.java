package pp.block3.cc.symbol;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block3.cc.antlr.MyCalcAttrLexer;
import pp.block3.cc.antlr.MyCalcAttrParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hans on 16-5-2016.
 */
public class DeclUseChecker extends DeclUseBaseListener{

    List<String> errorlist;
    private boolean unexpectedEOF;

    public List<String> getErrorList(File file) {
        this.errorlist = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            unexpectedEOF = false;
            CharStream stream = new ANTLRInputStream(fr);
            Lexer lexer = new DeclUseLexer(stream);
            DeclUseParser parser = new DeclUseParser(new CommonTokenStream(lexer));
            ParseTree tree =  parser.program();
            new ParseTreeWalker().walk(this, tree);
            return errorlist;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    SymbolTable<Object> mysymbols= new MySymbolTable<>();

    public DeclUseChecker() {
        unexpectedEOF = false;
    }



    @Override
    public void enterProgram(DeclUseParser.ProgramContext ctx) {
        mysymbols.openScope();
    }

    @Override
    public void exitProgram(DeclUseParser.ProgramContext ctx) {
        mysymbols.closeScope();
        //NOTE: We cannot detect tokens after the program has finished.
    }


    @Override
    public void enterUnitseries(DeclUseParser.UnitseriesContext ctx) {
        mysymbols.openScope();
    }

    @Override
    public void exitUnitseries(DeclUseParser.UnitseriesContext ctx) {
        mysymbols.closeScope();
    }

    @Override
    public void enterDecl(DeclUseParser.DeclContext ctx) {
        if (!mysymbols.add(ctx.ID().getText(), null)) {
            String errormessage= "Found dulicate declaration of \"" + ctx.ID().getText() +"\" in the same scope at " + ctx.getStart().getLine()+":"+ctx.getStart().getCharPositionInLine();
            errorlist.add(errormessage);
        }
    }

    @Override
    public void enterUse(DeclUseParser.UseContext ctx) {
        if (!mysymbols.contains(ctx.ID().getText())){
            String errormessage = "Usage of undeclared variable \"" + ctx.ID() + "\" at " + ctx.getStart().getLine() + ctx.getStart().getCharPositionInLine();
            errorlist.add(errormessage);
        }
    }

    @Override
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
            System.out.println(node.getText());
        }
    }
}
