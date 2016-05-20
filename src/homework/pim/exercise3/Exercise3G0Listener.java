package homework.pim.exercise3;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Exercise3G0Parser}.
 */
public interface Exercise3G0Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Exercise3G0Parser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(Exercise3G0Parser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link Exercise3G0Parser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(Exercise3G0Parser.EContext ctx);
	/**
	 * Enter a parse tree produced by {@link Exercise3G0Parser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(Exercise3G0Parser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link Exercise3G0Parser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(Exercise3G0Parser.FContext ctx);
	/**
	 * Enter a parse tree produced by {@link Exercise3G0Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterT(Exercise3G0Parser.TContext ctx);
	/**
	 * Exit a parse tree produced by {@link Exercise3G0Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitT(Exercise3G0Parser.TContext ctx);
}