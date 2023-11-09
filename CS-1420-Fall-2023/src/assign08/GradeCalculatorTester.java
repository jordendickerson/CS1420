package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTester {

	private GradeCalculator midSemesterScores;
	
	// This code executes before each test.
	// You can reference midSemesterScores in your tests without having to create it.
	@BeforeEach
	public void setup(){
		midSemesterScores = new GradeCalculator();
		midSemesterScores.addExamScore(64);
		midSemesterScores.addAssignmentScore(100);
		midSemesterScores.addAssignmentScore(95);
		midSemesterScores.addAssignmentScore(99);
		midSemesterScores.addAssignmentScore(82);
		midSemesterScores.addLabScore(90);
		midSemesterScores.addLabScore(100);
		midSemesterScores.addLabScore(80);
		midSemesterScores.addLabScore(70);
		midSemesterScores.addLabScore(90);
		midSemesterScores.addQuizScore(93);
		midSemesterScores.addQuizScore(100);
		midSemesterScores.addQuizScore(80);
	}
	
	@Test
	public void testGetAverageAssignmentScore() {
		assertEquals(94.0, midSemesterScores.getAverageAssignmentScore());
	}
	
	@Test
	public void testGetMedianAssignmentScore() {
		assertEquals(95, midSemesterScores.getMedianAssignmentScore());
	}
	
	@Test
	public void testGetNumberOfZeroAssignmentScores() {
		assertEquals(0, midSemesterScores.getNumberOfZeroAssignmentScores());
	}
	
	@Test
	public void testGetHighestAssignmentScore() {
		assertEquals(100, midSemesterScores.getHighestAssignmentScore());
	}
	
	@Test
	public void testGetLowestAssignmentScore() {
		assertEquals(82, midSemesterScores.getLowestAssignmentScore());
	}
	
	@Test
	public void testGetCourseGradeNumeric() {
		assertEquals(64, midSemesterScores.getCourseGradeNumeric());
	}
	
	@Test
	public void testGetCourseGradeLetter() {
		assertEquals("D", midSemesterScores.getCourseGradeLetter());
	}
	
	@Test
	public void testAddExamScoreNoAssignmentAverageChange() {
		double average = midSemesterScores.getAverageAssignmentScore();
		midSemesterScores.addExamScore(77);
		assertEquals(average, midSemesterScores.getAverageAssignmentScore(),
				"Adding an exam score changed assignment average score but should not have");
	}
	
	@Test
	public void testAddAssigmentScoreAssignmentAverageChange() {
		double average = midSemesterScores.getAverageAssignmentScore();
		midSemesterScores.addAssignmentScore(77);
		assertNotEquals(average, midSemesterScores.getAverageAssignmentScore(),
				"Adding an assignment score did not change assignment average score but should have");
	}
	
	// Add more tests, considering execution paths so far untested and edge cases.
	
	@Test
	public void testAddExamCourseGradeChange() {
		midSemesterScores.addExamScore(100);
		assertEquals("B+", midSemesterScores.getCourseGradeLetter());
	}
	
	@Test
	public void testEmptyArrayAverageAssignmentScore() {
		GradeCalculator empty = new GradeCalculator();
		assertThrows(NoSuchElementException.class,() -> { empty.getAverageAssignmentScore();});
	}
	
	@Test
	public void testEmptyArrayMedianAssignmentScore() {
	    GradeCalculator empty = new GradeCalculator();
	    assertThrows(NoSuchElementException.class, () -> { empty.getMedianAssignmentScore(); });
	}

	@Test
	public void testEmptyArrayNumberOfZeroAssignmentScores() {
	    GradeCalculator empty = new GradeCalculator();
	    assertThrows(NoSuchElementException.class, () -> { empty.getNumberOfZeroAssignmentScores(); });
	}

	@Test
	public void testEmptyArrayHighestAssignmentScore() {
	    GradeCalculator empty = new GradeCalculator();
	    assertThrows(NoSuchElementException.class, () -> { empty.getHighestAssignmentScore(); });
	}

	@Test
	public void testEmptyArrayLowestAssignmentScore() {
	    GradeCalculator empty = new GradeCalculator();
	    assertThrows(NoSuchElementException.class, () -> { empty.getLowestAssignmentScore(); });
	}
}