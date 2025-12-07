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

public class DogJUnitTest {

	private Dog dog1;
	private Dog dog2;
	private Dog dog3;

	@BeforeEach
	void setUp() {
		// Dog(name, age, species, color)
		dog1 = new Dog("Buddy", 5, "Labrador", "Brown");
		dog2 = new Dog("Buddy", 5, "Labrador", "Brown");
		dog3 = new Dog("Luna", 2, "Poodle", "White");
	}

	// Constructor and Public Getter Tests (from Animal interface)

	@Test
	void testGetName() {
		assertEquals("Buddy", dog1.getName(), "getName() should return 'Buddy'");
	}

	@Test
	void testGetAge() {
		assertEquals(5, dog1.getAge(), "getAge() should return 5");
	}

	// Animal Interface Method Tests

	@Test
	void testMoveMethod() {
		assertDoesNotThrow(() -> dog1.move(), "move() should execute without error.");
	}

	@Test
	void testMakeSoundMethod() {
		assertDoesNotThrow(() -> dog1.makeSound(), "makeSound() should execute without error.");
	}

	// equals() Tests

	@Test
	void testEqualsSelf() {
		assertTrue(dog1.equals(dog1), "A dog should equal itself (reference equality)");
	}

	@Test
	void testEqualsSameFields() {
		assertTrue(dog1.equals(dog2), "Two dogs with identical attributes should be logically equal");
	}

	@Test
	void testEqualsDifferentFields() {
		assertFalse(dog1.equals(dog3), "Two dogs with different attributes should not be equal");
	}

	@Test
	void testEqualsDifferentSpecies() {
		Dog differentSpecies = new Dog("Buddy", 5, "Husky", "Brown");
		assertFalse(dog1.equals(differentSpecies), "Should be false if species is different");
	}

	@Test
	void testEqualsDifferentColor() {
		Dog differentColor = new Dog("Buddy", 5, "Labrador", "Black");
		assertFalse(dog1.equals(differentColor), "Should be false if color is different");
	}

	@Test
	void testEqualsNull() {
		assertFalse(dog1.equals(null), "Should return false when comparing to null");
	}

	// toString() Test

	@Test
	void testToStringFormat() {
		// Expected format: dog [name=Buddy, age=5, species=Labrador, color=Brown]
		String expected = "dog [name=Buddy, age=5, species=Labrador, color=Brown]";
		assertEquals(expected, dog1.toString(), "toString() output should match the required format");
	}
}