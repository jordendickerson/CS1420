package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the SlidePuzzleFrame class.
 * 
 * @author Prof. Heisler and Jorden Dickerson
 * @version 11/16/2023
 */
public class SlidePuzzleFrameTest {  
	
	@Test
	public void testStartInUnsolvedState() { 
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		assertFalse(frame.isSolved());
	}
	
	/**
	 * Tests that solve changes it to a solved state
	 */
	@Test
	public void testSolve() {
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		frame.solve();
		assertTrue(frame.isSolved());
	}
	/**
	 * Tests that shuffle changes it to an unsolved state
	 */
	@Test
	public void testShuffle() {
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		frame.solve();
		frame.shuffle();
		assertFalse(frame.isSolved());
	}
}