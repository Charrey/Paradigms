package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

public class LLCalcTest {
	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testSentenceOrig() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
	}

	@Test
	public void testSentenceExtended() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
		// Now add the last rule, causing the grammar to fail
		// Define the non-terminals
		NonTerm subj = g.getNonterminal("Subject");
		NonTerm obj = g.getNonterminal("Object");
		NonTerm sent = g.getNonterminal("Sentence");
		NonTerm mod = g.getNonterminal("Modifier");
		g.addRule(mod, mod, mod);
		// Define the terminals
		Term adj = g.getTerminal(Sentence.ADJECTIVE);
		Term noun = g.getTerminal(Sentence.NOUN);
		Term verb = g.getTerminal(Sentence.VERB);
		Term end = g.getTerminal(Sentence.ENDMARK);
		LLCalc calc = createCalc(g);
		// FIRST sets
		Map<Symbol, Set<Term>> first = calc.getFirst();
		assertEquals(set(adj, noun), first.get(sent));
		assertEquals(set(adj, noun), first.get(subj));
		assertEquals(set(adj, noun), first.get(obj));
		assertEquals(set(adj), first.get(mod));
		// FOLLOW sets
		Map<NonTerm, Set<Term>> follow = calc.getFollow();
		assertEquals(set(Symbol.EOF), follow.get(sent));
		assertEquals(set(verb), follow.get(subj));
		assertEquals(set(end), follow.get(obj));
		assertEquals(set(noun, adj), follow.get(mod));
		// FIRST+ sets: test per rule
		Map<Rule, Set<Term>> firstp = calc.getFirstp();
		List<Rule> subjRules = g.getRules(subj);
		assertEquals(set(noun), firstp.get(subjRules.get(0)));
		assertEquals(set(adj), firstp.get(subjRules.get(1)));
		// is-LL1-test
		assertFalse(calc.isLL1());
	}

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {
		System.out.println(g);
		return new MyLLCalc(g);
	}


	@Test
	public void testIf () {
		Grammar g = Grammars.makeIf();
		System.out.println(g);
		// Define the non-terminals
		NonTerm stat = g. getNonterminal ("Stat" );
		NonTerm elsePart = g. getNonterminal ("ElsePart" );
		// Define the terminals
		Term ifT = g.getTerminal(If.IF);
		Term thenT = g.getTerminal(If.THEN);
		Term condT = g.getTerminal(If.COND);
		Term elseT = g.getTerminal(If.ELSE);
		Term assignT = g.getTerminal(If.ASSIGN);


		Term eof = Symbol.EOF ;
		Term empty = Symbol.EMPTY ;
		LLCalc calc = createCalc (g );
		// FIRST
		Map<Symbol, Set<Term>> first = calc.getFirst();
		assertEquals(set(assignT, ifT), first.get(stat));
		assertEquals(set(elseT, empty), first.get(elsePart));
		// FOLLOW
		Map <NonTerm , Set<Term>> follow = calc.getFollow();
		assertEquals(set(eof, elseT), follow.get(stat));
		assertEquals(set(eof), follow.get(elsePart));
		// FIRSTP
		Map <Rule , Set<Term>> firstp = calc.getFirstp();
		List<Rule>elsePartRules = g.getRules(elsePart);
		assertEquals(set(elseT), firstp.get(elsePartRules.get(0)));
		assertEquals(set(empty, eof), firstp.get(elsePartRules.get(1)));
		assertTrue(calc.isLL1());
	}


	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
}
