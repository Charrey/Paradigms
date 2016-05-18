// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/symbol\DeclUse.g4 by ANTLR 4.5.1
package pp.block3.cc.symbol;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DeclUseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DeclUseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DeclUseParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DeclUseParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclUseParser#series}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeries(DeclUseParser.SeriesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unitdeclare}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitdeclare(DeclUseParser.UnitdeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unituse}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnituse(DeclUseParser.UnituseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unitseries}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitseries(DeclUseParser.UnitseriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclUseParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(DeclUseParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeclUseParser#use}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse(DeclUseParser.UseContext ctx);
}