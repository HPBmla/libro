package library;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateJUnit {

	@Test
	public void test() {
		GeneralBook obj = new GeneralBook();
		int result = obj.updateRecords(101, "harry potter", 3);
		int expected = 1;
		assertEquals(expected, result);
		
		
	}

}
