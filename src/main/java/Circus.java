
/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: Data manager class for Bob's Circus.
* Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/
import java.util.ArrayList;
import java.util.List;

class TicketSaleDetail {
	String customerType;
	String day;
	double finalPricePerTicket;
	double dayDiscountPercent;
	double customerDiscountPercent;
	int numTickets;

	public TicketSaleDetail(String _type, String _day, double _finalPrice, double _dayDisc, double _custDisc,
			int _count) {
		this.customerType = _type;
		this.day = _day;
		this.finalPricePerTicket = _finalPrice;
		this.dayDiscountPercent = _dayDisc;
		this.customerDiscountPercent = _custDisc;
		this.numTickets = _count;
	}

	// the format below is not what i used while writing the method
	// i cannot stress enough how awful the autoformat is in this IDE
	@Override
	public String toString() {
		String capitalizedDay = day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase();
		return numTickets + " " + customerType.toLowerCase() + " $"
				+ String.format("%.2f", (finalPricePerTicket * numTickets)) + " (Day: " + capitalizedDay
				+ ", Day Discount: " + String.format("%.0f", dayDiscountPercent * 100) + "%, Customer Type Discount: "
				+ String.format("%.0f", customerDiscountPercent * 100) + "%)";
	}
}

public class Circus {
	private List<Animal> animals;
	private List<Person> persons;
	private List<Building> buildings;
	private List<Ticket> tickets;
	private List<TicketSaleDetail> currentSaleDetails;

	public Circus() {
		animals = new ArrayList<>();
		persons = new ArrayList<>();
		buildings = new ArrayList<>();
		tickets = new ArrayList<>();
		currentSaleDetails = new ArrayList<>();
	}

	public void addBuilding(Building building) {
		if (building != null) {
			buildings.add(building);
			System.out.println(building.getBuildingType() + " added.");
		}
	}

	public void displayBuilding() {
		if (buildings.isEmpty()) {
			System.out.println("no buildings currently listed.");
			return;
		}
		System.out.println("\n--- all circus facilities ---");
		for (Building building : buildings) {
			System.out.println(building.toString());
		}
	}

	public void addPerson(Person person) {
		if (person != null) {
			persons.add(person);
			System.out.println(person.getName() + " added to staff.");
		}
	}

	public void displayPerson() {
		if (persons.isEmpty()) {
			System.out.println("no staff currently listed.");
			return;
		}
		System.out.println("\n--- all circus staff ---");
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

	public void addAnimal(Animal animal) {
		if (animal != null) {
			animals.add(animal);
			System.out.println(animal.getName() + " added to the animals.");
		}
	}

	public void displayAnimal() {
		if (animals.isEmpty()) {
			System.out.println("no animals currently listed.");
			return;
		}
		System.out.println("\n--- all circus animals ---");
		for (Animal animal : animals) {
			System.out.println(animal.toString());
		}
	}

	public void addTicket(Ticket ticket) {
		if (ticket != null) {
			tickets.add(ticket);
		}
	}

	public Ticket generateTicket(String dayOfWeek, double basePrice, int age, int seatChoice) {
		Ticket ticket = new Ticket(dayOfWeek, basePrice, age, seatChoice);
		addTicket(ticket);
		return ticket;
	}

	public void processTicketSale(double basePrice, int dayChoice, int customerChoice, int seatChoice, int numTickets) {
		int tempAge = 0;
		double dayDiscountRate = 0.0;
		double customerDiscountRate = 0.0;
		String dayName;
		String customerTypeName;

		if (dayChoice >= 1 && dayChoice <= 5) {
			dayDiscountRate = 0.10;
			String[] days = { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" };
			dayName = days[dayChoice - 1];
		} else {
			dayName = (dayChoice == 6) ? "SATURDAY" : "SUNDAY";
		}

		switch (customerChoice) {
		case 1:
			customerDiscountRate = 0.10;
			customerTypeName = "Child";
			tempAge = 10;
			break;
		case 2:
			customerDiscountRate = 0.10;
			customerTypeName = "Student";
			tempAge = 20;
			break;
		case 3:
			customerTypeName = "Adult";
			tempAge = 40;
			break;
		case 4:
			customerDiscountRate = 0.05;
			customerTypeName = "Senior";
			tempAge = 70;
			break;
		default:
			return;
		}

		Ticket tempTicket = new Ticket(dayName, basePrice, tempAge, seatChoice);
		double finalPricePerTicket = tempTicket.calculatePrice();

		TicketSaleDetail detail = new TicketSaleDetail(customerTypeName, dayName, finalPricePerTicket, dayDiscountRate,
				customerDiscountRate, numTickets);
		currentSaleDetails.add(detail);

		for (int i = 0; i < numTickets; i++) {
			tickets.add(new Ticket(dayName, basePrice, tempAge, seatChoice));
		}
	}

	public double displayTicketSummary(double basePrice) {
		double finalTotal = 0.0;
		System.out.println("\nTicket Calculation Details:");
		System.out.println("---------------------------");
		System.out.println("Regular ticket price: $" + String.format("%.2f", basePrice));

		for (TicketSaleDetail detail : currentSaleDetails) {
			System.out.println(detail.toString());
			finalTotal += (detail.finalPricePerTicket * detail.numTickets);
		}

		System.out.println("\nFinal Total Amount: $" + String.format("%.2f", finalTotal));
		System.out.println("Enjoy the show!");

		currentSaleDetails.clear();
		return finalTotal;
	}

	public void sortAnimalsByAge() {
		for (int i = 0; i < animals.size() - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < animals.size(); ++j) {
				if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
					minIndex = j;
				}
			}
			Animal temp = animals.get(minIndex);
			animals.set(minIndex, animals.get(i));
			animals.set(i, temp);
		}
		System.out.println("animals sorted by age (ascending).");
	}

	public void sortAnimalsByName() {
		for (int i = 0; i < animals.size() - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < animals.size(); ++j) {
				if (animals.get(j).getName().compareTo(animals.get(minIndex).getName()) < 0) {
					minIndex = j;
				}
			}
			Animal temp = animals.get(minIndex);
			animals.set(minIndex, animals.get(i));
			animals.set(i, temp);
		}
		System.out.println("animals sorted by name (alphabetical).");
	}

	public Animal searchAnimalByName(String name) {
		for (Animal animal : animals) {
			if (animal.getName().equalsIgnoreCase(name)) {
				return animal;
			}
		}
		return null;
	}

	// methods needed for test cases

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public List<Building> getBuildings() {
		return this.buildings;
	}

}