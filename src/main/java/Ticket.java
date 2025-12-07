/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: represents a ticket for Bob's Circus.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

public class Ticket {
	private double basePrice;
	private String dayOfWeek;
	private int age;
	private int seatChoice;

	public Ticket(String _dayOfWeek, double _basePrice, int _age, int _seatChoice) {
		this.basePrice = _basePrice;
		this.age = _age;
		this.seatChoice = _seatChoice;
		this.dayOfWeek = _dayOfWeek.toLowerCase();
	}

	public double calculatePrice() {
		double price = this.basePrice;
		double totalDiscountAmount = 0.0;

		String day = this.dayOfWeek.toLowerCase();
		if (day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") || day.equals("thursday")
				|| day.equals("friday")) {
			totalDiscountAmount += (this.basePrice * 0.10);
		}

		if (this.age <= 12) {
			totalDiscountAmount += (this.basePrice * 0.10);
		} else if (this.age >= 13 && this.age <= 25) {
			totalDiscountAmount += (this.basePrice * 0.10);
		} else if (this.age >= 65) {
			totalDiscountAmount += (this.basePrice * 0.05);
		}

		price = this.basePrice - totalDiscountAmount;

		double seatMultiplier = 1.0;
		if (this.seatChoice == 2) {
			seatMultiplier = 2.0;
		} else if (this.seatChoice == 3) {
			seatMultiplier = 0.95;
		}

		price *= seatMultiplier;

		return price;
	}

	private String getSeatLocationName() {
		switch (this.seatChoice) {
		case 1:
			return "Lower level";
		case 2:
			return "T-level";
		case 3:
			return "Upper level";
		default:
			return "Unknown";
		}
	}

	public void displayTicketDetails() {
		String capitalizedDay = this.dayOfWeek.substring(0, 1).toUpperCase() + this.dayOfWeek.substring(1);
		// personally i like having my variables in my strings,
		// but wonderful eclipse kept giving me a yellow line saying it was bad
		System.out.printf("Ticket Details: [Age: %d, Day: %s, Seat: %s, Price: $%.2f]%n", this.age, capitalizedDay,
				getSeatLocationName(), calculatePrice());
	}

	@Override
	public String toString() {
		String capitalizedDay = this.dayOfWeek.substring(0, 1).toUpperCase() + this.dayOfWeek.substring(1);
		return String.format("Ticket [Day: %s, Age: %d, Seat: %s, Price: $%.2f]", capitalizedDay, this.age,
				getSeatLocationName(), calculatePrice());
	}
}