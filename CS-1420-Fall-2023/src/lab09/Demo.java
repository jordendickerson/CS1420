package lab09;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("Cleetus", "Jenkins", 123489, 2.4);
		Student s2 = new Student("Qualgus", "McGalgus", 431211, 4.0);
		int result = s1.compareTo(s2);
		if(result > 0)
		   System.out.println("The first student's GPA is larger.");
		else if(result < 0)
		   System.out.println("The second student's GPA is larger.");
		else
		   System.out.println("Both students have the same GPA.");
	}

}
