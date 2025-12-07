/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: represents an acrobatic performer in the circus.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

public class Acrobatic extends Person {
	private String job;

	public Acrobatic(String _name, int _age, int _yearsWorked, String _job) {
		super(_name, _age, _yearsWorked);
		this.job = _job;
	}

	@Override
	public boolean equals(Object rhs) {
		if (this == rhs)
			return true;
		if (rhs == null || getClass() != rhs.getClass())
			return false;
		Acrobatic other = (Acrobatic) rhs;
		return (this.getName() == other.getName() && this.getAge() == other.getAge()
				&& this.getYearsWorked() == other.getYearsWorked() && this.job == other.job);
	}

	@Override
	public String toString() {
		return "acrobatic [name=" + this.getName() + ", age=" + this.getAge() + ", yearsWorked=" + this.getYearsWorked()
				+ ", job=" + this.job + "]";
	}
}