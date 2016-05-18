package pp.block3.cc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pp.block3.cc.symbol.MySymbolTable;
import pp.block3.cc.symbol.SymbolTable;

public class SymbolTableTest {
	private SymbolTable table;

	@Before
	public void initTable() {
		table = new MySymbolTable<Integer>();
	}

	@Test
	public void testEmpty() {
		try {
			this.table.contains("aap");
		} catch (RuntimeException e) {
			Assert.fail("Using an empty table should not fail");
			// this is the expected behaviour
		}
		try {
			this.table.closeScope();
			Assert.fail("Closing the top-level scope should fail");
		} catch (RuntimeException e) {
			// this is the expected behaviour
		}
		this.table.openScope();
		this.table.closeScope();
		try {
			this.table.closeScope();
			Assert.fail("Closing the top-level scope should fail");
		} catch (RuntimeException e) {
			// this is the expected behaviour
		}
	}

	@Test
	public void testLookup() {
		assertFalse(this.table.contains("aap"));
		assertTrue(this.table.add("aap",1));
		assertTrue(this.table.contains("aap"));
		assertFalse(this.table.add("aap",2));
		assertFalse(this.table.contains("noot"));
		this.table.openScope();
		assertTrue(this.table.contains("aap"));
		assertFalse(this.table.contains("noot"));
		assertTrue(this.table.add("aap",3));
		assertTrue(this.table.add("noot",2));
		this.table.closeScope();
		assertTrue(this.table.contains("aap"));
		assertFalse(this.table.contains("noot"));
	}

	@Test
	public void testNesting() {
		this.table.openScope();
		assertTrue(this.table.add("aap",2));
		this.table.openScope();
		assertTrue(this.table.add("aap",2));
		this.table.openScope();
		assertTrue(this.table.contains("aap"));
		assertTrue(this.table.add("noot",5));
		assertTrue(this.table.contains("noot"));
		this.table.closeScope();
		assertFalse(this.table.contains("noot"));
		this.table.openScope();
		assertFalse(this.table.contains("noot"));
		assertTrue(this.table.add("noot",3));
		assertTrue(this.table.contains("noot"));
		this.table.closeScope();
		assertFalse(this.table.contains("noot"));
		this.table.closeScope();
		this.table.closeScope();
		assertFalse(this.table.contains("aap"));
		assertFalse(this.table.contains("noot"));
	}
}
