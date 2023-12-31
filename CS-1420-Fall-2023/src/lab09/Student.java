package lab09;

public class Student implements Comparable<Student>{
	private String firstName;
	private String lastName;
	private int id;
	private double gpa;
	
	public Student(String firstName, String lastName, int id, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.gpa = gpa;
	}
	
	public String toString() {
		return ("Name: " + this.firstName + " " + this.lastName + ", Student ID: " + this.id + ", GPA: " + this.gpa);
	}

	public int compareTo(Student other) {
		int result = this.lastName.compareTo(other.lastName);
		   if(result == 0)
		      return this.firstName.compareTo(other.firstName); 
		   return result;
	}
	
}
