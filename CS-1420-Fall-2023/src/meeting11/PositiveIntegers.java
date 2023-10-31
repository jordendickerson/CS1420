package meeting11;

/**
 * THIS CLASS REPRESENTS A COLLECITON OF POSITIVE INTEGERS
 * 
 * @author Jorden Dickerson
 * @version October 2, 2023
 */

public class PositiveIntegers {

	private int[] data;
	
	public PositiveIntegers(int[] data) {
		this.data = new int[data.length];
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 1) {
				throw new IllegalArgumentException("The array passed to set must only contain positive numbers.");
			}
			this.data[i] = data[i];	
		}
			
	}
	
	public void set(int index, int value) {
		//IllegalArgumentException e = new IllegalArgumentException("The value passed to set must be positive.");
		if (value < 1)
			throw new IllegalArgumentException("The value passed to set must be positive.");
		this.data[index] = value;
	}

}
