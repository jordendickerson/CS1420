package meeting09;

/**
 * This class represents a fraction; e.g., 1/2.
 * A Fraction has a numerator and denominator
 * 
 * @author Jorden Dickerson
 * @version September 20,2023
 */

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction (int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
}
