package assign08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the BetterDynamicArray class. 
 * 
 * @author Prof. Parker and Jorden Dickerson
 * @version Nov 8, 2023
 */
public class BetterDynamicArrayTester {   
    
	private static BetterDynamicArray threeInts;
	private static BetterDynamicArray largerArray;
	
	// This code executes before each test.
	// You can reference threeStrings in your tests without having to create it.
	@BeforeEach
	public void setup(){
		threeInts = new BetterDynamicArray();
		threeInts.append(9);
		threeInts.append(0);
		threeInts.append(4);
	}
	
	@BeforeEach
	public void setupLarger() {
		largerArray = new BetterDynamicArray();
		for (int i = 0; i < 20; i++)
			largerArray.append(i);
	}
       
    @Test
    public void testConstructor() {
        BetterDynamicArray array = new BetterDynamicArray();
        assertEquals(0, array.size(), "Constructor did not yield a 0-sized dynamic array");
        assertEquals("[] backing array length: 10", array.toString(), 
        		"Constructor did not yield the correct dynamic array (via toString)");
    }
        
    @Test
    public void testConstructorCreatesDistinctArrays() {
        BetterDynamicArray array = new BetterDynamicArray();
        BetterDynamicArray otherArray = new BetterDynamicArray();
        otherArray.append(-5);
        assertEquals(0, array.size(), 
        		"Appending an element to one DynamicArray object changed the size of a different DynamicArray object");
    }
    
    @Test
    public void testAppendSimple() {
        String expected = "[9, 0, 4] backing array length: 10";
        assertEquals(expected, threeInts.toString(), "Failed appending 3 elements to empty dynamic array");
        assertEquals(3, threeInts.size(), "Incorrect size after appending 3 elements to dynamic array");
    }
    
    @Test
    public void testAppendLarger() {
        // Appending >= 10 elements tests the double-length growth of a dynamic array.
        int[] largeArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BetterDynamicArray array = new BetterDynamicArray();
        for(int elem : largeArray) 
            array.append(elem);
        String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10] backing array length: 20";
        assertEquals(expected, array.toString(), "Failed appending 11 elements to dynamic array");
        assertEquals(11, array.size(), "Incorrect size after appending 11 elements to dynamic array");
    }
    
    @Test
    public void testInsertFront() {
        threeInts.insert(0, 5);
        String expected = "[5, 9, 0, 4] backing array length: 10";
        assertEquals(expected, threeInts.toString(), "Failed inserting an element to the front");
        assertEquals(4, threeInts.size(), "Incorrect size after inserting element to the front");
    }
    
    @Test
    public void testInsertMiddle() {
    	threeInts.insert(1, 50);
        String expected = "[9, 50, 0, 4] backing array length: 10";
        assertEquals(expected, threeInts.toString(), "Failed inserting an element to the middle");
        assertEquals(4, threeInts.size(), "Incorrect size after inserting element to the middle");
    }
    
    @Test
    public void testInsertEnd() {
    	threeInts.insert(3, 99);
        String expected = "[9, 0, 4, 99] backing array length: 10";
        assertEquals(expected, threeInts.toString(), "Failed inserting an element to the end");
        assertEquals(4, threeInts.size(), "Incorrect size after inserting element to the end");
    }
    
    @Test
    public void testInsertInvalidLowIndex() {
    	// This assertion checks that calling insert with an index that is too low throws the
    	// IndexIndexOutOfBoundsException.
    	assertThrows(IndexOutOfBoundsException.class, () -> { threeInts.insert(-1, 33); },
    			"Failed to throw exception when inserting with too-low index");
    }
    
    @Test
    public void testInsertInvalidHighIndex() {
    	assertThrows(IndexOutOfBoundsException.class, () -> { threeInts.insert(4, -4); }, 
    			"Failed to throw exception when inserting with too-high index");
    }
    
    @Test
    public void testGetElement(){
        assertEquals(9, threeInts.getElement(0), "Failed getting element from front");
        assertEquals(0, threeInts.getElement(1), "Failed getting element from middle");
        assertEquals(4, threeInts.getElement(2), "Failed getting element from end");
        assertEquals(3, threeInts.size(), "Calling getElement changed the size of dynamic array");
    }
    
    @Test
    public void testGetElementInvalidLow() {
    	assertThrows(IndexOutOfBoundsException.class, () -> { threeInts.getElement(-1); }, 
    			"Failed to throw exception when getting element with too-low index");
    }
    
    @Test
    public void testGetElementInvalidHigh() {
    	assertThrows(IndexOutOfBoundsException.class, () -> { threeInts.getElement(3); },
    			"Failed to throw exception when getting element with too-high index");
    }
    
    @Test
    public void testDoublingIsFaster() {
        double DynamicArrayTime = DynamicArrayTimer.appendToBetterDynamicArray(10000);
        double regularDynamicArrayTime = DynamicArrayTimer.appendToDynamicArray(10000);
        assertTrue(DynamicArrayTime < regularDynamicArrayTime,
                "The time to add 10k items to a doubling dynamic array should be faster, " +
                "but it is not with the current implementation");
    }
    
    // Step 1: Add tests for setElement, delete, and sort methods.
    @Test
    public void testSetElement() {
    	threeInts.setElement(0, 1);
    	threeInts.setElement(1, 2);
    	threeInts.setElement(2, 3);
    	
    	assertEquals(1, threeInts.getElement(0), "Incorrect number at index 0");
    	assertEquals(2, threeInts.getElement(1), "Incorrect number at index 1");
    	assertEquals(3, threeInts.getElement(2), "Incorrect number at index 2");
    }
    
    @Test
    public void testSetElementInvalid() {
    	assertThrows(IndexOutOfBoundsException.class, () -> { threeInts.setElement(4, 2); },
    			"Failed to throw an exception when trying to set an element out of range.");
    }
    
    @Test
    public void testDelete() {
    	threeInts.delete(0);
    	
    	assertEquals(0, threeInts.getElement(0), "Incorrect number at index 0");
    }
    
    @Test
    public void testDeleteInvalid() {
    	assertThrows(IndexOutOfBoundsException.class, () -> { threeInts.delete(5); },
    			"Failed to throw an exception when trying to delete an element out of range.");
    }
    
    @Test
    public void testSort() {
    	threeInts.append(1);
    	threeInts.append(2);
    	threeInts.sort();
    	assertEquals(0, threeInts.getElement(0));
    	assertEquals(1, threeInts.getElement(1));
    	assertEquals(2, threeInts.getElement(2));
    	assertEquals(4, threeInts.getElement(3));
    	assertEquals(9, threeInts.getElement(4));
    }
    // Step 2: Add tests for all methods that operate on a larger dynamic array that has doubled its length.
    
    @Test
    public void testLargerArrayAppend() {
    	largerArray.append(44);
    	assertEquals(44, largerArray.getElement(20));
    }
    
    @Test
    public void testLargerArrayInsert() {
    	largerArray.insert(4, 22);
    	assertEquals(22, largerArray.getElement(4));
    }
    
    @Test
    public void testLargerArrayGetElement() {
    	assertEquals(18, largerArray.getElement(18));
    }
    
    @Test
    public void testLargerArraySort() {
    	largerArray.append(0);
    	largerArray.sort();
    	assertEquals(0, largerArray.getElement(1));
    }
    
    @Test
    public void testLargerArrayDelete() {
    	largerArray.toString();
    	largerArray.delete(5);

    }
}