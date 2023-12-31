package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tester for the Word class.
 * 
 * @author Prof. Parker and Jorden Dickerson
 * @version Oct. 19, 2023
 */
public class WordTester {

	/**
	 * Test that the Word class constructor properly throws an exception when 
	 * the given string contains characters that are not a-z or A-Z.
	 */
	@Test
	public void testConstructorException() {
		assertThrows(IllegalArgumentException.class, () -> { new Word("hel!o"); });
	}
	
	/**
	 * Test that the Word class constructor properly sets the private instance 
	 * variable, which is used to generate and return a String in the toString method.
	 */
	@Test
	public void testToStringNormal() {
		Word normal = new Word("Normal");
		assertEquals("Normal", normal.toString());
	}
	
	/**
	 * Test that the Word class constructor properly throws an exception when
	 * the given string contains multiple words.
	 */
	@Test
	public void testToStringMultipleWords() {
		assertThrows(IllegalArgumentException.class, () -> {new Word("Hello there"); });
	}
	
	
	@Test
	public void testIsPalindromeTrue() {
		Word palindrome = new Word("saippuakivikauppias");
		assertTrue(palindrome.isPalindrome());
	}
	
	@Test
	public void testIsPalindromeOneLetter() {		
		Word oneLetter = new Word("a");
		assertTrue(oneLetter.isPalindrome());
	}
	
	/**
	 * Test that the isPalindrome method asserts false when there are no letters
	 */
	@Test
	public void testIsPlaindromeNoLetter() {
		Word noLetter = new Word("");
		assertFalse(noLetter.isPalindrome());
	}
	
	/**
	 * Tests that the isPalindrome method is case sensitive and returns false
	 * when it is same letter different case.
	 */
	@Test
	public void testIsPalindromeCaseSensitive() {
		Word abba = new Word("Abba");
		assertFalse(abba.isPalindrome());
	}
	
	/**
	 * Tests that the isPalindrome method asserts false when given a 
	 * word that is not a palindrome.
	 */
	@Test
	public void testIsPalindromeFalse() {
		Word falsePalindrome = new Word("indubitably");
		assertFalse(falsePalindrome.isPalindrome());
	}
	
	/**
	 * Tests that the isPalindrome method does not change the object
	 * state
	 */
	public void testIsPalindromeChangeState(){
		Word word = new Word("Cram");
		word.isPalindrome();
		assertEquals("Cram", word.toString());
	}
	
	

	
	@Test
	public void testReplaceLetterExceptionFirstArg() {
		Word oneLetter = new Word("a");
     	assertThrows(IllegalArgumentException.class, () -> { oneLetter.replaceLetter(' ', 'l'); });
	}
	
	
	@Test
	public void testReplaceLetterHello() {
		Word hello = new Word("hello");
		assertEquals("hesso", hello.replaceLetter('l', 's').toString());
	}
	
	
	
	@Test
	public void testReplaceLetterSameLetter() {
		Word garb = new Word("garb");
		assertEquals("garb", garb.replaceLetter('a', 'a').toString());
	}
	
	/**
	 * Tests that replaceLetter still functions even when the letter to replace is
	 * not in the word
	 */
	
	@Test
	public void testReplaceLetterNotFound() {
		Word ambidextrous = new Word("ambidextrous");
		assertEquals("ambidextrous", ambidextrous.replaceLetter('z', 'w').toString());
	}
	
	/**
	 * Tests that the method throws an exception when the second argument is passed in incorrectly
	 */
	
	@Test
	public void testReplaceLetterExceptionSecondArg() {
		Word oneLetter = new Word("a");
     	assertThrows(IllegalArgumentException.class, () -> { oneLetter.replaceLetter('l', ' '); });
	}
	
	@Test
	public void testReverseHello() {
		Word hello = new Word("hello");
		hello.reverse();
		assertEquals("olleh", hello.toString());
	}
	
	@Test
	public void testReverseEmpty() {
		Word empty = new Word("");
		empty.reverse();
		assertEquals("", empty.toString());
	}
	
	/**
	 * Tests that the word will stay the same if it is one letter.
	 */
	@Test
	public void testReverseOneLetter() {
		Word oneLetter = new Word("a");
		oneLetter.reverse();
		assertEquals("a", oneLetter.toString());
	}
	
	/**
	 * Tests that the word will still properly reverse even if given a word with an even
	 * amount of characters
	 */
	@Test
	public void testReverseEvenCharacters() {
		Word even = new Word("even");
		even.reverse();
		assertEquals("neve", even.toString());
	}
}