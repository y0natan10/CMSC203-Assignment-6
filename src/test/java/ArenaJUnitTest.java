
/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Arena class.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArenaJUnitTest {

	private Arena arena;

	@BeforeEach
	void setUp() {
		// Arena(color, length, width)
		arena = new Arena("Blue", 100.0, 50.0);
	}

	@Test
	void testConstructorAndInitialValues() {
		assertEquals("Blue", arena.getColor(), "Initial color is incorrect.");
		assertEquals(100.0, arena.getLength(), 0.001, "Initial length is incorrect.");
		assertEquals(50.0, arena.getWidth(), 0.001, "Initial width is incorrect.");
		assertEquals("Arena", arena.getBuildingType(), "Initial building type is incorrect.");
	}

	@Test
	void testSetSize() {
		double newLength = 150.5;
		double newWidth = 75.2;

		arena.setSize(newLength, newWidth);

		assertEquals(newLength, arena.getLength(), 0.001, "Length was not updated correctly by setSize.");
		assertEquals(newWidth, arena.getWidth(), 0.001, "Width was not updated correctly by setSize.");
	}

	@Test
	void testSetColor() {
		String newColor = "Red and White Stripes";

		arena.setColor(newColor);

		assertEquals(newColor, arena.getColor(), "Color was not updated correctly by setColor.");
	}

	@Test
	void testSetBuildingType() {
		String newType = "Main Tent";

		arena.setBuildingType(newType);

		assertEquals(newType, arena.getBuildingType(), "Building type was not updated correctly by setBuildingType.");
	}

	@Test
	void testToString() {
		// Expected format:
		// arena [color=Blue, length=100.0, width=50.0, buildingType=Arena]
		String expected = "arena [color=Blue, length=100.0, width=50.0, buildingType=Arena]";
		assertEquals(expected, arena.toString(), "toString() output does not match the expected format.");
	}

}