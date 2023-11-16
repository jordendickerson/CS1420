package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the SlidePuzzleFrame class.
 * 
 * @author Prof. Heisler and ?
 * @version ?
 */
public class SlidePuzzleFrameTest {  
	
	@Test
	public void testStartInUnsolvedState() { 
		SlidePuzzleFrame frame = new SlidePuzzleFrame();
		assertFalse(frame.isSolved());
	}
}