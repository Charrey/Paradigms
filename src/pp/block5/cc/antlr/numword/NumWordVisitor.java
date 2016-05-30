// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block5/cc/antlr\NumWord.g4 by ANTLR 4.5.1
package pp.block5.cc.antlr.numword;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NumWordParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NumWordVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NumWordParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(NumWordParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(NumWordParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(NumWordParser.WordContext ctx);
}