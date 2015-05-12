package test;
import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Test;

import Model.File;


public class FileTest {

	@Test
	public void test() {
		File file = new File(Paths.get("z:/random/file.text"));
		assertEquals(file.getName(), "file.text");
	}

}
