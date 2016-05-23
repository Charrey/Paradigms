// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/homework/hans/excercice3\Ex3Grammar.g4 by ANTLR 4.5.1
package homework.code.excercice3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Ex3GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Ex3GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Ex3GrammarParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(Ex3GrammarParser.EContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex3GrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(Ex3GrammarParser.FContext ctx);
	/**
	 * Visit a parse tree produced by {@link Ex3GrammarParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(Ex3GrammarParser.TContext ctx);
}