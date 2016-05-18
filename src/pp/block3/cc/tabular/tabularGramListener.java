// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/tabular\tabularGram.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tabularGramParser}.
 */
public interface tabularGramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tabularGramParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(tabularGramParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link tabularGramParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(tabularGramParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link tabularGramParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(tabularGramParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link tabularGramParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(tabularGramParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link tabularGramParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(tabularGramParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link tabularGramParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(tabularGramParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link tabularGramParser#lastentry}.
	 * @param ctx the parse tree
	 */
	void enterLastentry(tabularGramParser.LastentryContext ctx);
	/**
	 * Exit a parse tree produced by {@link tabularGramParser#lastentry}.
	 * @param ctx the parse tree
	 */
	void exitLastentry(tabularGramParser.LastentryContext ctx);
}