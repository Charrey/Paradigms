// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/symbol\DeclUse.g4 by ANTLR 4.5.1
package pp.block3.cc.symbol;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DeclUseParser}.
 */
public interface DeclUseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DeclUseParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DeclUseParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#series}.
	 * @param ctx the parse tree
	 */
	void enterSeries(DeclUseParser.SeriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#series}.
	 * @param ctx the parse tree
	 */
	void exitSeries(DeclUseParser.SeriesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unitdeclare}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnitdeclare(DeclUseParser.UnitdeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unitdeclare}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnitdeclare(DeclUseParser.UnitdeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unituse}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnituse(DeclUseParser.UnituseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unituse}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnituse(DeclUseParser.UnituseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unitseries}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnitseries(DeclUseParser.UnitseriesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unitseries}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnitseries(DeclUseParser.UnitseriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(DeclUseParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(DeclUseParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#use}.
	 * @param ctx the parse tree
	 */
	void enterUse(DeclUseParser.UseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#use}.
	 * @param ctx the parse tree
	 */
	void exitUse(DeclUseParser.UseContext ctx);
}