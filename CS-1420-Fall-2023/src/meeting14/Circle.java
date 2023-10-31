package meeting14;


/**
 * Creates a circle extended from the Shape2D class
 * 
 * @author Jorden Dickerson
 * @version Oct. 18, 2023
 */
public class Circle extends Shape2D {
	
	private double radius;
	
	public Circle(int posX, int posY, double rad) {
		super(posX, posY);
		radius = rad;
	}
	
	//Must override the abstract classes methods
	public double area() {
		return Math.PI * radius * radius;
	}
	
	public double perimeter() {
		return Math.PI * radius * 2;
	}
	
	//must use the interface method
	public void draw() {
		//TODO
	}
	
	public int compareTo(Shape2D other) {
		if(this.area() > other.area())
			return 1;
		else if (this.area() < other.area())
			return -1;
		
		return 0;
	}

}
