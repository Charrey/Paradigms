package homework.code.excercice5;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.Type;
import pp.block3.cc.antlr.TypeEvalActionBased;
import pp.block3.cc.antlr.TypeEvalListenerBased;
import pp.block3.cc.tabular.HTMLGenerator;
import pp.block3.cc.tabular.tabularGramLexer;
import pp.block3.cc.tabular.tabularGramParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class EmoteTest {

	private final TypeEvalActionBased typeEval = new TypeEvalActionBased();
	private final TypeEvalListenerBased typeEval2 = new TypeEvalListenerBased();

	String testStringOk = "( geek\n" +
			"  ^geek ^prick geek!\n" +
			"  ( ^prick prick!? )\n" +
			"  ( ^slag ^geek slag? (^slag slag!?) geek!! (slag!) )\n" +
			"  prick! )\n" +
			"prick\n";

	String testStringErr = "a bunch of ordinary words!";

	@Test
	public void testOk() throws IOException, InterruptedException {
		EmoteChecker emoteChecker = new EmoteChecker();
		CharStream stream = new ANTLRInputStream(testStringOk);
		Lexer lexer = new EmoteLexer(stream);
		EmoteParser parser = new EmoteParser(new CommonTokenStream(lexer));
		ParseTree parseTree = parser.text();
		System.out.println(emoteChecker.check(parseTree));;
		sleep(1000);
	}

	@Test
	public void testErr() throws IOException, InterruptedException {
		EmoteChecker emoteChecker = new EmoteChecker();
		CharStream stream = new ANTLRInputStream(testStringErr);
		Lexer lexer = new EmoteLexer(stream);
		EmoteParser parser = new EmoteParser(new CommonTokenStream(lexer));
		ParseTree parseTree = parser.text();
		System.out.println(emoteChecker.check(parseTree));;
		sleep(1000);
	}
}
