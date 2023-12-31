package assign04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * s creating methods and Javadoc comments by creating 7 methods:
 * kilometersToMiles, powerOfTwo, shiftCipher, countIntegerZeros, averageInRange, generateArray, and binaryToDecimal.
 * 
 * @author Jorden Dickerson
 * @version September 28th, 2023
 */
public class MethodPractice {
	

	public static void main(String[] args) {
		System.out.println("Checking kilometersToMiles(10.11). Expecting a result of 6. "
				+ "The actual result is " + kilometersToMiles(10.11));
		
		System.out.println("Checking powerOfTwo(10). Expecting a result of 1024. "
				+ "The actual result is " + powerOfTwo(10) + ".");
		
		System.out.println("Checking shiftCipher(\"hello\", 3). "
				+ "Expecting a result of khoor. "
				+ "The actual result is " + shiftCipher("hello", 3) + ".");
		
		System.out.println("Checking countIntegerZeros(new Scanner(\"hello 0 10 0.0 string0 0\"). "
				+ "Expecting a result of 2. The actual result is " 
				+ countIntegerZeros(new Scanner("hello 0 10 0.0 string0 0")) + ".");
		
		System.out.println("Checking averageInRange(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 5) "
				+ "Expecting a result of 4.5. The actual result is "
				+ averageInRange(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 5));
		
		System.out.println("Checking generateArray(5). Expecting a result of [0, 1, 2, 3, 4]. "
				+ "The actual result is " + Arrays.toString(generateArray(5)) + ".");
		
		System.out.println("Checking binaryToDecimal(\"1010\"). Expecting a result of 10. "
				+ "The actual result is " + binaryToDecimal("1010"));
		
	}
	
	/**
	 * Converts a kilometer amount into miles and rounds down to the nearest integer.
	 * 
	 * @param kilometers - the amount of kilometres to be converted to miles
	 * @return the amount of kilometers in miles, rounded down to the nearest integer
	 */
	public static int kilometersToMiles(double kilometers) {
		double miles = kilometers / 1.60934;
		
		return (int)miles;
	}
	
	
	/**
	 * Raises 2 to an exponent provided by the user
	 * 
	 * @param exponent - the power to raise 2 to
	 * @return the result of 2 raised to the exponent
	 */
	public static int powerOfTwo(int exponent) {
		if (exponent <= 0) {
			return 1;
		}else {
			int sum = 2;
			for (int i = 1; i<exponent; i++) {
				sum *= 2;
			}
			return sum;
		}
	}
	
	
	/**
	 * Takes a message and shifts it by a certain amount
	 * 
	 * @param message - the message to be shifted
	 * @param amount - the amount to shift by
	 * @return - the shifted message
	 */
	public static String shiftCipher(String message, int amount) {
		char[] lineChars = message.toCharArray();
		String shiftedMessage = "";
		
		for (int i = 0; i < lineChars.length; i++) {
			//shift character
        	lineChars[i] = (char)(lineChars[i] + amount);
        	
        	//if character is out of range, loop back to 32
        	if (lineChars[i] > 126) {
        		lineChars[i] = (char)(31 + (lineChars[i] - 126));
        	}
        	
        	shiftedMessage += lineChars[i];
		}
		
		return shiftedMessage;
	}
	
	
	/**
	 * 
	 * Counts the number of zeros in a scanner
	 * 
	 * @param scanner - the scanner containing the things to be read
	 * @return the count of zeros in the scanner
	 */
	public static int countIntegerZeros(Scanner scanner) {
		int count = 0;
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
                int nextNumber = scanner.nextInt();
                if (nextNumber == 0)
                    count++;
            } else {
                scanner.next();
            }
		}
		return count;
	}
	
	
	/**
	 * Takes a range of numbers in an array and returns the average
	 * 
	 * @param array - the array of numbers
	 * @param beginIndex - the beginning of the range
	 * @param endIndex - the end of the range (inclusive)
	 * @return the average of the numbers in the range
	 */
	public static double averageInRange(int[] array, int beginIndex, int endIndex) {
		double sum = 0;
		double divisor = (endIndex - beginIndex) + 1;
		if (divisor < 0 || beginIndex < 0 || endIndex > array.length - 1){
			return 0.0;
		}
		
		for (int i = beginIndex; i <= endIndex; i++) {
			sum += array[i];

		}
		
		double average = sum / divisor;
		
		return average;
		
	}
	
	/**
	 * Generates an array where each index's value is the number of the index
	 * @param length - the length of the array
	 * @return the array
	 */
	public static int[] generateArray(int length) {
		int[] array = new int[length];
		
		for (int i = 0; i < length; i++) {
			array[i] = i;
		}
		
		return array;
	}
	
	/**
	 * Takes a string of binary code and converts it to an integer
	 * 
	 * @param binary - the string of binary
	 * @return the binary converted to an integer
	 */
	public static int binaryToDecimal(String binary) {
		int sum = 0;
		int exponent = binary.length() - 1;
		
		for (int i = 0; i < binary.length(); i++) {
			char num = binary.charAt(i);
			
			if (num == '1') {
				sum += powerOfTwo(exponent);
			}
			exponent--;
		}
		
		return sum;
	}

}
