package pp.block2.cc.antlr;

import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block2.cc.*;
import pp.block2.cc.Parser;
import pp.block2.cc.ll.Sentence;

import java.util.Stack;

public class SentenceConverter //
		extends SentenceBaseListener implements Parser {
	/** Factory needed to create terminals of the {@link Sentence}
	 * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
	 * example usage. */
	private final SymbolFactory fact;

	private Stack<AST> myStack = new Stack<>();
	private AST sentenceAST;
	private boolean parseexception = false;

	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence.class);
	}

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
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
	public void enterSentence(SentenceParser.SentenceContext ctx) {
		myStack.add(new AST(new NonTerm("Sentence")));
	}

	@Override
	public void exitSentence(SentenceParser.SentenceContext ctx) {
		if (!myStack.peek().getSymbol().equals(new NonTerm("Sentence"))) {
			parseexception = true;
			System.err.println(myStack.peek().getSymbol());
		}
		sentenceAST = myStack.pop();
	}

	@Override
	public void enterModifier(SentenceParser.ModifierContext ctx) {
		myStack.add(new AST(new NonTerm("Modifier")));
	}

	@Override
	public void exitModifier(SentenceParser.ModifierContext ctx) {
		if (!myStack.peek().getSymbol().equals(new NonTerm("Modifier"))) {
			parseexception = true;
			System.err.println(myStack.peek().getSymbol());
		}
		AST modifierAST = myStack.pop();
		myStack.peek().addChild(modifierAST);
	}

	@Override
	public void enterObject(SentenceParser.ObjectContext ctx) {
		myStack.add(new AST(new NonTerm("Object")));
		assert(myStack.peek().equals(new AST(new NonTerm("Object"))));
	}


	@Override
	public void exitObject(SentenceParser.ObjectContext ctx) {
		if (!myStack.peek().getSymbol().equals(new NonTerm("Object"))) {
			parseexception = true;
			System.err.println(myStack.peek().getSymbol());
		}
		AST objectAST = myStack.pop();
		myStack.peek().addChild(objectAST);
	}

	@Override
	public void enterSubject(SentenceParser.SubjectContext ctx) {
		myStack.add(new AST(new NonTerm("Subject")));
		assert(myStack.peek().equals(new AST(new NonTerm("Subject"))));
	}

	@Override
	public void exitSubject(SentenceParser.SubjectContext ctx) {
		if (!myStack.peek().getSymbol().equals(new NonTerm("Subject"))) {
			parseexception = true;
			System.err.println(myStack.peek().getSymbol());
		}
		AST subjectAST = myStack.pop();
		myStack.peek().addChild(subjectAST);
	}


	@Override
	public void visitTerminal(TerminalNode node) {

		Token a = node.getSymbol();
		myStack.peek().addChild(new AST(new Term(a.getType(),SentenceLexer.ruleNames[a.getType()-1]), node.getSymbol()));

	}

	// From here on overwrite the listener methods
	// Use an appropriate ParseTreeProperty to
	// store the correspondence from nodes to ASTs
}
