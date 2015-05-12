package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Prefix;

public class PrefixTest {

	@Test
	public void test() {
		Prefix prefix = new Prefix("nicht-");
		assertEquals(prefix.makeNewName("toll.txt"), "nicht-toll.txt");
	}

}
