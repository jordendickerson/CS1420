package math;

import java.math.*;
public class PolynomialInequaleties {

	public static void main(String[] args) {
		for (double i = 0; i <= 20; i += 0.01) {
			double power = -5 * Math.pow(i, 2);
			double middle = 100 * i;
			double equation = (power + middle );
			
			if (equation >= 230) {
				System.out.print("HERE HERE HERE");
				System.out.print(i + " feet: ");
				System.out.println(equation);
			}
				
		}

	}

}
