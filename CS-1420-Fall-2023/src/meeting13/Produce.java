package meeting13;

//subclass can only extend ONE superclass
public class Produce extends Item {

	private String country;
	
	public Produce(String name, double price, String country) {
		//subclass constructor should call superclass constructor FIRST
		super(name, price);
		this.country = country;
	}
	
	public String infoString() {
		return "Produce: " + getName() + ", $" + getPrice() + ", product of " + country + ".";
	}
}
