// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block5/cc/antlr\NumWord.g4 by ANTLR 4.5.1
package pp.block5.cc.antlr.numword;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NumWordParser}.
 */
public interface NumWordListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NumWordParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(NumWordParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(NumWordParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumWordParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(NumWordParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(NumWordParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumWordParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(NumWordParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(NumWordParser.WordContext ctx);
}