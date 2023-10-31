package assign03;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * For calculating grades based on a text file
 * 
 * @author Jorden Dickerson and CS 1420
 * @version Sep 13, 2023
 */
public class GradeCalculator {
	
	/**
	 * Calculates a grade based on a text file.
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args){
		//Initialise scanner variables
		Scanner input = new Scanner(System.in);
		boolean doesFileExist = false;
		String filename;
		File file;
		Scanner fileScanner = new Scanner(System.in);
		
		//if the user inputs a nonexistent file, loop back and ask for another filename
		while (!doesFileExist) {
			System.out.println("Enter the file name");
			filename = input.nextLine();
			file = new File(filename);
			try {
				fileScanner = new Scanner(file);
				doesFileExist = true;
			}catch (FileNotFoundException e) {
				System.out.println(e);
			}
			
		}
		
		//create the variables for the first four lines
		double examAverage = fileScanner.nextDouble();
		double labAverage = fileScanner.nextDouble();
		double quizAverage = fileScanner.nextDouble();
		int numberOfAssignments = fileScanner.nextInt();
		
		//initialise assignments array and add scores to it
		int[] assignmentsArray = new int[numberOfAssignments];
		int index = 0;
		
		while (fileScanner.hasNext()) {
			assignmentsArray[index] = fileScanner.nextInt();
			index++;
		}
		
		//sort the assignment scores
		Arrays.sort(assignmentsArray);
		
		//find the average score on assignments
		double scoreSum = 0;
		
		for (int i = 0; i < numberOfAssignments; i++) {
			scoreSum += assignmentsArray[i];
		}
		double assignAverage = scoreSum / numberOfAssignments;
		
		//find the median score
		int median;
		if (numberOfAssignments % 2 == 0) {
			median = assignmentsArray[numberOfAssignments / 2];
		}else {
			median = assignmentsArray[(numberOfAssignments - 1) / 2];
		}
		
		//find the number of 0 score assignments
		int zeroScores = 0;
		for (int i = 0; i < numberOfAssignments; i++) {
			if (assignmentsArray[i] == 0)
				zeroScores++;
		}
		
		
		//Calculate the final grade
		
		double finalGrade = 0;
		
		if (examAverage >= 65.0) {
			finalGrade += ((examAverage * .45));
			finalGrade += assignAverage * .35;
			finalGrade += labAverage * .10;
			finalGrade += quizAverage * .10;
		}else {
			finalGrade = examAverage;
		}
		
		
		
		//Determine the letter grade
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
		
		int highestGrade = assignmentsArray[assignmentsArray.length - 1];
		int lowestGrade = assignmentsArray[0];
		
		//Print information
		System.out.printf("Average assignment score: %1.2f", assignAverage);
		System.out.println();
		System.out.printf("Median assignment score: %s", median);
		System.out.println();
		System.out.printf("Number of 0 assignment score: %s", zeroScores);
		System.out.println();
		System.out.printf("Highest assignent score: %s", highestGrade);
		System.out.println();
		System.out.printf("Lowest assignment score: %s", lowestGrade);
		System.out.println();
		System.out.printf("Course grade (numeric): %1.2f", finalGrade);
		System.out.println();
		System.out.printf("Course grade (letter): %s", letterGrade);
		
		
		input.close();
		fileScanner.close();		
	}

}
