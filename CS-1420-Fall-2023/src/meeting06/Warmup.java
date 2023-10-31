package meeting06;

public class Warmup {
	
//a method
	public static void main(String[] args) {
		int[] numbers = new int[] {1,4,3,3 ,2, 1, 2 ,15};
		int threshold = 5;
		int indexOfFirstGreater = indexOfNumberGreaterThan(threshold, numbers);
		
		int[] testArray = {1,2,3,4,5,5};
		System.out.println(testArray[7]);
		
		System.out.println("Index of the first number greater than " + threshold + ": [" + indexOfFirstGreater + "]");

	}
	
	public static int indexOfNumberGreaterThan(int threshold, int[] numberArray) {
		for (int i = 0; i < numberArray.length; i++)
			if (numberArray[i] > threshold)
				return i;
		return -1;
	}

}
