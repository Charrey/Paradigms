package pp.block5.cc.simple;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block5.cc.ParseException;
import pp.block5.cc.pascal.SimplePascalBaseListener;
import pp.block5.cc.pascal.SimplePascalParser;

import javax.activation.UnsupportedDataTypeException;

/** Class to type check and calculate flow entries and variable offsets. */
public class Checker extends SimplePascalBaseListener {
	/** Result of the latest call of {@link #check}. */
	private Result result;
	/** Variable scope for the latest call of {@link #check}. */
	private Scope scope;
	/** List of errors collected in the latest call of {@link #check}. */
	private List<String> errors;

	/** Runs this checker on a given parse tree,
	 * and returns the checker result.
	 * @throws ParseException if an error was found during checking.
	 */
	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.result = new Result();
		this.errors = new ArrayList<>();
		new ParseTreeWalker().walk(this, tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		return this.result;
	}

	// Override the listener methods for the statement nodes
	@Override
	public void exitBoolExpr(SimplePascalParser.BoolExprContext ctx) {
		checkType(ctx.expr(0), Type.BOOL);
		checkType(ctx.expr(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitCompExpr(SimplePascalParser.CompExprContext ctx) {
		checkType(ctx.expr(0), Type.INT);
		checkType(ctx.expr(1), Type.INT);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitFalseExpr(SimplePascalParser.FalseExprContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);
	}

	@Override
	public void exitIdExpr(SimplePascalParser.IdExprContext ctx) {
		String id = ctx.ID().getText();
		Type type = this.scope.type(id);
		if (type == null) {
			addError(ctx, "Variable '%s' not declared", id);
		} else {
			setType(ctx, type);
			setOffset(ctx, this.scope.offset(id));
			setEntry(ctx, ctx);
		}
	}

	@Override
	public void exitMultExpr(SimplePascalParser.MultExprContext ctx) {
		checkType(ctx.expr(0), Type.INT);
		checkType(ctx.expr(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitNumExpr(SimplePascalParser.NumExprContext ctx) {
		setType(ctx, Type.INT);
		setEntry(ctx, ctx);
	}

	@Override
	public void exitParExpr(SimplePascalParser.ParExprContext ctx) {
		setType(ctx, getType(ctx.expr()));
		setEntry(ctx, entry(ctx.expr()));
	}

	@Override
	public void exitPlusExpr(SimplePascalParser.PlusExprContext ctx) {
		checkType(ctx.expr(0), Type.INT);
		checkType(ctx.expr(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expr(0)));
	}

	@Override
	public void exitPrfExpr(SimplePascalParser.PrfExprContext ctx) {
		Type type;
		if (ctx.prfOp().MINUS() != null) {
			type = Type.INT;
		} else {
			assert ctx.prfOp().NOT() != null;
			type = Type.BOOL;
		}
		checkType(ctx.expr(), type);
		setType(ctx, type);
		setEntry(ctx, entry(ctx.expr()));
	}

	@Override
	public void exitTrueExpr(SimplePascalParser.TrueExprContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);
	}

	// -------------------- OUR CODE -------------------------- //

	@Override
	public void exitVarDecl(SimplePascalParser.VarDeclContext ctx) {
		super.exitVarDecl(ctx);
	}

	@Override
	public void exitVar(SimplePascalParser.VarContext ctx) {
		Type type;
		try {
			switch (ctx.type().getText().toLowerCase()) {
				case "integer":
					type = Type.INT;
					break;
				case "boolean":
					type = Type.BOOL;
					break;
				default:
					throw new IllegalStateException();
			}
			for (TerminalNode node: ctx.ID()) {
				scope.put(node.getText(), type);
				result.setType(node, type);
				//setEntry(ctx, entry(ctx.expr(0)));
			}
		} catch (IllegalStateException e) {
			addError(ctx,"Unknown type exception: " + ctx.type().getText() + " not recognized.");
		}
	}

	@Override
	public void exitAssStat(SimplePascalParser.AssStatContext ctx) {
		setEntry(ctx, (ParserRuleContext) ctx.getChild(2));
		Type targetType = scope.type(ctx.target().getText());
		Type exprType = result.getType(ctx.getChild(2));
		if (!targetType.equals(exprType)){
			addError(ctx,"Types don't match in assignment: " + "Target type= " + targetType.toString() + " Expression type= " + exprType);
		}
	}

	@Override
	public void exitIdTarget(SimplePascalParser.IdTargetContext ctx) {
		if(scope.contains(ctx.ID().getText())){
			result.setType(ctx, scope.type(ctx.ID().getText()));
		} else {
			addError(ctx,"Unkown id: " + ctx.ID().getText());
		}
	}

	@Override
	public void exitIfStat(SimplePascalParser.IfStatContext ctx) {
		if(!result.getType(ctx.expr()).equals(Type.BOOL)){
			addError(ctx,"Expected boolean, found: " + result.getType(ctx.expr()));
		}
	}



	@Override
	public void exitBlockStat(SimplePascalParser.BlockStatContext ctx) {
		setEntry(ctx, entry(ctx.getChild(0)));
	}

	@Override
	public void exitWhileStat(SimplePascalParser.WhileStatContext ctx) {
		if(!result.getType(ctx.expr()).equals(Type.BOOL)){
			addError(ctx,"Expected boolean, found: " + result.getType(ctx.expr()));
		}
	}

	// --------------------------------------------------------- //

	/** Indicates if any errors were encountered in this tree listener. */
	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	/** Returns the list of errors collected in this tree listener. */
	public List<String> getErrors() {
		return this.errors;
	}

	/** Checks the inferred type of a given parse tree,
	 * and adds an error if it does not correspond to the expected type.
	 */
	private void checkType(ParserRuleContext node, Type expected) {
		Type actual = getType(node);
		if (actual == null) {
			throw new IllegalArgumentException("Missing inferred type of "
					+ node.getText());
		}
		if (!actual.equals(expected)) {
			addError(node, "Expected type '%s' but found '%s'", expected,
					actual);
		}
	}

	/** Records an error at a given parse tree node.
	 * @param node the parse tree node at which the error occurred
	 * @param message the error message
	 * @param args arguments for the message, see {@link String#format}
	 */
	private void addError(ParserRuleContext node, String message,
			Object... args) {
		addError(node.getStart(), message, args);
	}

	/** Records an error at a given token.
	 * @param token the token at which the error occurred
	 * @param message the error message
	 * @param args arguments for the message, see {@link String#format}
	 */
	private void addError(Token token, String message, Object... args) {
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		message = String.format(message, args);
		message = String.format("Line %d:%d - %s", line, column, message);
		this.errors.add(message);
	}

	/** Convenience method to add an offset to the result. */
	private void setOffset(ParseTree node, Integer offset) {
		this.result.setOffset(node, offset);
	}

	/** Convenience method to add a type to the result. */
	private void setType(ParseTree node, Type type) {
		this.result.setType(node, type);
	}

	/** Returns the type of a given expression or type node. */
	private Type getType(ParseTree node) {
		return this.result.getType(node);
	}

	/** Convenience method to add a flow graph entry to the result. */
	private void setEntry(ParseTree node, ParserRuleContext entry) {
		if (entry == null) {
			throw new IllegalArgumentException("Null flow graph entry");
		}
		this.result.setEntry(node, entry);
	}

	/** Returns the flow graph entry of a given expression or statement. */
	private ParserRuleContext entry(ParseTree node) {
		return this.result.getEntry(node);
	}
}
