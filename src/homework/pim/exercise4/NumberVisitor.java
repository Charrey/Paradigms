// Generated from C:/Users/poesd_000/IdeaProjects/Paradigms/src/homework/pim/exercise4\Number.g4 by ANTLR 4.5.1
package homework.pim.exercise4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NumberParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NumberVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NumberParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(NumberParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumberParser#seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(NumberParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumberParser#prf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrf(NumberParser.PrfContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumberParser#dig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDig(NumberParser.DigContext ctx);
}