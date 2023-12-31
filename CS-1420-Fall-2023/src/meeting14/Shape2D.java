package meeting14;

public abstract class Shape2D implements Drawable, Comparable<Shape2D> {

	private int xPos;
	private int yPos;
	
	public Shape2D(int posX, int posY) {
		xPos = posX;
		yPos = posY;
	}
	
	public abstract double area();
	public abstract double perimeter();
}
