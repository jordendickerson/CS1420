package assign05;

/**
 * This class creates a circle object
 * 
 * @author Jorden Dickerson
 * @version October 4th, 2023
 */
public class Circle {
	private int x;
	private int y;
	private int radius;
	
	/**
	 * Creates a default circle when the user does not input parameters
	 */
	public Circle() {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}
	
	/**
	 * Creates a circle with user specified parameters
	 * 
	 * @param positionX - the x coordinate of the circle
	 * @param positionY - the y coordinate of the circle
	 * @param radius - the radius of the circle
	 */
	public Circle(int positionX, int positionY, int radius) {
		this.x = positionX;
		this.y = positionY;
		this.radius = radius;
	}
	
	/**
	 * Gets the x coordinate
	 * @return the x coordinate
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets the y coordinate
	 * @return the y coordinate
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Gets the radius of the circle
	 * @return the radius
	 */
	public int getRadius() {
		return this.radius;
	}
	
	/**
	 * Moves the circle to a new coordinate position
	 * 
	 * @param newX - the new x coordinate (int)
	 * @param newY - the new y coordinate (int)
	 */
	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}
	
	/**
	 * Scales the circle by a factor
	 * @param factor - the factor to scale by
	 */
	public void scale(double factor) {
		this.radius = (int)(this.radius * factor);
	}
	
	/**
	 * Compares 2 circles to see which is larger
	 * 
	 * @param other - the other circle
	 * @return true if the other is smaller, false if not
	 */
	public boolean largerThan (Circle other) {
		return ((this.radius) > (other.radius));
	}
	
	/**
	 * Creates a bounding rectangle around the circle
	 * @return the bounding rectangle
	 */
	public Rectangle boundingRectangle() {
		return new Rectangle(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
	}
	
	/**
	 * Creates a bounding rectangle around two circles
	 * 
	 * @param other - the other circle
	 * @return a bounding rectangle around two circles
	 */
	public Rectangle boundingRectangle(Circle other) {
		int xCoord = Math.min(this.x - this.radius, other.x - other.radius);
		int yCoord = Math.min(this.y - this.radius, other.y - other.radius);
		int maxXCoord = Math.max(this.x + this.radius, other.x + other.radius);
		int maxYCoord = Math.max(this.y + this.radius, other.y + other.radius);
		int newWidth = maxXCoord - xCoord;
		int newHeight = maxYCoord - yCoord;
		return new Rectangle(xCoord, yCoord, newWidth, newHeight);
	}
	
	public String toString() {
		return "r = " + this.radius + " circle at (" + this.x + ", " + this.y + ")";
	}
}
