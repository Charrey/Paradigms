/**
 * 
 */
package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammars {
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeSentence() {
		// Define the non-terminals
		NonTerm sent = new NonTerm("Sentence");
		NonTerm subj = new NonTerm("Subject");
		NonTerm obj = new NonTerm("Object");
		NonTerm mod = new NonTerm("Modifier");
		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(Sentence.class);
		Term noun = fact.getTerminal(Sentence.NOUN);
		Term verb = fact.getTerminal(Sentence.VERB);
		Term adj = fact.getTerminal(Sentence.ADJECTIVE);
		Term end = fact.getTerminal(Sentence.ENDMARK);
		// Build the context free grammar
		Grammar g = new Grammar(sent);
		g.addRule(sent, subj, verb, obj, end);
		g.addRule(subj, noun);
		g.addRule(subj, mod, subj);
		g.addRule(obj, noun);
		g.addRule(obj, mod, obj);
		g.addRule(mod, adj);
		return g;
	}

	public static Grammar makeIf() {
		// Define the non-terminals
		NonTerm stat = new NonTerm("Stat");
		NonTerm elsepart = new NonTerm("ElsePart");
		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(If.class);
		Term assignt = fact.getTerminal(If.ASSIGN);
		Term ift = fact.getTerminal(If.IF);
		Term exprt = fact.getTerminal(If.COND);
		Term thent = fact.getTerminal(If.THEN);
		Term elset = fact.getTerminal(If.ELSE);
		// Build the context free grammar
		Grammar g = new Grammar(stat);
		g.addRule(stat, assignt);
		g.addRule(stat, ift, exprt, thent, stat, elsepart);
		g.addRule(elsepart, elset, stat);
		g.addRule(elsepart, Term.EMPTY);
		return g;
	}

	public static Grammar makeAbc() {
		// Define the non-terminals
		NonTerm L = new NonTerm("L");
		NonTerm R = new NonTerm("R");
		NonTerm Rp = new NonTerm("R'");
		NonTerm Q = new NonTerm("Q");
		SymbolFactory fact = new SymbolFactory(abc.class);
		Term a = fact.getTerminal(abc.SMALLA);
		Term b = fact.getTerminal(abc.SMALLB);
		Term c = fact.getTerminal(abc.SMALLC);
		// Build the context free grammar
		Grammar g = new Grammar(L);
		g.addRule(L, R, a);
		g.addRule(L, b, Q, b, a);
		g.addRule(R, a, b, a, Rp);
		g.addRule(R, c, a, b, a, Rp);
		g.addRule(Rp, b, c, Rp);
		g.addRule(Rp, Term.EMPTY);
		g.addRule(Q, b, c);
		g.addRule(Q, c);
		return g;
	}
}
