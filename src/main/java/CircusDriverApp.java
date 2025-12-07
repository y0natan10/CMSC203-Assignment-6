
/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: driver application for Bob's Circus Management System.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {

	public static void main(String[] args) {
		Circus circus = new Circus();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		System.out.println("Welcome to Bob's Circus Management System!");

		while (!exit) {
			try {
				System.out.println("\nMenu:");
				System.out.println("1. Add Animal");
				System.out.println("2. Add Person");
				System.out.println("3. Add Building");
				System.out.println("4. Generate Ticket");
				System.out.println("5. Display All Animals");
				System.out.println("6. Display All Persons");
				System.out.println("7. Display All Buildings");
				System.out.println("8. Sort Animals by Age");
				System.out.println("9. Sort Animals by Name");
				System.out.println("10. Search Animal by Name");
				System.out.println("11. Exit\n");

				System.out.print("Choose an option: ");

				int choice = 0;
				boolean validInput = false;

				while (!validInput) {
					try {
						choice = validateInput(scanner);
						validInput = true;
					} catch (CustomInputMismatchException e) {
						System.out.println("invalid menu choice input. please try again.");
					}
				}

				switch (choice) {
				case 1:
					handleAddAnimal(circus, scanner);
					break;
				case 2:
					handleAddPerson(circus, scanner);
					break;
				case 3:
					handleAddBuilding(circus, scanner);
					break;
				case 4:
					handleGenerateTicket(circus, scanner);
					break;
				case 5:
					System.out.println("Displaying all animals:");
					System.out.println("----------------------");
					circus.displayAnimal();
					break;
				case 6:
					System.out.println("Displaying all persons:");
					System.out.println("----------------------");
					circus.displayPerson();
					break;
				case 7:
					System.out.println("Displaying all buildings:");
					System.out.println("------------------------");
					circus.displayBuilding();
					break;
				case 8:
					System.out.println("Sorting animals by age");
					circus.sortAnimalsByAge();
					break;
				case 9:
					System.out.println("Sorting animals by name");
					circus.sortAnimalsByName();
					break;
				case 10:
					System.out.print("Enter the name of the animal to search: ");
					scanner.nextLine();
					String searchName = scanner.nextLine();
					Animal foundAnimal = circus.searchAnimalByName(searchName);
					if (foundAnimal != null) {
						System.out.println("animal found: " + foundAnimal.toString());
					} else {
						System.out.println("animal with name '" + searchName + "' not found.");
					}
					break;
				case 11:
					exit = true;
					System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
					break;
				default:
					System.out.println("invalid option. please choose again.");
				}

			} catch (Exception e) {
				System.out.println("an unexpected error occurred: " + e.getMessage());
			}
		}
		scanner.close();
	}

	private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.nextLine();
			throw new CustomInputMismatchException("expected integer input.");
		}
	}

	private static void handleAddAnimal(Circus circus, Scanner scanner) {
		try {
			System.out.println("\nselect animal type to add:");
			System.out.println("1. dog");
			System.out.println("2. bird");
			System.out.println("3. horse");
			System.out.println("4. lion");
			System.out.print("enter choice: ");
			int type = validateInput(scanner);
			scanner.nextLine();

			System.out.print("enter name: ");
			String name = scanner.nextLine();
			System.out.print("enter age: ");
			int age = validateInput(scanner);
			scanner.nextLine();
			System.out.print("enter species/breed: ");
			String species = scanner.nextLine();
			System.out.print("enter color: ");
			String color = scanner.nextLine();

			Animal newAnimal = null;
			switch (type) {
			case 1:
				newAnimal = new Dog(name, age, species, color);
				break;
			case 2:
				newAnimal = new Bird(name, age, species, color);
				break;
			case 3:
				newAnimal = new Horse(name, age, species, color);
				break;
			case 4:
				newAnimal = new Lion(name, age, species, color);
				break;
			default:
				System.out.println("invalid animal type choice.");
				return;
			}
			circus.addAnimal(newAnimal);
		} catch (CustomInputMismatchException e) {
			System.out.println("input error: please ensure age is a number.");
		} catch (Exception e) {
			System.out.println("an error occurred while adding animal: " + e.getMessage());
		}
	}

	private static void handleAddPerson(Circus circus, Scanner scanner) {
		try {
			System.out.println("\nselect person type to add:");
			System.out.println("1. clerk");
			System.out.println("2. acrobatic");
			System.out.print("enter choice: ");
			int type = validateInput(scanner);
			scanner.nextLine();

			System.out.print("enter name: ");
			String name = scanner.nextLine();
			System.out.print("enter age: ");
			int age = validateInput(scanner);
			System.out.print("enter years worked: ");
			int yearsWorked = validateInput(scanner);
			scanner.nextLine();
			System.out.print("enter job/role: ");
			String job = scanner.nextLine();

			Person newPerson = null;
			switch (type) {
			case 1:
				newPerson = new Clerk(name, age, yearsWorked, job);
				break;
			case 2:
				newPerson = new Acrobatic(name, age, yearsWorked, job);
				break;
			default:
				System.out.println("invalid person type choice.");
				return;
			}
			circus.addPerson(newPerson);
		} catch (CustomInputMismatchException e) {
			System.out.println("input error: please ensure age and years worked are numbers.");
		} catch (Exception e) {
			System.out.println("an error occurred while adding person: " + e.getMessage());
		}
	}

	private static void handleAddBuilding(Circus circus, Scanner scanner) {
		try {
			System.out.println("\nselect building type to add:");
			System.out.println("1. arena");
			System.out.println("2. ticketing office");
			System.out.print("enter choice: ");
			int type = validateInput(scanner);
			scanner.nextLine();

			System.out.print("enter color: ");
			String color = scanner.nextLine();
			System.out.print("enter length: ");
			double length = scanner.nextDouble();
			System.out.print("enter width: ");
			double width = scanner.nextDouble();
			scanner.nextLine();

			Building newBuilding = null;
			switch (type) {
			case 1:
				newBuilding = new Arena(color, length, width);
				break;
			case 2:
				newBuilding = new TicketingOffice(color, length, width);
				break;
			default:
				System.out.println("invalid building type choice.");
				return;
			}
			circus.addBuilding(newBuilding);
		} catch (InputMismatchException e) {
			System.out.println("input error: please ensure length and width are numbers.");
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("an error occurred while adding building: " + e.getMessage());
		}
	}

	private static void handleGenerateTicket(Circus circus, Scanner scanner) {
		double basePrice = 0.0;
		boolean addMoreTickets = true;

		try {
			System.out.print("\nenter ticket base price: ");
			basePrice = scanner.nextDouble();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("invalid input for base price. returning to menu.");
			scanner.nextLine();
			return;
		}

		while (addMoreTickets) {
			int dayChoice = 0;
			int customerChoice = 0;
			int seatLocation = 0;
			int numberOfTickets = 0;

			try {
				System.out.println("\nselect day of the week:");
				DayOfWeek[] days = DayOfWeek.values();
				for (int i = 0; i < days.length; i++) {
					DayOfWeek day = days[i];
					if (day.getDiscount() > 0) {
						System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
					} else {
						System.out.printf("%d. %s%n", i + 1, day);
					}
				}
				System.out.print("\nenter your choice: ");
				dayChoice = validateInput(scanner);
				scanner.nextLine();

				if (dayChoice < 1 || dayChoice > days.length) {
					System.out.println("invalid choice. please select a valid day.");
					continue;
				}

				System.out.println("\nenter customer type:");
				System.out.println("1. child (10% discount)");
				System.out.println("2. student (10% discount)");
				System.out.println("3. adult");
				System.out.println("4. senior (5% discount)");
				System.out.print("\nenter your choice: ");
				customerChoice = validateInput(scanner);
				scanner.nextLine();

				if (customerChoice < 1 || customerChoice > 4) {
					System.out.println("invalid customer type. please try again.");
					continue;
				}

				System.out.println("\nseat location in the arena:");
				System.out.println("1. lower level");
				System.out.println("2. t-level (double ticket price)");
				System.out.println("3. upper level (5% discount)");
				System.out.print("\nenter your choice: ");
				seatLocation = validateInput(scanner);
				scanner.nextLine();

				if (seatLocation < 1 || seatLocation > 3) {
					System.out.println("invalid seat location. please try again.");
					continue;
				}

				System.out.print("enter number of tickets: ");
				numberOfTickets = validateInput(scanner);
				scanner.nextLine();

				if (numberOfTickets <= 0) {
					System.out.println("must purchase at least one ticket.");
					continue;
				}

				circus.processTicketSale(basePrice, dayChoice, customerChoice, seatLocation, numberOfTickets);

			} catch (CustomInputMismatchException e) {
				System.out.println("input error: please ensure your choice and number of tickets are numbers.");
				continue;
			} catch (Exception e) {
				System.out.println("an error occurred during ticket generation: " + e.getMessage());
				continue;
			}

			System.out.print("\ndo you want to add more tickets? (y/n): ");
			String response = scanner.nextLine().trim().toLowerCase();
			addMoreTickets = response.equals("y");
		}

		circus.displayTicketSummary(basePrice);
	}
}