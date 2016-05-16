// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/antlr\MyCalc.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyCalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyCalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MyCalcParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(MyCalcParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MyCalcParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(MyCalcParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHat(MyCalcParser.HatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(MyCalcParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code brackets}
	 * labeled alternative in {@link MyCalcParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrackets(MyCalcParser.BracketsContext ctx);
}