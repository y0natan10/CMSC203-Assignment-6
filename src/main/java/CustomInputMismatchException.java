
/*
 * Class: CMSC203 CRN20813
 * Instructor: Ahmed Tarek
 * Description: a custom exception class used to handle invalid data type input from the user (e.g., expected int, got string).
 * Due: 12/3/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 Print your Name here: Yonatan Rubin
*/
import java.util.InputMismatchException;

public class CustomInputMismatchException extends InputMismatchException {

	/**
	 * default constructor. sets a standard error message.
	 */
	public CustomInputMismatchException() {
		super("invalid input detected. please enter the correct type (e.g., a number).");
	}

	/**
	 * constructor with a specific message.
	 * 
	 * @param message the detail message for the exception.
	 */
	public CustomInputMismatchException(String message) {
		super(message);
	}
}