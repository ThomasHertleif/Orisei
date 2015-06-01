package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Suffix;

public class SuffixTest {

	@Test
	public void noExt() {
		Suffix suffix = new Suffix("-essen");
		assertEquals(suffix.makeNewName("toll"), "toll-essen");
	}
	
	@Test
	public void withExt() {
		Suffix suffix = new Suffix("-essen");
		assertEquals(suffix.makeNewName("pasta.md"), "pasta-essen.md");
	}
	
	@Test
	public void withNull() {
		Suffix suffix = new Suffix(null);
		assertEquals(suffix.makeNewName("pasta.md"), "pasta.md");
		
		Suffix suffix2 = new Suffix("-bier");
		assertEquals(suffix2.makeNewName(null), null);
	}

}
