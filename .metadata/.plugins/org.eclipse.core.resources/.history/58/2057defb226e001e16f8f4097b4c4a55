package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tester for the Word class.
 * 
 * @author Prof. Parker and ?
 * @version ?
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
	
	// TODO: Write at least one more test for the constructor and toString, considering edge cases.
	
	// TODO: Uncomment in Step 4 to test isPalindrome.
	/*
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
	*/
	
	// TODO: Write at least three more tests for isPalindrome, considering a false return value, another edge cases, and how to ensure the method does not change object state.

	// TODO: Uncomment in Step 6 to test replaceLetter.
	/*
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
	*/
	
	// TODO: Write at least three more tests for replace, considering cases untested by provided tests.

	// TODO: Uncomment in Step 8 to test reverse.
	/*
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
	*/
	
	// TODO: Write at least two more tests for reverse, considering cases untested by provided tests.
}