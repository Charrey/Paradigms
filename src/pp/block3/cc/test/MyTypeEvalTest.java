package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;
import pp.block2.cc.ParseException;
import pp.block3.cc.antlr.*;
import pp.block3.cc.antlr.CalcAttrParser.ExprContext;

import static org.junit.Assert.assertEquals;

public class MyTypeEvalTest {

	private final TypeEvalActionBased typeEval = new TypeEvalActionBased();
	private final TypeEvalListenerBased typeEval2 = new TypeEvalListenerBased();


	@Test
	public void testCorrectAB() {
		assertEquals(Type.BOOL, typeEval.getType("1==1"));
		assertEquals(Type.NUM, typeEval.getType("1+1"));
		assertEquals(Type.NUM, typeEval.getType("1^1"));
		assertEquals(Type.STR, typeEval.getType("\"1==1\""));
	}

	//Next time, we can just use assertFail and we don't need to throw the exception in the variable.
	@Test
	public void testErrorAB() {
		assertEquals(Type.ERR, typeEval.getType("3^True"));
		assertEquals(Type.ERR, typeEval.getType("3^\"3\""));
	}

	@Test
	public void testCorrectLB() {
		assertEquals(Type.BOOL, typeEval2.getType("1==1"));
		assertEquals(Type.NUM, typeEval2.getType("1+1"));
		assertEquals(Type.NUM, typeEval2.getType("1^1"));
		assertEquals(Type.STR, typeEval2.getType("\"1==1\""));
	}

	@Test
	public void testErrorLB() {
		assertEquals(Type.ERR, typeEval2.getType("3^True"));
		assertEquals(Type.ERR, typeEval2.getType("3^\"3\""));
	}
}
