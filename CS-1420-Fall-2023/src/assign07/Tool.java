package assign07;

public class Tool extends Item{
	private int power;

	/**
	 * Creates a Tool object extended from the Item superclass. It takes in a name parameter,
	 * which is passed into the superclass, and a power parameter.
	 * It contains methods to return a detailed string, merge with an item of the same type,
	 * and compare to other items.
	 * 
	 * @param name
	 * @param power
	 */
	public Tool(String name, int power) {
		super(name);
		this.power = power;
	}
	
	/**
	 * Returns a detailed string detailing the attributes of the Tool item
	 */
	public String toString() {
		return "Tool: " + getName() + " - power = " + this.power;
	}
	
	/**
	 * Takes in an item and, if the item is of a tool type, adds the powers of the items.
	 * 
	 * @param other
	 */
	public void merge(Item other) {
		if (other instanceof Tool) {
			this.power += ((Tool) other).power;
		}
	}
	
	/**
	 * Takes in an item and, if the other item is not of tool type, returns greater than.
	 * If the item is of tool type, it compares the powers of both items and returns
	 * a positive integer if this item is greater, a 0 if they are equal, and a negative
	 * integer if this item is smaller.
	 */
	public int compareTo(Item other) {
		if (other instanceof Magic || other instanceof Armor)
			return 1;
		
		if (this.power > ((Tool) other).power)
			return 1;
		else if(this.power == ((Tool) other).power)
			return 0;
		else
			return -1;
		
	}
}
