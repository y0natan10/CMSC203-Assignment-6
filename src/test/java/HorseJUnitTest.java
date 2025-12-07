/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Horse class.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorseJUnitTest {

	private Horse horse1;
	private Horse horse2;
	private Horse horse3;

	@BeforeEach
	void setUp() {
		// Horse(name, age, species, color)
		horse1 = new Horse("Spirit", 7, "Mustang", "Brown");
		horse2 = new Horse("Spirit", 7, "Mustang", "Brown");
		horse3 = new Horse("Lightning", 4, "Arabian", "White");
	}

	// Constructor and Public Getter Tests

	@Test
	void testGetName() {
		assertEquals("Spirit", horse1.getName(), "getName() should return 'Spirit'");
	}

	@Test
	void testGetAge() {
		assertEquals(7, horse1.getAge(), "getAge() should return 7");
	}

	// Animal Interface Method Tests

	@Test
	void testMoveMethod() {
		assertDoesNotThrow(() -> horse1.move(), "move() should execute without error.");
	}

	@Test
	void testMakeSoundMethod() {
		assertDoesNotThrow(() -> horse1.makeSound(), "makeSound() should execute without error.");
	}

	// equals() Tests

	@Test
	void testEqualsSelf() {
		assertTrue(horse1.equals(horse1), "A horse should equal itself (reference equality)");
	}

	@Test
	void testEqualsSameFields() {
		assertTrue(horse1.equals(horse2), "Two horses with identical attributes should be logically equal");
	}

	@Test
	void testEqualsDifferentFields() {
		assertFalse(horse1.equals(horse3), "Two horses with different attributes should not be equal");
	}

	@Test
	void testEqualsDifferentSpecies() {
		// This test verifies that the `species` field is compared in the equals()
		// method
		Horse differentSpecies = new Horse("Spirit", 7, "Clydesdale", "Brown");
		assertFalse(horse1.equals(differentSpecies), "Should be false if species is different");
	}

	@Test
	void testEqualsDifferentColor() {
		// This test verifies that the `color` field is compared in the equals() method
		Horse differentColor = new Horse("Spirit", 7, "Mustang", "Black");
		assertFalse(horse1.equals(differentColor), "Should be false if color is different");
	}

	@Test
	void testEqualsNull() {
		assertFalse(horse1.equals(null), "Should return false when comparing to null");
	}

	// toString() Test

	@Test
	void testToStringFormat() {
		String expected = "horse [name=Spirit, age=7, species=Mustang, color=Brown]";
		assertEquals(expected, horse1.toString(), "toString() output should match the required format");
	}
}