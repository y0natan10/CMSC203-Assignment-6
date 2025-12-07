/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Ticket class, verifying complex pricing logic based on day, customer, and seat.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently.
 Print your Name here: Yonatan Rubin
*/

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TicketJUnitTestStudent {

	private final double BASE_PRICE = 20.0;
	private final double DELTA = 0.01; // Tolerance for double comparisons

	// Price Calculation Tests (Verifying all discounts and multipliers)

	@Test
	void testPrice_Adult_Saturday_LowerLevel() {
		// Day: SATURDAY (0% disc), Customer: ADULT (Age 40, 0% disc), Seat: LOWER (1x)
		// Expected Price: 20.00
		Ticket ticket = new Ticket("SATURDAY", BASE_PRICE, 40, 1);
		double expectedPrice = 20.00;
		assertEquals(expectedPrice, ticket.calculatePrice(), DELTA,
				"Adult on Saturday, Lower Level should be base price.");
	}

	@Test
	void testPrice_Child_Monday_LowerLevel_FullDiscount() {
		// Day: MONDAY (10% disc), Customer: CHILD (Age 10, 10% disc), Seat: LOWER (1x)
		// Price: 20 - (20*0.10) - (20*0.10) = 16.00
		Ticket ticket = new Ticket("MONDAY", BASE_PRICE, 10, 1);
		double expectedPrice = 16.00;
		assertEquals(expectedPrice, ticket.calculatePrice(), DELTA,
				"Child on Monday should have 20% total discount ($16.00).");
	}

	@Test
	void testPrice_Student_Thursday_TLevel_DoublePrice() {
		// Day: THURSDAY (10% disc), Customer: STUDENT (Age 20, 10% disc), Seat: T-LEVEL
		// (2x)
		// Price before Seat Multiplier: 20 - (20*0.10) - (20*0.10) = 16.00
		// Final Price: 16.00 * 2.0 = 32.00
		Ticket ticket = new Ticket("THURSDAY", BASE_PRICE, 20, 2);
		double expectedPrice = 32.00;
		assertEquals(expectedPrice, ticket.calculatePrice(), DELTA, "Student on Thursday at T-Level should be $32.00.");
	}

	@Test
	void testPrice_Senior_Sunday_UpperLevel_SeatDiscount() {
		// Day: SUNDAY (0% disc), Customer: SENIOR (Age 70, 5% disc), Seat: UPPER (5%
		// disc multiplier 0.95)
		// Price before Seat Multiplier: 20 - (20*0.05) = 19.00
		// Final Price: 19.00 * 0.95 = 18.05
		Ticket ticket = new Ticket("SUNDAY", BASE_PRICE, 70, 3);
		double expectedPrice = 18.05;
		assertEquals(expectedPrice, ticket.calculatePrice(), DELTA,
				"Senior on Sunday at Upper Level should be $18.05.");
	}

	@Test
	void testPrice_Adult_Friday_UpperLevel() {
		// Day: FRIDAY (10% disc), Customer: ADULT (Age 40, 0% disc), Seat: UPPER (5%
		// disc multiplier 0.95)
		// Price before Seat Multiplier: 20 - (20*0.10) = 18.00
		// Final Price: 18.00 * 0.95 = 17.10
		Ticket ticket = new Ticket("FRIDAY", BASE_PRICE, 40, 3);
		double expectedPrice = 17.10;
		assertEquals(expectedPrice, ticket.calculatePrice(), DELTA, "Adult on Friday at Upper Level should be $17.10.");
	}

	// Test to ensure discount logic is applied correctly to the Student age range
	// (13-25)
	@Test
	void testPrice_Student_AgeBoundary() {
		// Age 13 (Student, 10% disc) on Saturday (0% disc), Lower Level (1x)
		// Price: 20 - (20 * 0.10) = 18.00
		Ticket ticket = new Ticket("SATURDAY", BASE_PRICE, 13, 1);
		double expectedPrice = 18.00;
		assertEquals(expectedPrice, ticket.calculatePrice(), DELTA, "Age 13 (Student) should receive 10% discount.");
	}

	// toString() Test (Verifying the exact required output format)

	@Test
	void testToStringFormat() {
		Ticket ticket = new Ticket("SATURDAY", 100.0, 5, 1); // Age 5 is a Child
		double finalPrice = ticket.calculatePrice(); // Expected final price: 100 - 10 = 90.00

		// Expected format from your code: Ticket [Day: SATURDAY, Age: 5, Seat: Lower
		// level, Price: $90.00]
		String expected = String.format("Ticket [Day: Saturday, Age: %d, Seat: %s, Price: $%.2f]", 5, "Lower level",
				finalPrice);
		assertEquals(expected, ticket.toString(), "toString() output should match the required format.");
	}
}