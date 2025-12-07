/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Clerk class.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClerkJUnitTest {

	private Clerk clerk1;
	private Clerk clerk2;
	private Clerk clerk3;

	@BeforeEach
	void setUp() {
		// Clerk(name, age, yearsWorked, job)
		clerk1 = new Clerk("John Brown", 35, 10, "Office Manager");
		clerk2 = new Clerk("John Brown", 35, 10, "Office Manager");
		clerk3 = new Clerk("Jane Doe", 28, 3, "Ticket Seller");
	}

	@Test
	public void testConstructorAndInheritedGetters() {
		// Test inherited fields and getters
		assertEquals("John Brown", clerk1.getName(), "getName() should return 'John Brown'");
		assertEquals(35, clerk1.getAge(), "getAge() should return 35");
		assertEquals(10, clerk1.getYearsWorked(), "getYearsWorked() should return 10");
	}

	@Test
	public void testToString() {
		// Expected output:
		// clerk [name=John Brown, age=35, yearsWorked=10, job=Office Manager]
		String expected = "clerk [name=John Brown, age=35, yearsWorked=10, job=Office Manager]";
		assertEquals(expected, clerk1.toString(), "toString() output should match the required format.");
	}

	// equals() Tests

	@Test
	void testEqualsSelf() {
		assertTrue(clerk1.equals(clerk1), "A clerk should equal itself (reference equality)");
	}

	@Test
	public void testEqualsSameFields() {
		assertTrue(clerk1.equals(clerk2), "Two clerks with identical attributes should be logically equal.");
	}

	@Test
	public void testEqualsDifferentJob() {
		Clerk differentJob = new Clerk("John Brown", 35, 10, "Concessions Supervisor");
		assertFalse(clerk1.equals(differentJob), "Should be false if job is different.");
	}

	@Test
	public void testEqualsDifferentYearsWorked() {
		Clerk differentYears = new Clerk("John Brown", 35, 5, "Office Manager");
		assertFalse(clerk1.equals(differentYears), "Should be false if yearsWorked is different.");
	}

	@Test
	public void testEqualsDifferentClerk() {
		assertFalse(clerk1.equals(clerk3), "Two different clerks should not be equal.");
	}

	@Test
	public void testEqualsNull() {
		assertFalse(clerk1.equals(null), "Should return false when comparing to null.");
	}
}