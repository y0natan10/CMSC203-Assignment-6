
/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: represents a horse animal in the circus.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/
import java.util.Objects;

public class Horse implements Animal {
	private String name;
	private int age;
	private String species;
	private String color;

	public Horse(String _name, int _age, String _species, String _color) {
		this.name = _name;
		this.age = _age;
		this.species = _species;
		this.color = _color;
	}

	@Override
	public void move() {
		System.out.println(this.getName() + " trots and gallops around the ring.");
	}

	@Override
	public void makeSound() {
		System.out.println(this.getName() + " neighs loudly.");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public boolean equals(Object rhs) {
		if (this == rhs)
			return true;
		if (rhs == null || getClass() != rhs.getClass())
			return false;
		Horse other = (Horse) rhs;
		return this.getAge() == other.getAge() && Objects.equals(this.getName(), other.getName())
				&& Objects.equals(this.species, other.species) && Objects.equals(this.color, other.color);
	}

	@Override
	public String toString() {
		return "horse [name=" + this.getName() + ", age=" + this.getAge() + ", species=" + this.species + ", color="
				+ this.color + "]";
	}
}