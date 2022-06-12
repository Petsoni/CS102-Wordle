package utils;

public class WordLengthCheck {

	/***
	 * Method that checks if the word provided is the correct length
	 * @param word
	 * @return boolean
	 */
	public static boolean checkIfWordIsTooLongOrTooShort(String word) {

		if (word.length() != 5) {
			return true;
		}
		return false;

	}
}
