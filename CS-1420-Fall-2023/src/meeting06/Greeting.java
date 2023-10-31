package meeting06;
import java.util.Scanner;

public class Greeting {

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++)
			printHi();
		sayGreeting(11, "Albert");

	}
	
	public static void printHi() {
		System.out.println("Hi");
	}
	
	public static void sayGreeting(int hour, String name) {
		if (hour < 12)
			System.out.println("Good morning " + name);
		else
			System.out.println("Hi " + name);
	}
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	//The place of void in defining a method is to say what the function returns
	//return can also act as a break

}
