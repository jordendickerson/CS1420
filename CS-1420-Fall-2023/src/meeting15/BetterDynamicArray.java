package meeting15;

/**
 * This class represents a better dynamic array of strings, doubling the length of
 * the backing array when more space is needed and never shrinking.
 * 
 * This is a reduced version of the class students are to fill in later.
 * Filling in the doubleBackingArray helper method is the warm-up problem for 
 * the next class meeting.
 * 
 * @author Prof. Parker
 * @version October 23, 2023
 */
public class BetterDynamicArray {

	// DO NOT ADD OR REMOVE ANY INSTANCE VARIABLES
	private String[] elements; // the backing array
	private int elementCount; // the number of elements

	/**
	 * Creates a dynamic array with space for ten elements, but zero spaces occupied.
	 * 
	 * DO NOT MODIFY THIS METHOD
	 */
	public BetterDynamicArray() {
		elements = new String[10];
		elementCount = 0;
	}

	/**
	 * Inserts a given string into this dynamic array at a given index.
	 * 
	 * @param index - the index at which to insert
	 * @param str - the string to insert
	 * @throws IndexOutOfBoundsException if the given index is out of bounds
	 */
	public void insert(int index, String str) {		
		// Step 1: Add code to ensure the value of index is valid.
		// HINT: The index is valid if it is in the range of indexes currently used by 
		// elements in this dynamic array.  The range is determined by elementCount, 
		// not elements.length.
		
		// Step 2: If there are no free spaces in the backing array, expand.
		// (This step is already done for you.)
		if(elementCount == elements.length) 
			doubleBackingArray();

		// Step 3: Shift the elements at positions index, index + 1, index + 2, and so on
		// up one position.  This makes room for value at index.
		// ADVICE: Try this on paper first since this can be a difficult operation.
		// HINT: It is best to shift the elements if you start at the end because
		// it prevents overwriting values that have not yet been shifted.
		
		// Step 4: Insert value at index.
		
		// Step 5: Update elementCount.
		
		// DO NOT create a new array each time this method is called. If you create 
		// a new array each time, your program will be too slow.
	}
	
	/**
	 * Deletes the integer at the given index from this dynamic array. 
	 * 
	 * @param index - the index of the element to delete
	 * @throws IndexOutOfBoundsException if the given index is out of bounds
	 */
	public void delete(int index) {
		// Do not shrink the backing array. 
		// Its length should be the same before and after executing this method.
		
		// Step 1: Add code to ensure the value of index is valid.

		// Step 2: Shift the elements at positions index + 1, index + 2, and so on
		// down one position.  This overwrites the deleted element at index.
		
		// Step 3: Update elementCount.
		
		// DO NOT create a new array each time this method is called. If you create 
		// a new array each time, your program will be too slow.
	}
	
	/**
	 * Creates a new array with twice the length as the backing array.
	 * Copies all elements from the backing array to the new array.
	 * Sets the backing array reference to the new array.
	 */
	private void doubleBackingArray() {
		// TODO: Fill in during next class meeting.
	}
}