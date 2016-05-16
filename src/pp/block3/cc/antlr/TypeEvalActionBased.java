// Generated from C:/Users/Gebruiker/IdeaProjects/Paradigms/Paradigmes2/Paradigms/src/pp/block3/cc/antlr\MyCalcAttr.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.*;
import pp.block2.cc.ParseException;
import pp.block2.cc.antlr.ArithmeticLexer;
import pp.block2.cc.antlr.ArithmeticParser;

/**
 * This class provides an empty implementation of {@link MyCalcAttrVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 *  The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class TypeEvalActionBased extends MyCalcAttrBaseListener{

	private ParseTreeProperty<Type> type;

	public Type getType(String typeString) {
		try {
			CharStream stream = new ANTLRInputStream(typeString);
			Lexer lexer = new MyCalcAttrLexer(stream);
			MyCalcAttrParser parser = new MyCalcAttrParser(new CommonTokenStream(lexer));
			ParseTree tree = null;
			tree = parser.t();
			init();
			new ParseTreeWalker().walk(this, tree);
			return type.get(tree);
		}
		catch (ParseException e){
			e.printStackTrace();
			return Type.ERR;
		}
	}

	public void init() {
		this.type = new ParseTreeProperty<Type>();
	}

	@Override
	public void exitT(MyCalcAttrParser.TContext ctx) {
		set(ctx, ctx.type);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		System.out.println(1);
	}

	private void set(ParseTree node, Type typ) {
		this.type.put(node, typ);
	}

	public Type type(ParseTree node){
		return this.type.get(node);
	}



}
