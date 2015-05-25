package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Count;
import Model.Position;

public class CountTest {

	@Test
	public void defaultCase() {
		Count counter = new Count(42);
		assertEquals("42test.txt", counter.makeNewName("test.txt"));
	}

	@Test
	public void beforeCase() {
		Count counter = new Count(42, Position.Before);
		assertEquals("42test.txt", counter.makeNewName("test.txt"));
	}

	@Test
	public void afterCase() {
		Count counter = new Count(42, Position.After);
		assertEquals("test.txt42", counter.makeNewName("test.txt"));
	}

	@Test
	public void failCase() {
		Count counter = new Count(-10, Position.After);
		assertNotEquals("42test.txt", counter.makeNewName("test.txt"));
	}

}
