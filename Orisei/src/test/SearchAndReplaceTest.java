package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.SearchAndReplace;

public class SearchAndReplaceTest {

	@Test
	public void trivial() {
		SearchAndReplace sAr = new SearchAndReplace("Test", "Lester");
		assertEquals(sAr.makeNewName("Test"), "Lester");
	}
	
	@Test
	public void noMatch() {
		SearchAndReplace sAr = new SearchAndReplace("Test", "Lester");
		assertEquals(sAr.makeNewName("Jim Beam"), "Jim Beam");
	}
	
	@Test
	public void handleNull() {
		SearchAndReplace sAr = new SearchAndReplace("Test", "Lester");
		assertEquals(sAr.makeNewName(null), null);
	}

}
