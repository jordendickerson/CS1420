package assign08;

import java.util.Arrays;

/**
 * This class represents a better dynamic array of integers, doubling the length of
 * the backing array when more space is needed and never shrinking.
 * 
 * @author Prof. Parker and Jorden Dickerson
 * @version Nov. 7, 2023
 */
public class BetterDynamicArray {

	// DO NOT ADD OR REMOVE ANY INSTANCE VARIABLES
	private int[] elements; // the backing array
	private int elementCount; // the number of elements

	/**
	 * Creates a dynamic array with space for ten elements, but zero spaces occupied.
	 * 
	 * DO NOT MODIFY THIS METHOD
	 */
	public BetterDynamicArray() {
		elements = new int[10];
		elementCount = 0;
	}

	/**
	 * Appends the given integer to end of this dynamic array.
	 * 
	 * @param value - the integer to append
	 */
	public void append(int value) {
		// TODO: Fill in by calling the insert method appropriately.
		insert(elementCount, value);
	}

	/**
	 * Inserts a given integer into this dynamic array at a given index.
	 * 
	 * @param index - the index at which to insert
	 * @param value - the integer to insert
	 * @throws IndexOutOfBoundsException if the given index is out of bounds
	 */
	public void insert(int index, int value) {	
		// TODO: Fill in according to steps below.
		
		// Step 1: Add code to ensure the value of index is valid.
		// HINT: The index is valid if it is in the range of indexes currently used by 
		// elements in this dynamic array.  The range is determined by elementCount, 
		// not elements.length.
		checkIndexOutOfBounds(index);
		
		// Step 2: If there are no free spaces in the backing array, expand.
		// (This step is already done for you.)
		if(elementCount == elements.length) 
			doubleBackingArray();

		// Step 3: Shift the elements at positions index, index + 1, index + 2, and so on
		// up one position.  This makes room for value at index.
		// ADVICE: Try this on paper first since this can be a difficult operation.
		// HINT: It is best to shift the elements if you start at the end because
		// it prevents overwriting values that have not yet been shifted.
		for (int i = elementCount; i > index; i--) {
			elements[i+1] = elements[i];
		}
		// Step 4: Insert value at index.
		elements[index] = value;
		// Step 5: Update elementCount.
		elementCount++;
		// DO NOT create a new array each time this method is called. If you create 
		// a new array each time, your program will be too slow to earn full credit.
	}
	
	/**
	 * Creates a new array with twice the length as the backing array.
	 * Copies all elements from the backing array to the new array.
	 * Sets the backing array reference to the new array.
	 */
	private void doubleBackingArray() {
		int[] largerArray = new int[elements.length * 2];
		for(int i = 0; i < elements.length; i++) 
			largerArray[i] = elements[i];			
		elements = largerArray;
	}

	/**
	 * Gets the integer stored in this dynamic array at the given index.
	 * 
	 * @param index - the index of the element to get
	 * @return the element at the given index
	 * @throws IndexOutOfBoundsException if the given index is out of bounds
	 */
	public int getElement(int index) {		
		// TODO: Fill in and replace "return 0" appropriately.
		checkIndexOutOfBounds(index);
		
		return elements[index]; 
	}

	/**
	 * Returns the number of elements in this dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		// TODO: Replace "return 0" appropriately.

		return elementCount; 
	}

	/**
	 * Sets (i.e., changes) the integer stored in this dynamic array at the given index
	 * to the given integer.
	 * 
	 * @param index - the index of the element to set
	 * @param value - the new integer value for setting the element
	 * @throws IndexOutOfBoundsException if the given index is out of bounds
	 */
	public void setElement(int index, int value) {
		// TODO: Fill in according to steps below.
		checkIndexOutOfBounds(index);
		elements[index] = value;
	}

	/**
	 * Deletes the integer at the given index from this dynamic array. 
	 * 
	 * @param index - the index of the element to delete
	 * @throws IndexOutOfBoundsException if the given index is out of bounds
	 */
	public void delete(int index) {
		// TODO: Fill in. 
		
		// Do not shrink the backing array. 
		// Its length should be the same before and after executing this method.
		
		// Step 1: Add code to ensure the value of index is valid.
		checkIndexOutOfBounds(index);
		// Step 2: Shift the elements at positions index + 1, index + 2, and so on
		// down one position.  This overwrites the deleted element at index.
		for (int i = index; i < elementCount; i++) {
			elements[i] = elements[i + 1];
		}
		// Step 3: Update elementCount.
		elementCount--;
		// DO NOT create a new array each time this method is called. If you create 
		// a new array each time, your program will be too slow to earn full credit.
	}
	
	/**
	 * Sorts the elements of this dynamic array from smallest to largest.
	 */
	public void sort() {
		// TODO: Fill in with the appropriate call to a sort method from Java's Arrays class.
		// https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html
		Arrays.sort(elements);
	}
	
	/**
	 * Throws an IndexOutOfBoundsException if the index is out of bounds
	 * @param index
	 */
	private void checkIndexOutOfBounds(int index) {
		if(index < 0 || index > elementCount)
			throw new IndexOutOfBoundsException(
					"Index " + index + "is invalid for this array with length " + elements.length);
	}

	/**
	 * Generates a textual representation of this dynamic array.
	 * 
	 * @return the textual representation
	 * 
	 * DO NOT MODIFY THIS METHOD
	 */
	public String toString() {
		String result = "[";
		if(size() > 0) 
			result += getElement(0);
		
		for(int i = 1; i < size(); i++) 
			result += ", " + getElement(i);
		
		return result + "] backing array length: " + elements.length;
	}
}