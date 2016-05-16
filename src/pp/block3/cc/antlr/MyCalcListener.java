// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/antlr\MyCalc.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import pp.block2.cc.ParseException;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyCalcParser}.
 */
public interface MyCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void enterNumber(MyCalcParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void exitNumber(MyCalcParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void enterBool(MyCalcParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void exitBool(MyCalcParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void enterString(MyCalcParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void exitString(MyCalcParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equals}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void enterEquals(MyCalcParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void exitEquals(MyCalcParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hat}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void enterHat(MyCalcParser.HatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void exitHat(MyCalcParser.HatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void enterPlus(MyCalcParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void exitPlus(MyCalcParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code brackets}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void enterBrackets(MyCalcParser.BracketsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code brackets}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 */
	void exitBrackets(MyCalcParser.BracketsContext ctx);
}