package pp.block2.cc.test;

import org.junit.Assert;
import org.junit.Test;
import pp.block2.cc.ParseException;
import pp.block2.cc.antlr.ExpressionEval;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class ExpressionEvalTest {

	@Test
	public void testSentence() {
		ExpressionEval eval = new ExpressionEval();
		try {
			assertEquals(eval.evaluate("1"), new BigInteger("1"));
			assertEquals(eval.evaluate("100+3"), new BigInteger("103"));
			assertEquals(eval.evaluate("100*(1+2)"), new BigInteger("300"));
			assertEquals(eval.evaluate("2*2^3"), new BigInteger("16"));
			assertEquals(eval.evaluate("1^(2)^0"), new BigInteger("1"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}



}
