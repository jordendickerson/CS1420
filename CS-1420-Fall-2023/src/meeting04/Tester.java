package meeting04;

public class Tester {

	public static void main(String[] args) {
		String[] names = new String[365];
		names[2] = "Mia";
		
		String myName = names[4];
		
		System.out.println(names[1]);
		
		String[] knownString = new String[]{"String one", "String two", "String Three", "String four"};
		
		System.out.println(knownString.length);
		
		String stringOne = "good morning";
		String stringTwo = "good morming";
		
		boolean sugma = stringOne == stringTwo;
		
		System.out.println(sugma);
		
		int x = 82;
		int sum = 0;
		while(x > 0){
		    sum = sum + x;
		    x -= 1;
		}
		System.out.println(sum);
		
		char[] letters = new char[4];

		for(int i = 0; i < letters.length; i++){
		    letters[i] = (char)('a' + i);
		    System.out.println(letters[i]);
		}
		
		double y = 1.5;

		if(y < 1)
		    y = 1;
		else if(y < 2)
		    y = 2;
		else if(y < 3)
		    y = 3;
		else
		    y = 4;
		System.out.println(y);
		
		boolean values[] = new boolean[7];
		
		System.out.println(values[4]);

	}

}
