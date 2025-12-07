/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: JUnit test class for the Circus manager class, verifying aggregation, sorting, searching, and ticket generation logic.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircusJUnitTest {
	private Circus circus;

	@BeforeEach
	void setUp() {
		circus = new Circus();
		// Setup initial data for sorting/searching tests
		circus.addAnimal(new Dog("Alpha", 5, "Husky", "Grey"));
		circus.addAnimal(new Bird("Zulu", 2, "Parrot", "Red"));
		circus.addAnimal(new Lion("Beta", 10, "African", "Gold"));
	}

	// 1. Aggregation (Add) Tests

	@Test
	void testAddAnimal() {
		Dog dog = new Dog("Shila", 3, "Golden Retriever", "Brown");
		circus.addAnimal(dog);

		// Use the new public getter to verify size and content
		List<Animal> animals = circus.getAnimals();
		assertEquals(4, animals.size(), "Total animals count should be 4.");
		assertTrue(animals.contains(dog), "The newly added dog should be in the list.");
	}

	@Test
	void testAddPerson() {
		Clerk clerk = new Clerk("Joan", 40, 5, "Ticket Seller");
		circus.addPerson(clerk);

		// Use the new public getter
		List<Person> persons = circus.getPersons();
		assertEquals(1, persons.size(), "Clerk should be added to the persons list.");
		assertTrue(persons.get(0) instanceof Clerk, "The added person should be a Clerk.");
	}

	@Test
	void testAddBuilding() {
		TicketingOffice office = new TicketingOffice("Green", 20.0, 10.0);
		circus.addBuilding(office);

		// Use the new public getter
		List<Building> buildings = circus.getBuildings();
		assertEquals(1, buildings.size(), "Office should be added to the buildings list.");
		assertEquals("Ticketing Office", buildings.get(0).getBuildingType(),
				"Added building type should be 'Ticketing Office'.");
	}

	// 2. Search Tests

	@Test
	void testSearchAnimalByName_Found() {
		Animal found = circus.searchAnimalByName("Alpha");
		assertNotNull(found, "Should find Alpha.");
		assertEquals("Alpha", found.getName());
	}

	@Test
	void testSearchAnimalByName_NotFound() {
		Animal found = circus.searchAnimalByName("NotHere");
		assertNull(found, "Should not find 'NotHere'.");
	}

	@Test
	void testSearchAnimalByName_CaseInsensitive() {
		Animal found = circus.searchAnimalByName("alpha");
		assertNotNull(found, "Search should be case-insensitive and find 'Alpha'.");
	}

	// 3. Sort Tests

	@Test
	void testSortAnimalsByAge() {
		circus.sortAnimalsByAge();
		List<Animal> animals = circus.getAnimals(); // Expected order: [Zulu (2), Alpha (5), Beta (10)]

		assertEquals("Zulu", animals.get(0).getName(), "Animal with youngest age (2) should be first.");
		assertEquals("Alpha", animals.get(1).getName(), "Animal with middle age (5) should be second.");
		assertEquals("Beta", animals.get(2).getName(), "Animal with oldest age (10) should be third.");
	}

	@Test
	void testSortAnimalsByName() {
		circus.sortAnimalsByName();
		List<Animal> animals = circus.getAnimals(); // Expected order: [Alpha, Beta, Zulu]

		assertEquals("Alpha", animals.get(0).getName(), "Animal name 'Alpha' should be first alphabetically.");
		assertEquals("Beta", animals.get(1).getName(), "Animal name 'Beta' should be second alphabetically.");
		assertEquals("Zulu", animals.get(2).getName(), "Animal name 'Zulu' should be last alphabetically.");
	}

	// 4. Ticket Logic Tests

	// Helper function to calculate a price outside the Circus class for validation
	private double calculatePriceCheck(int dayChoice, int customerChoice, int seatChoice, double basePrice) {
		int age = 0;
		String day;

		switch (customerChoice) {
		case 1:
			age = 10;
			break; // Child
		case 2:
			age = 20;
			break; // Student
		case 3:
			age = 40;
			break; // Adult
		case 4:
			age = 70;
			break; // Senior
		}
		switch (dayChoice) {
		case 1:
			day = "MONDAY";
			break;
		case 6:
			day = "SATURDAY";
			break;
		case 7:
			day = "SUNDAY";
			break;
		default:
			day = "FRIDAY";
		}

		Ticket tempTicket = new Ticket(day, basePrice, age, seatChoice);
		return tempTicket.calculatePrice();
	}

	@Test
	void testProcessTicketSale_FullDiscount() {
		// Scenario: Child (10% off) on a Monday (10% off), Lower Level (1x), 1 ticket
		double basePrice = 20.0;

		// Expected Price Calculation: 20 - (20 * 0.10) - (20 * 0.10) = 16.00
		double expectedPrice = calculatePriceCheck(1, 1, 1, basePrice);

		// Process the sale
		circus.processTicketSale(basePrice, 1, 1, 1, 1);

		// displayTicketSummary returns the final total amount
		double finalTotal = circus.displayTicketSummary(basePrice);

		assertEquals(expectedPrice, finalTotal, 0.01, "Sale total should match $16.00.");
	}

	@Test
	void testProcessTicketSale_MultipleTicketsComplexTotal() {
		double basePrice = 50.0;

		// Sale 1: Monday (10% off), Adult (0% off), Lower Level (1x), 2 tickets
		// Price per ticket: 45.00 (Total: 90.00)
		circus.processTicketSale(basePrice, 1, 3, 1, 2);

		// Sale 2: Saturday (0% off), Child (10% off), T-Level (2x), 1 ticket
		// Price per ticket: 90.00 (Total: 90.00)
		circus.processTicketSale(basePrice, 6, 1, 2, 1);

		// Expected Total: 90.00 + 90.00 = 180.00
		double expectedTotal = 180.00;

		double finalTotal = circus.displayTicketSummary(basePrice);

		assertEquals(expectedTotal, finalTotal, 0.01,
				"The total calculated ticket amount should be $180.00 for multi-sale.");
	}
}