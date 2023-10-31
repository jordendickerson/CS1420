package assign07;

public class Armor extends Item{
	private int defense;
	private int condition;
	
	/**
	 * Creates an armor item with a name that is passed to the item superclass, an int for defense
	 * and an int for condition. It includes methods to give a detailed string of information about
	 * the item, a method to merge with another item of the same type, and a method to compare 
	 * to other items
	 * 
	 * @param name
	 * @param defense
	 * @param condition
	 */
	public Armor(String name, int defense, int condition) {
		super(name);
		this.defense = defense;
		this.condition = condition;
	}
	
	/**
	 * Returns a detailed string detailing the attributes of the armor item
	 */
	public String toString() {
		return "Armor: " + getName() + " - defense = " + this.defense + ", condition = " + this.condition;
	}
	
	/**
	 * Takes in an item and, if the item is of an armor type, adds the defenses and sets the condition
	 * to the maximum condition between the two items.
	 * 
	 * @param other
	 */
	public void merge(Item other) {
		if (other instanceof Armor) {
			this.defense += ((Armor) other).defense;
			this.condition = Math.max(this.condition, ((Armor) other).condition);
		}
	}
	
	/**
	 * Takes in another item  and compares it to the armor item. If it is of type tool, 
	 * the armor is less than. If it is of type Magic, the armor is greater than.
	 * If it is of type armor, it compares by taking 
	 * (defense x condition) - (other defense x other condition).
	 * If the value is positive, it is greater than the other object.
	 * If the value is negative, it is less than the other object.
	 * If the value is 0, the objects are equal.
	 */
	public int compareTo(Item other) {
		if (other instanceof Tool)
			return -1;
		else if (other instanceof Magic)
			return 1;
		
		return (this.defense * this.condition) - (((Armor) other).condition * ((Armor) other).defense);
		
	}
}
