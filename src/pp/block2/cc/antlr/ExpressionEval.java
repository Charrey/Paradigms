package pp.block2.cc.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Term;

import java.math.BigInteger;
import java.util.Stack;

/**
 * Created by poesd_000 on 08/05/2016.
 */
public class ExpressionEval extends ArithmeticBaseListener {

    public static final String toEval= "2^2";
    private boolean parseexception;
    private AST sentenceAST;
    private Stack<AST> myStack = new Stack<>();

    public static void main(String[] args) {
        CharStream stream = new ANTLRInputStream(toEval);
        Lexer lexer = new ArithmeticLexer(stream);



        ExpressionEval eeval = new ExpressionEval();
        try {
            AST myAST = eeval.toAST(lexer);
            System.out.println(Eval(myAST));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    public static BigInteger Eval (AST input) {
        switch (input.getSymbol().getName()){
            case "Expression":
                if (input.getChildren().size()==1) {
                    return Eval(input.getChildren().get(0));
                } else {
                    assert (input.getChildren().size()==3);
                    if (input.getChildren().get(1).getToken().getText().equals("+")) {
                        return Eval(input.getChildren().get(0)).add(Eval(input.getChildren().get(2)));
                    } else {
                        System.out.println(input.getChildren().get(1).getSymbol().getName());
                        return Eval(input.getChildren().get(0)).subtract(Eval(input.getChildren().get(2)));
                    }
                }
            case "Factor":
                switch (input.getChildren().size()) {
                    case 1:
                        return new BigInteger(input.getChildren().get(0).getText());
                    case 2:
                        return BigInteger.ZERO.subtract(Eval(input.getChildren().get(1)));
                    case 3:
                        return Eval(input.getChildren().get(1));
                    default:
                        System.err.println("OH NEE!");
                        return null;
                }
            case "Power":
                if (input.getChildren().size()==1) {
                    return Eval(input.getChildren().get(0));
                } else {
                    return Eval(input.getChildren().get(0)).modPow(Eval(input.getChildren().get(2)), new BigInteger(zeroes(300)));
                    //is modulo 1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
                }
            case "Term":
                if (input.getChildren().size()==1) {
                    return Eval(input.getChildren().get(0));
                } else {
                    if (input.getChildren().get(1).getToken().getText().equals("*")) {
                        return Eval(input.getChildren().get(2)).multiply(Eval(input.getChildren().get(0)));
                    } else {
                        return Eval(input.getChildren().get(2)).divide(Eval(input.getChildren().get(0)));
                    }
                }
            default:
                System.err.println("UNKNOWN: "+input.getSymbol().getName());
                return null;
        }
    }

    public static String zeroes(int number) {
        String res = "1";
        for (int i = 0; i<number; i++) {
            res += number;
        }
        return res;
    }


    public AST toAST(Lexer lexer) throws ParseException {
        ArithmeticParser parser = new ArithmeticParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        parseexception = false;
        new ParseTreeWalker().walk(this, tree);
        if (parseexception) {
            throw new ParseException();
        }
        return sentenceAST;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        parseexception = true;
    }

    @Override
    public void enterExpression(ArithmeticParser.ExpressionContext ctx) {
        myStack.add(new AST(new NonTerm("Expression")));
    }

    @Override
    public void exitExpression(ArithmeticParser.ExpressionContext ctx) {
        if (!myStack.peek().getSymbol().equals(new NonTerm("Expression"))) {
            parseexception = true;
            System.err.println(myStack.peek().getSymbol());
        }
        if (myStack.size()==1) {
            sentenceAST = myStack.pop();
        } else {
            AST sentenceAST = myStack.pop();
            myStack.peek().addChild(sentenceAST);
        }
    }

    @Override
    public void enterTerm(ArithmeticParser.TermContext ctx) {
        myStack.add(new AST(new NonTerm("Term")));
    }

    @Override
    public void exitTerm(ArithmeticParser.TermContext ctx) {
        if (!myStack.peek().getSymbol().equals(new NonTerm("Term"))) {
            parseexception = true;
            System.err.println(myStack.peek().getSymbol());
        }
        AST termAST = myStack.pop();
        myStack.peek().addChild(termAST);
    }

    @Override
    public void enterPower(ArithmeticParser.PowerContext ctx) {
        myStack.add(new AST(new NonTerm("Power")));
    }

    @Override
    public void exitPower(ArithmeticParser.PowerContext ctx) {
        if (!myStack.peek().getSymbol().equals(new NonTerm("Power"))) {
            parseexception = true;
            System.err.println(myStack.peek().getSymbol());
        }
        AST powerAST = myStack.pop();
        myStack.peek().addChild(powerAST);
    }

    @Override
    public void enterFactor(ArithmeticParser.FactorContext ctx) {
        myStack.add(new AST(new NonTerm("Factor")));
    }

    @Override
    public void exitFactor(ArithmeticParser.FactorContext ctx) {
        if (!myStack.peek().getSymbol().equals(new NonTerm("Factor"))) {
            parseexception = true;
            System.err.println(myStack.peek().getSymbol());
        }
        AST factorAST = myStack.pop();
        myStack.peek().addChild(factorAST);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        Token a = node.getSymbol();
        myStack.peek().addChild(new AST(new Term(a.getType(), "TERMINAL"), node.getSymbol()));
    }
}
