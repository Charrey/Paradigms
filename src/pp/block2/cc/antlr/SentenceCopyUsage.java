package pp.block2.cc.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class SentenceCopyUsage {
	public static void main(String[] args) {
		parse();
	}

	public static void parse(){
		// Convert the input text to a character stream
		CharStream stream = new ANTLRInputStream("all, smart, undergraduate students love compilers.");
		// Build a lexer on top of the character stream
		Lexer lexer = new SentenceCopyLexer(stream);
		// Extract a token stream from the lexer
		TokenStream tokens = new CommonTokenStream(lexer);
		// Build a parser instance on top of the token stream
		SentenceCopyParser parser = new SentenceCopyParser(tokens);
		// Get the parse tree by calling the start rule
		ParseTree tree = parser.sentence();
		// Print the (formatted) parse tree
		System.out.println(tree.toStringTree(parser));





		// Convert the input text to a character stream
		CharStream stream2 = new ANTLRInputStream("all smart undergraduate students love compilers.");
		// Build a lexer on top of the character stream
		Lexer lexer2 = new SentenceLexer(stream2);
		// Extract a token stream from the lexer
		TokenStream tokens2 = new CommonTokenStream(lexer2);
		// Build a parser instance on top of the token stream
		SentenceParser parser2 = new SentenceParser(tokens2);
		// Get the parse tree by calling the start rule
		ParseTree tree2 = parser2.sentence();
		// Print the (formatted) parse tree
		System.out.println(tree2.toStringTree(parser2));
	}
}
