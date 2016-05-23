package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.BlockStatContext;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;


	ParseTreeProperty<Node> entrie;
	ParseTreeProperty<Node> exitie;

	/** Builds the CFG for a program contained in a given file. */
	public Graph build(File file) {
		Graph result = null;
		ErrorListener listener = new ErrorListener();
		try {
			CharStream chars = new ANTLRInputStream(new FileReader(file));
			Lexer lexer = new FragmentLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			FragmentParser parser = new FragmentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(listener);
			ParseTree tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
				for (String error : listener.getErrors()) {
					System.err.println(error);
				}
			} else {
				result = build(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ParseTree tree) {
		entrie = new ParseTreeProperty<>();
		exitie = new ParseTreeProperty<>();
		this.graph = new Graph();
		new ParseTreeWalker().walk(this, tree);
		try {
			graph.writeDOT("file.DOT", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.graph;
	}

	@Override
	public void exitWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
		Node mynode = addNode(ctx, "WHILE");
		entrie.put(ctx, mynode);
		mynode.addEdge(entrie.get(ctx.getChild(4)));
		exitie.get(ctx.getChild(4)).addEdge(mynode);
		exitie.put(ctx, mynode);
	}

	@Override
	public void exitDecl(@NotNull FragmentParser.DeclContext ctx) {
		Node mynode = addNode(ctx, "Decl");
		entrie.put(ctx, mynode);
		exitie.put(ctx, mynode);
	}

	@Override
	public void exitAssignStat(@NotNull FragmentParser.AssignStatContext ctx) {
		Node mynode = addNode(ctx, "Assign");
		entrie.put(ctx, mynode);
		exitie.put(ctx, mynode);
	}

	@Override
	public void exitBlockStat(@NotNull BlockStatContext ctx) {
		if (ctx.getChildCount()==2) {
			Node mynode = addNode(ctx, "Empty_Block");
			entrie.put(ctx, mynode);
			exitie.put(ctx, mynode);
		} else {
			entrie.put(ctx, entrie.get(ctx.getChild(1)));
			exitie.put(ctx, exitie.get(ctx.getChild(ctx.getChildCount()-2)));
			for (int i = 1; i<ctx.getChildCount()-2; i++) {
				exitie.get(ctx.getChild(i)).addEdge(entrie.get(ctx.getChild(i+1)));
			}
		}
	}

	@Override
	public void exitPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {
		Node mynode = addNode(ctx, "Print");
		entrie.put(ctx, mynode);
		exitie.put(ctx, mynode);
	}

	@Override
	public void exitIfStat(@NotNull FragmentParser.IfStatContext ctx) {
			Node mynode = addNode(ctx, "IF");
			if (ctx.getChildCount()==5) {
				entrie.put(ctx, mynode);
				mynode.addEdge(entrie.get(ctx.getChild(4)));
				Node exitnode = addNode(ctx, "JOIN");
				mynode.addEdge(exitnode);
				exitie.get(ctx.getChild(4)).addEdge(exitnode);
				exitie.put(ctx, exitnode);
			} else if (ctx.getChildCount()==7) {
				entrie.put(ctx, mynode);
				mynode.addEdge(entrie.get(ctx.getChild(4)));
				mynode.addEdge(entrie.get(ctx.getChild(6)));
				Node exitnode = addNode(ctx, "JOIN");
				exitie.get(ctx.getChild(4)).addEdge(exitnode);
				exitie.get(ctx.getChild(6)).addEdge(exitnode);
				exitie.put(ctx, exitnode);
			} else {
				System.err.println("WAT NO MUNNIE");
			}

	}

	@Override
	public void enterBreakStat(BreakStatContext ctx) {
		throw new IllegalArgumentException("Break not supported");
	}

	@Override
	public void enterContStat(FragmentParser.ContStatContext ctx) {
		throw new IllegalArgumentException("Continue not supported");
	}

	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
