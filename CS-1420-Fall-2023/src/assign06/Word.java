package assign06;

/**
 * Creates a Word object that sets an array of letters to each letter of a
 * passed in word.
 * 
 * @author Jorden Dickerson
 * @version Oct. 19, 2023
 */
public class Word {
	private char[] letters;
	
	public Word(String word) {
		//Initialise the letters array to the length of the word
		letters = new char[word.length()];
		
		//Set the letters array to each letter of the word
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			//If the letter has an incorrect ASCII code and is not a letter, throw an IllegalArgumentException
			if (!(letter >= 'a' && letter <= 'z') && !(letter >= 'A' && letter <= 'Z')) {
				throw new IllegalArgumentException();
			}
			//If the letter has the correct ASCII code, set it in the letters array
			letters[i] = letter;
		}
	}
	
	/**
	 * Generates and returns a String object to represent this Word object 
	 * (driver method).
	 * 
	 * @return a String object that represents this Word object
	 */
	public String toString() {
	   return toString(0);
	}
		
	/**
	 * Generates and returns a String object to represent the letters of 
	 * this Word object from a given index to the last index (recursive method).
	 * 
	 * @param startIndex - index at which to start
	 * @return the letters of this Word from startIndex to the last index, as a String
	 */
	private String toString(int startIndex) {
	   // base case
	   if(startIndex == letters.length)
	      return "";
	   // recursive case
	   return letters[startIndex] + toString(startIndex + 1);
	}
	
	/**
	 * Checks whether the word is a plaindrome or not
	 * (Driver method)
	 * 
	 * @return the result of isPalindrome recursive
	 */
	public boolean isPalindrome() {
		return isPalindrome(0,letters.length - 1);
	}
	
	/**
	 * Starts by comparing the start index and the end index and goes inward, comparing
	 * each letter to see if they are equal. If unequal letters are found, the method returns
	 * false. If the word is only one letter, it returns true. If the middle of the word is reached
	 * with no unequal letters found, it returns true.
	 * 
	 * 
	 * @param startIndex - The start of the word
	 * @param endIndex - The end of the word
	 * @return Whether two letters within the word are equal or not.
	 */
	private boolean isPalindrome(int startIndex, int endIndex) {
		//base case
		if (letters.length == 1)
			return true;
		//base case
		if (letters.length == 0)
			return false;
		//recursive case
		if (startIndex == endIndex) {
			return true;
		}
		//recursive case
		if (letters[startIndex] != letters[endIndex]) {
			return false;
		}

		return isPalindrome(startIndex + 1, endIndex - 1);
		
		
	}
	
	/**
	 * The driver method for the replaceLetter recursive method. Takes a letter and replacement
	 * input and starts the recursive method from index 0.
	 * 
	 * @param letter - The letter to be replaced
	 * @param replacement - The letter to replace with
	 * @return - The result of the recursive method
	 */
	public Word replaceLetter(char letter, char replacement) {
		return new Word(replaceLetter(letter, replacement, 0));
	}
	
	/**
	 * Cycles through the word and replaces a specific letter with a replacement letter.
	 * 
	 * @param letter - The letter to be replaced
	 * @param replacement - The replacement letter
	 * @param startIndex - The index to start from
	 * @return - The word with the letters replaced
	 */
	private String replaceLetter(char letter, char replacement, int startIndex) {
		char newLetter;
		
		if (startIndex == letters.length)
			return "";
		//check if letter and replacement are not letters
		if ((!(letter >= 'a' && letter <= 'z') && !(letter >= 'A' && letter <= 'Z')) || ((!(replacement >= 'a' && replacement <= 'z') && !(replacement >= 'A' && replacement <= 'Z')))){
			throw new IllegalArgumentException("Only letters are accepted");
		}
		
		//if the letter at index is the letter to replace, set newLetter to replacement
		if (letters[startIndex] == letter)
			newLetter = replacement;
		//if not, keep letter the same
		else
			newLetter = letters[startIndex];
		
		return newLetter + replaceLetter(letter, replacement, startIndex + 1);
		
	}
	
	/**
	 * Reverses the word
	 * (driver method)
	 */
	public void reverse() {
		reverse(0, letters.length - 1);
	}
	
	/**
	 * Reverses the word by swapping the first and last items of the letters array and moves inward.
	 * 
	 * @param startIndex - The index to start at
	 * @param endIndex - The end of the Array
	 */
	private void reverse(int startIndex, int endIndex) {
		//base case if no letters
		if (letters.length == 0)
			return;
		//base case if only one letter
		if (letters.length == 1)
			return;
		
		//set temp variables to store current letters
		char startLetter = letters[startIndex];
		char endLetter = letters[endIndex];
		
		//swap letters
		letters[startIndex] = endLetter;
		letters[endIndex] = startLetter;
		
		//if the middle of the word has been reached, return.
		if (startIndex == letters.length / 2 || endIndex == letters.length / 2)
			return;
		
		//recursive case
		reverse(startIndex + 1, endIndex - 1);
	}

}
