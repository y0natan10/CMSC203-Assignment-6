/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: represents a clerk in the circus.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

public class Clerk extends Person {
	private String job;

	public Clerk(String name, int age, int yearsWorked, String job) {
		super(name, age, yearsWorked);
		this.job = job;
	}

	@Override
	public boolean equals(Object rhs) {
		if (this == rhs)
			return true;
		if (rhs == null || getClass() != rhs.getClass())
			return false;
		Clerk other = (Clerk) rhs;
		return (this.getName() == other.getName() && this.getAge() == other.getAge()
				&& this.getYearsWorked() == other.getYearsWorked() && this.job == other.job);
	}

	@Override
	public String toString() {
		return "clerk [name=" + this.getName() + ", age=" + this.getAge() + ", yearsWorked=" + this.getYearsWorked()
				+ ", job=" + this.job + "]";
	}
}