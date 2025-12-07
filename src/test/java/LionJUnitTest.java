/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Lion class.
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

public class LionJUnitTest {

	private Lion lion1;
	private Lion lion2;
	private Lion lion3;

	@BeforeEach
	void setUp() {
		// Lion(name, age, species, color)
		lion1 = new Lion("Simba", 9, "African Lion", "Gold");
		lion2 = new Lion("Simba", 9, "African Lion", "Gold");
		lion3 = new Lion("Nala", 5, "Barbary Lion", "Tan");
	}

	// Constructor and Public Getter Tests (from Animal interface)

	@Test
	void testGetName() {
		assertEquals("Simba", lion1.getName(), "getName() should return 'Simba'");
	}

	@Test
	void testGetAge() {
		assertEquals(9, lion1.getAge(), "getAge() should return 9");
	}

	// Animal Interface Method Tests

	@Test
	void testMoveMethod() {
		assertDoesNotThrow(() -> lion1.move(), "move() should execute without error.");
	}

	@Test
	void testMakeSoundMethod() {
		assertDoesNotThrow(() -> lion1.makeSound(), "makeSound() should execute without error.");
	}

	// equals() Tests

	@Test
	void testEqualsSelf() {
		assertTrue(lion1.equals(lion1), "A lion should equal itself (reference equality)");
	}

	@Test
	void testEqualsSameFields() {
		assertTrue(lion1.equals(lion2), "Two lions with identical attributes should be logically equal");
	}

	@Test
	void testEqualsDifferentFields() {
		assertFalse(lion1.equals(lion3), "Two lions with different attributes should not be equal");
	}

	@Test
	void testEqualsDifferentSpecies() {
		// Tests that the 'species' field is included in the equals check
		Lion differentSpecies = new Lion("Simba", 9, "Asiatic Lion", "Gold");
		assertFalse(lion1.equals(differentSpecies), "Should be false if species is different");
	}

	@Test
	void testEqualsDifferentAge() {
		// Tests that the 'age' field is included in the equals check
		Lion differentAge = new Lion("Simba", 10, "African Lion", "Gold");
		assertFalse(lion1.equals(differentAge), "Should be false if age is different");
	}

	@Test
	void testEqualsNull() {
		assertFalse(lion1.equals(null), "Should return false when comparing to null");
	}

	// toString() Test

	@Test
	void testToStringFormat() {
		// Expected format: lion [name=Simba, age=9, species=African Lion, color=Gold]
		String expected = "lion [name=Simba, age=9, species=African Lion, color=Gold]";
		assertEquals(expected, lion1.toString(), "toString() output should match the required format");
	}
}