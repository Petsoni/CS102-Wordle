package exceptions;

public class NonExistentWordException extends RuntimeException{

	public NonExistentWordException(String message) {
		super(message);
	}
}
