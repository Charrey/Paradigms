// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/tabular\tabularGram.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tabularGramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tabularGramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tabularGramParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(tabularGramParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link tabularGramParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(tabularGramParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link tabularGramParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(tabularGramParser.EntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link tabularGramParser#lastentry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastentry(tabularGramParser.LastentryContext ctx);
}