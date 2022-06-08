package utils;

import java.util.Locale;

public class LetterChecker {

	//method that compares the letters of a given word with the letters of a given word
	public static boolean checkLetters(String word, String wordToCheck) {

		//convert the word to lowercase
		word = word.toLowerCase(Locale.ENGLISH);
		wordToCheck = wordToCheck.toLowerCase(Locale.ENGLISH);

		//check if the word is the same length as the word to check
		if (word.length() != wordToCheck.length()) {
			return false;
		}

		//check if the letters of the word are the same as the letters of the word to check
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != wordToCheck.charAt(i)) {
				return false;
			}
		}

		return true;

	}

}
