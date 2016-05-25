package pp.block4.cc.iloc;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
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
import pp.iloc.model.*;

import java.util.LinkedList;
import java.util.List;

/** Compiler from Calc.g4 to ILOC. */
public class CalcCompiler extends CalcBaseListener {

	public class Instruction {
		private final OpCode opcode;
		private final Operand[] operands;

		public Instruction(OpCode opcode, Operand... args) {
			this.opcode = opcode;
			this.operands = args;
		}
		public OpCode getOpCode() {
			return opcode;
		}
		public Operand[] getOperands() {
			return operands;
		}
	}

	ParseTreeProperty<List<Instruction>> needed;
	Reg r_a;
	Reg r_0;
	int counter;

	//IDEE: Sla van elke node bij EXIT de instructies op die zouden moeten resulteren in het antwoord op r_a.
	//      Bij operaties, doe eerst links, kopieer r_a naar r_b, doe dan rechts, doe dan operatie en sla op in r_a.
	//		Maak hiervoor kleine subclasse "Instructie". NB: Houd een counter bij voor register namen.


	@Override
	public void exitNumber(CalcParser.NumberContext ctx) {
		Instruction instr1 = new Instruction(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), r_a);
		List<Instruction> myneeded = new LinkedList<>();
		myneeded.add(instr1);
		needed.put(ctx, myneeded);
	}

	@Override
	public void exitMinus(CalcParser.MinusContext ctx) {
		List<Instruction> instrstat = needed.get(ctx.getChild(1));
		List<Instruction> weneed = new LinkedList<>(instrstat);
		weneed.add(new Instruction(OpCode.sub, r_0, r_a, r_a));
		needed.put(ctx, weneed);
	}

	@Override
	public void exitPlus(CalcParser.PlusContext ctx) {
		List<Instruction> needed1 = needed.get(ctx.getChild(0));
		List<Instruction> needed2= needed.get(ctx.getChild(2));
		List<Instruction> weneed = new LinkedList<>(needed1);
		Reg tempsave = new Reg("r_"+String.valueOf(counter));
		counter++;
		weneed.add(new Instruction(OpCode.add, r_a, r_0, tempsave));
		weneed.addAll(needed2);
		weneed.add(new Instruction(OpCode.add, tempsave, r_a, r_a));
		needed.put(ctx, weneed);
	}

	@Override
	public void exitTimes(CalcParser.TimesContext ctx) {
		List<Instruction> needed1 = needed.get(ctx.getChild(0));
		List<Instruction> needed2 = needed.get(ctx.getChild(2));
		List<Instruction> weneed = new LinkedList<>(needed1);
		Reg tempsave = new Reg("r_"+String.valueOf(counter));
		counter++;
		weneed.add(new Instruction(OpCode.add, r_a, r_0, tempsave));
		weneed.addAll(needed2);
		weneed.add(new Instruction(OpCode.mult, tempsave, r_a, r_a));
		needed.put(ctx, weneed);
	}

	@Override
	public void exitPar(CalcParser.ParContext ctx) {
		needed.put(ctx, needed.get(ctx.getChild(1)));
	}

	@Override
	public void exitComplete(CompleteContext ctx) {
		needed.put(ctx, needed.get(ctx.getChild(0)));
	}

	/** Program under construction. */
	private Program prog;
	// Attribute maps and other fields

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		counter = 1;
		prog = new Program();
		r_0 = new Reg("r_0");
		r_a = new Reg("r_a");
		needed = new ParseTreeProperty<>();

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
		List<Instruction> myneeded = needed.get(tree);
		Program res = new Program();

		res.addInstr(new Op(OpCode.loadI, new Num(0), r_0));
		for (Instruction i: myneeded) {
			res.addInstr(new Op(i.getOpCode(), i.getOperands()));
		}
		res.addInstr(new Op(OpCode.out, new Str("Result: "), r_a));
		return res;
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
