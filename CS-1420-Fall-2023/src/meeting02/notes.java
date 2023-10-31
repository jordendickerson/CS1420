package meeting02;
import java.util.Scanner;

public class notes {

	public static void main(String[] args) {
		//Initialise the scanner
		Scanner input = new Scanner(System.in);
		
		//Prompt the user for an integer
		System.out.println("Enter an integer:");
		int number = input.nextInt();
		System.out.println("You entered: " + number);

		//Add code to output the number as a double-typed value
		System.out.println("As a double, " + number + " is " + (double)number);
		
		System.out.println("Enter a floating-point value");
		double userDouble = input.nextDouble();
		
		System.out.println("As an integer, " + userDouble + " is " + (int)userDouble);
		
		//Code to output the string inputted by the user
		System.out.println("Enter a string:");
		String userString = input.next();
		
		System.out.println("The amount of characters in " + userString + " is " + userString.length());
		
		//close the scanner
		input.close();
	}

}
