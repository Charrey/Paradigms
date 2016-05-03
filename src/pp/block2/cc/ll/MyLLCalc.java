package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.*;

/**
 * Created by poesd_000 on 26/04/2016.
 */
public class MyLLCalc implements LLCalc{


    public final Grammar grammar;

    private Map<Symbol, Set<Term>> first;
    private Map<NonTerm, Set<Term>> follow;
    private Map<Rule, Set<Term>> firstplus;
    private Boolean isll1 = null;



    public MyLLCalc(Grammar g) {
        this.grammar = g;
    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        if (first != null) {
            return first;
        }
        first = new HashMap<>();
        for (Term i : grammar.getTerminals()) {
            HashSet<Term> toadd = new HashSet<>();
            toadd.add(i);
            first.put(i, toadd);
        }
        first.put(Term.EMPTY, new HashSet<>());
        first.get(Term.EMPTY).add(Term.EMPTY);
        first.put(Term.EOF, new HashSet<>());
        first.get(Term.EOF).add(Term.EOF);

        for (NonTerm i : grammar.getNonterminals()) {
            first.put(i, new HashSet<>());
        }
        boolean changing = true;
        while(changing) {
            changing = false;
            for (Rule p : grammar.getRules()) {
                Set<Term> rhs = new HashSet<>(first.get(p.getRHS().get(0)));
                rhs.remove(Term.EMPTY);
                int i = 0;
                while(i<p.getRHS().size()-1 && first.get(p.getRHS().get(i)).contains(Term.EMPTY)) {
                    Set<Term> setwoe = first.get(p.getRHS().get(i));
                    setwoe.remove(Term.EMPTY);
                    rhs.addAll(setwoe);
                    i+=1;
                }
                if (i==p.getRHS().size()-1 && first.get(p.getRHS().get(i)).contains(Term.EMPTY)){
                    rhs.add(Term.EMPTY);
                }
                int sizefirst = first.get(p.getLHS()).size();
                first.get(p.getLHS()).addAll(rhs);
                if (first.get(p.getLHS()).size() > sizefirst) {
                    changing = true;
                }
            }
        }
        return first;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        if (follow!=null) {
            return follow;
        }
        follow = new HashMap<>();
        for (NonTerm i : grammar.getNonterminals()) {
            follow.put(i, new HashSet<>());
        }
        follow.get(grammar.getStart()).add(Term.EOF);

        for (Rule p : grammar.getRules()) {
            Set<Term> trailer = new HashSet<>(follow.get(p.getLHS()));
            for (int i = p.getRHS().size()-1; i>=0; i--) {
                if (p.getRHS().get(i) instanceof NonTerm) {
                    follow.get(p.getRHS().get(i)).addAll(trailer);
                    if (getFirst().get(p.getRHS().get(i)).contains(Term.EMPTY)) {
                        Set<Term> firstbiwithout = new HashSet<>(getFirst().get(p.getRHS().get(i)));
                        firstbiwithout.remove(Term.EMPTY);
                        trailer.addAll(firstbiwithout);
                    } else {
                        trailer = new HashSet<>(first.get(p.getRHS().get(i)));
                    }

                } else {
                    trailer = new HashSet<>(first.get(p.getRHS().get(i)));
                }
            }
        }
        return follow;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        if (firstplus!=null) {
            return firstplus;
        }
        firstplus = new HashMap<>();
        for (Rule p : grammar.getRules()) {
            firstplus.put(p, new HashSet<>(getFirst().get(p.getRHS().get(0))));
            if (getFirst().get(p.getRHS().get(0)).contains(Term.EMPTY)) {
                firstplus.get(p).addAll(follow.get(p.getLHS()));
            }
        }
        return firstplus;
    }

    @Override
    public boolean isLL1() {
        Map<NonTerm, Set<Term>> test = new HashMap<>();
        for (NonTerm i : grammar.getNonterminals()) {
            test.put(i, new HashSet<>());
        }
        for (Rule p : grammar.getRules()) {
            assert(getFirstp().get(p)!=null);
            if (Collections.disjoint(getFirstp().get(p), test.get(p.getLHS()))) {
                test.get(p.getLHS()).addAll(getFirstp().get(p));
            } else {
                return false;
            }
        }
        return true;
    }
}
