package meeting12;

public class Warmup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("The array passed to set must only contain positive numbers.");
		}
		return factorialRecursive(n);
	}
	
	private static int factorialRecursive(int n) {
		if (n == 0)
			return 1;
		return factorialRecursive(n-1) * n;
	}

}
