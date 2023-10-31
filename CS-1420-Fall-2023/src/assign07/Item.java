package assign07;
//TODO: Write javadocs
public abstract class Item implements Comparable<Item>{
	private String name;
	
	public Item(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void merge(Item other);
}
