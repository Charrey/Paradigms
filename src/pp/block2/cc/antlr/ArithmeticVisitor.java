// Generated from C:/Users/poesd_000/IdeaProjects/Paradigms/src/pp/block2/cc/antlr\Arithmetic.g4 by ANTLR 4.5.1
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArithmeticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArithmeticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ArithmeticParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ArithmeticParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(ArithmeticParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ArithmeticParser.FactorContext ctx);
}