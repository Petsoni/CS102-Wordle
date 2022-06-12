package exceptions;

public class UserAlreadyExistsException extends RuntimeException {

	/***
	 * Constructor that takes in a message and throws the exception if the user already exists
	 * @param message
	 */
	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
