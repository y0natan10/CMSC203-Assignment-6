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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketingOfficeJUnitTest {

	private TicketingOffice office;
	private final String INITIAL_COLOR = "Red";
	private final double INITIAL_LENGTH = 15.0;
	private final double INITIAL_WIDTH = 10.0;
	private final String DEFAULT_TYPE = "Ticketing Office";

	@BeforeEach
	void setUp() {
		// TicketingOffice(color, length, width)
		office = new TicketingOffice(INITIAL_COLOR, INITIAL_LENGTH, INITIAL_WIDTH);
	}

	@Test
	void testConstructorAndGetters() {
		// Test constructor initialization and default building type
		assertEquals(INITIAL_COLOR, office.getColor(), "Initial color should match constructor input.");
		assertEquals(INITIAL_LENGTH, office.getLength(), 0.001, "Initial length should match constructor input.");
		assertEquals(INITIAL_WIDTH, office.getWidth(), 0.001, "Initial width should match constructor input.");
		assertEquals(DEFAULT_TYPE, office.getBuildingType(), "Building type should default to 'Ticketing Office'.");
	}

	@Test
	void testSetSize() {
		double newLength = 25.5;
		double newWidth = 15.2;

		office.setSize(newLength, newWidth);

		assertEquals(newLength, office.getLength(), 0.001, "Length should be updated by setSize.");
		assertEquals(newWidth, office.getWidth(), 0.001, "Width should be updated by setSize.");
	}

	@Test
	void testSetColor() {
		String newColor = "Blue";
		office.setColor(newColor);
		assertEquals(newColor, office.getColor(), "Color should be updated by setColor.");
	}

	@Test
	void testSetBuildingType() {
		String newType = "Customer Service Center";
		office.setBuildingType(newType);
		assertEquals(newType, office.getBuildingType(), "Building type should be updated by setBuildingType.");
	}

	@Test
	void testToString() {
		// Expected format:
		// ticketingOffice [color=Red, length=15.0, width=10.0, buildingType=Ticketing Office]
		String expected = "ticketingOffice [color=Red, length=15.0, width=10.0, buildingType=Ticketing Office]";
		assertEquals(expected, office.toString(), "toString() output should match the required format.");
	}

	// Test to ensure default building type is set even after using setSize and setColor
	@Test
	void testBuildingTypePersistence() {
		office.setSize(50.0, 50.0);
		office.setColor("Yellow");
		assertEquals(DEFAULT_TYPE, office.getBuildingType(),
				"Building type should remain 'Ticketing Office' unless explicitly changed.");
	}
}