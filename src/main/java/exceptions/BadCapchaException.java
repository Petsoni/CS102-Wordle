package exceptions;

public class BadCapchaException extends RuntimeException{

	public BadCapchaException(String message) {
		super(message);
	}
}
