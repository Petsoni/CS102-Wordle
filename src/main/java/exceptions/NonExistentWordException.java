package exceptions;

public class NonExistentWordException extends RuntimeException{

	/***
	 * Constructor that takes in a message and throws the exception if the word does not exist
	 * @param message
	 */
	public NonExistentWordException(String message) {
		super(message);
	}
}
