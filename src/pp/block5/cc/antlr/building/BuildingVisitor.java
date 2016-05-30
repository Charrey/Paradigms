// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block5/cc/antlr\Building.g4 by ANTLR 4.5.1
package pp.block5.cc.antlr.building;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BuildingParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BuildingVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BuildingParser#building}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuilding(BuildingParser.BuildingContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#floor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloor(BuildingParser.FloorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#room}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoom(BuildingParser.RoomContext ctx);
}