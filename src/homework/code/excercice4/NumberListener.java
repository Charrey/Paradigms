// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/homework/hans/excercice4\Number.g4 by ANTLR 4.5.1
package homework.code.excercice4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NumberParser}.
 */
public interface NumberListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NumberParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(NumberParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumberParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(NumberParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumberParser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(NumberParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumberParser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(NumberParser.SeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumberParser#prf}.
	 * @param ctx the parse tree
	 */
	void enterPrf(NumberParser.PrfContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumberParser#prf}.
	 * @param ctx the parse tree
	 */
	void exitPrf(NumberParser.PrfContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumberParser#dig}.
	 * @param ctx the parse tree
	 */
	void enterDig(NumberParser.DigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumberParser#dig}.
	 * @param ctx the parse tree
	 */
	void exitDig(NumberParser.DigContext ctx);
}