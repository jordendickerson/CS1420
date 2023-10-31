package meeting04;

public class AgeClassifier {

	public static void main(String[] args) {
		int[] age = new int[] {10,52,34,65,65,87,0,23,1,76,44,225};
		
		for (int i = 0; i < age.length; i++) {
			
			if (i > 10) {
				System.out.println("Too many items!");
				break;
			}
			
			System.out.print("I'm " + age[i] + " and I'm ");
			
			if (age[i] < 0)
				System.out.println("a liar");
			else if (age[i] <= 12)
				System.out.println("a kid");
			else if (age[i] <=19)
				System.out.println("a teen");
			else if (age[i] <=64)
				System.out.println("an adult");
			else if (age[i] <= 122)
				System.out.println("a senior");
			else
				System.out.println("most elderly person ever");
		}
		
		int sum = 0;
		int max = -1;
		int min = 1000;
		for (int i = 0; i < age.length; i++) {
			if (age[i] > max)
				max = age[i];
			
			if (age[i] < min)
				min = age[i];
			sum += age[i];
		}
		
		int average = sum / age.length;
		
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		System.out.println("Average age: " + average);
		

	}

}
