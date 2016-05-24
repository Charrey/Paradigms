package pp.block4.cc.iloc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.traversal.TreeWalker;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.iloc.CalcParser.CompleteContext;
import pp.iloc.Simulator;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;

/** Compiler from Calc.g4 to ILOC. */
public class CalcCompiler extends CalcBaseListener {

	//IDEE: Sla van elke node bij EXIT de instructies op die zouden moeten resulteren in het antwoord op r_a.
	//      Bij operaties, doe eerst links, kopieer r_a naar r_b, doe dan rechts, doe dan operatie en sla op in r_a.
	//		Maak hiervoor kleine subclasse "Instructie". NB: Houd een counter bij voor register namen.







	/** Program under construction. */
	private Program prog;
	// Attribute maps and other fields

	ParseTreeProperty<Integer> content;

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		Program result = null;
		ErrorListener listener = new ErrorListener();
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.complete();
		if (listener.hasErrors()) {
			System.out.printf("Parse errors in %s:%n", text);
			for (String error : listener.getErrors()) {
				System.err.println(error);
			}
		} else {
			result = compile(tree);
		}
		return result;
	}

	/** Compiles a given Calc-parse tree into an ILOC program. */
	public Program compile(ParseTree tree) {
		new ParseTreeWalker().walk(this, tree);
		return prog;
	}

	@Override
	public void exitMinus(CalcParser.MinusContext ctx) {
		super.exitMinus(ctx);
	}

	/** Constructs an operation from the parameters
	 * and adds it to the program under construction. */
	private void emit(OpCode opCode, Operand... args) {
		this.prog.addInstr(new Op(opCode, args));
	}

	/** Calls the compiler, and simulates and prints the compiled program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [expr]+");
			return;
		}
		CalcCompiler compiler = new CalcCompiler();
		for (String expr : args) {
			System.out.println("Processing " + expr);
			Program prog = compiler.compile(expr);
			new Simulator(prog).run();
			System.out.println(prog.prettyPrint());
		}
	}
}
