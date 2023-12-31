package meeting13;

public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	public String receiptString() {
		return this.name + " : $" + this.price;
	}
	
	public String infoString() {
		return "Item: " + this.name + " : $" + this.price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}

}
