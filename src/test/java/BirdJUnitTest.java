/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Bird class.
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

public class BirdJUnitTest {

	private Bird bird1;
	private Bird bird2;
	private Bird bird3;

	@BeforeEach
	void setUp() {
		// Bird(name, age, species, color)
		bird1 = new Bird("Tweety", 2, "Canary", "Yellow");
		bird2 = new Bird("Tweety", 2, "Canary", "Yellow");
		bird3 = new Bird("Polly", 5, "Parrot", "Green");
	}

	// Constructor and Public Getter Tests

	@Test
	void testGetName() {
		assertEquals("Tweety", bird1.getName(), "getName() should return 'Tweety'");
	}

	@Test
	void testGetAge() {
		assertEquals(2, bird1.getAge(), "getAge() should return 2");
	}

	// Animal Interface Method Tests

	@Test
	void testMoveMethod() {
		assertDoesNotThrow(() -> bird1.move(), "move() should execute without error.");
	}

	@Test
	void testMakeSoundMethod() {
		assertDoesNotThrow(() -> bird1.makeSound(), "makeSound() should execute without error.");
	}

	// equals() Tests

	@Test
	void testEqualsSelf() {
		assertTrue(bird1.equals(bird1), "A bird should equal itself (reference equality)");
	}

	@Test
	void testEqualsSameFields() {
		assertTrue(bird1.equals(bird2), "Two birds with identical attributes should be logically equal");
	}

	@Test
	void testEqualsDifferentFields() {
		assertFalse(bird1.equals(bird3), "Two birds with different attributes should not be equal");
	}

	@Test
	void testEqualsDifferentName() {
		Bird differentName = new Bird("Twitter", 2, "Canary", "Yellow");
		assertFalse(bird1.equals(differentName), "Should be false if name is different");
	}

	@Test
	void testEqualsDifferentSpecies() {
		Bird differentSpecies = new Bird("Tweety", 2, "Finch", "Yellow");
		assertFalse(bird1.equals(differentSpecies), "Should be false if species is different");
	}

	@Test
	void testEqualsNull() {
		assertFalse(bird1.equals(null), "Should return false when comparing to null");
	}

	// toString() Test

	@Test
	void testToStringFormat() {
		// "bird [name=Tweety, age=2, species=Canary, color=Yellow]"
		String expected = "bird [name=Tweety, age=2, species=Canary, color=Yellow]";
		assertEquals(expected, bird1.toString(), "toString() output should match the required format");
	}
}