package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellCheck {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		File file = new File("src/lab04/words.txt");
		int wordCount = countWords(file);
		String wordCompare = getClosestWord("zoo", file);
		
		System.out.println(wordCount);
		System.out.println(wordCompare);
		
		System.out.println("Enter a word:");
		String userWord = input.nextLine();
		
		while(!userWord.equals("exit")) {
			String closestWord = getClosestWord(userWord, file);
			System.out.println("Did you mean " + closestWord + "?");
			
			System.out.println("Enter a word: ('exit' to exit)");
			userWord = input.nextLine();
		}

	}
	
	/**
	 * Given a filename, this method returns a count of the number of
	 * words in the file. If the file cannot be opened, -1 is returned.
	 * 
	 * @param the name with path of a text file
	 * @return the count of words in the file or -1
	 */
	public static int countWords(File file) {
		Scanner fileInput;
		try {
		    // TODO
			fileInput = new Scanner(file);
		}catch(FileNotFoundException e) {
		    // TODO
			return 0;
		}
		
		int wordCount = 0;
		while(fileInput.hasNext()) {
			wordCount++;
			fileInput.next();
		}
		fileInput.close();
		return wordCount;
	}
	
	public static String getClosestWord(String word, File file) {
		Scanner fileInput;
		try {
		    // TODO
			fileInput = new Scanner(file);
		}catch(FileNotFoundException e) {
		    // TODO
			return "ERROR: FILE NOT FOUND";
		}
		
		String current = "";
		
		while(fileInput.hasNext()) {
			current = fileInput.next();
			if(word.compareTo(current) <= 0)
			    break;
		}
		fileInput.close();
		return current;
	}

}
