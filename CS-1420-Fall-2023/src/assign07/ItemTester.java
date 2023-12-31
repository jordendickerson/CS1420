package assign07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * A tester for the subclasses of Item: Magic, Armor, and Tool. These tests ensure that the 
 * subclasses are working as designed.
 * 
 * @author Jorden Dickerson
 * @version Oct. 26, 2023
 */
class ItemTester {

	/**
	 * Tests the merge function for tool
	 */
	@Test
	public void testMergeTool() {
		Tool tool1 = new Tool("tool 1", 20);
		Tool tool2 = new Tool("tool 2", 10);
		tool1.merge(tool2);
		assertEquals("Tool: tool 1 - power = 30", tool1.toString());
	}
	
	/**
	 * Tests the merge function for armor
	 */
	@Test
	public void testMergeArmor() {
		Armor armor1 = new Armor("armor 1", 12, 11);
		Armor armor2 = new Armor("armor 2", 11, 10);
		armor1.merge(armor2);
		assertEquals("Armor: armor 1 - defense = 23, condition = 11", armor1.toString());
	}
	
	/**
	 * Tests the merge function for magic
	 */
	@Test
	public void testMergeMagic() {
		Magic magic1 = new Magic("magic 1", 10, 12);
		Magic magic2 = new Magic("magic 2", 15, 17);
		magic1.merge(magic2);
		assertEquals("Magic: magic 1 - power = 25, cost = 13", magic1.toString());
	}
	
	/**
	 * Test the compareTo method of Tool against another Tool
	 */
	@Test
	public void testToolCompareToTool() {
		Tool tool1 = new Tool("tool 1", 20);
		Tool tool2 = new Tool("tool 2", 10);
		assertEquals(1, tool1.compareTo(tool2));
	}
	
	/**
	 * Test the compareTo method of Tool against another equal Tool
	 */
	@Test
	public void testToolCompareToEqualTool() {
		Tool tool1 = new Tool("tool 1", 10);
		Tool tool2 = new Tool("tool 2", 10);
		assertEquals(0, tool1.compareTo(tool2));
	}
	
	/**
	 * Tests Tool compared to Magic
	 */
	@Test
	public void testToolComparedToMagic() {
		Tool tool1 = new Tool("tool 1", 20);
		Magic magic1 = new Magic("magic 1", 10, 12);
		assertEquals(1, tool1.compareTo(magic1));
	}
	
	/**
	 * Tests Tool compared to Armor
	 */
	@Test
	public void testToolComparedToArmor() {
		Tool tool1 = new Tool("tool 1", 20);
		Armor armor1 = new Armor("armor 1", 12, 11);
		assertEquals(1, tool1.compareTo(armor1));
	}
	
	/**
	 * Tests Armor compared to other armor
	 */
	@Test
	public void testArmorComparedToArmor() {
		Armor armor1 = new Armor("armor 1", 12, 11);
		Armor armor2 = new Armor("armor 2", 11, 10);
		assertTrue(0 < armor1.compareTo(armor2));
	}
	
	/**
	 * Tests Armor compared to other equivalent armor
	 */
	@Test
	public void testArmorComparedToEqualArmor() {
		Armor armor1 = new Armor("armor 1", 11, 10);
		Armor armor2 = new Armor("armor 2", 11, 10);
		assertEquals(0, armor1.compareTo(armor2));
	}
	
	/**
	 * Tests Armor compared to Tool
	 */
	@Test
	public void testArmorComparedToTool() {
		Armor armor1 = new Armor("armor 1", 12, 11);
		Tool tool1 = new Tool("tool 1", 20);
		assertEquals(-1, armor1.compareTo(tool1));
	}
	
	/**
	 * Tests Armor compared to Magic
	 */
	@Test
	public void testArmorComparedToMagic() {
		Armor armor1 = new Armor("armor 1", 12, 11);
		Magic magic1 = new Magic("magic 1", 10, 12);
		assertEquals(1, armor1.compareTo(magic1));
	}
	
	/**
	 * Tests Magic compared to other magic
	 */
	@Test
	public void testMagicComparedToMagic() {
		Magic magic1 = new Magic("magic 1", 10, 12);
		Magic magic2 = new Magic("magic 2", 15, 17);
		assertEquals(-1, magic1.compareTo(magic2));
	}
	
	/**
	 * Tests Magic compared to other equivalent magic
	 */
	@Test
	public void testMagicComparedToEqualMagic() {
		Magic magic1 = new Magic("magic 1", 15, 17);
		Magic magic2 = new Magic("magic 2", 15, 17);
		assertEquals(0, magic1.compareTo(magic2));
	}
	
	/**
	 * Tests Magic compared to Tool
	 */
	@Test
	public void testMagicComparedToTool() {
		Magic magic1 = new Magic("magic 1", 10, 12);
		Tool tool1 = new Tool("tool 1", 20);
		assertEquals(-1, magic1.compareTo(tool1));
	}
	
	/**
	 * Tests Magic compared to Magic
	 */
	@Test
	public void testMagicComparedToArmor() {
		Armor armor1 = new Armor("armor 1", 12, 11);
		Magic magic1 = new Magic("magic 1", 10, 12);
		assertEquals(-1, magic1.compareTo(armor1));
	}
}
