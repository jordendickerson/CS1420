package assign08;

import java.util.NoSuchElementException;

/**
 * 
 * 
 * @author Jorden Dickerson
 * @version Nov. 7, 2023
 */
public class GradeCalculator {
	private DynamicArray examsArray;
	private DynamicArray assignmentsArray;
	private DynamicArray labsArray;
	private DynamicArray quizArray;
	
	public GradeCalculator() {
		examsArray = new DynamicArray();
		assignmentsArray = new DynamicArray();
		labsArray = new DynamicArray();
		quizArray = new DynamicArray();
	}
	
	/**
	 * Appends a score to the end of the exams array
	 * @param score - the int score to be added
	 */
	public void addExamScore(int score) {
		examsArray.append(score);
	}
	
	/**
	 * Appends a score to the end of the labs array
	 * @param score - the int score to be added
	 */
	public void addLabScore(int score) {
		labsArray.append(score);
	}
	
	/**
	 * Appends a score to the end of the quiz array
	 * @param score - the int score to be added
	 */
	public void addQuizScore(int score) {
		quizArray.append(score);
	}
	
	/**
	 * Appends a score to the end of the assignments array
	 * @param score - the int score to be added
	 */
	public void addAssignmentScore(int score) {
		assignmentsArray.append(score);
	}
	
	/**
	 * Gets the average of the scores in assignments array
	 * @return the average
	 */
	public double getAverageAssignmentScore() {
		int size = assignmentsArray.size();
		if (size < 1)
			throw new NoSuchElementException();
		
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += assignmentsArray.getElement(i);
		}
		return (double)sum / (double)size;
	}
	
	/**
	 * Divides the size of assignments array and gets the element a that index
	 * @return the median
	 */
	public int getMedianAssignmentScore() {
		if (assignmentsArray.size() < 1)
			throw new NoSuchElementException();
		
		int median;
		if (assignmentsArray.size() % 2 == 0) {
			median = assignmentsArray.getElement((assignmentsArray.size() / 2) - 1);
		}else {
			median = assignmentsArray.getElement((assignmentsArray.size() - 1) / 2);
		}
		
		return median;
	}
	
	/**
	 * Loops through each score and counts the number of zero scores
	 * 
	 * @return the amount of zero scores
	 */
	public int getNumberOfZeroAssignmentScores() {
		if (assignmentsArray.size() < 1)
			throw new NoSuchElementException();
		
		int count = 0;
		for (int i = 0; i < assignmentsArray.size(); i++) {
			if (assignmentsArray.getElement(i) == 0)
				count++;
		}
		
		return count;
	}
	
	/**
	 * Sorts the array and grabs the highest element
	 * 
	 * @return the highest score
	 */
	public int getHighestAssignmentScore() {
		if (assignmentsArray.size() < 1)
			throw new NoSuchElementException();
		
		DynamicArray tempArray = assignmentsArray;
		tempArray.sort();
		
		return tempArray.getElement(tempArray.size() - 1);
	}
	
	/**
	 * Sorts the array and grabs the lowest element
	 * 
	 * @return the lowest score
	 */
	public int getLowestAssignmentScore() {
		if (assignmentsArray.size() < 1)
			throw new NoSuchElementException();
		
		DynamicArray tempArray = assignmentsArray;
		tempArray.sort();
		
		return tempArray.getElement(0);
	}
	
	/**
	 * Gets the averages of all arrays, and weighs them into a final grade.
	 * If the exam average is below 65, the grade is the exam average.
	 * 
	 * @return the final grade
	 */
	public double getCourseGradeNumeric() {
		double assignAverage = getAverageAssignmentScore();
		double examAverage = getAverageExamScore();
		double labAverage = getAverageLabScore();
		double quizAverage = getAverageQuizScore();
		double finalGrade = 0;
		
		if (examAverage >= 65.0) {
			finalGrade += ((examAverage * .45));
			finalGrade += assignAverage * .35;
			finalGrade += labAverage * .10;
			finalGrade += quizAverage * .10;
		}else {
			finalGrade = examAverage;
		}
		
		return finalGrade;
	}
	
	/**
	 * Takes the final grade score from getCourseGradeNumeric and 
	 * converts it to a letter grade.
	 * 
	 * @return the letter grade
	 */
	public String getCourseGradeLetter() {
		double finalGrade = getCourseGradeNumeric();
		String letterGrade = "";
		
		if (93 <= finalGrade && finalGrade <= 100)
			letterGrade = "A";
		else if(90 <= finalGrade && finalGrade < 93)
			letterGrade = "A-";
		else if(87 <= finalGrade && finalGrade < 90)
			letterGrade = "B+";
		else if(83 <= finalGrade && finalGrade < 87)
			letterGrade = "B";
		else if(80 <= finalGrade && finalGrade < 83)
			letterGrade = "B-";
		else if(77 <= finalGrade && finalGrade < 80)
			letterGrade = "C+";
		else if(73 <= finalGrade && finalGrade < 77)
			letterGrade = "C";
		else if(70 <= finalGrade && finalGrade < 73)
			letterGrade = "C-";
		else if(67 <= finalGrade && finalGrade < 70)
			letterGrade = "D+";
		else if(63 <= finalGrade && finalGrade <67)
			letterGrade = "D";
		else if(60 <= finalGrade && finalGrade < 63)
			letterGrade = "D-";
		else if(finalGrade < 60)
			letterGrade = "E";
		
		return letterGrade;
	}
	
	/**
	 * Gets the average of the scores in exams array
	 * @return the average
	 */
	private double getAverageExamScore() {
		int size = examsArray.size();
		if (size < 1)
			throw new NoSuchElementException();
		
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += examsArray.getElement(i);
		}
		return (double)sum / (double)size;
	}
	
	/**
	 * Gets the average of the scores in labs array
	 * @return the average
	 */
	private double getAverageLabScore() {
		int size = labsArray.size();
		if (size < 1)
			throw new NoSuchElementException();
		
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += labsArray.getElement(i);
		}
		return (double)sum / (double)size;
	}
	
	/**
	 * Gets the average of the scores in exams array
	 * @return the average
	 */
	private double getAverageQuizScore() {
		int size = quizArray.size();
		if (size < 1)
			throw new NoSuchElementException();
		
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += quizArray.getElement(i);
		}
		return (double)sum / (double)size;
	}
	
}
