package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.BreakStatContext;
import pp.block4.cc.cfg.FragmentParser.ContStatContext;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;
	private ParseTreeProperty<Node> entrie;
	private ParseTreeProperty<Node> exitie;



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
			ProgramContext tree = parser.program();
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

	@Override
	public void enterAssignStat(FragmentParser.AssignStatContext ctx) {
		Node myentry = entrie.get(ctx);
		Node myexit = exitie.get(ctx);
		myentry.addEdge(myexit);
	}

	@Override
	public void enterBlockStat(FragmentParser.BlockStatContext ctx) {
		Node myentry = entrie.get(ctx);
		Node myexit = exitie.get(ctx);

		if (ctx.getChildCount()==2) {
			myentry.addEdge(myexit);
			return;
		}
		Node lastnode = myentry;
		for (int i = 1; i<ctx.getChildCount()-1; i++) {
			ParserRuleContext thisnode = (ParserRuleContext) ctx.getChild(i);
			Node yourentry = addNode(thisnode, getFirstNodeText(thisnode));
			Node yourexit = addNode(thisnode, getLastNodeText(thisnode));
			entrie.put(thisnode, yourentry);
			exitie.put(thisnode, yourexit);
			lastnode.addEdge(yourentry);
			lastnode = yourexit;
		}
		lastnode.addEdge(myexit);
	}

	@Override
	public void enterDecl(FragmentParser.DeclContext ctx) {
		Node myentry = entrie.get(ctx);
		Node myexit = exitie.get(ctx);
		myentry.addEdge(myexit);
	}

	@Override
	public void enterWhileStat(FragmentParser.WhileStatContext ctx) {
		Node myentry = entrie.get(ctx);
		Node myexit = exitie.get(ctx);
		ParserRuleContext internalstat = (ParserRuleContext) ctx.getChild(4);
		Node yourentry = addNode(internalstat, getFirstNodeText(internalstat));
		Node yourexit = addNode(internalstat, getLastNodeText(internalstat));
		entrie.put(internalstat, yourentry);
		exitie.put(internalstat, yourexit);
		myentry.addEdge(yourentry);
		yourexit.addEdge(myentry);
		myentry.addEdge(myexit);
	}

	@Override
	public void exitPrintStat(FragmentParser.PrintStatContext ctx) {
		Node myentry = entrie.get(ctx);
		Node myexit = exitie.get(ctx);
		myentry.addEdge(myexit);
	}

	@Override
	public void enterIfStat(FragmentParser.IfStatContext ctx) {
		Node myentry = entrie.get(ctx);
		Node myexit = exitie.get(ctx);
		if (ctx.getChildCount()==5) {
			ParserRuleContext nextstat = (ParserRuleContext) ctx.getChild(4);
			Node yourentry = addNode(nextstat, getFirstNodeText(nextstat));
			Node yourexit = addNode(nextstat, getLastNodeText(nextstat));
			myentry.addEdge(yourentry);
			yourexit.addEdge(myexit);
			entrie.put(nextstat, yourentry);
			exitie.put(nextstat, yourexit);
		} else if (ctx.getChildCount()==7) {
			ParserRuleContext ifstat = (ParserRuleContext) ctx.getChild(4);
			ParserRuleContext elsestat = (ParserRuleContext) ctx.getChild(6);
			Node ifentry = addNode(ifstat, getFirstNodeText(ifstat));
			Node ifexit = addNode(ifstat, getLastNodeText(ifstat));
			entrie.put(ifstat, ifentry);
			exitie.put(ifstat, ifexit);
			Node elseentry = addNode(elsestat, getFirstNodeText(elsestat));
			Node elseexit = addNode(elsestat, getLastNodeText(elsestat));
			entrie.put(elsestat, elseentry);
			exitie.put(elsestat, elseexit);
			myentry.addEdge(ifentry);
			myentry.addEdge(elseentry);
			ifexit.addEdge(myexit);
			elseexit.addEdge(myexit);
		}


	}

	@Override
	public void enterProgram(ProgramContext ctx) {
		Node firstentry = null;
		Node lastexit = null;
		for (int i = 0; i<ctx.getChildCount()-1; i++) {
			ParserRuleContext get = (ParserRuleContext) ctx.getChild(i);
			Node entry = addNode(get, getFirstNodeText(get));
			Node exit = addNode(get, getLastNodeText(get));
			entrie.put(ctx.getChild(i), entry);
			exitie.put(ctx.getChild(i), exit);

			if (lastexit!=null) {
				lastexit.addEdge(entry);
			}
			if (firstentry == null) {
				firstentry = entry;
			}
			lastexit = exit;
		}
	}


	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ProgramContext tree) {
		this.graph = new Graph();
		entrie = new ParseTreeProperty<>();
		exitie = new ParseTreeProperty<>();
		new ParseTreeWalker().walk(this, tree);
		try {
			graph.writeDOT("file.DOT", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.graph;
	}

	@Override
	public void enterBreakStat(BreakStatContext ctx) {
		throw new IllegalArgumentException("Break not supported");
	}

	@Override
	public void enterContStat(ContStatContext ctx) {
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
		TopDownCFGBuilder builder = new TopDownCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}

	public String getFirstNodeText(ParserRuleContext ctx) {
		if (ctx instanceof FragmentParser.WhileStatContext) {
			return "WHILE: "+ctx.getChild(2).getText();
		}
		if (ctx instanceof FragmentParser.DeclContext || ctx instanceof FragmentParser.AssignStatContext) {
			return ctx.getText();
		}
		if (ctx instanceof FragmentParser.BlockStatContext) {
			return "ENTER BLOCK";
		}
		if (ctx instanceof FragmentParser.IfStatContext) {
			return "IF: "+ctx.getChild(2).getText();
		}
		if (ctx instanceof FragmentParser.PrintStatContext) {
			return "PRINT";
		}
		return "?";
	}

	public  String getLastNodeText(ParserRuleContext ctx) {
		if (ctx instanceof FragmentParser.WhileStatContext) {
			return "JOIN WHILE";
		}
		if (ctx instanceof FragmentParser.DeclContext || ctx instanceof FragmentParser.AssignStatContext || ctx instanceof FragmentParser.PrintStatContext) {
			return "-";
		}
		if (ctx instanceof FragmentParser.BlockStatContext) {
			return "EXIT BLOCK";
		}
		if (ctx instanceof FragmentParser.IfStatContext) {
			return "JOIN IF";
		}
		return "?";
	}

}
