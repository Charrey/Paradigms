package pp.block3.cc.test;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.block3.cc.tabular.HTMLGenerator;
import pp.block3.cc.tabular.tabularGramLexer;
import pp.block3.cc.tabular.tabularGramParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class HTMLGeneratorTest {

	@Test
	public void test() throws IOException, InterruptedException {
		HTMLGenerator htmlGenerator = new HTMLGenerator();
		for (int i = 1; i <= 5; i++) {
			System.out.println("------    FILE"+ i + "    ------\n");
			FileReader reader = new FileReader(new File(getClass().getResource("tabular-" + i + ".tex").getPath()));
			CharStream stream = new ANTLRInputStream(reader);
			Lexer lexer = new tabularGramLexer(stream);
			tabularGramParser parser = new tabularGramParser(new CommonTokenStream(lexer));
			ParseTree parseTree = parser.table();
			System.out.println(htmlGenerator.generateHTML(parseTree));
			sleep(1000);
		}
	}
}
