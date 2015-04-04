package library;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteProfTest {

	@Test
	public void test() {
		Librarian obj = new Librarian();
		int result = obj.deleteProfileDetails("Lochana");
		int expected = 1;
		assertEquals( expected, result);
	}

}
