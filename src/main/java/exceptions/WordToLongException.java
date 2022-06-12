package exceptions;

public class WordToLongException extends RuntimeException{

	/***
	 * Constructor that takes in a message and throws the exception if the word is too long
	 * @param message
	 */
	public WordToLongException(String message) {
		super(message);
	}
}
