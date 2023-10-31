package meeting09;

public class OOPCourse {

	public static void main(String[] args) {
		int studentCount = 365;
		Student[] students = new Student[studentCount];
		
		students[0] = new Student("eric", 14, "eric@utah.edu");
		
		
		Fraction f = new Fraction(1,2);
		System.out.println(f.getNumerator());
	}
}
