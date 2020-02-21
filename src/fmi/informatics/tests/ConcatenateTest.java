package fmi.informatics.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ConcatenateTest {

	public String concatenate(String one, String two) {
		return one + two;
	}

	@Test
	public void testConcatenate() {
		String result = concatenate("one", "two");
		String expectedResult = "onetwo";

		assertEquals(expectedResult, result);
	}

	@Test
	public void testConcatenateFailed() {
		fail("Not yet implemented!");
	}
}