/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: represents the ticketing office building for the circus.
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/

public class TicketingOffice implements Building {
	// instance variables
	private String color;
	private double length;
	private double width;
	private String buildingType;

	// constructor
	public TicketingOffice(String _color, double _length, double _width) {
		this.color = _color;
		this.length = _length;
		this.width = _width;
		this.buildingType = "Ticketing Office";
	}

	@Override
	public void setSize(double _length, double _width) {
		this.length = _length;
		this.width = _width;
	}

	@Override
	public double getLength() {
		return this.length;
	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public void setColor(String _color) {
		this.color = _color;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public void setBuildingType(String _type) {
		this.buildingType = _type;
	}

	@Override
	public String getBuildingType() {
		return this.buildingType;
	}

	@Override
	public String toString() {
		return "ticketingOffice [color=" + this.getColor() + ", length=" + this.getLength() + ", width="
				+ this.getWidth() + ", buildingType=" + this.getBuildingType() + "]";
	}
}