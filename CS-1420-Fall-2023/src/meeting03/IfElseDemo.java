package meeting03;

public class IfElseDemo {

	public static void main(String[] args) {
		boolean isStudent = true;
		int age = 20;
		
		if (isStudent)
			System.out.println("I'm a student");
		else
			System.out.println("I'm not a student");
		
		if (age < 10 && isStudent)
			System.out.println("I'm the Youngest student");
		
		if (age < 10) {
			System.out.println("I'm still a kid,");
			System.out.println("and I know Java!");
		}
		
		if (age > 23)
			System.out.println("I was born before 2000");
	}

}
