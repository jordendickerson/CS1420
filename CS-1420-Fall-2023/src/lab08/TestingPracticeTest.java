package lab08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestingPracticeTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
	    double result = TestingPractice.averageInRange(new int[]{1,3,5}, 1, 21);
	    assertEquals(3, result, "Failed 10 plus 20");
	}
	
	@Test
	void testAverageInRange() {
		
	}
}
