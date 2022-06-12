package exceptions;

public class WordAlreadyExistsException extends RuntimeException {

	/***
	 * Constructor that takes in a message and throws the exception if the word already exists
	 * @param message
	 */
	public WordAlreadyExistsException(String message) {
		super(message);
	}
}
