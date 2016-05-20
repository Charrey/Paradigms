package homework.pim.exercise5;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EmoteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EmoteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EmoteParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(EmoteParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wordItem}
	 * labeled alternative in {@link EmoteParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWordItem(EmoteParser.WordItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textItem}
	 * labeled alternative in {@link EmoteParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextItem(EmoteParser.TextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code raiseItem}
	 * labeled alternative in {@link EmoteParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaiseItem(EmoteParser.RaiseItemContext ctx);
}