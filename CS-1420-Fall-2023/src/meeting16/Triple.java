package meeting16;

public class Triple<T> {
	
	private T item1;
	private T item2;
	private T item3;
	
	public Triple(T item1, T item2, T item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	public T getFirstItem() {
		return item1;
	}
	
	public void setFirstItem(T newItem1) {
		this.item1 = newItem1;
	}
	
	public void setSecondItem(T newItem2) {
		this.item2 = newItem2;
	}
	
	public void setThirdItem(T newItem3) {
		this.item3 = newItem3;
	}
	
}
