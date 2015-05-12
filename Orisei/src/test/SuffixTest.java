package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Suffix;

public class SuffixTest {

	@Test
	public void test() {
		Suffix suffix = new Suffix("-essen");
		assertEquals(suffix.makeNewName("toll"), "toll-essen");
	}

}
