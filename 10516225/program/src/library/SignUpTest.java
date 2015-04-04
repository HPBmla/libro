package library;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignUpTest {

	@Test
	public void test() {
		Librarian libTest = new Librarian();
		int result = libTest.signUp("madhi", "hewa", "3", "Main", "colombo", "0112233456", "123456789v", "mhewa", "12345");
		int expected = 1;
		assertEquals(expected, result);
	}

}
