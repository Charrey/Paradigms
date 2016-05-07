package pp.block2.cc.ll;



import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.SymbolFactory;

public class AbcParser implements Parser {
	public AbcParser() {
		this.fact = new SymbolFactory(abc.class);
	}

	private final SymbolFactory fact;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		this.tokens = lexer.getAllTokens();
		this.index = 0;
		return parseL();
	}

	private List<? extends Token> tokens;

	private AST parseL() throws ParseException {
		AST result = new AST(L);
		Token next = peek();
		switch (next.getType()) {
			//bij a en c hetzelfde doen
			case abc.SMALLA:
			case abc.SMALLC:
				result.addChild(parseR());
				result.addChild(parseToken(abc.SMALLA));
				break;
			case abc.SMALLB:
				result.addChild(parseToken(abc.SMALLB));
				result.addChild(parseQ());
				result.addChild(parseToken(abc.SMALLB));
				result.addChild(parseToken(abc.SMALLA));
				break;
			default:
				System.out.println(next.getType());
				throw unparsable(L);
		}
		return result;
	}

	private AST parseR() throws ParseException {
		AST result = new AST(R);
		Token next = peek();
		switch (next.getType()) {
			case abc.SMALLA:
				result.addChild(parseToken(abc.SMALLA));
				result.addChild(parseToken(abc.SMALLB));
				result.addChild(parseToken(abc.SMALLA));
				result.addChild(parseRp());
				break;
			case abc.SMALLC:
				result.addChild(parseToken(abc.SMALLC));
				result.addChild(parseToken(abc.SMALLA));
				result.addChild(parseToken(abc.SMALLB));
				result.addChild(parseToken(abc.SMALLA));
				result.addChild(parseRp());
				break;
			default:
				throw unparsable(R);
		}
		return result;
	}

	private AST parseRp() throws ParseException {
		AST result = new AST(RP);
		Token next = peek();
		switch (next.getType()) {
			case abc.SMALLB:
				result.addChild(parseToken(abc.SMALLB));
				result.addChild(parseToken(abc.SMALLC));
				break;
			default:
				//do nothing
		}
		return result;
	}

	private ParseException unparsable(NonTerm nt) {
		try {
			Token next = peek();
			return new ParseException(String.format(
					"Line %d:%d - could not parse '%s' at token '%s'",
					next.getLine(), next.getCharPositionInLine(), nt.getName(),
					this.fact.get(next.getType())));
		} catch (ParseException e) {
			return e;
		}
	}

	private AST parseQ() throws ParseException {
		AST result = new AST(Q);
		// there is only one rule, no need to look at the next token
		Token next = peek();
		switch (next.getType()) {
			case abc.SMALLB:
				result.addChild(parseToken(abc.SMALLB));
				result.addChild(parseToken(abc.SMALLC));
				break;
			case abc.SMALLC:
				result.addChild(parseToken(abc.SMALLC));
				break;
		}
		return result;
	}

	/** Creates an AST based on the expected token type. */
	private AST parseToken(int tokenType) throws ParseException {
		Token next = next();
		if (next.getType() != tokenType) {
			throw new ParseException(String.format(
					"Line %d:%d - expected token '%s' but found '%s'",
					next.getLine(), next.getCharPositionInLine(),
					this.fact.get(tokenType), this.fact.get(next.getType())));
		}
		return new AST(this.fact.getTerminal(tokenType), next);
	}

	/** Returns the next token, without moving the token index. */
	private Token peek() throws ParseException {
		if (this.index >= this.tokens.size()) {
			throw new ParseException("Reading beyond end of input");
		}
		return this.tokens.get(this.index);
	}

	/** Returns the next token and moves up the token index. */
	private Token next() throws ParseException {
		Token result = peek();
		this.index++;
		return result;
	}

	private int index;

	private static final NonTerm L = new NonTerm("L");
	private static final NonTerm R = new NonTerm("R");
	private static final NonTerm RP = new NonTerm("R'");
	private static final NonTerm Q = new NonTerm("Q");

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [text]+");
		} else {
			for (String text : args) {
				CharStream stream = new ANTLRInputStream(text);
				Lexer lexer = new abc(stream);
				try {
					System.out.printf("Parse tree: %n%s%n",
							new AbcParser().parse(lexer));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
