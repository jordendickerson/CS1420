package lab06;

public class FractionPractice {
	public static void main(String[] args) {
		Fraction fiveWholes = new Fraction(5,1);
		Fraction oneHalf = new Fraction(1,2);
		Fraction threeFourths = new Fraction(3,4);
		Fraction one = new Fraction(1,1);
		
		threeFourths.reciprocal();
		
		System.out.println(threeFourths.toString());
		
		threeFourths.reciprocal();
		System.out.println(fiveWholes + " " + oneHalf + " " + threeFourths + " " + one);
	}
}
