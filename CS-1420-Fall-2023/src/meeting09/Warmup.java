package meeting09;

public class Warmup {

	public static void main(String[] args) {
		int[][]identityMatrix = new int[100][100];
		
		for (int row = 0; row < identityMatrix.length; row++) {
			for (int col = 0; col < identityMatrix[0].length; col++) {
				if (col == row) {
					identityMatrix[row][col] = 1;
				}else {
					identityMatrix[row][col] = 0;
				}
				System.out.print(identityMatrix[row][col]);
			}
			System.out.println();
		}
		
		Student s; //no need to import as it's in the same package
		
		s = new Student("Spongebob", 147293, "spongy@utah.edu");

	}

}
