package exceptions;

public class WrongUsernameOrPasswordException extends RuntimeException {

	/***
	 * Constructor that takes in a message and throws the exception if the username or password is wrong
	 * @param message
	 */
	public WrongUsernameOrPasswordException(String message) {
		super(message);
	}
}
