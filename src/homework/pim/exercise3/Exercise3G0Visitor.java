package homework.pim.exercise3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Exercise3G0Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Exercise3G0Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Exercise3G0Parser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(Exercise3G0Parser.EContext ctx);
	/**
	 * Visit a parse tree produced by {@link Exercise3G0Parser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(Exercise3G0Parser.FContext ctx);
	/**
	 * Visit a parse tree produced by {@link Exercise3G0Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(Exercise3G0Parser.TContext ctx);
}