package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.Tree;
import org.junit.Test;
import pp.block3.cc.antlr.*;
import pp.block3.cc.antlr.CalcAttrParser.ExprContext;
import pp.block3.cc.tabular.tabularGramLexer;
import pp.block3.cc.tabular.tabularGramParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class TabularTest {

	@Test
	public void test() throws IOException, InterruptedException {
		for (int i = 1; i <= 5; i++) {
			System.out.println("------    FILE"+ i + "    ------\n");
			FileReader reader = new FileReader(new File(getClass().getResource("tabular-" + i + ".tex").getPath()));
			CharStream stream = new ANTLRInputStream(reader);
			Lexer lexer = new tabularGramLexer(stream);
			tabularGramParser parser = new tabularGramParser(new CommonTokenStream(lexer));
			ParseTree parseTree = parser.table();
			System.out.println(parseTree.toStringTree(parser));
			System.out.println("-------------------------\n\n\n");
			sleep(1000);
		}
	}
}
