package pp.iloc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

@SuppressWarnings("javadoc")
public class SimulatorTest {


	@Test
	public void testSimulator(){
		Program p = parse("max");
		Machine m = new Machine();
		Simulator s = new Simulator(p,m);
		s.getVM().init("a",1,3,2,5,4);
		s.getVM().setNum("alength",5);
		s.run();
		assertEquals(5,m.getReg("r_max"));
	}

	@Test
	public void testFib1(){
		assertEquals(getFibonacci1(17), 1597);
		assertEquals(getFibonacci1(33), 3524578);
		assertEquals(getFibonacci1(10), 55);
	}

	@Test
	public void testFib2() {
		assertEquals(getFibonacci2(17), 1597);
		assertEquals(getFibonacci2(33), 3524578);
		assertEquals(getFibonacci2(10), 55);
	}

	public int getFibonacci1(int n) {
		Program p = parse("fibReg");
		Machine m = new Machine();
		Simulator s = new Simulator(p,m);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		s.setOut(out);
		s.getVM().setNum("limit",n);
		//47 yields overflow
		s.run();
		try (Scanner scan = new Scanner(out.toString())) {
			return Integer.parseInt(scan.findInLine("[\\d-]+"));
		}
	}

	public int getFibonacci2(int n) {
		Program p = parse("fibMem");
		Machine m = new Machine();
		Simulator s = new Simulator(p,m);
		s.getVM().init("a", 1);
		s.getVM().init("b", 1);
		s.getVM().setNum("limit",n);
		//47 yields overflow
		s.run();
		return (s.getVM().load(0));
	}


	/*
	@Test(timeout = 1000)
	public void testFig13() {
		Program p = parse("fig1-3");
		Machine c = new Machine();
		int a = c.init("a", 2);
		c.init("b", 3);
		c.init("c", 4);
		c.init("d", 5);
		new Simulator(p, c).run();
		if (SHOW) {
			System.out.println(c);
		}
		assertEquals(240, c.load(a));
	}


	@Test(timeout = 1000)
	public void testFig13Stack() {
		Program p = parse("fig1-3-stack");
		Machine c = new Machine();
		int a = c.init("a", 2);
		c.init("b", 3);
		c.init("c", 4);
		c.init("d", 5);
		new Simulator(p, c).run();
		if (SHOW) {
			System.out.println(c);
		}
		assertEquals(240, c.load(a));
	}

	@Test(timeout = 1000)
	public void testFig13Init() {
		Program p = parse("fig1-3-init");
		Machine c = new Machine();
		c.store(2, p.getSymb("a"));
		c.store(3, p.getSymb("b"));
		c.store(4, p.getSymb("c"));
		c.store(5, p.getSymb("d"));
		new Simulator(p, c).run();
		if (SHOW) {
			System.out.println(c);
			System.out.println(p.prettyPrint());
		}
		assertEquals(240, c.load(p.getSymb("a")));
	}

	@Test(timeout = 1000)
	public void testString() {
		Program p = parse("string");
		Simulator sim = new Simulator(p);
		sim.setIn(new ByteArrayInputStream("abc".getBytes()));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		sim.setOut(out);
		sim.run();
		if (SHOW) {
			System.out.println(p.prettyPrint());
		}
		assertEquals("Doubled: abcabc", out.toString().trim());
	}

	@Test
	//(timeout = 1000)
	public void testStringChar4() {
		Program p = parse("string4");
		Simulator sim = new Simulator(p);
		sim.getVM().setCharSize(4);
		sim.setIn(new ByteArrayInputStream("abc".getBytes()));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		sim.setOut(out);
		sim.run();
		if (SHOW) {
			System.out.println(p.prettyPrint());
		}
		assertEquals("Doubled: abcabc", out.toString().trim());
	}
	*/

	Program parse(String filename) {
		File file = new File(filename + ".iloc");
		if (!file.exists()) {
			file = new File(BASE_DIR + filename + ".iloc");
		}
		try {
			return Assembler.instance().assemble(file);
		} catch (FormatException | IOException e) {
			fail(e.getMessage());
			return null;
		}
	}

	private final static String BASE_DIR = "src/pp/iloc/sample/";
	private final static boolean SHOW = true;
}
