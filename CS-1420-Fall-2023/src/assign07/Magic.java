package assign07;

public class Magic extends Item{
	private int power;
	private int cost;
	
	/**
	 * Creates a magic item extended from the Item superclass. The magic item class has a String name,
	 * int power variable, and an int cost variable. Includes methods to output as a string, merge
	 * with items of the same type, and compare to other items.
	 * 
	 * @author Jorden Dickerson
	 * @version Oct. 26, 2023
	 * @param name - The name of the Magic Item
	 * @param power - The power of the item
	 * @param cost - the cost of the item
	 */
	public Magic(String name, int power, int cost) {
		super(name);
		this.power = power;
		this.cost = cost;
	}
	
	/**
	 * Gives a detailed description of the Magic item and it's attributes
	 * 
	 * @return - A string containing the name, power, and cost of the item.
	 */
	public String toString() {
		return "Magic: " + getName() + " - power = " + this.power + ", cost = " + cost;
	}

	/**
	 * Merges the item with another item if it is of the same type, if not, nothing is done
	 * 
	 * @param other - the other item to be merged
	 */
	public void merge(Item other) {
		if (other instanceof Magic) {
			this.power += ((Magic) other).power;
			this.cost++;
		}
	}
	
	/**
	 * Compares the item to another item. If the other item is of Magic type, it 
	 * will compare the ratios of the power to cost and return a value
	 * based on which one has the greater ratio. If the other item is of the 
	 * tool or armor type, it will return less than. It returns
	 * a positive integer if this item is greater, a 0 if they are equal, and a negative
	 * integer if this item is smaller.
	 * 
	 * @param other - the other item to be compared.
	 */
	public int compareTo(Item other) {
		if (other instanceof Tool || other instanceof Armor)
			return -1;
		
		double thisRatio = (double)this.power / (double)this.cost;
		double otherRatio = (double)((Magic) other).power / (double)((Magic) other).cost;
		
		if (thisRatio > otherRatio)
			return 1;
		else if (thisRatio == otherRatio)
			return 0;
		else
			return -1;
		
	}
}
