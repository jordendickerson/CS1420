package meeting04;
import java.util.Scanner;

public class Warmup {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		if (number == 0)
			System.out.println("Zero");
		else if (number % 2 == 0)
			System.out.println("Even");
		else
			System.out.println("Odd");

	}

}
