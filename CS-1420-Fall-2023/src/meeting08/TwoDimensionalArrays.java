package meeting08;

public class TwoDimensionalArrays {

	public static void main(String[] args) {
		double[][] matrix = new double[3][2]; //new double[rows][columns]
		matrix[0][0] = 2.5;
		matrix[0][1] = 21;
		matrix[1][1] = 21.5;
		matrix[1][0] = 2.5;
		matrix[2][0] = 2.5;
		matrix[2][1] = 2.5;
		
		printArray(matrix);
		
		double [][] numbers = new double[10][5];
		for (int row = 0; row < numbers.length; row++) {
			for (int col = 0; col < numbers[row].length; col++) {
				numbers[row][col] = 1;
			}
		}
		printArray(numbers);
		
		double[] r = new double[]{1,3,5,2,3};
		printArray(r);
		
		
		
		
	}
	
	public static void printArray(double[]array) {
		for (int row = 0; row < array.length; row++) {
			System.out.print(array[row] + " ");
		}
	}
	
	public static void printArray(double[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	//METHODS CAN HAVE THE SAME NAME IN A CLASS AS LONG AS THE COMPILER HAS ENOUGH INFORMATION TO TELL WHICH IS WHICH (i.e parameters)
	
	public static int multiply (int value1, int value2) {
		return value1 * value2;
	}
	
	public static int multiply(int[] values) {
		int product = 1;
		for (int i = 0; i < values.length; i++) {
			product *= values[i];
		}
		return product;
	}

}
