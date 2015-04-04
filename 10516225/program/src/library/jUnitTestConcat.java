package library;

import static org.junit.Assert.*;

import org.junit.Test;

public class jUnitTestConcat {

	@Test
	public void test() {
		Librarian test2 = new Librarian();
	String actual =	test2.concatenateName("Jane", " Austin");
	String expected = "Jane Austin";
	assertEquals(expected, actual);
		
	}

}
