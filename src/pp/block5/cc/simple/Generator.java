package pp.block5.cc.simple;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block3.cc.symbol.MySymbolTable;
import pp.block3.cc.symbol.SymbolTable;
import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.iloc.Simulator;
import pp.iloc.model.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends SimplePascalBaseVisitor<List<Op>> {
	/** The representation of the boolean value <code>false</code>. */
	public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
	/** The representation of the boolean value <code>true</code>. */
	public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

	/** The base register. */
	private Reg arp = new Reg("r_arp");
	/** The outcome of the checker phase. */
	private Result checkResult;
	/** Association of statement nodes to labels. */
	private ParseTreeProperty<Label> labels;
	/** The program being built. */
	private Program prog;
	/** Register count, used to generate fresh registers. */
	private int regCount;
	/** Association of expression and target nodes to registers. */
	private ParseTreeProperty<Reg> regs;



	/** Generates ILOC code for a given parse tree,
	 * given a pre-computed checker result.
	 */
	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		this.regs = new ParseTreeProperty<>();
		this.labels = new ParseTreeProperty<>();
		this.regCount = 1;
		List<Op> res = tree.accept(this);
		for (Op i : res) {
			this.prog.addInstr(i);
		}
		return this.prog;
	}

	// Override the visitor methods
	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(Label label, OpCode opCode, Operand... args) {
		Op result = new Op(label, opCode, args);
		this.prog.addInstr(result);
		return result;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(OpCode opCode, Operand... args) {
		return emit((Label) null, opCode, args);
	}

	/** 
	 * Looks up the label for a given parse tree node,
	 * creating it if none has been created before.
	 * The label is actually constructed from the entry node
	 * in the flow graph, as stored in the checker result.
	 */
	private Label label(ParserRuleContext node) {
		Label result = this.labels.get(node);
		if (result == null) {
			ParserRuleContext entry = this.checkResult.getEntry(node);
			result = createLabel(entry, "n");
			this.labels.put(node, result);
		}
		return result;
	}

	/** Creates a label for a given parse tree node and prefix. */
	private Label createLabel(ParserRuleContext node, String prefix) {
		Token token = node.getStart();
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		String result = prefix + "_" + line + "_" + column;
		return new Label(result);
	}

	/** Retrieves the offset of a variable node from the checker result,
	 * wrapped in a {@link Num} operand. */
	private Num offset(ParseTree node) {
		return new Num(this.checkResult.getOffset(node));
	}

	/** Returns a register for a given parse tree node,
	 * creating a fresh register if there is none for that node. */
	private Reg reg(ParseTree node) {
		Reg result = this.regs.get(node);
		if (result == null) {
			result = new Reg("r_" + this.regCount);
			this.regs.put(node, result);
			this.regCount++;
		}
		return result;
	}

	/** Assigns a register to a given parse tree node. */
	private void setReg(ParseTree node, Reg reg) {
		this.regs.put(node, reg);
	}

	// --------------- OUR CODE ------------------//

	Map<String, Reg> registers;

	private Reg r_0;
	private Reg r_a;

	private int label_counter;

	ParseTreeProperty<String> label;

	@Override
	public List<Op> visitProgram(SimplePascalParser.ProgramContext ctx) {
		registers = new HashMap<>();
		label = new ParseTreeProperty<>();
		r_0 = new Reg("r_0");
		r_a = new Reg("r_a");
		return visitBody(ctx.body());
	}

	@Override
	public List<Op> visitBody(SimplePascalParser.BodyContext ctx) {
		List<Op> res = new LinkedList<>();
		res.add(new Op(OpCode.loadI, new Num(0), r_0));
		res.add(new Op(OpCode.loadI, new Num(0), r_a));
		for (SimplePascalParser.DeclContext i : ctx.decl()) {
			res.addAll(visitVarDecl((SimplePascalParser.VarDeclContext) i));
		}
		res.addAll(visitBlock(ctx.block()));
		return res;
	}

	@Override
	public List<Op> visitVarDecl(SimplePascalParser.VarDeclContext ctx) {
		List<Op> res = new LinkedList<>();
		for (SimplePascalParser.VarContext i : ctx.var()) {
			res.addAll(visitVar(i));
		}
		return res;
	}

	@Override
	public List<Op> visitVar(SimplePascalParser.VarContext ctx) {
		List<Op> res = new LinkedList<>();
		for (TerminalNode i : ctx.ID()) {
			Reg reg = new Reg("r_"+i.getText());
			registers.put(i.getText(), reg);
			res.add(new Op(OpCode.loadI, new Num(0), reg));
		}
		return res;
	}

	@Override
	public List<Op> visitBlock(SimplePascalParser.BlockContext ctx) {
		List<Op> res = new LinkedList<>();
		for (SimplePascalParser.StatContext i : ctx.stat()) {
			res.addAll(visit(i));
		}
		return res;
	}

	@Override
	public List<Op> visitAssStat(SimplePascalParser.AssStatContext ctx) {
		List<Op> res = new LinkedList<>();
		if (label.get(ctx)!=null) {
			res.add(new Op(new Label(label.get(ctx)), OpCode.i2i, r_0, r_0));
		}
		res.addAll(visit(ctx.expr()));
		res.add(new Op(OpCode.i2i, r_a, registers.get(ctx.target().getText())));
		return res;
	}

	@Override
	public List<Op> visitBlockStat(SimplePascalParser.BlockStatContext ctx) {
		List<Op> res = new LinkedList<>();
		if (label.get(ctx)!=null) {
			res.add(new Op(new Label(label.get(ctx)), OpCode.i2i, r_0, r_0));
		}
		res.addAll(visit(ctx.block()));
		return res;
	}



	@Override
	public List<Op> visitIfStat(SimplePascalParser.IfStatContext ctx) {
		List<Op> res = new LinkedList<>();
		if (label.get(ctx)!=null) {
			res.add(new Op(new Label(label.get(ctx)), OpCode.i2i, r_0, r_0));
		}


		//res.add(new Op(new Label("prepareif_"+label_counter), OpCode.i2i, r_0, r_0));


		List<Op> exprget = visit(ctx.expr());
		res.addAll(exprget);



		res.add(new Op(OpCode.cbr, r_a, new Label("label_"+label_counter+"_if"), new Label("label_"+label_counter+"_else")));
		label.put(ctx.stat(0), "label_"+label_counter+"_if");
		if (ctx.stat().size()==2) {
			label.put(ctx.stat(1), "label_"+label_counter+"_else");
		}
		int counter_old = label_counter;
		label_counter++;

		res.addAll(visit(ctx.stat(0)));
		res.add(new Op(OpCode.jumpI, new Label("label_"+counter_old+"_end")));
		res.addAll(visit(ctx.stat(1)));
		res.add(new Op(new Label("label_"+counter_old+"_end"), OpCode.i2i, r_0, r_0));
		return res;
	}

	@Override
	public List<Op> visitInStat(SimplePascalParser.InStatContext ctx) {
		List<Op> res = new LinkedList<>();
		res.add(new Op(OpCode.in, new Str(ctx.STR().getText().replaceAll("\"", "")), registers.get(ctx.target().getText())));
		return res;
	}

	@Override
	public List<Op> visitTrueExpr(SimplePascalParser.TrueExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.add(new Op(OpCode.loadI, new Num(1), r_a));
		return res;
	}

	@Override
	public List<Op> visitFalseExpr(SimplePascalParser.FalseExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.add(new Op(OpCode.loadI, new Num(0), r_a));
		return res;
	}

	@Override
	public List<Op> visitNumExpr(SimplePascalParser.NumExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.add(new Op(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), r_a));
		return res;
	}

	@Override
	public List<Op> visitIdExpr(SimplePascalParser.IdExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.add(new Op(OpCode.i2i, registers.get(ctx.ID().getText()), r_a));
		return res;
	}

	@Override
	public List<Op> visitMultExpr(SimplePascalParser.MultExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.addAll(visit(ctx.expr(0)));
		res.add(new Op(OpCode.i2i, r_a, reg(ctx)));
		res.addAll(visit(ctx.expr(1)));
		switch(ctx.multOp().getText().toLowerCase()) {
			case "*":
				res.add(new Op(OpCode.mult, reg(ctx), r_a, r_a));
				break;
			case "/":
				res.add(new Op(OpCode.div, reg(ctx), r_a, r_a));
				break;
		}
		return res;
	}

	@Override
	public List<Op> visitPrfExpr(SimplePascalParser.PrfExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.addAll(visit(ctx.expr()));
		switch(ctx.prfOp().getText().toLowerCase()) {
			case "not":
				res.add(new Op(OpCode.cmp_EQ, r_0, r_a, r_a));
				break;
			case "-":
				res.add(new Op(OpCode.sub, r_0, r_a, r_a));
				break;
		}

		return res;
	}

	@Override
	public List<Op> visitPlusExpr(SimplePascalParser.PlusExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.addAll(visit(ctx.expr(0)));
		res.add(new Op(OpCode.i2i, r_a, reg(ctx)));
		res.addAll(visit(ctx.expr(1)));
		switch(ctx.plusOp().getText().toLowerCase()) {
			case "+":
				res.add(new Op(OpCode.add, reg(ctx), r_a, r_a));
				break;
			case "-":
				res.add(new Op(OpCode.sub, reg(ctx), r_a, r_a));
				break;
		}
		return res;
	}

	@Override
	public List<Op> visitCompExpr(SimplePascalParser.CompExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.addAll(visit(ctx.expr(0)));
		res.add(new Op(OpCode.i2i, r_a, reg(ctx)));
		res.addAll(visit(ctx.expr(1)));
		switch (ctx.compOp().getText().toLowerCase()) {
			case "=":
				res.add(new Op(OpCode.cmp_EQ, reg(ctx), r_a, r_a));
				break;
			case ">":
				res.add(new Op(OpCode.cmp_GT, reg(ctx), r_a, r_a));
				break;
			case "<":
				res.add(new Op(OpCode.cmp_LT, reg(ctx), r_a, r_a));
				break;
			case ">=":
				res.add(new Op(OpCode.cmp_GE, reg(ctx), r_a, r_a));
				break;
			case "<=":
				res.add(new Op(OpCode.cmp_LE, reg(ctx), r_a, r_a));
				break;
			case "<>":
				res.add(new Op(OpCode.cmp_NE, reg(ctx), r_a, r_a));
				break;
		}
		return res;
	}

	@Override
	public List<Op> visitBoolExpr(SimplePascalParser.BoolExprContext ctx) {
		List<Op> res = new LinkedList<>();
		res.addAll(visit(ctx.getChild(0)));
		res.add(new Op(OpCode.i2i, r_a, reg(ctx)));
		res.addAll(visit(ctx.getChild(2)));
		switch (ctx.boolOp().getText().toLowerCase()) {
			case "and":
				res.add(new Op(OpCode.and, r_a, reg(ctx), r_a));
				break;
			case "or":
				res.add(new Op(OpCode.or, r_a, reg(ctx), r_a));
				break;
		}
		return res;
	}

	@Override
	public List<Op> visitParExpr(SimplePascalParser.ParExprContext ctx) {
		return visit(ctx.expr());
	}


	@Override
	public List<Op> visitWhileStat(SimplePascalParser.WhileStatContext ctx) {
		List<Op> res = new LinkedList<>();
		if (label.get(ctx)!=null) {
			res.add(new Op(new Label(label.get(ctx)), OpCode.i2i, r_0, r_0));
		}
		res.add(new Op(new Label("preparewhile_"+label_counter), OpCode.i2i, r_0, r_0));
		res.addAll(visit(ctx.expr()));
		res.add(new Op(OpCode.cbr, r_a, new Label("label_"+label_counter+"_while"), new Label("label_"+label_counter+"_end")));
		int old_count = label_counter;
		label.put(ctx.stat(), "label_"+label_counter+"_while");
		label_counter++;
		res.addAll(visit(ctx.stat()));
		res.addAll(visit(ctx.expr()));
		res.add(new Op(OpCode.jumpI, new Label("preparewhile_"+old_count)));
		res.add(new Op(new Label("label_"+old_count+"_end"), OpCode.i2i, r_0, r_0));
		return res;
	}

	@Override
	public List<Op> visitOutStat(SimplePascalParser.OutStatContext ctx) {
		List<Op> res = new LinkedList<>();
		if (label.get(ctx)!=null) {
			res.add(new Op(new Label(label.get(ctx)), OpCode.i2i, r_0, r_0));
		}
		res.addAll(visit(ctx.expr()));
		res.add(new Op(OpCode.out, new Str(ctx.STR().getText().replaceAll("\"", "")), r_a));
		return res;
	}
}
