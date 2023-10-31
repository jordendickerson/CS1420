package assign05;

/**
 * This class creates a rectangle object
 * 
 * @author Jorden Dickerson
 * @version October 4th, 2023
 */

public class Rectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * Creates a default rectangle when the user does not input parameters
	 */
	public Rectangle() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.height = 1;
	}
	
	/**
	 * Creates a rectangle with user-specified parameters
	 * 
	 * @param positionX - x coordinate of the top left corner
	 * @param positionY - y coordinate of the top left corner
	 * @param width - the width of the rectangle
	 * @param height - the height of the rectangle
	 */
	public Rectangle(int positionX, int positionY, int width, int height) {
		this.x = positionX;
		this.y = positionY;
		this.width = width;
		this.height = height;
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
	 * Gets the width
	 * @return the width
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Gets the height
	 * @return the height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Moves the rectangle to a new coordinate position
	 * 
	 * @param newX - the new x coordinate (int)
	 * @param newY - the new y coordinate (int)
	 */
	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}
	
	/**
	 * Scales the rectangle by the provided factors
	 * 
	 * @param xFactor - the factor to scale x by
	 * @param yFactor - the factor to scale y by
	 */
	public void scale(double xFactor, double yFactor) {
		this.width = (int)(this.width * xFactor);
		this.height = (int)(this.height * yFactor);
	}
	
	/**
	 * Compares 2 rectangles to see which is larger
	 * 
	 * @param other - the other rectangle
	 * @return true if the other is smaller, false if not
	 */
	public boolean largerThan (Rectangle other) {
		return ((this.width * this.height) > (other.width * other.height));
	}
	
	/**
	 * Creates a new rectangle that encapsulates both rectangles
	 * 
	 * @param other - the other rectangle
	 * @return A new rectangle that surrounds the two rectangles
	 */
	public Rectangle boundingRectangle(Rectangle other) {
		int xCoord = Math.min(this.x, other.x);
		int yCoord = Math.min(this.y, other.y);
		int maxXCoord = Math.max(this.x + this.width, other.x + other.width); 
		int newWidth = maxXCoord - xCoord;
		int maxYCoord = Math.max(this.y + this.height, other.y + other.height);
		int newHeight = maxYCoord - yCoord;
		return new Rectangle(xCoord, yCoord, newWidth, newHeight);
	}
	
	/**
	 * Provides information about the rectangle as a string
	 * 
	 */
	public String toString() {
		return this.width + " x " + this.height + " rectangle at (" + this.x + ", " + this.y + ")";
	}
}
