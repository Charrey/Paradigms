package homework.pim.exercise5;

/** Store and tests for nested scopes of variable declarations.
 * A newly constructed {@link SymbolTable} should consist of a single
 * (outer) scope. 
 */
public interface SymbolTable<R> {
	/** Adds a next deeper scope level. */
	void openScope();

	/** Removes the deepest scope level.
	 * @throws RuntimeException if the table only contains the outer scope.
	 */
	void closeScope();

	/** Tries to declare a given identifier in the deepest scope level.
	 * @return <hans>true</hans> if the identifier was added,
	 * <hans>false</hans> if it was already declared in this scope.
	 */
	boolean add(String id, R rec);

	/** Tests if a given identifier is in the scope of any declaration.
	 * @return <hans>true</hans> if there is any enclosing scope in which
	 * the identifier is declared; <hans>false</hans> otherwise.
	 */
	boolean contains(String id);
}
