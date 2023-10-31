//CS 1420 Assignment 1 by Jorden Dickerson (September 6, 2023)

package assign02;
import java.util.Scanner;

public class FortuneTeller {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//get name
		System.out.println("Enter your name ('exit' to exit): ");
		String name = input.nextLine();
		
		while (!name.equals("exit")) {
			//get lucky number
			int sum = 0;
			for (int i = 0; i < name.length(); i++) {
				sum += name.charAt(i);
			}
			//calculate fortunes
			int happiness = (sum % 42) / 7;
			int career = (sum % 18) / 3;
			int love = (sum % 66) / 11;
			String fortune;
			
			if (happiness + career + love > 7)
				fortune = "good";
			else
				fortune = "bad";
			
			//print fortunes
			System.out.println("Your fortune is " + fortune);
			System.out.println("Happiness: " + happiness);
			System.out.println("Career: " + career);
			System.out.println("Love: " + love);
			System.out.println("Lucky number: " + sum);
			
			//get name again
			System.out.println("Enter your name ('exit' to exit): ");
			name = input.nextLine();
		}
		System.out.println("Goodbye");
		input.close();
		
		}

}
