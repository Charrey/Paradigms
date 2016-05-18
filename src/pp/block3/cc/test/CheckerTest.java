package pp.block3.cc.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pp.block3.cc.symbol.DeclUseChecker;
import pp.block3.cc.symbol.MySymbolTable;
import pp.block3.cc.symbol.SymbolTable;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckerTest {
	private SymbolTable table;

	DeclUseChecker declUseChecker = new DeclUseChecker();
	List<String> errorlist;

	@Test
	public void testEmpty() {
	}

	@Test
	public void testLookup() {
		System.out.println(declUseChecker.getErrorList(new File(getClass().getResource("test.txt").getPath())).toString());
	}

}
