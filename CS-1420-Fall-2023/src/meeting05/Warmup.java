package meeting05;

public class Warmup {

	public static void main(String[] args) {
		int elevations[] = new int[] {10, 40, -32, 5, -1, -23};
		
		System.out.println("Last elevation: " + elevations[elevations.length - 1]);
		
		int positiveElevations = 0;
		int closestIndex = 0;
		
		for (int i = 0; i < elevations.length; i++) {
			if (elevations[i] > 0)
				positiveElevations++;
			
			if (Math.abs(elevations[i]) < Math.abs(elevations[closestIndex]))
				closestIndex = i;
		}
		
		System.out.println("Positive elevations: " + positiveElevations);
		System.out.println("Closest elevation index to zero: " + closestIndex);
		System.out.println("Closes elevations to zero: " + elevations[closestIndex]);
		
		
		String[] sentences = new String[3];
		sentences[0] = "This is the first sentence.";
		sentences[1] = "This is the best essay.";
		sentences[2] = "This is the third sentence.";
		
		for (int i = 0; i < sentences.length; i++) {
			if (sentences[i].equals("This is the best essay.")) {
				System.out.println("Success!");
				break;
			}
		}

	}

}
