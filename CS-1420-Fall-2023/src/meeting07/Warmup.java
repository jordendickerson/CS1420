package meeting07;

/**
 * @author Jorden Dickerson
 * @version Sep 13, 2023
 */

public class Warmup {
	
	/**
	 * Divides the input in half
	 * @param input the value being halved
	 * @return half of the input value as a double
	 */
	
	public static double half(int input) {
		return input * 0.5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double halved = half(3);
		System.out.println(halved);
		
		double[] prices = new double[20];
		
		int count = 0;
		for (int i = 0; i < prices.length; i ++) {
			System.out.println(count);
			count++;
		}
	}

}
