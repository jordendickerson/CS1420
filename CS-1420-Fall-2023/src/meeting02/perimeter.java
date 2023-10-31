package meeting02;
import java.util.Scanner;


public class perimeter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the length of the rectangle: ");
		int length = input.nextInt();
		
		System.out.print("Enter the width of the rectangle: ");
		int width = input.nextInt();
		
		int perimeter = (length * 2) + (width * 2);
		int area = length * width;
		
		System.out.println("The perimeter of the rectangle is: " + perimeter);
		System.out.println("The area of the rectangle is: " + area);
	}

}
