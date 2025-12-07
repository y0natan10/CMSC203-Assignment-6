/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Acrobatic class.
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

public class AcrobaticJUnitTest {

	private Acrobatic acrobatic1;
	private Acrobatic acrobatic2;
	private Acrobatic acrobatic3;

	@BeforeEach
	void setUp() {
		// Acrobatic(name, age, yearsWorked, job)
		acrobatic1 = new Acrobatic("Mike Bell", 30, 8, "Trapeze Artist");
		acrobatic2 = new Acrobatic("Mike Bell", 30, 8, "Trapeze Artist");
		acrobatic3 = new Acrobatic("Alice Brown", 35, 12, "Fire Breather");
	}

	@Test
	public void testConstructorAndInheritedGetters() {
		assertEquals("Mike Bell", acrobatic1.getName(), "getName() should return 'Mike Bell'");
		assertEquals(30, acrobatic1.getAge(), "getAge() should return 30");
		assertEquals(8, acrobatic1.getYearsWorked(), "getYearsWorked() should return 8");
	}

	@Test
	public void testToString() {
		String expected = "acrobatic [name=Alice Brown, age=35, yearsWorked=12, job=Fire Breather]";
		assertEquals(expected, acrobatic3.toString(), "toString() output should match the required format.");
	}

	@Test
	public void testEqualsSameFields() {
		assertTrue(acrobatic1.equals(acrobatic2), "Two acrobats with identical attributes should be logically equal.");
	}

	@Test
	public void testEqualsDifferentJob() {
		Acrobatic differentJob = new Acrobatic("Mike Bell", 30, 8, "Tightrope Walker");
		assertFalse(acrobatic1.equals(differentJob), "Should be false if job is different.");
	}

	@Test
	public void testEqualsDifferentName() {
		Acrobatic differentName = new Acrobatic("Michael Bell", 30, 8, "Trapeze Artist");
		assertFalse(acrobatic1.equals(differentName), "Should be false if name is different.");
	}

	@Test
	public void testEqualsNull() {
		assertFalse(acrobatic1.equals(null), "Should return false when comparing to null.");
	}
}